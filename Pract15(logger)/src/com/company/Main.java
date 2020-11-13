package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger.writeToLog("MyLogs","Размер папки 'to' в текущей дирректории = ");
        Logger.writeToLog("MyLogs",Logger.sizeOf("to")+"\n");
        Logger.writeToLog("MyLogs","Размер папки 'from' в текущей дирректории = ");
        Logger.writeToLog("MyLogs",Logger.sizeOf("from")+"\n");
        Logger.writeToLog("MyLogs","Размер папки 'src' в текущей дирректории = ");
        Logger.writeToLog("MyLogs",Logger.sizeOf("src")+"\n");

        System.out.println("Содержимое логов -> ");
        System.out.println(Logger.readFile("MyLogs\\log.txt"));
        // примеры работы статических методов по копированию директорий и файлов
//        System.out.println(
//                Logger.sizeOf(
//                        "C:\\Qt\\Qt5.14.2\\installer.dat"));
        //Logger.copyFile(new File("from.txt"),new File ("to.txt"));
        //Logger.copyFolders(new File("D:\\Documents\\denisov"),new File("D:\\Documents\\denisov1"));

        // копирование папок в папке с проектом
        Logger.copyFolders(new File("from"),new File ("to"));
    }
}
