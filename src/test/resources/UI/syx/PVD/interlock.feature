# language: zh-CN
@skip
功能:安全互锁界面
  Rule:显示功能
    @pvd-ui
    场景:标签页显示是否正确
      那么标签页显示如下:
      """
      : [
          ...
          "    Ch2",
          "    Ch3",
          "    ChC",
          "    ChE",
          "    LA",
          "    LB",
          "    ChA",
          "    ChB",
          "    TransferChamber",
          "    BufferChamber",
          "    ATR",
          "    LP1",
          "    LP2",
          "    LP3",
          "    VTR1",
          "    VTR2",
          "    FFU",
          "    Platform",
          "    System"
        ]
      """

    @pvd-ui
    场景:获取Ch2全部的设置型互锁
      当获取"Ch2"的"设置型互锁"时
      那么返回结果如下:
      """
      : [
          {
              互锁名称:  "/Control/Ch2/SInterlocks/ChuckMoveRestriction",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/Online",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC01",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC02",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC03",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC04",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC07",
          },
          { 
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC09",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC10",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC11",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC12",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC15",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenC25",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenChillerLidWaterVlv",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0501",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0503",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0504",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0601",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0603",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0604",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0701",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0703",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0704",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0801",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0803",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenG0804",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP01",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP02",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP03",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP04",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP21",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP22",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP23",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenP24",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/OpenRPSPedWaterVlv",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/PedHeaterOn",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/PedHome",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/PedMove",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/RFOn",
          },
          {
              互锁名称:  "/Control/Ch2/SInterlocks/TurbopumpStart",
          }
      ]
      """

    @pvd-ui
    场景:获取Ch2全部的监控型互锁
      当获取"Ch2"的"监控型互锁"时
      那么返回结果如下:
      """
      :[
        {
          互锁名称:  "/Control/Ch2/VInterlocks/CDAPressureHigh",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/CDAPressureLow",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ChamberATM",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ChamberLidOpenAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ChamberOverTemp",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ChamberPressureHigh",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ChillerWaterFlowLow",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/CycWaferCounter",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnFGAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC05Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC06Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC07Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC08Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC21Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC22Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnMFC23Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnPC01Alarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnPlcAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DnTCAlarm",
        },
        { 
          互锁名称:  "/Control/Ch2/VInterlocks/DnTVAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DryPump",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DryPumpAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/DryPumpAlert",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ForeLineNotVac",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/GasBoxDiffPressureAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/GasBoxDoorOpenAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/GasBoxLeakAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/H2DetectorFault",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/H2Leak",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/LeakAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/LidDiffPressureAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/MatchSafetyAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/MotorSrvOff",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PMCounterAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PMCounterWarning",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PS07PressureHigh",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT05HighAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT05LowAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT06HighAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT06LowAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT07HighAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT07LowAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT21ArPressureHigh",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT21ArPressureLow",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT31N2PressureHigh",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT31N2PressureLow",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT32PressureHigh",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PT32PressureLow",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PedMotorError",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PedOriginPoint",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PedOverTemp",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PedWaterFlowLow",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PlcError",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeComErr",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeFBError",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeOutErr",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/RFCoverOpenAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/ScrubberAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/SmokeAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/SmokeDetectorFault",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/TpAlarm",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/TpGateValveOpen",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/TpIsoVlvClosed",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/TpOverTemp",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/TpPurgeVlvOpen",
        },
        {
          互锁名称:  "/Control/Ch2/VInterlocks/WaferCounter",
        }
      ]
      """

    @pvd-ui
    场景: 设置型安全互锁详细信息可以显示
      当查看"Ch2"的"设置型互锁""/Control/Ch2/SInterlocks/OpenC04"的详细信息时
      那么设置型互锁名称为:
      """
      ="/Control/Ch2/SInterlocks/OpenC04"
      """
      那么设置型防护对象为:
      """
      ="/IO/Ch2/Plc/C04DO"
      """
      那么设置型触发条件为:
      """
      ="(/IO/Ch2/Plc/C04DO == Open)"
      """
      那么设置型检测条件为:
      """
      =[
        "(/IO/Ch2/Plc/Safe/LidClosedDI == Closed)",
        "(/IO/Ch2/Plc/TpGateVlvOpenDI == NotOpen)",
        "(/IO/Ch2/Plc/TpGateVlvClosedDI == Closed)",
        "(/IO/Ch2/Plc/CDALowDI == Normal)",
        "(/IO/Ch2/Plc/CDAHighDI == Normal)",
        "(/IO/Ch2/Plc/PedInSafeTempDI == Normal)"
        ]
      """
      那么设置型报警为:
      """
      ="None"
      """

    @pvd-ui
    场景: 监控型安全互锁详细信息可以显示
      当查看"Ch2"的"监控型互锁""/Control/Ch2/VInterlocks/ChamberOverTemp"的详细信息时
      那么监控型互锁名称为:
      """
      ="/Control/Ch2/VInterlocks/ChamberOverTemp"
      """
      那么监控型触发条件为:
      """
      ="((/IO/Ch2/Plc/Safe/ChamberOverTempDI == Abnormal) && (timer 500))"
      """
      那么监控型动作为:
      """
      =[
           "/IO/Ch2/Plc/RFOnOffDO <- Off",
           "/IO/Ch2/Plc/PedHeaterEnDO <- Disable",
           "/IO/Ch2/EzZoneTc/Zone17AO <- 0",
           "/IO/Ch2/Plc/LidFLGaugeHeaterEnDO <- Disable",
           "/IO/Ch2/Plc/G0701DO <- Close"
       ]
      """
      那么监控型报警为:
      """
      ="/Control/Ch2/VInterlocks/ChamberOverTemp/Alarm"
      """

    @pvd-lower
    场景:下位机屏蔽互锁后上位机能否正确显示
      假如屏蔽下位机互锁
        | name                                          |
        | /Control/Ch2/SInterlocks/ChuckMoveRestriction |
      当用户"pe"使用密码"8888"启动上位机
      那么"Ch2"的"设置型互锁"结果如下:
      """
      : [
          {
            互锁名称:"/Control/Ch2/SInterlocks/ChuckMoveRestriction",
            状态:"　屏蔽　"
          }
          ...
        ]
      """

  Rule:检验激活互锁后是否生效
    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:检验激活设置型互锁后时候生效
      假如激活"Ch2"的"设置型互锁":
        | name                                        |
        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
      当修改通道值:
        | name                             | value  |
        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
      那么报警信息返回如下:
      """
      : [
          "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn/Over400T"
          ...
        ]
      """

    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:检验激活监控型互锁后时候生效
      假如激活"Ch2"的"监控型互锁":
        | name                                |
        | /Control/Ch2/VInterlocks/ChamberATM |
      当修改通道值:
        | name                     | value |
        | /IO/Ch2/Plc/Safe/AtmSWDI | Atm   |
      那么等待1秒后报警信息返回如下:
      """
      : [
          "/Control/Ch2/VInterlocks/ChamberATM/Alarm"
          ...
        ]
      """

  Rule:检验屏蔽互锁后没有报警抛出
    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:检验屏蔽设置型互锁后修改通道没有报警抛出
      假如屏蔽"Ch2"的"设置型互锁":
        | name                                        |
        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
      当修改通道值:
        | name                             | value  |
        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
      那么不会抛出报警:
      """
      : [
          "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn/Over400T"
        ]
      """

    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:检验屏蔽监控型互锁后时候生效
      假如屏蔽"Ch2"的"监控型互锁":
        | name                                |
        | /Control/Ch2/VInterlocks/ChamberATM |
      当修改通道值:
        | name                     | value |
        | /IO/Ch2/Plc/Safe/AtmSWDI | Atm   |
      那么不会抛出报警:
      """
      : [
          "/Control/Ch2/VInterlocks/ChamberATM/Alarm"
          ...
        ]
      """

  Rule:激活按钮功能
    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:激活所有设置型互锁,界面状态更改
      当激活所有"Ch2""设置型互锁"
      那么返回结果如下:
      """
      = [
    {
        互锁名称:  "/Control/Ch2/SInterlocks/ChuckMoveRestriction",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/Online",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC01",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC02",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC03",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC04",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC07",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC09",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC10",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC11",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC12",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC15",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC25",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenChillerLidWaterVlv",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0501",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0503",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0504",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0601",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0603",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0604",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0701",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0703",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0704",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0801",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0803",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0804",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP01",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP02",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP03",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP04",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP21",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP22",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP23",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP24",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenRPSPedWaterVlv",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/PedHeaterOn",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/PedHome",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/PedMove",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/RFOn",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/TurbopumpStart",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    }
]
      """

    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:激活所有监控型互锁,界面状态更改
      当激活所有"Ch2""监控型互锁"
      那么返回结果如下:
      """
      = [
    {
        互锁名称:  "/Control/Ch2/VInterlocks/CDAPressureHigh",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/CDAPressureLow",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberATM",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberLidOpenAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberOverTemp",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberPressureHigh",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChillerWaterFlowLow",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/CycWaferCounter",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnFGAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC05Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC06Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC07Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC08Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC21Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC22Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC23Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnPC01Alarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnPlcAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnTCAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnTVAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DryPump",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DryPumpAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DryPumpAlert",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ForeLineNotVac",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/GasBoxDiffPressureAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/GasBoxDoorOpenAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/GasBoxLeakAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/H2DetectorFault",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/H2Leak",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/LeakAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/LidDiffPressureAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/MatchSafetyAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/MotorSrvOff",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PMCounterAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PMCounterWarning",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PS07PressureHigh",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT05HighAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT05LowAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT06HighAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT06LowAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT07HighAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT07LowAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT21ArPressureHigh",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT21ArPressureLow",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT31N2PressureHigh",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT31N2PressureLow",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT32PressureHigh",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT32PressureLow",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedMotorError",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedOriginPoint",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedOverTemp",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedWaterFlowLow",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcError",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeComErr",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeFBError",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeOutErr",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/RFCoverOpenAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ScrubberAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/SmokeAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/SmokeDetectorFault",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpAlarm",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpGateValveOpen",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpIsoVlvClosed",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpOverTemp",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpPurgeVlvOpen",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/WaferCounter",
        操作:  "　屏蔽　",
        状态:  "　激活　"
    }
]
      """

  Rule:屏蔽按钮功能
    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:屏蔽所有设置型互锁,界面状态更改
      当屏蔽所有"Ch2""设置型互锁"
      那么返回结果如下:
      """
      = [
    {
        互锁名称:  "/Control/Ch2/SInterlocks/ChuckMoveRestriction",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/Online",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC01",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC02",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC03",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC04",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC07",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC09",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC10",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC11",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC12",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC15",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenC25",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenChillerLidWaterVlv",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0501",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0503",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0504",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0601",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0603",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0604",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0701",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0703",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0704",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0801",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0803",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenG0804",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP01",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP02",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP03",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP04",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP21",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP22",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP23",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenP24",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/OpenRPSPedWaterVlv",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/PedHeaterOn",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/PedHome",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/PedMove",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/RFOn",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/SInterlocks/TurbopumpStart",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    }
]
      """

    @pvd-lower
    @clean-alarm
    @pvd-ui
    场景:屏蔽所有监控型互锁,界面状态更改
      当屏蔽所有"Ch2""监控型互锁"
      那么返回结果如下:
      """
      = [
    {
        互锁名称:  "/Control/Ch2/VInterlocks/CDAPressureHigh",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/CDAPressureLow",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberATM",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberLidOpenAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberOverTemp",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChamberPressureHigh",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ChillerWaterFlowLow",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/CycWaferCounter",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnFGAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC05Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC06Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC07Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC08Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC21Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC22Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnMFC23Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnPC01Alarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnPlcAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnTCAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DnTVAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DryPump",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DryPumpAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/DryPumpAlert",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ForeLineNotVac",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/GasBoxDiffPressureAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/GasBoxDoorOpenAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/GasBoxLeakAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/H2DetectorFault",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/H2Leak",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/LeakAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/LidDiffPressureAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/MatchSafetyAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/MotorSrvOff",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PMCounterAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PMCounterWarning",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PS07PressureHigh",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT05HighAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT05LowAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT06HighAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT06LowAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT07HighAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT07LowAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT21ArPressureHigh",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT21ArPressureLow",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT31N2PressureHigh",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT31N2PressureLow",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT32PressureHigh",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PT32PressureLow",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedMotorError",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedOriginPoint",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedOverTemp",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PedWaterFlowLow",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcError",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeComErr",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeFBError",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/PlcSafeOutErr",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/RFCoverOpenAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/ScrubberAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/SmokeAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/SmokeDetectorFault",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpAlarm",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpGateValveOpen",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpIsoVlvClosed",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpOverTemp",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/TpPurgeVlvOpen",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    },
    {
        互锁名称:  "/Control/Ch2/VInterlocks/WaferCounter",
        操作:  "　激活　",
        状态:  "　屏蔽　"
    }
]
      """

