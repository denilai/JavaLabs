package com.company;

public class Pract3Demo {

    public static void main(String[] args) {
        System.out.println("\tPart 1. Circle");
        CircleDemo.circleDemo();

        System.out.println("\tPart 2. Human");
        HumanDemo.humanDemo();

        System.out.println("\tPart 3. Book");
        BookDemo.bookDemo();


    }
}

class CircleDemo{
    public static void circleDemo() {
        Circle circle1 = new Circle(3, 4, 5);
        Circle circle2 = new Circle(5.2, 5.3, 2);

        System.out.println("Circle1 before: ");
        System.out.println(circle1.toString());
        System.out.println("Set center of circle 1 to {6,-4}");
        circle1.setCenter(6, -4);
        System.out.println("Circle1 after: ");
        System.out.println(circle1.toString());

        System.out.println("Radius of 2 circle");
        System.out.println(circle2.getRadius());

        System.out.println("Circle2 before: ");
        System.out.println(circle2.toString());
        System.out.println("Set radius to 1,3");
        System.out.println("Set center circle2 to {3.2,6.3}");
        circle2.setRadius(1.3);
        circle2.setCenter(3.2, 6.3);
        System.out.println("Circle2 after: ");
        System.out.println(circle2.toString());
    }
}

class HumanDemo{
    public static void humanDemo(){
        Human Mike = new Human("Mike",41, 56, "Undercut",20);
        Human Stan = new Human("Stan",39, 54, "Hairless",21);
        Human Elen = new Human("Elen",37, 54, "Braid hairstyle", 18);
        Elen.toString();
        Stan.toString();
        Mike.toString();
        System.out.println(Mike.toString());
        Mike.getHead().setHair("Mohawk");
        System.out.println("Changed Mike's hair: Undercut -> Mohawk");
        System.out.println(Mike.toString());
        Mike.toString();
    }
}

class BookDemo{
    public static void bookDemo(){
        Book gradObrechennyi = new Book("Strugazhky brother", "Grad Obrechennyi", 1972);
        Book zamok = new Book("Franz Kafka", "Castle", 1922);
        System.out.println("My library");
        System.out.println(zamok.toString());
        System.out.println(gradObrechennyi.toString());
    }
}