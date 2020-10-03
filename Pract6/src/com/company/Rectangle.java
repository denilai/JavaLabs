package com.company;

public class Rectangle extends Shape{
    // FIELDS
    protected double a;
    protected double b;
    // METHODS

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.square = a*b;
        this.perimeter = 2*a+2*b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public double getSquare() {
        return square;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "Rectangle:" +
                "\n{" +
                "   \n\tone side   = " + a +
                "   \n\tother side = " + b +
                "   \n\tperimeter  = " + perimeter +
                "   \n\tsquare     = " + square +
                "\n}";
    }
}