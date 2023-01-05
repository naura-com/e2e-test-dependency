# language: zh-CN
@skip
@clean-lower-route
功能:job
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