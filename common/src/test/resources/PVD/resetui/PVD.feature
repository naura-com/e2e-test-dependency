# language: zh-CN
@pvd-ui-mock
@skip
功能: 新建配方

  场景: 首次创建Recipe （duanhn&guox）
    假如存在pe的RecipeClass"Ch1"的如下"RemoteParamInfo"
      | name | defaultValue |
      | step | 1            |
    当创建名称为"test1"且Class为"Ch1"的Recipe时
    那么以如下的RemoteRecipeInfo注册Recipe成功
      | name  |
      | test1 |

#    那么Recipe创建成功 /Process/Rcp0;1
#      | Step Name | Time | Pressure | Source DC | Source DC Ramp | Ar 1 | N2 | Gate Valve | Process Position | SpaceCompensation | TimeCompensation | PowerCompensation |
#      | 1         | 0    | 10       | 0         | 0              | 0    | 0  | Full       | ProcessPos       | disable           | disable          | disable           |
#    并且创建了如下Recipe属性
#      | editedBy | comments | version | approvalLvl | rcpClass |
#      | pe       |          | 1       | 0           | /Process |

#  场景:独占模式取出Rcp
#    假如用户“CTC”下存在rcpID为"Process/Test;1"的配方
#    当用户"CTC"独占模式取出“Process/Test;1”时
#    那么取出成功
#
#    假如用户“CTC”下存在rcpID为"Process/Test;1"的配方
#    当用户"GUI"独占模式取出下的“Process/Test;1”时
#    那么抛出异常“InvalidNameException”
#
#    假如用户“CTC”和"GUI"下存在rcpID为"Process/Test;1"的配方
#    当用户"CTC"独占模式取出下的“Process/Test;1”,
#    并且用户“GUI”独占模式取出下的“Process/Test;1”,
#    那么抛出异常“DuplicatedException”
#
#  场景:释放Rcp
#    假如用户“CTC”和"GUI"下存在rcpID为"Process/Test;1"的配方
#    当用户"CTC"独占模式取出下的“Process/Test;1”后并释放“Process/Test;1”
#    并且用户“GUI”独占模式取出下的“Process/Test;1”,
#    那么用户“GUI”取出“Process/Test;1”成功
#
#  场景:独占模式下修改Recipe的参数
#    假如用户“CTC”下存在rcpID为"Process/Test;1"的配方
#    并且在索引"1"处有“Time”参数为“5”
#    当用户"CTC"独占模式修改"Time"参数为“10”时
#    那么"Process/Test;1"中的"Time"为“10”
#
#    假如用户“CTC”和"GUI"下存在rcpID为"Process/Test;1"的配方
#    并且在索引"1"处有“Time”参数为“5”
#    当用户"CTC"独占模式修改"Time"参数为“10”,
#    并且用户“GUI”独占模式修改"Time"参数为"20"
#    那么用户“GUI”修改失败，抛出异常
