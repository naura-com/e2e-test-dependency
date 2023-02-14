# language: zh-CN
#@ETCH-PM2-lower
#@clean-lower-recipe
#@pvd-lower
@etch1ref-lower
@deactivate-interlock
@clean-alarm
#@skip
功能:Alarm

  Rule:getAllAlarms

    @skip
    场景: getAllAlarms
      当调用"alarm"的"getAllAlarms"接口时
      那么返回如下:
        """
        :[...
        "VInterlock_TMAbnormal_TCLIDNotClosed"
        ...
        ]
        """

  Rule:getAlarmInfo

    场景: 获取存在的已抛出的Alarm"DevicenetIG"信息
      假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
      并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
      当调用"alarm"的"getAlarmInfo"接口时:
        | id                                   |
        | VInterlock_TMAbnormal_TCLIDNotClosed |
      那么返回如下:
      """
        isPosted:true
      """

    场景: 获取存在的未触发的Alarm信息
      假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
      并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
      并且消除互锁"/Control/OverrunInterlocks/TMAbnormal"的触发条件
      并且清除报警
      当调用"alarm"的"getAlarmInfo"接口时:
        | id                                   |
        | VInterlock_TMAbnormal_TCLIDNotClosed |
      那么返回如下:
      """
      :{
        type:'NONBLOCKING'
        name:"VInterlock_TMAbnormal_TCLIDNotClosed",
        number:293,
        message:"TC's lid is not closed.",
        description:"TC's lid is not closed. The channel [/IO/SlaveNode/LID_CLSD_ISO_TC] should be [Closed]",
        isPosted:false,
        poster:"/Control/OverrunInterlocks/TMAbnormal",
        severity:'FATAL',
        hasAutoRecovery:false,
        optRecoveryInfos:
          [{message:"Clear",
          type:'CLEAR'}]
      }
      """

    场景: 获取不存在的Alarm信息
      当调用"alarm"的"getAlarmInfo"接口时:
        | id         |
        | Dont-exist |
      那么返回如下:
      """
      null
      """

  Rule:getAllPostedAlarm
    场景: 无报警时查询被抛出报警
      当调用"alarm"的"getAllPostedAlarms"接口时
      那么返回如下:
      """
      =[]
      """

    场景: 有报警时查询被抛出报警
      假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
      并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
      当调用"alarm"的"getAllPostedAlarms"接口时
      那么返回如下:
      """
      =["VInterlock_TMAbnormal_TCLIDNotClosed"]
      """

  Rule:getAllAlarmInfos
    @skip
    场景: getAllAlarmInfos
      当调用"alarm"的"getAllAlarmInfos"接口时
      那么返回如下:
        """
        :[...
          {
          type:'NONBLOCKING'
          name:"VInterlock_TMAbnormal_TCLIDNotClosed",
          number:293,
          message:"TC's lid is not closed.",
          description:"TC's lid is not closed. The channel [/IO/SlaveNode/LID_CLSD_ISO_TC] should be [Closed]",
          isPosted:false,
          poster:"/Control/OverrunInterlocks/TMAbnormal",
          severity:'FATAL',
          hasAutoRecovery:false,
          optRecoveryInfos:
            [{message:"Clear",
            type:'CLEAR'}]
          }
        ...]
        """

  Rule:recoverAlarm

    场景:recoverAlarm pos=0
      假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
      并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
      当消除互锁"/Control/OverrunInterlocks/TMAbnormal"的触发条件
      当调用"alarm"的"recoverAlarm"接口时:
      """
      {
      "id":"VInterlock_TMAbnormal_TCLIDNotClosed",
      "pos":0
      }
      """
      并且调用"alarm"的"getAllPostedAlarms"接口时
      那么返回如下:
      """
      =[]
      """

    场景:recoverAlarm pos!=0
      假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
      并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
      当消除互锁"/Control/OverrunInterlocks/TMAbnormal"的触发条件
      当调用"alarm"的"recoverAlarm"接口时:
      """
      {
      "id":"VInterlock_TMAbnormal_TCLIDNotClosed",
      "pos":1
      }
      """
      那么调用失败, 错误为:
      """
      :{
      "message":null
      }
      """

    场景:recoverAlarm AlarmID无效
      假如激活并触发互锁"/Control/OverrunInterlocks/TMAbnormal"
      并且产生了报警"VInterlock_TMAbnormal_TCLIDNotClosed"
      当消除互锁"/Control/OverrunInterlocks/TMAbnormal"的触发条件
      当调用"alarm"的"recoverAlarm"接口时:
      """
      {
      "id":"Useless",
      "pos":0
      }
      """
      那么调用失败, 错误为:
      """
      :{
      "message":null
      }
      """




