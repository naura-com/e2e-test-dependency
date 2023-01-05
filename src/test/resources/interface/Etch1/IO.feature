# language: zh-CN
@ETCH-PM2-lower
@clean-alarm
#@skip
功能: IO
  Rule:SetValue
    场景:对存在的远程Data对象进行设值成功（同步调用）
      当一刻调用"IO"的"setValue"接口时:
        | name                                  | value |
        | /SETUP/GasConfig/cfgGasPumpPurgeCycle | 11    |
      那么一刻调用成功
      当一刻调用"IO"的"getValue"接口时:
        | name                                  |
        | /SETUP/GasConfig/cfgGasPumpPurgeCycle |
      那么一刻调用成功
      并且一刻返回如下:
      """
      value: 11
      """

    场景:对存在的远程Data对象进行设值失败（同步调用）
      当一刻调用"IO"的"setValue"接口时:
        | name                                  | value |
        | /SETUP/GasConfig/cfgGasPumpPurgeCycle | aaa   |
      那么一刻调用失败, 错误为:
      """
      null
      """

    场景大纲: 对存在的远程Data对象进行同步设值错误: <title>
      当一刻调用"IO"的"setValue"接口时:
        | name   | value   |
        | <name> | <value> |
      那么一刻调用失败, 错误为:
      """
      message= /.*<message>.*/
      """
      例子:
        | title                 | name                                  | value     | message                                                   |
        | Invalid value         | /SETUP/GasConfig/cfgGasPumpPurgeCycle | ?123      | failed! Invalid value                                     |
        | Value is out of range | /SETUP/GasConfig/cfgGasPumpPurgeCycle | 111111111 | the value 111111111 to set is out of range of 0 and 10000 |
        | Negative Number       | /SETUP/GasConfig/cfgGasPumpPurgeCycle | -1        | the value -1 to set is out of range of 0 and 10000        |

      #TODO: 这个场景没太看懂，那个通道值是互锁的触发条件吗?
#  Rule:SetValue_async
#    场景:对触发互锁的Data对象进行设值(异步调用)
#      假如一刻通道"/IO/ATRExports/State"的值为"NotReady"
#      假如激活并触发互锁"/Control/ATR/SInterlocks/Online"
#      当一刻调用"IO"的"setValue_Async"接口时:
#        | name                 | value  |
#        | /IO/ATRExports/State | Online |
#      那么一刻调用成功
#      并且一刻通道"/IO/ATRExports/State"的值为:
#      """
#      : {
#          descriptor: NotReady
#          value:-1
#      }
#      """

    场景大纲: 对存在的远程Data对象进行异步设值错误: <title>
      当一刻调用"IO"的"setValue_Async"接口时:
        | name   | value   |
        | <name> | <value> |
      那么一刻调用失败, 错误为:
      """
      null
      """
      例子:
        | title                 | name                                  | value     |
        | Invalid value         | /SETUP/GasConfig/cfgGasPumpPurgeCycle | ?123      |
        | Value is out of range | /SETUP/GasConfig/cfgGasPumpPurgeCycle | 111111111 |
        | Negative Number       | /SETUP/GasConfig/cfgGasPumpPurgeCycle | -1        |
        | NotIntType            | /SETUP/GasConfig/cfgGasPumpPurgeCycle | aaa       |


  Rule:getValue
    场景:获取指定远程Data对象的值信息
      当一刻调用"IO"的"getValue"接口时:
        | name                                  |
        | /SETUP/GasConfig/cfgGasPumpPurgeCycle |
      那么一刻调用成功
      并且一刻返回如下:
      """
      : {
        value: 11
        descriptor: ""
        type: {...}
        validity: {...}
        timeStamp: {...}
      }
      """

    场景: 获取不存在的远程Data对象的值信息
      * 一刻远程Data对象"/not-exist"为空

  Rule:getInfo
    场景:获取指定远程Data对象的信息
      当一刻调用"IO"的"getInfo"接口时:
        | name                                  |
        | /SETUP/GasConfig/cfgGasPumpPurgeCycle |
      那么一刻调用成功
      并且一刻返回如下:
      """
      : {
        typeInfo: {
          min: 0,
          max: 10000,
          unit: '',
          descriptors: []
        },
        type:  {...},
        accessMode:  {...},
        isSimulated: false,
        nodeNum: -1,
        channelNum: -1
      }
      """