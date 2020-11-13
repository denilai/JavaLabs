package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CarNumberGenerator {

    private ArrayList<String> letterSet;

    private ArrayList<Integer> regionSet;

    private ArrayList<String> carNumbers;

    public CarNumberGenerator(){
        letterSet = new ArrayList<>(Arrays.asList("A","B","C","E","K","M","H","O","P","T","Y","X"));
        carNumbers = new ArrayList<>();
        createList();
    }

    public int count(){
        return carNumbers.size();
    }

    public void createList(){
       carNumbers.addAll(similarLetAndTrio());
       carNumbers.addAll(serialLetAndSimilarTrio());
       carNumbers.addAll(similarLetButRandDig());
    }

    public ArrayList<String> getCarNumbers() {
        return carNumbers;
    }

    ArrayList<String> similarLetAndTrio(){
        ArrayList<String> numbers = new ArrayList<>();
        Iterator iterator = letterSet.iterator();
        String template,letter;
        while(iterator.hasNext()) {
            letter = (String) iterator.next();
            for (int i = 0; i <= 9; i++) {
                for (int reg = 1; reg <= 199; reg++) {
                    if (reg < 100)
                        template = "%s%d%d%d%s%s%02d";
                    else
                        template = "%s%d%d%d%s%s%03d";
                    numbers.add(String.format(
                            template,
                            letter,
                            i,i,i,
                            letter, letter,
                            reg
                    ));
                }
            }
        }
        return numbers;
    }

    ArrayList<String> serialLetAndSimilarTrio(){
        ArrayList<String> numbers = new ArrayList<>();
        Iterator iterator = letterSet.iterator();
        String template, letter,trio;
        for(int dig = 0;dig<=9;dig++) {
            for (int i = 0; i < letterSet.size() - 2; i++) {
                for (int j = i + 1; j < letterSet.size() - 1; j++) {
                    for (int reg = 1; reg <= 199; reg++) {
                        if (reg < 100)
                            template = "%s%s%s%s%02d";
                        else
                            template = "%s%s%s%s%03d";
                        trio = Integer.toString(dig)+Integer.toString(dig)+Integer.toString(dig);
                        numbers.add(String.format(template,
                                letterSet.get(i),
                                trio,
                                letterSet.get(j),letterSet.get(j+1),
                                reg));
                    }
                }

            }
        }
        return numbers;
    }

    ArrayList<String> similarLetButRandDig(){
        ArrayList<String> numbers = new ArrayList<>();
        Iterator iterator = letterSet.iterator();
        String template, letter,trio;
        while(iterator.hasNext()) {
            letter = (String) iterator.next();
            for (int i = 0; i < 999; i++){
                for(int reg = 1;reg<200;reg++){
                    if (reg < 100)
                        template = "%s%d%s%s%02d";
                    else
                        template = "%s%d%s%s%03d";
                    if((i==0 || (i<100&&i%11!=0) || (i>100&&i%111!=0)))
                    numbers.add(String.format(template,
                            letter,
                            i,
                            letter,letter,
                            reg
                            ));
                }
            }
        }

        return numbers;
    }

    @Override
    public String toString() {
        return "CarNumberGenerator{" +
                "carNumbers=" + carNumbers +
                '}';
    }
}
