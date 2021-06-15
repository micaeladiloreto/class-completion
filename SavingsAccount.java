package project;

public class SavingsAccount {
    //data fields
    double balance;
    int savingsAccount;
    double interestRate;
    double totalInterest;
//    double deposit;

    //constructor
    public SavingsAccount(double balance, int savingsAccount, double interestRate) {
        this.balance = balance;
        this.savingsAccount = savingsAccount;
        this.interestRate = interestRate;
    }

    //getters
    public double getBalance() {

        return balance;
    }

    public int getAccountNumber() {

        return savingsAccount;
    }

    public double getInterestRate() {

        return interestRate;
    }

    //add money to account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit into account " + savingsAccount);
        System.out.println("Amount: " + amount);
        System.out.println("New balance: " + balance);
        System.out.println();
    }

    //withdraw money from account
    //set withdraw limit
    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("Withdraw account: " + savingsAccount);
            System.out.println("Amount: " + amount);
            System.out.println("New balance: " + balance);
            System.out.println();
            return amount;
        }
        return amount;
    }

    //accrue interest
   public double accrueInterest(){
        double monthlyInterestRate = balance * getInterestRate();
        totalInterest += interestRate;
        balance += monthlyInterestRate;
        return interestRate;
   }

   //deposit accrue interest & deposit again
    public void depositAccrueInterest(double amount){
        balance += interestRate;
        System.out.println("Deposit into account: " + savingsAccount);
        System.out.println("Amount: " + interestRate);
        System.out.println("New balance: " + balance);
        System.out.println();
    }
}
