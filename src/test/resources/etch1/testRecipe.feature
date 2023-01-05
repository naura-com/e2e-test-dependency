# language: zh-CN
@skip
功能: Recipe test
  Rule:界面显示功能
    @ETCH-PM2-lower
    @clean-lower-recipe
    @etch1-clean-lower-route
    场景: 创建recipe
      假如存在"defaultEtch1Rcp Recipe":
        | name | rcpClass |
        | test | /Process |