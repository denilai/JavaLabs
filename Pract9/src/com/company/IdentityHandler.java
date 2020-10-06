package com.company;

public class IdentityHandler implements EmployeeHandler{
    @Override
    public Employee handleEmployee(Employee employee) {
        return employee;
    }
}
