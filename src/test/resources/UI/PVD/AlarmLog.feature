# language: zh-CN
@skip
@pvd-lower
@clean-lower-recipe
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
