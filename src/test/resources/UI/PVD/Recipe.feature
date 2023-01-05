# language: zh-CN
@skip
功能: Recipe的UI测试
  Rule:界面显示功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    场景: 创建时间控件显示为配方创建时间
      假如创建"Ch2"的工艺配方"test1"
      那么能查询到配方"test"的创建时间为:
      """
      is AlmostNow
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景: 修改时间控件显示为配方修改时间
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | syx  | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"syx":
        | parameter | value | value2 |
        | Step Name | step1 | step2  |
      并且保存后
      那么能查询到配方"test"的修改时间为:
      """
      is AlmostNow
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景: pe创建配方显示为pe
      假如用户"pe"使用密码"8888"启动上位机
      当创建"Ch2"的工艺配方"test1"
      那么能查询到创建者为"pe"

    @pvd-lower
    @clean-lower-recipeOnly
    场景: 所有一级RcpClass存在Recipe,界面能否显示
      假如存在"defaultRcp Recipe":
        | name   | rcpClass | comments                                               |
        | Ch2Rcp | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0       |
        | Ch3Rcp | /Ch3     | Shutter:No,ProcType:Ch3,PedTemp:100,PedTempTol:0       |
        | ChARcp | /ChA     | Shutter:No,ProcType:ChA,PedTemp:,PedTempTol:           |
        | ChBRcp | /ChB     | Shutter:No,ProcType:ChB,PedTemp:,PedTempTol:           |
        | ChCRcp | /ChC     | Shutter:No,ProcType:ChC,HeaterTemp:100,HeaterTempTol:0 |
        | ChDRcp | /ChD     | Shutter:No,ProcType:ChD,HeaterTemp:,HeaterTempTol:     |
      当用户"pe"使用密码"8888"启动上位机
      那么查看"Ch2"的配方时,配方显示如下:
      """
      = [Ch2Rcp]
      """
      那么查看"Ch3"的配方时,配方显示如下:
      """
      = [Ch3Rcp]
      """
      那么查看"ChA"的配方时,配方显示如下:
      """
      = [ChARcp]
      """
      那么查看"ChB"的配方时,配方显示如下:
      """
      = [ChBRcp]
      """
      那么查看"ChC"的配方时,配方显示如下:
      """
      = [ChCRcp]
      """
      那么查看"ChD"的配方时,配方显示如下:
      """
      = [ChDRcp]
      """

    @pvd-lower
    @clean-lower-recipe
    场景: 二级RcpClass包含Recipe,界面能否显示
      假如存在一个RecipeClass:
      """
      {
        "name": "/Ch2/newSubClass",
        "params": [{
          "name": "StringStep",
          "type": "S",
          "defaultValue": "a-default",
          "dataObj": "a-dataObj",
          "maxLength": 128
        }, {
          "name": "Time",
          "type": "D",
          "defaultValue": "1",
          "dataObj": "double-obj",
          "min": 0.0,
          "max": 3600.0,
          "unit": "sec",
          "accuracy": 0.1
        }]
      }
      """
      并且存在"defaultRcp Recipe":
        | name   | rcpClass         | comments                                         |
        | newRcp | /Ch2/newSubClass | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      那么查看"Ch2/newSubClass"的配方时,配方显示如下:
      """
      = [newRcp]
      """

  Rule:界面查找功能
    @pvd-lower
    @clean-lower-recipeOnly
    场景:单字符查询
      假如存在"defaultRcp Recipe":
        | name               | rcpClass | comments                                         |
        | contains-c         | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | not                | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | another-contains-c | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      并且在"Ch2"中查找"c"时,结果显示如下:
      """
      = [another-contains-c,contains-c]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:双字符查询-不区分大小写
      假如存在"defaultRcp Recipe":
        | name        | rcpClass | comments                                         |
        | contains-Ab | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | not-contain | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | contains-ab | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      并且在"Ch2"中查找"Ab"时,结果显示如下:
      """
      = [contains-ab,contains-Ab]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:特殊字符查询
      假如存在"defaultRcp Recipe":
        | name    | rcpClass | comments                                         |
        | Aa1_-bc | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      并且在"Ch2"中查找"Aa1_-bc"时,结果显示如下:
      """
      = [Aa1_-bc]
      """

  Rule:新建Recipe
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:首次创建Recipe成功
      当创建"Ch2"的工艺配方"test"
      那么"Ch2"的"test"创建成功
      并且配方参数如下:
      """
      =[
        {Parameter: "Step Name", 1: "Step Name"},
        {Parameter: "Step End Type", 1: "Time"},
        {Parameter: "Step End Cond", 1: "(null)"},
        {Parameter: "Time", 1: 0},
        {Parameter: "RF", 1: 0},
        {Parameter: "RF Ramp", 1: 0},
        {Parameter: "Match", 1: "Auto"},
        {Parameter: "O2FlowType", 1: "FlowToChamber"},
        {Parameter: "O2", 1: 0},
        {Parameter: "Ar2FlowType", 1: "FlowToChamber"},
        {Parameter: "Ar2", 1: 0},
        {Parameter: "H2FlowType", 1: "FlowToChamber"},
        {Parameter: "H2", 1: 0},
        {Parameter: "H2EPFlowType", 1:"FlowToChamber"},
        {Parameter: "H2EP", 1:0},
        {Parameter: "ArBP", 1: 0},
        {Parameter: "ArEP", 1: 0},
        {Parameter: "ArSP", 1: 0},
        {Parameter: "Chuck", 1: "Off"},
        {Parameter: "BSP", 1: 0},
        {Parameter: "BSF", 1: 0},
        {Parameter: "TVMode", 1: "FullOpen"},
        {Parameter: "TVSetPoint", 1: 0},
        {Parameter: "Spacing", 1: 0}
        ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    场景:有未保存的新建配方,再次执行新建是否有提示
      假如创建"Ch2"的工艺配方"test1"
      当执行"新建配方"
      那么执行失败,返回错误信息如下:
      """
      ="配方 test1尚未保存，是否保存？"
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:存在配方更改参数后不保存再次执行新建
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test":
        | parameter | value |
        | Step Name | step1 |
      并且执行"新建配方"
      那么执行失败,返回错误信息如下:
      """
      ="配方 test尚未保存，是否保存？"
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:存在配方更改Comment后不保存再次执行新建
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的"test"的PedTemp的温度值为"10"，余度值为"10"
      并且执行"新建配方"
      那么执行失败,返回错误信息如下:
      """
      ="配方 test尚未保存，是否保存？"
      """

    @pvd-lower
    @clean-lower-recipe
    @clean-create-recipe
    场景:工艺腔室子目录创建Recipe
      假如存在一个RecipeClass:
      """
      {
        "name": "/Ch2/newSubClass",
        "params": [{
          "name": "StringStep",
          "type": "S",
          "defaultValue": "a-default",
          "dataObj": "a-dataObj",
          "maxLength": 128
        }, {
          "name": "Time",
          "type": "D",
          "defaultValue": "0",
          "dataObj": "double-obj",
          "min": 0.0,
          "max": 3600.0,
          "unit": "sec",
          "accuracy": 0.1
        }]
      }
      """
      当用户"pe"使用密码"8888"启动上位机
      并且创建"Ch2/newSubClass"的工艺配方"test"
      那么"Ch2/newSubClass"的"test"创建成功
      并且配方参数如下:
      """
      =[
        {Parameter: "StringStep", 1: "a-default"},
        {Parameter: "Time", 1: 0},
        ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证新建未保存是否提示配方未保存
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      当在"Ch2"新建配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
      并且切换recipe为"ChangeRecipe"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = '配方 test尚未保存，是否保存?'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证新建未保存选择保存后保存成功并切换recipe
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      当在"Ch2"新建配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
      并且切换recipe为"ChangeRecipe"后选择"确定"
      那么抛出提示，信息为:
      """
      = "保存配方 ‘test’ 成功！"
      """
      并且"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: ChangeRStep
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证新建未保存选择不保存后不保存并切换recipe
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      当在"Ch2"新建配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
      并且切换recipe为"ChangeRecipe"后选择"取消"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: ChangeRStep
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证新建未保存切换腔室是否提示配方未保存
      假如在"Ch2"新建配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
      当切换腔室为"Ch3"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = '配方 test尚未保存，是否保存?'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证新建未保存切换腔室选择保存后保存成功并切换腔室
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当在"Ch2"新建配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
      并且切换腔室为"Ch3"后选择"确定"
      那么抛出提示，信息为:
      """
      = "保存配方 ‘test’ 成功！"
      """
      并且此时recipe list包含
      """
      =[Ch3Recipe]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证新建未保存切换腔室选择不保存后不保存并切换腔室
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当在"Ch2"新建配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
      当切换腔室为"Ch3"后选择"取消"
      那么此时recipe list包含
      """
      =[Ch3Recipe]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    场景:二次新建时保存上一次新建的配方
      假如创建"Ch2"的工艺配方"test"
      并且执行"新建配方"
      当执行"保存配方"并且"确定"后
      那么提示"新建工艺配方"
      并且成功保存到下位机"/Ch2/test;1"中:
      """
      : {
          name: 'test',
          rcpClass: '/Ch2',
          version: '1',
          attrChgTime is AlmostNow,
          editTime is AlmostNow,
          verified: true,
          linked: false,
          editedBy: 'pe',
          approvalLvl: 0,
          body:  {
              steps: [
                      {
                        name: '1',
                        values: [...
                                ]
                      }
                    ]
                  }
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:修改配方参数后再次新建并且不保存
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
      并且执行"新建配方"
      当执行"保存配方"并且"取消"后
      那么"取消"后的"Ch2"的"test"应恢复为先前的参数值如下:
      """
      =[...
           {Parameter: "Step Name", 1: "Step Name"}
        ...]
      """
      并且下位机"/Ch2/test;1"应为:
      """
        :  {  name: 'test',
              rcpClass: '/Ch2',
              version: '1',
              attrChgTime is AlmostNow,
              editTime is AlmostNow,
              verified: true,
              linked: false,
              approvalLvl: 0,
              body:  {
                  steps: [
                        {
                          name: '1',
                          values: [...
                                   'Step Name'
                                   ...]
                        }
                         ]
                      }
          }
      """

  Rule: 保存Recipe
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    场景:保存新建Recipe成功
      假如创建"Ch2"的工艺配方"test"
      当执行"保存配方"
      那么成功保存到下位机"/Ch2/test;1"中:
      """
      : {
          name: 'test',
          rcpClass: '/Ch2',
          version: '1',
          attrChgTime is AlmostNow,
          editTime is AlmostNow,
          verified: true,
          linked: false,
          editedBy: 'pe',
          approvalLvl: 0,
          body:  {
              steps: [
                      {
                        name: '1',
                        values: [...
                                ]
                      }
                    ]
                  }
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:保存在编辑状态的Recipe成功
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
      并且执行"保存配方"
      那么成功保存到下位机"/Ch2/test;1"中:
      """
      : {
          body:{
            steps:[{
              name:'1',
              values:[...
                      'step1'
              ...]
            }]
          }
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:参数值输入的合法性验证
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1    |
        | RF        | 2000 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
    """
    ='RF 输入错误！请输入0到1500范围内的Double类型值！'
    """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | RF        | -test |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
    """
    ='RF输入类型错误！请输入Double类型值！'
    """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF        | 测试 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
    """
    ='RF输入类型错误！请输入Double类型值！'
    """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | RF        | \test |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
    """
    ='RF输入类型错误！请输入Double类型值！'
    """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:删除PedTemp的原有值后保存配方,验证是否有提醒
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当删除"Ch2"的"test"的PedTemp后"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="请设置 PedTemp 监控值！"
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:保存非编辑状态的Recipe(已有场景未涉及)
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当未编辑"Ch2"的"test"时"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="当前配方为非编辑状态！"
      """

        #TODO 转义字符和空字符无法传入
    @pvd-lower
    @clean-lower-recipeOnly
    场景:保存配方步骤Double类型合法性校验(已有场景未涉及)
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF        | 非法 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF输入类型错误！请输入Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | RF        | 10001 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF 输入错误！请输入0到1500范围内的Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF        | -1 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF 输入错误！请输入0到1500范围内的Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1 |
        | RF        | ? |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF输入类型错误！请输入Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1 |
        | RF        | ？ |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF输入类型错误！请输入Double类型值！"
      """

    #TODO 转义字符和空字符无法传入
    @pvd-lower
    @clean-lower-recipeOnly
    场景:保存配方步骤Int类型合法性校验(已有场景未涉及)
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF Ramp   | 非法 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF Ramp输入错误！请输入0到1500范围内的Int类型值或其描述符（如果有）！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | RF Ramp   | 10001 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF Ramp输入错误！请输入0到1500范围内的Int类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF Ramp   | -1 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF Ramp输入错误！请输入0到1500范围内的Int类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1 |
        | RF Ramp   | ? |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF Ramp输入错误！请输入0到1500范围内的Int类型值或其描述符（如果有）！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1 |
        | RF Ramp   | ？ |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF Ramp输入错误！请输入0到1500范围内的Int类型值或其描述符（如果有）！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | RF Ramp   | 9.999 |
      并且执行"保存配方"
      那么执行失败,返回错误信息如下:
      """
      ="RF Ramp输入错误！请输入0到1500范围内的Int类型值或其描述符（如果有）！"
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:未设置PedTemp参数时有提示信息
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     |
        | Step Name | test1 |
      当不设置监控值"保存配方"时
      那么抛出警告，信息为:
      """
      = '请设置 PedTemp 监控值！'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:循环步骤是否保存正确
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      并且执行"新建"步骤插入到第2步时
      当设置PedTemp的值为100,PedTempTol的值为0
      并且"保存配方"时
      那么成功保存到下位机"/Ch2/syx;1"中:
      """
      : {
          body:{
            steps:[{
              name: '1'
            },{
              name: '2'
            },{
              name: '3'
            },{
              name: '4'
            },{
              name: '5[3-4;2]'
            },{
              name: '9'
            }]
          }
        }
      """

  Rule:编辑Recipe
    #TODO ComboBox选择下拉框修改值
    @pvd-lower
    @clean-lower-recipeOnly
    场景:修改配方参数成功
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
        | RF        | 2     |
      那么配方参数如下:
      """
      =[...
          {1: 'step1', Parameter: 'Step Name'},
          {1: 2,       Parameter:'RF'},
        ...]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑参数未保存是否提示配方未保存
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"参数:
        | Parameter | 1     |
        | Step Name | step1 |
      当切换recipe为"ChangeRecipe"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = '配方 test尚未保存，是否保存?'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑参数未保存选择保存后保存成功并切换recipe
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"参数:
        | Parameter | 1     |
        | Step Name | step1 |
      并且切换recipe为"ChangeRecipe"后选择"确定"
      那么抛出提示，信息为:
      """
      = "保存配方 ‘test’ 成功！"
      """
      并且"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: ChangeRStep
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑参数未保存选择不保存后不保存并切换recipe
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"参数:
        | Parameter | 1     |
        | Step Name | step1 |
      并且切换recipe为"ChangeRecipe"后选择"取消"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: ChangeRStep
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑comment未保存是否提示配方未保存
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"comment信息:
        | name    | value |
        | PedTemp | 10    |
      并且切换recipe为"ChangeRecipe"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = '配方 test尚未保存，是否保存?'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑comment未保存选择保存后保存成功并切换recipe
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"comment信息:
        | name    | value |
        | PedTemp | 10    |
      并且切换recipe为"ChangeRecipe"后选择"确定"
      那么抛出提示，信息为:
      """
      = "保存配方 ‘test’ 成功！"
      """
      并且"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: ChangeRStep
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑comment未保存选择不保存后不保存并切换recipe
      假如在"Ch2"存在配方"ChangeRecipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1           |
        | Step Name | ChangeRStep |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"comment信息:
        | name    | value |
        | PedTemp | 10    |
      并且切换recipe为"ChangeRecipe"后选择"取消"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: ChangeRStep
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑配方参数未保存切换腔室是否提示配方未保存
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"参数:
        | Parameter | 1     |
        | Step Name | step1 |
      当切换腔室为"Ch3"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = '配方 test尚未保存，是否保存?'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑配方参数未保存切换腔室选择保存后保存成功并切换腔室
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"参数:
        | Parameter | 1     |
        | Step Name | step1 |
      并且切换腔室为"Ch3"后选择"确定"
      那么抛出提示，信息为:
      """
      = "保存配方 ‘test’ 成功！"
      """
      并且此时recipe list包含
      """
      =[Ch3Recipe]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑配方参数未保存切换腔室选择不保存后不保存并切换腔室
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"参数:
        | Parameter | 1     |
        | Step Name | step1 |
      并且切换腔室为"Ch3"后选择"取消"
      那么此时recipe list包含
      """
      =[Ch3Recipe]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑comment未保存切换腔室是否提示配方未保存
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"comment信息:
        | name    | value |
        | PedTemp | 10    |
      并且切换腔室为"Ch3"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = '配方 test尚未保存，是否保存?'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑comment未保存切换腔室选择保存后保存成功并切换腔室
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"comment信息:
        | name    | value |
        | PedTemp | 10    |
      并且切换腔室为"Ch3"后选择"确定"
      那么抛出提示，信息为:
      """
      = "保存配方 ‘test’ 成功！"
      """
      并且此时recipe list包含
      """
      =[Ch3Recipe]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-recipe
    场景:验证编辑comment未保存切换腔室选择不保存后不保存并切换腔室
      假如在"Ch3"存在配方"Ch3Recipe"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      并且在"Ch2"存在配方"test"，comments信息为"PedTemp:100,PedTempTol:0"
        | Parameter | 1 |
      当修改"Ch2"的工艺配方"test"comment信息:
        | name    | value |
        | PedTemp | 10    |
      并且切换腔室为"Ch3"后选择"取消"
      那么此时recipe list包含
      """
      =[Ch3Recipe]
      """

  Rule:撤销编辑
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:撤销新建的Rcp配方数值成功
      假如创建"Ch2"的工艺配方"test"
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
      并且撤销编辑
      那么"Parameter"的"Step Name"参数返回如下:
      """
      ={
          1: 'Step Name',
          Parameter: 'Step Name'
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:撤销存在的配方数值成功
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
      并且撤销编辑
      那么"Parameter"的"Step Name"参数返回如下:
      """
      ={
          1: 'Step Name',
          Parameter: 'Step Name'
        }
      """

  Rule:删除Recipe
    @pvd-lower
    @clean-lower-recipeOnly
    场景:删除一个存在的Recipe
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当删除"Ch2"的配方"test"并二次确认后
      那么删除"Ch2"的"test"成功
      并且下位机无法查找到"/Ch2/test;1"

    @pvd-lower
    @clean-lower-recipeOnly
    场景:不选择配方执行操作
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当未选择配方执行"保存配方"时
      那么执行失败,返回错误信息如下:
      """
      "请选择要保存的配方!"
      """
      当未选择配方执行"删除配方"时
      那么执行失败,返回错误信息如下:
      """
      "请选择要删除的配方!"
      """
      当未选择配方执行"另存为"时
      那么执行失败,返回错误信息如下:
      """
      "请选择要另存为的配方!"
      """
      当未选择配方执行"编辑"时
      那么执行失败,返回错误信息如下:
      """
      "请选择要编辑的配方!"
      """
      当未选择配方执行"撤销编辑"时
      那么执行失败,返回错误信息如下:
      """
      "请选择要撤销编辑的配方!"
      """

  Rule:另存为Rcp

    @pvd-lower
    @clean-lower-recipeOnly
    场景:另存为一个Recipe
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
      当选择"Ch2"的"test""另存为""dhn"并且二次确认后
      那么"Ch2"的"dhn"创建成功
      并且成功保存到下位机"/Ch2/dhn;1"中:
      """
      : {
          name: 'dhn',
          rcpClass: '/Ch2',
          version: '1',
          attrChgTime is AlmostNow,
          editTime is AlmostNow,
          verified: true,
          linked: false,
          editedBy: 'pe',
          approvalLvl: 0,
          body:  {
              steps: [
                      {
                        name: '1',
                        values: [...'step1'
                                ...]
                      }
                    ]
                  }
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:修改rcp参数后执行另存为是否有提示
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
        | RF        | 2     |
      当选择"Ch2"的"test"并"另存为"时
      那么执行失败,返回错误信息如下:
      """
      ="配方 test尚未保存，是否保存?"
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    场景:新建配方未保存时执行另存为
      假如创建"Ch2"的工艺配方"test"
      并且修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | Step Name | step1 |
      当执行"另存为"
      那么执行失败,返回错误信息如下:
      """
      ="配方 test尚未保存，是否保存?"
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:当recipe信息缺失,验证另存为功能
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当删除"Ch2"的"test"的PedTemp后"另存为"
      那么执行失败,返回错误信息如下:
      """
      ="请设置 PedTemp 监控值！"
      """

  Rule:导出Rcp

    @pvd-lower
    @clean-lower-recipeOnly
    @CleanDir
    场景: 成功导出文件
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当选择"Ch2"的"test"并"导出"名为"test.csv"的文件时
      那么提示信息为:
      """
      ="导出配方 test成功!"
      """
      并且导出路径存在文件"test.csv":
      """
      :[
        'Parameter,1',
        'Step Name,Step Name',
        'Step End Type,Time',
        'Step End Cond,',
        'Time,1',
        'RF,0',
        'RF Ramp,0',
        'Match,Auto',
        'O2FlowType,FlowToChamber',
        'O2,0',
        'Ar2FlowType,FlowToChamber',
        'Ar2,0',
        'H2FlowType,FlowToChamber',
        'H2,0',
        'H2EPFlowType,FlowToChamber',
        'H2EP,0',
        'ArBP,0',
        'ArEP,0',
        'ArSP,0',
        'Chuck,Off',
        'BSP,0',
        'BSF,0',
        'TVMode,FullOpen',
        'TVSetPoint,0',
        'Spacing,0',
        '',
        'Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0'
      ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:参数非法导出文件
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF        | 非法 |
      并且执行"导出"
      那么执行失败,返回错误信息如下:
      """
      ="RF输入类型错误！请输入Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1     |
        | RF        | 10001 |
      并且执行"导出"
      那么执行失败,返回错误信息如下:
      """
      ="RF 输入错误！请输入0到1500范围内的Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1  |
        | RF        | -1 |
      并且执行"导出"
      那么执行失败,返回错误信息如下:
      """
      ="RF 输入错误！请输入0到1500范围内的Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1 |
        | RF        | ? |
      并且执行"导出"
      那么执行失败,返回错误信息如下:
      """
      ="RF输入类型错误！请输入Double类型值！"
      """
      当修改"Ch2"的工艺配方"test"如下:
        | Parameter | 1 |
        | RF        | ？ |
      并且执行"导出"
      那么执行失败,返回错误信息如下:
      """
      ="RF输入类型错误！请输入Double类型值！"
      """

  Rule:步骤移动功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:步骤1和3可正确移动一次
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     | 3     |
        | Step Name | test1 | test2 | test3 |
      当移动1次步骤"1"和步骤"3"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: test2,
        2: test3,
        3: test1
      }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:步骤1和3可正确移动三次
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     | 3     |
        | Step Name | test1 | test2 | test3 |
      当移动3次步骤"1"和步骤"3"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      :{
        1:test1,
        2:test2,
        3:test3
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:复杂移动场景的正确性
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     | 3     |
        | Step Name | test1 | test2 | test3 |
      当移动1次步骤"3"和步骤"1"
      并且移动1次步骤"2"和步骤"1"
      并且移动1次步骤"1"和步骤"3"
      并且移动1次步骤"1"和步骤"2"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      :{
        1:test2,
        2:test3,
        3:test1
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:带有循环步骤的Rcp移动弹出框验证
      假如在"Ch2"存在配方"syx",步骤3是步骤1和步骤2循环2次
        | Parameter | 1     | 2     | 3[1-2;2] | 7     |
        | Step Name | test1 | test2 | test3    | test4 |
      那么移动Recipe步骤的起始位返回如下:
      """
      :[3,7]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证移动界面右侧下拉框内容
      假如在"Ch2"存在配方"syx",步骤3是步骤1和步骤2循环2次
        | Parameter | 1     | 2     | 3[1-2;2] | 7     |
        | Step Name | test1 | test2 | test3    | test4 |
      当移动Recipe步骤的起始位选择步骤3时
      那么移动Recipe步骤的目的位返回如下:
      """
      :[7]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 移动循环步骤后列名正确移动
      假如在"Ch2"存在配方"syx",步骤3是步骤1和步骤2循环2次
        | Parameter | 1     | 2     | 3[1-2;2] | 7     |
        | Step Name | test1 | test2 | test3    | test4 |
      当移动1次步骤"3"和步骤"7"
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        3,
        '4[1-2;2]'
        ]
      """

  Rule: 步骤复制功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证包含循环步骤的Rcp复制步骤时起始步骤下拉框选项
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      那么复制Recipe步骤的起始位返回如下:
      """
      =[1,2,3,8]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证包含循环步骤的Rcp复制步骤时目的步骤下拉框选项
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当复制Recipe步骤的起始位选择步骤3时
      那么复制Recipe步骤的目的位返回如下:
      """
      =[1,2,8]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 复制循环步骤中的步骤，检验结果
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
        | RF        | *     | 10    | *     | *        | *     |
      当复制Recipe步骤的步骤2到步骤3时
      那么步骤2和步骤3参数相同

  Rule: 循环设定功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 设置第一步为循环步骤，显示不是设置第一步
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当修改步骤"1"的循环设定
      那么抛出警告，信息为:
      """
      = 第一步不能被设置为循环步骤！请重新选择！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 设置被循环步骤包含的步骤为循环步骤，显示已被占用
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当修改步骤"2"的循环设定
      那么抛出警告，信息为:
      """
      = 该步骤已经被其他的循环步骤占用！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 更改循环步骤的循环设定
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当修改步骤"4[2-3;2]"的循环设定为步骤"1"和步骤"2"的循环3次设定
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        3,
        '4[1-2;3]',
        10
        ]
      """

  Rule: 步骤删除功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证不选择步骤点击删除的提示信息
      当创建"Ch2"的工艺配方"test"
      并且执行删除步骤操作时
      那么抛出警告，信息为:
      """
      = 请选择要删除的步骤！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除循环步骤包含的步骤的提示信息
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当删除步骤"2"并二次确定时
      那么抛出警告，信息为:
      """
      = 删除步骤失败，原因:被循环步骤占用的步骤2无法删除！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除循环步骤后的列名
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当删除步骤"4[2-3;2]"并二次确定时
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        3,
        4
        ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除第一步后的列名
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当删除步骤"1"并二次确定时
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        '3[1-2;2]',
        7
        ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除步骤时有二次确认提示
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     |
        | Step Name | test1 | test2 |
      当删除步骤"2"时
      那么出现提示信息:
      """
      = '请确认是否要删除步骤 2 ?'
      """


  Rule: 非编辑状态下点击步骤编辑中的各个按钮
    @pvd-lower
    @clean-lower-recipeOnly
    场景: 在非编辑状态下依次点击步骤编辑中的按钮
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | syx  | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当对"Ch2"的非编辑模式的工艺配方"syx""新建"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""删除"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""循环设定"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""复制"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""移动"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """

  Rule: 不选中Recipe的情况下点击步骤编辑中的各个按钮
    @pvd-lower
    @clean-lower-recipeOnly
    场景: 不选中Recipe的情况下点击步骤编辑中的各个按钮
      假如用户"pe"使用密码"8888"启动上位机
      当选择"Ch2"执行"新建"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"删除"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"循环设定"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"复制"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"移动"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """

  Rule: 步骤新建功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:新建第二步
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     |
        | Step Name | test1 |
      当执行"新建"步骤时
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: test1
        2: 'Step Name'
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:新建步骤插入到第一步前
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     |
        | Step Name | test1 |
      当执行"新建"步骤插入到第1步时
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: 'Step Name'
        2: test1
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证插入步骤弹框的内容显示正确
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      那么新建步骤中的插入步骤的结果显示如下:
      """
      = [1,2,4,8,9]
      """

