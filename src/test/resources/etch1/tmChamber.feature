# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
#@skip
功能: TMChamber
  Rule: LoadPort Operations

    场景: LP1下拉列表验证
      当查看"LP1"的下拉列表
      那么"LP1"下拉列表显示正确:
      """
      =[
      "Load",
      "Unload",
      "LoadToLoadLock"
      ]
      """

    场景: LP2下拉列表验证
      当查看"LP2"的下拉列表
      那么"LP2"下拉列表显示正确:
      """
      =[
      "Load",
      "Unload",
      "LoadToLoadLock"
      ]
      """

    场景: LoadPort Operations相关界面的run abort状态检查
      假如"LP1"模块状态为maintain
      那么"LP1"的"Run"按钮处于使能状态,"Abort"按钮处于非使能状态
      假如"LP2"模块状态为maintain
      那么"LP2"的"Run"按钮处于使能状态,"Abort"按钮处于非使能状态

  Rule: SlotValve Operations

    场景: LA下拉列表验证
      当查看"LA"的下拉列表
      那么"LA"下拉列表显示正确:
      """
      =[
      "Open Valve",
      "Close Valve"
      ]
      """

    场景: LB下拉列表验证
      当查看"LB"的下拉列表
      那么"LB"下拉列表显示正确:
      """
      =[
      "Open Valve",
      "Close Valve"
      ]
      """

    场景: PM2下拉列表验证
      当查看"PM2"的下拉列表
      那么"PM2"下拉列表显示正确:
      """
      =[
      "Open Valve",
      "Close Valve"
      ]
      """

    场景: SlotValve Operations相关界面的run abort状态检查
      假如"VBE"模块状态为maintain:
      当查看"LA"页面
      那么"LA"的"Run"按钮处于使能状态,"Abort"按钮处于非使能状态
      当查看"LB"页面
      那么"LB"的"Run"按钮处于使能状态,"Abort"按钮处于非使能状态
      当查看"PM2"页面
      那么"PM2"的"Run"按钮处于使能状态,"Abort"按钮处于非使能状态

      #TODO:无法截取整个模块的一小部分
#    场景: LA Close Valve
#      假如"VBE"模块状态为maintain:
#      当"LA"执行"Close Valve"
#      那么操作成功,LA为"Close"状态

  Rule: Other Operations

    场景: VACRobot下拉列表验证
      当查看"VACRobot"的下拉列表
      那么"VACRobot"下拉列表显示正确:
      """
      =[
      "Home","HomeR","HomeZ","HomeT","Pick","Place","Extend","Retract","GoUp","GoDown","Rotate","Map","ALPick","ALPlace"
      ]
      """

    场景: Aligner下拉列表验证
      当查看"Aligner"的下拉列表
      那么"Aligner"下拉列表显示正确:
      """
      =[
      "Home","Align","Map","Scan"
      ]
      """

    场景: OLA下拉列表验证
      当查看"OLA"的下拉列表
      那么"OLA"下拉列表显示正确:
      """
      =[
      "Map","HomeAll","ExtendPlatform","RetractPlatform","GotoSlot","GoLoad","HomeR","Open Door","Close Door"
      ]
      """

    场景: OLB下拉列表验证
      当查看"OLB"的下拉列表
      那么"OLB"下拉列表显示正确:
      """
      =[
      "Map","HomeAll","ExtendPlatform","RetractPlatform","GotoSlot","GoLoad","HomeR","Open Door","Close Door"
      ]
      """

    场景: LPI1下拉列表验证
      当查看"LPI1"的下拉列表
      那么"LPI1"下拉列表显示正确:
      """
      =[
      "Recovery","Fetch","LoadCassetteToPlatform","UnloadCassetteFromPlatform","OpenPod","ClosePod","Lock","Unlock"
      ]
      """

    场景: LPI2下拉列表验证
      当查看"LPI2"的下拉列表
      那么"LPI2"下拉列表显示正确:
      """
      =[
      "Recovery","Fetch","LoadCassetteToPlatform","UnloadCassetteFromPlatform","OpenPod","ClosePod","Lock","Unlock"
      ]
      """

    场景: ATP下拉列表验证
      当查看"ATP"的下拉列表
      那么"ATP"下拉列表显示正确:
      """
      =[
      "LeakRate Test","Pump Time Test","Vent Time Test","Base Pressure Test"
      ]
      """

    场景: Centering 界面的Pin按钮状态
      假如centering模块状态为maintain
      当查看"Centering"页面
      那么"Centering"的"Pin Up"按钮处于使能状态,"Pin Down"按钮处于使能状态,"Centering Maintain"按钮处于使能状态

    场景: Centering选项卡中按钮检查
      当查看"Centering"页面
      那么"Centering"页面存在按钮:
      """
      :[
      ...
      "Pin Down",
      "Pin Up",
      "Centering Maintain"
      ...
      ]
      """

    场景: Maintain维护界面中对边腔的针落下操作
      假如centering模块状态为maintain
      当centering执行"Pin Down"操作
      那么操作成功,Pin status状态为:
      """
      ="Down"
      """

    场景: Maintain维护界面中对边腔的针升起操作
      假如centering模块状态为maintain
      当centering执行"Pin Up"操作
      那么操作成功,Pin status状态为:
      """
      ="Up"
      """