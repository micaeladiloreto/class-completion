package project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SavingsAccountTest {

    /* Uncomment these tests one at a time and create a savings account class that passes all of the given unit tests.
     *
     * The SavingsAccount class will have the following features:
     * - A starting balance
     * - An account number
     * - The ability to add money to the account
     * - The ability to withdraw money from the account
     * - The ability to add interest to the account balance.  (This is a super bank account and accrues interest
     *   whenever you call the method to accrue interest!)
     * - Not fulfilling a withdraw if the withdraw would put the balance below 0.
     *
     */

    @Test
    public void shouldBeAbleToInstantiateSavingsAccount() {
        SavingsAccount underTest = new SavingsAccount(0, 110110110, 0.10);
    }

    @Test
    public void newAccountsHaveAStartingBalanceFromTheConstructor() {
        SavingsAccount underTest = new SavingsAccount(10.10, 110110110, 0.10);
        double balance = underTest.getBalance();
        assertEquals(10.10, balance, 0.001);
    }

    @Test
    public void newAccountHasAnAccountNumberPassedFromConstructor() {
        SavingsAccount underTest = new SavingsAccount(18.10, 45673251, 0.10);
        int accountNumber = underTest.getAccountNumber();
        assertEquals(45673251, accountNumber);
    }

    @Test
    public void shouldBeAbleToSetInterestRateInConstructor(){
        SavingsAccount underTest = new SavingsAccount(10.00, 110110110, 0.10);
        double interestRate = underTest.getInterestRate();
        assertEquals(.10, interestRate, 0.001);

    }

    @Test
    public void shouldBeAbleToAddMoneyToAccount() {
        SavingsAccount underTest = new SavingsAccount(10.01, 110110110, 0.10);
        underTest.deposit(9.99);
        assertEquals(20, underTest.getBalance(), .001);
    }

    @Test
    public void shouldBeAbleToDepositAnotherAmount() {
        SavingsAccount underTest = new SavingsAccount(10.00, 110110110, 0.10);
        underTest.deposit(19.99);
        assertEquals(29.99, underTest.getBalance(), .001);
    }

    @Test
    public void shouldBeAbleToWithdrawFromAccount() {
        SavingsAccount underTest = new SavingsAccount(10.00, 110110110, 0.10);
        underTest.withdraw(5.00);
        assertEquals(5.00, underTest.getBalance(), .001);
    }
    @Test
    public void shouldNotBeAbleToWithdrawIfItTakesTheBalanceBelowZero(){
        SavingsAccount underTest = new SavingsAccount(10.00, 110110110, 0.10);
        underTest.withdraw(2345.43);
        assertEquals(10.00, underTest.getBalance(), 0.001);
    }
    @Test
    public void shouldBeAbleToAccrueInterest(){
        SavingsAccount underTest = new SavingsAccount(10.00, 110110110, 0.10);
        underTest.accrueInterest();
        assertEquals(11.00, underTest.getBalance(), 0.001);
    }
    @Test
    public void shouldBeAbleToDepositAccrueInterestAndDepositAgain(){
        SavingsAccount underTest = new SavingsAccount(10.00, 110110110, .05);
        underTest.deposit(10.00);
        underTest.accrueInterest();
        underTest.deposit(4.25);
        assertEquals(25.25, underTest.getBalance(), 0.001);
    }

}
