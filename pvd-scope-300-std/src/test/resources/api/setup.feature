# language: zh-CN
@pvd-lower
功能: setup
  Rule: loadFromSetup

    场景: 加载正确的文件名和参数2
      假如设置配置参数如下时:
        | name         | index | paramName | value |
        | AlignerSetup | 1     | AngleLA   | 15    |
      当调用"setup"的"loadFromSetup"接口时:
        | name         | index |
        | AlignerSetup | 1     |
      那么"/SETUP/Control/ATR/Aligner/AngleLA"的值为"15"

    场景: 加载不存在的文件名的参数
      当调用"setup"的"loadFromSetup"接口时:
        | name      | index |
        | not_exist | 1     |
      那么调用失败

    场景: 加载错误索引的参数
      假如设置配置参数如下时:
        | name         | index | paramName | value |
        | AlignerSetup | 1     | AngleLA   | 12    |
      当调用"setup"的"loadFromSetup"接口时:
        | name         | index  |
        | AlignerSetup | 100000 |
      那么"/SETUP/Control/ATR/Aligner/AngleLA"的值为"12"


  Rule: saveToSetup

    场景: 保存正确的setup值并验证
      假如设置参数如下时:
        | name                               | value |
        | /SETUP/Control/ATR/Aligner/AngleLA | 11    |
        | /SETUP/Control/ATR/Aligner/AngleLB | 78    |
      当调用"setup"的"saveToSetup"接口时:
        | name         | index |
        | AlignerSetup | 1     |
      那么"AlignerSetup"索引"1"的参数为:
      """
      : [ '11' '78' ... ]
      """

    场景: 保存不存在的配置选项值
      当调用"setup"的"saveToSetup"接口时:
        | name      | index |
        | not_exist | 1     |
      那么调用失败

    场景: 保存存在的配置选项值的错误索引
      假如设置参数如下时:
        | name                               | value |
        | /SETUP/Control/ATR/Aligner/AngleLA | 13    |
      当调用"setup"的"saveToSetup"接口时:
        | name         | index |
        | AlignerSetup | -1    |
      那么"AlignerSetup"索引"1"的参数为:
      """
      : [ '13' ... ]
      """

  Rule: saveSetupToXML

    场景: 保存正确的配置选项
      假如设置配置参数如下时:
        | name         | index | paramName | value |
        | AlignerSetup | 1     | AngleLA   | 10    |
      当调用"setup"的"saveSetupToXML"接口时:
        | name         |
        | AlignerSetup |
      那么调用成功
      并且下位机文件应为:
      """
      config.Setup['AlignerSetup.xml'].lines: [
        ...
        /.*<Value paramName="AngleLA">10.*/
        ...
      ]
      """

    场景: 保存错误的配置选项
      当调用"setup"的"saveSetupToXML"接口时:
        | name      |
        | not_exist |
      那么调用失败

  Rule: getSetupOptionNum

    场景: 获取存在的配置选项的选项个数
      当调用"setup"的"getSetupOptionNum"接口时:
        | name         |
        | AlignerSetup |
      那么调用成功
      并且返回如下:
      """
      = 1
      """

    场景: 获取不存在的配置选项的选项个数
      当调用"setup"的"getSetupOptionNum"接口时:
        | name      |
        | not_exist |
      那么调用成功
      并且返回如下:
      """
      = -1
      """

  Rule: getSetupAllParams

    场景: 获取存在的配置选项的所有参数
      当调用"setup"的"getSetupAllParams"接口时:
        | name         |
        | AlignerSetup |
      那么调用成功
      并且返回如下:
      """
      :[
        {
          "typeInfo":{
            "min": 0,
            "max": 360000,
            "unit": '',
            "descriptors": []
          },
          "name": "AngleLA",
          "dataObj": "/SETUP/Control/ATR/Aligner/AngleLA",
          "defaultValue": "0",
          "type": "INTDATA"
        },{
          "typeInfo":{
            "min": 0,
            "max": 360000,
            "unit": '',
            "descriptors": []
          },
          "name": "AngleLB",
          "dataObj": "/SETUP/Control/ATR/Aligner/AngleLB",
          "defaultValue": "0",
          "type": "INTDATA"
        },{
          "typeInfo":{
            "min": 0,
            "max": 360000,
            "unit": '',
            "descriptors": []
          },
          "name": "AngleX",
          "dataObj": "/SETUP/Control/ATR/Aligner/AngleX",
          "defaultValue": "0",
          type: "INTDATA"
        },{
          "typeInfo":{
            "min": 0,
            "max": 1,
            "unit": '',
            "descriptors": [{
                    "name": "No",
                    "value": 0
                },{
                    "name": "Yes",
                    "value": 1
                }]
          },
          "name": "NotchSupport",
          "dataObj": "/SETUP/Control/ATR/Aligner/NotchSupport",
          "defaultValue": "No",
          type: "INTDATA"
        },{
        "typeInfo":{
            "min": 0,
            "max": 1,
            "unit": '',
            "descriptors": [{
                    "name": "No",
                    "value": 0
                },{
                    "name": "Yes",
                    "value": 1
                }]
            },
            "name": "Bypass",
            "dataObj": "/SETUP/Control/ATR/Aligner/Bypass",
            "defaultValue": "No",
            "type": "INTDATA"
        }
      ]
      """

    场景: 获取不存在的配置选项的参数
      当调用"setup"的"getSetupAllParams"接口时:
        | name      |
        | not_exist |
      那么调用成功
      并且返回如下:
      """
      = []
      """

  Rule: getSetupOptionValues

    场景: 获取存在的配置选项的指定的配置值
      假如设置配置参数如下时:
        | name         | index | paramName    | value |
        | AlignerSetup | 1     | AngleLA      | 12    |
        | AlignerSetup | 1     | AngleLB      | 77    |
        | AlignerSetup | 1     | AngleX       | 65000 |
        | AlignerSetup | 1     | NotchSupport | No    |
        | AlignerSetup | 1     | Bypass       | Yes   |
      当调用"setup"的"getSetupOptionValues"接口时:
        | name         | index |
        | AlignerSetup | 1     |
      那么调用成功
      并且返回如下:
      """
      =['12','77','65000','No','Yes']
      """

    场景: 获取不存在存在的配置选项的所有配置值
      当调用"setup"的"getSetupOptionValues"接口时:
        | name      | index |
        | not_exist | 1     |
      那么调用成功
      并且返回如下:
      """
      =[]
      """

    场景: 获取存在的配置选项中不存在的索引的配置值
      当调用"setup"的"getSetupOptionValues"接口时:
        | name         | index |
        | AlignerSetup | -1    |
      那么调用成功
      并且返回如下:
      """
      =[]
      """

  Rule: setSetupValue
    #TODO:lly?
    场景: 修改正确的setup值并验证
      假如设置配置参数如下时:
        | name         | index | paramName    | value |
        | AlignerSetup | 1     | AngleLA      | 12    |
        | AlignerSetup | 1     | AngleLB      | 77    |
        | AlignerSetup | 1     | AngleX       | 65000 |
        | AlignerSetup | 1     | NotchSupport | No    |
        | AlignerSetup | 1     | Bypass       | Yes   |
      当调用"setup"的"setSetupValue"接口时:
        | name         | index | paramName | value |
        | AlignerSetup | 1     | AngleLA   | 66    |
      那么"AlignerSetup"索引"1"的参数为:
      """
      =['66','77','65000','No','Yes']
      """

    场景: 修改不存在的配置选项的值
      当调用"setup"的"setSetupValue"接口时:
        | name      | index | paramName | value |
        | not_exist | 1     | AngleLA   | 66    |
      那么调用失败

    场景: 修改存在的配置选项的不存在的索引的值
      当调用"setup"的"setSetupValue"接口时:
        | name         | index | paramName | value |
        | AlignerSetup | -1    | AngleLA   | 66    |
      那么调用失败

    场景: 修改存在的配置选项中不存在的参数值
      当调用"setup"的"setSetupValue"接口时:
        | name         | index | paramName | value |
        | AlignerSetup | -1    | not_exist | 66    |
      那么调用失败

    场景: 修改存在的配置选项中存在的参数值为不合法的值
      当调用"setup"的"setSetupValue"接口时:
        | name         | index | paramName | value |
        | AlignerSetup | -1    | AngleLA   | -1    |
      那么调用失败