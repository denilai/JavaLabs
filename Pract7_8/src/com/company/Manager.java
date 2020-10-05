package com.company;

import java.util.Random;

public class Manager   implements IEmployerPosition{

    @Override
    public String getJobTitle(){
        return "Employer position: Manager\n" +
                "\tSalary = fix + 5 % of revenue for the company";
    }

    @Override
    public double calcSalary(double baseSalary) {
        double cashForCompany = 115_000 +  new Random().nextInt(140_000-115_000);
        Company.income+=cashForCompany*0.95;
        return baseSalary + 0.05 * cashForCompany;
    }
}
