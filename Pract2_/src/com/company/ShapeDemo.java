package com.company;

public class ShapeDemo {
    public void getInfo(Shape shape){
        System.out.println("---------------------------");
        System.out.println("SHAPE INFO:");
        System.out.println("Name: "+shape.getName());
        System.out.println("Type: "+shape.getType());
        System.out.println("Perimeter = "+shape.getPerimeter());
        System.out.println("Area = "+shape.getArea());
        System.out.println("---------------------------");
    }
}
