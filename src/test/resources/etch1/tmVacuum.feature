# language: zh-CN
@etch1ref-lower
@etch1-ui
@reset-feature-ui
#@skip

功能: TMVacuum

  Rule: 上位机设置阀门
    场景: 设置TC的阀门Slow Vent状态为Open
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseSlowVent"
      当设置TM阀门"TC Slow Vent"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Slow Vent"显示为"Open"

    场景: 设置TC的阀门Slow Vent状态为Close
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenSlowVent"
      当设置TM阀门"TC Slow Vent"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Slow Vent"显示为"Close"

    场景: 设置TC的阀门Fast Vent状态为Open
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseFastVent"
      当设置TM阀门"TC Fast Vent"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Fast Vent"显示为"Open"

    场景: 设置TC的阀门Fast Vent状态为Close
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenFastVent"
      当设置TM阀门"TC Fast Vent"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Fast Vent"显示为"Close"

    场景: 设置TC的阀门Slow Rough状态为Open
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseSlowRough"
      当设置TM阀门"TC Slow Rough"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Slow Rough"显示为"Open"

    场景: 设置TC的阀门Slow Rough状态为Close
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenSlowRough"
      当设置TM阀门"TC Slow Rough"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Slow Rough"显示为"Close"

    场景: 设置TC的阀门Fast Rough状态为Open
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseFastRough"
      当设置TM阀门"TC Fast Rough"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Fast Rough"显示为"Open"

    场景: 设置TC的阀门Fast Rough状态为Close
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenFastRough"
      当设置TM阀门"TC Fast Rough"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"TC Fast Rough"显示为"Close"

    场景: 设置LA的阀门Slow Vent状态为Open
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseSlowVent"
      当设置TM阀门"LA Slow Vent"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Slow Vent"显示为"Open"

    场景: 设置LA的阀门Slow Vent状态为Close
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenSlowVent"
      当设置TM阀门"LA Slow Vent"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Slow Vent"显示为"Close"

    场景: 设置LA的阀门Fast Vent状态为Open
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseFastVent"
      当设置TM阀门"LA Fast Vent"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Fast Vent"显示为"Open"

    场景: 设置LA的阀门Fast Vent状态为Close
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenFastVent"
      当设置TM阀门"LA Fast Vent"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Fast Vent"显示为"Close"

    场景: 设置LA的阀门Slow Rough状态为Open
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseSlowRough"
      当设置TM阀门"LA Slow Rough"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Slow Rough"显示为"Open"

    场景: 设置LA的阀门Slow Rough状态为Close
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenSlowRough"
      当设置TM阀门"LA Slow Rough"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Slow Rough"显示为"Close"

    场景: 设置LA的阀门Fast Rough状态为Open
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseFastRough"
      当设置TM阀门"LA Fast Rough"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Fast Rough"显示为"Open"

    场景: 设置LA的阀门Fast Rough状态为Close
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenFastRough"
      当设置TM阀门"LA Fast Rough"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LA Fast Rough"显示为"Close"

    场景: 设置LB的阀门Slow Vent状态为Open
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseSlowVent"
      当设置TM阀门"LB Slow Vent"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Slow Vent"显示为"Open"

    场景: 设置LB的阀门Slow Vent状态为Close
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenSlowVent"
      当设置TM阀门"LB Slow Vent"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Slow Vent"显示为"Close"

    场景: 设置LB的阀门Fast Vent状态为Open
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseFastVent"
      当设置TM阀门"LB Fast Vent"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Fast Vent"显示为"Open"

    场景: 设置LB的阀门Fast Vent状态为Close
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenFastVent"
      当设置TM阀门"LB Fast Vent"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Fast Vent"显示为"Close"

    场景: 设置LB的阀门Slow Rough状态为Open
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseSlowRough"
      当设置TM阀门"LB Slow Rough"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Slow Rough"显示为"Open"

    场景: 设置LB的阀门Slow Rough状态为Close
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenSlowRough"
      当设置TM阀门"LB Slow Rough"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Slow Rough"显示为"Close"

    场景: 设置LB的阀门Fast Rough状态为Open
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseFastRough"
      当设置TM阀门"LB Fast Rough"为"Open"
      那么TM阀门在服务窗口显示为"Open"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Fast Rough"显示为"Open"

    场景: 设置LB的阀门Fast Rough状态为Close
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenFastRough"
      当设置TM阀门"LB Fast Rough"为"Close"
      那么TM阀门在服务窗口显示为"Close"
      当在TM服务窗口点击"Cancel"
      那么TM阀门"LB Fast Rough"显示为"Close"

  Rule: Pump

    场景: 设置DryPump状态为Pump Off
      假如TM处于Maintain模式
      假如TM设备"MTRC"状态为"TurnPumpOn"
      当设置TM的DryPump为"Pump Off"
      那么TM的DryPump在服务窗口显示为"Off"
      当在TM服务窗口点击"Cancel"
      那么TM的DryPump显示为"Off"

    场景: 设置DryPump状态为Pump On
      假如TM处于Maintain模式
      假如TM设备"MTRC"状态为"TurnPumpOff"
      当设置TM的DryPump为"Pump On"
      那么TM的DryPump在服务窗口显示为"On"
      当在TM服务窗口点击"Cancel"
      那么TM的DryPump显示为"On"

  Rule: 执行operation
    场景: TC执行OpenSlowVent
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseSlowVent"
      当"TC"执行"OpenSlowVent"
      那么TM阀门"TC Slow Vent"显示为"Open"

    场景: TC执行CloseSlowVent
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenSlowVent"
      当"TC"执行"CloseSlowVent"
      那么TM阀门"TC Slow Vent"显示为"Close"

    场景: TC执行OpenFastVent
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseFastVent"
      当"TC"执行"OpenFastVent"
      那么TM阀门"TC Fast Vent"显示为"Open"

    场景: TC执行CloseFastVent
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenFastVent"
      当"TC"执行"CloseFastVent"
      那么TM阀门"TC Fast Vent"显示为"Close"

    场景: TC执行OpenSlowRough
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseSlowRough"
      当"TC"执行"OpenSlowPump"
      那么TM阀门"TC Slow Rough"显示为"Open"

    场景: TC执行CloseSlowRough
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenSlowRough"
      当"TC"执行"CloseSlowPump"
      那么TM阀门"TC Slow Rough"显示为"Close"

    场景: TC执行OpenFastRough
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"CloseFastRough"
      当"TC"执行"OpenFastPump"
      那么TM阀门"TC Fast Rough"显示为"Open"

    场景: TC执行CloseFastRough
      假如TM的"TC"处于Maintain模式
      假如TM设备"MTRC"状态为"OpenFastRough"
      当"TC"执行"CloseFastPump"
      那么TM阀门"TC Fast Rough"显示为"Close"

    场景: LA执行OpenSlowVent
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseSlowVent"
      当"LA"执行"OpenSlowVent"
      那么TM阀门"LA Slow Vent"显示为"Open"

    场景: LA执行CloseSlowVent
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenSlowVent"
      当"LA"执行"CloseSlowVent"
      那么TM阀门"LA Slow Vent"显示为"Close"

    场景: LA执行OpenFastVent
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseFastVent"
      当"LA"执行"OpenFastVent"
      那么TM阀门"LA Fast Vent"显示为"Open"

    场景: LA执行CloseFastVent
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenFastVent"
      当"LA"执行"CloseFastVent"
      那么TM阀门"LA Fast Vent"显示为"Close"

    场景: LA执行OpenSlowRough
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseSlowRough"
      当"LA"执行"OpenSlowPump"
      那么TM阀门"LA Slow Rough"显示为"Open"

    场景: LA执行CloseSlowRough
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenSlowRough"
      当"LA"执行"CloseSlowPump"
      那么TM阀门"LA Slow Rough"显示为"Close"

    场景: LA执行OpenFastRough
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"CloseFastRough"
      当"LA"执行"OpenFastPump"
      那么TM阀门"LA Fast Rough"显示为"Open"

    场景: LA执行CloseFastRough
      假如TM的"LA"处于Maintain模式
      假如TM设备"MLAC"状态为"OpenFastRough"
      当"LA"执行"CloseFastPump"
      那么TM阀门"LA Fast Rough"显示为"Close"

    场景: LB执行OpenSlowVent
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseSlowVent"
      当"LB"执行"OpenSlowVent"
      那么TM阀门"LB Slow Vent"显示为"Open"

    场景: LB执行CloseSlowVent
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenSlowVent"
      当"LB"执行"CloseSlowVent"
      那么TM阀门"LB Slow Vent"显示为"Close"

    场景: LB执行OpenFastVent
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseFastVent"
      当"LB"执行"OpenFastVent"
      那么TM阀门"LB Fast Vent"显示为"Open"

    场景: LB执行CloseFastVent
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenFastVent"
      当"LB"执行"CloseFastVent"
      那么TM阀门"LB Fast Vent"显示为"Close"

    场景: LB执行OpenSlowRough
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseSlowRough"
      当"LB"执行"OpenSlowPump"
      那么TM阀门"LB Slow Rough"显示为"Open"

    场景: LB执行CloseSlowRough
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenSlowRough"
      当"LB"执行"CloseSlowPump"
      那么TM阀门"LB Slow Rough"显示为"Close"

    场景: LB执行OpenFastRough
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"CloseFastRough"
      当"LB"执行"OpenFastPump"
      那么TM阀门"LB Fast Rough"显示为"Open"

    场景: LB执行CloseFastRough
      假如TM的"LB"处于Maintain模式
      假如TM设备"MLBC"状态为"OpenFastRough"
      当"LB"执行"CloseFastPump"
      那么TM阀门"LB Fast Rough"显示为"Close"