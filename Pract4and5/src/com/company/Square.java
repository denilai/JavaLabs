package com.company;

public class Square extends Rectangle{
    Square(double a){
        super(a,a);
    }

    @Override
    public String toString() {
        return  "Square:" +
                "\n{" +
                "   \n\tside   = " + a +
                "   \n\tperimeter  = " + perimeter +
                "   \n\tsquare     = " + square +
                "\n}";
    }
}
