package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Employee implements Comparable<Employee>{
    private String fstName;
    private String sndName;
    private String position;
    private double baseSalary;
    public double finalSalary;
    private static List<String> randomFstName;
    private static List <String> randomSndName;
    Company company;
    int cashForCompany = 0;

    public double getBaseSalary(){
        return this.baseSalary;
    }

    Employee(String position) throws IOException {
        randomFstName = Files.readAllLines(Path.of  ("RandomFstNames.txt"), StandardCharsets.UTF_8);
        randomSndName = Files.readAllLines(Path.of  ("RandomSndNames.txt"), StandardCharsets.UTF_8);
        Random random = new Random();
        String rFstName = randomFstName.get(random.nextInt(100));
        String rSndName = randomSndName.get(random.nextInt(88));
        this.fstName = rFstName;
        this.sndName = rSndName;
        this.position = position;
        this.baseSalary = random.nextInt(300000)+150000;
        switch (position){
            case "Manager":
                finalSalary = new Manager().calcSalary(baseSalary);
                break;
            case "Operator":
                finalSalary = new Operator().calcSalary(baseSalary);
                break;
            case "Top Manager":
                finalSalary = new TopManager().calcSalary(baseSalary);
        }
    }

    Employee(String fstName, String sndName, String position, double baseSalary) throws IOException {
        this.fstName = fstName;
        this.sndName = sndName;
        this.baseSalary = baseSalary;
        this.position = position;
        switch (position){
            case "Manager":
                finalSalary = new Manager().calcSalary(baseSalary);
                break;
            case "Operator":
                finalSalary = new Operator().calcSalary(baseSalary);
                break;
            case "Top Manager":
                finalSalary = new TopManager().calcSalary(baseSalary);
        }
        FileReader reader = new FileReader("RandomNames.txt");
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    @Override
    public int compareTo(Employee o) {
        double eps = 0.000000001;
        double temp = Math.abs(o.getFinalSalary()-this.getFinalSalary());
        if (temp<eps ) return 0;
        else if (o.getFinalSalary()>this.getFinalSalary())
            return -1;
        else return 1;
    }

    public String getPosition() {
        return position;
    }

    public String getFullName() {
        return fstName + ' ' + sndName;
    }

    @Override
    public String toString() {
        return "Employee: {"+
                " name: " + fstName + ' '+ sndName +
                " position: "+ position +
                " final salary: "+ getFinalSalary() +
        " }";
    }


}
