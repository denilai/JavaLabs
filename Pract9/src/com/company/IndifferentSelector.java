package com.company;

public class IndifferentSelector implements EmployeeSelector{
    @Override
    public boolean need(Employee employee) {
        return true;
    }
}
