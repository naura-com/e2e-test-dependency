# language: zh-CN
@skip
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
