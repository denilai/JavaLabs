package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("-- TASK 1. SHAPES -- ");
        Shape dot1 = new Shape("Dot1","Dot",0,0);
        Shape triangle1 = new Shape("Triangle1","Triangle",10,23);
        Shape circle1 = new Shape("Circle1","Circle",25.12,50.24);

        ShapeDemo demo = new ShapeDemo();
        demo.getInfo(dot1);
        demo.getInfo(triangle1);
        demo.getInfo(circle1);

        System.out.println("-- TASK 2. DOGS ---");
        Kennel kennel = new Kennel();
        kennel.addDog(new Dog("Dendy",12));
        kennel.addDog(new Dog("Stan",4));
        kennel.addDog(new Dog("Milly",2));
        kennel.addDog(new Dog("Olive",5));
        kennel.addDog(new Dog("Zyzi",6));

        kennel.muster();


        // write your code here
    }
}
