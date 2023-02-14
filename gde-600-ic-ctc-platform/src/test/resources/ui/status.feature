# language: zh-CN
@etch1ref-lower
@etch1-ui
@reset-feature-ui
#@skip
功能: status

  场景: 触发某一报警出现在界面
    当激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
    并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
    那么界面出现报警项目"VInterlock_TMAbnormal_TCLIDNotClosed"

  场景: 同时触发多个报警
    当激活并触发互锁"/Control/OverrunInterlocks/Scrubber1Failed"
    并且产生了报警"VInterlock_Scrubber1Failed_Scrubber1Failed"
    并且激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
    并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
    那么界面出现报警项目"VInterlock_Scrubber1Failed_Scrubber1Failed"
    并且界面出现报警项目"VInterlock_TMAbnormal_TCLIDNotClosed"

  场景:触发报警，检验报警信息
    当激活并触发互锁"/Control/OverrunInterlocks/Scrubber1Failed"
    并且产生了报警"VInterlock_Scrubber1Failed_Scrubber1Failed"
    那么报警"VInterlock_TMAbnormal_TCLIDNotClosed"的信息描述部分如下:
    """
    "Alarm Name: VInterlock_Scrubber1Failed_Scrubber1Failed"
    """

  场景: 清除某一报警
    假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
    并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
    当消除互锁"/Control/OverrunInterlocks/TMAbnormal"的触发条件
    并且清除界面上"VInterlock_TMAbnormal_TCLIDNotClosed"的报警项目
    那么界面上没有报警项目"VInterlock_TMAbnormal_TCLIDNotClosed"

  场景: 未修复问题，清除报警无效
    假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
    并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
    当清除界面上"VInterlock_TMAbnormal_TCLIDNotClosed"的报警项目
    那么界面出现报警项目"VInterlock_TMAbnormal_TCLIDNotClosed"
