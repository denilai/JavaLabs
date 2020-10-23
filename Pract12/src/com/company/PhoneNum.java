package com.company;

public class PhoneNum {
    private String regionCode;
    private String stateCode = "+7";
    private String userCode;
    private boolean state;

    PhoneNum(String someNum){
        String cleanNum = clean(someNum);
        state = validity(cleanNum);
        analyze(cleanNum);
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
            if (str.length() == 11) {
                regionCode = str.substring(1, 4);
                userCode = formatUserCode(str.substring(4, 11));
            }
            if (str.length() == 10) {
                regionCode = str.substring(0, 3);
                userCode = formatUserCode(str.substring(3, 10));
            }
        }
        else
            userCode = regionCode = stateCode =  "format error";
    }

    private String formatUserCode(String raw){
        return raw.substring(0,3) + "-" + raw.substring(3,5) + "-" + raw.substring(5,7);
    }

    private boolean validity(String str){
        if (str.length() == 11){
            if (str.charAt(0) == '7' || str.charAt(0) == '8')
                return true;
        }
        if(str.length() == 10){
            if(str.charAt(0) == 9)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(state)
            return stateCode + " (" + regionCode + ") " + userCode;
        else return "Неверный формат номера";
    }
}
