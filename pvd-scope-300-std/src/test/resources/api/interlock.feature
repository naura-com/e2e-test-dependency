# language: zh-CN
@pvd-lower
@clean-alarm
功能: InterLock
  Rule: getInterlockInfo

    场景: 获取指定的Interlock的信息
      当调用"interlock"的"getInterlockInfo"接口时:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      那么调用成功
      并且返回如下:
      """
      :{
        guardedData: '/Control/ATR/State',
        checkers:[
                  '(/IO/ATRExports/State != NotReady)'
                  ],
        type: SETVALUE,
        id: '/Control/ATR/SInterlocks/Online',
        trigger: '(/IO/ATRExports/State == Online)'
        }
      """

    场景: 获取不存在的Interlock的信息
      当调用"interlock"的"getInterlockInfo"接口时:
        | id        |
        | not_exist |
      那么调用成功
      并且返回如下:
      """
      null
      """

  Rule: getAllInterlockInfos

    场景: 获取所有的Interlock信息
      当调用"interlock"的"getAllInterlockInfos"接口时
      那么调用成功
      并且返回如下:
      """
      : [...]
      """

  Rule: isActive

    场景: 激活指定interlock后判断Interlock处于激活状态
      假如激活互锁:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      当调用"interlock"的"isActive"接口时:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      那么调用成功
      并且返回如下:
      """
      = true
      """

    场景: 取消激活指定interlock后判断Interlock处于非激活状态
      假如取消激活互锁:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      当调用"interlock"的"isActive"接口时:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      那么调用成功
      并且返回如下:
      """
      = false
      """

    场景: 判断不存在的Interlock是否处于激活状态
      当调用"interlock"的"isActive"接口时:
        | id        |
        | not_exist |
      那么调用成功
      并且返回如下:
      """
      = false
      """


  Rule: activate

    场景: 激活指定的S型Interlock
      假如激活互锁:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      当调用"IO"的"setValue"接口时:
        | name                 | value    |
        | /IO/ATRExports/State | NotReady |
      当调用"IO"的"setValue_Async"接口时:
        | name                 | value  |
        | /IO/ATRExports/State | Online |
      那么抛出报警:
      """
      :[
        ...
        '/Control/ATR/SInterlocks/Online/ModuleNotReady'
        ...
        ]
      """

    场景: 激活指定的V型Interlock
      假如激活互锁:
        | id                                         |
        | /Control/BufferChamber/VInterlocks/LidOpen |
      当调用"IO"的"setValue"接口时:
        | name                                | value     |
        | /IO/Platform/Plc/Buffer/LidClosedDI | NotClosed |
      那么抛出报警:
      """
      :[
        ...
        '/Control/BufferChamber/VInterlocks/LidOpen/Alarm'
        ...
        ]
      """

    场景: 激活不存在的Interlock
      当调用"interlock"的"activate"接口时:
        | id        |
        | not_exist |
      那么调用失败

  Rule: deactivate

    场景: 取消激活指定的Interlock
      假如取消激活互锁:
        | id                              |
        | /Control/ATR/SInterlocks/Online |
      当调用"IO"的"setValue"接口时:
        | name                 | value    |
        | /IO/ATRExports/State | NotReady |
      当调用"IO"的"setValue"接口时:
        | name                 | value  |
        | /IO/ATRExports/State | Online |
      那么不会抛出报警:
      """
      /Control/Ch1/SInterlocks/ChangeToShuttered/ShutterDiskNotInChamber
      """

    场景: 取消激活指定的V型Interlock
      假如取消激活互锁:
        | id                                         |
        | /Control/BufferChamber/VInterlocks/LidOpen |
      当调用"IO"的"setValue"接口时:
        | name                                | value     |
        | /IO/Platform/Plc/Buffer/LidClosedDI | NotClosed |
      那么不会抛出报警:
      """
      :[
        ...
        '/Control/Ch1/VInterlocks/Bakeout/Disabled'
        ...
        ]
      """

    场景: 取消激活不存在的Interlock
      当调用"interlock"的"deactivate"接口时:
        | id        |
        | not_exist |
      那么调用失败