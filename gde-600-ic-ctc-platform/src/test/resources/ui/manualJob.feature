# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
@clean-lower-recipe
#@etch1-clean-lower-route
#@skip
功能: 自动job界面

  背景:
    假如存在"defaultEtch1Rcp Recipe":
      | name | rcpClass |
      | test | /Process |
    假如存在如下已保存路径"PM2Process":
      | 步骤 | 腔室      | 配方   |
      | 1  | PM2 GDE | test |

  Rule: Set Waferflow

    @etch1-clean-lower-route
#    @clean-lower-recipe
    场景: Set Waferflow列表验证
      当"LoadLock A"执行Set Waferflow操作后
      那么列表显示为:
      """
      =["PM2Process"]
      """
      当"LoadLock B"执行Set Waferflow操作后
      那么列表显示为:
      """
      =["PM2Process"]
      """

#    @etch1-clean-lower-route
    场景大纲: Set Waferflow列表验证:<title>
      当执行Set Waferflow操作后
        | <LoadLock> |
      那么列表显示为:
      """
      =[<verification>]
      """
      例子:
        | title      | LoadLock   | verification |
        | LoadLock A | LoadLock A | PM2Process   |
        | LoadLock B | LoadLock B | PM2Process   |

#    @etch1-clean-lower-route
    场景: LoadLock A的Set Waferflow设置成功验证
      当LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock A | 1        | PM2Process |
      那么"LoadLock A"执行Set Waferflow操作成功:
      """
      : {
        "1": "PM2Process"
      }
      """

#    @etch1-clean-lower-route
    场景: LoadLock A的Set Waferflow设置不同route成功验证
      假如存在已保存路径"PM2Process-2":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow    |
        | LoadLock A | 1        | PM2Process   |
        | LoadLock A | 2        | PM2Process-2 |
      那么"LoadLock A"执行Set Waferflow操作成功:
      """
      : {
        "1": "PM2Process",
        "2": "PM2Process-2"
      }
      """

#    @etch1-clean-lower-route
    场景: LoadLock B的Set Waferflow设置成功验证
      当LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock B | 1        | PM2Process |
      那么"LoadLock B"执行Set Waferflow操作成功:
      """
      : {
        "1": "PM2Process"
      }
      """

#    @etch1-clean-lower-route
    场景: LoadLock B的Set Waferflow设置不同route成功验证
      假如存在已保存路径"PM2Process-2":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow    |
        | LoadLock B | 1        | PM2Process   |
        | LoadLock B | 2        | PM2Process-2 |
      那么"LoadLock B"执行Set Waferflow操作成功:
      """
      : {
        "1": "PM2Process",
        "2": "PM2Process-2"
      }
      """

    @etch1-clean-lower-route
    @etch-reset
    场景: LoadLock A和LoadLock B的Set Waferflow设置不同route成功验证
      假如存在已保存路径"PM2Process-2":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow    |
        | LoadLock A | 1        | PM2Process   |
        | LoadLock B | 2        | PM2Process-2 |
      那么"LoadLock A"执行Set Waferflow操作成功:
      """
      : {
        "1": "PM2Process"
      }
      """
      那么"LoadLock B"执行Set Waferflow操作成功:
      """
      : {
        "2": "PM2Process-2"
      }
      """

  Rule: Del Waferflow

    @etch-reset
    @etch1-clean-lower-route
    场景: 单个LoadLock执行Del Waferflow成功
      假如LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock A | 1        | PM2Process |
      当LoadLock执行Del Waferflow操作:
        | LoadLock   | wafer ID |
        | LoadLock A | 1        |
      那么"LoadLock A"执行Del Waferflow操作成功:
      """
      : {
        "1": ""
      }
      """

#    @etch1-clean-lower-route
    场景: 多个LoadLock执行Del Waferflow成功
      假如存在已保存路径"PM2Process-2":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      假如LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow    |
        | LoadLock A | 1        | PM2Process   |
        | LoadLock B | 2        | PM2Process-2 |
      当LoadLock执行Del Waferflow操作:
        | LoadLock   | wafer ID |
        | LoadLock A | 1        |
        | LoadLock B | 2        |
      那么"LoadLock A"执行Del Waferflow操作成功:
      """
      : {
        "1": ""
      }
      """
      那么"LoadLock B"执行Del Waferflow操作成功:
      """
      : {
        "1": ""
      }
      """

#    @etch1-clean-lower-route
    场景: 单个LoadLock多次执行Del Waferflow成功
      假如LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock A | 1        | PM2Process |
        | LoadLock A | 3        | PM2Process |
      当LoadLock执行Del Waferflow操作:
        | LoadLock   | wafer ID |
        | LoadLock A | 1        |
        | LoadLock A | 3        |
      那么"LoadLock A"执行Del Waferflow操作成功:
      """
      : {
        "1": "",
        "3": ""
      }
      """

  Rule: Lot ID

#    @etch1-clean-lower-route
    场景: Lot ID设置成功
      当设置"LoadLock A"的Lot ID为"1"
      那么"LoadLock A"的Lot ID设置成功:
      """
      = "1"
      """
      当设置"LoadLock A"的Lot ID为"1111111111"
      那么"LoadLock A"的Lot ID设置成功:
      """
      = "1111111111"
      """
      当设置"LoadLock B"的Lot ID为"~!@#$%^&*()"
      那么"LoadLock B"的Lot ID设置成功:
      """
      = "~!@#$%^&*()"
      """
      当设置"LoadLock A"的Lot ID为"合法"
      那么"LoadLock A"的Lot ID设置成功:
      """
      = "合法"
      """

  Rule: Set Map Wfr

    @etch1-reset
    @etch1-clean-lower-route
    场景: 列表验证
      当"LoadLock A"执行Set Map Waferflow操作后
      那么列表显示为:
        """
        = [
          "PM2Process"
          ]
        """
      当"LoadLock B"执行Set Map Waferflow操作后
      那么列表显示为:
        """
        = [
          "PM2Process"
          ]
        """

#    @etch1-clean-lower-route
    场景: A成功设置Set Map Waferflow
      假如"LoadLock A"全部晶圆装载
      当"LoadLock A"选中"PM2Process"执行Set Map Waferflow操作
      那么"LoadLock A"执行Set Map Waferflow操作成功:
      """
      : {
        "1": "PM2Process",
        "2": "PM2Process",
        "3": "PM2Process",
        "4": "PM2Process",
        "5": "PM2Process",
        "6": "PM2Process",
        "7": "PM2Process",
        "8": "PM2Process",
        "9": "PM2Process",
        "10": "PM2Process",
        "11": "PM2Process",
        "12": "PM2Process",
        "13": "PM2Process",
        "14": "PM2Process",
        "15": "PM2Process",
        "16": "PM2Process",
        "17": "PM2Process",
        "18": "PM2Process",
        "19": "PM2Process",
        "20": "PM2Process",
        "21": "PM2Process",
        "22": "PM2Process",
        "23": "PM2Process",
        "24": "PM2Process",
        "25": "PM2Process"
      }
      """

#    @etch1-clean-lower-route
    场景: B成功设置Set Map Waferflow
      假如"LoadLock B"全部晶圆装载
      当"LoadLock B"选中"PM2Process"执行Set Map Waferflow操作
      那么"LoadLock B"执行Set Map Waferflow操作成功:
      """
      : {
        "1": "PM2Process",
        "2": "PM2Process",
        "3": "PM2Process",
        "4": "PM2Process",
        "5": "PM2Process",
        "6": "PM2Process",
        "7": "PM2Process",
        "8": "PM2Process",
        "9": "PM2Process",
        "10": "PM2Process",
        "11": "PM2Process",
        "12": "PM2Process",
        "13": "PM2Process",
        "14": "PM2Process",
        "15": "PM2Process",
        "16": "PM2Process",
        "17": "PM2Process",
        "18": "PM2Process",
        "19": "PM2Process",
        "20": "PM2Process",
        "21": "PM2Process",
        "22": "PM2Process",
        "23": "PM2Process",
        "24": "PM2Process",
        "25": "PM2Process"
      }
      """

#    @etch1-clean-lower-route
    场景: A 部分装载的SetMapWfr
      假如"LoadLock A"里面装载了晶圆:
        | 1 | 2 | 3 | 4 | 5 |
      当"LoadLock A"选中"PM2Process"执行Set Map Waferflow操作
      那么"LoadLock A"执行Set Map Waferflow操作成功:
      """
      : {
        "1": "PM2Process",
        "2": "PM2Process",
        "3": "PM2Process",
        "4": "PM2Process",
        "5": "PM2Process",
        "6": "",
        "7": ""
      }
      """

#    @etch1-clean-lower-route
    场景: B 部分装载的SetMapWfr
      假如"LoadLock B"里面装载了晶圆:
        | 1 | 2 | 3 | 4 | 5 |
      当"LoadLock B"选中"PM2Process"执行Set Map Waferflow操作
      那么"LoadLock B"执行Set Map Waferflow操作成功:
      """
      : {
        "1": "PM2Process",
        "2": "PM2Process",
        "3": "PM2Process",
        "4": "PM2Process",
        "5": "PM2Process",
        "6": "",
        "7": ""
      }
      """

#    @etch1-clean-lower-route
    场景: ClearAll A all
      假如"LoadLock A"全部晶圆装载
      并且"LoadLock A"选中"PM2Process"执行Set Map Waferflow操作
      当"LoadLock A"执行Clear All操作
      那么"LoadLock A"执行Clear All操作成功:
      """
      : {
        "1": "",
        "2": "",
        "3": "",
        "4": "",
        "5": "",
        "6": "",
        "7": "",
        "8": "",
        "9": "",
        "10": "",
        "11": "",
        "12": "",
        "13": "",
        "14": "",
        "15": "",
        "16": "",
        "17": "",
        "18": "",
        "19": "",
        "20": "",
        "21": "",
        "22": "",
        "23": "",
        "24": "",
        "25": ""
      }
      """

#    @etch1-clean-lower-route
    场景: ClearAll B all
      假如"LoadLock B"全部晶圆装载
      并且"LoadLock B"选中"PM2Process"执行Set Map Waferflow操作
      当"LoadLock B"执行Clear All操作
      那么"LoadLock B"执行Clear All操作成功:
      """
      : {
        "1": "",
        "2": "",
        "3": "",
        "4": "",
        "5": "",
        "6": "",
        "7": "",
        "8": "",
        "9": "",
        "10": "",
        "11": "",
        "12": "",
        "13": "",
        "14": "",
        "15": "",
        "16": "",
        "17": "",
        "18": "",
        "19": "",
        "20": "",
        "21": "",
        "22": "",
        "23": "",
        "24": "",
        "25": ""
      }
      """

#    @etch1-clean-lower-route
    场景: ClearAll A JustOne
      假如LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock A | 1        | PM2Process |
      当"LoadLock A"执行Clear All操作
      那么"LoadLock A"执行Clear All操作成功:
      """
      : {
        "1": ""
      }
      """

#    @etch1-clean-lower-route
    场景: ClearAll B JustOne
      假如LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock B | 1        | PM2Process |
      当"LoadLock B"执行Clear All操作
      那么"LoadLock B"执行Clear All操作成功:
      """
      : {
        "1": ""
      }
      """

  Rule: Schedule Mode

#    @etch1-clean-lower-route
    场景: LoadLock A的Schedule Mode下拉列表验证
      当查看"LoadLock A"的Schedule Mode
      那么"LoadLock A"Schedule Mode下拉框显示内容为:
      """
      = [
        "Smart",
        "Concurrent",
        "Pipelined",
        "Sequential"
      ]
      """

#    @clean-lower-recipe
    @etch-reset
#    @etch1-clean-lower-route
    场景: LoadLock B的Schedule Mode下拉列表验证
      当查看"LoadLock B"的Schedule Mode
      那么"LoadLock B"Schedule Mode下拉框显示内容为:
      """
      = [
        "Smart",
        "Concurrent",
        "Pipelined",
        "Sequential"
      ]
      """

  Rule: Cycle Num

#    @clean-lower-recipe
    @etch-reset
#    @etch1-clean-lower-route
    场景: 设置Cycle Num验证
      当"LoadLock A"设置"Cycle Num"为"1"
      那么"LoadLock A"的"Cycle Num"设置成功:
      """
      =["01"]
      """
      当"LoadLock B"设置"Cycle Num"为"25"
      那么"LoadLock B"的"Cycle Num"设置成功:
      """
      =["025"]
      """
      当"LoadLock A"设置"Cycle Num"为"-"
      那么"LoadLock A"的"Cycle Num"设置成功:
      """
      =["0"]
      """

  Rule: Start

    场景: 未设置waferflow执行start
      假如设置"LoadLock A"的Lot ID为"1",未设置waferflow
      当"LoadLock A"执行"Start"操作
      那么操作失败,失败信息为:
      """
      ="The current Job1 information is not integrated!"
      """

    @etch-reset
    场景: 未设置Lot ID执行start
      当LoadLock执行Set Waferflow操作:
        | LoadLock   | wafer ID | waferFlow  |
        | LoadLock A | 1        | PM2Process |
      假如设置"LoadLock A"的Lot ID为""
      当"LoadLock A"执行"Start"操作
      那么操作失败,失败信息为:
      """
      = "LotID is invalid!"
      """

    @skip
    @etch-reset
    @etch1-init
#    @etch1-load-synWithCTC
#    @etch1-PostAlarmForExtraWafers
    场景: LoadLock A正常Start单片单job
      假如LoadLock存在单片job:
        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
        | LoadLock A | 1        | PM2Process | 1      | 1         |
      当"LoadLock A"执行"Start"操作
      那么"LoadLock A"执行"Start"操作成功:
      """
      = [
        "job1",
        "Running",
        "1",
        "1"
      ]
      """
      并且"LoadLock A"的job正常执行结束:
      """
      = [
        "job1",
        "JobCompleted",
        "1",
        "0"
      ]
      """

#TODO ci不跑
#    @etch1-load-synWithCTC
#    场景: LoadLock B正常Start单片单job
#      假如LoadLock存在单片job:
#        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
#        | LoadLock B | 1        | PM2Process | 1      | 1         |
#      当"LoadLock B"执行"Start"操作
#      那么"LoadLock B"执行"Start"操作成功:
#      """
#      =[
#      "job2",
#      "Running",
#      "1",
#      "1"
#      ]
#      """
#      并且"LoadLock B"的job正常执行结束:
#      """
#      =[
#      "job2",
#      "JobCompleted",
#      "1",
#      "0"
#      ]
#      """
#
#    @etch1-load-synWithCTC
#    场景: LoadLock正常Start单片多job
#      假如LoadLock存在单片job:
#        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
#        | LoadLock A | 1        | PM2Process | 1      | 1         |
#        | LoadLock B | 1        | PM2Process | 2      | 1         |
#      当"LoadLock A"执行"Start"操作
#      那么"LoadLock A"执行"Start"操作成功:
#      """
#      =[
#      "job1","Running","1","1"
#      ]
#      """
#      当"LoadLock B"执行"Start"操作
#      那么"LoadLock B"执行"Start"操作成功
#      """
#      =[
#      "job2","Validated","2","1"
#      ]
#      """
#      并且"LoadLock A"的job正常执行结束:
#      """
#      =[
#      "job1","JobCompleted","1","0"
#      ]
#      """
#      并且"LoadLock B"的job正常执行结束:
#      """
#      =[
#      "job2","JobCompleted","2","0"
#      ]
#      """

  #TODO ci暂时不跑
#    @etch1-load-synWithCTC
#    场景: LoadLock正常Start满片多job
#      假如LoadLock存在满片job:
#        | LoadLock   | waferFlow  | Lot ID | Cycle Num |
#        | LoadLock A | PM2Process | 1      | 1         |
#        | LoadLock B | PM2Process | 1      | 1         |
#      当"LoadLock A"执行"Start"操作
#      那么"LoadLock A"执行"Start"操作成功:
#      """
#      =[
#      "job1","Running","1","1"
#      ]
#      """
#      当"LoadLock B"执行"Start"操作
#      那么"LoadLock B"执行"Start"操作成功
#      """
#      =[
#      "job2","Validated","1","1"
#      ]
#      """
#      并且"LoadLock A"的job正常执行结束:
#      """
#      =[
#      "job1","JobCompleted","1","0"
#      ]
#      """
#      并且"LoadLock B"的job正常执行结束:
#      """
#      =[
#      "job2","JobCompleted","1","0"
#      ]
#      """

  Rule: End

#    @etch-reset
#    @etch1-init
#    场景: Running状态的job执行End提示信息验证
#      假如LoadLock存在Running状态的job:
#        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
#        | LoadLock A | 1        | PM2Process | 1      | 1         |
#      当"LoadLock A"执行"End"操作:
#      那么操作成功,成功提示信息为:
#      """
#      ="Do you want to end the job1 ? (Wafers left source will continue to run waferflow while others stay in source.)"
#      """

    @skip
    @etch-reset
#    @clean-lower-recipe
#    @etch1-clean-lower-route
    @etch1-init
    场景: Running状态的job执行End成功验证
      假如LoadLock存在Running状态的job:
        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
        | LoadLock A | 1        | PM2Process | 1      | 1         |
      当"LoadLock A"执行"End"操作
      那么"LoadLock A"执行"End"操作成功:
      """
      = [
        "job1",
        "Aborted",
        "1",
        "0"
      ]
      """

  Rule: Abort

#    #TODO
#    @etch-reset
#    @etch1-init
##    @etch1-clean-LPA-job1
#    场景: Running状态的job执行Abort提示信息验证
#      假如LoadLock存在Running状态的job:
#        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
#        | LoadLock A | 1        | PM2Process | 1      | 1         |
#      当"LoadLock A"执行"Abort"操作:
#      那么操作成功,成功提示信息为:
#      """
#      ="Do you want to abort the job1 ? (Wafers unprocessed will return to source directly, processing wafer do so after end of the process.)"
#      """

    @skip
    @etch-reset
#    @clean-lower-recipe
#    @etch1-clean-lower-route
    @etch1-init
    场景: Running状态的job执行Abort成功验证
      假如LoadLock存在Running状态的job:
        | LoadLock   | wafer ID | waferFlow  | Lot ID | Cycle Num |
        | LoadLock A | 1        | PM2Process | 1      | 1         |
      当"LoadLock A"执行"Abort"操作
      那么"LoadLock A"执行"Abort"操作成功:
      """
      = [
        "job1",
        "Aborted",
        "1",
        "0"
      ]
      """


