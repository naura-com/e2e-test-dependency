# language: zh-CN
@skip
@clean-lower-route
功能:DataLog界面
  Rule:test
    场景:test
#      假如存在"Lot":
#        | starttime           | endtime             | lotid    |
#        | 2022-12-14T14:00:00 | 2022-12-14T15:00:00 | test_lot |
      假如存在"Ch2":
        | lot.lotid | lot.starttime       | lot.endtime         |
        | test_lot  | 2022-12-14T14:00:00 | 2022-12-14T15:00:00 |
      假如存在"Transfer":
        | triggerTime         | collectTime         | lotId    | mtName | mtNameId | module | actor | action        | actparam | triggerTimeMs |
        | 2022-12-14T14:00:00 | 2022-12-14T14:00:01 | test_lot | LP1,1  | 01       | Ch2    |       | begin process |          | 200           |
