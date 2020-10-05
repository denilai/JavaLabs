package com.company;

import java.util.*;

public class Company {

    // FIELDS
    public static int income;
    private List <Employee> employees = new LinkedList<Employee>();

    // METHODS

    public void hire(Employee newcomer){
        if (newcomer!= null)
            employees.add(newcomer);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void hireAll(ArrayList<Employee> newcomers){
        for(Employee newcomer:newcomers)
            hire(newcomer);
    }
/*

    public void showEmployees(){
        System.out.println("___________________________________________________________________");
        System.out.printf("%-11s%-31s|%-10s|%-10s","|#Place","|#Full name","#Position","#Final salary|\n");
        System.out.println("-------------------------------------------------------------------");
        int count =1;
        for (Employee employee:employees) {
            System.out.printf("|%-10s","# "+count);
            System.out.printf("|%-30s",employee.getFullName());
            System.out.printf("|%-10s",employee.getPosition());
            System.out.printf("|%-30s\n",employee.getFinalSalary());
            count++;
        }
    }
 */

    // увольнение сотрудника
    public void fire (){
        Random random = new Random();
        int rand = random.nextInt(employees.size());
        System.out.print("Remove ");
        System.out.println(employees.get(rand).toString());
        employees.remove(rand);
    }


    public boolean compare(Employee one, Employee two){
        return one.getFinalSalary()< two.getFinalSalary();
    }


    List<Employee> getTopSalaryStaff (int count){
        if (count<0)
            return null;
        if(count>employees.size())
            return null;
        List<Employee> answer = employees;
        Collections.sort(answer,Collections.reverseOrder());
        return answer.subList(0,count);
    }
    public List <Employee> getLowestSalaryStaff(int count){
        if (count<0)
            return null;
        if(count>employees.size())
            return null;
        List<Employee> answer = employees;
        Collections.sort(answer);
        return answer.subList(0,count);
    }
}
