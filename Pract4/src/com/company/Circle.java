package com.company;

public class Circle extends Shape{

    private double radius;

    // METHODS
    Circle (double radius){
        this.radius = radius;
        this.square = radius*radius*Math.PI;
        this.perimeter = 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getSquare() {
        return 0;
    }

    @Override
    public double getPerimeter(){
        return perimeter;
    }
    @Override
    public String toString() {
        return "Circle:" +
                "\n{" +
                "   \n\tradius    = " + radius +
                "   \n\tperimeter = " + perimeter +
                "   \n\tsquare    = " + square +
                "\n}";
    }
}
