# language: zh-CN
@skip
功能: 设备控制例子

  @ETCH-PM2-lower
  场景: Given下位机温度
    假如dnscan设备"/dev/SSTDN3PCU2_0000A"状态如下:
      | mac | channel    | data                                                             |
      | 8   | DEVIO_OUT1 | 000D000000000000000000000000000000000000000000000000000000000000 |
    那么IO状态为:
    """
    remoteData: {
      '/IO/Chiller/TempSensor'.value.value: 1.3
    }
    """

  @ETCH-PM2-lower
  场景: Verify下位机设置温度
    当设置IO"/IO/Chiller/TempSP"状态为"50"
    那么dnscan设备"/dev/SSTDN3PCU2_0000A"状态应为:
      | mac | channel   | data                                                             |
      | 8   | DEVIO_IN1 | 3A303131373030303030303030303030423030303130323031463445350D0A00 |

  场景: Verify下位机设置温度 - 串口step
#    当设置IO"/IO/Chiller/TempSP"状态为"50"
    那么串口设备"/dev/tty"写入所有数据中应包含"world"
