import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //format of Deposit.toString()
        return "Deposit of: $" + amount + " Date: " + date.toString() + " into account: " + account;
    }
}
