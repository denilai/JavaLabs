package denilai.rtu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {
    private final Map<String,Account> accounts;
    private final BigDecimal withoutVerification;

    public Bank(){
        accounts = new HashMap<>();
        withoutVerification = new BigDecimal(50_000);
    }

    public synchronized void addAccount(Account account) {
        if( !accounts.containsKey( account.getAccNumber() ) ) {
            accounts.put( account.getAccNumber(), account );
        }
    }


    public void transfer(String fromID, String toID, BigDecimal amount) {
        synchronized (accounts) { // гарантируется равенство денег на всех
                                 // счетах при синхронизации по accounts
            try {
                BigDecimal preAmount = moneyInBank();
                Account from = accounts.get(fromID);
                Account to = accounts.get(toID);

                if (!from.isEnabled() || !to.isEnabled()) {
                    System.out.println("=== Transfer is not approved. Some account is blocked ===");
                    return;
                }

                System.out.println("Transfer:");
                System.out.println(from.getAccNumber() + " -> " + amount.toString() + " y.e. -> " + to.getAccNumber());

                if (amount.compareTo(withoutVerification) > 0 && isFraud()) {

                    System.out.println("=== Transfer is not approved ===");
                    System.out.println("=== Security system blocked " + fromID+ " and " + toID + " ===");

                    to.block();
                    from.block();
                    return;
                }

                try {
                    from.spend(amount);
                    to.receive(amount);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                BigDecimal postAmount = moneyInBank();
                if (postAmount.compareTo(preAmount) != 0) {
                    throw new Exception("The balance on all accounts is different");
                }

                System.out.println("Balance of " + from.getAccNumber() + " is " + from.getBalance());
                System.out.println("Balance of " + to.getAccNumber() + " is " + to.getBalance());
            } catch (NullPointerException e) {
                System.out.println("=== ID is invalid. Transfer is not approved ===");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private boolean isFraud() {
        Random random = new Random();
        try {
            Thread.sleep(1_000);
            return random.nextBoolean();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public BigDecimal getBalance(String accNum){
        return accounts.get(accNum).getBalance();
    }

    public synchronized BigDecimal moneyInBank(){
        BigDecimal[] sum = new BigDecimal[1];
        sum[0] = new BigDecimal(0);
        accounts.values().forEach(el -> sum[0] = sum[0].add(el.getBalance()));
        return sum[0];
    }

}
