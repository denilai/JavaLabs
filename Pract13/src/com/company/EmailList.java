package com.company;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {
    TreeSet<String> emails;

    EmailList(){
        emails = new TreeSet<>();
    }

    public boolean add (String email){
        if (isValid(email)){
            emails.add(email);
            return true;
        }
        else return false;
    }
    private boolean isValid(String email){
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean print(){
        if (emails.isEmpty()) {
            System.out.println("Empty");
            return true;
        }
        int[] a = new int[1];
        emails.forEach(task -> {
            System.out.println(++a[0] + " - " + task);
        });
        return true;
    }
}
