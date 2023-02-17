package com.naura.test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.那么;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import static com.github.leeonky.dal.Assertions.expect;

public class DeviceSteps {

    @Value("${lower.etch1.pm2.host}")
    private String lowerIp;

    @假如("dnscan设备{string}状态如下:")
    public void dnscan设备状态如下(String devName, DataTable table) {
        table.asMaps().forEach(command -> dnscanWrite(devName, command));
    }

    @那么("dnscan设备{string}状态应为:")
    public void dnscan设备状态应为(String devName, DataTable table) {
        table.asMaps().forEach(command -> dnscanVerify(devName, command));
    }

    @SneakyThrows
    @那么("串口设备{string}写入所有数据中应包含{string}")
    public void 串口设备写入所有数据中应包含字符串(String device, String str) {
        try (Socket socket = new Socket(lowerIp, 50000)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writeLine(bufferedWriter, "serialPort");
            writeLine(bufferedWriter, device);
            writeLine(bufferedWriter, "readAll");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            expect(bufferedReader.lines().collect(Collectors.toList())).should(String.format(": [... '%s' ...]", toHex(str)));
        }
    }

    public String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes(StandardCharsets.UTF_8)));
    }

    @SneakyThrows
    @那么("串口设备{string}写入所有数据中应包含hex串{string}")
    public void 串口设备写入所有数据中应包含hex串(String device, String hex) {
        try (Socket socket = new Socket(lowerIp, 50000)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writeLine(bufferedWriter, "serialPort");
            writeLine(bufferedWriter, device);
            writeLine(bufferedWriter, "readAll");
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            expect(bufferedReader.lines().collect(Collectors.toList())).should(String.format(": [... '%s' ...]", hex));
        }
    }

    @SneakyThrows
    private void dnscanVerify(String devName, Map<String, String> command) {
        try (Socket socket = new Socket(lowerIp, 50000)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writeLine(bufferedWriter, "dnscan");
            writeLine(bufferedWriter, devName);
            writeLine(bufferedWriter, command.get("mac"));
            writeLine(bufferedWriter, "read");
            writeLine(bufferedWriter, command.get("channel"));
            bufferedWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            expect(bufferedReader.readLine()).exact(command.get("data"));
        }
    }

    @SneakyThrows
    private void dnscanWrite(String devName, Map<String, String> command) {
        try (Socket socket = new Socket(lowerIp, 50000)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writeLine(bufferedWriter, "dnscan");
            writeLine(bufferedWriter, devName);
            writeLine(bufferedWriter, command.get("mac"));
            writeLine(bufferedWriter, "write");
            writeLine(bufferedWriter, command.get("channel"));
            writeLine(bufferedWriter, command.get("data"));
            bufferedWriter.flush();
        }
    }

    private String readLine(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }

    private void writeLine(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.write("\n");
    }
}
