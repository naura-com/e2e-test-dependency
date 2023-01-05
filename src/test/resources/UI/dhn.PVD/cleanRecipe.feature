# language: zh-CN
@skip
@pvd-lower
@clean-lower-recipeOnly
功能:cleanRcp
  Rule:刷新配方
    场景:刷新配方正确显示
      假如存在"defaultRcp Recipe":
        | name  | rcpClass | comments                                         |
        | test0 | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | test1 | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | test2 | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当执行"刷新配方"后
      那么配方显示如下
      """
      =['test0','test1','test2']
      """

  Rule:设置空闲时间
    场景:设置空闲时间成功
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当设置空闲时间为"10"时
      那么设置成功，空闲时间为10秒

    场景:非法输入空闲时间
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当设置空闲时间为"10000"时
      那么设置失败，提示信息如下
      """
      ='输入超出范围！请输入[0-2000]范围内的值！'
      """
      当设置空闲时间为"abc"时
      那么设置失败，提示信息如下
      """
      ='非法输入！'
      """
      当设置空闲时间为""时
      那么设置失败，提示信息如下
      """
      ='参数为空！'
      """

  Rule:设置周期晶片数
    场景:设置周期晶片数成功
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当设置周期晶片数为"20"时
      那么设置成功，周期晶片数为20

    场景:非法输入周期晶片数
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当设置周期晶片数为"100000"时
      那么设置失败，提示信息如下
      """
      ='输入超出范围！请输入[1-10000]范围内的值！'
      """
      当设置周期晶片数为"abc"时
      那么设置失败，提示信息如下
      """
      ='非法输入！'
      """
      当设置周期晶片数为""时
      那么设置失败，提示信息如下
      """
      ='参数为空！'
      """

  #TODO 验证文件格式
  Rule:保存
    场景:保存配方成功
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      并且选择"test"左移到大于等于空闲配方时
      当设置空闲时间为"10"时
      并且设置周期晶片数为"20"时
      当执行保存时
      那么大于等于空闲配方栏显示配方如下
      """
      =['test']
      """
      并且下位机文件应为:
      """
      config.Setup['Ch2CleanRule.xml'].lines: [
        ...
        /.*10.*/
        /.*20.*/
        ...
      ]
      """
