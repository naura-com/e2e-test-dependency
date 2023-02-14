# language: zh-CN
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
        | name   | posttime            |
        | alarm1 | 2022-01-01T08:00:00 |
        | alarm2 | 2022-01-01T08:00:00 |
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      那么当前页面显示如下:
      """
      alarmInfo: | 名称    |
                 | alarm2 |
                 | alarm1 |
      """

  Rule: 过滤

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤指定模块所有类型的报警记录
      假如存在"Alarm":
        | name                                                   | poster                                  | posttime            |
        | /Control/Ch2/VInterlocks/FBError/G0501Closed           | /Control/Ch2/VInterlocks/FBError        | 2022-01-01T08:00:00 |
        | /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown | /Control/FFU/VInterlocks/FFUSpeed2Alarm | 2022-01-01T08:00:00 |
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"ALL LEVELS"和抛出模块"Ch2"的记录
      那么当前页面显示如下:
      """
      alarmInfo: | 名称                                          | 抛出者                            |
                 | /Control/Ch2/VInterlocks/FBError/G0501Closed | /Control/Ch2/VInterlocks/FBError |
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤所有模块指定类型的报警记录
      假如存在"Alarm":
        | name        | severity | posttime            |
        | NOTICEAlarm | NOTICE   | 2022-01-01T08:00:00 |
        | FATALAlarm  | FATAL    | 2022-01-01T08:00:00 |
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"FATAL"和抛出模块"ALL MODULES"的记录
      那么当前页面显示如下:
      """
      alarmInfo: | 级别   |
                 | FATAL |
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤所有模块所有类型的报警记录
      假如存在"Alarm":
        | name                                                   | severity | poster                                  | posttime            |
        | /Control/Ch2/VInterlocks/FBError/G0501Closed           | NOTICE   | /Control/Ch2/VInterlocks/FBError        | 2022-01-01T08:00:00 |
        | /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown | FATAL    | /Control/FFU/VInterlocks/FFUSpeed2Alarm | 2022-01-01T08:00:00 |
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"ALL LEVELS"和抛出模块"ALL MODULES"的记录
      那么当前页面显示如下:
      """
      alarmInfo: | 名称                                                    | 抛出者                                   | 级别   |
                 | /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown | /Control/FFU/VInterlocks/FFUSpeed2Alarm | FATAL |
                 | /Control/Ch2/VInterlocks/FBError/G0501Closed           | /Control/Ch2/VInterlocks/FBError        | NOTICE |
      """

    @pvd-lower
    @clean-alarm-log
    @pvd-ui
    场景: 过滤指定模块指定类型的报警记录
      假如存在"Alarm":
        | name                                                   | severity | poster                                  | posttime            |
        | /Control/Ch2/VInterlocks/FBError/G0501Closed           | NOTICE   | /Control/Ch2/VInterlocks/FBError        | 2022-01-01T08:00:00 |
        | /Control/FFU/VInterlocks/FFUSpeed2Alarm/TriggerUnknown | FATAL    | /Control/FFU/VInterlocks/FFUSpeed2Alarm | 2022-01-01T08:00:00 |
      当查询"2022-01-01"至"2022-01-01"时间段的报警信息时
      并且过滤报警级别"NOTICE"和抛出模块"Ch2"的记录
      那么当前页面显示如下:
      """
      alarmInfo: | 名称                                                    | 抛出者                                   | 级别   |
                 | /Control/Ch2/VInterlocks/FBError/G0501Closed           | /Control/Ch2/VInterlocks/FBError        | NOTICE |
      """
