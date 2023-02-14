# language: zh-CN
@skip
功能:Recipe

  @pvd-lower
  @clean-lower-recipeOnly
    #TODO CI上偶发会挂掉，原因未知
  场景:recipe命名检查
    假如存在"defaultRcp Recipe":
      | name  | rcpClass | comments                                         |
      | test1 | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
    并且用户"pe"使用密码"8888"启动上位机
    当选择"Ch2"腔室且"新建配方""test1"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='该配方名称已存在！'
    """
    当新建配方""时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='配方名称不能为空！'
    """
    当新建配方"111"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='请勿输入数字或中横线开头的字符串！'
    """
    当新建配方"-test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='请勿输入数字或中横线开头的字符串！'
    """
    当新建配方"test311111111111111111111111111"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"test?"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"测试"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"\test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """

  @pvd-lower
  @clean-lower-recipe
    #TODO CI上偶发会挂掉，原因未知
  场景:子腔室recipe命名检查
    假如存在一个RecipeClass:
      """
      {
        "name": "/Ch2/newSubClass",
        "params": [{
          "name": "StringStep",
          "type": "S",
          "defaultValue": "a-default",
          "dataObj": "a-dataObj",
          "maxLength": 128
        }, {
          "name": "Time",
          "type": "D",
          "defaultValue": "0",
          "dataObj": "double-obj",
          "min": 0.0,
          "max": 3600.0,
          "unit": "sec",
          "accuracy": 0.1
        }]
      }
      """
    并且存在"defaultRcp Recipe":
      | name  | rcpClass         | comments                                         |
      | test1 | /Ch2/newSubClass | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
    并且用户"pe"使用密码"8888"启动上位机
    当选择"Ch2/newSubClass"腔室且"新建配方""test1"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='该配方名称已存在！'
    """
    当新建配方"111"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='请勿输入数字或中横线开头的字符串！'
    """
    当新建配方"-test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='请勿输入数字或中横线开头的字符串！'
    """
    当新建配方"test311111111111111111111111111"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"test?"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"测试"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"\test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方""时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='配方名称不能为空！'
    """

  @pvd-lower
  @clean-lower-recipeOnly
  场景:参数值输入的合法性验证
    假如存在"defaultRcp Recipe":
      | name | rcpClass | comments                                         |
      | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
    并且用户"pe"使用密码"8888"启动上位机
    当修改"Ch2"的工艺配方"test"如下:
      | Parameter | 1    |
      | RF        | 2000 |
    并且执行"保存配方"
    那么执行失败,返回错误信息如下:
    """
    ='RF 输入错误！请输入0到1500范围内的Double类型值！'
    """
    当修改"Ch2"的工艺配方"test"如下:
      | Parameter | 1     |
      | RF        | -test |
    并且执行"保存配方"
    那么执行失败,返回错误信息如下:
    """
    ='RF输入类型错误！请输入Double类型值！'
    """
    当修改"Ch2"的工艺配方"test"如下:
      | Parameter | 1  |
      | RF        | 测试 |
    并且执行"保存配方"
    那么执行失败,返回错误信息如下:
    """
    ='RF输入类型错误！请输入Double类型值！'
    """
    当修改"Ch2"的工艺配方"test"如下:
      | Parameter | 1     |
      | RF        | \test |
    并且执行"保存配方"
    那么执行失败,返回错误信息如下:
    """
    ='RF输入类型错误！请输入Double类型值！'
    """

  @pvd-lower
  @clean-lower-recipeOnly
    #TODO CI上偶发会挂掉，原因未知
  场景:PedTemp设值合法性验证
    假如存在"defaultRcp Recipe":
      | name | rcpClass | comments                                         |
      | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
    并且用户"pe"使用密码"8888"启动上位机
    当执行"编辑"操作修改"Ch2"的"test"的PedTemp的值为"1000"
    那么执行失败,"HeaterTemp"报错信息如下
    """
    ='PedTemp设置错误！请输入不大于450的数！'
    """
    当执行"编辑"操作修改"Ch2"的"test"的PedTemp余度的值为"1000"
    那么执行失败,"HeaterTol"报错信息如下
    """
    ='PedTemp余度设置错误！请输入不大于450的数！'
    """

  @pvd-lower
  @clean-lower-recipeOnly
    #TODO CI上偶发会挂掉，原因未知
  场景:另存为失败场景综合
    假如存在"defaultRcp Recipe":
      | name | rcpClass | comments                                         |
      | test | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
    并且用户"pe"使用密码"8888"启动上位机
    当选择"Ch2"腔室且"另存为""test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='该配方名称已存在！'
    """
    当新建配方"111"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='请勿输入数字或中横线开头的字符串！'
    """
    当新建配方"-test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='请勿输入数字或中横线开头的字符串！'
    """
    当新建配方"test311111111111111111111111111"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"test?"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"测试"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方"\test"时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='输入字符格式或长度错误(长度应不超过30)！'
    """
    当新建配方""时
    那么执行失败,"recipe命名"报错信息如下
    """
    ='配方名称不能为空！'
    """

#  #TODO 虚拟机文件小红锁问题
#  Rule:导入Rcp
#    @skip
#    @pvd-lower
#    @clean-lower-recipeOnly
#    @pvd-ui
#    场景:导入成功
#      假如本地存在有效参数的配置文件"test.csv":
#      当选择"test.csv""导入"到"Ch2"时
#      那么提示信息为:
#      """
#      ="导入配方 test成功!"
#      """
#      并且配方参数如下:
#      """
#      =[
#        {Parameter: "Step Name", 1: "Step Name"},
#        {Parameter: "Step End Type", 1: "Tme"},
#        {Parameter: "Step End Cond", 1: "(null)"},
#        {Parameter: "Time", 1: 0},
#        {Parameter: "RF", 1: 0},
#        {Parameter: "RF Ramp", 1: 0},
#        {Parameter: "Match", 1: "Auto"},
#        {Parameter: "O2FlowType", 1: "FlowToChamber"},
#        {Parameter: "O2", 1: 0},
#        {Parameter: "Ar2FlowType", 1: "FlowToChamber"},
#        {Parameter: "Ar2", 1: 0},
#        {Parameter: "H2FlowType", 1: "FlowToChamber"},
#        {Parameter: "H2", 1: 0},
#        {Parameter: "H2EPFlowType", 1:"FlowToChamber"},
#        {Parameter: "H2EP", 1:0},
#        {Parameter: "ArBP", 1: 0},
#        {Parameter: "ArEP", 1: 0},
#        {Parameter: "ArSP", 1: 0},
#        {Parameter: "Chuck", 1: "Off"},
#        {Parameter: "BSP", 1: 0},
#        {Parameter: "BSF", 1: 0},
#        {Parameter: "TVMode", 1: "FullOpen"},
#        {Parameter: "TVSetPoint", 1: 0},
#        {Parameter: "Spacing", 1: 0}
#        ]
#      """
#
#    场景:已存在Rcp
#      假如"D:\pvd_scope_300_std-pvd_scope_300_std_1.4.0_RC_03"存在配方文件"test.csv"
#        | name | rcpClass |
#        | test | /Ch2     |
#      并且下位机已存在配方文件"test.csv"
#      当执行"导入"操作时
#      那么导入失败,提示"导入配方test.csv失败!原因:导入配方失败!配方/Ch2/test;1已经存在!"
#
#    场景:导入非法文件
#      假如"D:\pvd_scope_300_std-pvd_scope_300_std_1.4.0_RC_03"存在无效参数的配方文件<FileName>:
#        | FileName          | pedTemp | RF    | H2     | O2 |
#        | test.txt          |         |       |        |    |
#        | EmptyPedTemp.csv  |         | 1     | 1      | 1  |
#        | RFOutOfRange.csv  | 10      | 36001 | 1      | 1  |
#        | O2NotExist.csv    | 10      | 36001 | 1      |    |
#        | WrongTypeOfH2.csv | 10      | 1     | string | 1  |
#      当执行"导入"操作时导入"test.txt"时
#      那么导入失败,提示信息为"导入配方test.txt失败!原因:获取配方失败!请检查文件的步骤号"
#      当执行"导入"操作时导入"EmptyPedTemp.csv"时
#      那么导入失败,提示信息为
#      当执行"导入"操作时导入"RFOutOfRange.csv"时
#      那么导入失败,提示信息为"导入配方RFOutOfRange.csv失败!原因:参数验证失败:步骤号'x',RF输入有误!请输入0到1500范围内的double类型值"
#      当执行"导入"操作时导入"O2NotExist.csv"时
#      那么导入失败,提示信息为"导入配方O2NotExist.csv失败!原因:在文件O2NotExist中找不到参数‘O2’!"
#      当执行"导入"操作时导入"WrongTypeOfH2.csv"时
#      那么导入失败,提示信息为"导入配方WrongTypeOfH2.csv失败!原因:参数验证失败:步骤号'x',H2输入类型有误!请输入double类型值!"
#
#    场景: 导出功能（配方已存在）,是否有提示
#      假如存在"Recipe":
#        | name | rcpClass |
#        | test | /Ch2     |
#      当执行"导出"操作到"D:\pvd_scope_300_std-pvd_scope_300_std_1.4.0_RC_03"时
#      那么导出失败,提示"test.csv已存在.要替换它吗?"