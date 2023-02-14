# language: zh-CN
@skip
@pvd-lower
@clean-lower-recipe
@clean-route
@pvd-ui
功能: 路径

  背景:
    假如存在"Recipe":
      | name  | rcpClass |
      | rcp-c | /ChC     |
    当调用"recipe"的"storeRcpBody"接口时:
    """
    {
      "recipe": "/ChC/rcp-c;1",
      "body": [{
        "name": "1",
        "value": ["st", "200", "1.0"]
      }],
      "override": true
    }
    """

  场景: 查询路径
    假如存在"Route":
    """
    {
      "name": "route",
      "createtime": "2000-01-01T00:00:00",
      "modifytime": "2000-01-02T00:00:00",
      "steps": [{
        "visits": [{
          "station": "ChC",
          "slot": 1,
          "recipe": {
            "name": "rcp-c",
            "rcpClass": "/ChC",
            "version": 1
          }
        }]
      }]
    }
    """
    并且重新启动上位机
    那么能查询到路径"route":
    """
    : | 步骤 | 腔室 | 槽位 | 配方         |
      | 1   | ChC | 1    |/ChC/rcp-c;1 |
      | ...                            |
    """

  场景: 创建路径
    并且重新启动上位机
    当新增如下路径"route":
      | 步骤 | 腔室  | 槽位 | 配方           |
      | 1  | ChC | 1  | /ChC/rcp-c;1 |
    那么所有"Route"应为:
    """
    : [{
      name: route
      steps: [{
        visits: [{
          station: ChC
          slot: 1
          recipe: {
            name: rcp-c
            rcpClass: '/ChC'
            version: '1'
          }
        }]
      }]
    }]
    """
