package com.company;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

class MyException extends Exception{
    public MyException(String s) {
        super (s);
    }
}

public class Menu {
    public int task(){
        boolean check = false;
        int answer =0;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("==== Select task ====");
            System.out.println("1) Message logging");
            System.out.println("2) Сhecking the folder size");
            System.out.println("3) Copy user folder");
            System.out.println("4) EXIT");
            try{
                answer = sc.nextInt();
                if (answer<1 || answer>4)
                    throw new MyException ("That task isn't exist");
                check = true;
            }
            catch (InputMismatchException e){
                System.out.println("this isn't a number.Try again!");
                check =  false;
            }
            catch (MyException a){
                System.out.println(a);
                check =  false;
            }
        }while(!check);
        return answer;
    }
    public boolean execute (int answer){
        String line="";
        switch (answer){
            case 1:{
                Scanner sc = new Scanner(System.in);
                System.out.println("Type 'q' to exit");
                do{
                    System.out.print("Введите название папки,\nв которой будет создан файл 'log.txt'> ");
                    String dir = sc.nextLine();
                    if(dir.equals("q")){
                        break;
                    }
                    System.out.println("Введите сообщение, которое будет помещено в файл '..\\"+dir+"\\log.txt'> ");
                    String message = sc.nextLine();
                    if(Logger.writeToLog(dir,message))
                        System.out.println("Сообщение успешно записано");
                    else System.out.println("Ошибка записи сообщения");
                }while (true);
                break;
            }
            case 2:{
                Scanner sc = new Scanner(System.in);
                System.out.println("Type 'q' to exit");
                do{
                    System.out.println("Введите абсолютный путь папки/файла,\nразмер которой Вы хотели бы узнать>");
                    String path = sc.nextLine();
                    if(path.equals("q")){
                        break;
                    }
                    if(!Logger.sizeOf(path))
                        System.out.println("Не удалось узнать размер файла");
                }while (true);
                break;
            }
            case 3: {
                Scanner sc = new Scanner(System.in);
                System.out.println("Type 'q' to exit");
                do {
                    System.out.println("Введите абсолютный путь копируемого файла/папки>");
                    String from = sc.nextLine();
                    if(from.equals("q")){
                        break;
                    }
                    System.out.println("Введите абсолютный путь до места назанчения>");
                    String to = sc.nextLine();
                    if (to.equals("q")){
                        break;
                    }
                    Logger.copyFolders(new File(from),new File(to));
                    System.out.println("Процесс копирования завершен");
                }while (true);
                break;
            }
            case 4:{
                System.out.println("Program finished...");
                return false;
            }
        }
        return true;
    }
}
