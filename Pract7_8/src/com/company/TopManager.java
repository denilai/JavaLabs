package com.company;

public class TopManager implements IEmployerPosition{

    @Override
    public String getJobTitle() {
        return "Employer position: Top Manager\n" +
                "\tSalary = fix + 150% bonus*\n\t" +
                "   \t(if income of company more then 10 million of rubles)";
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (Company.income>10_000_000)
            return baseSalary*1.5;
        else return baseSalary;
    }
}
