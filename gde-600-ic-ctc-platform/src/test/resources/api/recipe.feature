# language: zh-CN
@ETCH-PM2-lower
@clean-lower-recipe
#@skip
功能: Recipe

  Rule: getAllRecipe

    场景: 获取所有Recipe
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"getAllRecipe"接口时
      那么返回如下:
      """
      = [ '/Process/test0;1' ]
      """

  Rule: getRecipeInfo

    场景: 获取存在的Recipe的信息
      假如存在"Recipe":
        | name  | version | rcpClass | editedBy | comments | approvalLvl |
        | test0 | 1       | /Process | pe       | comments | 0           |
      当调用"recipe"的"getRecipeInfo"接口时:
        | recipe           |
        | /Process/test0;1 |
      那么调用成功
      并且返回如下:
      """
      :{
        "name": "test0",
        "rcpClass": "/Process",
        "editedBy": "pe",
        "comments": "comments",
        "approvalLvl": 0,
        "verified":true,
        "linked":false,
        body.steps: [],
        "attrChgTime" is AlmostNow,
        "editTime" is AlmostNow,
      }
      """

    场景大纲: 获取不存在的Recipe的信息  <title>
      当调用"recipe"的"getRecipeInfo"接口时:
        | recipe   |
        | <recipe> |
      那么调用失败, 错误为:
      """
      message= null
      """
      例子:
        | title           | recipe               |
        | name is empty   | /Process/;1          |
        | class not exist | /Not-exist/test0;1   |
        | name  not exist | /Process/not-exist;1 |

  Rule: registerRecipe

    场景: 注册Recipe
      当调用"recipe"的"registerRecipe"接口时:
        | name  | rcpClass | editedBy | comments | approvalLvl |
        | test0 | /Process | sa       | foo      | 1           |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
      """
      : {
        name= 'test0'
        rcpClass= '/Process'
        editedBy= 'sa'
        comments= 'foo'
        approvalLvl= 1
        attrChgTime is AlmostNow
        editTime is AlmostNow
      }
      """

    场景大纲: 注册Recipe - 错误处理: <title>
      当调用"recipe"的"registerRecipe"接口时:
        | name   | rcpClass |
        | <name> | <class>  |
      那么调用失败, 错误为:
      """
      message= "<message>"
      """
      例子:
        | title           | name | class     | message                                                                                                                                                                                                                           |
        | name is empty   |      | /Process  | RemoteRecipeUserImpl[NID<PVD>::PVDEMC_SCOPE_Recipe]::registerNewRecipe(/Process/): RecipeMgmtSession[NID<PVD>::PVDEMC_SCOPE_Recipe]::createRecipe(/Process/): Failed! Construct ExecutionRecipe[] failed! Illegal recipe name ''. |
        | class not exist | any  | not-exist | RemoteRecipeUserImpl[NID<PVD>::PVDEMC_SCOPE_Recipe]::registerNewRecipe(not-exist/any): RecipeMgmtSession[NID<PVD>::PVDEMC_SCOPE_Recipe]::createRecipe(not-exist/any): Failed! RecipeClass does NOT exist.                         |

    场景大纲: 注册Recipe - 错误处理-正则表达式: <title>
      当调用"recipe"的"registerRecipe"接口时:
        | name   | rcpClass |
        | <name> | <class>  |
      那么调用失败, 错误为:
      """
      message= /.*<message>.*/
      """
      例子:
        | title           | name | class     | message                            |
        | name is empty   |      | /Process  | failed! Illegal recipe name ''     |
        | class not exist | any  | not-exist | Failed! RecipeClass does NOT exist |

  Rule: storeRcpBody

    场景:存储Rcpbody(覆盖旧版本)
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      那么调用成功
      并且Recipe"/Process/sub1/rcp1;1"的Info为:
      """
      body.steps: | name     | values          |
                  | stepName | [ chuck       ] |
                  | stepName | [ chuck-again ] |
      """

    场景:存储Rcpbody(生成新版本)
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": false
      }
      """
      那么调用成功
      并且Recipe"/Process/sub1/rcp1;2"的Info为:
      """
      body.steps: | name     | values          |
                  | stepName | [ chuck       ] |
                  | stepName | [ chuck-again ] |
      """

    场景:存储Rcpbody(RcpBody为空)
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [],
        "override": true
      }
      """
      那么调用成功
      并且Recipe"/Process/sub1/rcp1;1"的Info为:
      """
      body.steps: []
      """

    场景:存储Rcpbody(Rcp不存在)
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp2;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      那么调用失败, 错误为:
      """
      message= /.*Failed! Recipe dose NOT exist.*/
      """

    场景:存储Rcpbody(RcpClass不存在)
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/aaa1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      那么调用失败, 错误为:
      """
      message= /.*Failed! RecipeClass does NOT exist.*/
      """

  Rule: removeRecipe

    场景: 删除一个已经存在的Reicpe
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"removeRecipe"接口时:
        | recipe           |
        | /Process/test0;1 |
      那么调用成功
      并且调用"recipe"的"getAllRecipe"接口时
      那么返回如下:
      """
      =[]
      """

    场景: 删除一个不存在的RecipeClass中的Recipe
      当调用"recipe"的"removeRecipe"接口时:
        | recipe              |
        | /not-exist/Recipe;1 |
      那么调用失败, 错误为:
      """
      message =/.*Failed! RecipeClass does NOT exist.*/
      """

    场景: 删除一个存在的RecipeClass中的不存在的Recipe
      当调用"recipe"的"removeRecipe"接口时:
        | recipe               |
        | /Process/not_exist;1 |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Recipe does NOT exist.*/
      """

  Rule: setRcpComments

    场景: 修改存在的Recipe的comment
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"setRcpComments"接口时:
        | recipe           | comments      |
        | /Process/test0;1 | changeComment |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
      """
      : {
        comments= 'changeComment'
      }
      """

    场景: 修改不存在的RecipeClass中的Recipe的comment
      当调用"recipe"的"setRcpComments"接口时:
        | recipe              | comments           |
        | /not-exist/Recipe;1 | not_exist_rcpclass |
      那么调用失败, 错误为:
      """
      message =/.*Failed! RecipeClass does NOT exist.*/
      """

#TODO:执行失败:拼写错误 does->dose
    场景: 修改存在的RecipeClass中的不存在的Recipe的comment
      当调用"recipe"的"setRcpComments"接口时:
        | recipe               | comments      |
        | /Process/not_exist;1 | not_exist_rcp |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Recipe dose NOT exist.*/
      """

  Rule: setRcpEditor

    场景:修改存在Recipe的作者
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"setRcpEditor"接口时:
        | recipe           | edit       |
        | /Process/test0;1 | shaoyixuan |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
        """
        :{
          editedBy= 'shaoyixuan'
        }
        """

    场景: 修改不存在的RecipeClass中的Recipe的作者
      当调用"recipe"的"setRcpEditor"接口时:
        | recipe              | edit               |
        | /not-exist/Recipe;1 | not_exist_rcpclass |
      那么调用失败, 错误为:
      """
      message =/.*Failed! RecipeClass does NOT exist.*/
      """
#TODO:执行失败:拼写错误 does->dose
    场景: 修改存在的RecipeClass中不存在的Recipe的作者
      当调用"recipe"的"setRcpEditor"接口时:
        | recipe               | edit          |
        | /Process/not_exist;1 | not_exist_rcp |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Recipe dose NOT exist.*/
      """

  Rule: registerRcpClass

    场景: 注册一个新的子Class
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "/Process/newSubClass",
        "params": [{
          "name": "StringStep",
          "type": "S",
          "defaultValue": "a-default",
          "dataObj": "a-dataObj",
          "maxLength": 128
        }, {
          "name": "IntStep",
          "type": "I",
          "defaultValue": "10",
          "dataObj": "int-obj",
          "min": -1,
          "max": 100,
          "unit": "TB",
          "descriptors": {
            "key1": 30,
            "key2": 50
          }
        }, {
          "name": "DoubleStep",
          "type": "D",
          "defaultValue": "0.1",
          "dataObj": "double-obj",
          "min": -1.0,
          "max": 128.0,
          "unit": "sccm",
          "accuracy": 0.1
        }]
      }
      """
      那么调用成功
      并且RecipeClass"/Process/newSubClass"为:
      """
      : {
        params: | name       | type       | defaultValue | dataObj   | typeInfo.maxLength | typeInfo.min | typeInfo.max  | typeInfo.unit |typeInfo.accuracy |
                | StringStep | STRINGDATA | a-default    | a-dataObj | 128                | *            | *             | *             |   *              |
                | IntStep    | INTDATA    | '10'         | int-obj   | *                  | -1           | 100           | TB            |   *              |
                | DoubleStep | DOUBLEDATA | '0.1'        |double-obj | *                  | -1           | 128           | sccm          |  0.1             |

        params[1].typeInfo.descriptors: | name | value |
                                        | key1 | 30    |
                                        | key2 | 50    |
      }
      """

    场景: 注册一个重名的子Class
      假如存在"RecipeClass":
        | name           |
        | /Process/exist |
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "/Process/exist",
        "params": [{
          "name": "any",
          "type": "S",
          "defaultValue": "any",
          "dataObj": "any",
          "maxLength": 128
        }]
      }
      """
      那么调用失败, 错误为:
      """
      message= /.*Failed! RecipeClass already exists.*/
      """

    场景: 注册子Class时父节点不存在
#      假如不存在"RecipeClass":
#        |      name       |
#        |/Process/nonexist|
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "any",
        "params": [{
          "name": "any",
          "type": "S",
          "defaultValue": "any",
          "dataObj": "any",
          "maxLength": 128
        }]
      }
      """
      那么调用失败, 错误为:
      """
      message= /.*Failed! Parent class.*/
      """

    场景: 注册一个的子Class,只有大小写差异
      假如存在"RecipeClass":
        | name           |
        | /Process/exist |
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "/Process/EXIST",
        "params": [{
          "name": "any",
          "type": "S",
          "defaultValue": "any",
          "dataObj": "any",
          "maxLength": 128
        }]
      }
      """
      那么调用成功
      并且RecipeClass"/Process/EXIST"为:
      """
      :{
        params:| name   | type     |defaultValue | dataObj   | typeInfo.maxLength |
               |any     |STRINGDATA|  any        |   any     |   128              |
      }
      """

    场景: 注册RcpClass,param里有同名行
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "/Process/sameParam",
        "params": [{
          "name": "sameStep",
          "type": "S",
          "defaultValue": "a-default",
          "dataObj": "a-dataObj",
          "maxLength": 128
        }, {
          "name": "sameStep",
          "type": "I",
          "defaultValue": "10",
          "dataObj": "int-obj",
          "min": -1,
          "max": 100,
          "unit": "TB",
          "descriptors": {
            "key1": 30,
            "key2": 50
          }
        }]
      }
      """
      那么调用失败, 错误为:
      """
      message=/.*Failed! Input Template at lease has two Parameters with the same name.*/
      """

    场景: 注册RcpClass,Param里存在冲突数据
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "/Process/sameParam",
        "params": [{
          "name": "sameStep",
          "type": "I",
          "defaultValue": "ioo",
          "dataObj": "int-obj",
          "min": -1,
          "max": 100,
          "unit": "TB",
          "descriptors": {
            "key1": 30,
            "key2": 50
          }
        }]
      }
      """
      那么调用失败, 错误为:
      """
      message=/.*failed! Reason: Invalid 'default' setting.*/
      """

    场景: 注册RcpClass,注册类名无效
      当调用"recipe"的"registerRcpClass"接口时:
      """
      {
        "name": "/Process/",
        "params": [{
          "name": "sameStep",
          "type": "I",
          "defaultValue": "10",
          "dataObj": "int-obj",
          "min": -1,
          "max": 100,
          "unit": "TB",
          "descriptors": {
            "key1": 30,
            "key2": 50
          }
        }]
      }
      """
      那么调用失败, 错误为:
      """
      message=/.*Illegal child name.*/
      """

  Rule: getAllRcpClass

    场景: 获得所有RecipeClass的信息
      假如存在"RecipeClass":
        | name              |
        | /Process/OneOfAll |
        | /Process/TwoOfAll |
      当调用"recipe"的"getAllRcpClass"接口时
      那么返回如下:
        """
        : +[
        ...
        '/Process/OneOfAll',
        '/Process/TwoOfAll'
        ...
        ]
        """

  Rule: getRcpClassInfo

    场景:查询Recipe class
#      假如存在"RecipeClass":
#        | name      | params[0](IntParam)! |
#        | /Process/sub1 |                      |
      假如存在"RecipeClass":
      """
      {
        "name": "/Process/sub1",
        "params": [{
          "_": "(IntParam)!",
          "name": "Source DC Ramp",
          "dataObj": "",
          "defaultValue": 0,
          "typeInfo": {
            "min": 0,
            "max": 40000,
            "unit": "W/s",
            "descriptors": []
          }
        }, {
          "_": "(IntParam)!",
          "name": "SpaceCompensation",
          "dataObj": "",
          "defaultValue": "Disable",
          "typeInfo": {
            "min": 0,
            "max": 1,
            "unit": "",
            "descriptors": [{
              "name": "Disable",
              "value": 0
            }, {
              "name": "Enable",
              "value": 1
            }]
          }
        }]
      }
      """
      当调用"recipe"的"getRcpClassInfo"接口时:
        | recipeClass   |
        | /Process/sub1 |
      那么返回如下:
      """
#    <Param name="Source DC Ramp" dataObject="" type="I" min="0" max="40000" descriptorList="" units="W/s" default="0" />
#    <Param name="SpaceCompensation" dataObject="" type="I" min="0" max="1" descriptorList="Disable:0,Enable:1" units="" default="Disable" />
      params:
        | name              | type    | defaultValue | dataObj | typeInfo.maxLength | typeInfo.min | typeInfo.max | typeInfo.unit | typeInfo.descriptors                                 |
        | Source DC Ramp    | INTDATA | '0'          |         | *                  | 0            | 40000        | W/s           | []                                                   |
        | SpaceCompensation | INTDATA | Disable      |         | *                  | 0            | 1            |               | [{name: Disable, value: 0} {name: Enable, value: 1}] |
      """

      #TODO:没有验证,返回为空
    场景: 获取不存在的Class的信息
      当调用"recipe"的"getRcpClassInfo"接口时:
        | recipeClass       |
        | /Process/nonexist |
      那么调用失败, 错误为:
        """
        """

  Rule: removeRcpClass

    场景: 移除一个空子Class
      假如存在"RecipeClass":
        | name              |
        | /Process/toRemove |
      当调用"recipe"的"removeRcpClass"接口时:
        """
        {
        "name": "/Process/toRemove"
        }
        """
      那么调用成功

    场景: 移除一个有子Class的Class
      假如存在"RecipeClass":
        | name               |
        | /Process/ClsIncCls |
      并且存在"RecipeClass":
        | name                         |
        | /Process/ClsIncCls/ClsBelCls |
      当调用"recipe"的"removeRcpClass"接口时:
        """
        {
        "name": "/Process/ClsIncCls"
        }
        """
      那么调用失败, 错误为:
        """
        message=/.*Failed! RecipeClass is NOT empty.*/
        """

    场景: 移除一个有Recipe的Class
      假如存在"RecipeClass":
        | name               |
        | /Process/ClsIncRcp |
      并且存在"Recipe":
        | name      | rcpClass           |
        | RcpBelCls | /Process/ClsIncRcp |
      当调用"recipe"的"removeRcpClass"接口时:
        """
        {
        "name": "/Process/ClsIncRcp"
        }
        """
      那么调用失败, 错误为:
        """
        message=/.*Failed! RecipeClass is NOT empty.*/
        """

    场景: 移除不存在的Class
      当调用"recipe"的"removeRcpClass"接口时:
        """
        {
          "name": "/Process/nonexist",
        }
        """
      那么调用成功

  Rule: selectRecipe

    场景: 选中Recipe后删除
      假如存在"Recipe":
        | name     | rcpClass |
        | Beselect | /Process |
      并且调用"recipe"的"selectRecipe"接口时:
        """
          {
            "name": "/Process/Beselect;1"
          }
        """
      当调用"recipe"的"deleteRecipe"接口时:
        """
          {
            "name": "/Process/Beselect;1"
          }
        """
      那么调用失败, 错误为:
        """
        message=/.*Failed! Recipe is in use.*/
        """

    场景: 选中不存在的Recipe
#       假如不存在"Recipe":
#        |      name        |
#        |/Process/unexist;1|
      当调用"recipe"的"selectRecipe"接口时:
        """
        {
          "name": "/Process/unexist;1"
        }
        """
      那么调用失败, 错误为:
        """
        message=/.*Failed! Recipe dose NOT exist.*/
        """

    场景: 选中Recipe后修改属性
      假如存在"Recipe":
        | name     | rcpClass |
        | Beselect | /Process |
      并且调用"recipe"的"selectRecipe"接口时:
        """
          {
            "name": "/Process/Beselect;1"
          }
        """
      当调用"recipe"的"setRcpEditor"接口时:
        """
          {
            "recipe": "/Process/Beselect;1",
            "edit": "NotDefault"
          }
        """
      那么调用失败, 错误为:
        """
        message=/.*The recipe was selected.*/
        """

  Rule: deselect

    场景: 取消选中Recipe后成功删除
      假如存在"Recipe":
        | name       | rcpClass |
        | Bedeselect | /Process |
      并且调用"recipe"的"selectRecipe"接口时:
        """
          {
            "name": "/Process/Bedeselect;1"
          }
        """
      当调用"recipe"的"deselectRecipe"接口时:
        """
          {
            "name": "/Process/Bedeselect;1"
          }
        """
      并且调用"recipe"的"deleteRecipe"接口时:
        """
          {
            "name": "/Process/Bedeselect;1"
          }
        """
      那么调用成功
      并且recipe"/Process/Bedeselect;1"已被删除

  Rule: retrieveExclRcp

    场景: 独占模式取出
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe           |
        | /Process/test0;1 |
      那么调用成功
      并且无法再独占取出Recipe"/Process/test0;1"

    场景: 独占模式取出不存在的RcpClass的Recipe
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe             |
        | /not-exist/test0;1 |
      那么调用失败, 错误为:
      """
      message =/.*Failed! RecipeClass does NOT exist.*/
      """

    场景: 独占模式取出不存在的Recipe
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe               |
        | /Process/not-exist;1 |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Recipe dose NOT exist.*/
      """

    #TODO:多用户场景

  Rule: releaseExclRcp

    场景: 释放Recipe
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"releaseExclRcp"接口时:
        | recipe           |
        | /Process/test0;1 |
      那么调用失败, 错误为:
      """
      message =/.*The recipe was NOT retrieved with exclusive mode.*/
      """

    场景: 释放独占取出的Recipe
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe           |
        | /Process/test0;1 |
      并且调用"recipe"的"releaseExclRcp"接口时:
        | recipe           |
        | /Process/test0;1 |
      那么调用成功

  Rule: setExclRcpStepValue

    场景: 修改未取出的Recipe参数
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/test0;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      并且调用"recipe"的"setExclRcpStepValue"接口时:
        | recipe           | index | paramName | value  |
        | /Process/test0;1 | 1     | stepName  | change |
      那么调用失败, 错误为:
      """
      message =/.*The recipe was NOT retrieved with exclusive mode.*/
      """

    场景: 修改已取出的Recipe参数
      假如存在"RecipeClass":
        | name          | params[0](StringParam).name |
        | /Process/sub1 | name                        |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe               |
        | /Process/sub1/rcp1;1 |
      并且调用"recipe"的"setExclRcpStepValue"接口时:
        | recipe               | index | paramName | value  |
        | /Process/sub1/rcp1;1 | 1     | name      | change |
      那么调用成功

    场景: 修改已取出的Recipe的错误name的参数
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe               |
        | /Process/sub1/rcp1;1 |
      并且调用"recipe"的"setExclRcpStepValue"接口时:
        | recipe               | index | paramName | value  |
        | /Process/sub1/rcp1;1 | 1     | not_exist | change |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Input Parameter index is out of range.*/
      """

    场景: 修改已取出的Recipe的错误步骤的参数
      假如存在"RecipeClass":
        | name          | params[0](StringParam)! |
        | /Process/sub1 |                         |
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ["chuck"]
        },{
          "name": "stepName",
          "value": ["chuck-again"]
        }],
        "override": true
      }
      """
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe               |
        | /Process/sub1/rcp1;1 |
      并且调用"recipe"的"setExclRcpStepValue"接口时:
        | recipe               | index | paramName | value  |
        | /Process/sub1/rcp1;1 | 3     | not_exist | change |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Input step index is out of range.*/
      """

    场景:修改已取出的Recipe的参数变为不合法类型的值
      假如存在"RecipeClass":
      """
      {
        "name": "/Process/sub1",
        "params": [{
          "_": "(IntParam)!",
          "name": "Source DC Ramp",
          "dataObj": "",
          "defaultValue": 0,
          "typeInfo": {
            "min": 0,
            "max": 40000,
            "unit": "W/s",
            "descriptors": []
          }
        }]
      }
      """
      假如存在"Recipe":
        | name | rcpClass      |
        | rcp1 | /Process/sub1 |
      当调用"recipe"的"storeRcpBody"接口时:
      """
      {
        "recipe": "/Process/sub1/rcp1;1",
        "body": [{
          "name": "stepName",
          "value": ['5']
        }],
        "override": true
      }
      """
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe               |
        | /Process/sub1/rcp1;1 |
      并且调用"recipe"的"setExclRcpStepValue"接口时:
        | recipe               | index | paramName      | value   |
        | /Process/sub1/rcp1;1 | 1     | Source DC Ramp | not_int |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Invalid step-value.*/
      """


  Rule: setExclRcpEditor

    场景: 修改已独占取出的执行态Recipe的编辑者
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe           |
        | /Process/test0;1 |
      当调用"recipe"的"setExclRcpEditor"接口时:
        | recipe           | editor       |
        | /Process/test0;1 | changeEditor |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
      """
      editedBy: "changeEditor"
      """

    场景: 修改未独占取出的执行态Recipe的编辑者
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"setExclRcpEditor"接口时:
        | recipe           | editor       |
        | /Process/test0;1 | changeEditor |
      那么调用失败, 错误为:
      """
      message =/.*The recipe was NOT retrieved with exclusive mode.*/
      """


  Rule: setExclRcpComments

    场景: 修改已独占取出的执行态Recipe的注释
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"retrieveExclRcp"接口时:
        | recipe           |
        | /Process/test0;1 |
      当调用"recipe"的"setExclRcpComments"接口时:
        | recipe           | comments       |
        | /Process/test0;1 | changeComments |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
      """
      comments: "changeComments"
      """

    场景: 修改未独占取出的执行态Recipe的注释
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"setExclRcpComments"接口时:
        | recipe           | comments     |
        | /Process/test0;1 | changeEditor |
      那么调用失败, 错误为:
      """
      message =/.*The recipe was NOT retrieved with exclusive mode.*/
      """

  Rule: getNamespaceROLvl

    场景: 获取Recipe命名空间的只读级别
      当调用"recipe"的"getNamespaceROLvl"接口时
      那么返回如下:
      """
      = 2
      """

  Rule: setRcpApprovalLvl

    场景: 设置指定Recipe的授权级别为合法值
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"setRcpApprovalLvl"接口时:
        | recipe           | level |
        | /Process/test0;1 | 1     |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
      """
      approvalLvl: 1
      """

    场景: 设置不存在的RecipeClass中的Recipe的授权级别为合法值
      当调用"recipe"的"setRcpApprovalLvl"接口时:
        | recipe              | level |
        | /not_exist/recipe;1 | 1     |
      那么调用失败, 错误为:
      """
      message =/.*Failed! RecipeClass does NOT exist.*/
      """
#TODO:执行失败:拼写错误 does->dose
    场景: 设置不存在的Recipe的授权级别为合法值
      当调用"recipe"的"setRcpApprovalLvl"接口时:
        | recipe               | level |
        | /Process/not_exist;1 | 1     |
      那么调用失败, 错误为:
      """
      message =/.*Failed! Recipe dose NOT exist.*/
      """

    场景大纲: 设置Recipe的授权级别为非法值
      假如存在"Recipe":
        | name  | version | rcpClass |
        | test0 | 1       | /Process |
      当调用"recipe"的"setRcpApprovalLvl"接口时:
        | recipe           | level   |
        | /Process/test0;1 | <Value> |
      那么调用成功
      并且Recipe"/Process/test0;1"的Info为:
      """
      approvalLvl: 4
      """
      例子:
        | Value |
        | 5     |
        | -1    |
