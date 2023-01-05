package com.naura.test.ui.page.Etch1;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.Window;
import io.cucumber.datatable.DataTable;
import lombok.SneakyThrows;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOption {
    File file;
    FileReader fileReader;
    BufferedReader bufferedReader;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    List<Map<Object, Window.WindowOperation>> view;

    private int timeIntervalConfig = 1;

    public FileOption() {
        file = null;
        fileWriter = null;
        fileReader = null;
        bufferedReader = null;
        bufferedWriter = null;
        view = null;
    }


    public String[] readFile(String filePathName) {
        ArrayList<String> fileContent = new ArrayList<String>();
        String str;
        file = new File(filePathName);
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((str = bufferedReader.readLine()) != null) {
                fileContent.add(str);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent.toArray(new String[0]);
    }

    public String[] createSetupFile(Window.WindowOperation page) {
        ArrayList<String> fileContent = new ArrayList<String>();
        String str;
        view = page.asTable();
        fileContent.add("Parameter,Range,Unit,CurrentValue,DefaultValue");
        for (int i = 0; i < view.size(); i++) {
            fileContent.add(view.get(i).get("Parameter").getValue().toString() + ',' +
                    ((str = view.get(i).get("Range").getValue().toString()).contains(",") ? ("\"" + str + "\"") : str) + ',' +
                    view.get(i).get("Unit").getValue().toString() + ',' +
                    view.get(i).get("CurrentValue").getValue().toString() + ',' +
                    view.get(i).get("DefaultValue").getValue().toString());
        }
        return fileContent.toArray(new String[0]);
    }

    public void changeFileLine(String[] fileContent, String line, String value) {
        for (int i = 0; i < fileContent.length; i++) {
            if (fileContent[i].contains(line)) {
                String[] str = fileContent[i].split(",");
                if (str.length == 5) {
                    str[3] = value;
                    fileContent[i] = str[0] + ',' + str[1] + ',' + str[2] + ',' + str[3] + ',' + str[4];
                } else {
                    str[4] = value;
                    fileContent[i] = str[0] + ',' + str[1] + ',' + str[2] + ',' + str[3] + ',' + str[4] + ',' + str[5];
                }
            }
        }
    }

    public void writerFile(String filePathName, String[] fileContent) {
        for (int i = 0; i < fileContent.length; i++) {
            fileContent[i] = fileContent[i].replace("(null)", "");
        }
        if (filePathName.contains(".csv"))
            file = new File(filePathName.substring(0, filePathName.length() - 4));
        else
            file = new File(filePathName);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < fileContent.length; i++) {
                bufferedWriter.write(fileContent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileRename(String oldFilePathName, String newFilePathName) {
        new File(oldFilePathName).renameTo(new File(newFilePathName));
    }

    public boolean fileExsit(String filePathName) {
        file = new File(filePathName);
        return file.exists();
    }

    public void filecreate(String filePathName) {
        file = new File(filePathName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanDir(String dir) {
        File Dir = new File(dir);
        File[] fileslist = Dir.listFiles();
        for (File temp : fileslist) {
            if (temp.isDirectory()) {
                cleanDir(String.valueOf(temp));
                temp.delete();
            } else
                temp.delete();
        }
    }

    public void writerAlarmFile(String filePathName, DataTable fileContent) {
        file = new File(filePathName);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String filerow = fileContent.row(0).toString();
            filerow = filerow.replace("null", "");
            bufferedWriter.write(filerow.substring(1, filerow.length() - 1));
            bufferedWriter.newLine();
            for (int i = 1; i < fileContent.height(); i++) {
                filerow = fileContent.row(i).toString();
                filerow = filerow.replace("null", "");
                filerow = filerow.replace(",", "     ");
                bufferedWriter.write(filerow.substring(1, filerow.length() - 1));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void alarmImportFile(String path, Table table) {
        ArrayList<String> fileContent = new ArrayList<String>();
        for (int num = 0; num < table.size(); num++) {
            fileContent.add("ALID " + table.get(num).get("Id") + "{");
            fileContent.add("     ALName: " + table.get(num).get("Name"));
            fileContent.add("     ALSeverity: " + table.get(num).get("Severity"));
            fileContent.add("     ALMessage: " + table.get(num).get("Message"));
            fileContent.add("     ALDescription: " + table.get(num).get("Description"));
            fileContent.add("     ALPostTime: " + table.get(num).get("PostTime"));
            fileContent.add("     ALRecoveryType: ");
            fileContent.add("     ALRecoveryTime: " + table.get(num).get("RecoveryTime"));
            fileContent.add("     ALModule: " + table.get(num).get("Module"));
            fileContent.add("   }");
            fileContent.add("");
        }
        String[] filecontent = fileContent.toArray(new String[0]);
        file = new File(path);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void alarmImportUselessFile(String path) {
        file = new File(path);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Useless");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lotMProFile(String day, String time, String id, String num) {//由于用途单一，且此处用到的文件需要三个不同格式后缀名特殊的文件同时存在，所以直接整合到一个方法内，此处准备的为手动工艺记录
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + day);
        if (!file.isDirectory())
            file.mkdir();

        ArrayList<String> fileContent = new ArrayList<String>();
        fileContent.add("lot id:" + id);
        fileContent.add("cjob id:ManualProcessPM2");
        fileContent.add("start Time:" + day + " " + time + " AM");
        fileContent.add("end Time:" + day + " " + time + " AM");
        fileContent.add("cairrer id:");
        fileContent.add("input Foup:");
        fileContent.add("output Foup:");
        fileContent.add("defined wafer: ");
        fileContent.add("waferid,wafername,wafer status,slot,flowname,status error,chamber,recipe,starttime,endtime,alignangle");
        fileContent.add("441,,1,0,,0,PM2 GDE,zz," + day + " " + time + "," + day + " " + time + ",");
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + day + "\\" + "ManualProcess_" + id + "_" + num + ".l");
        String[] filecontent = fileContent.toArray(new String[0]);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileContent.clear();

        fileContent.add(",1,zz,PM2 GDE");
        fileContent.add("dechuck," + day + " " + time + "," + day + " " + time + ",1/1,20,Time,IEP,20,0:");
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + day + "ManualProcess_1_" + num + ".r");
        filecontent = fileContent.toArray(new String[0]);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileContent.clear();

        fileContent.add("operation time,wafer name,source station_slot,destination station_slot");
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + day + "ManualProcess_1_" + num + ".w");
        filecontent = fileContent.toArray(new String[0]);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileContent.clear();
    }

    public void createDir(String s) {
        file = new File(s);
        file.mkdir();
    }

    public void lotAutoFileL(Table table) {
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + table.get(0).get("Day"));
        if (!file.isDirectory())
            file.mkdir();

        ArrayList<String> fileContent = new ArrayList<String>();
        fileContent.add("lot id:" + table.get(0).get("LotID"));
        fileContent.add("cjob id:ManualProcessPM2");
        fileContent.add("start Time:" + table.get(0).get("startTime"));
        fileContent.add("end Time:" + table.get(0).get("endTime"));
        fileContent.add("cairrer id:");
        fileContent.add("input Foup:" + table.get(0).get("inputFoup"));
        fileContent.add("output Foup:" + table.get(0).get("outFoup"));
        fileContent.add("defined wafer: " + table.get(0).get("definedWafer"));
        fileContent.add("waferid,wafername,wafer status,slot,flowname,status error,chamber,recipe,starttime,endtime,alignangle");
        fileContent.add(table.get(0).get("waferid") + "," + table.get(0).get("wafername") + "," + table.get(0).get("waferstatus") + "," + table.get(0).get("slot") + "," +
                table.get(0).get("flowname") + "," + table.get(0).get("statuserror") + "," + table.get(0).get("chamber") + "," + table.get(0).get("recipe") + "," +
                table.get(0).get("starttime") + "," + table.get(0).get("endtime") + "," + table.get(0).get("alignangle"));

        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + table.get(0).get("Day") + "\\" + table.get(0).get("LotID") + "_" +
                table.get(0).get("FileID") + ".l");

        String[] filecontent = fileContent.toArray(new String[0]);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lotAutoFileR(Table table) {
        ArrayList<String> fileContent = new ArrayList<String>();
        fileContent.add(table.get(0).get("wafername") + "," + table.get(0).get("LotID") + "," + table.get(0).get("recipe") + "," + table.get(0).get("chamber"));
        fileContent.add(table.get(0).get("StepName") + "," + table.get(0).get("stepstartTime") + "," + table.get(0).get("stependTime") + "," + table.get(0).get("stepAddress") +
                "," + table.get(0).get("stepProcessTime") + "," + table.get(0).get("stepEndBy") + "," + table.get(0).get("EPDType") + "," + table.get(0).get("EPDTime") +
                "," + table.get(0).get("Error") + ":");
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + table.get(0).get("Day") + "\\" + table.get(0).get("LotID") + "_" +
                table.get(0).get("FileID") + ".r");
        String[] filecontent = fileContent.toArray(new String[0]);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lotAutoFileW(int FileID, Table table) {
        ArrayList<String> fileContent = new ArrayList<String>();
        fileContent.add("operation time,wafer name,source station_slot,destination station_slot");
        for (int i = 0; i < table.size(); i++) {
            fileContent.add(table.get(i).get("time") + "," + table.get(i).get("wafername") + "," + table.get(i).get("flowFrom") + "," + table.get(i).get("flowTo"));
        }
        file = new File("C:\\test\\etch1\\Debug\\data\\history log\\" + table.get(0).get("Day") + "\\" + table.get(0).get("LotID") + "_" +
                FileID + ".w");
        String[] filecontent = fileContent.toArray(new String[0]);
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < filecontent.length; i++) {
                bufferedWriter.write(filecontent[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public boolean checkLog(String logStr, String logFile) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        Date beforeTime = getTimeRange(now, -timeIntervalConfig);
        Date afterTime = getTimeRange(now, timeIntervalConfig);
        ArrayList<String> contexts = getInfoFromLog(logStr, logFile);
        String filterTime = "(?<Time>\\d{4}-\\d{2}-\\d{2} (20|21|22|23|[0-1]?)\\d:[0-5]?\\d:[0-5]?\\d).*";
        Pattern filterTimePatter = Pattern.compile(filterTime);
        for (String context :
                contexts) {
            Matcher matcher = filterTimePatter.matcher(context);
            if (matcher.matches()) {
                String textTime = matcher.group("Time");
                if (isEffectiveDate(df.parse(textTime), beforeTime, afterTime))
                    return true;
            }
        }
        return false;
    }

    public ArrayList<String> getInfoFromLog(String logStr, String logFile) {
        ArrayList<String> context = new ArrayList<String>();
        String[] fileContexts = readFile(logFile);
        for (String fileContext :
                fileContexts) {
            if (fileContext.contains(logStr)) {
                context.add(fileContext);
            }
        }
        return context;
    }

    public Date getTimeRange(Date time, int timeRange) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.MINUTE, timeRange);
        return cal.getTime();
    }

    public boolean isEffectiveDate(Date dateTime, Date beforeTime, Date afterTime) {
        if (dateTime.getTime() == beforeTime.getTime() || dateTime.getTime() == afterTime.getTime())
            return true;
        Calendar date = Calendar.getInstance();
        date.setTime(dateTime);

        Calendar before = Calendar.getInstance();
        before.setTime(beforeTime);

        Calendar after = Calendar.getInstance();
        after.setTime(afterTime);

        if (date.after(before) && date.before(after))
            return true;
        else
            return false;
    }

    public String[] createSetupFileLly(Table table) {
        ArrayList<String> fileContent = new ArrayList<String>();
        String str;
        fileContent.add("Parameter,Range,Unit,CurrentValue,DefaultValue");
        for (int i = 0; i < table.size(); i++) {
            fileContent.add((table.get(i).get("Parameter").toString() + ',' +
                    ((str = table.get(i).get("Range").toString()).contains(",") ? ("\"" + str + "\"") : str) + ',' +
                    table.get(i).get("Unit") + ',' +
                    table.get(i).get("CurrentValue").toString() + ',' +
                    table.get(i).get("DefaultValue").toString()).replace("null", ""));
        }
        return fileContent.toArray(new String[0]);
    }
}
