# language: zh-CN
@skip
@pvd-lower
@clean-lower-recipeOnly
功能:清洁参数界面
  Rule:移动配方
    场景:左右移动配方
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当选择"test"左移到大于等于空闲配方时
      那么大于等于空闲配方栏显示配方如下
      """
      =['test']
      """
      当选择"test"右移出大于等于空闲配方时
      那么大于等于空闲配方栏显示配方如下
      """
      =[]
      """

    场景:上下移动配方
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当选择"test"左移到大于等于空闲配方时
      并且选择"test"下移到小于空闲时间配方时
      并且小于空闲配方栏显示配方如下
      """
      =['test']
      """
      当选择"test"上移到大于等于空闲配方时
      并且大于等于空闲配方栏显示配方如下
      """
      =['test']
      """