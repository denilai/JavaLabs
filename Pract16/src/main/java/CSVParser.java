import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVParser {

    private BufferedReader reader;
    private Scanner scanner;
    private float totalIncome;
    private float totalExpenses;
    private ArrayList<BankingUnit> bankingUnits;

    public ArrayList<BankingUnit> getBankingUnits(){
        return bankingUnits;
    }

    CSVParser(String path)  {
        try {
            reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path),"windows-1251"));


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
