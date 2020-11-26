package denilai.rtu.app;
import denilai.rtu.app.adapt.SubwayAdapter;
import denilai.rtu.app.parse.FileMaster;
import denilai.rtu.app.parse.SubwayParser;
import denilai.rtu.subway.MoscowSubway;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    private static final String PATH_TO_RESOURCES = "src\\main\\resources";
    private static final String PATH_TO_JSON = "src\\main\\resources\\subway.json";
    private static final String mosMetro = "https://www.moscowmap.ru/metro.html#lines";


    public static int task(){
        boolean check = false;
        int answer =0;
        do{
            Scanner sc = new Scanner(System.in,"UTF-8");
            System.out.println("\n\n==== Parsing from https://www.moscowmap.ru ====");
            System.out.println("====             Select option             ====");
            System.out.println("1) Start");
            System.out.println("3) EXIT");
            System.out.println("===============================================\n");
            try{
                answer = sc.nextInt();
                if (answer<1 || answer>3)
                    throw new MenuException("That task isn't exist");
                check = true;
            }
            catch (InputMismatchException e){
                System.out.println("this isn't a number.Try again!");
                check =  false;
            }
            catch (MenuException a){
                a.printStackTrace();
                check =  false;
            }
        }while(!check);
        return answer;
    }
    public static boolean execute (int answer){

        boolean check;
        switch (answer){
            case 1: {
                Scanner in = new Scanner(System.in,"UTF-8");
                String chs;
                do {
                    System.out.println("Connecting to "+mosMetro+"...\n");
                    try {
                        System.out.println("Parsing subway station...");
                        MoscowSubway subway = SubwayParser.parseSubwayResource(mosMetro);
                        String json = SubwayAdapter.serializeSubway(subway);

                        System.out.println("Write .json string to "+PATH_TO_RESOURCES);
                        System.out.println("=== Serialize subway object ===\n\n");

                        FileMaster.deleteAllFilesFolder(PATH_TO_RESOURCES);
                        System.out.println(PATH_TO_JSON+ " folder is definitely empty");
                        FileMaster.writeToFile(PATH_TO_JSON,json);

                        String json2 = FileMaster.readFromFile(PATH_TO_JSON);

                        System.out.println("\n\n=== Deserialize subway object ===");
                        MoscowSubway subway2 = SubwayAdapter.deserializeSubway(json2);
                        System.out.println("Object is ready\n");

                        System.out.println("");
                        subway2.stationOnEachLineReport();
                    }
                    catch( IOException | NullPointerException ex){

                        System.out.println(ex.getMessage());
                    }

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
