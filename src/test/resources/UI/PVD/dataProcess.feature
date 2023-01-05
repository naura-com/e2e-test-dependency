# language: zh-CN
@skip
@pvd-ui
@clean-lower-route
@create-table-chc
功能:工艺数据界面

  场景:无效时间范围条件下执行查询
    当查询"2022-11-02-08:00:00"至"2022-11-01-08:00:00"时间段内"基于批次"的工艺数据时
    那么抛出以下信息，同时执行"确定"
      """
      = "起始时间不能晚于或等于结束时间，请重新选择时间"
      """
    当查询"2022-11-02-08:00:00"至"2022-11-01-08:00:00"时间段内"基于腔室"的工艺数据时
    那么抛出以下信息，同时执行"确定"
      """
      = "起始时间不能晚于或等于结束时间，请重新选择时间"
      """

  场景:基于批次与基于腔室的切换
    假如现在是"基于批次"查询
    当切换"基于腔室"查询
    那么抛出以下信息，同时执行"确定"
      """
      = "请确认是否要选择基于'腔室'查询的方式？"
      """
    当切换"基于批次"查询
    那么抛出以下信息，同时执行"确定"
      """
      = "请确认是否要选择基于'批次'查询的方式？"
      """

  Rule:基于批次查询

    场景:没有数据时基于批次查询
      当查询"2022-11-01-08:00:00"至"2022-11-02-08:00:00"时间段内"基于批次"的工艺数据时
      那么抛出以下信息，同时执行"确定"
      """
      = "未查询到符合条件的数据信息！"
      """

    场景:基于批次查询时批次号验证
      假如存在"Lot":
        | lotid     | starttime           | endtime             |
        | test_lot1 | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
        | test_lot2 | 2022-12-18T09:00:00 | 2022-12-18T10:00:00 |
      当查询"2022-12-18-00:00:00"至"2022-12-18-02:00:00"时间段内"基于批次"的工艺数据时
      那么批次列表显示为
      """
      = [test_lot1,test_lot2]
      """
      并且批次总数显示为
      """
      = "Total:2"
      """
      并且批次信息表显示为
      """
      = [
            {
                lotid: "test_lot1",
                starttime: "2022-12-18 00:00:00",
                endtime: "2022-12-18 01:00:00"
            },
            {
                endtime: "2022-12-18 02:00:00",
                lotid: "test_lot2",
                starttime: "2022-12-18 01:00:00"
            }
        ]

      """

    场景:基于批次查询时批次信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"时
      那么批次信息显示为
      """
      =[
        "Lot: test_lot   2022-12-18 00:00:00    2022-12-18 01:00:00   (0天1小时0分钟0秒)"
       ]
      """

    场景:基于批次查询时批次的物料验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | lotId    | mtName | mtNameId |
        | 2022-12-18T08:01:00 | test_lot | LP1.1  | 01       |
        | 2022-12-18T08:02:00 | test_lot | LP1.2  | 02       |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      那么批次"test_lot"显示的物料有
      """
      = [LP1.1^01,LP1.2^02]
      """

    场景:基于批次查询时物料信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | lotId    | mtName | mtNameId |
        | 2022-12-18T08:01:00 | test_lot | LP1.1  | 01       |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"时
      那么物料信息标题显示为
      """
      = "test_lot|LP1.1"
      """

    场景:基于批次查询时物料历史列表信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action          | actparam    |
        | 2022-12-18T08:01:00 | 111           | test_lot | LP1.1  | 01       | Atr    | Arm A | begin Pick from | LP1         |
        | 2022-12-18T08:12:00 | 123           | test_lot | LP1.1  | 01       | Ch2    |       | begin Process   | /Ch2/test;1 |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"时
      那么物料的HistoryList显示为
      """
      = [
          {
              actor: "Arm A",
              trigger_time: "2022-12-18 00:01:00",
              module: "Atr",
              materialnameid: 1,
              action: "begin Pick from",
              trigger_time_ms: 111,
              actparam: "LP1"
          },
          {
              actor: "(null)",
              trigger_time: "2022-12-18 00:12:00",
              module: "Ch2",
              materialnameid: 1,
              action: "begin Process",
              trigger_time_ms: 123,
              actparam: "/Ch2/test;1"
          }
        ]
      """

  Rule:基于腔室查询

    场景: 基于腔室查询时物料列表验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于腔室"的工艺数据时
      那么腔室"ChC"显示的物料有
      """
      =[LP1.1^01:/ChC/test;1:test_lot]
      """

    场景:基于腔室查询时物料信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于腔室"的工艺数据时
      并且选择批次"ChC"的物料"LP1.1^01:/ChC/test;1:test_lot"时
      那么物料信息显示为
      """
      =[
          "WaferName:   LP1.1",
          "RecipeName:  /ChC/test;1",
          "Start:            2022-12-18 00:00:05.123",
          "End:              2022-12-18 00:00:19.456",
          "Total:            14.333 s"
        ]
      """
      那么物料信息标题显示为
      """
      = "test_lot|LP1.1"
      """

  Rule:工艺信息验证

    场景:基于批次查询时物料工艺列表信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action        | actparam    |
        | 2022-12-18T08:01:00 | 111           | test_lot | LP1.1  | 01       | ChC    |       | begin Process | /ChC/test;1 |
        | 2022-12-18T08:12:00 | 111           | test_lot | LP1.1  | 01       | Ch2    |       | begin Process | /Ch2/test;1 |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"时
      那么物料的ProcessList显示为
      """
      = [
          {
              "No.": 1,
              Module: "ChC",
              Process: "/ChC/test;1"
          },
          {
              "No.": 2,
              Module: "Ch2",
              Process: "/Ch2/test;1"
          }
        ]
      """

    场景:基于批次查询时物料工艺信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:20 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 2:step2     |
        | 2022-12-18T08:00:34 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 2:step2     |
        | 2022-12-18T08:00:34 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
        | 2022-12-18T08:00:34 | test_lot | LP1.1  | /ChC/test;1 | 2            | 2              | step2       | 10          | 10.01              | 0     | 0     | 0     | 0     | 3     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"的第1个Process时
      那么物料工艺信息标题显示为
      """
      = "test_lot|LP1.1|/ChC/test;1"
      """
      并且物料工艺步骤列表显示为
      """
      = [
          {
              EndTime: "2022-12-18 00:00:19.456",
              StepTime: 10,
              StartTime: "2022-12-18 00:00:05.123",
              ElapsedTime: 14.333,
              StepName: "step1",
              ProcTime: 10.01,
              Step: 1
          },
          {
              EndTime: "2022-12-18 00:00:34.456",
              StepTime: 10,
              StartTime: "2022-12-18 00:00:20.123",
              ElapsedTime: 14.333,
              StepName: "step2",
              ProcTime: 10.01,
              Step: 2
          }
        ]
      """
      并且物料步骤信息显示为
      """
      = [
          {
              Std: 0,
              Min: 0,
              Avg: 0,
              Graph: "False",
              Max: 0,
              Samples: 2,
              Param: "InnerPower"
          }
          ...
        ]
      """

    场景:基于批次查询时物料工艺切换步骤信息验证
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:20 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 2:step2     |
        | 2022-12-18T08:00:34 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 2:step2     |
        | 2022-12-18T08:00:34 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
        | 2022-12-18T08:00:34 | test_lot | LP1.1  | /ChC/test;1 | 2            | 2              | step2       | 10          | 10.01              | 0     | 0     | 0     | 0     | 3     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"的第1个Process时
      当选择工艺的步骤"2"时
      那么物料步骤信息显示为
      """
      = [
          {
              Std: 0,
              Min: 0,
              Avg: 0,
              Graph: "False",
              Max: 0,
              Samples: 3,
              Param: "InnerPower"
          }
          ...
        ]
      """

    场景:基于批次查询时执行物料工艺的对比
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action        | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process | /ChC/test;1 |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"的第1个Process时
      并且执行界面的"对比"操作时
      那么抛出以下信息，同时执行"确定"
      """
      = "只支持基于腔室查询方式下的对比功能！"
      """

    场景:基于批次查询时不选择参数执行物料工艺的绘图
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action        | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process | /ChC/test;1 |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"的第1个Process时
      并且执行界面的"绘图"操作时
      那么抛出以下信息，同时执行"确定"
      """
      = "请选择要查看的参数！"
      """

    场景:基于批次查询时选择参数超过五个执行物料工艺的绘图
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于批次"的工艺数据时
      并且选择批次"test_lot"的物料"LP1.1^01"的第1个Process时
      当选择以下工艺参数
        | InnerPower | InnerCurrent | OuterPower | OuterCurrent | HeaterTemp | HeaterPower |
      并且执行界面的"绘图"操作时
      那么抛出以下信息，同时执行"确定"
      """
      = "同时选择的参数个数不能大于 5"
      """

    场景:基于腔室查询时不选择参数执行对比
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于腔室"的工艺数据时
      并且选择批次"ChC"的物料"LP1.1^01:/ChC/test;1:test_lot"的第1个Process时
      并且执行界面的"对比"操作时
      那么抛出以下信息，同时执行"确定"
      """
      = "请选择要查看的参数！"
      """

    场景:基于腔室查询时选择多个参数执行对比
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于腔室"的工艺数据时
      并且选择批次"ChC"的物料"LP1.1^01:/ChC/test;1:test_lot"的第1个Process时
      当选择以下工艺参数
        | InnerPower | InnerCurrent |
      并且执行界面的"对比"操作时
      那么抛出以下信息，同时执行"确定"
      """
      = "只能选择一个对比参数！"
      """

    场景:基于腔室查询时选择少于一个物料时执行对比
      假如存在"Lot":
        | lotid    | starttime           | endtime             |
        | test_lot | 2022-12-18T08:00:00 | 2022-12-18T09:00:00 |
      假如存在"Transfer":
        | triggerTime         | triggerTimeMs | lotId    | mtName | mtNameId | module | actor | action                | actparam    |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process         | /ChC/test;1 |
        | 2022-12-18T08:00:05 | 123           | test_lot | LP1.1  | 01       | ChC    |       | begin Process Step    | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process Step | 1:step1     |
        | 2022-12-18T08:00:19 | 456           | test_lot | LP1.1  | 01       | ChC    |       | finished Process      | /ChC/test;1 |
      假如存在"ChC":
        | triggerTime         | lotId    | mtName | rcpName     | rcpTotalStep | rcpStepCounter | rcpStepName | rcpStepTime | rcpStepElapsedTime | iPMin | iPMax | iPAvg | iPStd | iPTSN | iPBSN |
        | 2022-12-18T08:00:19 | test_lot | LP1.1  | /ChC/test;1 | 2            | 1              | step1       | 10          | 10.01              | 0     | 0     | 0     | 0     | 2     | 0     |
      当查询"2022-12-18-00:00:00"至"2022-12-18-01:00:00"时间段内"基于腔室"的工艺数据时
      当对比腔室"ChC"以下物料的参数"InnerPower"时
        | LP1.1^01:/ChC/test;1:test_lot |
      那么抛出以下信息，同时执行"确定"
      """
      = "要对比的wafer节点不能少于2个！"
      """


