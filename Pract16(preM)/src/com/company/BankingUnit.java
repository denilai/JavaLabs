package com.company;

import java.text.*;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankingUnit {

    private String accountType; // Тип счета        FIELD #0
    private String accountNumber; // Номер счета    FIELD #1
    private String currency; // Валюта              FIELD #2
    private Date date;//                            FIELD #3
    private String reference;//                     FIELD #4
    private String operationsDescription;//         FIELD #5
    private String organization;// Организация (подполе FIELD #5)
    private Double income;//                         FIELD #6
    private Double expense;//                        FIELD #7


    public BankingUnit(String line) throws Exception {
        int field=0;
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String data = scanner.next();
            if (data.contains("\"")){
                data = data + "." +scanner.next();
            }
            switch (field){
                case 0:{
                    accountType = data;
                    break;
                }
                case 1:{
                    accountNumber = data;
                    break;
                }
                case 2:{
                    currency = data;
                    break;
                }
                case 3:{
                    date = new SimpleDateFormat("dd.MM.yy").parse(data);
                    break;
                }
                case 4:{
                    reference = data;
                    break;
                }
                case 5:{
                    operationsDescription = data;
                    Scanner orgScanner = new Scanner(data);
                    orgScanner.useDelimiter(Pattern.compile("[\\\\/]"));
                    String info = null;
                    while(orgScanner.hasNext()){
                        info = orgScanner.next();

                    }
                    organization = info;
                    int a = info.indexOf("        ");
                    organization = info.substring(0,a).trim();

                    break;
                }
                case 6:{
                    income = Double.parseDouble(data);//myParseDouble(data);
                    break;
                }
                case 7:{
                    expense = Double.parseDouble(data.replace("\"",""));//myParseDouble(data);
                    break;
                }
                default:{
                    throw new Exception("BankingUnit parse error: " + data);
                }
            }
            field ++;
        }
    }

    public String getOrganization() {
        return organization;
    }

    public String getAccountType() { return accountType; }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getExpense() { return expense; }

    public Double getIncome() {
        return income;
    }

    public String getOperationsDescription() {
        return operationsDescription;
    }

    public String getReference() {
        return reference;
    }

    public Date getDate() { return date; }

    @Override
    public String toString() {
        return "BankingUnit{" +
                "\naccountType='" + accountType + '\'' +
                "\naccountNumber='" + accountNumber + '\'' +
                "\ncurrency='" + currency + '\'' +
                "\ndate=" + date +
                "\nreference='" + reference + '\'' +
                "\noperationsDescription='" + operationsDescription + '\'' +
                "\norganization='" + organization + '\''+
                "\nincome=" + income +
                "\nexpense=" + expense +
                "\n}";
    }

//    public static Double myParseDouble(String value){
//
//        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
//        dfs.setDecimalSeparator('.');
//        DecimalFormat df = new DecimalFormat();
//        df.setDecimalFormatSymbols(dfs); // point as a separator
//        try {
//            return (Double) df.parse(value);
//        }
//        catch ( Exception e ) {
//            System.out.println("Fail on " + value);
//        }
//        dfs.setDecimalSeparator(',');
//        df.setDecimalFormatSymbols(dfs); // comma as a separator
//        try {
//            return (Double) df.parse(value);
//        }
//        catch ( Exception e ) {
//            System.out.println("Fail on " + value);
//        }
//        return null;
//    }

}
