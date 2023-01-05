# language: zh-CN
@skip
功能:报警记录界面

  Rule: 查询
    @pvd-ui
    场景: 无效时间范围条件下执行查询
      当查询"2022-11-30"至"2022-11-29"时间段的报警信息时
      那么抛出警告，信息为:
      """
      ="起始时间不能晚于结束时间，请重新选择时间！"
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景:查询指定时间段已存在的数据
      假如存在"Alarm":
      """
      [{
      name : /Control/Ch2/VInterlocks/FBError/G0501Closed,
      id : 1,
      severity : NOTICE,
      message : Ch2 chamber valve 'G0501' has closed.,
      poster : /Control/Ch2/VInterlocks/FBError,
      posttime : 2022-01-01T08:00:00
      },{
      name : /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown,
      id : 2,
      severity : FATAL,
      message : Interlock trigger state is unknown. (Hardware IO may be unavailable),
      poster : /Control/FFU/VInterlocks/FFUSpeed2Alarm,
      posttime : 2022-01-01T08:00:00
      }]
      """
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      那么报警查询结果显示为
      """
      : [
        {
        信息: "Interlock trigger state is unknown. (Hardware IO may be unavailable)",
        名称: "/Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/FFU/VInterlocks/FFUSpeed2Alarm",
        清除操作: "(null)",
        详述: "(null)",
        级别: "FATAL",
        抛出时间: "2022/1/1 0:00:00",
        编号: 2
        },
        {
        信息: "Ch2 chamber valve 'G0501' has closed.",
        名称: "/Control/Ch2/VInterlocks/FBError/G0501Closed",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/Ch2/VInterlocks/FBError",
        清除操作: "(null)",
        详述: "(null)",
        级别: "NOTICE",
        抛出时间: "2022/1/1 0:00:00",
        编号: 1
        }
        ]
      """

  Rule: 过滤

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤指定模块所有类型的报警记录
      假如存在"Alarm":
      """
      [{
      name : /Control/Ch2/VInterlocks/FBError/G0501Closed,
      id : 1,
      severity : NOTICE,
      message : Ch2 chamber valve 'G0501' has closed.,
      poster : /Control/Ch2/VInterlocks/FBError,
      posttime : 2022-01-01T08:00:00
      },{
      name : /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown,
      id : 2,
      severity : FATAL,
      message : Interlock trigger state is unknown. (Hardware IO may be unavailable),
      poster : /Control/FFU/VInterlocks/FFUSpeed2Alarm,
      posttime : 2022-01-01T08:00:00
      }]
      """
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"ALL LEVELS"和抛出模块"Ch2"的记录
      那么报警查询结果显示为
      """
      : [
        {
        信息: "Ch2 chamber valve 'G0501' has closed.",
        名称: "/Control/Ch2/VInterlocks/FBError/G0501Closed",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/Ch2/VInterlocks/FBError",
        清除操作: "(null)",
        详述: "(null)",
        级别: "NOTICE",
        抛出时间: "2022/1/1 0:00:00",
        编号: 1
        }
        ]
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤所有模块指定类型的报警记录
      假如存在"Alarm":
      """
      [{
      name : /Control/Ch2/VInterlocks/FBError/G0501Closed,
      id : 1,
      severity : NOTICE,
      message : Ch2 chamber valve 'G0501' has closed.,
      poster : /Control/Ch2/VInterlocks/FBError,
      posttime : 2022-01-01T08:00:00
      },{
      name : /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown,
      id : 2,
      severity : FATAL,
      message : Interlock trigger state is unknown. (Hardware IO may be unavailable),
      poster : /Control/FFU/VInterlocks/FFUSpeed2Alarm,
      posttime : 2022-01-01T08:00:00
      }]
      """
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"FATAL"和抛出模块"ALL MODULES"的记录
      那么报警查询结果显示为
      """
      : [
        {
        信息: "Interlock trigger state is unknown. (Hardware IO may be unavailable)",
        名称: "/Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/FFU/VInterlocks/FFUSpeed2Alarm",
        清除操作: "(null)",
        详述: "(null)",
        级别: "FATAL",
        抛出时间: "2022/1/1 0:00:00",
        编号: 2
        }
        ]
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤所有模块所有类型的报警记录
      假如存在"Alarm":
      """
      [{
      name : /Control/Ch2/VInterlocks/FBError/G0501Closed,
      id : 1,
      severity : NOTICE,
      message : Ch2 chamber valve 'G0501' has closed.,
      poster : /Control/Ch2/VInterlocks/FBError,
      posttime : 2022-01-01T08:00:00
      },{
      name : /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown,
      id : 2,
      severity : FATAL,
      message : Interlock trigger state is unknown. (Hardware IO may be unavailable),
      poster : /Control/FFU/VInterlocks/FFUSpeed2Alarm,
      posttime : 2022-01-01T08:00:00
      }]
      """
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"ALL LEVELS"和抛出模块"ALL MODULES"的记录
      那么报警查询结果显示为
      """
      : [
        {
        信息: "Interlock trigger state is unknown. (Hardware IO may be unavailable)",
        名称: "/Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/FFU/VInterlocks/FFUSpeed2Alarm",
        清除操作: "(null)",
        详述: "(null)",
        级别: "FATAL",
        抛出时间: "2022/1/1 0:00:00",
        编号: 2
        },
        {
        信息: "Ch2 chamber valve 'G0501' has closed.",
        名称: "/Control/Ch2/VInterlocks/FBError/G0501Closed",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/Ch2/VInterlocks/FBError",
        清除操作: "(null)",
        详述: "(null)",
        级别: "NOTICE",
        抛出时间: "2022/1/1 0:00:00",
        编号: 1
        }
        ]
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤指定模块指定类型的报警记录
      假如存在"Alarm":
      """
      [{
      name : /Control/Ch2/VInterlocks/FBError/G0501Closed,
      id : 1,
      severity : NOTICE,
      message : Ch2 chamber valve 'G0501' has closed.,
      poster : /Control/Ch2/VInterlocks/FBError,
      posttime : 2022-01-01T08:00:00
      },{
      name : /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown,
      id : 2,
      severity : FATAL,
      message : Interlock trigger state is unknown. (Hardware IO may be unavailable),
      poster : /Control/FFU/VInterlocks/FFUSpeed2Alarm,
      posttime : 2022-01-01T08:00:00
      }]
      """
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"NOTICE"和抛出模块"Ch2"的记录
      那么报警查询结果显示为
      """
      : [
        {
        信息: "Ch2 chamber valve 'G0501' has closed.",
        名称: "/Control/Ch2/VInterlocks/FBError/G0501Closed",
        清除时间: "(null)",
        清除者: "(null)",
        抛出者: "/Control/Ch2/VInterlocks/FBError",
        清除操作: "(null)",
        详述: "(null)",
        级别: "NOTICE",
        抛出时间: "2022/1/1 0:00:00",
        编号: 1
        }
        ]
      """

#  Rule: 导出
#
#    场景:未执行查询数据的条件下执行导出
#      当执行"导出"操作
#      那么操作失败,当前提示信息为:
#      """
#      ="当前没有可以保存的记录!"
#      """
#
#    场景:查询结果为空的条件下执行导出
#      当不存在报警记录
#      并且执行"导出"操作
#      那么操作失败,当前提示信息为:
#      """
#      ="当前没有可以保存的记录!"
#      """
#
#    场景: 成功导出提示信息验证
#      假如存在报警记录
#        | name | id | severity | message | description | poster | post time | recovery type | recovery time | recovactor |
#        |      |    | NOTICE   |         |             | Ch2    |           |               |               |            |
#      当查询"2022-11-30"至"2022-11-29"时间段的报警信息时
#      并且执行"导出"到"test"时
#      那么操作成功,当前提示信息为:
#      """
#      ="alarm数据文件已经成功导出到test"
#      """
#
#    场景: 成功导出文件验证
#      假如存在报警记录
#        | name | id | severity | message | description | poster | post time | recovery type | recovery time | recovactor |
#        |      |    | NOTICE   |         |             | Ch2    |           |               |               |            |
#      当查询"2022-11-30"至"2022-11-29"时间段的报警信息时
#      并且执行"导出"到"test"时
#      那么文件内容为:
#      """
#      =[
#        ]
#      """
#
#    场景: 导出报警存在同名文件,导出文件覆盖
#      假如在路径"E:\alarm"存在文件"alarm.csv":
#        | name | id | severity | message | description | poster | post time | recovery type | recovery time | recovactor |
#        |      |    | NOTICE   |         |             | Ch2    |           |               |               |            |
#      并且存在报警记录
#        | name | id | severity | message | description | poster | post time | recovery type | recovery time | recovactor |
#        |      |    | NOTICE   |         |             | Ch2    |           |               |               |            |
#      当用户"pe"使用密码"8888"启动上位机
#      并且查询"2022-11-30"至"2022-11-29"时间段的报警信息时
#      并且"导出"报警覆盖"alarm.csv"时
#      那么文件内容为:
#      """
#      =[
#
#        ]
#      """