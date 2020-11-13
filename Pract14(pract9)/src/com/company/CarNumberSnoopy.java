package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Function;

public class CarNumberSnoopy {
    Instant start;
    Instant finish;

    CarNumberGenerator generator;
    ArrayList <String> forBinarySearch;
    HashSet<String> forHashSearch;
    TreeSet <String> forTreeSearch;

    CarNumberSnoopy(CarNumberGenerator generator){

        this.generator = generator;
        forBinarySearch = generator.getCarNumbers();
        Collections.sort(forBinarySearch, String::compareTo);
        forHashSearch = new HashSet<>(generator.getCarNumbers());
        forTreeSearch = new TreeSet<>(generator.getCarNumbers());
    }


    public boolean directSearch(String num){
        return generator.getCarNumbers().contains(num);
    }

    public boolean binarySearch(String num){
        return Collections.binarySearch(forBinarySearch, num) != -1;
    }

    public boolean hashSetSearch(String num){
        return forHashSearch.contains(num);
    }

    public boolean treeSetSearch(String num){
        return forTreeSearch.contains(num);
    }
}
