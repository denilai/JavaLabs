package com.company;


import java.util.ArrayList;

public class PersonParser {

     private class Person{
         String sndName;
         String fstName;
         String midName;
         boolean state;

         public Person(String fstName, String sndName, String midName){

             this.fstName = fstName;
             this.sndName = sndName;
             this.midName = midName;
             state = true;
         }

         public Person(String fstName, String sndName){

             this.fstName = fstName;
             this.sndName = sndName;
             state = true;
         }

         public void introduce() {
             if (state) {
                 if (fstName != null)
                     System.out.println("Фамилия: " + fstName);
                 if (sndName != null)
                     System.out.println("Имя: " + sndName);
                 if (midName != null)
                     System.out.println("Отчество: " + midName);
             }
         }
     }

     private Person person = null;//= new Person("","","");

     public PersonParser(String fullName){
         ArrayList<String> words = words(fullName);
         if(words.size() == 2) {
             person = new Person(words.get(0), words.get(1));
         }
         if(words.size() == 3){
             person = new Person(words.get(0), words.get(1),words.get(2));
         }
    }

    public void introduce() {
         if (person!=null)
            person.introduce();
         else
             System.out.println("Введенная строка не является ФИО!");
    }

    public ArrayList<String> words(String line){
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        for ( char ch : line.toCharArray()){
            if(ch == ' ') {
                words.add(word);
                word = "";
            }
            else
                word += ch;
        }
        return words;
    }
}
