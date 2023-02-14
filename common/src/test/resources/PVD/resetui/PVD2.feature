# language: zh-CN
@pvd-ui-mock
@reset-feature-ui
@skip
功能: 新建配方

  场景: 首次创建Recipe （duanhn&guox）
    假如存在pe的RecipeClass"Ch1"的如下"RemoteParamInfo"
      | name | defaultValue |
      | step | 1            |
    当创建名称为"test1"且Class为"Ch1"的Recipe时
    那么以如下的RemoteRecipeInfo注册Recipe成功
      | name  |
      | test1 |
