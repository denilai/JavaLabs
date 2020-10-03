package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Author myself = new Author();
        myself.introduce();
        PractWorks practice = new PractWorks();
        practice.practWork1(in);
    }
}
