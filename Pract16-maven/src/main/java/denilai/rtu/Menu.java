package denilai.rtu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    public static int task(){
        boolean check = false;
        int answer =0;
        do{
            Scanner sc = new Scanner(System.in,"UTF-8");
            System.out.println("==== Select task ====");
            System.out.println("1) Report on banking operations");
            System.out.println("2) HTTP parse");
            System.out.println("3) EXIT");
            try{
                answer = sc.nextInt();
                if (answer<1 || answer>3)
                    throw new MyException ("That task isn't exist");
                check = true;
            }
            catch (InputMismatchException e){
                System.out.println("this isn't a number.Try again!");
                check =  false;
            }
            catch (MyException a){
                a.printStackTrace();
                check =  false;
            }
        }while(!check);
        return answer;
    }
    public static boolean execute (int answer){
        switch (answer){
            case 1: {
                Scanner in = new Scanner(System.in,"UTF-8");
                String chs;
                do {
                    String pathToCSV = "src\\main\\resources\\movementList.csv";
                    CSVParser parser = new CSVParser(pathToCSV);
                    parser.getReport();
                    boolean check;
                    do {
                        check = true;
                        System.out.println("Repeat the task? (y or n)> ");
                        chs = in.nextLine();
                        if (!(chs.equals("y") || chs.equals("n"))) {
                            System.out.println("This answer is not exist.\nTry again");
                            check = false;
                        }
                    }while (!check) ;
                }while (chs.equals("y"));
                break;
            }
            case 2:{
                Scanner in = new Scanner(System.in,"UTF-8");
                String chs;
                do {
                    ArrayList<String> downloadedImagesNames =
                            new ArrayList<>(JsoupDownloadImages.parseImageFromResources());
                    System.out.println("==== List of uploaded images: ====");
                    downloadedImagesNames.forEach(System.out::println);
                    boolean check;
                    do {
                        check = true;
                        System.out.println("Repeat the task? (y or n)> ");
                        chs = in.nextLine();
                        if (!(chs.equals("y") || chs.equals("n"))) {
                            System.out.println("This answer is not exist.\nTry again");
                            check = false;
                        }
                    }while (!check) ;
                }while (chs.equals("y"));
                break;
            }
            case 3: {
                System.out.println("Program finished...");
                return false;
            }
        }
        System.out.println("==== Program loop ====");
        return true;
    }
}
