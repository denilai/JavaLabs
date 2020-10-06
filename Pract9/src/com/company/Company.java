package com.company;

import java.util.List;

public class Company {

    // FIELDS
    private List<Employee> employees;

    // METHODS

    public void hire(Employee newcomer){
        if (newcomer!= null)
            employees.add(newcomer);
    }

    public void fire(Employee unlucky){
        if(unlucky != null)
        employees.remove(unlucky);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void hireAll(List<Employee> newcomers){
        for(Employee newcomer:newcomers)
            hire(newcomer);
    }

    // реализация метода handleEmployee через интрефейсы в отдельном классе
    public void handleEmployee(EmployeeSelector selector, EmployeeHandler handler){
        for(Employee employee : employees)
            if(selector.need(employee))
                handler.handleEmployee(employee);
    }


}
