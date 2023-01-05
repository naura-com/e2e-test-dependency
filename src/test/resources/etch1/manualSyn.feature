# language: zh-CN
@ETCH-PM2-lower
@etch1-ui
@reset-feature-ui
#@skip
功能: 晶圆同步界面

  场景: CTC状态单独修改
    当修改"LoadLock A"的第1个CTC为"WAFER_UNKNOWN"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_UNKNOWN"状态
    当修改"LoadLock A"的第1个CTC为"WAFER_ABSENT"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_ABSENT"状态
    当修改"LoadLock A"的第1个CTC为"WAFER_PRESENT"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_PRESENT"状态
    当修改"LoadLock A"的第1个CTC为"WAFER_XSLOTTED"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_XSLOTTED"状态
    当修改"LoadLock A"的第1个CTC为"WAFER_DOUBLED"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_DOUBLED"状态

  场景: 晶圆状态单独修改
    当修改"LoadLock A"的第1个晶圆为"unknown"状态
    那么"LoadLock A"的第1个晶圆状态变为"unknown"状态
    当修改"LoadLock A"的第1个晶圆为"unprocessed"状态
    那么"LoadLock A"的第1个晶圆状态变为"unprocessed"状态
    当修改"LoadLock A"的第1个晶圆为"processing"状态
    那么"LoadLock A"的第1个晶圆状态变为"processing"状态
    当修改"LoadLock A"的第1个晶圆为"processed"状态
    那么"LoadLock A"的第1个晶圆状态变为"processed"状态
    当修改"LoadLock A"的第1个晶圆为"doubled"状态
    那么"LoadLock A"的第1个晶圆状态变为"doubled"状态
    当修改"LoadLock A"的第1个晶圆为"done"状态
    那么"LoadLock A"的第1个晶圆状态变为"done"状态
    当修改"LoadLock A"的第1个晶圆为"xslotted"状态
    那么"LoadLock A"的第1个晶圆状态变为"xslotted"状态
    当修改"LoadLock A"的第1个晶圆为"none"状态
    那么"LoadLock A"的第1个晶圆状态变为"none"状态
    当修改"LoadLock A"的第1个晶圆为"bad"状态
    那么"LoadLock A"的第1个晶圆状态变为"bad"状态

  场景: 开启selectAll后修改CTC
    当修改"LoadLock A"的所有CTC为"WAFER_ABSENT"状态
    那么所有CTC全部是"WAFER_ABSENT"状态

  场景:开启selectAll后修改晶圆
    当修改"LoadLock A"的所有晶圆为"unknown"状态
    那么所有晶圆全部是"unknown"状态

  场景: 修改CTC状态，晶圆状态同时改变
    当修改"LoadLock A"的第1个CTC为"WAFER_UNKNOWN"状态
    那么"LoadLock A"的第1个晶圆状态变为"unknown"状态

  场景: 修改晶圆状态，CTC状态同时改变
    当修改"LoadLock A"的第1个晶圆为"unknown"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_UNKNOWN"状态

  场景: 与CTC同步
    假如"LoadLock A"的第1个CTC本来为"WAFER_UNKNOWN"状态
    当修改"LoadLock A"的第1个CTC为"WAFER_PRESENT"状态
    那么"LoadLock A"的第1个Tool状态变为"WAFER_UNKNOWN"状态
    当选择状态同步到CTC
    那么"LoadLock A"的第1个Tool状态变为"WAFER_PRESENT"状态

  场景: 与Tool同步
    假如"LoadLock A"的第1个CTC本来为"WAFER_UNKNOWN"状态
    当修改"LoadLock A"的第1个CTC为"WAFER_PRESENT"状态
    那么"LoadLock A"的第1个CTC状态变为"WAFER_PRESENT"状态
    当选择状态同步到Tool
    那么"LoadLock A"的第1个CTC状态变为"WAFER_UNKNOWN"状态
