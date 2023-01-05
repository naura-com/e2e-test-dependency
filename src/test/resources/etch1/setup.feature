# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
@skip

功能: Setup功能

  Rule: 编辑参数

    场景: OnlyReadInt类型参数合法输入
      假如存在"OnlyReadInt"类型的参数:
        | Name     | Parameter        | CurrentValue |
        | RFConfig | SRFCenterRunMode | Load         |
      当修改"SRFCenterRunMode"的当前值为"Forward"
      那么操作成功,"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """

    场景: Int类型参数合法输入
      假如存在"Int"类型的参数:
        | Name      | Parameter         | CurrentValue |
        | GasConfig | GasPumpPurgeCycle | 20           |
      当修改"GasPumpPurgeCycle"的当前值为"30":
      那么操作成功,"GasPumpPurgeCycle"的当前值为
      """
      = 30
      """

      # TODO 全角无法输入
    场景: Int类型参数非法输入校验
      假如存在"Int"类型的参数:
        | Name      | Parameter         | Range   | CurrentValue |
        | GasConfig | GasPumpPurgeCycle | 0~10000 | 20           |
      当修改"GasPumpPurgeCycle"的当前值为" ":
      并且切换到任意位置
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"非法":
      并且切换到任意位置
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"？*":
      并且切换到任意位置
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"\n":
      并且切换到任意位置
      那么操作失败,提示信息为:
      """
      "Input is invalid! Please input again!"
      """
#      当修改"GasPumpPurgeCycle"的当前值为"５":
#      并且切换到任意位置
#      那么操作失败,提示信息为:
#      """
#      "Input is invalid! Please input again!"
#      """
      当修改"GasPumpPurgeCycle"的当前值为"10001":
      并且切换到任意位置
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"-1":
      并且切换到任意位置
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
#      当修改"GasPumpPurgeCycle"的当前值为"9.999":
#      并且切换到任意位置
#      那么操作失败,提示信息为:
#      """
#      ="Input is invalid! Please input again!"
#      """

    场景: Double类型参数合法输入
      假如存在"Double"类型的参数:
        | Name     | Parameter         | CurrentValue |
        | RFConfig | SRFCenterRampTime | 1            |
      当修改"SRFCenterRampTime"的当前值为"3.5":
      那么操作成功,"SRFCenterRampTime"的当前值为
      """
      = 3.5
      """

    #TODO CTC Bug 1.超范围、负数、超精度,无弹框提示
    场景: Double类型参数非法输入校验
      假如存在"Double"类型的参数:
        | Name     | Parameter         | Range | Accuracy | CurrentValue |
        | RFConfig | SRFCenterRampTime | 0~10  | 0.1      | 1            |
      当修改"SRFCenterRampTime"的当前值为非法值" ":
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为非法值"非法":
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为非法值"？*":
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为非法值"\n":
      那么操作失败,提示信息为:
      """
      ="Input is invalid! Please input again!"
      """
#      当修改"SRFCenterRampTime"的当前值为非法值"５":
#      那么操作失败,提示信息为:
#      """
#      "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为非法值"11":
#      那么操作失败,提示信息为:
#      """
#      "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为非法值"-1":
#      那么操作失败,提示信息为:
#      """
#      "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为非法值"9.99":
#      那么操作失败,提示信息为:
#      """
#      "Input is invalid! Please input again!"
#      """

  Rule: Undo

    场景: 恢复单个OnlyReadInt类型值至修改前值
      假如存在被修改的"OnlyReadInt"类型的参数:
        | Name     | Parameter        | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRunMode | Forward      | Forward      | Load                 |
      当执行setup的"Undo"操作
      那么操作成功,"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """

    场景: 恢复多个OnlyReadInt类型值至修改前值
      假如存在被修改的"OnlyReadInt"类型的参数:
        | Name     | Parameter        | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRunMode | Forward      | Forward      | Load                 |
        | RFConfig | SRFEdgeRunMode   | Forward      | Forward      | Load                 |
      当执行setup的"Undo"操作
      那么操作成功,"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """
      并且"SRFEdgeRunMode"的当前值为
      """
      = "Forward"
      """

    场景:恢复单个Int类型值至修改前值
      假如存在被修改的"Int"类型的参数:
        | Name      | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | GasConfig | GasPumpPurgeCycle | 20           | 20           | 0                    |
      当执行setup的"Undo"操作
      那么操作成功,"GasPumpPurgeCycle"的当前值为
      """
      = 20
      """

    场景:恢复多个Int类型值至修改前值
      假如存在被修改的"Int"类型的参数:
        | Name      | Parameter               | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | GasConfig | GasPumpPurgeCycle       | 20           | 20           | 0                    |
        | GasConfig | GasPanelLeakRateTimeout | 300          | 300          | 0                    |
      当执行setup的"Undo"操作
      那么操作成功,"GasPumpPurgeCycle"的当前值为
      """
      = 20
      """
      并且"GasPanelLeakRateTimeout"的当前值为
      """
      = 300
      """

    场景: 恢复单个Double类型值至修改前值
      假如存在被修改的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 3            | 1            | 3.5                  |
      当执行setup的"Undo"操作
      那么操作成功,"SRFCenterRampTime"的当前值为
        """
        = 3
        """

    场景: 恢复多个Double类型值至修改前值
      假如存在被修改的"Double"类型的参数:
        | Name     | Parameter                 | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime         | 3            | 1            | 3.5                  |
        | RFConfig | SRFCenterStableThreadhold | 50           | 50           | 45                   |
      当执行setup的"Undo"操作
      那么操作成功,"SRFCenterRampTime"的当前值为
        """
        = 3
        """
      并且"SRFCenterStableThreadhold"的当前值为
        """
        = 50
        """

    @etch1-reset
    场景: Undo恢复Save后的值
      假如存在被"Save"的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 3            | 1            | 3.5                  |
      当修改"SRFCenterRampTime"的当前值为"2":
      并且执行setup的"Undo"操作
      那么操作成功,"SRFCenterRampTime"的当前值为
        """
        = 3.5
        """

    场景: Undo恢复Apply后的值
      假如存在被"Apply"的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 3            | 1            | 3.5                  |
      当修改"SRFCenterRampTime"的当前值为"2":
      并且执行setup的"Undo"操作
      那么操作成功,"SRFCenterRampTime"的当前值为
        """
        = 3.5
        """

  Rule: Apply

    场景:OnlyReadInt类型参数合法应用校验
      假如存在被修改的"OnlyReadInt"类型的参数:
        | Name     | Parameter        | CurrentValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRunMode | Load         | Forward              |
      当执行setup的"Apply"操作
      那么操作成功,提示信息为:
      """
      = "RFConfig Apply Success"
      """
      并且"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """
      并且"SRFCenterRunMode"对应的通道值"/SETUP/RF/cfgSRFCenterRunMode"为
      """
      = 0
      """
    # TODO add method
#      当重启上下位机
#      那么"SRFCenterRunMode"的当前值为"Load"

    场景: Int类型参数合法应用校验
      假如存在被修改的"Int"类型的参数:
        | Name      | Parameter         | CurrentValue | ModifiedCurrentValue |
        | GasConfig | GasPumpPurgeCycle | 20           | 30                   |
      当执行setup的"Apply"操作
      那么操作成功,提示信息为:
      """
      = "GasConfig Apply Success"
      """
      并且"GasPumpPurgeCycle"的当前值为
      """
      = 30
      """
      并且"GasPumpPurgeCycle"对应的通道值"/SETUP/GasConfig/cfgGasPumpPurgeCycle"为
      """
      = 30
      """

    场景: Int类型参数非法应用校验
      假如存在"Int"类型的参数:
        | Name      | Parameter         | Range   | CurrentValue |
        | GasConfig | GasPumpPurgeCycle | 0~10000 | 20           |
      当修改"GasPumpPurgeCycle"的当前值为" ":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"非法":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"？*":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"\n":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
#      当修改"GasPumpPurgeCycle"的当前值为"５":
#      并且执行"Save"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """
      当修改"GasPumpPurgeCycle"的当前值为"10001":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"-1":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"9.999":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """

    场景: Double类型参数合法应用校验

      假如存在被修改的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 1            | 3.5                  |
      当执行setup的"Apply"操作
      那么操作成功,提示信息为:
        """
        = "RFConfig Apply Success"
        """
      并且"SRFCenterRampTime"的当前值为
        """
        = 3.5
        """
      并且"SRFCenterRampTime"对应的通道值"/SETUP/Recipe/cfgSRFCenterRampTime"为
        """
        = 3.5
        """

    场景: Double类型参数非法应用校验
      假如存在"Double"类型的参数:
        | Name     | Parameter         | Range | Accuracy | CurrentValue |
        | RFConfig | SRFCenterRampTime | 0~10  | 0.1      | 1            |
      当修改"SRFCenterRampTime"的当前值为" ":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
        """
        = "Input is invalid! Please input again!"
        """
      当修改"SRFCenterRampTime"的当前值为"非法":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
        """
        = "Input is invalid! Please input again!"
        """
      当修改"SRFCenterRampTime"的当前值为"？*":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
        """
        = "Input is invalid! Please input again!"
        """
      当修改"SRFCenterRampTime"的当前值为"\n":
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
        """
        = "Input is invalid! Please input again!"
        """
  #      当修改"SRFCenterRampTime"的当前值为"５":
  #      并且切换到任意位置"SRFCenterRampTime"
  #      那么操作失败,提示信息为:
  #      """
  #      = "Input is invalid! Please input again!"
  #      """
        #TODO 提示RFConfig Apply Success
  #      当修改"SRFCenterRampTime"的当前值为"11":
  #      并且执行setup的"Apply"操作
  #      那么操作失败,提示信息为:
  #      """
  #      = "Input is invalid! Please input again!"
  #      """
  #      当修改"SRFCenterRampTime"的当前值为"-1":
  #      并且执行setup的"Apply"操作
  #      那么操作失败,提示信息为:
  #      """
  #      = "Input is invalid! Please input again!"
  #      """
#      当修改"SRFCenterRampTime"的当前值为"9.99":
#      并且执行setup的"Apply"操作
#      那么操作失败,提示信息为:
#        """
#        = "Input is invalid! Please input again!"
#        """

    @CleanDir
    场景: Apply导入的不同界面文件
      假如setup的"RFConfig"存在如下配置:
        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue |
        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      |
        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           |
        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            |
        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            |
        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           |
        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           |
        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      |
        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           |
        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            |
        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            |
        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            |
        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           |
        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      |
        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           |
        | BRFRampTime               | 1~10             | s    | 1            | 1            |
        | BRFStableTimeout          | 0~60             | s    | 4            | 4            |
        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           |
        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         |
        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         |
        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         |
      当"Import"有效参数的配置文件"Valid.csv":
        | Parameter         | Range   | Unit | CurrentValue | DefaultValue |
        | GasPumpPurgeCycle | 0~10000 |      | 20           | 20           |
      并且执行setup的"Apply"操作
      那么操作失败,提示信息为:
        """
        = "RFConfig Apply Failed"
        """

#    #TODO ci不通过，和其他用例之前不独立
#    @CleanDir
#    @etch1-reset
#    场景: Apply导入的合法文件
#      假如setup的"RFConfig"存在如下配置:
#        | Parameter        | Range            | Unit | CurrentValue | DefaultValue | Type        |
#        | SRFCenterRunMode | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt |
#      当"Import"有效参数的配置文件"Valid.csv":
#        | Parameter        | Range            | Unit | CurrentValue | DefaultValue |
#        | SRFCenterRunMode | Forward:0,Load:1 |      | Forward      | Load         |
#      并且执行setup的"Apply"操作
#      那么操作成功,提示信息为:
#        """
#        = "RFConfig Apply Success"
#        """
#      并且"SRFCenterRunMode"的当前值为
#        """
#        = "Forward"
#        """

  Rule: Save

    场景:OnlyReadInt类型参数合法保存校验
      假如存在被修改的"OnlyReadInt"类型的参数:
        | Name     | Parameter        | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRunMode | Forward      | Forward      | Load                 |
      当执行setup的"Save"操作
      那么操作成功,提示信息为:
      """
      = "RFConfig Save To Xml Success"
      """
      并且"SRFCenterRunMode"的当前值为
      """
      = "Load"
      """
      并且"SRFCenterRunMode"对应的通道值"/SETUP/RF/cfgSRFCenterRunMode"为
      """
      = 1
      """

    场景:Int类型合法保存校验
      假如存在被修改的"Int"类型的参数:
        | Name      | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | GasConfig | GasPumpPurgeCycle | 20           | 20           | 0                    |
      当执行setup的"Save"操作
      那么操作成功,提示信息为:
      """
      = "GasConfig Save To Xml Success"
      """
      并且"GasPumpPurgeCycle"的当前值为
      """
      = 0
      """
      并且"GasPumpPurgeCycle"对应的通道值"/SETUP/GasConfig/cfgGasPumpPurgeCycle"为
      """
      = 0
      """

     #TODO 全角字符无法输入
    场景: Int类型参数非法保存校验
      假如存在"Int"类型的参数:
        | Name      | Parameter         | Range   | CurrentValue |
        | GasConfig | GasPumpPurgeCycle | 0~10000 | 20           |
      当修改"GasPumpPurgeCycle"的当前值为" ":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"非法":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"？*":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"\n":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
#      当修改"GasPumpPurgeCycle"的当前值为"５":
#      并且执行"Save"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """
      当修改"GasPumpPurgeCycle"的当前值为"10001":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"-1":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"GasPumpPurgeCycle"的当前值为"9.999":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """

    场景: Double类型合法保存校验
      假如存在被修改的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 1            | 3.5                  |
      当执行setup的"Save"操作
      那么操作成功,提示信息为:
      """
      = "RFConfig Save To Xml Success"
      """
      并且"SRFCenterRampTime"的当前值为
      """
      = 3.5
      """
      并且"SRFCenterRampTime"对应的通道值"/SETUP/Recipe/cfgSRFCenterRampTime"为
      """
      = 3.5
      """

    场景: Double类型参数非法保存校验
      假如存在"Double"类型的参数:
        | Name     | Parameter         | Range | Accuracy | CurrentValue |
        | RFConfig | SRFCenterRampTime | 0~10  | 0.1      | 1            |
      当修改"SRFCenterRampTime"的当前值为" ":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为"非法":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为"？*":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为"\n":
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
#      当修改"SRFCenterRampTime"的当前值为"11":
#      并且执行setup的"Save"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为"-1":
#      并且执行setup的"Save"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为"9.99":
#      并且执行setup的"Save"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """

    场景: Save恢复Apply后的值
      假如存在被"Apply"的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 3            | 1            | 3.5                  |
      当修改"SRFCenterRampTime"的当前值为"2.1":
      并且执行setup的"Save"操作
      那么操作成功,提示信息为:
      """
      = "RFConfig Save To Xml Success"
      """
      并且"SRFCenterRampTime"的当前值为
      """
      = 2.1
      """
      并且"SRFCenterRampTime"对应的通道值"/SETUP/Recipe/cfgSRFCenterRampTime"为
      """
      = 2.1
      """

    场景: Save恢复Undo后的值
      假如存在被"Undo"的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 3            | 1            | 3.5                  |
      当修改"SRFCenterRampTime"的当前值为"2.1":
      并且执行setup的"Save"操作
      那么操作成功,提示信息为:
      """
      = "RFConfig Save To Xml Success"
      """
      并且"SRFCenterRampTime"的当前值为
      """
      = 2.1
      """
      并且"SRFCenterRampTime"对应的通道值"/SETUP/Recipe/cfgSRFCenterRampTime"为
      """
      = 2.1
      """

    @CleanDir
    场景: Save导入的合法文件
      假如setup的"RFConfig"存在如下配置:
        | Parameter        | Range            | Unit | CurrentValue | DefaultValue | Type        |
        | SRFCenterRunMode | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt |
      当"Import"有效参数的配置文件"Valid.csv":
        | Parameter        | Range            | Unit | CurrentValue | DefaultValue |
        | SRFCenterRunMode | Forward:0,Load:1 |      | Forward      | Load         |
      并且执行setup的"Save"操作
      那么操作成功,提示信息为:
      """
      = "RFConfig Save To Xml Success"
      """
      并且"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """

    @CleanDir
    场景: Save导入的不同界面文件
      假如setup的"RFConfig"存在如下配置:
        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue |
        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      |
        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           |
        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            |
        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            |
        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           |
        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           |
        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      |
        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           |
        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            |
        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            |
        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            |
        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           |
        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      |
        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           |
        | BRFRampTime               | 1~10             | s    | 1            | 1            |
        | BRFStableTimeout          | 0~60             | s    | 4            | 4            |
        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           |
        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         |
        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         |
        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         |
      当"Import"和界面参数不同的配置文件"DiffValid.csv":
        | Parameter         | Range   | Unit | CurrentValue | DefaultValue |
        | GasPumpPurgeCycle | 0~10000 |      | 20           | 20           |
      并且执行setup的"Save"操作
      那么操作失败,提示信息为:
      """
      = "RFConfig Save to Xml Failed"
      """

  Rule: Import

    @CleanDir
    场景: 导入和界面不同参数值
      假如存在"Double"类型的参数:
        | Name     | Parameter         | CurrentValue |
        | RFConfig | SRFCenterRampTime | 2            |
      并且存在有效参数的配置文件"PM2 RFConfig 2022-10-19 17点00分4秒.csv":
        | Parameter         | Range | Unit | CurrentValue | DefaultValue |
        | SRFCenterRampTime | 0~10  | s    | 1            | 1            |
      当执行setup的"Import"操作
      并且选择导入文件为"PM2 RFConfig 2022-10-19 17点00分4秒.csv"
      那么操作成功,"SRFCenterRampTime"的当前值为
      """
      = 1
      """

    @CleanDir
    场景:导入非法文件
      假如存在无效参数的配置文件"Notvaliad.csv":
        | Parameter         | Range | Unit | CurrentValue | DefaultValue |
        | SRFCenterRampTime | 0~10  | s    | notvaliad    | 1            |
      当执行setup的"Import"操作
      并且选择导入文件为"Notvaliad.csv"
      那么操作失败,提示信息为:
      """
      = "Invalid Parameters! Import Setup Config Failed!"
      """

    @CleanDir
    场景: 导入非法格式文件
      假如存在无效格式的配置文件:
        | configName   |
        | invalid.txt  |
        | invalid2.xml |
      当执行setup的"Import"操作
      并且选择导入非法文件为"invalid.txt"
      那么操作失败,提示信息为:
      """
      = "Invalid Parameters! Import Setup Config Failed!"
      """
      当执行setup的"Import"操作
      并且选择导入非法文件为"invalid2.xml"
      那么操作失败,提示信息为:
      """
      = "Invalid Parameters! Import Setup Config Failed!"
      """

  Rule: Export

    #TODO: 导出文件夹名称精确到时间
    @CleanDir
    场景: 成功导出文件
      假如setup的"RFConfig"存在如下配置:
        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue |
        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      |
        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           |
        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            |
        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            |
        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           |
        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           |
        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      |
        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           |
        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            |
        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            |
        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            |
        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           |
        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      |
        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           |
        | BRFRampTime               | 1~10             | s    | 1            | 1            |
        | BRFStableTimeout          | 0~60             | s    | 4            | 4            |
        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           |
        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         |
        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         |
        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         |
      当执行"Export"操作:
      那么操作成功,提示信息为:
      """
      = "Export Setup successfully!"
      """
      并且存在文件"PM2 RFConfig":
      """
      :[
      'Parameter,Range,Unit,CurrentValue,DefaultValue',
      'SRFCenterRunMode,"Forward:0,Load:1",,Load,Forward',
      'SRFCenterRampEnable,"No:0,Yes:1",,No,No',
      'SRFCenterRampTime,1~10,s,1,1',
      'SRFCenterDelayTime,0~10,s,4,0',
      'SRFCenterStableTimeout,0~60,sec,50,4',
      'SRFCenterStableThreadhold,0~100,watt,50,50',
      'SRFEdgeRunMode,"Forward:0,Load:1",,Load,Forward',
      'SRFEdgeRampEnable,"No:0,Yes:1",,No,No',
      'SRFEdgeRampTime,1~10,s,1,1',
      'SRFEdgeDelayTime,0~10,s,0,0',
      'SRFEdgeStableTimeout,0~60,sec,4,4',
      'SRFEdgeStableThreadhold,0~100,watt,50,50',
      'BRFRunMode,"Forward:0,Load:1",,Load,Forward',
      'BRFRampEnable,"No:0,Yes:1",,No,No',
      'BRFRampTime,1~10,s,1,1',
      'BRFStableTimeout,0~60,sec,4,4',
      'BRFStableThreadhold,0~100,watt,50,50',
      'SRFCenterLinerAdjust,2750~3000,w,2851,2999',
      'SRFEdgeLinerAdjust,2750~3000,w,2954,2999',
      'BRFLinerAdjust,1410~1500,w,1450,1499',
      ''
      ]
      """

    # TODO 超范围、超精度、负数导出成功了
    场景: 参数非法导出文件
      假如setup的"RFConfig"存在如下配置:
        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue | Type        |
        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt |
        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           | OnlyReadInt |
        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            | Double      |
        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            | Double      |
        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           | Double      |
        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           | Double      |
        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt |
        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           | OnlyReadInt |
        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            | Double      |
        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            | Double      |
        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            | Double      |
        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           | Double      |
        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt |
        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           | OnlyReadInt |
        | BRFRampTime               | 1~10             | s    | 1            | 1            | Double      |
        | BRFStableTimeout          | 0~60             | s    | 4            | 4            | Double      |
        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           | Double      |
        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         | Double      |
        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         | Double      |
        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         | Double      |
      当修改"SRFCenterRampTime"的当前值为" ":
      并且执行setup的"Export"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为"非法":
      并且执行setup的"Export"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为"？*":
      并且执行setup的"Export"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
      当修改"SRFCenterRampTime"的当前值为"\n":
      并且执行setup的"Export"操作
      那么操作失败,提示信息为:
      """
      = "Input is invalid! Please input again!"
      """
#      当修改"SRFCenterRampTime"的当前值为"11":
#      并且执行"Export"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为"-1":
#      并且执行"Export"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """
#      当修改"SRFCenterRampTime"的当前值为"9.99":
#      并且执行"Export"操作
#      那么操作失败,提示信息为:
#      """
#      = "Input is invalid! Please input again!"
#      """

    @CleanDir
    场景: 成功导出保存后的文件
      假如存在"Save"后的setup的"RFConfig":
        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue | Type        | ModifiedCurrentValue |
        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt | Forward              |
        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           | OnlyReadInt | Yes                  |
        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            | Double      | 2                    |
        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            | Double      | 0                    |
        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           | Double      | 0                    |
        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           | Double      | 0                    |
        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt | Forward              |
        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           | OnlyReadInt | Yes                  |
        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            | Double      | 10                   |
        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            | Double      | 10                   |
        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            | Double      | 0                    |
        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           | Double      | 0                    |
        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt | Forward              |
        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           | OnlyReadInt | Yes                  |
        | BRFRampTime               | 1~10             | s    | 1            | 1            | Double      | 10                   |
        | BRFStableTimeout          | 0~60             | s    | 4            | 4            | Double      | 0                    |
        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           | Double      | 0                    |
        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         | Double      | 3000                 |
        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         | Double      | 3000                 |
        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         | Double      | 1450                 |
      当执行"Export"操作:
      那么操作成功,提示信息为:
      """
      = "Export Setup successfully!"
      """
      并且存在文件"PM2 RFConfig":
      """
      :[
      'Parameter,Range,Unit,CurrentValue,DefaultValue',
      'SRFCenterRunMode,"Forward:0,Load:1",,Forward,Forward',
      'SRFCenterRampEnable,"No:0,Yes:1",,Yes,No',
      'SRFCenterRampTime,1~10,s,2,1',
      'SRFCenterDelayTime,0~10,s,0,0',
      'SRFCenterStableTimeout,0~60,sec,0,4',
      'SRFCenterStableThreadhold,0~100,watt,0,50',
      'SRFEdgeRunMode,"Forward:0,Load:1",,Forward,Forward',
      'SRFEdgeRampEnable,"No:0,Yes:1",,Yes,No',
      'SRFEdgeRampTime,1~10,s,10,1',
      'SRFEdgeDelayTime,0~10,s,10,0',
      'SRFEdgeStableTimeout,0~60,sec,0,4',
      'SRFEdgeStableThreadhold,0~100,watt,0,50',
      'BRFRunMode,"Forward:0,Load:1",,Forward,Forward',
      'BRFRampEnable,"No:0,Yes:1",,Yes,No',
      'BRFRampTime,1~10,s,10,1',
      'BRFStableTimeout,0~60,sec,0,4',
      'BRFStableThreadhold,0~100,watt,0,50',
      'SRFCenterLinerAdjust,2750~3000,w,3000,2999',
      'SRFEdgeLinerAdjust,2750~3000,w,3000,2999',
      'BRFLinerAdjust,1410~1500,w,1450,1499',
      ''
      ]
      """

    @CleanDir
    场景: 成功导出应用后的文件
      假如存在"Apply"后的setup的"RFConfig":
        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue | Type        | ModifiedCurrentValue |
        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt | Forward              |
        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           | OnlyReadInt | Yes                  |
        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            | Double      | 2                    |
        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            | Double      | 0                    |
        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           | Double      | 0                    |
        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           | Double      | 0                    |
        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt | Forward              |
        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           | OnlyReadInt | Yes                  |
        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            | Double      | 10                   |
        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            | Double      | 10                   |
        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            | Double      | 0                    |
        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           | Double      | 0                    |
        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt | Forward              |
        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           | OnlyReadInt | Yes                  |
        | BRFRampTime               | 1~10             | s    | 1            | 1            | Double      | 10                   |
        | BRFStableTimeout          | 0~60             | s    | 4            | 4            | Double      | 0                    |
        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           | Double      | 0                    |
        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         | Double      | 3000                 |
        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         | Double      | 3000                 |
        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         | Double      | 1450                 |
      当执行"Export"操作:
      那么操作成功,提示信息为:
      """
      = "Export Setup successfully!"
      """
      并且存在文件"PM2 RFConfig":
      """
      :[
      'Parameter,Range,Unit,CurrentValue,DefaultValue',
      'SRFCenterRunMode,"Forward:0,Load:1",,Forward,Forward',
      'SRFCenterRampEnable,"No:0,Yes:1",,Yes,No',
      'SRFCenterRampTime,1~10,s,2,1',
      'SRFCenterDelayTime,0~10,s,0,0',
      'SRFCenterStableTimeout,0~60,sec,0,4',
      'SRFCenterStableThreadhold,0~100,watt,0,50',
      'SRFEdgeRunMode,"Forward:0,Load:1",,Forward,Forward',
      'SRFEdgeRampEnable,"No:0,Yes:1",,Yes,No',
      'SRFEdgeRampTime,1~10,s,10,1',
      'SRFEdgeDelayTime,0~10,s,10,0',
      'SRFEdgeStableTimeout,0~60,sec,0,4',
      'SRFEdgeStableThreadhold,0~100,watt,0,50',
      'BRFRunMode,"Forward:0,Load:1",,Forward,Forward',
      'BRFRampEnable,"No:0,Yes:1",,Yes,No',
      'BRFRampTime,1~10,s,10,1',
      'BRFStableTimeout,0~60,sec,0,4',
      'BRFStableThreadhold,0~100,watt,0,50',
      'SRFCenterLinerAdjust,2750~3000,w,3000,2999',
      'SRFEdgeLinerAdjust,2750~3000,w,3000,2999',
      'BRFLinerAdjust,1410~1500,w,1450,1499',
      ''
      ]
      """

  Rule: Default

    场景: OnlyReadInt类型参数合法恢复默认值校验
      假如存在被修改的"OnlyReadInt"类型的参数:
        | Name     | Parameter        | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRunMode | Forward      | Forward      | Load                 |
      当执行setup的"Default"操作
      那么操作成功,"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """
#      并且"SRFCenterRunMode"对应的通道值"/SETUP/RF/cfgSRFCenterRunMode"为
#      """
#      = 1
#      """

    场景: Int类型参数合法恢复默认值校验
      假如存在被修改的"Int"类型的参数:
        | Name      | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | GasConfig | GasPumpPurgeCycle | 10           | 20           | 30                   |
      当执行setup的"Default"操作
      那么操作成功,"GasPumpPurgeCycle"的当前值为
      """
      = 20
      """
#      并且"GasPumpPurgeCycle"对应的通道值"/SETUP/GasConfig/cfgGasPumpPurgeCycle"为
#      """
#      = 30
#      """

      #TODO 弹出非法提示
    场景: Double类型参数合法恢复默认值校验
      假如存在被修改的"Double"类型的参数:
        | Name     | Parameter         | CurrentValue | DefaultValue | ModifiedCurrentValue |
        | RFConfig | SRFCenterRampTime | 3            | 1            | 3.5                  |
      当执行setup的"Default"操作
      那么操作成功,"SRFCenterRampTime"的当前值为
      """
      = 1
      """
#      并且"SRFCenterRampTime"对应的通道值"/SETUP/Recipe/cfgSRFCenterRampTime"为
#      """
#      = 1.0
#      """

    @CleanDir
    场景: Default导入的合法文件
      假如setup的"RFConfig"存在如下配置:
        | Parameter        | Range            | Unit | CurrentValue | DefaultValue | Type        |
        | SRFCenterRunMode | Forward:0,Load:1 |      | Load         | Forward      | OnlyReadInt |
      当"Import"有效参数的配置文件"Valid.csv":
        | Parameter        | Range            | Unit | CurrentValue | DefaultValue |
        | SRFCenterRunMode | Forward:0,Load:1 |      | Forward      | Load         |
      并且执行setup的"Default"操作
      那么操作成功,"SRFCenterRunMode"的当前值为
      """
      = "Forward"
      """

#  #TODO CTC Bug 恢复的为当前界面的默认值
#    @CleanDir
#    场景: Default导入的不同界面文件
#      假如setup的"RFConfig"存在如下配置:
#        | Parameter                 | Range            | Unit | CurrentValue | DefaultValue |
#        | SRFCenterRunMode          | Forward:0,Load:1 |      | Load         | Forward      |
#        | SRFCenterRampEnable       | No:0,Yes:1       |      | No           | No           |
#        | SRFCenterRampTime         | 1~10             | s    | 1            | 1            |
#        | SRFCenterDelayTime        | 0~10             | s    | 4            | 4            |
#        | SRFCenterStableTimeout    | 0~60             | sec  | 50           | 50           |
#        | SRFCenterStableThreadhold | 0~100            | watt | 50           | 50           |
#        | SRFEdgeRunMode            | Forward:0,Load:1 |      | Load         | Forward      |
#        | SRFEdgeRampEnable         | No:0,Yes:1       |      | No           | No           |
#        | SRFEdgeRampTime           | 1~10             | s    | 1            | 1            |
#        | SRFEdgeDelayTime          | 0~10             | s    | 0            | 0            |
#        | SRFEdgeStableTimeout      | 0~60             | sec  | 4            | 4            |
#        | SRFEdgeStableThreadhold   | 0~100            | watt | 50           | 50           |
#        | BRFRunMode                | Forward:0,Load:1 |      | Load         | Forward      |
#        | BRFRampEnable             | No:0,Yes:1       |      | No           | No           |
#        | BRFRampTime               | 1~10             | s    | 1            | 1            |
#        | BRFStableTimeout          | 0~60             | s    | 4            | 4            |
#        | BRFStableThreadhold       | 0~100            | watt | 50           | 50           |
#        | SRFCenterLinerAdjust      | 2750~3000        | w    | 2851         | 2999         |
#        | SRFEdgeLinerAdjust        | 2750~3000        | w    | 2954         | 2999         |
#        | BRFLinerAdjust            | 1410~1500        | w    | 1450         | 1499         |
#      当"Import"和界面参数不同的配置文件"Valid.csv":
#        | Parameter         | Range   | Unit | CurrentValue | DefaultValue |
#        | GasPumpPurgeCycle | 0~10000 |      | 20           | 20           |
#      并且执行"Default"操作
#      那么操作失败
