package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Employee {
    // FIELDS
    private String fstName;
    private String sndName;
    private Date birthdate;
    private String address;
    private String phoneNumber;
    private double salary;
    private SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMMM d, yyyy", Locale.ENGLISH);

    // METHODS

    Employee(String fstName, String sndName, String dataStr, String address, String phoneNumber, double salary){
        this.fstName = fstName;
        this.sndName = sndName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        try {
            birthdate = formatter.parse(dataStr);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }

    String getBirthdate(){
        return formatter.format(birthdate);
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getFstName() {
        return fstName;
    }

    public String getSndName() {
        return sndName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fstName='" + fstName + '\'' +
                ", sndName='" + sndName + '\'' +
                ", birthdate=" + getBirthdate() +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
