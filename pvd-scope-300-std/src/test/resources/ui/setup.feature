# language: zh-CN
@pvd-lower
@pvd-ui
功能: 配置参数界面
  Rule: 编辑参数
    场景: 修改int类型参数
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1003
      """

    场景: 修改Double类型参数
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      那么"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.9
      """

    场景: 修改int类型参数为非法值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"-1003"
      那么抛出警告，信息为:
      """
      '[SetupManager]输入错误！请输入100-600000范围内的Int类型值！'
      """
      并且"LampInnerPower (TOS) ms"的值为:
      """
      = 1001
      """

    场景: 修改Double类型参数为非法值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"-8.9"
      那么抛出警告，信息为:
      """
      '[SetupManager]输入错误！请输入0-100范围内的Double类型值！'
      """
      并且"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.1
      """

  Rule: 应用按钮功能验证
    场景: 应用int类型的参数
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且执行"应用"时
      那么提示信息为:
      """
      = ChCProcessMonitor应用成功！
      """
      并且"LampInnerPower (TOS) ms"对应的通道值"/SETUP/Control/ChC/ProcessMonitor/LampInnerPowerTOS"为:
      """
      = 1003
      """

    场景: 应用Double类型的参数
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且执行"应用"时
      那么提示信息为:
      """
      = ChCProcessMonitor应用成功！
      """
      并且"LampInnerPower (ST) +/-%"对应的通道值"/SETUP/Control/ChC/ProcessMonitor/LampInnerPowerST"为:
      """
      = 8.9
      """

    场景: 应用int类型的参数,重启上位机后参数值为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1008"
      并且执行"应用"并重启上位机后
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1008
      """

    场景: 应用Double类型的参数,重启上位机后参数值为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"9.9"
      并且执行"应用"并重启上位机后
      那么"LampInnerPower (ST) +/-%"对应的通道值"/SETUP/Control/ChC/ProcessMonitor/LampInnerPowerST"为:
      """
      = 9.9
      """

  Rule: 取消操作按钮功能验证
    场景: 取消int类型参数的修改,结果为修改前的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且执行"取消操作"时
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1001
      """

    场景: 取消Double类型参数的修改,结果为修改前的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且执行"取消操作"时
      那么"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.1
      """

    场景: 修改int类型参数后应用,点击取消,结果为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且执行"应用"后执行"取消操作"
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1003
      """

    场景: 修改Double类型参数后应用,点击取消,结果为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且执行"应用"后执行"取消操作"
      那么"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.9
      """

    场景: 修改int类型参数后保存,点击取消,结果为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且执行"保存"后执行"取消操作"
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1003
      """

    场景: 修改Double类型参数后保存,点击取消,结果为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且执行"保存"后执行"取消操作"
      那么"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.9
      """

    场景: 修改int类型参数多次，不应用后点击取消，结果为初始值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且修改"LampInnerPower (TOS) ms"的当前数值为"1005"
      并且执行"取消操作"时
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1001
      """

    场景: 修改Double类型参数多次，不应用后点击取消，结果为初始值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且修改"LampInnerPower (ST) +/-%"的当前数值为"9.9"
      并且执行"取消操作"时
      那么"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.1
      """

    场景: 修改多个参数后不应用，点击取消后结果为初始值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms  | 1001       |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且修改"LampInnerPower (ST) +/-%"的当前数值为"9.9"
      并且执行"取消操作"时
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1001
      """
      并且"LampInnerPower (ST) +/-%"的值为:
      """
      = 8.1
      """

  Rule: 保存按钮功能验证
    场景: 保存int类型的参数
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且执行"保存"时
      那么提示信息为:
      """
      = 'ChCProcessMonitor 保存成功！'
      """
      并且"LampInnerPower (TOS) ms"对应的通道值"/SETUP/Control/ChC/ProcessMonitor/LampInnerPowerTOS"为:
      """
      = 1003
      """

    场景: 保存Double类型的参数
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且执行"保存"时
      那么提示信息为:
      """
      = 'ChCProcessMonitor 保存成功！'
      """
      并且"LampInnerPower (ST) +/-%"对应的通道值"/SETUP/Control/ChC/ProcessMonitor/LampInnerPowerST"为:
      """
      = 8.9
      """

    场景: 保存int类型的参数,重启上位机后参数值为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1008"
      并且执行"保存"并重启上位机后
      那么"LampInnerPower (TOS) ms"的值为:
      """
      = 1008
      """

    场景: 保存Double类型的参数,重启上位机后参数值为修改后的值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"9.9"
      并且执行"保存"并重启上位机后
      那么"LampInnerPower (ST) +/-%"对应的通道值"/SETUP/Control/ChC/ProcessMonitor/LampInnerPowerST"为:
      """
      = 9.9
      """

    #TODO:验证的加参数有问题
    场景: 保存int类型的参数后,下位机文件应修改为保存值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                    | 当前数值1(可编辑) |
        | LampInnerPower (TOS) ms | 1001       |
      当修改"LampInnerPower (TOS) ms"的当前数值为"1003"
      并且执行"保存"时
      那么提示信息为:
      """
      = 'ChCProcessMonitor 保存成功！'
      """
      并且下位机文件应为:
      """
      config.Setup['ChCProcessMonitor'].lines[]: [
        ...
        /.*1003.*/
        ...
      ]
      """

    #TODO:验证的加参数有问题
    场景: 保存Double类型的参数后,下位机文件应修改为保存值
      假如在"ChC"的"ProcessMonitor"中存在参数:
        | 参数名称                     | 当前数值1(可编辑) |
        | LampInnerPower (ST) +/-% | 8.1        |
      当修改"LampInnerPower (ST) +/-%"的当前数值为"8.9"
      并且执行"保存"时
      那么提示信息为:
      """
      = 'ChCProcessMonitor 保存成功！'
      """
      并且下位机文件应为:
      """
      config.Setup['ChCProcessMonitor'].lines[]: [
        ...
        /.*8.9.*/
        ...
      ]
      """









