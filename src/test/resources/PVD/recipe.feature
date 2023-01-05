# language: zh-CN
功能: 配方

  @skip
  @pvd-lower
  @clean-lower-recipe
  @reset-ui-recipe
  @pvd-ui
  场景: 查询配方
    假如存在"RecipeClass":
      | name     | params[0](StringParam).name | params[1](StringParam).name |
      | /Ch2/sub | Step                        | Time                        |
    假如存在"Recipe":
      | name | rcpClass | comments                                                                                      |
      | rcp  | /Ch2/sub | Shutter:No,CyclePurge:No,ProcType:Ch2,HeaterTemp:43,HeaterTempST:2,HeaterTempHT:4,Increment:1 |
#    TODO transform to 假如存在"XXXX"
    当调用"recipe"的"storeRcpBody"接口时:
    """
    {
      "recipe": "/Ch2/sub/rcp;1",
      "body": [{
        "name": "1",
        "value": ["st", "200"]
      }],
      "override": true
    }
    """
    那么能查询到配方"/Ch2/sub/rcp":
    """
    : {
      shutter= No
      procType= Ch2
      increment= 1
      heaterTemp= 43
      heaterTempST= 2
      heaterTempHT= 4
      body: | Parameter | 1   |
            | Step      | st  |
            | Time      | 200 |
    }
    """
