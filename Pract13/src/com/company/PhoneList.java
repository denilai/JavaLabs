package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PhoneList {
    Map <String, String> phones;// map <телефон, имя>
                                // ключ должен быть уникальным, каким как раз и
                                // является номер мобильного телефона.
                                // Имена же могут повторяться, что делает их
                                // непригодными для использования в качестве ключа.
                                // Минус - ключ-номер весьма длинный, сложнее для запоминания,
                                // в то время как имя, казалось бы, больше подходит в качестве ключа.
    // Еще одна проблема - отсутствие единого варианта представления номера телефона, что делает
    // сложнее операции по его обработке

    public PhoneList(){
        phones = new HashMap<>();
    }

    public boolean handleRequest (String request){
        PhoneNum newPhoneNum = new PhoneNum(request);
        Name newName = new Name(request);
        if (newPhoneNum.getStatus()) {
            if (phones.containsKey(newPhoneNum.toString())) {
                return infoAbout(newPhoneNum);
            }
            else {
                return register(newPhoneNum);
            }
        }
        if(newName.getStatus()){
            if (phones.containsValue(newName.hisName())){
                return infoAbout(newName);
            }
            else{
                return register(newName);
            }
        }
        return false;
    }

    private boolean infoAbout(PhoneNum phoneNum){
        System.out.println("Phone> " + phoneNum.toString());
        System.out.println("Owner> " + phones.get(phoneNum.toString()));
        return true;
    }

    private boolean infoAbout(Name name){
        Iterator iterator = phones.keySet().iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            Object value = phones.get(key);
            if (value.equals(name.hisName()))
                System.out.println("Phone> " + key);
                System.out.println("Owner> " + value);
        }
        return true;
    }
    
    private boolean register(PhoneNum phoneNum){
        Name newcomer;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please type the name of the number holder> ");
            newcomer = new Name(sc.nextLine());
            if (newcomer.getStatus()) {
                phones.put(phoneNum.toString(), newcomer.hisName());
            } else {
                System.out.println("Wrong name format!");
                System.out.println("Please try again");
            }
        }while (!newcomer.getStatus());
        return true;
    }

    private boolean register(Name newcomer){
        PhoneNum phoneNum = null;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Please type the number of the a user> ");
            phoneNum = new PhoneNum (sc.nextLine());
            if (phoneNum.getStatus()) {
                phones.put(phoneNum.toString(), newcomer.hisName());
            } else {
                System.out.println("Wrong phone number format!");
                System.out.println("Please try again");
            }
        }while (!phoneNum.getStatus());
        return true;
    }

    public boolean print(){
        if (phones.isEmpty())
            return false;
        System.out.printf("%-17s %10s %n","Phone number","Owner");
        System.out.printf("------------------------------%n");

        for(String key : phones.keySet()){
            System.out.printf("%-17s %10s %n",key,phones.get(key));
        }
        return  true;
    }
}
