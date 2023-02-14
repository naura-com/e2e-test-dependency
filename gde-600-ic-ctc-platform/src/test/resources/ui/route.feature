# language: zh-CN
@ETCH-PM2-lower
@clean-lower-recipe
@etch1-ui
@etch1-clean-lower-route
@reset-feature-ui
#@skip
功能: 路径

  背景:
    假如存在"Recipe":
      | name | rcpClass |
      | test | /Process |
    当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/test;1",
        "body": [{
          "name": "stepName",
          "value": ["dechuck"]
        },{
          "name": "stepName",
          "value": ["dechuck-again"]
        }],
        "override": true
      }
      """

  Rule: 保存Route

    @etch1-clean-all-route
    场景: 保存Route提示信息验证
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行保存"PM2Process"操作时
      那么操作成功,提示信息:
      """
      ="Save route recipe PM2Process successfully!"
      """

    场景: 带有Center模块的save
      假如存在新建带有"Center"模块路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行保存"PM2Process-Center"操作并二次确认时
      那么"PM2Process-Center"保存成功
      并且配置文件中可查询到"PM2Process-Center"文件:
      """
      : [
        ...
        'PM2Process-Center',
        'sa',
        'Centering,',
        'PM2,,/Process/test;1,,,'
        ...
      ]
      """

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 带有Align模块的save
      假如存在新建带有"Align"模块路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行保存"PM2Process"操作并二次确认时
      那么"PM2Process"保存成功
      并且配置文件中可查询到"PM2Process"文件:
      """
      : [
        ...
        'PM2Process',
        'sa',
        'PM2,,/Process/test;1,,,',
        '[UseAlign] =True'
        ...
      ]
      """

    场景: 新建waferflow未选recipe后执行save
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室      | 配方 |
        | 1  | PM2 GDE |    |
      当执行保存"PM2Process"操作时
      那么操作失败,提示信息:
      """
      ="PM's recipe name can not be empty, please edit again!"
      """

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 新建waferflow未选腔室后执行save
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室 | 配方 |
        | 1  |    |    |
      当执行保存"PM2Process"操作
      那么操作失败,提示信息:
      """
      ="It is an invalid waferflow!"
      """

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 带有Clean Recipe的save
      假如在"PM2 GDE"的"DryClean"存在配方"clean-rcp":
        | Parameter | 1     | 2     | 3     |
        | Step Name | step1 | step2 | step3 |
      假如存在新建带有清洁配方路径"PM2Process":
        | 步骤 | 腔室      | 配方   | Clean Recipe |
        | 1  | PM2 GDE | test | clean-rcp    |
      当执行保存"PM2Process"操作并二次确认时
      那么"PM2Process"保存成功
      并且配置文件中可查询到"PM2Process"文件:
      """
      : [
        ...
        'PM2Process',
        'sa',
        'PM2,,/Process/test;1,/DryClean/test;1,,'
        ...
      ]
      """

      #TODO:报错
    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: Aligner和centering共选状态
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当勾选"Align"
      那么"Align"处于勾选状态,"Center"处于非勾选状态
      当勾选"Center"
      那么"Center"处于勾选状态,"Align"处于非勾选状态
  Rule: 查询Route

    @etch-reset
    场景: 查询已保存Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当查询"PM2Process"时
      那么"PM2Process"查询成功:
      """
      =["PM2"]
      """
      并且当前界面存在2个结点

    @etch-reset
    场景: 查询删除结点后的Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行删除当前结点操作时
      那么当前界面存在0个结点

    @etch-reset
    场景: 查询删除腔室后的Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行删除当前腔室操作时
      那么当前界面存在1个结点

  Rule: 新建Route

    @etch-reset
    场景: 新建重名Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当新建模块路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行保存"PM2Process"操作时
      那么操作失败,提示信息:
        """
        ="The recipe has been existed, please input again!"
        """

  Rule: 删除Route

    @etch-reset
    场景: 删除Route提示信息验证
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行"Delete""PM2Process"操作时
      那么操作成功,提示信息
      """
      ="Are you sure to delete the routerecipe 'PM2Process'? "
      """

    @etch-reset
    场景: 删除已保存Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行"Delete""PM2Process"操作并二次确认时
      那么"PM2Process"删除成功
      并且配置文件中无法查询到"PM2Process"文件

    场景: 存在未保存Route删除Route提示信息验证
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行删除操作时
      那么操作失败,提示信息:
      """
      ="Please select a waferflow to delete!"
      """

    @etch-reset
    场景: 新建waferflow未选recipe后执行删除
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室      | 配方 |
        | 1  | PM2 GDE |    |
      当执行删除操作时
      那么操作失败,提示信息:
      """
      ="Please select a waferflow to delete!"
      """

    @etch-reset
    场景: 新建waferflow未选腔室后执行删除
      假如存在新建路径"PM2Process":
        | 步骤 | 腔室 | 配方 |
        | 1  |    |    |
      当执行删除操作时
      那么操作失败,提示信息:
      """
      ="Please select a waferflow to delete!"
      """

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 未选中Route执行删除操作
      当不选中Route执行"Delete"操作时
      那么操作失败,提示信息:
      """
      ="Please select a waferflow to delete!"
      """

  Rule: GUOXIANG
    @clean-lower-recipe
    @etch-reset
    场景: 编辑未保存切换WaferFlow
      假如存在已保存路径"test1":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      并且存在已保存路径"test2":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当修改路径"test1"在腔室"PM2"的执行时间为"10"
      并且选择路径"test2"
      那么执行失败,异常信息为
      """
      = "test1 is not saved.Do you want to save first?"
      """

    @etch-reset
    @etch1-clean-all-route
    场景: 正常FlowName的save
      假如存在新建路径"LegalName":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行保存"test_test-test."操作时
      那么操作成功,提示信息:
        """
        ="Save route recipe test_test-test. successfully!"
        """

    场景: 异常FlowName的save
      假如存在新建路径"IllegalName":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行保存"test@test"操作时
      那么操作成功,提示信息:
        """
        ="Save route recipe test successfully!"
        """

  Rule:Rename

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 正常Rename
      假如存在已保存路径"test":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当将路径"test"重命名为"test1"
      那么操作成功，路径列表中"test"变为"test1"

    场景: Rename重名
      假如存在已保存路径"test":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      并且存在已保存路径"test1":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当将路径"test"重命名为"test1"
      那么操作提示信息为:
      """
      = "The waferflow name is exist, Please rename it!"
      """

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 否认Rename操作
      假如存在已保存路径"test":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当否认想要对路径"test"进行重命名操作
      那么否认重命名成功，无异常发生

  Rule: Save As

    @clean-lower-recipe
    @etch-reset
    场景: 正常另存为
      假如存在已保存路径"test":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当将路径"test"另存为"test1"
      那么操作成功，路径列表中"test"另存为"test1"

  Rule: 重命名Route

    @clean-lower-recipe
    @etch-reset
    场景: 重命名已保存Route提示信息验证
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行重命名"PM2Process"操作时
      那么操作成功,提示信息
      """
      ="Are you sure to rename the wafer flow 'PM2Process'? "
      """

    @clean-lower-recipe
    @etch-reset
    @etch1-clean-all-route
    场景: 重命名已保存Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当重命名"PM2Process"为"renamePM2Process"并二次确认
      那么"renamePM2Process"保存成功
      并且配置文件中可查询到"renamePM2Process"文件:
      """
      : [
        ...
        'renamePM2Process',
        'sa'
        'PM2,,/Process/test;1,,,'
        ...
      ]
      """
      并且配置文件中无法查询到"PM2Process"文件

    场景: 未选中Route执行重命名操作
      当不选中Route执行"Rename"操作时
      那么操作失败,提示信息:
      """
      ="Please choose a waferflow!"
      """

  Rule: 另存为Route

    @clean-lower-recipe
    @etch-reset
    场景: 已保存Route另存为提示信息验证
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当"PM2Process"另存为"saveAsPM2Process"并二次确认
      那么操作成功,提示信息:
      """
      ="Save route recipe saveAsPM2Process successfully!"
      """

    @clean-lower-recipe
    @etch-reset
    场景: 已保存Route另存为
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当"PM2Process"另存为"saveAsPM2Process"并二次确认
      那么"saveAsPM2Process"保存成功
      并且配置文件中可查询到"saveAsPM2Process"文件:
      """
      : [
        ...
        'saveAsPM2Process',
        'sa'
        'PM2,,/Process/test;1,,,'
        ...
      ]
      """
      并且配置文件中可查询到"PM2Process"文件:
      """
      : [
        ...
        'PM2Process',
        'sa'
        'PM2,,/Process/test;1,,,'
        ...
      ]
      """

    @clean-lower-recipe
    @etch-reset
    场景: 未选中Route执行另存为操作
      当不选中Route执行"Save As"操作时
      那么操作失败,提示信息:
      """
      ="Please choose a waferflow!"
      """

  Rule: Add Node

    @clean-lower-recipe
    @etch-reset
    场景: 新添加单个空结点
      当新添加一个空结点时
      那么当前界面存在1个结点

    @clean-lower-recipe
    @etch-reset
    场景: 存在空结点时新添加结点
      假如当前存在一个空结点
      当新添加一个空结点时
      那么操作失败,提示信息:
      """
      ="There is a null node!"
      """
      并且当前界面存在1个结点

    @clean-lower-recipe
    @etch-reset
    场景: 已保存Route新建结点
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当新添加一个空结点时
      那么当前界面存在3个结点

  Rule: Clear All

    @clean-lower-recipe
    @etch-reset
    场景: Clear All提示信息验证
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行"Clear All""PM2Process"操作时
      那么操作成功,提示信息
      """
      ="Do you want to clear all items? Press Yes to clear all or Press No to cancel."
      """

    @clean-lower-recipe
    @etch-reset
    场景: Clear All已保存Route
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行"Clear All""PM2Process"操作并二次确认时
      那么当前界面存在0个结点

    @clean-lower-recipe
    @etch-reset
    场景: Clear All后保存Route验证
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当执行"Clear All""PM2Process"操作并二次确认时
      当执行"Save"操作时
      那么操作失败,提示信息:
      """
      ="It is an invalid waferflow!"
      """

    @clean-lower-recipe
    @etch-reset
    场景: Clear All后切换Route验证
      假如存在已保存路径"PM2Process":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      假如存在已保存路径"route-ClearAll"执行"Clear All"操作:
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当切换至"PM2Process"
      那么操作失败,提示信息
      """
      =" is not saved.Do you want to save first?"
      """

  Rule: Delete Item

    @clean-lower-recipe
    @etch-reset
    场景:  删除单个空节点
      假如当前存在一个空结点
      当选中唯一的空结点
      并且执行删除结点操作时
      那么当前界面存在0个结点

    @clean-lower-recipe
    @etch-reset
    场景: 删除结点内的腔室
      假如存在已保存路径"PM2Route":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当选中"PM2"的路径结点
      并且执行删除结点操作时
      那么当前界面存在1个结点

    @clean-lower-recipe
    @etch-reset
    场景: 删除有内容的结点
      假如存在已保存路径"PM2Route":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      当选中第1个结点时
      并且执行删除结点操作时
      那么当前界面存在0个结点

  Rule: Undo

    @clean-lower-recipe
    @etch-reset
    场景: 撤销新添加结点的操作
      假如存在已保存路径"PM2Route":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      并且新添加一个空结点时
      当执行撤销路径编辑操作
      那么当前界面存在2个结点

    @clean-lower-recipe
    @etch-reset
    场景: 撤销删除结点
      假如存在已保存路径"PM2Route":
        | 步骤 | 腔室      | 配方   |
        | 1  | PM2 GDE | test |
      并且选中"PM2"的路径结点
      并且执行删除结点操作时
      当执行撤销路径编辑操作
      那么当前界面存在2个结点
