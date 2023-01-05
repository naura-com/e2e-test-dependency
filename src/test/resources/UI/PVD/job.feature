# language: zh-CN
@skip
@clean-lower-route
功能:job界面
  Rule:新建
    场景: 新建一个job,查看任务名称中是否有
      当用户"pe"使用密码"8888"启动上位机
      那么新建任务"job"
      那么任务名称列表返回如下:
      """
      : [
          {
            任务名称: job
          }
        ]
      """

    场景:新建使用相同slot的job
      假如存在"Route":
        | name   |
        | route1 |
        | route2 |
      当用户"pe"使用密码"8888"启动上位机
      并且新建使用相同的槽位任务如下:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        },{
          "route": "route2",
          "slots":"1"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      那么提示信息为:
      """
      = "Slot1被路径route1和route2同时占用！请检查！"
      """

    场景:新建的任务在编辑状态下，再次新建任务有提示信息未保存当前路径
      假如存在"Route":
        | name   |
        | route1 |
      当用户"pe"使用密码"8888"启动上位机
      并且新建任务如下:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当再次新建任务时
      那么提示信息为:
      """
      = "有尚未保存的Job信息：job1，是否保存？"
      """

    场景: 创建路径时,不选择路径和槽位,再次新建路径
      当用户"pe"使用密码"8888"启动上位机
      并且不选择路径和槽位创建任务:
      """
      {
        "name": job1,
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当再次新建任务时
      并且保存未保存的任务时
      那么提示信息为:
      """
      = "任务'job1'保存失败，原因：工艺路径/槽位配置有误，请检查！"
      """

    场景: 创建路径时,不选择起始片盒和目的片盒,再次新建路径
      假如存在"Route":
        | name   |
        | route1 |
      当用户"pe"使用密码"8888"启动上位机
      并且不选择起始片盒和目的片盒创建任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当再次新建任务时
      并且保存未保存的任务时
      那么提示信息为:
      """
      = "任务'job1'保存失败，原因：起始片盒/目的片盒为空，请选择！"
      """

    场景: 创建路径时,输入非法的提示信息,再次新建路径时有提示信息
      假如存在"Route":
        | name   |
        | route1 |
      当用户"pe"使用密码"8888"启动上位机
      并且不选择起始片盒和目的片盒创建任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "0"
      }
      """
      当再次新建任务时
      那么提示信息为:
      """
      = "请输入1-999范围内的正整数！"
      """

    场景:新建的任务在编辑状态下，再次新建任务，不保存当前任务，检查任务列表
      假如存在"Route":
        | name   |
        | route1 |
      当用户"pe"使用密码"8888"启动上位机
      并且不选择起始片盒和目的片盒创建任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当再次新建任务时
      并且不保存未保存的任务时
      那么任务名称列表返回如下:
      """
      = [

        ]
      """

    场景: 新建任务当没有路径选择槽位时，有提示信息
      假如用户"pe"使用密码"8888"启动上位机
      并且不选择路径创建任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "slots": "1"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      那么提示信息为:
      """
      = "请先选择路径！"
      """

    场景: 新建的任务起始片盒和目的片盒不同时，有提示信息
      假如用户"pe"使用密码"8888"启动上位机
      当创建起始片盒和目的片盒不同的任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      那么提示信息为:
      """
      = "目的片盒与起始片盒不一致，是否要保持一致？"
      """

    场景: 新建的任务起始片盒和目的片盒不同时，选择保持一致
      假如用户"pe"使用密码"8888"启动上位机
      并且创建起始片盒和目的片盒不同的任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当将起始片盒和目的片盒保持一致时
      那么起始片盒为:
      """
      = "LP1"
      """
      并且目的片盒为:
      """
      = "LP1"
      """

    场景: 新建的任务起始片盒和目的片盒不同时，选择不保持一致
      假如用户"pe"使用密码"8888"启动上位机
      并且创建起始片盒和目的片盒不同的任务:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "1"
        }],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当将起始片盒和目的片盒不保持一致时
      那么起始片盒为:
      """
      = "LP1"
      """
      并且目的片盒为:
      """
      = "LP2"
      """

  Rule:保存
    场景:新建Job保存成功
      假如存在"Route":
        | name   |
        | route1 |
        | route2 |
      当用户"pe"使用密码"8888"启动上位机
      并且新建路径如下:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "3"
        },{
          "route": "route2",
          "slots":"6"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当执行"保存"时:
      那么"保存"成功,提示信息如下:
      """
      ="任务'job1'保存成功！"
      """
      并且"Job"应为:
      """
      :{
        "name": job1,
        "routes": [{
          "route": "route1",
          "slots": "[3]"
        },{
          "route": "route2",
          "slots":"[6]"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "isunload": "1",
        "cyclenum": "1"
      }
      """

    场景:编辑已存在的Job保存成功
      假如存在"Route":
        | name   |
        | route1 |
        | route2 |
      假如存在"Job":
        | name | routes[0].route | routes[0].slots | src | dest | mode | isunload | cyclenum | isprocess | ishigh | createtime          | modifytime          |
        | job2 | route1          | 1,2             | LP1 | LP1  | 串行模式 | 0        | 1        | 1         | 0      | 2000-01-01T00:00:00 | 2000-01-01T00:00:00 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"job2"的参数如下:
      """
      {
        "name": job2,
        "jobDetail": [{
          "route": "route1",
          "slots": "3"
        },
        {
          "route": "route2",
          "slots":"1,2,6"
        }],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当执行"保存"时:
      那么"保存"成功,提示信息如下:
      """
      ="任务'job2'保存成功！"
      """
      并且"Job"应为:
      """
      :{
        "name": job2,
        "routes": [
        {
          "route": "route1",
          "slots": "[3]"
        }
        {
          "route": "route2",
          "slots":"[1, 2, 6]"
        }],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "isunload": "1",
        "cyclenum": "1"
      }
      """

    场景:非法参数保存Job
      假如存在"Route":
        | name   |
        | route2 |
      假如存在"Job":
        | name | routes[0].route | routes[0].slots | src | dest | mode | isunload | cyclenum | isprocess | ishigh | createtime          | modifytime          |
        | job2 | route2          | 1,2             | LP1 | LP1  | 串行模式 | 0        | 1        | 1         | 0      | 2000-01-01T00:00:00 | 2000-01-01T00:00:00 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"job2"的参数如下:
        """
      {
        "name": job2,
        "jobDetail": [{
          "route": "route2",
          "slots": "3"
        }
        ],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1000"
      }
      """
      当执行"保存"时:
      那么提示信息如下:
      """
      ='请输入1-999范围内的正整数！'
      """

    场景:未选择槽位时取消保存
      假如存在"Route":
        | name   |
        | route2 |
      假如存在"Job":
        | name | routes[0].route | routes[0].slots | src | dest | mode | isunload | cyclenum | isprocess | ishigh | createtime          | modifytime          |
        | job2 | route2          | 1,2             | LP1 | LP1  | 串行模式 | 0        | 1        | 1         | 0      | 2000-01-01T00:00:00 | 2000-01-01T00:00:00 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"job2"的参数如下:
        """
      {
        "name": job2,
        "jobDetail": [{
          "route": "route2",
          "slots": ""
        }
        ],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当执行"保存"时:
      那么抛出以下提示信息:
      """
      :"当前编辑的任务中存在空的槽位，请确认是否要继续保存! \r

      点击“是”系统将只保存合法的路径信息，点击“否”将返回继续编辑！"
      """
      并且继续执行"否"操作时
      那么"Job"应为:
      """
      :{
        "name": job2,
        "routes": [
        {
          "route": "route2",
          "slots":"[1, 2]"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "isunload": "0",
        "cyclenum": "1"
      }
      """

    场景:未选择槽位时继续保存
      假如存在"Route":
        | name   |
        | route2 |
      假如存在"Job":
        | name | routes[0].route | routes[0].slots | src | dest | mode | isunload | cyclenum | isprocess | ishigh | createtime          | modifytime          |
        | job2 | route2          | 1,2             | LP1 | LP1  | 串行模式 | 0        | 1        | 1         | 0      | 2000-01-01T00:00:00 | 2000-01-01T00:00:00 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"job2"的参数如下:
        """
      {
        "name": job2,
        "jobDetail": [{
          "route": "route2",
          "slots": ""
        }
        ],
        "src": "LP1",
        "dest": "LP2",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当执行"保存"时:
      那么抛出以下提示信息:
      """
      :"当前编辑的任务中存在空的槽位，请确认是否要继续保存! \r

      点击“是”系统将只保存合法的路径信息，点击“否”将返回继续编辑！"
      """
      并且继续执行"是"操作时
      那么提示信息如下:
      """
      ="保存任务'job2'失败！原因：工艺路径/槽位配置有误，请检查！"
      """
      并且"Job"应为:
      """
      :{
        "name": job2,
        "routes": [
        {
          "route": "route2",
          "slots":"[1, 2]"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "isunload": "0",
        "cyclenum": "1"
      }
      """

  Rule:删除
    场景:删除正在新建的Job
      假如存在"Route":
        | name   |
        | route1 |
        | route2 |
      当用户"pe"使用密码"8888"启动上位机
      并且新建路径如下:
      """
      {
        "name": job1,
        "jobDetail": [{
          "route": "route1",
          "slots": "3"
        },{
          "route": "route2",
          "slots":"6"
        }],
        "src": "LP1",
        "dest": "LP1",
        "mode": "串行模式",
        "action": "卸载片盒",
        "cyctime": "1"
      }
      """
      当执行"删除"时并二次确认
      那么"删除"成功,提示信息如下:
      """
      ="任务'job1'删除成功！"
      """
      并且任务名称列表返回如下:
      """
      =[]
      """

    场景: 删除已存在的Job
      假如存在"Route":
        | name   |
        | route1 |
        | route2 |
      假如存在"Job":
        | name | routes[0].route | routes[0].slots | src | dest | mode | isunload | cyclenum | isprocess | ishigh | createtime          | modifytime          |
        | job2 | route1          | 1,2             | LP1 | LP1  | 串行模式 | 0        | 1        | 1         | 0      | 2000-01-01T00:00:00 | 2000-01-01T00:00:00 |
      并且用户"pe"使用密码"8888"启动上位机
      当选择"job2"并且执行"删除"时
      那么"删除"成功,提示信息如下:
      """
      ="任务'job2'删除成功！"
      """
      并且任务名称列表返回如下:
      """
      =[]
      """

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

    @pvd-lower
    @clean-lower-route
    场景:不选择任何job时执行删除,修改,保存
      当用户"pe"使用密码"8888"启动上位机
      并且未选择job执行"删除"时
      那么提示信息为:
      """
      ="请选择要删除的任务！"
      """
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

