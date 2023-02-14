# language: zh-CN
@skip
@clean-lower-route
功能:编辑路径界面
  Rule:批量导出
    场景:验证批量导出的提示信息
      假如存在"Route":
      """
      {
        "name": "route2",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 0
            }]
        }]
      }
      """
      当用户"pe"使用密码"8888"启动上位机
      并且"批量导出"路径时
      那么提示信息为:
      """
      = "导出路径完成！成功：1，失败：0。"
      """

    场景:验证批量导出的文件内容
      假如存在"Route":
      """
      {
        "name": "route2",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 0
            }]
        }]
      }
      """
      当用户"pe"使用密码"8888"启动上位机
      并且"批量导出"路径时
      那么文件内容为:
      """
      =[
          {
          name: route2.csv,
          info: [
                "StepNum,Chamber,SlotNum,ProcessRcp,IdleInterval,IdleRcp,ShortIdleRcp,PeriodicInterval,PeriodicRcp,SwitchRcp,NormalRcp",
                "1,LA,0,,,,,,,,",
                "1,LB,0,,,,,,,,"
                ]
          }
        ]
      """

  Rule:导出路径
    场景:验证导出路径的提示信息
      假如存在"Route":
      """
      {
        "name": "route2",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          }]
        },{
          "visits": [{
            "station": "LB",
            "slot": 0
          }]
        }]
      }
      """
      并且用户"pe"使用密码"8888"启动上位机
      当"导出"路径"route2"时
      那么提示信息为:
      """
      = "导出路径 route2成功!"
      """

    场景:验证导出路径的文件内容
      假如存在"Route":
      """
      {
        "name": "route2",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 0
            }]
        }]
      }
      """
      当用户"pe"使用密码"8888"启动上位机
      并且"导出"路径"route2"时
      那么文件内容为:
      """
      =[
          {
          name: route2.csv,
          info: [
                "StepNum,Chamber,SlotNum,ProcessRcp,IdleInterval,IdleRcp,ShortIdleRcp,PeriodicInterval,PeriodicRcp,SwitchRcp,NormalRcp",
                "1,LA,0,,,,,,,,",
                "1,LB,0,,,,,,,,"
                ]
          }
        ]
      """

    场景: 导出路径存在同名文件,导出文件覆盖
      假如在路径"C:\test\Route"存在文件"route2.csv":
        | StepNum | Chamber | SlotNum | ProcessRcp | IdleInterval | IdleRcp | ShortIdleRcp | PeriodicInterval | PeriodicRcp | SwitchRcp | NormalRcp |
        | 1       | LA      | 0       |            |              |         |              |                  |             |           |           |
        | 2       | LA      | 0       |            |              |         |              |                  |             |           |           |
      并且存在"Route":
      """
      {
        "name": "route2",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          }]
        },{
          "visits": [{
            "station": "LB",
            "slot": 0
          }]
        }]
      }
      """
      当用户"pe"使用密码"8888"启动上位机
      并且"导出"路径"route2"覆盖"route2.csv"时
      那么文件内容为:
      """
      =[
          {
          name: route2.csv,
          info: [
                "StepNum,Chamber,SlotNum,ProcessRcp,IdleInterval,IdleRcp,ShortIdleRcp,PeriodicInterval,PeriodicRcp,SwitchRcp,NormalRcp",
                "1,LA,0,,,,,,,,",
                "2,LB,0,,,,,,,,"
                ]
          }
        ]
      """

  Rule:另存为路径
    场景:正确的路径另存为
      假如存在"Route":
      """
      {
        "name": "route2",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          }]
        },{
          "visits": [{
            "station": "LB",
            "slot": 0
          }]
        }]
      }
      """
      并且用户"pe"使用密码"8888"启动上位机
      当"route2"另存为"saveAs"时
      那么"saveAs"内容为:
      """
      : [
          {
              腔室: LA,
              步骤: 1,
              槽位: 0,
              配方: "(null)"
          },
          {
              腔室: LB,
              步骤: 2,
              槽位: 0,
              配方: "(null)"
          }
          ...
      ]
      """

    场景: 空路径另存为
      假如用户"pe"使用密码"8888"启动上位机
      并且新建路径"Empty"
      当另存为"Empty"时
      那么提示信息为:
      """
      = 路径为空！
      """

    场景:错误路径另存为
      假如用户"pe"使用密码"8888"启动上位机
      并且新增如下路径"errorRoute":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LA  | 0  |    |
        | 2  | ChC | 0  |    |
      当另存为"Empty"时
      那么显示错误信息为:
      """
      = "请以LB/LA结尾！"
      """

  Rule: 保存路径
    场景: 不选择路径进行保存
      假如用户"pe"使用密码"8888"启动上位机
      当保存路径时
      那么提示信息为:
      """
      ="保存失败，当前路径选择为空！"
      """

    场景: 保存一个正确路径提示保存成功
      假如用户"pe"使用密码"8888"启动上位机
      并且新增如下路径"CorrectRoute":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
        | 2  | LB | 0  |    |
      当保存路径"CorrectRoute"时
      那么提示信息为:
      """
      ="路径 CorrectRoute 保存成功!"
      """

    场景:保存一个空路径
      假如用户"pe"使用密码"8888"启动上位机
      并且新建路径"Empty"
      当保存路径"Empty"时
      那么提示信息为:
      """
      = 路径为空！
      """

    场景:保存一个错误路径
      假如用户"pe"使用密码"8888"启动上位机
      并且新增如下路径"errorRoute":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LA  | 0  |    |
        | 2  | ChC | 0  |    |
      当保存路径"errorRoute"时
      那么显示错误信息为:
      """
      = "请以LB/LA结尾！"
      """

    场景: 保存正确路径验证数据库
      假如用户"pe"使用密码"8888"启动上位机
      并且新增如下路径"CorrectRoute":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
        | 2  | LB | 0  |    |
      当保存路径"CorrectRoute"时
      那么所有"Route"应为:
      """
      : [{
        name: CorrectRoute
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          }]
        },{
          "visits": [{
            "station": "LB",
            "slot": 0
          }]
        }]
      }]
      """















