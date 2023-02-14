# language: zh-CN
@skip
功能: 工艺配方界面

  Rule:新建配方未保存切换recipe
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

  Rule:编辑配方参数未保存切换recipe
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

  Rule:编辑配方comment未保存切换recipe
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

  Rule:新建配方未保存切换腔室

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


  Rule:编辑配方参数未保存切换腔室
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


  Rule:编辑comment未保存切换腔室
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
