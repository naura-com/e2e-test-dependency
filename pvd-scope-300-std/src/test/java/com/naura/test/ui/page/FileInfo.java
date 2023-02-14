package com.naura.test.ui.page;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInfo {
    public String name;
    public String[] info;

    public FileInfo(String name, String[] info) {
        this.name = name;
        this.info = info;
    }

    public FileInfo() {

    }

    public void writeFile(String path, String[] lines) throws IOException {
        createFolder();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        File file = new File(path);
        if (file.exists())
            file.delete();
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < lines.length; i++) {
                bufferedWriter.write(lines[i]);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    public void createFolder() {
        File folder = new File("c:\\test\\Route");
        if (!folder.exists())
            folder.mkdirs();
        else {
            deleteFile(folder);
            folder.mkdirs();
        }
    }

    public void deleteFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                deleteFile(f);
            else
                f.delete();
        }
        file.delete();
    }
}
