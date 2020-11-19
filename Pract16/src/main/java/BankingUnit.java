import java.nio.DoubleBuffer;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class BankingUnit {

    private String accountType; // Тип счета        FIELD #0
    private String accountNumber; // Номер счета    FIELD #1
    private String currency; // Валюта              FIELD #2
    private Date date;//                            FIELD #3
    private String reference;//                     FIELD #4
    private String operationsDescription;//         FIELD #5
    private float income;//                         FIELD #6
    private float expense;//                        FIELD #7


    public BankingUnit(String line) throws Exception {
        int field=0;
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            String data = scanner.next();
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
                    break;
                }
                case 6:{
                    income = Float.parseFloat(data);
                    break;
                }
                case 7:{
                    expense = Float.parseFloat(data);
                    break;
                }
                default:{
                    throw new Exception("BankingUnit parse error");
                }
            }
            field ++;
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public float getExpense() {
        return expense;
    }

    public float getIncome() {
        return income;
    }

    public String getOperationsDescription() {
        return operationsDescription;
    }

    public String getReference() {
        return reference;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "BankingUnit{" +
                "\naccountType='" + accountType + '\'' +
                "\naccountNumber='" + accountNumber + '\'' +
                "\ncurrency='" + currency + '\'' +
                "\ndate=" + date +
                "\nreference='" + reference + '\'' +
                "\noperationsDescription='" + operationsDescription + '\'' +
                "\nincome=" + income +
                "\nexpense=" + expense +
                "\n}";
    }
}
