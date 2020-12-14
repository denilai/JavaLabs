package denilai.rtu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        int countOfClients = 100;
        randomAccounts(countOfClients).forEach(bank::addAccount);
        Random random = new Random();

        BankOnSteroids rnblBank = new BankOnSteroids(bank);

        Thread mainThread =  new Thread(rnblBank);
        mainThread.start();

        for(int i = 0;i<100;i++){
            String from = "Client # "+ random.nextInt(countOfClients);
            String to = "Client # "+ random.nextInt(countOfClients);
            BigDecimal amount = new BigDecimal(random.nextInt(100_000));
            while (to.equals(from)){
                to = "Client # "+ random.nextInt();
            }
            rnblBank.addTransaction(from,to,amount);

        }

    }

    public static ArrayList<Account> randomAccounts(int countOfClients){
        Random random = new Random();
        random.nextInt(10);
        ArrayList<Account> accounts = new ArrayList<>();
        for(int i = 0;i<countOfClients;i++){
            accounts.add(
                    new Account(
                            "Client # " + i,
                            new BigDecimal(random.nextInt(1_000)+100_000)
                    )
            );
        }
        return accounts;
    }



}
