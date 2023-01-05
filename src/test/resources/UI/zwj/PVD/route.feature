# language: zh-CN
@skip
功能: route界面

  Rule:编辑route-清除
    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:取消route的编辑-清除操作
      假如存在Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
      当对路径"route"执行编辑的"清除"操作时
      那么抛出警告，选择"取消"操作，信息为:
       """
      = '确认清除当前路径全部内容？'
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LA", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:确定route的编辑-清除操作
      假如存在Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
      当对路径"route"执行编辑的"清除"操作时
      那么抛出警告，选择"确定"操作，信息为:
       """
      = '确认清除当前路径全部内容？'
      """
      并且路径显示如下:
      """
      = [
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 0",槽位: "(null)",配方: "(null)"}
        ]
      """

  Rule:编辑route-删除行
    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:不选择行时点击删除行
      假如存在Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
      当对路径"route"执行编辑的"删除行"操作时
      那么抛出对话框，信息为:
      """
      = "请选择需要删除的行！"
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LA", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:选择单元格时点击删除行
      假如存在Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
      当选择单元格"0,槽位"后对路径"route"执行编辑的"删除行"操作时
      那么抛出对话框，信息为:
      """
      = "请选择需要删除的行！"
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LA", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:删除第一步没有并行步骤的路径的第一行
      假如存在Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LA | 0  |    |
      当选择第"0"行后对路径"route"执行编辑的"删除行"操作时
      那么抛出对话框，信息为:
      """
      = "请不要将第一步全部删除！"
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LA", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:删除第一步有并行步骤的路径的第一行
      假如存在Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 1  | LA  | 0  |    |
        | 2  | ChC | 0  |    |
        | 3  | LA  | 0  |    |
      当选择第"0"行后对路径"route"执行编辑的"删除行"操作时
      那么抛出警告，信息为:
      """
      = "请确认是否删除选中行？"
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LA", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "ChC", 步骤: 2,左上方标题单元格: "行 1",槽位: 0,配方: "(null)"},
         {腔室: "LA", 步骤: 3,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 3",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:删除路径的非第一步的串行步骤
      假如存在Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 2  | ChE | 0  |    |
        | 3  | ChC | 0  |    |
        | 4  | LA  | 0  |    |
      当选择第"1"行后对路径"route"执行编辑的"删除行"操作时
      那么抛出警告，信息为:
      """
      = "请确认是否删除选中行？"
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "ChC", 步骤: 2,左上方标题单元格: "行 1",槽位: 0,配方: "(null)"},
         {腔室: "LA", 步骤: 3,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 3",槽位: "(null)",配方: "(null)"}
        ]
      """

  Rule:编辑route-插入行
    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:选择最后一个空行后执行插入行
      假如存在Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LB | 0  |    |
      当选择第"1"行后对路径"route"执行编辑的"插入行"操作时
      那么抛出对话框，信息为:
      """
      = "请不要在最后一行编辑行后插入行"
      """
      并且路径显示如下:
      """
      = [
         {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:选择非最后一个空行的行后执行插入行
      假如存在Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 2  | ChC | 0  |    |
        | 3  | LB  | 0  |    |
      当选择第"1"行后对路径"route"执行编辑的"插入行"操作时
      并且编辑路径参数并保存:
        | 左上方标题单元格 | 步骤 | 腔室  | 槽位 | 配方 |
        | 行 2      | 3  | ChE | 0  | *  |
      那么路径显示如下:
      """
      = [
        {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "ChC", 步骤: 2,左上方标题单元格: "行 1",槽位: 0,配方: "(null)"},
         {腔室: "ChE", 步骤: 3,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
         {腔室: "LB", 步骤: 4,左上方标题单元格: "行 3",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 4",槽位: "(null)",配方: "(null)"}
        ]
      """

  Rule:选择Chamber
    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证VTR2可达到的腔室--从CHA/CHB
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 2  | ChA | 0  |    |
        | 2  | ChB | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 3      | 3  |
      那么第"3"行的"腔室"返回如下:
      """
      = ["LB","LA","ChE","ChC","Ch2","Ch3"]
      """

    #TODO:软件存在bug
#    @pvd-lower
#    @clean-lower-route
#    @pvd-ui
#    @clean-allCreate-route
#    场景:验证VTR2可达到的腔室--从Ch2，并行
#      假如新建Route"route":
#        | 步骤 | 腔室  | 槽位 | 配方 |
#        | 1  | LB  | 0  |    |
#        | 2  | ChA | 0  |    |
#        | 2  | ChB | 0  |    |
#        | 3  | Ch2 | 0  |    |
#      当编辑路径参数:
#        | 左上方标题单元格 | 步骤 |
#        | 行 4      | 3  |
#      那么第"4"行的"腔室"返回如下:
#      """
#      = ["Ch3","ChA","ChB"]
#      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证VTR2可达到的腔室--从Ch2，串行
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 2  | ChA | 0  |    |
        | 2  | ChB | 0  |    |
        | 3  | Ch2 | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 4      | 4  |
      那么第"4"行的"腔室"返回如下:
      """
      = ["Ch3","ChA","ChB"]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证VTR1可达到的腔室--从LA/LB
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LB | 0  |    |
        | 1  | LA | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 2      | 2  |
      那么第"2"行的"腔室"返回如下:
      """
      = ["ChE","ChC","ChA","ChB"]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证VTR1可达到的腔室--从ChE，并行
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 1  | LA  | 0  |    |
        | 2  | ChE | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 3      | 2  |
      那么第"3"行的"腔室"返回如下:
      """
      = ["ChC","ChA","ChB"]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证VTR1可达到的腔室--从ChE，串行
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 1  | LA  | 0  |    |
        | 2  | ChE | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 3      | 3  |
      那么第"3"行的"腔室"返回如下:
      """
      = ["LB","LA","ChC","ChA","ChB"]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证第一步可选腔室
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 0      | 1  |
      那么第"0"行的"腔室"返回如下:
      """
      = ["LB","LA"]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证第一步可选腔室--并行
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LB | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 1      | 1  |
      那么第"1"行的"腔室"返回如下:
      """
      = ["LA"]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证空白步骤没有可选腔室
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
      那么第"0"行的"腔室"返回如下:
      """
      = []
      """

  Rule:选择Step
    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证在并行步骤之间插入行的步骤
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LB | 0  |    |
        | 1  | LA | 0  |    |
      当选择第"0"行后对路径"route"执行编辑的"插入行"操作时
      那么第"1"行的"步骤"返回如下:
      """
      = [1]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证在串行步骤之间插入行的步骤
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 2  | ChE | 0  |    |
      当选择第"0"行后对路径"route"执行编辑的"插入行"操作时
      那么第"1"行的"步骤"返回如下:
      """
      = [1,2]
      """

#TODO 软件存在bug
#    @pvd-lower
#    @clean-lower-route
#    @pvd-ui
#    @clean-allCreate-route
#    场景:验证在串行步骤之间插入并行步骤
#      假如新建Route"route":
#        | 步骤 | 腔室  | 槽位 | 配方 |
#        | 1  | LB  | 0  |    |
#        | 2  | ChE | 0  |    |
#      当选择第"0"行后对路径"route"执行编辑的"插入行"操作时
#      并且编辑路径参数:
#        | 左上方标题单元格 | 步骤 |
#        | 行 1      | 1  |
#      那么路径显示如下:
#      """
#      = [
#         {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
#         {腔室: "(null)", 步骤: 1,左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"},
#         {腔室: "ChE", 步骤: 2,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
#         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 3",槽位: "(null)",配方: "(null)"}
#        ]
#      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:验证在串行步骤之间插入串行步骤
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 2  | ChE | 0  |    |
      当选择第"0"行后对路径"route"执行编辑的"插入行"操作时
      并且编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 1      | 2  |
      那么路径显示如下:
      """
      = [
         {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: 2,左上方标题单元格: "行 1",槽位: "(null)",配方: "(null)"},
         {腔室: "ChE", 步骤: 3,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 3",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:并行步骤第二个节点步骤
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 1  | LA  | 0  |    |
        | 2  | ChE | 0  |    |
      那么第"1"行的"步骤"返回如下:
      """
      = [1,2]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:重新选择并行步骤第二个节点步骤为当前步
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 1  | LA  | 0  |    |
        | 2  | ChE | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 1      | 1  |
      那么路径显示如下:
      """
      = [
         {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "LA", 步骤: 1,左上方标题单元格: "行 1",槽位: 0,配方: "(null)"},
         {腔室: "ChE", 步骤: 2,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 3",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:重新选择并行步骤第二个节点步骤为下一步
      假如新建Route"route":
        | 步骤 | 腔室  | 槽位 | 配方 |
        | 1  | LB  | 0  |    |
        | 1  | LA  | 0  |    |
        | 2  | ChE | 0  |    |
      当编辑路径参数:
        | 左上方标题单元格 | 步骤 |
        | 行 1      | 2  |
      那么路径显示如下:
      """
      = [
         {腔室: "LB", 步骤: 1,左上方标题单元格: "行 0",槽位: 0,配方: "(null)"},
         {腔室: "LA", 步骤: 2,左上方标题单元格: "行 1",槽位: 0,配方: "(null)"},
         {腔室: "ChE", 步骤: 3,左上方标题单元格: "行 2",槽位: 0,配方: "(null)"},
         {腔室: "(null)", 步骤: "(null)",左上方标题单元格: "行 3",槽位: "(null)",配方: "(null)"}
        ]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:最后一步(非第一步)可选步骤
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
        | 1  | LB | 0  |    |
      那么第"1"行的"步骤"返回如下:
      """
      = [1,2]
      """

    @pvd-lower
    @clean-lower-route
    @pvd-ui
    @clean-allCreate-route
    场景:第一步可选步骤
      假如新建Route"route":
        | 步骤 | 腔室 | 槽位 | 配方 |
      那么第"0"行的"步骤"返回如下:
      """
      = [1]
      """