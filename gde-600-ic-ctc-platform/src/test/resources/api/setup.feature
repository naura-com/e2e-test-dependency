# language: zh-CN
@ETCH-PM2-lower
#@skip
功能: setup
  Rule: loadFromSetup
    #TODO 合并，不要都是调用，将假如和验证改一下
    场景: 加载正确的文件名和参数
#      当调用"setup"的"setSetupValue"接口时:
#        | name      | index | paramName         | value |
#        | GasConfig | 1     | GasPumpPurgeCycle | 20    |
#      那么调用成功
      假如设置配置参数如下时:
        | name      | index | paramName         | value |
        | GasConfig | 1     | GasPumpPurgeCycle | 20    |
      当调用"setup"的"loadFromSetup"接口时:
        | name      | index |
        | GasConfig | 1     |
#      那么调用成功
      那么一刻"/SETUP/GasConfig/cfgGasPumpPurgeCycle"的值为"20"
#      当一刻调用"IO"的"getValue"接口时:
#        | name                                  |
#        | /SETUP/GasConfig/cfgGasPumpPurgeCycle |
#      那么一刻返回如下:
#      """
#      : {value:20}
#      """


    场景: 加载不存在的文件名的参数
      当调用"setup"的"loadFromSetup"接口时:
        | name      | index |
        | not_exist | 1     |
      那么调用失败

    场景: 加载错误索引的参数
      假如设置配置参数如下时:
        | name      | index | paramName         | value |
        | GasConfig | 1     | GasPumpPurgeCycle | 12    |
      当调用"setup"的"loadFromSetup"接口时:
        | name      | index |
        | GasConfig | 10000 |
      那么一刻"/SETUP/GasConfig/cfgGasPumpPurgeCycle"的值为"12"

  Rule: saveSetupToXML
    场景: 保存正确的配置选项
      当调用"setup"的"setSetupValue"接口时:
        | name      | index | paramName         | value |
        | GasConfig | 1     | GasPumpPurgeCycle | 22    |
      当调用"setup"的"saveSetupToXML"接口时:
        | name      |
        | GasConfig |
      那么调用成功
      并且一刻下位机文件应为:
      """
      508Bv2_PM.config_PM2_GDEC200_6958.Setup['GasConfig.xml'].lines: [
        ...
        /.*<Value paramName="GasPumpPurgeCycle">22.*/
        ...
      ]
      """

    场景: 保存错误的配置选项
      当调用"setup"的"saveSetupToXML"接口时:
        | name      |
        | not_exist |
      那么调用失败

  Rule: getSetupAllParams

    场景: 获取存在的配置选项的所有参数
      当调用"setup"的"getSetupAllParams"接口时:
        | name      |
        | GasConfig |
      那么调用成功
      并且返回如下:
      """
      :[
        {
          "typeInfo":{
            "min": 0,
            "max": 10000,
            "unit": '',
            "descriptors": []
          },
          "name": "GasPumpPurgeCycle",
          "dataObj": "/SETUP/GasConfig/cfgGasPumpPurgeCycle",
          "defaultValue": "20",
          "type": "INTDATA"
        },
        ...
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
        | name      | index | paramName         | value |
        | GasConfig | 1     | GasPumpPurgeCycle | 23    |
      当调用"setup"的"getSetupOptionValues"接口时:
        | name      | index |
        | GasConfig | 1     |
      那么调用成功
      并且返回如下:
      """
      =['23',...]
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
        | name      | index |
        | GasConfig | -1    |
      那么调用成功
      并且返回如下:
      """
      =[]
      """

  Rule: setSetupValue

    场景: 修改正确的setup值并验证
      假如设置配置参数如下时:
        | name      | index | paramName         | value |
        | GasConfig | 1     | GasPumpPurgeCycle | 23    |
      当调用"setup"的"setSetupValue"接口时:
        | name      | index | paramName         | value |
        | GasConfig | 1     | GasPumpPurgeCycle | 222   |
      当调用"setup"的"getSetupOptionValues"接口时:
        | name      | index |
        | GasConfig | 1     |
      那么返回如下:
      """
      =['222',...]
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