package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Menu {
    public static int task(){
        boolean check = false;
        int answer =0;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("==== Select task ====");
            System.out.println("1) Report on banking operations");
            System.out.println("2) HTTP parse");
            System.out.println("3) EXIT");
            try{
                answer = sc.nextInt();
                if (answer<1 || answer>3)
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
    public static boolean execute (int answer){
        switch (answer){
            case 1: {
                Scanner in = new Scanner(System.in);
                String chs;
                do {
                    String pathToCSV = "D:\\Documents\\Denisov\\ProgPractice\\JavaLabs\\Pract16\\src\\main\\resources\\movementList.csv";
                    CSVParser parser = new CSVParser(pathToCSV);
                    parser.getReport();
                    boolean check;
                    do {
                        check = true;
                        System.out.println("Repeat the task? (y or n)> ");
                        chs = in.nextLine();
                        if (!(chs.equals("y") || chs.equals("n"))) {
                            System.out.println("This answer is not exist.\nTry again");
                            check = false;
                        }
                    }while (!check) ;
                }while (chs.equals("y"));
                break;
            }
            case 2:
                break;
            case 3: {
                System.out.println("Program finished...");
                return false;
            }
        }
        System.out.println("Program finished...");
        return true;
    }
}