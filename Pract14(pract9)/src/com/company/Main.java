package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarNumberSnoopy numberFinder = new CarNumberSnoopy(new CarNumberGenerator());
        System.out.println("Список номеров создан и содержит " + numberFinder.generator.count() + " элементов");
        System.out.println("Список вспомогательных контейнеров создан");
        System.out.print("Введите элемент для поиска> ");
        String str = sc.nextLine();
        System.out.println("Время прямого перебора, нс =" + TimeMeter.elapsedTime(numberFinder::directSearch,str));

        System.out.println("Время бинарного поиска, нс = " + TimeMeter.elapsedTime(numberFinder::binarySearch,str));

        System.out.println("Время поиска в HashSet, нс = " + TimeMeter.elapsedTime(numberFinder::hashSetSearch,str));

        System.out.println("Время поиска в Tree Set, нс = " + TimeMeter.elapsedTime(numberFinder::treeSetSearch,str));
    }
}
