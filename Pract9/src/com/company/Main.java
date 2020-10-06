package com.company;

public class Main {

    public static void main(String[] args) {

        Company company = new Company();
        company.hire(new Employee(
                "Stan","Norf",
                "Sat, April 4, 1997",
                "Ontario,St.1",
                "976725748112",
                123334));
        company.hire(new Employee("Gerald",
                "Trupper",
                "Mon, September 15, 1980",
                "Mexico, 12-s St.",
                "56275134",
                553561));

        System.out.println("List of employees is processed using interfaces in separated classes");


        // I
        // Обработка списка сотрудников с помощью классов,
        // наследующих интерфейсы обработчика и селектора

        IdentityHandler id = new IdentityHandler();
        IndifferentSelector indif = new IndifferentSelector();

        company.handleEmployee(indif,id);

        System.out.println("List of employees is processed using anonymous classes");


        // II
        // Обработка списка сотрудников с помощью
        // анонимных классов


        // Обработчик ID handler.handleEmployee(x) = x
        EmployeeHandler idHandler = new EmployeeHandler() {
            @Override
            public Employee handleEmployee(Employee employee) {
                return employee;
            }
        };

        // Безразличный, нечувствительный селектор.
        // indifSelector.need(x) = true
        EmployeeSelector indifSelector = new EmployeeSelector() {
            @Override
            public boolean need(Employee employee) {
                return true;
            }
        };

        company.handleEmployee(indifSelector,idHandler);

        System.out.println("List of employees is processed using lambda expressions");


        // III
        // Обработка списка сотрудников с помощью
        // Функциональных интерфейсов

        company.handleEmployee(el->true, el->el);

    }

}
