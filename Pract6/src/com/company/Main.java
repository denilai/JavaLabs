package com.company;

public class Main{
    public static void main(String args[]){
        MovingRectangle moveRect = new MovingRectangle(3,4);
        System.out.println("Info before step #1 (2,-4) >");
        System.out.println(moveRect.toString());
        moveRect.moveTo(2,-4);
        System.out.println("Info after step #1 (2,-4)>");
        System.out.println(moveRect.toString());

        moveRect.moveTo(-5,+4);
        System.out.println("Info after step #2 (-5,4) >");
        System.out.println(moveRect.toString());

    }
}