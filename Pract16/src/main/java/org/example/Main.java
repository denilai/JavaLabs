package org.example;

public class Main {

    public static void main(String [] args){
        String pathToCSV = "\\resources\\movementList.csv";

        try {
            CSVParser parser = new CSVParser(pathToCSV);
        }
        catch (Exception a){
            System.out.println(a);
        }

    }


}
