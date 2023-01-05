# language: zh-CN
@skip

功能:Route的UI测试

  Rule:删除路径
    @pvd-lower
    @clean-lower-route
    场景:编辑-路径-删除-正在编辑时点击
      假如存在"Route":
    """
      [{
        "name": "route",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      },{
        "name": "route1",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
      """
      并且用户"pe"使用密码"8888"启动上位机
      当"删除"处于"编辑"状态的"route"时
      那么抛出警告，选择"取消"操作，信息为:
      """
      ="确定删除路径 route?"
      """
      当"删除"处于"编辑"状态的"route"并"确定"时
      那么提示信息为:
      """
        ="路径 route 已经被删除!"
      """
      并且成功删除"route"

    @pvd-lower
    @clean-lower-route
    @clean-lower-recipeOnly
    @pvd-ui
    场景:编辑-路径-删除-新建未保存时点击
      假如存在Route为"route":
        | 步骤 | 腔室  | 槽位 | 配方           |
        | 1  | LA  | 0  | /LA/test0;1  |
        | 2  | ChA | 0  | /ChA/test1;1 |
        | 3  | Ch2 | 0  | /Ch2/test2;1 |
        | 4  | Ch3 | 0  | /Ch3/test3;1 |
        | 5  | ChB | 0  | /ChB/test4;1 |
        | 6  | LB  | 0  | /LB/test5;1  |
      当"删除"处于"编辑"状态的"route"并"确定"时
      那么提示信息为:
      """
      = "路径 route 已经被删除!"
      """
      并且成功删除"route"

  Rule:查找路径
    @pvd-lower
    @clean-lower-route
    场景:路径查找功能验证-查找框中输入单字符(字母或数字)
      假如存在"Route":
    """
      [{
        "name": "abc",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      },{
        "name": "abe",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      },{
        "name": "abc1",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 2
            }]
        }]
      }]
      """
      当用户"pe"使用密码"8888"启动上位机
      并且查找"a"时,结果显示如下:
    """
    = [abc,abc1,abe]
    """
      当查找"c"时,结果显示如下:
    """
    =[abc,abc1]
    """
      当查找"1"时,结果显示如下:
    """
    =[abc1]
    """

    @pvd-lower
    @clean-lower-route
    场景:路径查找功能验证-查找框输入两个或三个字符(大小写字母)
      假如存在"Route":
    """
      [{
        "name": "Abc",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      },{
        "name": "abe",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      },{
        "name": "abc1",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 2
            }]
        }]
      }]
      """
      当用户"pe"使用密码"8888"启动上位机
      并且查找"Ab"时,结果显示如下:
    """
    = [Abc,abc1,abe]
    """
      当查找"bc"时,结果显示如下:
    """
    =[Abc,abc1]
    """
      当查找"be"时,结果显示如下:
    """
    =[abe]
    """
      当查找"ac"时,结果显示如下:
    """
    null
    """
      并且清除查找框后,界面显示如下:
    """
    =[Abc,abc1,abe]
    """

    @pvd-lower
    @clean-lower-route
    场景:路径查找功能验证-查找框包含特殊字符
      假如存在"Route":
    """
      [{
        "name": "Aa1_-bc",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
      """
      当用户"pe"使用密码"8888"启动上位机
      并且查找"Aa1_-bc"时,结果显示如下:
    """
    = [Aa1_-bc]
    """

  Rule:编辑路径(包含新建路径以及相关复杂场景验证)
    @pvd-lower
    @clean-lower-route
    场景:编辑-路径-切换列表-正在编辑已修改未保存时-路径完整-选择不保存
      假如存在"Route":
    """
        [{
        "name": "route",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          }]
        }]
      },{
        "name": "route1",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
    """
      并且用户"pe"使用密码"8888"启动上位机
      当选择"route"并"编辑"路径参数如下:
        | 左上方标题单元格 | 步骤 | 腔室 | 槽位 | 配方 |
        | 行 0      | 1  | LB | 1  | *  |
      并且选择Route"route1"
      那么抛出警告，选择"否"操作，信息为:
      """
      = '路径：route 尚未保存，是否要保存？'
      """
      并且"route"的路径参数如下:
    """
     =[
        {
          腔室: 'LA',
          步骤: 1,
          左上方标题单元格: '行 0',
          槽位: 0,
          配方: '(null)'
        }...
      ]
    """

    @pvd-lower
    @clean-lower-route
    场景:编辑-路径-切换列表-正在编辑已修改未保存时-路径完整-选择保存
      假如存在"Route":
    """
        [{
        "name": "route",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          }]
        }]
      },{
        "name": "route1",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
    """
      并且用户"pe"使用密码"8888"启动上位机
      当选择"route"并"编辑"路径参数如下:
        | 左上方标题单元格 | 步骤 | 腔室 | 槽位 | 配方 |
        | 行 0      | 1  | LB | 1  | *  |
      并且选择Route"route1"
      那么抛出警告，选择"是"操作，信息为:
      """
      = '路径：route 尚未保存，是否要保存？'
      """
      并且提示信息为:
    """
    ='路径：route 保存成功！'
    """
      并且"route"的路径参数如下:
    """
     =[
        {
          腔室: 'LB',
          步骤: 1,
          左上方标题单元格: '行 0',
          槽位: 1,
          配方: '(null)'
        }...
      ]
    """

    @pvd-lower
    @clean-lower-route
    场景:编辑-路径-未选择任何路径时执行删除,保存,另存为,导出,编辑
      假如存在"Route":
    """
      [{
        "name": "route",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      },{
        "name": "route1",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 1
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
      """
      并且用户"pe"使用密码"8888"启动上位机
      当未选择路径执行"删除"时
      那么执行失败，提示信息如下:
    """
    ="删除失败，当前路径选择为空！"
    """
      当未选择路径执行"保存"时
      那么执行失败，提示信息如下:
    """
    ="保存失败，当前路径选择为空！"
    """
      当未选择路径执行"另存为"时
      那么执行失败，提示信息如下:
    """
    ="另存为失败，当前路径选择为空！"
    """
      当未选择路径执行"导出"时
      那么执行失败，提示信息如下:
    """
    ="导出失败，当前路径选择为空！"
    """
      当未选择路径执行"编辑"时
      那么执行失败，提示信息如下:
    """
    ="请选择要编辑的路径！"
    """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    场景:编辑-路径-新建-未处于创建或编辑状态时点击新建
      当创建路径"route"时
      那么"route"创建成功，且参数列表为空
      当"删除"处于"编辑"状态的"route"并二次"确定"时
      并且"新建"路径"route"并执行"取消"
      那么未成功创建"route"

    @pvd-lower
    @clean-lower-route
    场景:编辑-路径-新建-正在编辑已修改未保存时点击-路径完整-选择不保存
      假如存在"Route":
      """
      [{
        "name": "route",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
      """
      并且用户"pe"使用密码"8888"启动上位机
      并且选择"route"并"编辑"路径参数如下:
        | 左上方标题单元格 | 步骤 | 腔室 | 槽位 | 配方 |
        | 行 0      | 1  | LA | 1  | *  |
        | 行 1      | 2  | LB | 0  | *  |
      当"新建""route2"时
      那么抛出警告并且执行"否"，信息为:
      """
      = '当前路径：route 尚未保存，是否要保存？'
      """
      当再次创建"route2"时
      并且"删除"处于"编辑"状态的"route2"并二次"确定"时
      那么"route"的路径参数如下:
      """
       =[
          {
            腔室: 'LA',
            步骤: 1,
            左上方标题单元格: '行 0',
            槽位: 0,
            配方: '(null)'
          },
          {
            腔室: 'LB',
            步骤: 1,
            左上方标题单元格: '行 1',
            槽位: 1,
            配方: '(null)'
          }
          ...
        ]
      """

    @pvd-lower
    @clean-lower-route
    场景:编辑-路径-新建-正在编辑已修改未保存时点击-路径完整-选择保存
      假如存在"Route":
      """
      [{
        "name": "route",
        "createtime": "2000-01-01T00:00:00",
        "modifytime": "2000-01-02T00:00:00",
        "steps": [{
          "visits": [{
            "station": "LA",
            "slot": 0
          },{
            "station": "LB",
            "slot": 1
            }]
        }]
      }]
      """
      并且用户"pe"使用密码"8888"启动上位机
      并且选择"route"并"编辑"路径参数如下:
        | 左上方标题单元格 | 步骤 | 腔室 | 槽位 | 配方 |
        | 行 0      | 1  | LA | 1  | *  |
        | 行 1      | 2  | LB | 0  | *  |
      当"新建""route2"时
      那么抛出警告，"确定"后并且二次确认，信息为:
      """
      = '当前路径：route 尚未保存，是否要保存？'
      """
      当再次创建"route2"时
      并且"删除"处于"编辑"状态的"route2"并二次"确定"时
      那么"route"的路径参数如下:
      """
       =[
          {
            腔室: 'LA',
            步骤: 1,
            左上方标题单元格: '行 0',
            槽位: 1,
            配方: '(null)'
          },
          {
            腔室: 'LB',
            步骤: 2,
            左上方标题单元格: '行 1',
            槽位: 0,
            配方: '(null)'
          }
          ...
        ]
      """

    @pvd-lower
    @clean-lower-route
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-route
    场景:编辑-路径-新建-正在编辑已修改未保存时点击-路径不完整
      假如存在Route为"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LA  | 0  |    |
        | 2  | ChA | 0  |    |
        | 3  | LB  | 0  |    |
      当选择"route"并"编辑"路径参数如下:
        | 左上方标题单元格 | 步骤 |
        | 行 1      | 1  |
      并且"新建""route2"时
      那么抛出警告并且执行"确定"，信息为:
      """
      = '无效路径! 路径必须以“LA”或“LB”开始！ 路径route保存失败！'
      """
      当选择第"1"行后对路径"route"执行编辑的"插入行"操作时
      并且"新建""route2"时
      那么抛出警告，信息如下:
      """
      = '第3行没有编辑完整，请继续编辑完成。'
      """
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 | 腔室  | 槽位 | 配方 |
        | 行 1      | 2  | ChC | 1  | *  |
        | 行 2      | 2  | ChA | 1  | *  |
        | 行 3      | 3  | ChE | 1  | *  |
      并且"新建""route2"时
      那么抛出警告，信息如下:
      """
      = '请以LB/LA结尾！'
      """

    @pvd-lower
    @clean-lower-route
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-allCreate-route
    场景:编辑-路径-新建-新建未保存时点击-路径不完整
      假如创建路径"route"时
      当"新建""route2"时
      那么抛出警告并且执行"确定"，信息为:
      """
      = '路径为空！ 路径route保存失败！'
      """
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 0      | 1  |
      并且"新建""route2"时
      那么抛出警告，信息如下:
      """
      = '第1行没有编辑完整，请继续编辑完成。'
      """
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 | 腔室  | 槽位 | 配方 |
        | 行 0      | 1  | LA  | 1  | *  |
        | 行 1      | 2  | ChC | 1  | *  |
        | 行 2      | 3  | ChE | 1  | *  |
      并且"新建""route2"时
      那么抛出警告，信息如下:
      """
      = '请以LB/LA结尾！'
      """
