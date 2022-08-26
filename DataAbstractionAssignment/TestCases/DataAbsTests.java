/*This program tests some of the methods in the Customer class
 *Creator: Vivian Yang
 * Date: August 25, 2022
 */
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DataAbsTests {
    //declare our variables
    Deposit deposit;
    Calendar calendar;
    Withdraw withdraw;
    Customer customer;

    @Before
    public void setup(){//setup for before
        calendar = Calendar.getInstance();
    }

    //Requires: Deposit object
    //Modifies: Deposit object
    //Effects: test if Deposit.toString() works for turning a Deposit object into a String value as expected
    @Test
    public void testDepToString() {//Deposit.toString()
        Date date = new Date();         //deposit date
        calendar.setTime(date);
        deposit = new Deposit(100, date, Customer.CHECKING);//value to deposit
        assertEquals(deposit.toString(), "Deposit of: $100.0" + " Date: " + date.toString() + " into account: Checking");

        deposit = new Deposit(200, date, Customer.SAVING);//value to deposit
        assertEquals(deposit.toString(), "Deposit of: $200.0" + " Date: " + date.toString() + " into account: Saving");
    }

    //Requires: Withdraw object
    //Modifies: Withdraw object
    //Effects: test if Withdraw.toString() works for turning a Withdraw object into a String value as expected
    @Test
    public void testWitToString() {//Withdraw.toString()
        Date date = new Date();         //deposit date
        calendar.setTime(date);
        withdraw = new Withdraw(100, date, Customer.SAVING);//value to withdrawal
        assertEquals(withdraw.toString(), "Withdrawal of: $100.0 " + "Date: " + date.toString() + " into account: Saving");

        withdraw = new Withdraw(50, date, Customer.CHECKING);//value to withdrawal
        assertEquals(withdraw.toString(), "Withdrawal of: $50.0 " + "Date: " + date.toString() + " into account: Checking");
    }

    //Requires: Customer object
    //Modifies: Customer object
    //Effects: test if Customer.deposit() updates balance after a deposit is applied
    @Test
    public void testCustDep() {     //Customer.deposit() (checks balance)
        customer = new Customer("Vivian Yang", 111, 0, 0);//value to customer
        Date date = new Date();         //deposit date
        calendar.setTime(date);
        assertEquals(customer.deposit(100, date, Customer.SAVING), 100.0, 0.00);//balance should be $100
        assertEquals(customer.getDeposits().size(), 1);//tests if deposits ArrayList holds one element now

        assertEquals(customer.deposit(50, date, Customer.CHECKING), 50.0, 0.00);//balance should be $100
        assertEquals(customer.getDeposits().size(), 2);//tests if deposits ArrayList holds two elements now
    }

    //Requires: Customer object
    //Modifies: Customer object
    //Effects: test if Customer.withdraw() updates balance after a withdrawal is applied, and also if it works with overdraft
    @Test
    public void testCustWit() {//Customer.withdraw() (checks balance)
        customer = new Customer("Vivian Yang", 111, 0, 0);//value to customer
        Date date = new Date();
        calendar.setTime(date);
        //withdrawal without overdraft (SAVING)
        assertEquals(customer.deposit(100, date, Customer.SAVING), 100.0, 0.00);//balance should be $100
        assertEquals(customer.withdraw(50, date, Customer.SAVING), 50.0, 0.00);//balance should be $50
        assertEquals(customer.getWithdraws().size(), 1);//tests if withdraw ArrayList holds one element now
        //withdrawal without overdraft (CHECKING)
        assertEquals(customer.deposit(50, date, Customer.CHECKING), 50.0, 0.00);//balance should be $50
        assertEquals(customer.withdraw(25, date, Customer.CHECKING), 25.0, 0.00);//balance should be $25
        assertEquals(customer.getWithdraws().size(), 2);//tests if withdraw ArrayList holds two elements now

        //withdrawal with overdraft (SAVING)
        assertEquals(customer.withdraw(150, date, Customer.SAVING), -100.0, 0.00);//balance should be $-100
        assertEquals(customer.getWithdraws().size(), 3);//tests if withdraw ArraylIst holds three elements now
        //withdrawal with overdraft (CHECKING)
        assertEquals(customer.withdraw(50, date, Customer.CHECKING), -25.0, 0.00);//balance should be $-25
        assertEquals(customer.getWithdraws().size(), 4);//tests if withdraw Arraylist holds four elements now

}
}
