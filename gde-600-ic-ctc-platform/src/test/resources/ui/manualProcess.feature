# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
@clean-lower-recipe
@etch1-clean-lower-route
#@skip
功能: manual process

  背景:
    假如存在"defaultEtch1Rcp Recipe":
      | name | rcpClass |
      | test | /Process |

  Rule: Run Process

    @etch1-init
    场景: Run Process提示信息验证
      当Recipe"test"执行"Run Process"
      那么执行成功,弹框提示为:
      """
      ="PM2 run process,are you sure?"
      """

    场景: Run Process未选择recipe提示信息验证
      当Recipe""执行"Run Process"并二次确认
      那么执行失败,弹框提示为:
      """
      = "Please select a recipe!"
      """

    @etch1-init
    场景: Run Process执行成功验证
      假如"PM2"存在晶圆
      当Recipe"test"执行"Run Process"并二次确认
      那么执行成功,Recipe Info列表信息为:
      """
      : {
        RecipeName: test
        ProcessStatus: Processed
      }
      """
      并且Step Info列表信息为:
      """
      = {
        StepId: "1/1"
        StepName: dechuck
        EndType: Time
        StepTime: "2.0"
        ElapseTime: "2.0"
      }
      """

  Rule: RecipeList

    场景: RecipeList下拉列表验证
      当查询RecipeList
      那么RecipeList查询成功:
      """
      = [
        "test"
      ]
      """

  Rule: Abort Process

    场景: Abort Process提示信息验证
      假如"PM2"存在晶圆
      当"Processing"状态的"test"执行"Abort Process"
      那么执行成功,弹框提示为:
      """
      = "Abort PM2 processing,are you sure?"
      """
      并且等待机台状态为"Idle"

    @etch1-init
    场景: Processing状态的Process执行Abort Process验证
      假如"PM2"存在晶圆
      当"Processing"状态的"test"执行"Abort Process"并二次确认
      那么执行成功,Recipe Info列表信息为:
      """
      : {
        RecipeName: test
        ProcessStatus: Aborted
      }
      """

  Rule: Manual Endpoint

    @etch1-init
    场景: Manual Endpoint提示信息验证
      假如"PM2"存在晶圆
      当"Processing"状态的"test"执行"Manual Endpoint"
      那么执行成功,弹框提示为
      """
      = "Manual endpoint now.Are you sure?"
      """
      并且等待机台状态为"Idle"

    @etch1-init
    场景: 单步recipe执行Manual Endpoint验证
      假如"PM2"存在晶圆
      当"Processing"状态的"test"的第"1/1"步执行"Manual Endpoint"
      那么执行成功,Recipe Info列表信息为:
      """
      : {
        RecipeName: test
        ProcessStatus: Processed
      }
      """
      并且ElapseTime不等于StepTime

#      #TODO ci不过
#    @etch1-init
#    场景: 多步recipe执行Manual Endpoint验证
#      假如存在未保存配方:
#        | PMName  | RecipeClass | RecipeName | Parameter | 1       | 2     |
#        | PM2 GDE | Process     | test2      | Step Name | dechuck | step2 |
#      假如修改当前配方并保存:
#        | Step Index | parameter    | value | Type    |
#        | 1          | ProcessTime  | 10    | double  |
#        | 1          | WaferType    | Si    | intlist |
#        | 1          | Pressure(mT) | 1     | double  |
#        | 2          | ProcessTime  | 2     | double  |
#        | 2          | WaferType    | Si    | intlist |
#        | 2          | Pressure(mT) | 1     | double  |
#      假如"PM2"存在晶圆
#      当"Processing"状态的"test2"的第"1/2"步执行"Manual Endpoint"
#      那么Step Info列表信息为:
#      """
#      :{
#      StepId: "2/2"
#      StepName: step2
#      }
#      """
