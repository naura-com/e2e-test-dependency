# language: zh-CN
#@ETCH-PM2-lower
#@clean-lower-recipe
@pvd-lower
@deactivate-interlock
@clean-alarm
功能:Alarm

  Rule:getAllAlarms

    @skip
    场景: getAllAlarms
      当调用"alarm"的"getAllAlarms"接口时
      那么返回如下:
        """
        :[...
        "/Control/Buffer/Vacuum/VentAlarm"
        ...
        ]
        """

  Rule:getAlarmInfo

    @skip
    场景: 获取存在的未触发的Alarm信息
      当调用"alarm"的"getAlarmInfo"接口时:
        | id                               |
        | /Control/Buffer/Vacuum/VentAlarm |
      那么返回如下:
      """
      :{
        type:'NONBLOCKING'
        name:"/Control/Buffer/Vacuum/VentAlarm",
        number:5254,
        message:"Perform 'Vent' operation on 'Vacuum' failed!",
        description:"",
        isPosted:false,
        poster:"None",
        severity:'ERROR',
        hasAutoRecovery:false,
        optRecoveryInfos:
          [{message:"Clear",
          type:'CLEAR'}]
      }
      """

    场景: 获取存在的已抛出的Alarm"DevicenetIG"信息
      假如激活并触发互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"
      并且产生了报警"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm"
      当调用"alarm"的"getAlarmInfo"接口时:
        | id                                            |
        | /Control/Ch3/VInterlocks/PlcSafeFBError/Alarm |
      那么返回如下:
      """
        isPosted:true
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
      假如激活并触发互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"
      并且产生了报警"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm"
      当调用"alarm"的"getAllPostedAlarms"接口时
      那么返回如下:
      """
      =["/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm"]
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
            name:"/Control/Buffer/Vacuum/VentAlarm",
            number:5254,
            message:"Perform 'Vent' operation on 'Vacuum' failed!",
            description:"",
            isPosted:false,
            poster:"None",
            severity:'ERROR',
            hasAutoRecovery:false,
            optRecoveryInfos:
              [{message:"Clear",
              type:'CLEAR'}]
          }
        ...]
        """

  Rule:recoverAlarm

    场景:recoverAlarm pos=0
      假如激活并触发互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"
      并且产生了报警"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm"
      并且消除互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"的触发条件
      当调用"alarm"的"recoverAlarm"接口时:
      """
      {
      "id":"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm",
      "pos":0
      }
      """
      并且调用"alarm"的"getAllPostedAlarms"接口时
      那么返回如下:
      """
      =[]
      """

    场景:recoverAlarm pos!=0
      假如激活并触发互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"
      并且产生了报警"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm"
      并且消除互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"的触发条件
      当调用"alarm"的"recoverAlarm"接口时:
      """
      {
      "id":"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm",
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
      假如激活并触发互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"
      并且产生了报警"/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm"
      并且消除互锁"/Control/Ch3/VInterlocks/PlcSafeFBError"的触发条件
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




