# language: zh-CN
@etch1ref-lower
@clean-alarm
功能: InterLockTM

  Rule: getInterlockInfo

    场景: 获取指定的Interlock的信息
      假如激活互锁"/Control/OverrunInterlocks/TMAbnormal"
      当调用"interlock"的"getInterlockInfo"接口时:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      那么调用成功
      并且返回如下:
      """
      :{
        actions: [],
        type: OVERRUN,
        id: '/Control/OverrunInterlocks/TMAbnormal',
        trigger: '((/IO/SlaveNode/LID_CLSD_ISO_TC == 0) && (timer 200))'
        alarm: 'VInterlock_TMAbnormal_TCLIDNotClosed'
        isActive: true
        }
      """

    场景: 获取不存在的Interlock的信息
      当调用"interlock"的"getInterlockInfo"接口时:
        | id        |
        | not_exist |
      那么调用成功
      并且返回如下:
      """
      null
      """

  Rule: getAllInterlockInfos

    场景: 获取所有的Interlock信息
      当调用"interlock"的"getAllInterlockInfos"接口时
      那么调用成功
      并且返回如下:
      """
      : [...]
      """

  Rule: isActive

    场景: 激活指定interlock后判断Interlock处于激活状态
      假如激活互锁:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      当调用"interlock"的"isActive"接口时:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      那么调用成功
      并且返回如下:
      """
      = true
      """

    场景: 取消激活指定interlock后判断Interlock处于非激活状态
      假如取消激活互锁:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      当调用"interlock"的"isActive"接口时:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      那么调用成功
      并且返回如下:
      """
      = false
      """

    场景: 判断不存在的Interlock是否处于激活状态
      当调用"interlock"的"isActive"接口时:
        | id        |
        | not_exist |
      那么调用成功
      并且返回如下:
      """
      = false
      """


  Rule: activate

    场景: 激活指定的Interlock
      假如激活互锁:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      当调用"IO"的"setValue"接口时:
        | name                          | value      |
        | /IO/SlaveNode/LID_CLSD_ISO_TC | Not_Closed |
      那么抛出报警:
      """
      :[
        ...
        'VInterlock_TMAbnormal_TCLIDNotClosed'
        ...
        ]
      """


    场景: 激活不存在的Interlock
      当调用"interlock"的"activate"接口时:
        | id        |
        | not_exist |
      那么调用失败

  Rule: deactivate

    场景: 取消激活指定的V型Interlock
      假如取消激活互锁:
        | id                                    |
        | /Control/OverrunInterlocks/TMAbnormal |
      当调用"IO"的"setValue"接口时:
        | name                          | value      |
        | /IO/SlaveNode/LID_CLSD_ISO_TC | Not_Closed |
      那么不会抛出报警:
      """
      :[
        ...
        'VInterlock_TMAbnormal_TCLIDNotClosed'
        ...
        ]
      """

    场景: 取消激活不存在的Interlock
      当调用"interlock"的"deactivate"接口时:
        | id        |
        | not_exist |
      那么调用失败