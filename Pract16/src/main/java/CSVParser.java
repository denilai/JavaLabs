import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVParser {

    private BufferedReader reader;
    private Scanner scanner;
    private float totalIncome;
    private float totalExpenses;
    ArrayList<BankingUnit> bankingUnits;



    CSVParser(String path)  {
        try {
            reader = new BufferedReader(
                    new FileReader(path));

            String line;
            bankingUnits = new ArrayList<BankingUnit>();
            String g = reader.readLine();
            while ((line = reader.readLine()) != null) {
                try {
                    bankingUnits.add(new BankingUnit(line));
                } catch (Exception a) {
                    System.out.println(a);
                }
            }
        }
        catch (IOException a){
                System.out.println(a);
        }

    }



}
