package com.company;

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
            System.out.println("1) To-do list");
            System.out.println("2) Email list");
            System.out.println("3) Phone book");
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
                ToDoList list = new ToDoList();
                ToDoCommandManager commander = new ToDoCommandManager(list);
                Scanner in = new Scanner(System.in);
                System.out.println("Type 'q' to exit");
                do {
                    line = in.nextLine();
                    if (!commander.execute(line))
                        System.out.println("Fail");
                    else System.out.println("OK");
                }while (!line.equals("q"));
                break;
            }
            case 2:{
                EmailList emailList = new EmailList();
                EmailCommandManager commander2 = new EmailCommandManager(emailList);
                Scanner in = new Scanner(System.in);
                System.out.println("Type 'q' to exit");
                do {
                    line = in.nextLine();
                    if (!commander2.execute(line))
                        System.out.println("Fail");
                    else System.out.println("OK");
                }while (!line.equals("q"));
                break;
            }
            case 3: {
                PhoneList phoneList = new PhoneList();
                PhoneCommandManager commander3 = new PhoneCommandManager(phoneList);
                Scanner in = new Scanner(System.in);
                System.out.println("Type 'q' to exit");
                do {
                    line = in.nextLine();
                    if (!commander3.execute(line))
                        System.out.println("Fail");
                    else System.out.println("OK");
                }while (!line.equals("q"));
                break;
            }
            case 4:{
                System.out.println("Program finished...");
                return false;
            }
        }
        return (line.equals("q"));
    }
}
