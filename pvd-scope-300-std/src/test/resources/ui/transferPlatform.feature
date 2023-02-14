# language: zh-CN
@deactivate-allInterlock
@clean-alarm
@pvd-lower
@pvd-ui
功能:传输平台的测试
  Rule:阀门开
    场景: 打开Transfer的快充阀门
      假如设备"/Control/TransferExports/FastVentVlv"为"Close"状态
      当打开"Transfer"的"快充"阀门
      那么"Transfer"的"快充"阀门被打开

    场景: 打开Transfer的快抽阀门
      假如设备"/Control/TransferExports/FastRoughVlv"为"Close"状态
      当打开"Transfer"的"快抽"阀门
      那么"Transfer"的"快抽"阀门被打开

    场景: 打开Transfer的门阀阀门
      假如设备"/Control/TransferExports/GateValve"为"Close"状态
      当打开"Transfer"的"门阀"阀门
      那么"Transfer"的"门阀"阀门被打开

    场景: 打开ChA的快充阀门
      假如设备"/Control/ChAExports/FastVentVlv"为"Close"状态
      当打开"ChA"的"快充"阀门
      那么"ChA"的"快充"阀门被打开

    场景: 打开ChA的快抽阀门
      假如设备"/Control/ChAExports/FastRoughVlv"为"Close"状态
      当打开"ChA"的"快抽"阀门
      那么"ChA"的"快抽"阀门被打开

    场景: 打开ChA的Cooling Ar阀门
      假如设备"/Control/ChAExports/CoolingVlv"为"Close"状态
      当打开"ChA"的"Cooling Ar"阀门
      那么"ChA"的"Cooling Ar"阀门被打开

    场景: 打开ChB的快充阀门
      假如设备"/Control/ChBExports/FastVentVlv"为"Close"状态
      当打开"ChB"的"快充"阀门
      那么"ChB"的"快充"阀门被打开

    场景: 打开ChB的快抽阀门
      假如设备"/Control/ChBExports/FastRoughVlv"为"Close"状态
      当打开"ChB"的"快抽"阀门
      那么"ChB"的"快抽"阀门被打开

    场景: 打开ChB的Cooling Ar阀门
      假如设备"/Control/ChBExports/CoolingVlv"为"Close"状态
      当打开"ChB"的"Cooling Ar"阀门
      那么"ChB"的"Cooling Ar"阀门被打开

    场景: 打开Buffer的快充阀门
      假如设备"/Control/BufferExports/FastVentVlv"为"Close"状态
      当打开"Buffer"的"快充"阀门
      那么"Buffer"的"快充"阀门被打开

    场景: 打开Buffer的快抽阀门
      假如设备"/Control/BufferExports/FastRoughVlv"为"Close"状态
      当打开"Buffer"的"快抽"阀门
      那么"Buffer"的"快抽"阀门被打开

    场景: 打开Buffer的门阀阀门
      假如设备"/Control/BufferExports/GateValve"为"Close"状态
      当打开"Buffer"的"门阀"阀门
      那么"Buffer"的"门阀"阀门被打开

    场景: 打开LA的慢充阀门
      假如设备"/Control/LAExports/SlowVentVlv"为"Close"状态
      当打开"LA"的"慢充"阀门
      那么"LA"的"慢充"阀门被打开

    场景: 打开LA的快充阀门
      假如设备"/Control/LAExports/FastVentVlv"为"Close"状态
      当打开"LA"的"快充"阀门
      那么"LA"的"快充"阀门被打开

    场景: 打开LA的慢抽阀门
      假如设备"/Control/LAExports/SlowRoughVlv"为"Close"状态
      当打开"LA"的"慢抽"阀门
      那么"LA"的"慢抽"阀门被打开

    场景: 打开LA的快抽阀门
      假如设备"/Control/LAExports/FastRoughVlv"为"Close"状态
      当打开"LA"的"快抽"阀门
      那么"LA"的"快抽"阀门被打开

    场景: 打开LB的慢充阀门
      假如设备"/Control/LBExports/SlowVentVlv"为"Close"状态
      当打开"LB"的"慢充"阀门
      那么"LB"的"慢充"阀门被打开

    场景: 打开LB的快充阀门
      假如设备"/Control/LBExports/FastVentVlv"为"Close"状态
      当打开"LB"的"快充"阀门
      那么"LB"的"快充"阀门被打开

    场景: 打开LB的慢抽阀门
      假如设备"/Control/LBExports/SlowRoughVlv"为"Close"状态
      当打开"LB"的"慢抽"阀门
      那么"LB"的"慢抽"阀门被打开

    场景: 打开LB的快抽阀门
      假如设备"/Control/LBExports/FastRoughVlv"为"Close"状态
      当打开"LB"的"快抽"阀门
      那么"LB"的"快抽"阀门被打开

  Rule: 阀门关
    场景: 关闭Transfer的快充阀门
      假如设备"/Control/TransferExports/FastVentVlv"为"Open"状态
      当关闭"Transfer"的"快充"阀门
      那么"Transfer"的"快充"阀门被关闭

    场景: 关闭Transfer的快抽阀门
      假如设备"/Control/TransferExports/FastRoughVlv"为"Open"状态
      当关闭"Transfer"的"快抽"阀门
      那么"Transfer"的"快抽"阀门被关闭

    场景: 关闭Transfer的门阀阀门
      假如设备"/Control/TransferExports/GateValve"为"Open"状态
      当关闭"Transfer"的"门阀"阀门
      那么"Transfer"的"门阀"阀门被关闭

    场景: 关闭ChA的快充阀门
      假如设备"/Control/ChAExports/FastVentVlv"为"Open"状态
      当关闭"ChA"的"快充"阀门
      那么"ChA"的"快充"阀门被关闭

    场景: 关闭ChA的快抽阀门
      假如设备"/Control/ChAExports/FastRoughVlv"为"Open"状态
      当关闭"ChA"的"快抽"阀门
      那么"ChA"的"快抽"阀门被关闭

    场景: 关闭ChA的Cooling Ar阀门
      假如设备"/Control/ChAExports/CoolingVlv"为"Open"状态
      当关闭"ChA"的"Cooling Ar"阀门
      那么"ChA"的"Cooling Ar"阀门被关闭

    场景: 关闭ChB的快充阀门
      假如设备"/Control/ChBExports/FastVentVlv"为"Open"状态
      当关闭"ChB"的"快充"阀门
      那么"ChB"的"快充"阀门被关闭

    场景: 关闭ChB的快抽阀门
      假如设备"/Control/ChBExports/FastRoughVlv"为"Open"状态
      当关闭"ChB"的"快抽"阀门
      那么"ChB"的"快抽"阀门被关闭

    场景: 关闭ChB的Cooling Ar阀门
      假如设备"/Control/ChBExports/CoolingVlv"为"Open"状态
      当关闭"ChB"的"Cooling Ar"阀门
      那么"ChB"的"Cooling Ar"阀门被关闭

    场景: 关闭Buffer的快充阀门
      假如设备"/Control/BufferExports/FastVentVlv"为"Open"状态
      当关闭"Buffer"的"快充"阀门
      那么"Buffer"的"快充"阀门被关闭

    场景: 关闭Buffer的快抽阀门
      假如设备"/Control/BufferExports/FastRoughVlv"为"Open"状态
      当关闭"Buffer"的"快抽"阀门
      那么"Buffer"的"快抽"阀门被关闭

    场景: 关闭Buffer的门阀阀门
      假如设备"/Control/BufferExports/GateValve"为"Open"状态
      当关闭"Buffer"的"门阀"阀门
      那么"Buffer"的"门阀"阀门被关闭

    场景: 关闭LA的慢充阀门
      假如设备"/Control/LAExports/SlowVentVlv"为"Open"状态
      当关闭"LA"的"慢充"阀门
      那么"LA"的"慢充"阀门被关闭

    场景: 关闭LA的快充阀门
      假如设备"/Control/LAExports/FastVentVlv"为"Open"状态
      当关闭"LA"的"快充"阀门
      那么"LA"的"快充"阀门被关闭

    场景: 关闭LA的慢抽阀门
      假如设备"/Control/LAExports/SlowRoughVlv"为"Open"状态
      当关闭"LA"的"慢抽"阀门
      那么"LA"的"慢抽"阀门被关闭

    场景: 关闭LA的快抽阀门
      假如设备"/Control/LAExports/FastRoughVlv"为"Open"状态
      当关闭"LA"的"快抽"阀门
      那么"LA"的"快抽"阀门被关闭

    场景: 关闭LB的慢充阀门
      假如设备"/Control/LBExports/SlowVentVlv"为"Open"状态
      当关闭"LB"的"慢充"阀门
      那么"LB"的"慢充"阀门被关闭

    场景: 关闭LB的快充阀门
      假如设备"/Control/LBExports/FastVentVlv"为"Open"状态
      当关闭"LB"的"快充"阀门
      那么"LB"的"快充"阀门被关闭

    场景: 关闭LB的慢抽阀门
      假如设备"/Control/LBExports/SlowRoughVlv"为"Open"状态
      当关闭"LB"的"慢抽"阀门
      那么"LB"的"慢抽"阀门被关闭

    场景: 关闭LA的快抽阀门
      假如设备"/Control/LBExports/FastRoughVlv"为"Open"状态
      当关闭"LB"的"快抽"阀门
      那么"LB"的"快抽"阀门被关闭

  Rule:隔离阀开
    场景: 打开LA的门阀
      假如设备"/Control/LAExports/Door"为"Close"状态
      当打开"LA"的"门阀"阀门
      那么"LA"的"门阀"阀门被打开

    场景: 打开LA的隔离阀
      假如设备"/Control/LAExports/SlotValve"为"Close"状态
      当打开"LA"的"隔离阀"阀门
      那么"LA"的"隔离阀"阀门被打开

    场景: 打开LB的门阀
      假如设备"/Control/LBExports/Door"为"Close"状态
      当打开"LB"的"门阀"阀门
      那么"LB"的"门阀"阀门被打开

    场景: 打开LB的隔离阀
      假如设备"/Control/LBExports/SlotValve"为"Close"状态
      当打开"LB"的"隔离阀"阀门
      那么"LB"的"隔离阀"阀门被打开

    场景: 打开ChC的隔离阀
      假如设备"/Control/ChCExports/SlotValve"为"Close"状态
      当打开"ChC"的"隔离阀"阀门
      那么"ChC"的"隔离阀"阀门被打开

    场景: 打开ChE的隔离阀
      假如设备"/Control/ChEExports/SlotValve"为"Close"状态
      当打开"ChE"的"隔离阀"阀门
      那么"ChE"的"隔离阀"阀门被打开

    场景: 打开ChA的门阀
      假如设备"/Control/ChAExports/ASlotValve"为"Close"状态
      当打开"ChA"的"门阀"阀门
      那么"ChA"的"门阀"阀门被打开

    场景: 打开ChA的隔离阀
      假如设备"/Control/ChAExports/BSlotValve"为"Close"状态
      当打开"ChA"的"隔离阀"阀门
      那么"ChA"的"隔离阀"阀门被打开

    场景: 打开ChB的门阀
      假如设备"/Control/ChBExports/ASlotValve"为"Close"状态
      当打开"ChB"的"门阀"阀门
      那么"ChB"的"门阀"阀门被打开

    场景: 打开ChB的隔离阀
      假如设备"/Control/ChBExports/BSlotValve"为"Close"状态
      当打开"ChB"的"隔离阀"阀门
      那么"ChB"的"隔离阀"阀门被打开

    场景: 打开Ch2的隔离阀
      假如设备"/Control/Ch2Exports/SlitValve"为"Close"状态
      当打开"Ch2"的"隔离阀"阀门
      那么"Ch2"的"隔离阀"阀门被打开

    场景: 打开Ch3的隔离阀
      假如设备"/Control/Ch3Exports/SlitValve"为"Close"状态
      当打开"Ch3"的"隔离阀"阀门
      那么"Ch3"的"隔离阀"阀门被打开

  Rule:隔离阀关
    场景: 关闭LA的门阀
      假如设备"/Control/LAExports/Door"为"Open"状态
      当关闭"LA"的"门阀"阀门
      那么"LA"的"门阀"阀门被关闭

    场景: 关闭LA的隔离阀
      假如设备"/Control/LAExports/SlotValve"为"Open"状态
      当关闭"LA"的"隔离阀"阀门
      那么"LA"的"隔离阀"阀门被关闭

    场景: 关闭LB的门阀
      假如设备"/Control/LBExports/Door"为"Open"状态
      当关闭"LB"的"门阀"阀门
      那么"LB"的"门阀"阀门被关闭

    场景: 关闭LB的隔离阀
      假如设备"/Control/LBExports/SlotValve"为"Open"状态
      当关闭"LB"的"隔离阀"阀门
      那么"LB"的"隔离阀"阀门被关闭

    场景: 关闭ChC的隔离阀
      假如设备"/Control/ChCExports/SlotValve"为"Open"状态
      当关闭"ChC"的"隔离阀"阀门
      那么"ChC"的"隔离阀"阀门被关闭

    场景: 关闭ChE的隔离阀
      假如设备"/Control/ChEExports/SlotValve"为"Open"状态
      当关闭"ChE"的"隔离阀"阀门
      那么"ChE"的"隔离阀"阀门被关闭

    场景: 关闭ChA的门阀
      假如设备"/Control/ChAExports/ASlotValve"为"Open"状态
      当关闭"ChA"的"门阀"阀门
      那么"ChA"的"门阀"阀门被关闭

    场景: 关闭ChA的隔离阀
      假如设备"/Control/ChAExports/BSlotValve"为"Open"状态
      当关闭"ChA"的"隔离阀"阀门
      那么"ChA"的"隔离阀"阀门被关闭

    场景: 关闭ChB的门阀
      假如设备"/Control/ChBExports/ASlotValve"为"Open"状态
      当关闭"ChB"的"门阀"阀门
      那么"ChB"的"门阀"阀门被关闭

    场景: 关闭ChB的隔离阀
      假如设备"/Control/ChBExports/BSlotValve"为"Open"状态
      当关闭"ChB"的"隔离阀"阀门
      那么"ChB"的"隔离阀"阀门被关闭

    场景: 关闭Ch2的隔离阀
      假如设备"/Control/Ch2Exports/SlitValve"为"Open"状态
      当关闭"Ch2"的"隔离阀"阀门
      那么"Ch2"的"隔离阀"阀门被关闭

    场景: 关闭Ch3的隔离阀
      假如设备"/Control/Ch3Exports/SlitValve"为"Open"状态
      当关闭"Ch3"的"隔离阀"阀门
      那么"Ch3"的"隔离阀"阀门被关闭

  Rule:常规维护操作
    场景:充大气
      当选择"LA"腔室并且执行"充大气"操作并确认时
      那么"LA当前压力"应为"760.000"

    场景:抽真空
      当选择"LB"腔室并且执行"抽真空"操作并确认时
      那么"LB当前压力"应为"1.000E-8"

    场景:循环吹扫服务开启成功
      假如选择"ChA"腔室并且执行"充大气"操作并确认时
      当选择"ChA"腔室并且执行"循环吹扫"操作时
      并且设定为"1"且确认时
      那么"ChA当前压力"应为"1.000E-8"

    场景:开启压升率服务成功
      假如选择"ChB"腔室并且执行"充大气"操作并确认时
      当选择"ChB"腔室并且执行"压升率"操作并确认时
      那么"ChB当前压力"应为"1.000E-8"

  Rule:ChA/ChB基座位置设定
    场景:基座位置设定
      当选择"ChA"腔室并且执行"工艺位置位"操作并确认时
      那么"基座当前位置"应为"ProcessPos1"
      当选择"ChA"腔室并且执行"传片位置位"操作并确认时
      那么"基座当前位置"应为"TransferLiftPos"

  Rule:Transfer/Buffer相关维护功能
    场景:温度设定
      假如选择"Transfer"腔室并且执行"温度控制"操作时
      当设定为"10"且确认时
      那么"Transfer当前温度"应为"10.000"
      并且"Heater设定温度"应为"10.00"
      并且"Heater当前温度"应为"10.00"

    场景:烘烤功能
      假如选择"Buffer"腔室并且执行"烘烤"操作时
      当设定"时间(H)"为"0.001","温度(°C)"为"20"
      那么"Buffer当前温度"应为"45.000"
      并且"总时"应为"00:00:03"
      并且"耗时"应为"00:00:03"

  Rule:System热交换器
    场景:打开热交换器
      当选择"System"腔室并且执行"开关"操作时
      并且设定为"打开"并且确认
      那么"开关状态"应为"Open"

    场景:关闭热交换器
      当选择"System"腔室并且执行"开关"操作时
      并且设定为"关闭"并且确认
      那么"开关状态"应为"Close"
