import java.util.Arrays;
import java.util.Random;

public class Animal {
    private int  number = 4;
    int sum(int a, int b){
        return a+b;
    }

    void mes (String message){
        System.out.println(message);
    }
}

class App {
    public static void main(String[] args) {
        // 3) вывести аргументы командной строки в цикле for
        for (int i = 0; i < 10; i++) {
            System.out.print(harmonic(i));
        }

        int [] array = new int[] {1,2,3,4,58,6,3,6};
        Arrays.sort (array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }



    // n- количество слагаемых в гармоническом ряду
    public static String harmonic (int n){
        return ("1/"+n+" ");

    }
}
