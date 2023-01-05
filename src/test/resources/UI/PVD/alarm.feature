# language: zh-CN
@deactivate-allInterlock
@clean-alarm
@skip
功能:报警界面
  Rule:显示功能
    @pvd-lower
    @clean-structure-alarm
    场景:下位机有报警，启动上位机验证显示是否正确
      假如激活下位机互锁:
        | name                                        |
        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
      并且修改通道值:
        | name                             | value  |
        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
      当用户"pe"使用密码"8888"启动上位机
      那么报警列表信息如下:
      """
      :
      [
        [
            [
               "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn/Over400T",
               is AlmostNow,
               "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn",
               "Ch2 chamber pressure is over 490T.",
               "ERROR",
               2386
             ]
        ]
        ...
      ]
      """

#    @pvd-lower
#    @clean-structure-alarm
#    场景:下位机有报警，启动上位机验证报警操作是否正确
#      假如激活下位机互锁:
#        | name                                        |
#        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
#      并且修改通道值:
#        | name                             | value  |
#        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
#        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
#      当用户"pe"使用密码"8888"启动上位机
#      那么"/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn"报警操作信息如下:
#      """
#      = [Retry,Abort]
#      """
#
#    @pvd-lower
#    @clean-structure-alarm
#    场景:验证报警详细信息
#      当用户"pe"使用密码"8888"启动上位机
#      那么"/Control/TimeSynchronizer"报警详细信息如下:
#      """
#      = [
#          "Synchronize system time failed!",
#          "Execute 'sudo net time set -I 192.168.0.9' failed, error code is '65280'."
#        ]
#      """
#
#    @pvd-lower
#    @clean-structure-alarm
#    场景:验证界面刷新功能
#      假如用户"pe"使用密码"8888"启动上位机
#      并且切换到当前报警界面
#      当激活下位机互锁:
#        | name                                        |
#        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
#      并且修改通道值:
#        | name                             | value  |
#        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
#        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
#      那么报警列表信息如下:
#      """
#      :
#      [
#        ...
#        [
#            [
#               "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn/Over400T",
#               is AlmostNow,
#               "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn",
#               "Ch2 chamber pressure is over 490T.",
#               "ERROR",
#               2386
#             ]
#        ]
#      ]
#      """
#
#  Rule: 按钮功能
#    @pvd-lower
#    场景: 验证clear的执行是否有效
#      假如用户"pe"使用密码"8888"启动上位机
#      当执行"/Control/TimeSynchronizer"的"Clear"选项
#      那么报警列表信息如下:
#      """
#      =[]
#      """
#
#    @pvd-lower
#    @clean-structure-alarm
#    场景: 验证Retry的执行是否有效
#      假如激活下位机互锁:
#        | name                                        |
#        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
#      并且修改通道值:
#        | name                             | value  |
#        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
#        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
#      当用户"pe"使用密码"8888"启动上位机
#      并且执行"/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn"的"Retry"选项
#      那么报警列表信息如下:
#      """
#      :
#      [
#      ...
#        [
#            [
#               "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn/Over400T",
#               is AlmostNow,
#               "/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn",
#               "Ch2 chamber pressure is over 490T.",
#               "ERROR",
#               2386
#             ]
#        ]
#      ]
#      """
#
#    @pvd-lower
#    @clean-structure-alarm
#    场景: 验证Abort的执行是否有效
#      假如激活下位机互锁:
#        | name                                        |
#        | /Control/Ch2/SInterlocks/LidFLGaugeHeaterOn |
#      并且修改通道值:
#        | name                             | value  |
#        | /IO/Ch2/Plc/Safe/AtmSWDI         | NotAtm |
#        | /IO/Ch2/Plc/LidFLGaugeHeaterEnDO | Enable |
#      当用户"pe"使用密码"8888"启动上位机
#      并且执行"/Control/Ch2/SInterlocks/LidFLGaugeHeaterOn"的"Abort"选项
#      那么报警列表信息如下:
#      """
#      :
#      [
#      ...
#        [
#            [
#                "/Control/TimeSynchronizer/SyncTime",
#                is AlmostNow,
#                "/Control/TimeSynchronizer",
#                "Synchronize system time failed!",
#                "NOTICE",
#                6184
#             ]
#        ]
#      ]
#      """












