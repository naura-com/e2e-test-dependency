# language: zh-CN
@etch1ref-lower
@etch1-ui
@reset-feature-ui
#@skip

功能: TMVacuum

  Rule: 设置阀门

    场景大纲:设置TM阀门状态:<title>
      假如TM的"<module>"处于Maintain模式
      假如TM设备"<moduleName>"状态为"<initStatus>"
      当设置TM阀门"<name>"为"<setStatus>"
      那么TM阀门"<name>"在服务窗口和界面显示为"<setStatus>"
      例子:
        | title                   | module | moduleName | initStatus     | name          | setStatus |
        | set TC Slow Vent open   | TC     | MTRC       | CloseSlowVent  | TC Slow Vent  | Open      |
        | set TC Slow Vent Close  | TC     | MTRC       | OpenSlowVent   | TC Slow Vent  | Close     |
        | set TC Fast Vent open   | TC     | MTRC       | CloseFastVent  | TC Fast Vent  | Open      |
        | set TC Fast Vent Close  | TC     | MTRC       | OpenFastVent   | TC Fast Vent  | Close     |
        | set TC Slow Rough open  | TC     | MTRC       | CloseSlowRough | TC Slow Rough | Open      |
        | set TC Slow Rough Close | TC     | MTRC       | OpenSlowRough  | TC Slow Rough | Close     |
        | set TC Fast Rough open  | TC     | MTRC       | CloseFastRough | TC Fast Rough | Open      |
        | set TC Fast Rough Close | TC     | MTRC       | OpenFastRough  | TC Fast Rough | Close     |
        | set LA Slow Vent open   | LA     | MLAC       | CloseSlowVent  | LA Slow Vent  | Open      |
        | set LA Slow Vent Close  | LA     | MLAC       | OpenSlowVent   | LA Slow Vent  | Close     |
        | set LA Fast Vent open   | LA     | MLAC       | CloseFastVent  | LA Fast Vent  | Open      |
        | set LA Fast Vent Close  | LA     | MLAC       | OpenFastVent   | LA Fast Vent  | Close     |
        | set LA Slow Rough open  | LA     | MLAC       | CloseSlowRough | LA Slow Rough | Open      |
        | set LA Slow Rough Close | LA     | MLAC       | OpenSlowRough  | LA Slow Rough | Close     |
        | set LA Fast Rough open  | LA     | MLAC       | CloseFastRough | LA Fast Rough | Open      |
        | set LA Fast Rough Close | LA     | MLAC       | OpenFastRough  | LA Fast Rough | Close     |
        | set LB Slow Vent open   | LB     | MLBC       | CloseSlowVent  | LB Slow Vent  | Open      |
        | set LB Slow Vent Close  | LB     | MLBC       | OpenSlowVent   | LB Slow Vent  | Close     |
        | set LB Fast Vent open   | LB     | MLBC       | CloseFastVent  | LB Fast Vent  | Open      |
        | set LB Fast Vent Close  | LB     | MLBC       | OpenFastVent   | LB Fast Vent  | Close     |
        | set LB Slow Rough open  | LB     | MLBC       | CloseSlowRough | LB Slow Rough | Open      |
        | set LB Slow Rough Close | LB     | MLBC       | OpenSlowRough  | LB Slow Rough | Close     |
        | set LB Fast Rough open  | LB     | MLBC       | CloseFastRough | LB Fast Rough | Open      |
        | set LB Fast Rough Close | LB     | MLBC       | OpenFastRough  | LB Fast Rough | Close     |

  Rule: Pump

    场景大纲:设置DryPump状态:<title>
      假如TM处于Maintain模式
      假如TM设备"MTRC"状态为"<initStatus>"
      当设置TM的DryPump为"<title>"
      那么TM的DryPump在服务窗口和界面显示为"<setStatus>"
      例子:
        | title    | initStatus  | setStatus |
        | Pump Off | TurnPumpOn  | Off       |
        | Pump On  | TurnPumpOff | On        |

  Rule: 阀门执行服务

    场景大纲:TM阀门执行服务:<title>
      假如TM的"<module>"处于Maintain模式
      假如TM设备"<moduleName>"状态为"<initStatus>"
      当"<module>"执行"<operation>"
      那么TM阀门"<name>"显示为"<setStatus>"
      例子:
        | title                     | module | moduleName | initStatus     | name          | operation     | setStatus |
        | TC execute OpenSlowVent   | TC     | MTRC       | CloseSlowVent  | TC Slow Vent  | OpenSlowVent  | Open      |
        | TC execute CloseSlowVent  | TC     | MTRC       | OpenSlowVent   | TC Slow Vent  | CloseSlowVent | Close     |
        | TC execute OpenFastVent   | TC     | MTRC       | CloseFastVent  | TC Fast Vent  | OpenFastVent  | Open      |
        | TC execute CloseFastVent  | TC     | MTRC       | OpenFastVent   | TC Fast Vent  | CloseFastVent | Close     |
        | TC execute OpenSlowRough  | TC     | MTRC       | CloseSlowRough | TC Slow Rough | OpenSlowPump  | Open      |
        | TC execute CloseSlowRough | TC     | MTRC       | OpenSlowRough  | TC Slow Rough | CloseSlowPump | Close     |
        | TC execute OpenFastRough  | TC     | MTRC       | CloseFastRough | TC Fast Rough | OpenFastPump  | Open      |
        | TC execute CloseFastRough | TC     | MTRC       | OpenFastRough  | TC Fast Rough | CloseFastPump | Close     |
        | LA execute OpenSlowVent   | LA     | MLAC       | CloseSlowVent  | LA Slow Vent  | OpenSlowVent  | Open      |
        | LA execute CloseSlowVent  | LA     | MLAC       | OpenSlowVent   | LA Slow Vent  | CloseSlowVent | Close     |
        | LA execute OpenFastVent   | LA     | MLAC       | CloseFastVent  | LA Fast Vent  | OpenFastVent  | Open      |
        | LA execute CloseFastVent  | LA     | MLAC       | OpenFastVent   | LA Fast Vent  | CloseFastVent | Close     |
        | LA execute OpenSlowRough  | LA     | MLAC       | CloseSlowRough | LA Slow Rough | OpenSlowPump  | Open      |
        | LA execute CloseSlowRough | LA     | MLAC       | OpenSlowRough  | LA Slow Rough | CloseSlowPump | Close     |
        | LA execute OpenFastRough  | LA     | MLAC       | CloseFastRough | LA Fast Rough | OpenFastPump  | Open      |
        | LA execute CloseFastRough | LA     | MLAC       | OpenFastRough  | LA Fast Rough | CloseFastPump | Close     |
        | LB execute OpenSlowVent   | LB     | MLBC       | CloseSlowVent  | LB Slow Vent  | OpenSlowVent  | Open      |
        | LB execute CloseSlowVent  | LB     | MLBC       | OpenSlowVent   | LB Slow Vent  | CloseSlowVent | Close     |
        | LB execute OpenFastVent   | LB     | MLBC       | CloseFastVent  | LB Fast Vent  | OpenFastVent  | Open      |
        | LB execute CloseFastVent  | LB     | MLBC       | OpenFastVent   | LB Fast Vent  | CloseFastVent | Close     |
        | LB execute OpenSlowRough  | LB     | MLBC       | CloseSlowRough | LB Slow Rough | OpenSlowPump  | Open      |
        | LB execute CloseSlowRough | LB     | MLBC       | OpenSlowRough  | LB Slow Rough | CloseSlowPump | Close     |
        | LB execute OpenFastRough  | LB     | MLBC       | CloseFastRough | LB Fast Rough | OpenFastPump  | Open      |
        | LB execute CloseFastRough | LB     | MLBC       | OpenFastRough  | LB Fast Rough | CloseFastPump | Close     |
