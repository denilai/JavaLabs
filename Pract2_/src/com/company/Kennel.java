package com.company;

import java.util.LinkedList;

// Kennel - собачий питомник
public class Kennel {
    LinkedList <Dog> dogs = new LinkedList<>();
    Kennel(){}
    public void addDog(Dog newcomer){
        dogs.add(newcomer);
    }
    public void removeDog(Dog outgoing){
        dogs.remove(outgoing);
    }
    // muster - перекличка
    public void muster(){
        for(Dog dog:dogs){
            System.out.println(dog.toString());
        }
    }
}
