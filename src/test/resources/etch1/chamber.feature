# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
@clean-alarm
#@skip
功能: Chamber

  Rule: Method

    @etch1-init
    场景: 正常Initialize验证
      当执行"Initialize"方法
      那么"Initialize"操作成功,Module Status状态显示正确:
      """
      = "Standby"
      """

    场景: 正常Maintain验证
      当执行"Maintain"方法
      那么"Initialize"操作成功,Module Status状态显示正确:
      """
      = "MaintMode"
      """

    场景: 初始化过程中点击Abort
      假如执行"Initialize"方法
      当执行"Abort"方法
      那么"Abort"操作成功,Run Service状态显示正确:
      """
      = "Aborted"
      """

  Rule: Source RF Center

    场景: 检查C1数值显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/SRFCenterMatch/ReadC1"为"56"
      那么设置成功,Source RF Center的"C1"显示为:
      """
      = "56"
      """

    场景: 检查C2数值显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/SRFCenterMatch/ReadC2"为"56"
      那么设置成功,Source RF Center的"C2"显示为:
      """
      = "56"
      """

    场景: 检查Reflected数值显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/PCI9116/SRFCenterReflectPWRAI"为"5"
      那么设置成功,Source RF Center的"Reflected(W)"显示为:
      """
      = "5"
      """

      #TODO 设置通道值后显示有误差
#    场景: 检查Forward数值显示
#      假如"PM2 GDE"处于"Maintain"模式
#      当设置通道"IO/PCI9116/SRFCenterFWDLPWRAI"为"5.0"
#      那么设置成功,Source RF Center的"Forward(W)"显示为:
#      """
#      = "5.0"
#      """

    场景: 设置Operate Mode后检查日志
      假如"PM2 GDE"处于"Maintain"模式
      当设置SourceRF的Operate Mode为"Auto"
      并且在服务窗口执行"Run"
      那么日志打印内容"Run Service RF_SetAuto, set the value:Auto"
      当设置SourceRF的Operate Mode为"Manual"
      并且在服务窗口执行"Run"
      那么日志打印内容"Run Service RF_SetAuto, set the value:Manual"

    场景: 设置Run Mode后检查日志
      假如"PM2 GDE"处于"Maintain"模式
      当设置SourceRF的Run Mode为"Local"
      并且在服务窗口执行"Run"
      那么日志打印内容"Run Service RF_SetRemote, set the value:Local"
      当设置SourceRF的Run Mode为"Remote"
      并且在服务窗口执行"Run"
      那么日志打印内容"Run Service RF_SetRemote, set the value:Remote"

    场景: SRFCenter SetPower
      假如"PM2 GDE"处于"MaintMode"模式
      当设置SRF Center的Forward值为44
      那么SRF Center的Forward值变为44

    场景: SRFCenter Match InitC1C2
      假如"PM2 GDE"处于"MaintMode"模式
      当在SRF Center Match中初始化C1C2
      那么SRF Center C1C2被初始化为750

    场景: SRFCenter Match SetC1
      假如"PM2 GDE"处于"MaintMode"模式
      当在SRF Center Match中设置C1值为44
      那么SRF Certer C1值变为44

    场景: SRFCenter Match SetC2
      假如"PM2 GDE"处于"MaintMode"模式
      当在SRF Center Match中设置C2值为44
      那么SRF Certer C2值变为44

    场景: SRF 检查日志
      假如"PM2 GDE"处于"MaintMode"模式
      当设置SRF Edge 的SetMode为Forward
      那么日志打印内容"Run Service RF_SetMode, set the value:0"
      当设置SRF Edge 的SetMode为Load
      那么日志打印内容"Run Service RF_SetMode, set the value:1"
      当SRF Edge 执行一次RF On
      那么日志打印内容"Run ServiceRF_On"
      当SRF Edge 执行一次RF Off
      那么日志打印内容"Run ServiceRF_Off"

  Rule: PM2 GDE模块

    场景: 检查腔室压力显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/PendulumValve/PressureRCh"为"1.23"
      那么设置成功,PM2 GDE的"Pre(mTorr)"显示为:
      """
      = "1.23"
      """

  Rule: Set Temperature

    场景: 温度设置小于阈值
      假如"PM2 GDE"处于"Maintain"模式
      当设置"Top"温度为"-30"
      那么设置失败,弹出提示信息:
      """
      The Number you input is overload, please input again!
      """
      当设置"Middle"温度为"-1"
      那么设置失败,弹出提示信息:
      """
      The Number you input is overload, please input again!
      """
      当设置"Rear"温度为"-1"
      那么设置失败,弹出提示信息:
      """
      The Number you input is overload, please input again!
      """

    场景: 温度设置大于阈值
      假如"PM2 GDE"处于"Maintain"模式
      当设置"Top"温度为"91"
      那么设置失败,弹出提示信息:
      """
      The Number you input is overload, please input again!
      """
      当设置"Middle"温度为"140.1"
      那么设置失败,弹出提示信息:
      """
      The Number you input is overload, please input again!
      """
      当设置"Rear"温度为"140.1"
      那么设置失败,弹出提示信息:
      """
      The Number you input is overload, please input again!
      """

    场景: Middle温度设置在阈值范围内
      假如"PM2 GDE"处于"Maintain"模式
      当设置"Middle"温度为"10"并确认
      那么设置成功,"PM2 GDE"的"Middle(°C)"显示为:
      """
      = "10.0"
      """

    场景: Top温度设置在阈值范围内
      假如"PM2 GDE"处于"Maintain"模式
      当设置"Top"温度为"10"并确认
      那么设置成功,"PM2 GDE"的"Top(°C)"显示为:
      """
      = "10.0"
      """

    场景: Rear温度设置在阈值范围内
      假如"PM2 GDE"处于"Maintain"模式
      当设置"Rear"温度为"10"并确认
      那么设置成功,"PM2 GDE"的"Rear(°C)"显示为:
      """
      = "10.0"
      """

  Rule: ESC

    场景: chiller温度设置上溢场景
      假如"PM2 GDE"处于"MaintMode"模式
      当设置chiller温度为100度并确认
      那么设置chiller失败，提示信息为:
      """
      The Number you input is overload, please input again!
      """

    场景: chiller温度设置下溢场景
      假如"PM2 GDE"处于"MaintMode"模式
      当设置chiller温度为-30度并确认
      那么设置chiller失败，提示信息为:
      """
      The Number you input is overload, please input again!
      """

    场景: chiller温度设置正常场景
      假如"PM2 GDE"处于"MainMode"模式
      当设置chiller温度为25度并确认
      并且在Chamber chiller执行Run动作
      那么chiller温度被设置为25度

    场景: PinUp
      假如"PM2 GDE"处于"MaintMode"模式
      当设置chiller执行Pinup操作
      那么Pin针在动画中变为升起状态

    场景: PinDown
      假如"PM2 GDE"处于"MaintMode"模式
      当设置chiller执行Pindown操作
      那么Pin针在动画中消失

    场景: RingUp
      假如"PM2 GDE"处于"MaintMode"模式
      当设置chiller执行RinUp操作
      那么Ring状态变为"Up"

    场景: RingDown
      假如"PM2 GDE"处于"MaintMode"模式
      当设置chiller执行RinDown操作
      那么Ring状态变为"Down"

    场景: ESC设置DC值
      假如"PM2 GDE"处于"MaintMode"模式
      当设置ESC模块的DC值为44
      那么ESC模块的DC值变为44

  Rule: Set Gas Flow

    场景大纲: 单个气体流量设置_流量为空:<title>
      当点击"Set Gas Flow"
      并且设置气体流量值如下
        | <gasName> |
        |           |
      那么执行失败,异常提示为:
      """
      ="<message>"
      """
      例子:
        | title | gasName | message               |
        | Ar    | Ar      | Error value in 1 row! |
        | O2    | O2      | Error value in 2 row! |
        | He    | He      | Error value in 3 row! |
        | N2    | N2      | Error value in 4 row! |
        | SF6   | SF6     | Error value in 5 row! |
        | CF4   | CF4     | Error value in 6 row! |
        | Cl2   | Cl2     | Error value in 7 row! |
        | Bcl3  | Bcl3    | Error value in 8 row! |

    场景: 不选择气体直接点击run
      假如"PM2 GDE"处于"Maintain"模式
      当点击"Set Gas Flow"
      并且在GasSetFlow窗口执行"Run"
      那么执行失败,异常提示为:
      """
      = "Please select a gas!"
      """

    场景: 多个气体流量设置_流量为空
      假如"PM2 GDE"处于"Maintain"模式
      当点击"Set Gas Flow"
      并且设置气体流量值如下
        | Ar | SF6 |
        |    |     |
      那么执行失败,异常提示为:
      """
      = "Error value in 1 row!"
      """

    场景大纲: 单个气体流量设置_大于阈值:<title>
      当点击"Set Gas Flow"
      并且设置气体流量值如下
        | <gasName> |
        | <value>   |
      那么执行失败,异常提示为:
      """
      = "Input is invalid! Please input again!"
      """
      例子:
        | title | gasName | value |
        | Ar    | Ar      | 200.1 |
        | O2    | O2      | 200.1 |
        | He    | He      | 200.1 |
        | N2    | N2      | 200.1 |
        | SF6   | SF6     | 200.1 |
        | CF4   | CF4     | 200.1 |
        | Cl2   | Cl2     | 200.1 |
        | Bcl3  | Bcl3    | 200.1 |

    场景大纲: 单个气体流量设置_小于阈值:<title>
      当点击"Set Gas Flow"
      并且设置气体流量值如下
        | <gasName> |
        | <value>   |
      那么执行失败,异常提示为:
      """
      = "Input is invalid! Please input again!"
      """
      例子:
        | title | gasName | value |
        | Ar    | Ar      | -1    |
        | O2    | O2      | -1    |
        | He    | He      | -1    |
        | N2    | N2      | -1    |
        | SF6   | SF6     | -1    |
        | CF4   | CF4     | -1    |
        | Cl2   | Cl2     | -1    |
        | Bcl3  | Bcl3    | -1    |

    场景: 单个气体流量设置_阈值内
      当点击"Set Gas Flow"
      并且设置气体流量值如下:
        | Ar  |
        | 1.0 |
      那么执行成功,"Ar"的Set Point显示正确:
      """
      = "1.0"
      """
      当点击"Set Gas Flow"
      并且设置气体流量值如下:
        | O2  |
        | 1.0 |
      那么执行成功,"O2"的Set Point显示正确:
      """
      = "1.0"
      """
      当点击"Set Gas Flow"
      并且设置气体流量值如下:
        | He  |
        | 1.0 |
      那么执行成功,"He"的Set Point显示正确:
      """
      = "1.0"
      """

    场景: 单个气体流量设置为最大值
      当点击"Set Gas Flow"
      并且设置如下气体流量值执行"Set max value"
        | Ar |
      那么执行成功,"Ar"的Set Point显示正确:
      """
      = "200.0"
      """

    场景: 单个气体流量设置为最小值
      当点击"Set Gas Flow"
      并且设置如下气体流量值执行"Set 0 value"
        | Ar |
      那么执行成功,"Ar"的Set Point显示正确:
      """
      = "0.0"
      """

    场景: 所有气体流量设置为最大值
      当点击"Set Gas Flow"
      并且所有气体流量值执行"Set max value"
      那么执行成功,Set Point显示正确:
      """
      = {
      Ar: "200.0"
      O2: "200.0"
      He: "200.0"
      N2: "200.0"
      SF6: "200.0"
      CF4: "200.0"
      Cl2: "200.0"
      Bcl3: "200.0"
      }
      """

    场景: 所有气体流量设置为最小值
      当点击"Set Gas Flow"
      并且所有气体流量值执行"Set 0 value"
      那么执行成功,Set Point显示正确:
      """
      = {
      Ar: "0.0"
      O2: "0.0"
      He: "0.0"
      N2: "0.0"
      SF6: "0.0"
      CF4: "0.0"
      Cl2: "0.0"
      Bcl3: "0.0"
      }
      """

    场景: 多个气体流量设置_阈值内
      当点击"Set Gas Flow"
      并且设置气体流量值如下:
        | Ar  | O2  |
        | 1.0 | 2.0 |
      那么执行成功,Set Point显示正确:
      """
      : {
      Ar: "1.0"
      O2: "2.0"
      }
      """

  Rule: Set He Pressure

    场景: 设置He压力值超出阈值
      假如"PM2 GDE"处于"Maintain"模式
      当设置He压力为"100"并确定时
      那么设置He压力失败并提示
      """
      = "The Number you input is overload, please input again!"
      """
      当设置He压力为"-20"并确定时
      那么设置He压力失败并提示
      """
      = "The Number you input is overload, please input again!"
      """

    场景:设置He压力值成功
      假如"PM2 GDE"处于"Maintain"模式
      当设置He压力为"5"并确定时
      那么服务窗口显示值为
      """
      = "5.0"
      """
      并且在服务窗口执行"Run"
      那么He压力值显示为
      """
      = "5.0"
      """

  Rule: DigitalInput相关操作

    场景: del按钮
      假如"PM2 GDE"处于"Maintain"模式
      当设置He压力为"12"时
      并且在DigitalInput窗口执行"del"
      那么DigitalInput窗口"Selected"显示为
      """
      = "1"
      """

    场景: clear按钮
      假如"PM2 GDE"处于"Maintain"模式
      当设置He压力为"12"时
      并且在DigitalInput窗口执行"Clear"
      那么DigitalInput窗口"Selected"显示为
      """
      = ""
      """

  Rule: Bias RF

    场景: 检查Forward(W)数值显示
      当设置通道"/IO/PM/BRF_ForwardPower"为"5.0"
      那么Bias RF模块"Forward(W)"值显示正确:
      """
      = "5.0"
      """

    场景: 检查Reflected(W)数值显示
      当设置通道"/IO/BRFGenerator/BRFReflectPWRAI"为"5.0"
      那么Bias RF模块"Reflected(W)"值显示正确:
      """
      = "5.0"
      """

    场景: 检查DutyCycle(%)数值显示
      当设置通道"/IO/BRFGenerator/PulseDutyAI"为"5"
      那么Bias RF模块"DutyCycle(%)"值显示正确:
      """
      ="5"
      """

    场景: 检查Frequency(Hz)数值显示
      当设置通道"/IO/BRFGenerator/PulseFreqAI"为"5"
      那么Bias RF模块"Frequency(Hz)"值显示正确:
      """
      = "5"
      """

    场景: 检查WaveMode数值显示
      当设置通道"/IO/BRFGenerator/WaveMode"为"Pulse"
      那么Bias RF模块"WaveMode"值显示正确:
      """
      = "Pulse"
      """
      当设置通道"/IO/BRFGenerator/WaveMode"为"CW"
      那么Bias RF模块"WaveMode"值显示正确:
      """
      = "CW"
      """

    场景: Bias RF InitC1C2
      假如"PM2 GDE"处于"MaintMode"模式
      当在Bias RF Match中初始化C1C2
      那么Bias RF C1C2被初始化为750

    场景: Bias RF Match SetC1
      假如"PM2 GDE"处于"MaintMode"模式
      当在Bias RF Match中设置C1值为44
      那么Bias RF的"C1"值变为44

    场景: SRFEdge Match SetC2
      假如"PM2 GDE"处于"MaintMode"模式
      当在Bias RF Match中设置C2值为44
      那么Bias RF的"C2"值变为44

    场景: BRF SetPower
      假如"PM2 GDE"处于"MaintMode"模式
      当设置BRF的Forward值为78
      那么BRF的Forward值变为78

    场景: BRF SetDutyCycle
      假如"PM2 GDE"处于"MaintMode"模式
      当设置BRF的"DutyCycle(%)"值为78
      那么Bias RF的"DutyCycle(%)"值变为78

    场景: BRF SetFrequency
      假如"PM2 GDE"处于"MaintMode"模式
      当设置BRF的"Frequency(Hz)"值为78
      那么Bias RF的"Frequency(Hz)"值变为78

  Rule: Vacuum

      #TODO:漏率检测应加上关于Lr(mT/min)的检查，可直接调用 getPM2GDEValue
    场景: Leak Check
      假如"PM2 GDE"处于"MaintMode"模式
      当执行Vacuum中主要的"Leak Check"时
      那么Run Service显示"do ChamberLeakRate"

    场景: Cycle Purge
      假如"PM2 GDE"处于"MaintMode"模式
      当执行Vacuum中主要的"Cycle Purge"时
      那么Run Service显示"do Chamber Purge"

          #TODO:有问题，偶尔不通过
    场景: Pump Down
      假如"PM2 GDE"处于"MaintMode"模式
      当执行Vacuum中主要的"Pump Down"时
      那么Run Service显示"do Pump"

      #TODO vent不执行
#    场景: Do Vent
#      假如"PM2 GDE"处于"MaintMode"模式
#      当执行Vacuum中主要的"Vent"时
#      那么Run Service显示"do Vent"

  Rule: Pump

    场景: 设置TurboPump状态为Pump Off
      假如"PM2 GDE"处于"Maintain"模式
      假如设备""状态为"TurboPump_Start"
      当设置Pump"TurboPump"为"Pump Off"
      那么"TurboPump"在服务窗口显示为"Off"
      当在服务窗口点击"Cancel"
      那么"TurboPump"显示为"Off"

      #TODO 泵打开失败，打开时的ImageValue
#    场景: 设置TurboPump状态为Pump On
#      假如"PM2 GDE"处于"Maintain"模式
#      假如设备""状态为"TurboPump_Stop"
#      当设置Pump"TurboPump"为"Pump On"
#      那么"TurboPump"在服务窗口显示为"On"
#      当在服务窗口点击"Cancel"
#      那么"TurboPump"显示为"On"

    场景: 设置DryPump状态为Pump Off
      假如"PM2 GDE"处于"Maintain"模式
      假如设备""状态为"DryPump_Start"
      当设置Pump"DryPump"为"Pump Off"
      那么"DryPump"在服务窗口显示为"Off"
      当在服务窗口点击"Cancel"
      那么"DryPump"显示为"Off"

    场景: 设置DryPump状态为Pump On
      假如"PM2 GDE"处于"Maintain"模式
      假如设备""状态为"DryPump_Stop"
      当设置Pump"DryPump"为"Pump On"
      那么"DryPump"在服务窗口显示为"On"
      当在服务窗口点击"Cancel"
      那么"DryPump"显示为"On"

  Rule: 上位机设置阀门
    场景: 设置阀门TPN2状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"TMPPurgeValve"状态为"CloseValve"
      当设置阀门"TPN2"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"TPN2"显示为"Open"

    场景: 设置阀门TPN2状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"TMPPurgeValve"状态为"OpenValve"
      当设置阀门"TPN2"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"TPN2"显示为"Close"

    场景: 设置阀门ISO状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"TMPIsolationValve"状态为"CloseValve"
      当设置阀门"ISO"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"ISO"显示为"Open"

    场景: 设置阀门ISO状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"TMPIsolationValve"状态为"OpenValve"
      当设置阀门"ISO"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"ISO"显示为"Close"

    场景: 设置阀门fast状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"FastRough"状态为"CloseValve"
      当设置阀门"fast"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"fast"显示为"Open"

    场景: 设置阀门fast状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"FastRough"状态为"OpenValve"
      当设置阀门"fast"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"fast"显示为"Close"

    场景: 设置阀门slow状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"SlowRough"状态为"CloseValve"
      当设置阀门"slow"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"slow"显示为"Open"

    场景: 设置阀门slow状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"SlowRough"状态为"OpenValve"
      当设置阀门"slow"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"slow"显示为"Close"

    场景: 设置阀门HePrimary状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve1"状态为"CloseValve"
      当设置阀门"HePrimary"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"HePrimary"显示为"Open"

    场景: 设置阀门HePrimary状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve1"状态为"OpenValve"
      当设置阀门"HePrimary"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"HePrimary"显示为"Close"

    场景: 设置阀门HeStabilize状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve3"状态为"CloseValve"
      当设置阀门"HeStabilize"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"HeStabilize"显示为"Open"

    场景: 设置阀门HeStabilize状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve3"状态为"OpenValve"
      当设置阀门"HeStabilize"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"HeStabilize"显示为"Close"

    场景: 设置阀门HeForelineEVAC状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve4"状态为"CloseValve"
      当设置阀门"HeForelineEVAC"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"HeForelineEVAC"显示为"Open"

    场景: 设置阀门HeForelineEVAC状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve4"状态为"OpenValve"
      当设置阀门"HeForelineEVAC"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"HeForelineEVAC"显示为"Close"

    场景: 设置阀门HeSecondary状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve2"状态为"CloseValve"
      当设置阀门"HeSecondary"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"HeSecondary"显示为"Open"

    场景: 设置阀门HeSecondary状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"HeValve2"状态为"OpenValve"
      当设置阀门"HeSecondary"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"HeSecondary"显示为"Close"

    场景: 设置阀门Final状态为Open
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"FinalValve"状态为"CloseValve"
      当设置阀门"Final"为"Open"
      那么阀门在服务窗口显示为"Open"
      当在服务窗口点击"Cancel"
      那么阀门"Final"显示为"Open"

    场景: 设置阀门Final状态为Close
      假如"PM2 GDE"处于"Maintain"模式
      假如设备"FinalValve"状态为"OpenValve"
      当设置阀门"Final"为"Close"
      那么阀门在服务窗口显示为"Close"
      当在服务窗口点击"Cancel"
      那么阀门"Final"显示为"Close"

  Rule: Source RF Edge

    场景: 检查C1数值显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/SRFEdgeMatch/ReadC1"为"56"
      那么设置成功,Source RF Edge的"C1"显示为:
      """
      = "56"
      """

    场景: 检查C2数值显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/SRFEdgeMatch/ReadC2"为"56"
      那么设置成功,Source RF Edge的"C2"显示为:
      """
      = "56"
      """

    场景: 检查Reflected数值显示
      假如"PM2 GDE"处于"Maintain"模式
      当设置通道"IO/PCI9116/SRFEdgeReflectPWRAI"为"5"
      那么设置成功,Source RF Edge的"Reflected(W)"显示为:
      """
      = "5"
      """

      #TODO 设置通道值后显示有误差
#    场景: 检查Forward数值显示
#      假如"PM2 GDE"处于"Maintain"模式
#      当设置通道"IO/PCI9116/SRFEdgeFWDLPWRAI"为"5.0"
#      那么设置成功,Source RF Edge的"Forward(W)"显示为:
#      """
#      ="5.0"
#      """

    场景: SRFEdge SetPower
      假如"PM2 GDE"处于"MaintMode"模式
      当设置SRF Edge的Forward值为44
      那么SRF Edge的Forward值变为44

    场景: SRFEdge Match InitC1C2
      假如"PM2 GDE"处于"MaintMode"模式
      当在SRF Edge Match中初始化C1C2
      那么SRF Edge C1C2被初始化为750

    场景: SRFEdge Match SetC1
      假如"PM2 GDE"处于"MaintMode"模式
      当在SRF Edge Match中设置C1值为44
      那么SRF Edge C1值变为44

    场景: SRFEdge Match SetC2
      假如"PM2 GDE"处于"MaintMode"模式
      当在SRF Edge Match中设置C2值为44
      那么SRF Edge C2值变为44
