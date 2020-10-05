package com.company;

import java.io.IOException;
import java.util.List;

public class CompanyDemo {
    public void companyDemo() throws IOException {
        Company company = new Company();
        System.out.println("### Test input of program ###\n\t180 Operators\n\t80Managers\n\t10Top managers");

        for (int i = 0; i <180; i++) {
            company.hire(new Employee("Operator"));
        }

        for (int i = 0; i <80; i++) {
            company.hire(new Employee("Manager"));
        }

        for (int i = 0; i <10; i++) {
            company.hire(new Employee("Top Manager"));
        }


        // список 10 сотрудников с самой высокой оплатой труда
        System.out.println("Top-salary staff in this company:");
        showEmployees(company.getTopSalaryStaff(10));

        System.out.println("Lowest-salary staff in this company:");
        // список 30 сотрудников с самой низкой оплатой труда
        showEmployees(company.getLowestSalaryStaff(30));

        // сокращение штата на 50%
        int sizeBef = company.getEmployees().size();
        while(company.getEmployees().size()>(int)sizeBef/2)
            company.fire();

        System.out.println("Changing in company...");

        // список 10 сотрудников с самой высокой оплатой труда
        System.out.println(company.getTopSalaryStaff(10));
        // список 30 сотрудников с самой низкой оплатой труда
        System.out.println(company.getLowestSalaryStaff(30));
    }

    public void showEmployees(List<Employee> list){
        System.out.println("___________________________________________________________________");
        System.out.printf("%-11s%-31s|%-10s|%-10s","|#Place","|#Full name","#Position","#Final salary|\n");
        System.out.println("-------------------------------------------------------------------");
        int count =1;
        for (Employee employee:list) {
            System.out.printf("|%-10s","# "+count);
            System.out.printf("|%-30s",employee.getFullName());
            System.out.printf("|%-10s",employee.getPosition());
            System.out.printf("|%-30s\n",employee.getFinalSalary());
            count++;
        }
        System.out.println();
    }
}
