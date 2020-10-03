package com.company;

public class Shape {
    private String name;
    private double perimeter;
    private double area;
    private String type;

    public String getName(){return name;}
    public String getType (){return type;}
    public double getPerimeter(){return perimeter;}
    public double getArea(){return area;}

    public Shape(String nameN, String typeN, double perimeterN, double areaN ){
        name = nameN;
        type = typeN;
        perimeter = perimeterN;
        area = areaN;
    }
}

