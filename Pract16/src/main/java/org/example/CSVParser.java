package org.example;

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

    CSVParser(String path) throws IOException {
        reader = new BufferedReader(
                    new FileReader(path));
        String line;
        bankingUnits = new ArrayList<BankingUnit>();

        while((line = reader.readLine())!=null){
            try {
                bankingUnits.add(new BankingUnit(line));
            }
            catch (Exception a){
                System.out.println(a);
            }
        }


    }



}
