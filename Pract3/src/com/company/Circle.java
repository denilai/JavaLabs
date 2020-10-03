package com.company;

public class Circle {
    private double radius;
    private Point center;

    public Circle(double x, double y, double radius){
        center = new Point(x,y);
        this.radius = radius;
    }

    private class Point {
        public Point (double x, double y){
            this.x = x;
            this.y = y;
        }
        private double x;
        private double y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setCenter(double x, double y) {
        this.center = new Point(x,y);
    }

    public double getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
}
