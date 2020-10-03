package com.company;

public class MovingRectangle extends Rectangle implements IMoving {

    // FIELDS
    // coordinate of two border points
    private Point top,bot;

    // METHODS

    private class Point{

        Point(int x, int y ){
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
        public void increment(int dX, int dY){
            x +=dX;
            y+=dY;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public MovingRectangle(int a, int b){
        super(a,b);
        this.top = new Point(0,0);
        this.bot = new Point(a, b);
    }

    public MovingRectangle(int topX, int topY, int botX, int botY ){
        super(Math.abs(topX-botX),Math.abs(topY-botY));
        this.top = new Point(topX, topY);
        this.bot = new Point (botX, botY);
    }

    @Override
    public void moveTo(int deltaX, int deltaY) {
        top.increment(deltaX,deltaY);
        bot.increment(deltaX,deltaY);
    }

    @Override
    public String toString() {
        return "MovingRectangle{" +
                "\n\ttop =" + top.toString() +
                "\n\tbot =" + bot.toString() +
                "\n\tone side =" + a +
                "\n\tother size =" + b +
                "\n\tsquare =" + square +
                "\n\tperimeter =" + perimeter +
                "\n}";
    }
}
