package com.company;

public class Operator implements IEmployerPosition{

    @Override
    public String getJobTitle(){
        return "Employer position: Operator\n" +
                "\tSalary = only fix ";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }
}
