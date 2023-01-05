# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
@clean-lower-recipe
#@skip
功能: 工艺配方比较界面

  背景:
    假如存在"defaultEtch1Rcp Recipe":
      | name | rcpClass |
      | test | /Process |
    假如存在已保存配方如下:
      | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     |
      | PM2 GDE | DryClean    | dtest      | Step Name | step1 | step2 |

  Rule: Compare

    场景: 所有均为空
      当直接点击Compare
      那么执行失败,弹出提示信息:
      """
      ="Please select a recipe!"
      """

    场景: PM B为空,PM A不为空
      假如"Choose PM A"选择"PM2 GDE"
      假如"Choose RecipeType A"选择"Process"
      假如"Choose Recipe A"选择"test"
      当直接点击Compare
      那么执行失败,弹出提示信息:
      """
      ="Please select a recipe!"
      """

    @etch1-clean-recipeCompare
    场景: Choose PM A有效,Choose RecipeType A为空,点击Choose Recipe A
      假如"Choose PM A"选择"PM2 GDE"
      假如"Choose RecipeType A"选择""
      当直接点击"Choose Recipe A"
      那么执行失败,弹出提示信息:
      """
      ="Please select the recipe type!"
      """

    @etch1-clean-recipeCompare
    场景: Choose PM A为空,点击Choose RecipeType A
      假如"Choose PM A"选择""
      当直接点击"Choose RecipeType A"
      那么执行失败,弹出提示信息:
      """
      ="Please select a pm first!"
      """

    @etch1-clean-recipeCompare
    场景: Choose PM A和Choose PM B类型不同
      假如"Choose PM A"选择"PM2 GDE","Choose RecipeType A"选择"Process","Choose Recipe A"选择"test"
      假如"Choose PM B"选择"PM2 GDE","Choose RecipeType B"选择"DryClean","Choose Recipe B"选择"dtest"
      假如"Page"选择"SetPoint"
      当直接点击Compare
      那么执行失败,弹出提示信息:
      """
      ="Please select the same chamber type!"
      """

  Rule: Page

    @etch1-clean-recipeCompare
    场景: Page为空,提示信息验证
      假如"Choose PM A"选择"PM2 GDE","Choose RecipeType A"选择"Process","Choose Recipe A"选择"test"
      假如"Choose PM B"选择"PM2 GDE","Choose RecipeType B"选择"Process","Choose Recipe B"选择"test"
      假如"Page"选择""
      当直接点击Compare
      那么执行失败,弹出提示信息:
      """
      ="Please select the page type first!"
      """

  Rule: View All

    # TODO:需要获取对应位置的颜色
#    场景: View All验证
#      假如"Choose PM A"选择"PM2 GDE","Choose RecipeType A"选择"Process","Choose Recipe A"选择"test"
#      假如"Choose PM B"选择"PM2 GDE","Choose RecipeType B"选择"Process","Choose Recipe B"选择"test"
#      假如"Page"选择"SetPoint"
#      当选中"View All"
#      并且直接点击Compare
#      那么显示所有

    @etch1-clean-recipeCompare
    场景: View All和View Differences无法同时勾选验证
      当选中"View All"
      那么"View All"被勾选,"View Differences"未被勾选
      当选中"View Differences"
      那么"View Differences"被勾选,"View All"未被勾选

  Rule: Clear

    @clean-lower-recipe
    场景: Clear验证
      假如存在已保存配方如下:
        | PMName  | RecipeClass | RecipeName | Parameter | 1     | 2     | 3     |
        | PM2 GDE | DryClean    | dtest2     | Step Name | step1 | step2 | step3 |
      假如已比较"PM2 GDE"的"DryClean"的"dtest"和"dtest2"的"View All"
      当执行Clear操作
      那么比较列表数据清空成功
