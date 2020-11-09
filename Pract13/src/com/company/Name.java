package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {
    private boolean state;
    private String name;

    Name(String rawName){
       if (state=validity(rawName))
           name = rawName;
       else name = "Pattern Error";
    }

    private boolean validity(String rawName){
        Pattern pattern = Pattern.compile("^([А-Я][а-яё]{1,23}|[A-Z][a-z]{1,23})$");
        Matcher matcher = pattern.matcher(rawName);
        return matcher.matches();
    }

    public boolean getStatus(){
        return state;
    }

    public String hisName(){
        return name;
    }
}
