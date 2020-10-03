package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class PractWorks {

    private int sumOfElements(Scanner in){
        // посчитать сумму элементов целочисленного
        // массива с помощью циклов. Результат вывести
        out.println("Practical work #1");
        out.print("Set size of array> ");
        int n = in.nextInt();
        int[] input = new int[n];
        out.print("Get " + n + " numbers> ");
        for (int i = 0; i < input.length; i++) {
            input[i] = in.nextInt();
        }
        out.print("Your array> ");
        out.println(Arrays.toString(input));
        int sum = Arrays.stream(input).sum();
        out.print("Sum of elements in your array = " + sum);
        return sum;
    }

    private int[] representArrayMath(){
        out.println("***The size of array belongs to the [4,10]");
        out.println("***The size of array belongs to the [0,100]");
        int minSize = 4, maxSize = 10, minElem = 0, maxElem = 100;
        int size1 = minSize + (int)(Math.random() * maxSize);
        int[] array = new int [size1];
        for (int i=0; i < array.length; i++)
            array[i] = minElem + (int) (Math.random() * maxElem);

        out.println("Unsorted array> ");
        out.println(Arrays.toString(array));
        Arrays.sort(array);

        out.println("Sorted array> ");
        out.println(Arrays.toString(array));
        out.print("\n\n");
        return array;
    }

    private int[] representArrayRandom(){
        Random random = new Random();

        out.println("***The size of array belongs to the [4,10]");
        out.println("***The size of array belongs to the [0,100]");
        int minSize = 4, maxSize = 10, minElem = 0, maxElem = 100;
        int size1 = minSize + random.nextInt(maxSize);
        int[] array = new int [size1];
        for (int i=0; i < array.length; i++)
            array[i] = minElem + random.nextInt(maxElem);

        out.println("Unsorted array> ");
        out.println(Arrays.toString(array));
        Arrays.sort(array);

        out.println("Sorted array> ");
        out.println(Arrays.toString(array));
        out.print("\n\n");
        return array;
    }

    private static boolean yesNo(Scanner in){
        out.println("Try practice again? (y/n)");
        while(!in.hasNext("[yn]")){
            out.println("This isn`t case!\nChose 'yes' or 'no'>");
            in.next();
        }
        String inp = in.next();
        return (inp == "y");
    }

    private void sortArray(){
        out.println("Create random array with Math.random() method:\n");
        int [] array1 = representArrayMath();
        out.println("Create random array with class Random:\n");
        int [] array2 = representArrayRandom();
    }

    private int fac (int arg){
        if (arg <= 1)
            return 1;
        int answer = 1;
        for(int count = 1; count <= arg; count ++){
            answer = count * answer;
        }
        return answer;
    }

    public void practWork1(Scanner in) {
        boolean answer = true;
        // посчитать сумму элементов целочисленного
        // массива с помощью циклов. Результат вывести
        out.println("Practical work #1");
        do {

            out.println("Select task in the work> ");

            out.println("\t| Task # 1 - Find sum of element in integer array");
            out.println("\t| Task # 2 - Sort array of integer");
            out.println("\t| Task # 3 - Find factorial of number");

            int task = in.nextInt();
            switch (task) {
                case 1:
                    sumOfElements(in);
                    break;
                case 2:
                    sortArray();
                    break;
                case 3:
                    out.println("Get number to calculate the factorial> ");
                    int n = in.nextInt();
                    while (n < 0) {
                        out.println("Get positive number!> ");
                        n = in.nextInt();
                    }
                    int facN = fac(n);
                    out.println(n + "! = " + facN);
                    break;
                case 4:
                    break;
                default:
                    out.println("ERROR");
                    break;
            }
            answer = yesNo(in);

        } while (answer);
    }
}
