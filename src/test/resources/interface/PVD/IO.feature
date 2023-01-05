# language: zh-CN
@skip
@pvd-lower
@clean-alarm
功能: IO
  Rule:SetValue
    场景:对存在的远程Data对象进行设值成功（同步调用）
      当调用"IO"的"setValue"接口时:
        | name                               | value |
        | /SETUP/Control/ATR/Aligner/AngleLA | 11    |
      那么调用成功
      当调用"IO"的"getValue"接口时:
        | name                               |
        | /SETUP/Control/ATR/Aligner/AngleLA |
      那么调用成功
      并且返回如下:
      """
      value: 11
      """

    场景:对存在的远程Data对象进行设值失败（同步调用）
      当调用"IO"的"setValue"接口时:
        | name                               | value |
        | /SETUP/Control/ATR/Aligner/AngleLA | aaa   |
      那么调用失败, 错误为:
      """
      null
      """

    场景大纲: 对存在的远程Data对象进行同步设值错误: <title>
      当调用"IO"的"setValue"接口时:
        | name   | value   |
        | <name> | <value> |
      那么调用失败, 错误为:
      """
      message= /.*<message>.*/
      """
      例子:
        | title                 | name                               | value     | message                                         |
        | Invalid value         | /SETUP/Control/ATR/Aligner/AngleLA | ?123      | failed! Invalid value                           |
        | Value is out of range | /SETUP/Control/ATR/Aligner/AngleLA | 111111111 | Input value is NOT in the range of '0 ~ 360000' |
        | Negative Number       | /SETUP/Control/ATR/Aligner/AngleLA | -1        | Input value is NOT in the range of '0 ~ 360000' |

  Rule:SetValue_async
    场景:对触发互锁的Data对象进行设值(异步调用)
      假如通道"/IO/ATRExports/State"的值为"NotReady"
      假如激活并触发互锁"/Control/ATR/SInterlocks/Online"
      当调用"IO"的"setValue_Async"接口时:
        | name                 | value  |
        | /IO/ATRExports/State | Online |
      那么调用成功
      并且通道"/IO/ATRExports/State"的值为:
      """
      : {
          descriptor: NotReady
          value:-1
      }
      """

    场景大纲: 对存在的远程Data对象进行异步设值错误: <title>
      当调用"IO"的"setValue_Async"接口时:
        | name   | value   |
        | <name> | <value> |
      那么调用失败, 错误为:
      """
      null
      """
      例子:
        | title                 | name                               | value     |
        | Invalid value         | /SETUP/Control/ATR/Aligner/AngleLA | ?123      |
        | Value is out of range | /SETUP/Control/ATR/Aligner/AngleLA | 111111111 |
        | Negative Number       | /SETUP/Control/ATR/Aligner/AngleLA | -1        |
        | NotIntType            | /SETUP/Control/ATR/Aligner/AngleLA | aaa       |


  Rule:getValue
    场景:获取指定远程Data对象的值信息
      当调用"IO"的"getValue"接口时:
        | name                               |
        | /SETUP/Control/ATR/Aligner/AngleLA |
      那么调用成功
      并且返回如下:
      """
      : {
        value: 11
        descriptor: ""
        type: {...}
        validity: {...}
        timeStamp: {...}
        transTimeStamp: ''
      }
      """

    场景: 获取不存在的远程Data对象的值信息
      * 远程Data对象"/not-exist"为空

  Rule:getInfo
    场景:获取指定远程Data对象的信息
      当调用"IO"的"getInfo"接口时:
        | name                               |
        | /SETUP/Control/ATR/Aligner/AngleLA |
      那么调用成功
      并且返回如下:
      """
      : {
        typeInfo: {
          min: 0,
          max: 360000,
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