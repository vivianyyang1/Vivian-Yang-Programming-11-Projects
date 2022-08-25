import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public String toString(){
        //format of Withdraw.toString()
        return "Withdrawal of: $" + amount + " Date: " + date.toString() + " into account: " + account;
    }
}
