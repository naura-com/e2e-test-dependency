# language: zh-CN
@skip
功能: 工艺配方界面

  Rule:配方创建时间控件
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    场景: 创建时间控件显示为配方创建时间
      假如创建"Ch2"的工艺配方"test1"
      那么能查询到配方"test"的创建时间为:
      """
      is AlmostNow
      """

  Rule:配方修改时间控件
    @pvd-lower
    @clean-lower-recipeOnly
    场景: 修改时间控件显示为配方修改时间
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | syx  | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当修改"Ch2"的工艺配方"syx":
        | parameter | value | value2 |
        | Step Name | step1 | step2  |
      并且保存后
      那么能查询到配方"test"的修改时间为:
      """
      is AlmostNow
      """

  Rule:配方创建者控件
    @pvd-lower
    @clean-lower-recipeOnly
    场景: pe创建配方显示为pe
      假如用户"pe"使用密码"8888"启动上位机
      当创建"Ch2"的工艺配方"test1"
      那么能查询到创建者为"pe"

  Rule:配方查找功能
    @pvd-lower
    @clean-lower-recipeOnly
    场景:单字符查询
      假如存在"defaultRcp Recipe":
        | name               | rcpClass | comments                                         |
        | contains-c         | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | not-contain        | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | another-contains-c | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      并且在"Ch2"中查找"c"时,结果显示如下:
      """
      = [contains-c, another-contains-c]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:双字符查询-不区分大小写
      假如存在"defaultRcp Recipe":
        | name        | rcpClass | comments                                         |
        | contains-Ab | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | not-contain | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
        | contains-ab | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      并且在"Ch2"中查找"Ab"时,结果显示如下:
      """
      = [contains-Ab, contains-ab]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景:特殊字符查询
      假如存在"defaultRcp Recipe":
        | name    | rcpClass | comments                                         |
        | Aa1_-bc | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      并且在"Ch2"中查找"Aa1_-bc"时,结果显示如下:
      """
      = [Aa1_-bc]
      """

  Rule:步骤移动功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:步骤1和3可正确移动一次
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     | 3     |
        | Step Name | test1 | test2 | test3 |
      当移动1次步骤"1"和步骤"3"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: test2,
        2: test3,
        3: test1
      }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:步骤1和3可正确移动三次
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     | 3     |
        | Step Name | test1 | test2 | test3 |
      当移动3次步骤"1"和步骤"3"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      :{
        1:test1,
        2:test2,
        3:test3
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:复杂移动场景的正确性
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     | 3     |
        | Step Name | test1 | test2 | test3 |
      当移动步骤时:
        | time | step1 | step2 |
        | 1    | 3     | 1     |
        | 1    | 2     | 1     |
        | 1    | 1     | 3     |
        | 1    | 1     | 2     |
#      当移动1次步骤"3"和步骤"1"
#      并且移动1次步骤"2"和步骤"1"
#      并且移动1次步骤"1"和步骤"3"
#      并且移动1次步骤"1"和步骤"2"
      那么"Parameter"的"Step Name"参数返回如下:
      """
      :{
        1:test2,
        2:test3,
        3:test1
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:带有循环步骤的Rcp移动弹出框验证
      假如在"Ch2"存在配方"syx",步骤3是步骤1和步骤2循环2次
        | Parameter | 1     | 2     | 3[1-2;2] | 7     |
        | Step Name | test1 | test2 | test3    | test4 |
      那么移动Recipe步骤的起始位返回如下:
      """
      :[3,7]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证移动界面右侧下拉框内容
      假如在"Ch2"存在配方"syx",步骤3是步骤1和步骤2循环2次
        | Parameter | 1     | 2     | 3[1-2;2] | 7     |
        | Step Name | test1 | test2 | test3    | test4 |
      当移动Recipe步骤的起始位选择步骤3时
      那么移动Recipe步骤的目的位返回如下:
      """
      :[7]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 移动循环步骤后列名正确移动
      假如在"Ch2"存在配方"syx",步骤3是步骤1和步骤2循环2次
        | Parameter | 1     | 2     | 3[1-2;2] | 7     |
        | Step Name | test1 | test2 | test3    | test4 |
      当移动1次步骤"3"和步骤"7"
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        3,
        '4[1-2;2]'
        ]
      """

  Rule: 步骤复制功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证包含循环步骤的Rcp复制步骤时起始步骤下拉框选项
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      那么复制Recipe步骤的起始位返回如下:
      """
      =[1,2,3,8]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证包含循环步骤的Rcp复制步骤时目的步骤下拉框选项
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当复制Recipe步骤的起始位选择步骤3时
      那么复制Recipe步骤的目的位返回如下:
      """
      =[1,2,8]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 复制循环步骤中的步骤，检验结果
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
        | RF        | *     | 10    | *     | *        | *     |
      当复制Recipe步骤的步骤2到步骤3时
      那么步骤2和步骤3参数相同

  Rule: 循环设定功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 设置第一步为循环步骤，显示不是设置第一步
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当修改步骤"1"的循环设定
      那么抛出警告，信息为:
      """
      = 第一步不能被设置为循环步骤！请重新选择！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 设置被循环步骤包含的步骤为循环步骤，显示已被占用
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当修改步骤"2"的循环设定
      那么抛出警告，信息为:
      """
      = 该步骤已经被其他的循环步骤占用！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 更改循环步骤的循环设定
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当修改步骤"4[2-3;2]"的循环设定为步骤"1"和步骤"2"的循环3次设定
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        3,
        '4[1-2;3]',
        10
        ]
      """

  Rule: 步骤删除功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证不选择步骤点击删除的提示信息
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当执行删除步骤操作时
      那么抛出警告，信息为:
      """
      = 请选择要删除的步骤！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除循环步骤包含的步骤的提示信息
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当删除步骤"2"并二次确定时
      那么抛出警告，信息为:
      """
      = 删除步骤失败，原因:被循环步骤占用的步骤2无法删除！
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除循环步骤后的列名
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当删除步骤"4[2-3;2]"并二次确定时
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        3,
        4
        ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除第一步后的列名
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当删除步骤"1"并二次确定时
      那么步骤列名返回如下:
      """
      =[
        Parameter,
        1,
        2,
        '3[1-2;2]',
        7
        ]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证删除步骤时有二次确认提示
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     | 2     |
        | Step Name | test1 | test2 |
      当删除步骤"2"时
      那么出现提示信息:
      """
      = '请确认是否要删除步骤 2 ?'
      """


  Rule: 非编辑状态下点击步骤编辑中的各个按钮
    @pvd-lower
    @clean-lower-recipeOnly
    场景: 在非编辑状态下依次点击步骤编辑中的按钮
      假如存在"defaultRcp Recipe":
        | name | rcpClass | comments                                         |
        | syx  | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      并且用户"pe"使用密码"8888"启动上位机
      当对"Ch2"的非编辑模式的工艺配方"syx""新建"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""删除"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""循环设定"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""复制"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """
      当对"Ch2"的非编辑模式的工艺配方"syx""移动"步骤时
      那么抛出警告，信息为:
      """
      = 当前配方为非编辑状态！
      """

  Rule: 不选中Recipe的情况下点击步骤编辑中的各个按钮
    @pvd-lower
    @clean-lower-recipeOnly
    场景: 不选中Recipe的情况下点击步骤编辑中的各个按钮
      假如用户"pe"使用密码"8888"启动上位机
      当选择"Ch2"执行"新建"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"删除"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"循环设定"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"复制"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """
      当选择"Ch2"执行"移动"步骤时
      那么抛出警告，信息为:
      """
      = 请选择要编辑的配方！
      """

  Rule: 步骤新建功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:新建第二步
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     |
        | Step Name | test1 |
      当执行"新建"步骤时
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: test1
        2: 'Step Name'
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:新建步骤插入到第一步前
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     |
        | Step Name | test1 |
      当执行"新建"步骤插入到第1步时
      那么"Parameter"的"Step Name"参数返回如下:
      """
      : {
        1: 'Step Name'
        2: test1
        }
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景: 验证插入步骤弹框的内容显示正确
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      当执行"新建"步骤时
      那么插入步骤的结果显示如下:
      """
      = [1,2,4,8,9]
      """

  Rule: 工艺配方显示功能
    @pvd-lower
    @clean-lower-recipeOnly
    场景: 所有一级RcpClass存在Recipe,界面能否显示
      假如存在"defaultRcp Recipe":
        | name   | rcpClass | comments                                               |
        | Ch2Rcp | /Ch2     | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0       |
        | Ch3Rcp | /Ch3     | Shutter:No,ProcType:Ch3,PedTemp:100,PedTempTol:0       |
        | ChARcp | /ChA     | Shutter:No,ProcType:ChA,PedTemp:,PedTempTol:           |
        | ChBRcp | /ChB     | Shutter:No,ProcType:ChB,PedTemp:,PedTempTol:           |
        | ChCRcp | /ChC     | Shutter:No,ProcType:ChC,HeaterTemp:100,HeaterTempTol:0 |
        | ChDRcp | /ChD     | Shutter:No,ProcType:ChD,HeaterTemp:,HeaterTempTol:     |
      当用户"pe"使用密码"8888"启动上位机
      那么查看"Ch2"的配方时,配方显示如下:
      """
      = [Ch2Rcp]
      """
      那么查看"Ch3"的配方时,配方显示如下:
      """
      = [Ch3Rcp]
      """
      那么查看"ChA"的配方时,配方显示如下:
      """
      = [ChARcp]
      """
      那么查看"ChB"的配方时,配方显示如下:
      """
      = [ChBRcp]
      """
      那么查看"ChC"的配方时,配方显示如下:
      """
      = [ChCRcp]
      """
      那么查看"ChD"的配方时,配方显示如下:
      """
      = [ChDRcp]
      """

    @pvd-lower
    @clean-lower-recipeOnly
    场景: 二级RcpClass包含Recipe,界面能否显示
      假如存在"defaultRcp Recipe":
        | name      | rcpClass   | comments                                         |
        | Ch3_Purge | /Ch3/Purge | Shutter:No,ProcType:Ch2,PedTemp:100,PedTempTol:0 |
      当用户"pe"使用密码"8888"启动上位机
      那么查看"Ch3/Purge"的配方时,配方显示如下:
      """
      = [Ch3_Purge]
      """

  Rule: 配方保存按钮功能
    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:未设置PedTemp参数时有提示信息
      假如在"Ch2"存在配方"syx":
        | Parameter | 1     |
        | Step Name | test1 |
      当"保存配方"时
      那么抛出警告，信息为:
      """
      = '请设置 PedTemp 监控值！'
      """

    @pvd-lower
    @clean-lower-recipeOnly
    @pvd-ui
    @clean-create-recipe
    场景:循环步骤是否保存正确
      假如在"Ch2"存在配方"syx",步骤4是步骤2和步骤3循环2次
        | Parameter | 1     | 2     | 3     | 4[2-3;2] | 8     |
        | Step Name | test1 | test2 | test3 | test4    | test8 |
      并且执行"新建"步骤插入到第2步时
      当设置PedTemp的值为100,PedTempTol的值为0
      并且"保存配方"时
      那么成功保存到下位机"/Ch2/syx;1"中:
      """
      : {
          body:{
            steps:[{
              name: '1'
            },{
              name: '2'
            },{
              name: '3'
            },{
              name: '4'
            },{
              name: '5[3-4;2]'
            },{
              name: '9'
            }]
          }
        }
      """




