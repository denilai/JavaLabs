package denilai.rtu;

import java.math.BigDecimal;

public class Account {

    private BigDecimal money;
    private final String accNumber;
    private boolean enabled;

    public Account(String alias, BigDecimal amount){
        enabled = true;
        money = amount;
        accNumber = alias;
    }

    public String  getAccNumber() {
        return accNumber;
    }

    public synchronized void spend(BigDecimal amount){
        if (isEnabled())
            money = money.subtract(amount);
    }

    public synchronized void receive(BigDecimal amount){
        if (isEnabled())
            money = money.add(amount);
    }

    public void block(){
        enabled = false;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public synchronized BigDecimal getBalance() {
        return money;
    }
}
