package com.company;

import com.sun.source.tree.BreakTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNum {

    private String regionCode;
    private String stateCode = "8";
    private String userCode;
    private String number;
    private boolean state;

    private boolean validity(String num){
        Pattern pattern =  Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }

    public boolean getStatus(){
        return state;
    }

    PhoneNum(String someNum){
        state = validity(clean(someNum));
        analyze(clean(someNum));
    }

    static String clean(String dirty){
        String clear = new String();
        for(char ch:dirty.toCharArray()){
            if (ch>='0' && ch<='9')
                clear = clear + new String(String.valueOf(ch));
        }
        return clear;
    }

    private void analyze(String str){
        if(state) {
//            if (str.length() == 11) {
//                regionCode = str.substring(1, 4);
//                userCode = formatUserCode(str.substring(4, 11));
//            }
//            if (str.length() == 10) {
//                regionCode = str.substring(0, 3);
//                userCode = formatUserCode(str.substring(3, 10));
//            }
            number = str;
            if (number.toCharArray()[0]=='7')
                number = "+" + number;
        }
        else
            userCode = regionCode = stateCode =  "format error";
    }

    private String formatUserCode(String raw){
        return raw.substring(0,3) + "-" + raw.substring(3,5) + "-" + raw.substring(5,7);
    }


    @Override
    public String toString() {
        if(state)
            return number;
        else return "Invalid number format";
    }
}
