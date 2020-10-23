package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SalaryParser {

    private String text;
    private String[]words;
    private LinkedHashMap <String, Integer> namesMap;

    public String getText() {
        return text;
    }

    public SalaryParser(String text){

        this.text = text;
        this.words = words(text);
        this.namesMap = namesMap(text);
    }

    public LinkedHashMap <String, Integer> namesMap (String text){
        LinkedHashMap <String, Integer> namesMap = new LinkedHashMap<>();
        int i = 0;
        for (String word:words(text)){
            if (Character.isUpperCase(word.charAt(0)))
                namesMap.put(word,i);
            i ++;
        }
        return namesMap;
    }

    public int someoneSalary(String name){
        if (!namesMap.containsKey(name))
            return -1;
        int salary = 0;
        int from = namesMap.get(name);
        for( int i = from+1; i < words.length; i++){
            if(!namesMap.containsKey(words[i])) {
                try {
                    salary = Integer.parseInt(words[i]);
                }
                catch (NumberFormatException a) { }
            }
            else break;
        }
        return salary;
    }

    public String[] words (String line){
        return line.trim().split(" ");
    }
}
