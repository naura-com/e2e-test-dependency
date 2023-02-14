# language: zh-CN
@skip
功能: 设备控制例子

  @pvd-lower
  场景: 下位机开启阀门
    假如设备"/Control/Ch1Exports/V21"为"Close"状态
    当改变设备"/Control/Ch1Exports/V21"为"Open"
    那么IO状态为:
    """
    remoteData: {
      '/IO/Ch1Exports/Solenoid_V21DI'.value.descriptor: Open
    }
    """

  @pvd-lower
  场景: Given阀门状态
    假如dnscan设备"/dev/SSTDN3PCU2_0000A"状态如下:
      | mac | channel    | data |
      | 8   | DEVIO_OUT1 | FFFF |
    那么IO状态为:
    """
    remoteData: {
      '/IO/Ch1Exports/Solenoid_V21DI'.value.descriptor: Open
    }
    """

  @pvd-lower
  场景: 读阀门状态
    假如dnscan设备"/dev/SSTDN3PCU2_0000A"状态如下:
      | mac | channel   | data |
      | 8   | DEVIO_IN1 | FFFF |
    当改变设备"/Control/Ch1Exports/V21"为"Close"
    那么dnscan设备"/dev/SSTDN3PCU2_0000A"状态应为:
      | mac | channel   | data |
      | 8   | DEVIO_IN1 | 00D8 |

  @pvd-lower
  @pvd-ui
  场景: 上位机开启阀门
    假如设备"/Control/Ch2Exports/V2"为"Close"状态
    当打开工艺腔室"V2"阀门
    那么工艺腔室"V2"阀门被打开

  @pvd-lower
  @pvd-ui
  场景: 氮气流量控制
    假如设备"/Control/Ch1Exports/V21"为"Close"状态
    假如设备"/Control/Ch1Exports/V2"为"Close"状态
    当设置MFC"Ar1MFC"的流量为"100"
    那么工艺腔室"V21"阀门被打开
    那么工艺腔室"V2"阀门被打开
    那么MFC"Ar1MFC"流量为"100.000"

#  TODO should mock callback !!!
#  @pvd-ui-mock
#  场景: 上位机开启阀门-打桩
#    假如设备"/Control/Ch1Exports/V21"为"Close"状态
#    当打开工艺腔室"V21"阀门
#    那么控制对象"/Control/Ch1Exports/V21"接受到命令"Open"
#
#  @pvd-ui-mock
#  场景: UI查看阀门状态-打桩
#    假如设备"/Control/Ch1Exports/V21"为"Open"状态
#    那么工艺腔室"V21"阀门被打开
