# language: zh-CN
@skip
@clean-lower-route
功能:维护配方
  Rule: 新建
    场景:腔室Pmacro配置为空时新建维护配方，有提示信息
      假如用户"pe"使用密码"8888"启动上位机
      当在"Ch2"新建维护配方时
      那么提示信息为:
      """
      = "腔室PMacro步骤类型配置为空！"
      """

    场景:新建一个维护配方，配方列表中有新建的配方
      假如用户"pe"使用密码"8888"启动上位机
      当在"ChC"新建维护配方"test"时
      那么配方列表如下:
      """
      =[test]
      """

    场景:新建一个维护配方，新建页面中的腔室信息正确
      假如用户"pe"使用密码"8888"启动上位机
      当在"ChC"新建维护配方时
      那么工艺腔室为:
      """
      = "ChC"
      """

    场景:新建一个没有步骤的维护配方，切换腔室时，有提示信息
      假如用户"pe"使用密码"8888"启动上位机
      当在"ChC"新建维护配方"test"时
      并且切换到"Ch2"时
      那么提示信息为:
      """
      = "当前PMacro配方步骤不能为空，请添加步骤！"
      """

  Rule:保存
    场景:保存一个步骤为空的维护配方，有提示信息
      假如用户"pe"使用密码"8888"启动上位机
      当在"ChC"新建维护配方"test"时
      并且保存时
      那么提示信息为:
      """
      = "当前PMacro配方步骤不能为空，请添加步骤！"
      """

    场景:保存一个步骤参数错误的维护配方，有提示信息
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤"Cycle Purge"且不输入参数时
      并且保存时
      那么提示信息为:
      """
      = "无法保存，请检查是否存在未填项或者输入不正确的项！"
      """

    场景:保存一个正确的维护配方
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: ROR,
          param: [
                  PumpTime: "10",
                  RorWarningSpec: "20",
                  RorAlarmSpec: "30"
                  ]
        }
      ]
      """
      并且保存时
      那么提示信息为:
      """
      = "保存成功"
      """

  Rule:步骤操作
    场景:上移一次，验证维护配方步骤的上移按钮
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: ROR,
          param: [
                  PumpTime: "10",
                  RorWarningSpec: "20",
                  RorAlarmSpec: "30"
                  ]
        },{
          name: Shutter,
        }
      ]
      """
      并且将步骤"2"上移1次
      那么步骤列表内容为:
      """
      : [
          ...
          "Shutter",
          "ROR"
          ...
        ]
      """

    场景:上移两次，验证维护配方步骤的上移按钮
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: ROR,
          param: [
                  PumpTime: "10",
                  RorWarningSpec: "20",
                  RorAlarmSpec: "30"
                  ]
        },{
          name: Shutter,
        },{
          name: Unshutter
        }
      ]
      """
      并且将步骤"3"上移2次
      那么步骤列表内容为:
      """
      : [
          "",
          "",
          "",
          "",
          "",
          "Unshutter",
          "",
          "",
          "",
          "",
          "ROR",
          "ROR",
          "",
          "",
          "",
          "",
          "",
          "",
          "Shutter"
        ]
      """

    场景: 下移移动，验证陪护配方步骤的下移按钮
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: ROR,
          param: [
                  PumpTime: "10",
                  RorWarningSpec: "20",
                  RorAlarmSpec: "30"
                  ]
        },{
          name: Shutter,
        }
      ]
      """
      并且将步骤"1"下移1次
      那么步骤列表内容为:
      """
      : [
          ...
          "Shutter",
          "ROR"
          ...
        ]
      """

    场景:下移两次，验证维护配方步骤的上移按钮
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: ROR,
          param: [
                  PumpTime: "10",
                  RorWarningSpec: "20",
                  RorAlarmSpec: "30"
                  ]
        },{
          name: Shutter,
        },{
          name: Unshutter
        }
      ]
      """
      并且将步骤"1"下移2次
      那么步骤列表内容为:
      """
      : [
          "",
          "",
          "",
          "",
          "",
          "Shutter",
          "",
          "",
          "",
          "",
          "Unshutter",
          "",
          "",
          "",
          "",
          "ROR",
          "ROR",
          "",
          ""
        ]
      """

    场景: 删除步骤，验证是否删除成功
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: ROR,
          param: [
                  PumpTime: "10",
                  RorWarningSpec: "20",
                  RorAlarmSpec: "30"
                  ]
        },{
          name: Shutter,
        },{
          name: Unshutter
        }
      ]
      """
      并且将步骤"1"删除
      那么步骤列表内容为:
      """
      : [
          "",
          "",
          "",
          "",
          "",
          "Shutter",
          "",
          "",
          "",
          "",
          "Unshutter"
        ]
      """

  Rule:维护配方删除操作
    场景: 删除一个维护配方，验证提示信息
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当删除"test"时
      那么配方列表如下:
      """
      = []
      """

  Rule:维护配方另存为
    场景:另存为一个没有步骤的维护配方
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当把"test"另存为时
      那么提示信息为:
      """
      = "当前PMacro配方步骤不能为空，请添加步骤！"
      """

    场景:另存为一个正确的维护配方
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"新建维护配方"test"时
      当添加步骤如下时:
      """
      [
        {
          name: Shutter,
        }
      ]
      """
      当把"test"另存为"test2"时
      那么配方列表如下:
      """
      = [test,test2]
      """

  Rule:修改维护配方
    场景:新增步骤
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"存在维护配方"test":
      """
      [
        {
          name: Shutter,
        }
      ]
      """
      当修改"ChC"中的维护配方"test"新增步骤:
      """
      [
        {
          name: Unshutter,
        }
      ]
      """
      那么步骤列表内容为:
      """
      : [
          "",
          "",
          "",
          "",
          "",
          "Shutter",
          "",
          "",
          "",
          "",
          "Unshutter"
        ]
      """

    场景:删除步骤
      假如用户"pe"使用密码"8888"启动上位机
      并且在"ChC"存在维护配方"test":
      """
      [
        {
          name: Shutter,
        },{
          name: Unshutter
        }
      ]
      """
      当修改"ChC"中的维护配方"test"删除步骤"1"时
      那么步骤列表内容为:
      """
      : [
          "",
          "",
          "",
          "",
          "",
          "Unshutter"
        ]
      """












