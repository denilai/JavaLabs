package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(4,5);
        Square square = new Square(5);

        System.out.println("Perimeter of circle : ");
        System.out.printf("%.3f\n",circle.getPerimeter());

        System.out.println("Info about shapes >");
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(square.toString());

    }
}
