# language: zh-CN
@skip
功能: 配方

  @pvd-ui-mock
  场景: 首次创建Recipe 1
    假如存在pe的RecipeClass"Ch1"的如下"RemoteParamInfo"
      | name | defaultValue |
      | step | 1            |
    当创建名称为"test1"且Class为"Ch1"的Recipe时
    那么以如下的RemoteRecipeInfo注册Recipe成功
      | name  |
      | test1 |

  @pvd-ui-mock
  @reset-feature-ui
  场景: 首次创建Recipe 2
    假如存在pe的RecipeClass"Ch1"的如下"RemoteParamInfo"
      | name | defaultValue |
      | step | 1            |
    当创建名称为"test1"且Class为"Ch1"的Recipe时
    那么以如下的RemoteRecipeInfo注册Recipe成功
      | name  |
      | test1 |

  @pvd-ui-mock
  @reset-scenario-ui
  场景: 首次创建Recipe 2
    假如存在pe的RecipeClass"Ch1"的如下"RemoteParamInfo"
      | name | defaultValue |
      | step | 1            |
    当创建名称为"test1"且Class为"Ch1"的Recipe时
    那么以如下的RemoteRecipeInfo注册Recipe成功
      | name  |
      | test1 |

  @pvd-lower
  @clean-lower-recipe
  场景: 获取所有Recipe
    假如存在"Recipe":
      | name  | version | rcpClass |
      | test0 | 1       | /Ch1     |
    当调用"recipe"的"getAllRecipe"接口时
    那么返回如下:
      """
      = [ '/Ch1/test0;1' ]
      """

  @pvd-lower
  @clean-lower-recipe
  @pvd-ui
  场景: 创建新Recipe2
    当创建名称为"test1"且Class为"Ch1"的Recipe时

  @pvd-lower
  @clean-lower-recipe
  场景: 获取所有Recipe
    假如存在"Recipe":
      | name  | version | rcpClass |
      | test0 | 1       | /Ch1     |
    当调用"recipe"的"getAllRecipe"接口时
    那么返回如下:
      """
      = [ '/Ch1/test0;1' ]
      """
