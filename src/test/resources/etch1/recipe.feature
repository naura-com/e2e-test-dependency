# language: zh-CN
@ETCH-PM2-lower
@clean-lower-recipe
@etch1-ui
@reset-feature-ui
#@skip
功能: 工艺配方界面

  Rule:配方创建时间控件

    @etch1-clean-lower-route
    场景: 创建时间控件显示为配方创建时间
      假如创建"PM2 GDE"的"DryClean"的配方"test"
      那么查询到配方"test"的创建时间为:
      """
      is AlmostNow
      """

  Rule: 步骤复制功能

    @clean-lower-recipe
    @etch-reset
    场景: 验证Rcp复制步骤时目的步骤下拉框选项
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当复制Recipe步骤的第一步
      那么复制目的步骤返回如下:
      """
      =[step1,step2,step3]
      """

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 复制选中步骤到指定步骤
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | 1step | 2step | 3step |
      当复制Recipe步骤的步骤"2"到步骤"3"时
      那么步骤"3"和步骤"2"内容一致

    @clean-lower-recipe
    @etch-reset
    场景: 未选中步骤验证步骤CopyTo..功能
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当未选中步骤执行步骤"Copy To.."操作
      那么执行失败,异常信息为:
      """
      ="Please select a column!"
      """

  Rule: 步骤删除功能

    @clean-lower-recipe
    @etch-reset
    场景: 不选择步骤删除步骤功能验证
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当未选中步骤执行步骤"Delete Step"操作
      那么执行失败,异常信息为:
      """
      = "Select a column first!"
      """

    @clean-lower-recipe
    @etch-reset
    场景: 验证删除第一步后的列名
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当删除步骤"1"并二次确定
      那么步骤列名返回如下
      """
      =[
        左上方标题单元格
        Parameter,
        1,
        2
        ]
      """
      并且"Parameter"的StepName参数如下:
      """
      : {
        1: step2
        2: step3
        }
      """

    @clean-lower-recipe
    @etch-reset
    场景: 验证删除步骤时有二次确认提示
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当删除步骤"3"时:
      那么执行成功,提示信息为:
      """
      = 'Do you want to delete the step ?'
      """

  Rule: 步骤新建功能

    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    场景:新建第二步
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     |
        | Step Name | step1 |
      当新建步骤"step2"时
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step1
        2: step2
        }
      """

    场景:新建名为空的步骤
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     |
        | Step Name | step1 |
      当新建步骤""时
      那么执行新建失败,异常信息为:
      """
      = "Please input the new name!"
      """

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 新建重名步骤配方
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     |
        | Step Name | step1 |
      当新建步骤"step1"时
      那么执行失败,异常信息为:
      """
      = "This step name has existed, please re-enter the name!"
      """

    @clean-lower-recipe
    @etch-reset
    场景: process类型重复新建dechuck步
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName  | Parameter | 1       |
        | PM2 GDE | Process     | rcpNotSaved | Step Name | dechuck |
      当新建步骤"dechuck"时
      那么执行失败,异常信息为:
      """
      = "This step name has existed, please re-enter the name!"
      """

  #TODO:新换的这个项目其他用户无创建配方权限
#  Rule: 配方创建者控件
#
#    @clean-lower-recipe
#    @etch-reset
#    场景: op创建配方显示为op
#      假如密码为"888888"的用户"op"重新登录
#      当创建"PM2 GDE"的"DryClean"的配方"test"
#      那么能查询到配方创建者为"op"

  Rule: 步骤移动功能

    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    场景:步骤1移动到步骤3之前
      假如在"PM2 GDE"的"DryClean"存在配方"MoveStep":
        | Parameter | 1     | 2     | 3     |
        | StepName  | step1 | step2 | step3 |
      当移动步骤"1"到步骤"3"之"前"
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step2
        2: step1
        3: step3
        }
      """

    @Etch1-clean-allCreate-recipe
    场景:步骤1移动到步骤3之后
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | StepName  | step1 | step2 | step3 |
      当移动步骤"1"到步骤"3"之"后"
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step2
        2: step3
        3: step1
        }
      """

    @Etch1-clean-allCreate-recipe
    场景:复杂移动场景的正确性-向前移动
      假如在"PM2 GDE"的"DryClean"存在配方"test2":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当移动步骤"3"到步骤"1"之"前"
      并且移动步骤"2"到步骤"1"之"前"
      并且移动步骤"1"到步骤"3"之"前"
      并且移动步骤"1"到步骤"2"之"前"
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step1
        2: step3
        3: step2
        }
      """

#    @Etch1-clean-allCreate-recipe
    场景:复杂移动场景的正确性-向后移动
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      当移动步骤"3"到步骤"1"之"后"
      并且移动步骤"2"到步骤"1"之"后"
      并且移动步骤"1"到步骤"3"之"后"
      并且移动步骤"1"到步骤"2"之"后"
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step1
        2: step2
        3: step3
        }
      """

  Rule: 界面显示

    @clean-lower-recipe
    @etch-reset
    场景: 所有一级RcpClass存在Recipe,界面能否显示
      假如存在"Recipe":
        | name   | rcpClass  | comments |
        | ProRcp | /Process  | a        |
        | DryRcp | /DryClean | a        |
      那么查看"PM2 GDE"的"Process"的配方列表如下:
      """
      =["ProRcp"]
      """
      那么查看"PM2 GDE"的"Dryclean"的配方列表如下:
      """
      =["DryRcp"]
      """

  Rule: 新建配方切换recipe

    @etch-reset
    @clean-lower-recipe
    场景: 新建未保存配方切换RecipeClass
      假如在"PM2 GDE"的"DryClean"存在配方"test":
        | Parameter | 1     | 2     |
        | Step Name | step1 | step2 |
      当切换RecipeType为"Process"
      那么执行失败,异常信息为
      """
      ='test is not saved.Do you want to save first?'
      """

    @etch-reset
    @clean-lower-recipe
    @Etch1-clean-allCreate-recipe
    场景: 保存配方后切换recipeType
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1       | 2           |
        | PM2 GDE | DryClean    | test1      | Step Name | step1   | step2       |
        | PM2 GDE | Process     | test2      | Step Name | dechuck | changeStep2 |
      当切换RecipeType为"DryClean"
      并且切换Recipe为"test1"
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step1
        2: step2
        }
      """

    @Etch1-clean-allCreate-recipe
    场景: 保存配方后切换recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2           |
        | PM2 GDE | DryClean    | test1      | Step Name | step1 | step2       |
        | PM2 GDE | DryClean    | test2      | Step Name | step1 | changeStep2 |
      当切换Recipe为"test1"
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step1
        2: step2
        }
      """

    场景: 新建未保存配方切换Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName   | Parameter | 1               | 2               |
        | PM2 GDE | DryClean    | rcpNot-saved | Step Name | not-saced-step1 | not-saced-step1 |
      当切换Recipe为"rcpSaved"
      那么执行失败,异常信息为
      """
      = 'rcpNot-saved is not saved.Do you want to save first?'
      """

  Rule: 编辑配方参数未保存切换RecipeClass

    @clean-lower-recipe
    @etch-reset
    场景:验证编辑配方参数未保存切换RecipeClass
      假如创建"PM2 GDE"的"Process"的配方"rcpNot-saved"
      当修改"test"的步骤1的"StepName"为"dechuck":
      当切换RecipeType为"DryClean"
      那么执行失败,异常信息为
      """
      = 'rcpNot-saved is not saved.Do you want to save first?'
      """

    @clean-lower-recipe
    @etch-reset
    场景: 新建未保存配方切换RecipeClass配方列表验证
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1       | 2     |
        | PM2 GDE | Process     | rcpSaved   | Step Name | dechuck | step2 |
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName   | Parameter | 1               | 2               |
        | PM2 GDE | DryClean    | rcpNot-saved | Step Name | not-saved-step1 | not-saved-step2 |
      当修改"rcpNot-saved"的步骤1的"StepName"为"dechuck":
      并且切换RecipeType为"Process"不保存
      那么查看"PM2 GDE"的"Process"的配方列表如下:
      """
      = ['rcpSaved']
      """

  Rule: 编辑配方参数未保存切换Recipe

    @clean-lower-recipe
    @etch-reset
    场景: 新建未保存配方切换Recipe异常信息验证
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName   | Parameter | 1               | 2               |
        | PM2 GDE | DryClean    | rcpNot-saved | Step Name | not-saved-step1 | not-saved-step2 |
      当修改"rcpNot-saved"的步骤1的"StepName"为"modeifyStep":
      并且切换Recipe为"rcpSaved"
      那么执行失败,异常信息为
      """
      = 'rcpNot-saved is not saved.Do you want to save first?'
      """

    @clean-lower-recipe
    @etch-reset
    场景: 新建未保存配方切换Recipe当前步骤验证
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName   | Parameter | 1               | 2               |
        | PM2 GDE | DryClean    | rcpNot-saved | Step Name | not-saved-step1 | not-saved-step2 |
      当修改"rcpNot-saved"的步骤1的"StepName"为"modeifyStep":
      并且切换Recipe为"rcpSaved"不保存
      那么"Parameter"的StepName参数如下:
      """
      : {
        1: step1
        2: step2
        }
      """

  Rule:保存配方

    @clean-lower-recipe
    @etch-reset
    场景: 新建配方会自动保存
      当创建"PM2 GDE"的"Process"的配方"test"
      那么成功保存到下位机"/Process/test;1":
      """
      : {
          name: 'test',
          rcpClass: '/Process',
          version: '1',
          attrChgTime is AlmostNow,
          editTime is AlmostNow,
          verified: true,
          linked: false,
          editedBy: 'sa',
          approvalLvl: 0,
          body: {
            steps: []
          }
        }
      """

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 修改StepName参数并保存
      假如创建"PM2 GDE"的"Process"的配方"test"
      当修改"test"的步骤1的"StepName"为"dechuck":
      并且执行Recipe的"Save"操作
      那么保存配方成功,提示:
      """
      = "Recipe:test was saved successfully!"
      """
      并且成功保存到下位机"/Process/test;1":
      """
      : {
          body:  {
              steps: [
                      {
                        name: 'dechuck',
                        values: [...
                                ]
                      }
                    ]
                  }
        }
      """

    @clean-lower-recipe
    @etch-reset
    场景: 修改StepName参数与comments并保存
      假如创建"PM2 GDE"的"Process"的配方"test"
      当修改"test"的步骤1的"StepName"为"dechuck"
      并且修改comments为"comments"
      并且执行Recipe的"Save"操作
      那么保存配方成功,提示:
      """
      = "Recipe:test was saved successfully!"
      """
      并且成功保存到下位机"/Process/test;1":
      """
      : {
          comments=/.*comments.*/
          body:  {
              steps: [
                      {
                        name: 'dechuck',
                        values: [...
                                ]
                      }
                    ]
                  }
        }
      """

    @clean-lower-recipe
    @etch-reset
    场景: 修改StepName参数与value内的参数并保存
      假如创建"PM2 GDE"的"Process"的配方"test"
      当修改"test"的步骤1的"StepName"为"dechuck"
      并且修改"test"的步骤1的"ProcessTime"为"10"
      并且执行Recipe的"Save"操作
      那么保存配方成功,提示:
      """
      = "Recipe:test was saved successfully!"
      """
      并且成功保存到下位机"/Process/test;1":
      """
      : {
          body:  {
              steps: [
                      {
                        name: 'dechuck',
                        values: [...
                                  "10"
                                ...]
                      }
                     ]
                  }
        }
      """

    @clean-lower-recipe
    @etch-reset
    场景: 配方非法输入TXT校验
      假如创建"PM2 GDE"的"Process"的配方"test"
      并且修改"test"的步骤1的"StepName"为"dechuck":
#  这里是为了激活Save的使能,否则无法进行保存操作
      当修改"test"的步骤1的"Ar"为"1000":
      并且执行Recipe的"Save"操作
      那么保存配方失败,提示
      """
      = "There are errors in current recipe, please check param values and dechuck step!"
      """

    @clean-lower-recipe
    @etch-reset
    场景: 配方非法输入COMB校验
      假如创建"PM2 GDE"的"Process"的配方"test"
      并且修改"test"的步骤1的"StepName"为"dechuck":
#  这里是为了激活Save的使能,否则无法进行保存操作
      当修改"test"的步骤1的"WaferType"为"useless":
      并且执行Recipe的"Save"操作
      那么保存配方失败,提示
      """
      = "Save recipe:test  failed!"
      """

    @clean-lower-recipe
    @etch-reset
    场景: process类型无dechuck步的save
      假如存在未保存配方
        | PMName  | RecipeClass | RecipeName  | Parameter | 1     | 2     |
        | PM2 GDE | Process     | rcpNotSaved | Step Name | step1 | step2 |
      当执行Recipe的"Save"操作
      那么执行失败,异常信息为:
      """
      = "There are errors in current recipe, please check param values and dechuck step!"
      """

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 保存为带有符号的名字
      假如创建"PM2 GDE"的"Process"的配方"-test"
      当修改"-test"的步骤1的"StepName"为"dechuck":
      并且执行Recipe的"Save"操作
      那么保存配方成功,提示:
      """
      = "Recipe:-test was saved successfully!"
      """
      并且成功保存到下位机"/Process/-test;1":
      """
      : {
          body:  {
              steps: [
                      {
                        name: 'dechuck',
                        values: [...
                                ]
                      }
                    ]
                  }
        }
      """

  Rule:新建配方

    @clean-lower-recipe
    @etch-reset
    场景: 新建配方成功
      当创建"PM2 GDE"的"Process"的配方"test"
      那么配方"test"创建成功
      并且配方"test"参数如下:
      """
      :[
        {Parameter: "StepName", 1: "step1"},
        {Parameter: "ProcessTime", 1: 0},
        {Parameter: "ESCTempCheck(degC)", 1: 20},
        {Parameter: "WaferType", 1: "Unknown"},
        {Parameter: "Pressure(mT)", 1: 0},
        {Parameter: "SRFCenterPower(W)", 1: 0},
        {Parameter: "SRFEdgePower(W)", 1: 0},
        {Parameter: "BRFPower(W)", 1: 0},
        {Parameter: "Ar", 1: 0},
        {Parameter: "O2", 1: 0},
        {Parameter: "He", 1: 0},
        {Parameter: "N2", 1: 0},
        {Parameter: "SF6", 1: 0},
        {Parameter: "CF4", 1: 0},
        {Parameter: "Cl2", 1: 0},
        {Parameter: "BCl3", 1: 0},
        {Parameter: "Spare9", 1: 0},
        {Parameter: "Spare10", 1: 0},
        {Parameter: "HePressure(T)", 1: 8},
        {Parameter: "VATCtlMode", 1: "Pressure"},
        {Parameter: "VATPosPreset", 1: 0},
        {Parameter: "VATPosDelayTime", 1: 0},
        {Parameter: "SRFCenterRefl(W)", 1: 50},
        {Parameter: "SRFEdgeRefl(W)", 1: 50},
        {Parameter: "BRFRefl(W)", 1: 10},
        {Parameter: "SRFCenterRamp", 1: "No"},
        {Parameter: "SRFCenterRampTime", 1: 0},
        {Parameter: "SRFEdgeRamp", 1: "No"},
        {Parameter: "SRFEdgeRampTime", 1: 0},
        {Parameter: "BRFRamp", 1: "No"},
        {Parameter: "BRFRampTime", 1: 0},
        {Parameter: "SRFCenterC1Preset", 1: 500},
        {Parameter: "SRFCenterC2Preset", 1: 500},
        {Parameter: "SRFEdgeC1Preset", 1: 500},
        {Parameter: "SRFEdgeC2Preset", 1: 500},
        {Parameter: "BRFC1Preset", 1: 500},
        {Parameter: "BRFC2Preset", 1: 500},
        {Parameter: "SRFCenterMatchTuneMode", 1: "Auto"},
        {Parameter: "SRFCenterMatchTuneDelay", 1: 0},
        {Parameter: "SRFEdgeMatchTuneMode", 1: "Auto"},
        {Parameter: "SRFEdgeMatchTuneDelay", 1: 0},
        {Parameter: "BRFMatchTuneMode", 1: "Auto"},
        {Parameter: "BRFMatchTuneDelay", 1: 0},
        {Parameter: "BRFPulseEnable", 1: "Enable"},
        {Parameter: "BRFPulseFrequency(Hz)", 1: 1000},
        {Parameter: "BRFPulseDutyCycle(%)", 1: 25},
        {Parameter: "EndMode", 1: "Time"},
        {Parameter: "EPDType", 1: "IEP"},
        {Parameter: "EPDConfig", 1: "(null)"},
        {Parameter: "SingleStepStop", 1: "No"},
        {Parameter: "MinEPDTime", 1: 0},
        {Parameter: "MaxEPDTime", 1: 50},
        {Parameter: "Oetch(percent)", 1: 0},
        {Parameter: "CloseSRFCenterBetweenStep", 1: No},
        {Parameter: "CloseSRFEdgeBetweenStep", 1: No},
        {Parameter: "CloseBRFBetweenStep", 1: No},
        {Parameter: "RcpStableCfg", 1: True},
        {Parameter: "LFPulse", 1: Off},
        {Parameter: "LFPower(W)", 1: 0},
        {Parameter: "LFRefl(W)", 1: 10},
        {Parameter: "LFFrequency(Hz)", 1: 150},
        {Parameter: "LFDutyCycle", 1: 10},
        {Parameter: "LFRamp", 1: "No"},
        {Parameter: "LFRampTime", 1: 0},
      ]
      """

    @clean-lower-recipe
    @etch-reset
    场景: 修改参数后未保存,新建配方弹出提示
      假如创建"PM2 GDE"的"Process"的配方"test"
      当修改"test"的步骤1的"StepName"为"dechuck":
      并且执行Recipe的"New"操作
      那么新建前弹出框提示信息:
      """
      = "test is not saved.Do you want to save first?"
      """

    @clean-lower-recipe
    @etch-reset
    场景: 修改参数后未保存,新建配方时保存编辑
      假如创建"PM2 GDE"的"Process"的配方"test"
      并且修改"test"的步骤1的"StepName"为"dechuck"
      当执行Recipe的"New"操作
      并且确认保存后再新建Recipe"Other"
      那么确认"test"的步骤1的"StepName"为"dechuck"

    @clean-lower-recipe
    @etch-reset
    场景: 修改参数后未保存,新建配方时不保存编辑
      假如创建"PM2 GDE"的"Process"的配方"test"
      并且修改"test"的步骤1的"StepName"为"dechuck"
      当执行Recipe的"New"操作
      并且确认不保存后再新建Recipe"Other"
      那么确认"test"的步骤1的"StepName"为"step1"

  Rule: 另存为Recipe

    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    场景: 已保存Recipe另存为Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当选择"DryClean"的"rcpSaved"另存为"PM2 GDE""lly"并且二次确认后
      那么"DryClean"的配方"lly"创建成功
      并且成功保存到下位机"/DryClean/lly;1":
      """
      :{
        "name": "lly",
        "rcpClass": "/DryClean",
        "editedBy": "sa",
        body:  {
            steps: [
                    {
                      name: 'step1',
                      values: [...]
                    },
                    {
                      name: 'step2',
                      values: [...]
                    },
                  ]
                }
      }
      """

    场景: 修改Recipe参数后执行另存为是否有提示
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当修改"rcpSaved"的步骤1的"StepName"为"dechuck":
      当选择当前配方另存为"PM2 GDE""lly"并且二次确认后:
      那么执行成功,提示信息
      """
      = "Successful!"
      """

      #TODO 感觉是一刻bug
    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景:新建配方未保存时执行另存为
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName   | Parameter | 1               | 2               |
        | PM2 GDE | DryClean    | rcpNot-saved | Step Name | not-saved-step1 | not-saved-step2 |
      当选择当前配方另存为"PM2 GDE""lly"并且二次确认后:
      那么执行成功,提示信息
      """
      = "Successful!"
      """
#      那么执行失败,异常信息为:
#      """
#      = "The new recipe name can't be null or be same as the recipe names in Buffer!"
#      """

    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    场景: 已保存Recipe另存为Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当选择"DryClean"的"rcpSaved"另存为"PM2 GDE""lly"并且二次确认后
      那么"DryClean"的配方"lly"创建成功
      并且成功保存到下位机"/DryClean/lly;1":
      """
      :{
        "name": "lly",
        "rcpClass": "/DryClean",
        "editedBy": "sa",
        body:  {
            steps: [
                    {
                      name: 'step1',
                      values: [...]
                    },
                    {
                      name: 'step2',
                      values: [...]
                    },
                  ]
                }
      }
      """

  Rule:撤销编辑

    场景: 撤销编辑
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      并且修改"rcpSaved"的步骤2的"StepName"为"dechuck":
      并且修改"rcpSaved"的步骤1的"StepName"为"Stepname":
      当执行Recipe的"Restore"操作
      那么确认"rcpSaved"的步骤2的"StepName"为"step2"
      并且确认"rcpSaved"的步骤1的"StepName"为"step1"

  Rule: 删除Recipe

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 删除已保存Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当删除"DryClean"的"rcpSaved"并二次确认
      那么"DryClean"的"rcpSaved"删除成功
      并且下位机无法查询到"/DryClean/rcpSaved;1"

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 删除Recipe提示信息验证
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当删除"DryClean"的"rcpSaved"
      那么弹出框提示信息:
      """
      = "Do you want to delete Recipe rcpSaved?"
      """

    @clean-lower-recipe
    @etch-reset
    场景: 删除未保存Recipe
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName   | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpNot-saved | Step Name | step1 | step2 |
      当删除"DryClean"的"rcpNot-saved"并二次确认:
      那么"DryClean"的"rcpNot-saved"删除成功
      并且下位机无法查询到"/DryClean/rcpNot-saved;1"

  Rule: 导出Recipe

    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    @CleanDir
    场景: 导出已保存Recipe所有步骤
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当导出"DryClean"的"rcpSaved"为"Etch1.csv"文件
      那么导出成功,提示信息为:
      """
      = 'Export Recipe successfully!'
      """
      并且导出路径存在"Etch1.csv":
      """
      :[
        'Parameter,1,2',
        'StepName,step1,step2',
        'ProcessTime,0,0',
        'ESCTempCheck(degC),20,20',
        'WaferType,Unknown,Unknown',
        'Pressure(mT),0,0',
        'SRFCenterPower(W),0,0',
        'SRFEdgePower(W),0,0',
        'BRFPower(W),0,0',
        'Ar,0,0',
        'O2,0,0',
        'He,0,0',
        'N2,0,0',
        'SF6,0,0',
        'CF4,0,0',
        'Cl2,0,0',
        'BCl3,0,0',
        'Spare9,0,0',
        'Spare10,0,0',
        'HePressure(T),8,8',
        'VATCtlMode,Pressure,Pressure',
        'VATPosPreset,0,0',
        'VATPosDelayTime,0,0',
        'SRFCenterRefl(W),50,50',
        'SRFEdgeRefl(W),50,50',
        'BRFRefl(W),10,10',
        'SRFCenterRamp,No,No',
        'SRFCenterRampTime,0,0',
        'SRFEdgeRamp,No,No',
        'SRFEdgeRampTime,0,0',
        'BRFRamp,No,No',
        'BRFRampTime,0,0',
        'SRFCenterC1Preset,500,500',
        'SRFCenterC2Preset,500,500',
        'SRFEdgeC1Preset,500,500',
        'SRFEdgeC2Preset,500,500',
        'BRFC1Preset,500,500',
        'BRFC2Preset,500,500',
        'SRFCenterMatchTuneMode,Auto,Auto',
        'SRFCenterMatchTuneDelay,0,0',
        'SRFEdgeMatchTuneMode,Auto,Auto',
        'SRFEdgeMatchTuneDelay,0,0',
        'BRFMatchTuneMode,Auto,Auto',
        'BRFMatchTuneDelay,0,0',
        'BRFPulseEnable,Enable,Enable',
        'BRFPulseFrequency(Hz),1000,1000',
        'BRFPulseDutyCycle(%),25,25',
        'EndMode,Time,Time',
        'EPDType,IEP,IEP',
        'EPDConfig,,',
        'SingleStepStop,No,No',
        'MinEPDTime,0,0',
        'MaxEPDTime,50,50',
        'Oetch(percent),0,0',
        'CloseSRFCenterBetweenStep,No,No',
        'CloseSRFEdgeBetweenStep,No,No',
        'CloseBRFBetweenStep,No,No',
        'RcpStableCfg,True,True',
        'LFPulse,Off,Off',
        'LFPower(W),0,0',
        'LFRefl(W),10,10',
        'LFFrequency(Hz),150,150',
        'LFDutyCycle,10,10',
        'LFRamp,No,No',
        'LFRampTime,0,0',
        ''
      ]
    """

    @CleanDir
    场景:参数非法导出文件
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当修改"rcpSaved"的步骤1的"StepName"为"!":
      当执行导出操作时
      那么执行失败,异常信息为:
      """
      = 'There are errors in current recipe, please check param values and dechuck step!'
      """
      当修改"rcpSaved"的步骤1的"Step Name"为"2222222222222222222222222222":
      当执行导出操作时
      那么执行失败,异常信息为:
      """
      = 'There are errors in current recipe, please check param values and dechuck step!'
      """

      #TODO 感觉是一刻的bug,待确认
    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    @CleanDir
    场景: 导出未保存Recipe所有步骤
      假如存在未保存配方:
        | PMName  | RecipeClass | RecipeName  | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpNotSaved | Step Name | step1 | step2 |
      当导出"DryClean"的"rcpNotSaved"为"Etch1.csv"文件:
      那么导出成功,提示信息为:
      """
      = 'Export Recipe successfully!'
      """
      并且导出路径存在"Etch1.csv":
      """
      :[
        'Parameter,1,2',
        'StepName,step1,step2',
        'ProcessTime,0,0',
        'ESCTempCheck(degC),20,20',
        'WaferType,Unknown,Unknown',
        'Pressure(mT),0,0',
        'SRFCenterPower(W),0,0',
        'SRFEdgePower(W),0,0',
        'BRFPower(W),0,0',
        'Ar,0,0',
        'O2,0,0',
        'He,0,0',
        'N2,0,0',
        'SF6,0,0',
        'CF4,0,0',
        'Cl2,0,0',
        'BCl3,0,0',
        'Spare9,0,0',
        'Spare10,0,0',
        'HePressure(T),8,8',
        'VATCtlMode,Pressure,Pressure',
        'VATPosPreset,0,0',
        'VATPosDelayTime,0,0',
        'SRFCenterRefl(W),50,50',
        'SRFEdgeRefl(W),50,50',
        'BRFRefl(W),10,10',
        'SRFCenterRamp,No,No',
        'SRFCenterRampTime,0,0',
        'SRFEdgeRamp,No,No',
        'SRFEdgeRampTime,0,0',
        'BRFRamp,No,No',
        'BRFRampTime,0,0',
        'SRFCenterC1Preset,500,500',
        'SRFCenterC2Preset,500,500',
        'SRFEdgeC1Preset,500,500',
        'SRFEdgeC2Preset,500,500',
        'BRFC1Preset,500,500',
        'BRFC2Preset,500,500',
        'SRFCenterMatchTuneMode,Auto,Auto',
        'SRFCenterMatchTuneDelay,0,0',
        'SRFEdgeMatchTuneMode,Auto,Auto',
        'SRFEdgeMatchTuneDelay,0,0',
        'BRFMatchTuneMode,Auto,Auto',
        'BRFMatchTuneDelay,0,0',
        'BRFPulseEnable,Enable,Enable',
        'BRFPulseFrequency(Hz),1000,1000',
        'BRFPulseDutyCycle(%),25,25',
        'EndMode,Time,Time',
        'EPDType,IEP,IEP',
        'EPDConfig,,',
        'SingleStepStop,No,No',
        'MinEPDTime,0,0',
        'MaxEPDTime,50,50',
        'Oetch(percent),0,0',
        'CloseSRFCenterBetweenStep,No,No',
        'CloseSRFEdgeBetweenStep,No,No',
        'CloseBRFBetweenStep,No,No',
        'RcpStableCfg,True,True',
        'LFPulse,Off,Off',
        'LFPower(W),0,0',
        'LFRefl(W),10,10',
        'LFFrequency(Hz),150,150',
        'LFDutyCycle,10,10',
        'LFRamp,No,No',
        'LFRampTime,0,0',
        ''
      ]
    """

    @Etch1-clean-allCreate-recipe
    @CleanDir
    场景: 导出删除步骤后的Recipe所有步骤
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName  | Parameter | 1     | 2     | 3     |
        | PM2 GDE | DryClean    | rcpNotSaved | Step Name | step1 | step2 | step3 |
      当删除步骤"1"并二次确定
      当导出"DryClean"的"rcpNotSaved"为"Etch1#2.csv"文件:
      那么导出成功,提示信息为:
      """
      = 'Export Recipe successfully!'
      """
      并且导出路径存在"Etch1#2.csv":
      """
      :[
        'Parameter,1,2',
        'StepName,step2,step3',
        'ProcessTime,0,0',
        'ESCTempCheck(degC),20,20',
        'WaferType,Unknown,Unknown',
        'Pressure(mT),0,0',
        'SRFCenterPower(W),0,0',
        'SRFEdgePower(W),0,0',
        'BRFPower(W),0,0',
        'Ar,0,0',
        'O2,0,0',
        'He,0,0',
        'N2,0,0',
        'SF6,0,0',
        'CF4,0,0',
        'Cl2,0,0',
        'BCl3,0,0',
        'Spare9,0,0',
        'Spare10,0,0',
        'HePressure(T),8,8',
        'VATCtlMode,Pressure,Pressure',
        'VATPosPreset,0,0',
        'VATPosDelayTime,0,0',
        'SRFCenterRefl(W),50,50',
        'SRFEdgeRefl(W),50,50',
        'BRFRefl(W),10,10',
        'SRFCenterRamp,No,No',
        'SRFCenterRampTime,0,0',
        'SRFEdgeRamp,No,No',
        'SRFEdgeRampTime,0,0',
        'BRFRamp,No,No',
        'BRFRampTime,0,0',
        'SRFCenterC1Preset,500,500',
        'SRFCenterC2Preset,500,500',
        'SRFEdgeC1Preset,500,500',
        'SRFEdgeC2Preset,500,500',
        'BRFC1Preset,500,500',
        'BRFC2Preset,500,500',
        'SRFCenterMatchTuneMode,Auto,Auto',
        'SRFCenterMatchTuneDelay,0,0',
        'SRFEdgeMatchTuneMode,Auto,Auto',
        'SRFEdgeMatchTuneDelay,0,0',
        'BRFMatchTuneMode,Auto,Auto',
        'BRFMatchTuneDelay,0,0',
        'BRFPulseEnable,Enable,Enable',
        'BRFPulseFrequency(Hz),1000,1000',
        'BRFPulseDutyCycle(%),25,25',
        'EndMode,Time,Time',
        'EPDType,IEP,IEP',
        'EPDConfig,,',
        'SingleStepStop,No,No',
        'MinEPDTime,0,0',
        'MaxEPDTime,50,50',
        'Oetch(percent),0,0',
        'CloseSRFCenterBetweenStep,No,No',
        'CloseSRFEdgeBetweenStep,No,No',
        'CloseBRFBetweenStep,No,No',
        'RcpStableCfg,True,True',
        'LFPulse,Off,Off',
        'LFPower(W),0,0',
        'LFRefl(W),10,10',
        'LFFrequency(Hz),150,150',
        'LFDutyCycle,10,10',
        'LFRamp,No,No',
        'LFRampTime,0,0',
        ''
      ]
    """

    @Etch1-clean-allCreate-recipe
    @CleanDir
    场景: 导出已保存Recipe指定步骤
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     | 3     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 | step3 |
      当导出"DryClean"的"rcpSaved"的步骤"1"到步骤"2"为"Etch1.csv"文件
      那么导出成功,提示信息为:
      """
      = 'Export Recipe successfully!'
      """
      并且导出路径存在"Etch1.csv":
      """
      :[
        'Parameter,1,2',
        'StepName,step1,step2',
        'ProcessTime,0,0',
        'ESCTempCheck(degC),20,20',
        'WaferType,Unknown,Unknown',
        'Pressure(mT),0,0',
        'SRFCenterPower(W),0,0',
        'SRFEdgePower(W),0,0',
        'BRFPower(W),0,0',
        'Ar,0,0',
        'O2,0,0',
        'He,0,0',
        'N2,0,0',
        'SF6,0,0',
        'CF4,0,0',
        'Cl2,0,0',
        'BCl3,0,0',
        'Spare9,0,0',
        'Spare10,0,0',
        'HePressure(T),8,8',
        'VATCtlMode,Pressure,Pressure',
        'VATPosPreset,0,0',
        'VATPosDelayTime,0,0',
        'SRFCenterRefl(W),50,50',
        'SRFEdgeRefl(W),50,50',
        'BRFRefl(W),10,10',
        'SRFCenterRamp,No,No',
        'SRFCenterRampTime,0,0',
        'SRFEdgeRamp,No,No',
        'SRFEdgeRampTime,0,0',
        'BRFRamp,No,No',
        'BRFRampTime,0,0',
        'SRFCenterC1Preset,500,500',
        'SRFCenterC2Preset,500,500',
        'SRFEdgeC1Preset,500,500',
        'SRFEdgeC2Preset,500,500',
        'BRFC1Preset,500,500',
        'BRFC2Preset,500,500',
        'SRFCenterMatchTuneMode,Auto,Auto',
        'SRFCenterMatchTuneDelay,0,0',
        'SRFEdgeMatchTuneMode,Auto,Auto',
        'SRFEdgeMatchTuneDelay,0,0',
        'BRFMatchTuneMode,Auto,Auto',
        'BRFMatchTuneDelay,0,0',
        'BRFPulseEnable,Enable,Enable',
        'BRFPulseFrequency(Hz),1000,1000',
        'BRFPulseDutyCycle(%),25,25',
        'EndMode,Time,Time',
        'EPDType,IEP,IEP',
        'EPDConfig,,',
        'SingleStepStop,No,No',
        'MinEPDTime,0,0',
        'MaxEPDTime,50,50',
        'Oetch(percent),0,0',
        'CloseSRFCenterBetweenStep,No,No',
        'CloseSRFEdgeBetweenStep,No,No',
        'CloseBRFBetweenStep,No,No',
        'RcpStableCfg,True,True',
        'LFPulse,Off,Off',
        'LFPower(W),0,0',
        'LFRefl(W),10,10',
        'LFFrequency(Hz),150,150',
        'LFDutyCycle,10,10',
        'LFRamp,No,No',
        'LFRampTime,0,0',
        ''
      ]
    """

#    @Etch1-clean-allCreate-recipe
    @CleanDir
    场景: 导出已保存Recipe指定一步
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     | 3     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 | step3 |
      当导出"DryClean"的"rcpSaved"的步骤"1"到步骤"1"为"Etch1.csv"文件
      那么导出成功,提示信息为:
      """
      = 'Export Recipe successfully!'
      """
      并且导出路径存在"Etch1.csv":
      """
      :[
        'Parameter,1',
        'StepName,step1',
        'ProcessTime,0',
        'ESCTempCheck(degC),20',
        'WaferType,Unknown',
        'Pressure(mT),0',
        'SRFCenterPower(W),0',
        'SRFEdgePower(W),0',
        'BRFPower(W),0',
        'Ar,0',
        'O2,0',
        'He,0',
        'N2,0',
        'SF6,0',
        'CF4,0',
        'Cl2,0',
        'BCl3,0',
        'Spare9,0',
        'Spare10,0',
        'HePressure(T),8',
        'VATCtlMode,Pressure',
        'VATPosPreset,0',
        'VATPosDelayTime,0',
        'SRFCenterRefl(W),50',
        'SRFEdgeRefl(W),50',
        'BRFRefl(W),10',
        'SRFCenterRamp,No',
        'SRFCenterRampTime,0',
        'SRFEdgeRamp,No',
        'SRFEdgeRampTime,0',
        'BRFRamp,No',
        'BRFRampTime,0',
        'SRFCenterC1Preset,500',
        'SRFCenterC2Preset,500',
        'SRFEdgeC1Preset,500',
        'SRFEdgeC2Preset,500',
        'BRFC1Preset,500',
        'BRFC2Preset,500',
        'SRFCenterMatchTuneMode,Auto',
        'SRFCenterMatchTuneDelay,0',
        'SRFEdgeMatchTuneMode,Auto',
        'SRFEdgeMatchTuneDelay,0',
        'BRFMatchTuneMode,Auto',
        'BRFMatchTuneDelay,0',
        'BRFPulseEnable,Enable',
        'BRFPulseFrequency(Hz),1000',
        'BRFPulseDutyCycle(%),25',
        'EndMode,Time',
        'EPDType,IEP',
        'EPDConfig,',
        'SingleStepStop,No',
        'MinEPDTime,0',
        'MaxEPDTime,50',
        'Oetch(percent),0',
        'CloseSRFCenterBetweenStep,No',
        'CloseSRFEdgeBetweenStep,No',
        'CloseBRFBetweenStep,No',
        'RcpStableCfg,True',
        'LFPulse,Off',
        'LFPower(W),0',
        'LFRefl(W),10',
        'LFFrequency(Hz),150',
        'LFDutyCycle,10',
        'LFRamp,No',
        'LFRampTime,0',
        ''
      ]
    """

    @clean-lower-recipe
    @etch-reset
    场景: 导出Recipe开始步骤大于结束步骤
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当导出"DryClean"的"rcpSaved"的步骤"2"到步骤"1"
      那么执行失败,异常信息为:
      """
      = 'Please select correct start and end steps!'
      """

  Rule: 重命名Recipe

    @clean-lower-recipe
    @etch-reset
    场景: 重命名已保存Recipe提示信息验证
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当选择"DryClean"的"rcpSaved"重命名
      那么执行成功,提示信息为
      """
      = "Are you sure to rename the recipe 'rcpSaved'? "
      """

    @clean-lower-recipe
    @etch-reset
    @Etch1-clean-allCreate-recipe
    场景: 重命名已保存Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当选择"DryClean"的"rcpSaved"重命名为"renameRcp"并且二次确认后
      那么"DryClean"的配方"renameRcp"创建成功
      并且成功保存到下位机"/DryClean/renameRcp;1":
      """
      :{
        "name": "renameRcp",
        "rcpClass": "/DryClean",
        "editedBy": "sa",
        body:  {
            steps: [
                    {
                      name: 'step1',
                      values: [...]
                    },
                    {
                      name: 'step2',
                      values: [...]
                    },
                  ]
                }
      }
      """

#    @Etch1-clean-allCreate-recipe
    场景: 重命名Recipe为同名Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当选择"DryClean"的"rcpSaved"重命名为"rcpSaved"并且二次确认后
      那么执行失败,异常信息为:
      """
      = "Rename recipe failed!"
      """

    @clean-lower-recipe
    @etch-reset
#    @Etch1-clean-allCreate-recipe
    场景: 重命名为大写Recipe
      假如存在已保存配方:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
        | PM2 GDE | DryClean    | rcpSaved   | Step Name | step1 | step2 |
      当选择"DryClean"的"rcpSaved"重命名为"RCPSAVED"并且二次确认后
      那么"DryClean"的配方"RCPSAVED"创建成功
      并且成功保存到下位机"/DryClean/RCPSAVED;1":
      """
      :{
        "name": "RCPSAVED",
        "rcpClass": "/DryClean",
        "editedBy": "sa",
        body:  {
            steps: [
                    {
                      name: 'step1',
                      values: [...]
                    },
                    {
                      name: 'step2',
                      values: [...]
                    },
                  ]
                }
      }
      """






