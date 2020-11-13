package com.company;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.lang.Object.*;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.Scanner;

public class Logger {

    public static void writeToLog(String path, String message){
        try {
            File logDir = new File (path);
            if (!logDir.exists())
                if(!logDir.mkdir())
                    System.out.println("Logger.Logger: Не удалось создать дирректорию");
            FileOutputStream fout = new FileOutputStream(new File(path+"\\log.txt"), true);
            fout.write(message.getBytes());
            fout.close();
        }
        catch (FileNotFoundException a){
            System.out.println("Logger.toLog: Не удалось открыть файл " + a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long sizeInBytes(String path) {// путь от пользователя до папки
        File dir = new File(path);
        if (!dir.exists())
            return 0;
        long size = 0;
        if (Files.isDirectory(Path.of(dir.getAbsolutePath()))) {
            File[] files = dir.listFiles();
            assert files != null;
            for (File file:files){
                size+= Logger.sizeInBytes(file.getAbsolutePath());
            }
        }
        if(Files.isRegularFile(Path.of(dir.getAbsolutePath()))){
            size = dir.length();
        }

        return size;
    }


    public static String sizeOf(String path){
        long size = Logger.sizeInBytes(path);
        int pow = 0;
        String[]prefixes = new String[]{"B","KB","MB","GB","TB"};
        if (size>=Float.MAX_VALUE){
            return "Out of bounds";
        }
        float bytes = size;
        while (bytes >= 1024) {
            bytes /= 1024;
            pow ++;
        }

        return String.format("%.2f",bytes) + " " + prefixes[pow];
    }



    public static void copyFolders(File sourseDir, File destDir) throws IOException {
        if (!destDir.exists()){
            destDir.mkdir();
        }
        File[]sons = sourseDir.listFiles();
        assert sons != null;
        for (File son:sons){
            if(son.isDirectory())
                copyFolders(son,new File (destDir.getAbsolutePath()+"\\" + son.getName()));
            if(son.isFile()){
                copyFile(son,new File(destDir.getAbsolutePath()+"\\" + son.getName()));
            }
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }

    public static String readFile(String path){
        String content = null;
        try {
            FileInputStream fin = new FileInputStream(new File(path));
            Scanner sc = new Scanner(fin);
            while (sc.hasNext()){
                content+=sc.nextLine()+"\n";
            }
            sc.close();
            fin.close();
        }
        catch (FileNotFoundException a){
            System.out.println("Logger.readFile: Не удалось окткрыть файл "+path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


}
