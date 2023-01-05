# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
#@skip
功能: 报警查询界面

  Rule: Execute

    @etch1-init
    场景: PM无历史数据条件下执行Execute
      假如"PM2"不存在"2022-11-29"至"2022-11-29"时间段的alarm历史记录
      当查询"PM2"模块所有类型"2022-11-29"至"2022-11-29"时间段的报警信息时
      那么查询失败,提示信息为:
      """
      = "There is no alarm data!"
      """

    场景: 无有效数据的时间范围条件下执行Execute
      当查询"PM2"模块所有类型"2022-11-30"至"2022-11-29"时间段的报警信息时
      那么查询失败,提示信息为:
      """
      = "This start time is later than end time, please input again!"
      """

    @etch-reset
    @etch1-clean-all-alarm
    场景: 查询指定模块指定时间已存在数据
      假如存在报警记录:
        | alarm id | module | alarm name                                                                  | alarm message                                                     | alarm description                                                                      | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm                                    | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status. | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
        | 586      | PM2    | /Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm | UnDefined7  LifeCounter exceed soft threshold.                    | UnDefined7  LifeCounter exceed soft threshold.                                         | PROBLEM  | 2022-08-11 10:05:02 |                     | 2022-08-11 10:05:10 |
        | 535      | PM2    | /Control/Functional/PM/nErrorOrFaltalAlarmExist                             | Error or Fatal alarm exist.                                       | Error or Fatal alarm exist! Operation can not be done.                                 | ERROR    | 2022-08-12 10:05:22 |                     | 2022-08-12 10:05:27 |
      当查询"PM2"模块所有类型"2022-08-11"至"2022-08-11"时间段的报警信息时
      那么查询结果为:
      """
      =[
      [
      'PROBLEM',
      '2022-08-11 10:05:02',
      '2022-08-11 10:05:10',
      '586',
      '/Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm',
      'UnDefined7  LifeCounter exceed soft threshold.',
      'PM2',
      'UnDefined7  LifeCounter exceed soft threshold.'
      ]
      ]
      """

    @etch-reset
    @etch1-clean-all-alarm
    场景: 查询指定模块指定类型已存在数据
      假如存在报警记录:
        | alarm id | module | alarm name                                                                  | alarm message                                                     | alarm description                                                                      | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm                                    | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status. | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
        | 586      | PM2    | /Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm | UnDefined7  LifeCounter exceed soft threshold.                    | UnDefined7  LifeCounter exceed soft threshold.                                         | PROBLEM  | 2022-08-11 10:05:02 |                     | 2022-08-11 10:05:10 |
        | 535      | PM2    | /Control/Functional/PM/nErrorOrFaltalAlarmExist                             | Error or Fatal alarm exist.                                       | Error or Fatal alarm exist! Operation can not be done.                                 | ERROR    | 2022-08-12 10:05:22 |                     | 2022-08-12 10:05:27 |
      当查询"PM2"类型为"PROBLEM"的"2022-08-10"至"2022-08-12"时间段的报警信息时
      那么查询结果为:
      """
      =[
      [
      ...
      'PROBLEM',
      '2022-08-11 10:05:02',
      '2022-08-11 10:05:10',
      'PM2'
      ...
      ]
      ]
      """

    @etch-reset
    @etch1-clean-all-alarm
    场景: 查询所有模块所有类型指定时间已存在数据
      假如存在报警记录:
        | alarm id | module | alarm name                                                                  | alarm message                                                     | alarm description                                                                                                        | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm                                    | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status.                                   | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
        | 586      | PM2    | /Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm | UnDefined7  LifeCounter exceed soft threshold.                    | UnDefined7  LifeCounter exceed soft threshold.                                                                           | PROBLEM  | 2022-08-11 10:05:02 |                     | 2022-08-11 10:05:10 |
        | 1        | CTC    | TaskValidateModulesFail                                                     | Centering's state is not ok.                                      | job1 validated modules failed for Centering's state is not ok. Ensure Centering at [Standby] state when start a new job. | ERROR    | 2022-08-13 10:05:22 |                     | 2022-08-13 10:05:27 |
      当查询所有模块所有类型"2022-08-10"至"2022-08-14"时间段的报警信息时
      那么查询结果为:
      """
      =[
         [
         'EVENT','2022-08-10 19:03:41','2022-08-10 19:03:52','543','/Control/Operational/PM/InvalidModeAlarm','/Control/Operational/PM is not in proper mode for this operation.','PM2',"A client has attempted to run a service when it's status is not in the correct status."
         ],
         [
         'PROBLEM','2022-08-11 10:05:02','2022-08-11 10:05:10','586','/Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm','UnDefined7  LifeCounter exceed soft threshold.','PM2','UnDefined7  LifeCounter exceed soft threshold.'
         ],
         [
         'ERROR','2022-08-13 10:05:22','2022-08-13 10:05:27','1','TaskValidateModulesFail',"Centering's state is not ok.",'CTC',"job1 validated modules failed for Centering's state is not ok. Ensure Centering at [Standby] state when start a new job."
         ]
      ]
      """

    @etch-reset
    @etch1-clean-all-alarm
    场景: 查询所有模块指定类型指定时间已存在数据
      假如存在报警记录:
        | alarm id | module | alarm name                                                                  | alarm message                                                     | alarm description                                                                                                        | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm                                    | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status.                                   | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
        | 586      | PM2    | /Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm | UnDefined7  LifeCounter exceed soft threshold.                    | UnDefined7  LifeCounter exceed soft threshold.                                                                           | PROBLEM  | 2022-08-11 10:05:02 |                     | 2022-08-11 10:05:10 |
        | 535      | PM2    | /Control/Functional/PM/nErrorOrFaltalAlarmExist                             | Error or Fatal alarm exist.                                       | Error or Fatal alarm exist! Operation can not be done.                                                                   | ERROR    | 2022-08-12 10:05:22 |                     | 2022-08-12 10:05:27 |
        | 1        | CTC    | TaskValidateModulesFail                                                     | Centering's state is not ok.                                      | job1 validated modules failed for Centering's state is not ok. Ensure Centering at [Standby] state when start a new job. | ERROR    | 2022-08-13 10:05:22 |                     | 2022-08-13 10:05:27 |
      当查询所有模块"ERROR"类型"2022-08-10"至"2022-08-14"时间段的报警信息时
      那么查询结果为:
      """
      =[
         [
         'ERROR','2022-08-12 10:05:22','2022-08-12 10:05:27','535','/Control/Functional/PM/nErrorOrFaltalAlarmExist','Error or Fatal alarm exist.','PM2','Error or Fatal alarm exist! Operation can not be done.'
         ],
         [
         'ERROR','2022-08-13 10:05:22','2022-08-13 10:05:27','1','TaskValidateModulesFail',"Centering's state is not ok.",'CTC',"job1 validated modules failed for Centering's state is not ok. Ensure Centering at [Standby] state when start a new job."
         ]
      ]
      """

    @etch-reset
    @etch1-clean-all-alarm
    场景: 查询指定模块所有类型已存在数据
      假如存在报警记录:
        | alarm id | module | alarm name                                                                  | alarm message                                                     | alarm description                                                                                                        | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm                                    | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status.                                   | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
        | 586      | PM2    | /Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm | UnDefined7  LifeCounter exceed soft threshold.                    | UnDefined7  LifeCounter exceed soft threshold.                                                                           | PROBLEM  | 2022-08-11 10:05:02 |                     | 2022-08-11 10:05:10 |
        | 535      | PM2    | /Control/Functional/PM/nErrorOrFaltalAlarmExist                             | Error or Fatal alarm exist.                                       | Error or Fatal alarm exist! Operation can not be done.                                                                   | ERROR    | 2022-08-12 10:05:22 |                     | 2022-08-12 10:05:27 |
        | 1        | CTC    | TaskValidateModulesFail                                                     | Centering's state is not ok.                                      | job1 validated modules failed for Centering's state is not ok. Ensure Centering at [Standby] state when start a new job. | ERROR    | 2022-08-13 10:05:22 |                     | 2022-08-13 10:05:27 |
      当查询"PM2"模块所有类型"2022-08-10"至"2022-08-14"时间段的报警信息时
      那么查询结果为:
      """
      =[
         [
         'EVENT','2022-08-10 19:03:41','2022-08-10 19:03:52','543','/Control/Operational/PM/InvalidModeAlarm','/Control/Operational/PM is not in proper mode for this operation.','PM2',"A client has attempted to run a service when it's status is not in the correct status."
         ],
         [
         'PROBLEM','2022-08-11 10:05:02','2022-08-11 10:05:10','586','/Control/Util/CounterManager/CounterItems/UnDefined7/nLifeCounterSoftTolAlm','UnDefined7  LifeCounter exceed soft threshold.','PM2','UnDefined7  LifeCounter exceed soft threshold.'
         ],
         [
         'ERROR','2022-08-12 10:05:22','2022-08-12 10:05:27','535','/Control/Functional/PM/nErrorOrFaltalAlarmExist','Error or Fatal alarm exist.','PM2','Error or Fatal alarm exist! Operation can not be done.'
         ]
      ]
      """

  Rule: Clear Result

    场景: 已经查询出数据的条件下执行clear Result
      假如Query Result已显示查询结果
      当执行"Clear Result"操作
      那么Query Result显示为空

  Rule: Load

    @etch-reset
    @etch1-clean-all-alarm
    @CleanDir
    场景: 导入文件
      假如存在可导入文件"C:\test\testFiles\Alarm.txt"包含内容:
        | Id  | Name                                       | Severity | Message              | Description                                                                      | PostTime            | RecoveryType | RecoveryTime        | Module |
        | 292 | VInterlock_Scrubber1Failed_Scrubber1Failed | ERROR    | Scrubber1 is not ok. | Scrubber1 is not ok. The channel [/IO/SlaveNode/SCRUBBER1_STATUS] should be [OK] | 2022-11-30 08:58:14 |              | 2022-11-30 08:58:21 | TM     |
      当导入Alarm文件"Z:\testFiles\Alarm.txt"时
      那么查询结果为:
        """
        =[
        [
        'ERROR',
        '2022-11-30 08:58:14',
        '2022-11-30 08:58:21',
        '292',
        'VInterlock_Scrubber1Failed_Scrubber1Failed',
        'Scrubber1 is not ok.',
        'TM',
        'Scrubber1 is not ok. The channel [/IO/SlaveNode/SCRUBBER1_STATUS] should be [OK]'
        ]
        ]
        """

    @etch-reset
    @etch1-clean-all-alarm
    @CleanDir
    场景: 导入非法文件
      假如存在可导入非法文件"C:\test\testFiles\Alarm.txt"
      当导入Alarm文件"Z:\testFiles\Alarm.txt"时
      那么查询失败,提示信息为:
      """
      = "There is no alarm data!"
      """

  Rule: Export

    @etch-reset
    @etch1-clean-all-alarm
    场景: 未执行查询数据的条件下执行Export
      当执行"Export"操作
      那么操作失败,当前提示信息为:
      """
      = "The table has no data, export failed!"
      """

    @etch-reset
    @etch1-clean-all-alarm
    @CleanDir
    场景: 成功导出文件提示信息验证
      假如存在报警记录:
        | alarm id | module | alarm name                               | alarm message                                                     | alarm description                                                                      | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status. | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
      假如查询"PM2"模块所有类型"2022-08-10"至"2022-08-10"时间段的报警信息时
      当执行"Export"到"test.txt"并二次确认时
      那么操作成功,当前提示信息为:
      """
      = "Export Data Successfully!"
      """

    #TODO : 报错，时间段输入需要在最后额外添加一个’/‘，请注意
    @etch-reset
    @etch1-clean-all-alarm
    @CleanDir
    场景: 成功导出文件验证
      假如存在报警记录:
        | alarm id | module | alarm name                               | alarm message                                                     | alarm description                                                                      | severity | alarm post time     | alarm recovery type | alarm recovery time |
        | 543      | PM2    | /Control/Operational/PM/InvalidModeAlarm | /Control/Operational/PM is not in proper mode for this operation. | A client has attempted to run a service when it's status is not in the correct status. | EVENT    | 2022-08-10 19:03:41 |                     | 2022-08-10 19:03:52 |
      假如查询"PM2"模块所有类型"2022-08-10"至"2022-08-10"时间段的报警信息时
      当执行"Export"到"test"并二次确认时
      那么导出文件"test.txt"成功
      并且文件"test.txt"的内容为:
      """
      =["ALID 543{",
      "     ALName: /Control/Operational/PM/InvalidModeAlarm",
      "     ALSeverity: EVENT",
      "     ALMessage: /Control/Operational/PM is not in proper mode for this operation.",
      "     ALDescription: A client has attempted to run a service when it's status is not in the correct status.",
      "     ALPostTime: 2022-08-10 19:03:41",
      "     ALRecoveryType: ",
      "     ALRecoveryTime: 2022-08-10 19:03:52",
      "     ALModule: PM2",
      "   }",
      ""
      ]
      """

  Rule: SelectAll

    @etch-reset
    @etch1-clean-all-alarm
    场景: Modules区域执行SelectAll
      当"Modules"点击SelectAll
      那么所有PM,TM被选中

    @etch-reset
    @etch1-clean-all-alarm
    场景: Severity区域执行SelectAll
      当"Severity"点击SelectAll
      那么所有报警级别被选中


