package com.company;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Dog {
    private String alias;
    private int birthYear;
    Dog(String alias, int age){
        this.alias = alias;
        this.birthYear = getCurrentYear() -  age;
    }

    private static int getCurrentYear()
    {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getAlias() {
        return alias;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    // метод переводит возраст собаки в человеческий эквивалент
    public int transposeAge(){
        return birthYear*7;
    }

    public String toString(){
        return "It's a "+ this.alias + " dog\nAge: " + (getCurrentYear() - this.birthYear)+"\n";
    }
}
