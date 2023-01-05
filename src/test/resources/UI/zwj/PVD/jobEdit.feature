# language: zh-CN
@skip
功能:JOB界面

  Rule:修改
    @pvd-lower
      @clean-lower-route
      @pvd-ui
      @clean-all-job
    场景大纲:修改job参数成功:<title>
      假如存在如下defaultRoute
        | name   |
        | route1 |
        | route2 |
      并且存在如下Job
        | name | 路径和槽位    | 起始片盒 | 目的片盒 | 调度模式 | 卸载片盒  | 循环次数 |
        | job  | route1:1 | LP1  | LP1  | 串行模式 | false | 1    |
      当编辑job"job"参数:
        | <param> |
        | <value> |
      那么job信息显示如下:
        | <param> |
        | <value> |
      例子:
        | title  | param | value    |
        | 编辑路径   | 路径    | 0:route2 |
        | 编辑槽位   | 槽位    | 0:2,8    |
        | 编辑起始片盒 | 起始片盒  | LP2      |
        | 编辑调度模式 | 调度模式  | 管道模式     |
        | 编辑卸载片盒 | 卸载片盒  | true     |
        | 编辑循环次数 | 循环次数  | 5        |

    @pvd-lower
      @clean-lower-route
      @pvd-ui
      @clean-all-job
    场景大纲:存在job修改参数后不保存切换其他job是否有提示:<title>
      假如存在如下defaultRoute
        | name   |
        | route1 |
        | route2 |
      并且存在如下Job
        | name    | 路径和槽位    | 起始片盒 | 目的片盒 | 调度模式 | 卸载片盒  | 循环次数 |
        | job     | route1:1 | LP1  | LP1  | 串行模式 | false | 1    |
        | EditJob | route1:1 | LP1  | LP1  | 串行模式 | false | 1    |
      当编辑job"EditJob"参数:
        | <param> |
        | <value> |
      并且选择job"job"
      那么抛出警告，选择"取消"操作，信息为:
      """
      = "有尚未保存的Job信息：EditJob，是否保存？"
      """
      例子:
        | title  | param | value    |
        | 编辑路径   | 路径    | 0:route2 |
        | 编辑槽位   | 槽位    | 0:2,8    |
        | 编辑起始片盒 | 起始片盒  | LP2      |
        | 编辑调度模式 | 调度模式  | 管道模式     |
        | 编辑卸载片盒 | 卸载片盒  | true     |
        | 编辑循环次数 | 循环次数  | 5        |

      #TODO 软件bug
#    @pvd-lower
#      @clean-lower-route
#      @pvd-ui
#      @clean-all-job
#    场景大纲:存在job修改参数后不保存切换其他job并且不保存:<title>
#      假如存在如下defaultRoute
#        | name        |
#        | route       |
#        | selectRoute |
#        | EditRoute   |
#      并且存在如下Job
#        | name      | 路径和槽位         | 起始片盒 | 目的片盒 | 调度模式 | 卸载片盒  | 循环次数 |
#        | selectJob | selectRoute:1 | LP1  | LP1  | 串行模式 | false | 1    |
#        | EditJob   | route:1       | LP1  | LP1  | 串行模式 | false | 1    |
#      当编辑job"EditJob"参数:
#        | <param> |
#        | <value> |
#      并且选择job"selectJob"后选择"取消"操作
#      那么job信息显示如下:
#        | 路径            |
#        | 0:selectRoute |
#      并且job"EditJob"信息显示如下:
#        | 路径      | 槽位  | 起始片盒 | 目的片盒 | 调度模式 | 卸载片盒  | 循环次数 |
#        | 0:route | 0:1 | LP1  | LP1  | 串行模式 | false | 1    |
#      例子:
#        | title  | param | value       |
#        | 编辑路径   | 路径    | 0:EditRoute |
#        | 编辑槽位   | 槽位    | 0:2,8       |
#        | 编辑起始片盒 | 起始片盒  | LP2         |
#        | 编辑调度模式 | 调度模式  | 管道模式        |
#        | 编辑卸载片盒 | 卸载片盒  | true        |
#        | 编辑循环次数 | 循环次数  | 5           |

    @pvd-lower
      @clean-lower-route
      @pvd-ui
      @clean-all-job
    场景大纲:存在job修改参数后不保存切换其他job并且保存:<param>
      假如存在如下defaultRoute
        | name        |
        | route       |
        | selectRoute |
        | EditRoute   |
      并且存在如下Job
        | name      | 路径和槽位         | 起始片盒 | 目的片盒 | 调度模式 | 卸载片盒  | 循环次数 |
        | selectJob | selectRoute:1 | LP1  | LP1  | 串行模式 | false | 1    |
        | EditJob   | route:1       | LP1  | LP1  | 串行模式 | false | 1    |
      当编辑job"EditJob"参数:
        | <param> |
        | <value> |
      并且选择job"selectJob"后选择"确定"操作
      那么抛出提示，信息为:
      """
      = "任务'EditJob'保存成功！"
      """
      并且job信息显示如下:
        | 路径            |
        | 0:selectRoute |
      并且job"EditJob"信息显示如下:
        | <param> |
        | <value> |
      例子:
        | title  | param | value       |
        | 编辑路径   | 路径    | 0:EditRoute |
        | 编辑槽位   | 槽位    | 0:2,8       |
        | 编辑起始片盒 | 起始片盒  | LP2         |
        | 编辑调度模式 | 调度模式  | 管道模式        |
        | 编辑卸载片盒 | 卸载片盒  | true        |
        | 编辑循环次数 | 循环次数  | 5           |

      #TODO 软件bug
    @pvd-lower
    @clean-lower-route
    场景:不选择任何job时执行删除,修改,保存
      当用户"pe"使用密码"8888"启动上位机
      并且未选择job执行"删除"时
      那么提示信息为:
    """
    ="请选择要删除的任务！"
    """
#      当未选择job执行"保存"时
#      那么提示信息为:
#    """
#    ="请选择要保存的任务！"
#    """
      当未选择job执行"修改"时
      那么提示信息为:
    """
    ="请选择要修改的任务！"
    """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-all-job
    场景:job编辑槽位选择全部
      假如存在如下defaultRoute
        | name  |
        | route |
      并且新建job"job":
        | 路径      |
        | 0:route |
      当编辑job"job"的第"0"路径的槽位为全部
      那么job信息显示如下:
        | 槽位                                                                  |
        | 0:1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25 |

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-all-job
    场景:job的路径可选项--第一个路径
      假如存在如下defaultRoute
        | name   |
        | route1 |
        | route2 |
      当新建空job"job":
      那么第"0"行的路径返回如下:
      """
      = [route1,route2]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-all-job
    场景:job的路径可选项--已有路径被选择
      假如存在如下defaultRoute
        | name   |
        | route1 |
        | route2 |
      当新建job"job":
        | 路径       |
        | 0:route1 |
      那么第"1"行的路径返回如下:
      """
      = [route2]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-all-job
    场景:job的起始片盒和目的片盒可选项
      当新建空job"job":
      那么起始片盒可选项返回如下
       """
      = [LP1,LP2,LP3]
      """
      并且目的片盒可选项返回如下
      """
      = [LP1,LP2,LP3]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-all-job
    场景:选择起始片盒后目的片盒自动填充
      当新建job"job":
        | 起始片盒 |
        | LP1  |
      那么job信息显示如下:
        | 目的片盒 |
        | LP1  |

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-all-job
    场景:修改起始片盒后目的片盒自动修改
      当新建job"job":
        | 起始片盒 |
        | LP1  |
      当编辑job参数:
        | 起始片盒 |
        | LP2  |
      那么job信息显示如下:
        | 目的片盒 |
        | LP2  |



