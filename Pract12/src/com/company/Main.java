package com.company;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Task 1");
        System.out.println("------------------------------------");
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        SalaryParser parser = new SalaryParser(text);
        System.out.println("Заработок Васи = ");
        System.out.println( parser.someoneSalary("Вася"));
        System.out.println("Заработок Пети = ");
        System.out.println( parser.someoneSalary("Петя"));
        System.out.println("Заработок Маши = ");
        System.out.print( parser.someoneSalary("Маша"));

        System.out.println("Task 2");
        System.out.println("------------------------------------");
        System.out.print("Введите ФИО> ");
        Scanner sc = new Scanner(System.in);
        String fullName = sc.nextLine();
        PersonParser personParser = new PersonParser (fullName);
        personParser.introduce();

        System.out.println("Task 2");
        System.out.println("------------------------------------");
        System.out.println( PhoneNum.clean("45678sdf78--9 "));

        ArrayList <PhoneNum> phones = new ArrayList<>();
        phones.add(new PhoneNum ("+7 909 343-45-88"));
        phones.add(new PhoneNum ("8 (909)3443588"));
        phones.add(new PhoneNum ("+7 (909) 1234567"));
        phones.add(new PhoneNum ("8-905-123"));
        phones.add(new PhoneNum ("8-905-12345672342"));
        phones.add(new PhoneNum ("9-453-1234567"));
        phones.forEach((phoneNum -> {
            System.out.println(phoneNum.toString());
        }));


    }
}
