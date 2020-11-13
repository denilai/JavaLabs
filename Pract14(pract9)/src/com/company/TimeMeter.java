package com.company;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;

public class TimeMeter {
    static public long elapsedTime (Function<String,Boolean> search, String num){
        long start = System.nanoTime();
        boolean f = search.apply(num);
        long finish = System.nanoTime();
        if (f)
            System.out.println("Элемент найден");
        else
            System.out.println("Элемент не найден");
        long elapsed = finish - start;
        return elapsed;
    }
}
