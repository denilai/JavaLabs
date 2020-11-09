package com.company;


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
         String[] words = words(fullName);
         if(words.length == 2) {
             person = new Person(words[0], words[1]);
         }
         if(words.length == 3){
             person = new Person(words[0], words[1],words[2]);
         }
    }

    public void introduce() {
         if (person!=null)
            person.introduce();
         else
             System.out.println("Введенная строка не является ФИО!");
    }

    public String[] words (String line){
        return line.trim().split(" ");
    }
}
