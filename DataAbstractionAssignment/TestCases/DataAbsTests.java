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
    Date dDate;
    Withdraw withdraw;
    Date wDate;
    Customer customer;

    @Before
    public void setup(){//setup for before
        dDate = new Date();//deposit date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dDate);
        deposit = new Deposit(100, dDate, Customer.CHECKING);//value to deposit
        wDate = new Date();//withdrawal date
        calendar.setTime(wDate);
        withdraw = new Withdraw(100, wDate, Customer.SAVING);//value to withdrawal
        customer = new Customer("Vivian Yang", 111, 0, 0);//value to customer
    }

    @Test
    public void testDepToString() {//Deposit.toString()
        assertEquals(deposit.toString(), "Deposit of: $100.0" + " Date: " + dDate.toString() + " into account: Checking");
    }

    @Test
    public void testWitToString() {//Withdraw.toString()
        assertEquals(withdraw.toString(), "Withdrawal of: $100.0 " + "Date: " + wDate.toString() + " into account: Saving");
    }

    @Test
    public void testCustDep() {//Customer.deposit() (checks balance)
        customer.deposit(100, dDate, Customer.SAVING);//deposits $100
        assertEquals(customer.getSavingBalance(), 100.0, 0.00);//balance should be $100
        assertEquals(customer.getDeposits().size(), 1);//tests array list
    }

    @Test
    public void testCustWit() {//Customer.withdraw() (checks balance)
        customer.deposit(100, dDate, Customer.CHECKING);//deposits $100
        customer.withdraw(50, wDate, Customer.CHECKING);//withdraws $50
        assertEquals(customer.getCheckBalance(), 50.0, 0.00);//balance should be $50
        assertEquals(customer.getWithdraws().size(), 1);//tests array list
    }

    @Test
    public void testCustWitOverdraft() {//Customer.withdraw() overdraft (checks balance)
        customer.withdraw(100, wDate, Customer.CHECKING);//withdraws $100
        assertEquals(customer.getCheckBalance(), -100.0, 0.00);//balance should be $-100
        assertEquals(customer.getWithdraws().size(), 1);//tests array list
    }
}
