package denilai.rtu;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class BankOnSteroids implements Runnable {

    private final Bank bank;
    private final Queue<Thread> transactionQueue;
    private final Queue<Thread> addQueue;

    public BankOnSteroids(Bank bank) {
        this.bank = bank;
        transactionQueue = new ArrayDeque<>();
        addQueue = new ArrayDeque<>();
    }


    @Override
    public void run() {
        while (true){
            try {
                synchronized (addQueue) {
                    if (addQueue.size() != 0)
                        addQueue.poll().start();
                }
                synchronized (transactionQueue) {
                    if (transactionQueue.size() != 0)
                        transactionQueue.poll().start();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    public void addTransaction(String fromID, String toID, BigDecimal amount){
        transactionQueue.add(new Thread(()->{
            bank.transfer(fromID, toID, amount);
        }));
    }
}
