import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.Collections;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Animal {
    private final int number = 4;

    int sum(final int a, final int b) {
        return a + b;
    }

    void mes(final String message) {
        System.out.println(message);
    }
}

class App {
    public static void main(final String[] args) throws NoSuchAlgorithmException {
        task3();
        task4(args);
        task5();
        tack6();
    }

    public static void task3() {
        System.out.println("Task #3");

        // 3) вычислить сумму элементов целочисленного массива
        // с помощью циклов
        final ArrayList<Integer> array1 = myGetArray();
        final Integer sum = mySumArray(array1);

    }

    public static void task4(final String[] args) {
        // 4) вывести аргументы командной строки в цикле for
        for (int i = 0; i < 10; i++) {
            System.out.print(args);
        }
    }

    public static void task5() {
        // 5) Написать программу, в результате работы которой
        // выводятся на экран первые 10 чисел гармонического ряда

        for (int i = 0; i < 10; i++) {
            System.out.print(harmonic(i));
        }
    }

    public static void tack6() throws NoSuchAlgorithmException {
        // 6) Написать программу, в результате которой
        // генерируется массив целых чисел случайным образом,
        // вывести его на экран, отсортировать его, и снова
        // вывести на экран

        System.out.println("Using Random class ->");
        Random random = SecureRandom.getInstanceStrong();
        final ArrayList<Integer> arr = new ArrayList<>(random.nextInt());
        for (int i=0;i<arr.size();i++){
            arr.add(random.nextInt());
        }
        System.out.println("Before sorting");
        for (int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+' ');
        }
        Collections.sort(arr);
        System.out.println("After sorting");
        for (int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+' ');
        }

        System.out.println("Using Math class ->");

        ArrayList <Integer> arrM = new ArrayList<>();
        for (int i=0;i<randomInARange(0, 20);i++){
            arrM.add(randomInARange(-100, 100));
        }

        System.out.println("Before sorting");
        for (int i=0;i<arr.size();i++){
            System.out.print(arrM.get(i)+' ');
        }
        Collections.sort(arr);
        System.out.println("After sorting");
        for (int i=0;i<arr.size();i++){
            System.out.print(arrM.get(i)+' ');
        }

    }
    
    // получение случайного числа средствами класса Math
    static int randomInARange(int min, int max) {
        return  (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static ArrayList<Integer> myGetArray() {
        final Scanner input = new Scanner(System.in);
        int size = -1;
        while (size <0){
            String n = input.nextLine();
            try {
                size = Integer.parseInt(n);
            }
            catch (NumberFormatException e)
            {
                size = 0;
            }
        }
        final ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Get element");
            final int x = input.nextInt();
            array.add(x);
        }
        input.close();
        return array;
    }

    public static Integer mySumArray(final ArrayList<Integer> arr) {
        Integer sum = 0;
        while (!arr.isEmpty()) {
            sum += arr.remove(0);
        }
        return sum;
    }

    // n- количество слагаемых в гармоническом ряду
    public static String harmonic(final int n) {
        return ("1/"+n+" ");

    }
}
