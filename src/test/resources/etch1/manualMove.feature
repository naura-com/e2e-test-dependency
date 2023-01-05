# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
#@skip
功能: 自动move界面

  Rule: Position

    @etch1-init
#    @etch1-clean-module
    场景: 起始模块Position下拉列表检查-满片
      假如所有模块已全部装载晶圆
      当选择初始模块"LA"模块
      那么初始模块"LA"的Position列表如下:
      """
      =[
      "","slot_1","slot_2","slot_3","slot_4","slot_5","slot_6","slot_7","slot_8",
      "slot_9","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15","slot_16",
      "slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """
      当选择初始模块"LB"模块
      那么初始模块"LB"的Position列表如下:
      """
      =[
      "","slot_1","slot_2","slot_3","slot_4","slot_5","slot_6","slot_7","slot_8",
      "slot_9","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15","slot_16",
      "slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """
      当选择初始模块"TM"模块
      那么初始模块"TM"的Position列表如下:
      """
      =[
      "","ARM A","ARM B"
      ]
      """

#    @etch-reset
    @etch1-clean-module
    场景: 初始模块Position下拉列表检查-多片
      假如模块里面装载了晶圆:
        | LoadLock A | 1 | 3 | 5 | 7 | 9 |
        | LoadLock B | 2 | 3 | 5 | 7 | 9 |
      当选择初始模块"LA"模块
      那么初始模块"LA"的Position列表如下:
      """
      =[
      "","slot_1","slot_3","slot_5","slot_7","slot_9"
      ]
      """
      当选择初始模块"LB"模块
      那么初始模块"LB"的Position列表如下:
      """
      =[
      "","slot_2","slot_3","slot_5","slot_7","slot_9"
      ]
      """

    @etch1-clean-module
    场景: 初始模块Position下拉列表检查-无片
      假如"LoadLock A"未装载晶圆
      假如"LoadLock B"未装载晶圆
      当选择初始模块"LA"模块
      那么初始模块"LA"的Position列表如下:
      """
      =[
      ""
      ]
      """
      当选择初始模块"LB"模块
      那么初始模块"LB"的Position列表如下:
      """
      =[
      ""
      ]
      """

    @etch1-clean-module
    场景: 目的模块Position下拉列表检查
      假如所有模块均无晶圆存在
      当选择目的模块"LA"模块
      那么目的模块"LA"的Position列表如下:
      """
      =[
      "","slot_1","slot_2","slot_3","slot_4","slot_5","slot_6","slot_7","slot_8",
      "slot_9","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15","slot_16",
      "slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """
      当选择目的模块"LB"模块
      那么目的模块"LB"的Position列表如下:
      """
      =[
      "","slot_1","slot_2","slot_3","slot_4","slot_5","slot_6","slot_7","slot_8",
      "slot_9","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15","slot_16",
      "slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """
      当选择目的模块"TM"模块
      那么目的模块"TM"的Position列表如下:
      """
      =[
      "","ARM A","ARM B"
      ]
      """

#    @etch-reset
    场景: 初始和目的模块Position下拉列表检查-多片
      假如模块里面装载了晶圆:
        | LoadLock A | 1 | 3 | 5 | 7 | 9 |
        | LoadLock B | 2 | 3 | 5 | 7 | 9 |
      当选择初始模块"LA"模块
      那么初始模块"LA"的Position列表如下:
      """
      =[
      "","slot_1","slot_3","slot_5","slot_7","slot_9"
      ]
      """
      并且目的模块"LA"的Position列表如下:
      """
      =[
      "","slot_2","slot_4","slot_6","slot_8","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15",
      "slot_16","slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """
      当选择初始模块"LB"模块
      那么初始模块"LB"的Position列表如下:
      """
      =[
      "","slot_2","slot_3","slot_5","slot_7","slot_9"
      ]
      """
      并且目的模块"LB"的Position列表如下:
      """
      =[
      "","slot_1","slot_4","slot_6","slot_8","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15",
      "slot_16","slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """

  Rule: Module

    场景: 初始模块Module文本框正确显示验证
      当选择初始模块"PM2"模块
      那么初始模块Module文本框正确显示"PM2"模块名:
      """
      ="PM2"
      """
      当选择初始模块"TM"模块
      那么初始模块Module文本框正确显示"TM"模块名:
      """
      ="TR1"
      """
      当选择初始模块"AL"模块
      那么初始模块Module文本框正确显示"AL"模块名:
      """
      ="AL"
      """
      当选择初始模块"Center"模块
      那么初始模块Module文本框正确显示"Center"模块名:
      """
      ="CENTERING"
      """
      当选择初始模块"LA"模块
      那么初始模块Module文本框正确显示"LA"模块名:
      """
      ="P1"
      """
      当选择初始模块"LB"模块
      那么初始模块Module文本框正确显示"LB"模块名:
      """
      ="P2"
      """

    场景: 目的模块Module文本框正确显示验证
      当选择目的模块"PM2"模块
      那么目的模块Module文本框正确显示"PM2"模块名:
      """
      ="PM2"
      """
      当选择目的模块"TM"模块
      那么目的模块Module文本框正确显示"TM"模块名:
      """
      ="TR1"
      """
      当选择目的模块"AL"模块
      那么目的模块Module文本框正确显示"AL"模块名:
      """
      ="AL"
      """
      当选择目的模块"Center"模块
      那么目的模块Module文本框正确显示"Center"模块名:
      """
      ="CENTERING"
      """
      当选择目的模块"LA"模块
      那么目的模块Module文本框正确显示"LA"模块名:
      """
      ="P1"
      """
      当选择目的模块"LB"模块
      那么目的模块Module文本框正确显示"LB"模块名:
      """
      ="P2"
      """

  Rule: Move

    @etch1-init
    场景: 目的模块Position为空
      假如模块里面装载了晶圆:
        | LoadLock A | 1 |
      当选择初始模块"LA",Position选择"slot_1"
      当选择目的模块"LB"模块,Position选择""
      并且执行Move操作
      那么操作失败，弹框提示为:
      """
      ="Please input right information!"
      """

    场景: 初始模块Position为空
      假如模块里面装载了晶圆:
        | LoadLock A | 1 |
      当选择初始模块"LA",Position选择""
      当选择目的模块"LB"模块,Position选择"slot_2"
      并且执行Move操作
      那么操作失败，弹框提示为:
      """
      ="Please input right information!"
      """

    场景: 初始模块和目的模块相同
      假如模块里面装载了晶圆:
        | LoadLock A | 1 |
      当选择初始模块"LA",Position选择"slot_1"
      当选择目的模块"LA"模块,Position选择"slot_2"
      并且执行Move操作
      那么操作失败，弹框提示为:
      """
      ="Please select two different modules"
      """

    场景: Move正确提示信息验证
      假如模块里面装载了晶圆:
        | LoadLock A | 1 |
      当选择初始模块"LA",Position选择"slot_1"
      当选择目的模块"LB"模块,Position选择"slot_2"
      并且执行Move操作
      那么操作成功,弹框提示信息为:
      """
      ="Please check the following items before manual move: \r\n(1) Make sure the position view of wafers in software UI is identical with the actual situation. If not, you should synchronize wafer position first in [Wafer Synchronization] page."
      """

#    @etch1-init
    @etch1-clean-module
    场景: Move正确验证-目的模块无晶圆
      假如模块里面装载了晶圆:
        | LoadLock A | 1 |
      当选择初始模块"LA",Position选择"slot_1"
      当选择目的模块"LB"模块,Position选择"slot_2"
      并且执行Move操作且二次确认
      那么操作成功,初始模块"LA"的Position列表如下:
      """
      =[
      ""
      ]
      """
      并且目的模块"LB"的Position列表如下:
      """
      =[
      "","slot_1","slot_3","slot_4","slot_5","slot_6","slot_7","slot_8",
      "slot_9","slot_10","slot_11","slot_12","slot_13","slot_14","slot_15","slot_16",
      "slot_17","slot_18","slot_19","slot_20","slot_21","slot_22","slot_23","slot_24","slot_25"
      ]
      """
      并且初始模块"LB"的Position列表如下:
      """
      =[
      "","slot_2"
      ]
      """

#    @etch1-init
    场景: Move正确验证-初始模块和目的模块均有晶圆
      假如模块里面装载了晶圆:
        | LoadLock A | 1 |
        | TM         | 1 |
      当选择初始模块"LA",Position选择"slot_1"
      当选择目的模块"TM"模块,Position选择"ARM B"
      并且执行Move操作且二次确认
      那么操作成功,初始模块"LA"的Position列表如下:
      """
      =[
      ""
      ]
      """
      并且目的模块"TM"的Position列表如下:
      """
      =[
      ""
      ]
      """
      并且初始模块"TM"的Position列表如下:
      """
      =[
      "","ARM A","ARM B"
      ]
      """

