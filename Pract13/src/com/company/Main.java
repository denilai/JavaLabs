package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    // вводимый индекс - порядковый номер элемента в списке дел (от 1...)

//        ToDoList list = new ToDoList();
//        ToDoCommandManager commander = new ToDoCommandManager(list);
//        String line;
//        Scanner in = new Scanner(System.in);
//        do {
//            line = in.nextLine();
//            if (!commander.execute(line))
//                System.out.println("Fail");
//            else System.out.println("OK");
//        }while (line!="q");
        boolean answer = false;
        do {
            Menu menu = new Menu();
            answer = menu.execute(menu.task());
        }while (answer);
    }
}
