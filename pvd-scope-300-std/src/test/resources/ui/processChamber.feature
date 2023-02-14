# language: zh-CN
@deactivate-allInterlock
@clean-alarm
@pvd-lower
@pvd-ui
功能:工艺腔室的测试
  Rule:阀门开
    场景大纲: 打开<valve>阀门
      假如设备"<channel>"为"<status>"状态
      当打开工艺腔室"<valve>"阀门
      那么工艺腔室"<valve>"阀门被打开
      例子:
        | valve    | channel                          | status |
        | G0501    | /Control/Ch2Exports/G0501        | Close  |
        | G0601    | /Control/Ch2Exports/G0601        | Close  |
        | G0701    | /Control/Ch2Exports/G0701        | Close  |
        | G0801    | /Control/Ch2Exports/G0801        | Close  |
        | G0602    | /Control/Ch2Exports/G0602        | Close  |
        | G0503    | /Control/Ch2Exports/G0503        | Close  |
        | G0603    | /Control/Ch2Exports/G0603        | Close  |
        | G0703    | /Control/Ch2Exports/G0703        | Close  |
        | G0803    | /Control/Ch2Exports/G0803        | Close  |
        | G0504    | /Control/Ch2Exports/G0504        | Close  |
        | G0604    | /Control/Ch2Exports/G0604        | Close  |
        | G0704    | /Control/Ch2Exports/G0704        | Close  |
        | G0804    | /Control/Ch2Exports/G0804        | Close  |
        | C1       | /Control/Ch2Exports/C01          | Close  |
        | C2       | /Control/Ch2Exports/C02          | Close  |
        | C3       | /Control/Ch2Exports/C03          | Close  |
        | C4       | /Control/Ch2Exports/C04          | Close  |
        | C7       | /Control/Ch2Exports/C07          | Close  |
        | C9       | /Control/Ch2Exports/C09          | Close  |
        | C10      | /Control/Ch2Exports/C10          | Close  |
        | C11      | /Control/Ch2Exports/C11          | Close  |
        | C12      | /Control/Ch2Exports/C12          | Close  |
        | C15      | /Control/Ch2Exports/C15          | Close  |
        | P1       | /Control/Ch2Exports/P01          | Close  |
        | P2       | /Control/Ch2Exports/P02          | Close  |
        | P3       | /Control/Ch2Exports/P03          | Close  |
        | P4       | /Control/Ch2Exports/P04          | Close  |
        | P24      | /Control/Ch2Exports/P24          | Close  |
        | Heater水阀 | /Control/Ch2Exports/C06          | Close  |
        | 腔室水阀     | /Control/Ch2Exports/C05          | Close  |
        | TV       | /Control/Ch2Exports/ButterflyVlv | Close  |
        | 隔离阀      | /Control/Ch2Exports/SlitValve    | Close  |
        | 门阀       | /Control/Ch2Exports/TpGateValve  | Close  |

    场景大纲: 打开<valve>阀门(双阀门)
      假如设备"<channel>"为"<status>"状态
      当打开工艺腔室"<valve>"阀门
      那么工艺腔室"<valve1>"阀门被打开
      并且工艺腔室"<valve2>"阀门被打开
      例子:
        | valve | channel                 | valve1 | valve2 | status |
        | P21_1 | /Control/Ch2Exports/P21 | P21_1  | P21_2  | Close  |
        | P22_1 | /Control/Ch2Exports/P22 | P22_1  | P22_2  | Close  |
        | P23_1 | /Control/Ch2Exports/P23 | P23_1  | P23_2  | Close  |
        | P21_2 | /Control/Ch2Exports/P21 | P21_1  | P21_2  | Close  |
        | P22_2 | /Control/Ch2Exports/P22 | P22_1  | P22_2  | Close  |
        | P23_2 | /Control/Ch2Exports/P23 | P23_1  | P23_2  | Close  |

  Rule:阀门关
    场景大纲: 关闭<valve>阀门
      假如设备"<channel>"为"<status>"状态
      当关闭工艺腔室"<valve>"阀门
      那么工艺腔室"<valve>"阀门被关闭
      例子:
        | valve    | channel                          | status |
        | G0501    | /Control/Ch2Exports/G0501        | Open   |
        | G0601    | /Control/Ch2Exports/G0601        | Open   |
        | G0701    | /Control/Ch2Exports/G0701        | Open   |
        | G0801    | /Control/Ch2Exports/G0801        | Open   |
        | G0602    | /Control/Ch2Exports/G0602        | Open   |
        | G0503    | /Control/Ch2Exports/G0503        | Open   |
        | G0603    | /Control/Ch2Exports/G0603        | Open   |
        | G0703    | /Control/Ch2Exports/G0703        | Open   |
        | G0803    | /Control/Ch2Exports/G0803        | Open   |
        | G0504    | /Control/Ch2Exports/G0504        | Open   |
        | G0604    | /Control/Ch2Exports/G0604        | Open   |
        | G0704    | /Control/Ch2Exports/G0704        | Open   |
        | G0804    | /Control/Ch2Exports/G0804        | Open   |
        | C1       | /Control/Ch2Exports/C01          | Open   |
        | C2       | /Control/Ch2Exports/C02          | Open   |
        | C3       | /Control/Ch2Exports/C03          | Open   |
        | C4       | /Control/Ch2Exports/C04          | Open   |
        | C7       | /Control/Ch2Exports/C07          | Open   |
        | C9       | /Control/Ch2Exports/C09          | Open   |
        | C10      | /Control/Ch2Exports/C10          | Open   |
        | C11      | /Control/Ch2Exports/C11          | Open   |
        | C12      | /Control/Ch2Exports/C12          | Open   |
        | C15      | /Control/Ch2Exports/C15          | Open   |
        | P1       | /Control/Ch2Exports/P01          | Open   |
        | P2       | /Control/Ch2Exports/P02          | Open   |
        | P3       | /Control/Ch2Exports/P03          | Open   |
        | P4       | /Control/Ch2Exports/P04          | Open   |
        | P24      | /Control/Ch2Exports/P24          | Open   |
        | Heater水阀 | /Control/Ch2Exports/C06          | Open   |
        | 腔室水阀     | /Control/Ch2Exports/C05          | Open   |
        | TV       | /Control/Ch2Exports/ButterflyVlv | Open   |
        | 隔离阀      | /Control/Ch2Exports/SlitValve    | Open   |
        | 门阀       | /Control/Ch2Exports/TpGateValve  | Open   |

    场景大纲: 关闭<valve>阀门(双阀门)
      假如设备"<channel>"为"<status>"状态
      当关闭工艺腔室"<valve>"阀门
      那么工艺腔室"<valve1>"阀门被关闭
      并且工艺腔室"<valve2>"阀门被关闭
      例子:
        | valve | channel                 | valve1 | valve2 | status |
        | P21_1 | /Control/Ch2Exports/P21 | P21_1  | P21_2  | Open   |
        | P22_1 | /Control/Ch2Exports/P22 | P22_1  | P22_2  | Open   |
        | P23_1 | /Control/Ch2Exports/P23 | P23_1  | P23_2  | Open   |
        | P21_2 | /Control/Ch2Exports/P21 | P21_1  | P21_2  | Open   |
        | P22_2 | /Control/Ch2Exports/P22 | P22_1  | P22_2  | Open   |
        | P23_2 | /Control/Ch2Exports/P23 | P23_1  | P23_2  | Open   |

  Rule:流量计设置
    场景: MFC5FlowToChamber流量控制
      假如设备"/Control/Ch2Exports/G0501"为"Close"状态
      并且设备"/Control/Ch2Exports/G0503"为"Close"状态
      并且设备"/Control/Ch2Exports/G0504"为"Close"状态
      并且设备"/Control/Ch2Exports/C09"为"Close"状态
      当设置MFC"MFC5(2000)"的"FlowToChamber"的流量为"111"
      那么工艺腔室"G0501"阀门被打开
      并且工艺腔室"G0503"阀门被打开
      并且工艺腔室"G0504"阀门被打开
      并且工艺腔室"C9"阀门被打开
      并且MFC"MFC5(2000)"流量为"111.0"

    场景: MFC5FlowToDivert流量控制
      假如设备"/Control/Ch2Exports/G0501"为"Close"状态
      并且设备"/Control/Ch2Exports/G0503"为"Close"状态
      并且设备"/Control/Ch2Exports/G0504"为"Close"状态
      并且设备"/Control/Ch2Exports/C10"为"Close"状态
      当设置MFC"MFC5(2000)"的"FlowToDivert"的流量为"222"
      那么工艺腔室"G0501"阀门被打开
      并且工艺腔室"G0503"阀门被打开
      并且工艺腔室"G0504"阀门被打开
      并且工艺腔室"C10"阀门被打开
      并且MFC"MFC5(2000)"流量为"222.0"

    场景: MFC5PurgeToChamber流量控制
      假如设备"/Control/Ch2Exports/G0601"为"Close"状态
      假如设备"/Control/Ch2Exports/G0602"为"Close"状态
      并且设备"/Control/Ch2Exports/G0503"为"Close"状态
      并且设备"/Control/Ch2Exports/G0504"为"Close"状态
      并且设备"/Control/Ch2Exports/C09"为"Close"状态
      当设置MFC"MFC5(2000)"的"PurgeToChamber"的流量为"333"
      那么工艺腔室"G0601"阀门被打开
      那么工艺腔室"G0602"阀门被打开
      并且工艺腔室"G0503"阀门被打开
      并且工艺腔室"G0504"阀门被打开
      并且工艺腔室"C9"阀门被打开
      并且MFC"MFC5(2000)"流量为"333.0"

    场景: MFC5PurgeToDivert流量控制
      假如设备"/Control/Ch2Exports/G0601"为"Close"状态
      假如设备"/Control/Ch2Exports/G0602"为"Close"状态
      并且设备"/Control/Ch2Exports/G0503"为"Close"状态
      并且设备"/Control/Ch2Exports/G0504"为"Close"状态
      并且设备"/Control/Ch2Exports/C10"为"Close"状态
      当设置MFC"MFC5(2000)"的"PurgeToDivert"的流量为"444"
      那么工艺腔室"G0601"阀门被打开
      那么工艺腔室"G0602"阀门被打开
      并且工艺腔室"G0503"阀门被打开
      并且工艺腔室"G0504"阀门被打开
      并且工艺腔室"C10"阀门被打开
      并且MFC"MFC5(2000)"流量为"444.0"

    场景: MFC6FlowToChamber流量控制
      假如设备"/Control/Ch2Exports/G0601"为"Close"状态
      并且设备"/Control/Ch2Exports/G0603"为"Close"状态
      并且设备"/Control/Ch2Exports/G0604"为"Close"状态
      并且设备"/Control/Ch2Exports/C09"为"Close"状态
      当设置MFC"MFC6(5000)"的"FlowToChamber"的流量为"111"
      那么工艺腔室"G0601"阀门被打开
      并且工艺腔室"G0603"阀门被打开
      并且工艺腔室"G0604"阀门被打开
      并且工艺腔室"C9"阀门被打开
      并且MFC"MFC6(5000)"流量为"111.0"

    场景: MFC6FlowToDivert流量控制
      假如设备"/Control/Ch2Exports/G0601"为"Close"状态
      并且设备"/Control/Ch2Exports/G0603"为"Close"状态
      并且设备"/Control/Ch2Exports/G0604"为"Close"状态
      并且设备"/Control/Ch2Exports/C10"为"Close"状态
      当设置MFC"MFC6(5000)"的"FlowToDivert"的流量为"222"
      那么工艺腔室"G0601"阀门被打开
      并且工艺腔室"G0603"阀门被打开
      并且工艺腔室"G0604"阀门被打开
      并且工艺腔室"C10"阀门被打开
      并且MFC"MFC6(5000)"流量为"222.0"

    场景: MFC7FlowToChamber流量控制
      假如设备"/Control/Ch2Exports/G0701"为"Close"状态
      并且设备"/Control/Ch2Exports/G0703"为"Close"状态
      并且设备"/Control/Ch2Exports/G0704"为"Close"状态
      并且设备"/Control/Ch2Exports/C11"为"Close"状态
      当设置MFC"MFC7(6000)"的"FlowToChamber"的流量为"111"
      那么工艺腔室"G0701"阀门被打开
      并且工艺腔室"G0703"阀门被打开
      并且工艺腔室"G0704"阀门被打开
      并且工艺腔室"C11"阀门被打开
      并且MFC"MFC7(6000)"流量为"111.0"

    场景: MFC7FlowToDivert流量控制
      假如设备"/Control/Ch2Exports/G0701"为"Close"状态
      并且设备"/Control/Ch2Exports/G0703"为"Close"状态
      并且设备"/Control/Ch2Exports/G0704"为"Close"状态
      并且设备"/Control/Ch2Exports/C12"为"Close"状态
      当设置MFC"MFC7(6000)"的"FlowToDivert"的流量为"222"
      那么工艺腔室"G0701"阀门被打开
      并且工艺腔室"G0703"阀门被打开
      并且工艺腔室"G0704"阀门被打开
      并且工艺腔室"C12"阀门被打开
      并且MFC"MFC7(6000)"流量为"222.0"

    场景: MFC7PurgeToChamber流量控制
      假如设备"/Control/Ch2Exports/G0801"为"Close"状态
      假如设备"/Control/Ch2Exports/G0703"为"Close"状态
      并且设备"/Control/Ch2Exports/G0704"为"Close"状态
      并且设备"/Control/Ch2Exports/C11"为"Close"状态
      当设置MFC"MFC7(6000)"的"PurgeToChamber"的流量为"333"
      那么工艺腔室"G0801"阀门被打开
      并且工艺腔室"G0703"阀门被打开
      并且工艺腔室"G0704"阀门被打开
      并且工艺腔室"C11"阀门被打开
      并且MFC"MFC7(6000)"流量为"333.0"

    场景: MFC7PurgeToDivert流量控制
      假如设备"/Control/Ch2Exports/G0801"为"Close"状态
      并且设备"/Control/Ch2Exports/G0703"为"Close"状态
      并且设备"/Control/Ch2Exports/G0704"为"Close"状态
      并且设备"/Control/Ch2Exports/C12"为"Close"状态
      当设置MFC"MFC7(6000)"的"PurgeToDivert"的流量为"444"
      那么工艺腔室"G0801"阀门被打开
      那么工艺腔室"G0703"阀门被打开
      并且工艺腔室"G0704"阀门被打开
      并且工艺腔室"C12"阀门被打开
      并且MFC"MFC7(6000)"流量为"444.0"

    场景: MFC8FlowToChamber流量控制
      假如设备"/Control/Ch2Exports/G0701"为"Close"状态
      并且设备"/Control/Ch2Exports/G0803"为"Close"状态
      并且设备"/Control/Ch2Exports/G0804"为"Close"状态
      当设置MFC"MFC8(2000)"的"FlowToChamber"的流量为"111"
      那么工艺腔室"G0701"阀门被打开
      并且工艺腔室"G0803"阀门被打开
      并且工艺腔室"G0804"阀门被打开
      并且MFC"MFC8(2000)"流量为"111.0"

    场景: MFC8PurgeToChamber流量控制
      假如设备"/Control/Ch2Exports/G0801"为"Close"状态
      并且设备"/Control/Ch2Exports/G0803"为"Close"状态
      并且设备"/Control/Ch2Exports/G0804"为"Close"状态
      当设置MFC"MFC8(2000)"的"PurgeToChamber"的流量为"222"
      那么工艺腔室"G0801"阀门被打开
      并且工艺腔室"G0803"阀门被打开
      并且工艺腔室"G0804"阀门被打开
      并且MFC"MFC8(2000)"流量为"222.0"

    场景: MFC23流量控制
      假如设备"/Control/Ch2Exports/P23"为"Close"状态
      当设置MFC"MFC23(5000)"的流量为"111"
      那么工艺腔室"P23_1"阀门被打开
      并且工艺腔室"P23_2"阀门被打开
      并且MFC"MFC23(5000)"流量为"111.0"

    场景: MFC21流量控制
      假如设备"/Control/Ch2Exports/P21"为"Close"状态
      当设置MFC"MFC21(3000)"的流量为"222"
      那么工艺腔室"P21_1"阀门被打开
      并且工艺腔室"P21_2"阀门被打开
      并且MFC"MFC21(3000)"流量为"222.0"

    场景: MFC22流量控制
      假如设备"/Control/Ch2Exports/P22"为"Close"状态
      当设置MFC"MFC22(3000)"的流量为"333"
      那么工艺腔室"P22_1"阀门被打开
      并且工艺腔室"P22_2"阀门被打开
      并且MFC"MFC22(3000)"流量为"333.0"

    场景:PC01的Stabilize流量控制
      假如设备"/Control/Ch2Exports/P03"为"Close"状态
      并且设备"/Control/Ch2Exports/P24"为"Close"状态
      当设置MFC"PC01(100)"的"Stabilize"的流量为"11"
      那么工艺腔室"P24"阀门被打开
      并且工艺腔室"P3"阀门被打开
      并且"PC01(100)"的AI流量为"11.00"
      并且"PC01(100)"的AO流量为"11.00"

    场景:PC01的BackSideFlow流量控制
      假如设备"/Control/Ch2Exports/P01"为"Close"状态
      假如设备"/Control/Ch2Exports/P03"为"Close"状态
      并且设备"/Control/Ch2Exports/P24"为"Close"状态
      当设置MFC"PC01(100)"的"BackSideFlow"的流量为"22"
      那么工艺腔室"P24"阀门被打开
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P3"阀门被打开
      并且"PC01(100)"的AI流量为"22.00"
      并且"PC01(100)"的AO流量为"22.00"

    场景:PC01的FullChuck流量控制
      假如设备"/Control/Ch2Exports/P01"为"Close"状态
      假如设备"/Control/Ch2Exports/P03"为"Close"状态
      当设置MFC"PC01(100)"为"FullChuck"
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P3"阀门被打开
      并且"PC01(100)"的AI流量为"0"
      并且"PC01(100)"的AO流量为"0"

    场景:PC01的Bypass流量控制
      假如设备"/Control/Ch2Exports/P01"为"Close"状态
      假如设备"/Control/Ch2Exports/P02"为"Close"状态
      当设置MFC"PC01(100)"为"Bypass"
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P2"阀门被打开
      并且"PC01(100)"的AI流量为"0"
      并且"PC01(100)"的AO流量为"0"

    场景:PC01的Off流量控制
      假如设备"/Control/Ch2Exports/P03"为"Open"状态
      当设置MFC"PC01(100)"为"Off"
      并且工艺腔室"P3"阀门被关闭
      并且"PC01(100)"的AI流量为"0"
      并且"PC01(100)"的AO流量为"0"

  Rule:常规维护操作
    场景:充大气
      当选择"Ch2"腔室并执行"充大气"操作并确认时
      那么"腔室当前压力"为"760.000"
      并且"蝶阀当前压力"为"760.00"

    场景:抽真空
      当选择"Ch2"腔室并执行"抽真空"操作并确认时
      那么"腔室当前压力"为"1.000E-8"
      并且"蝶阀当前压力"为"0.00"

    场景:物料设定数量成功
      假如选择"Ch2"腔室并执行"设置物料"操作时
      当设置为"1"并确认时
      那么设置成功,且"物料数量"为"1.0"

    场景:循环吹扫服务开启成功
      假如选择"Ch2"腔室并执行"充大气"操作并确认时
      当选择"Ch2"腔室并执行"循环吹扫"操作时
      并且设置为"1"并确认时
      那么"腔室当前压力"为"1.000E-8"
      并且"蝶阀当前压力"为"0.00"

    场景:基座位置设定
      假如设备"/Control/Ch2Exports/P24"为"Open"状态
      并且设备"/Control/Ch2Exports/P03"为"Open"状态
      并且设备"/Control/Ch2Exports/P04"为"Open"状态
      当选择"Ch2"腔室并执行"Home位置位"操作并确认时
      那么"基座当前位置"为"HomePos"
      当选择"Ch2"腔室并执行"工艺位置位"操作并确认时
      那么"基座当前位置"为"ProcessPos1"
      当选择"Ch2"腔室并执行"传片位置位"操作并确认时
      那么"基座当前位置"为"TransferLiftPos"
      并且工艺腔室"P24"阀门被关闭
      并且工艺腔室"P3"阀门被关闭
      并且工艺腔室"P4"阀门被关闭

    场景:开启压升率服务成功
      假如选择"Ch2"腔室并执行"充大气"操作并确认时
      当选择"Ch2"腔室并执行"压升率"操作并确认时
      那么"腔室当前压力"为"1.000E-8"
      并且"蝶阀当前压力"为"0.00"
      并且关闭"压升率"服务

    场景:基座测试设定成功
      假如设备"/Control/Ch2Exports/P24"为"Open"状态
      并且设备"/Control/Ch2Exports/P03"为"Open"状态
      并且设备"/Control/Ch2Exports/P04"为"Open"状态
      当选择"Ch2"腔室并执行"基座测试设定"操作时
      并且设置开始位置为"ReleasePosition",结束位置为"ProcessPosition1",测试次数为1,延迟为2s且确认
      那么"基座当前位置"为"ProcessPos1"
      并且工艺腔室"P24"阀门被关闭
      并且工艺腔室"P3"阀门被关闭
      并且工艺腔室"P4"阀门被关闭
      并且结束后"测试总数"为1

    场景:背吹与VacChuck设定(Stabilize压力设定小于50)
      假如设备"/Control/Ch2Exports/P24"为"Close"状态
      并且设备"/Control/Ch2Exports/P01"为"Open"状态
      并且设备"/Control/Ch2Exports/P02"为"Open"状态
      并且设备"/Control/Ch2Exports/P03"为"Close"状态
      并且设备"/Control/Ch2Exports/P04"为"Open"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定"Stabilize"的压力值为"49"并确认
      那么"背吹设定压力"为"49.0"
      并且"背吹当前压力"为"49.00"
      并且"背吹当前模式"变为"Stabilize"
      并且工艺腔室"P24"阀门被打开
      并且工艺腔室"P1"阀门被关闭
      并且工艺腔室"P2"阀门被关闭
      并且工艺腔室"P3"阀门被打开
      并且工艺腔室"P4"阀门被关闭
      并且"PC01(100)"的AI流量为"49.00"
      并且"PC01(100)"的AO流量为"49.00"

    场景:背吹与VacChuck设定(Stabilize压力设定大于等于50)
      假如设备"/Control/Ch2Exports/P24"为"Close"状态
      并且设备"/Control/Ch2Exports/P01"为"Open"状态
      并且设备"/Control/Ch2Exports/P02"为"Open"状态
      并且设备"/Control/Ch2Exports/P03"为"Open"状态
      并且设备"/Control/Ch2Exports/P04"为"Close"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定"Stabilize"的压力值为"50"并确认
      那么"背吹设定压力"为"50.0"
      并且"背吹当前压力"为"50.00"
      并且"背吹当前模式"变为"Stabilize"
      并且工艺腔室"P24"阀门被打开
      并且工艺腔室"P1"阀门被关闭
      并且工艺腔室"P2"阀门被关闭
      并且工艺腔室"P3"阀门被关闭
      并且工艺腔室"P4"阀门被打开
      并且"PC01(100)"的AI流量为"50.00"
      并且"PC01(100)"的AO流量为"50.00"

    场景:背吹与VacChuck设定(BackSideFlow压力设定小于50)
      假如设备"/Control/Ch2Exports/P24"为"Close"状态
      并且设备"/Control/Ch2Exports/P01"为"Close"状态
      并且设备"/Control/Ch2Exports/P02"为"Close"状态
      并且设备"/Control/Ch2Exports/P03"为"Close"状态
      并且设备"/Control/Ch2Exports/P04"为"Close"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定"BackSideFlow"的压力值为"49"并确认
      那么"背吹设定压力"为"49.0"
      并且"背吹当前压力"为"49.00"
      并且"背吹当前模式"变为"BacksideFlow"
      并且工艺腔室"P24"阀门被打开
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P2"阀门被关闭
      并且工艺腔室"P3"阀门被打开
      并且工艺腔室"P4"阀门被关闭
      并且"PC01(100)"的AI流量为"49.00"
      并且"PC01(100)"的AO流量为"49.00"

    场景:背吹与VacChuck设定(BackSideFlow压力设定大于等于50)
      假如设备"/Control/Ch2Exports/P24"为"Close"状态
      并且设备"/Control/Ch2Exports/P01"为"Close"状态
      并且设备"/Control/Ch2Exports/P02"为"Close"状态
      并且设备"/Control/Ch2Exports/P03"为"Close"状态
      并且设备"/Control/Ch2Exports/P04"为"Close"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定"BackSideFlow"的压力值为"50"并确认
      那么"背吹设定压力"为"50.0"
      并且"背吹当前压力"为"50.00"
      并且"背吹当前模式"变为"BacksideFlow"
      并且工艺腔室"P24"阀门被打开
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P2"阀门被关闭
      并且工艺腔室"P3"阀门被关闭
      并且工艺腔室"P4"阀门被打开
      并且"PC01(100)"的AI流量为"50.00"
      并且"PC01(100)"的AO流量为"50.00"

    场景:背吹与VacChuck设定(FullChuck)
      假如设备"/Control/Ch2Exports/P24"为"Open"状态
      并且设备"/Control/Ch2Exports/P01"为"Close"状态
      并且设备"/Control/Ch2Exports/P02"为"Open"状态
      并且设备"/Control/Ch2Exports/P03"为"Close"状态
      并且设备"/Control/Ch2Exports/P04"为"Open"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定为"FullChuck"并确认
      那么"背吹设定压力"为"0"
      并且"背吹当前压力"为"0"
      并且"背吹当前模式"变为"FullChuck"
      并且工艺腔室"P24"阀门被关闭
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P2"阀门被关闭
      并且工艺腔室"P3"阀门被打开
      并且工艺腔室"P4"阀门被关闭
      并且"PC01(100)"的AI流量为"0"
      并且"PC01(100)"的AO流量为"0"

    场景:背吹与VacChuck设定(Bypass)
      假如设备"/Control/Ch2Exports/P24"为"Open"状态
      并且设备"/Control/Ch2Exports/P01"为"Close"状态
      并且设备"/Control/Ch2Exports/P02"为"Close"状态
      并且设备"/Control/Ch2Exports/P03"为"Open"状态
      并且设备"/Control/Ch2Exports/P04"为"Open"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定为"Bypass"并确认
      那么"背吹设定压力"为"0"
      并且"背吹当前压力"为"0"
      并且"背吹当前模式"变为"Bypass"
      并且工艺腔室"P24"阀门被关闭
      并且工艺腔室"P1"阀门被打开
      并且工艺腔室"P2"阀门被打开
      并且工艺腔室"P3"阀门被关闭
      并且工艺腔室"P4"阀门被关闭
      并且"PC01(100)"的AI流量为"0"
      并且"PC01(100)"的AO流量为"0"

    场景:背吹与VacChuck设定(Off)
      假如设备"/Control/Ch2Exports/P24"为"Open"状态
      并且设备"/Control/Ch2Exports/P01"为"Open"状态
      并且设备"/Control/Ch2Exports/P02"为"Open"状态
      并且设备"/Control/Ch2Exports/P03"为"Open"状态
      并且设备"/Control/Ch2Exports/P04"为"Open"状态
      当选择"Ch2"腔室并执行"背吹压力设定"操作时
      并且设定为"Off"并确认
      那么"背吹设定压力"为"0"
      并且"背吹当前压力"为"0"
      并且"背吹当前模式"变为"Off"
      并且工艺腔室"P24"阀门被关闭
      并且工艺腔室"P1"阀门被关闭
      并且工艺腔室"P2"阀门被关闭
      并且工艺腔室"P3"阀门被关闭
      并且工艺腔室"P4"阀门被关闭
      并且"PC01(100)"的AI流量为"0"
      并且"PC01(100)"的AO流量为"0"

    场景:蝶阀压力设定成功
      假如设备"/Control/Ch2Exports/C01"为"Close"状态
      并且设备"/Control/Ch2Exports/C02"为"Open"状态
      当选择"Ch2"腔室并执行"蝶阀压力设定"操作时
      并且设置为"100"并确认时
      那么"蝶阀设定压力"为"100.00"
      并且"蝶阀当前压力"为"100.00"
      并且"腔室当前压力"为"100.000"
      并且"蝶阀当前模式"变为"Pressure"
      并且工艺腔室"C1"阀门被打开
      并且工艺腔室"C2"阀门被关闭

    场景:蝶阀位置设定成功
      假如设备"/Control/Ch2Exports/C01"为"Close"状态
      并且设备"/Control/Ch2Exports/C02"为"Open"状态
      当选择"Ch2"腔室并执行"蝶阀位置设定"操作时
      并且设置为"100"并确认时
      那么"蝶阀设定位置"为"100.00"
      并且"蝶阀当前位置"为"100.00"
      并且"蝶阀当前模式"变为"Position"
      并且工艺腔室"C1"阀门被打开
      并且工艺腔室"C2"阀门被关闭

  Rule:RF相关
    场景:设定功率成功
      假如选择"Ch2"腔室并进入"RF"界面时
      当执行"设定功率"操作后
      并且设置"功率值(W)"为"1000","加载速度(W/s)"为"100"
      那么"设定功率"为"1000.00"
      并且"前向功率"为"1000.00"

    场景:预设Match成功
      当选择"Ch2"腔室并进入"RF"界面时
      并且执行"设定Match"操作后
      并且执行"预设C1/C2"操作后
      并且"预设"C1为"10","预设"C2为"20"
      那么"C1Match"为"10.00"
      并且"C2Match"为"20.00"

    场景:手动设置Match
      当选择"Ch2"腔室并进入"RF"界面时
      并且执行"设定Match"操作后
      并且执行"手调C1/C2"操作后
      并且"手调"C1为"200","手调"C2为"400"
      那么"C1Match"为"200.00"
      并且"C2Match"为"400.00"

    场景:关闭电源
      假如选择"Ch2"腔室并进入"RF"界面时
      当设定为"关闭电源"并确认
      那么"设定功率"为"0"
      并且"前向功率"为"0"




