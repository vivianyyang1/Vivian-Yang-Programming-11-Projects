/*This program is the class for Customers
 *Creator: Vivian Yang
 *Date: August 25, 2022
 */
import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor

    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //my constructor code
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        this.name = name;
        this.accountNumber = accountNumber;
        checkBalance = checkDeposit;
        savingBalance = savingDeposit;
        savingRate = 0.015;
    }

    public double deposit(double amt, Date date, String account){
        //my code for deposit double
        if(account.equals(CHECKING)) checkBalance += amt;
        else savingBalance += amt;

        Deposit dp = new Deposit(amt, date, account);
        deposits.add(dp);

        return 0;
    }
    public double withdraw(double amt, Date date, String account){
        //my code for withdraw double
        if (checkOverdraft(amt, account) == true) {
            if(account.equals(CHECKING)) checkBalance -= amt;
            else savingBalance -= amt;
            Withdraw wd = new Withdraw(amt, date, account);
            withdraws.add(wd);
        }
        return 0;
    }
    private boolean checkOverdraft(double amt, String account){
        //my code for Overdraft possibility
        boolean rtrn = false;
        if (account.equals(CHECKING)) {
            if (checkBalance - amt >= OVERDRAFT) {
                rtrn = true;
            }
        }
        else {
            if (savingBalance - amt >= OVERDRAFT) {
                rtrn = true;
            }
        }
        return rtrn;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    //Getters and Setters for saving/checking account balances
    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    //Getters and Setters for deposit and withdrawal array lists
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(ArrayList<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }


}
