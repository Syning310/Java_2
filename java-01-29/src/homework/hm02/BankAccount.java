package homework.hm02;

public class BankAccount
{
    private int balance;  //余额

    public BankAccount() { }

    public BankAccount(int balance)
    {
        this.setBalance(balance);
    }

    //存款
    public void deposit(int amount)
    {
        this.balance += amount;
    }
    //取款
    public void withdraw(int amount)
    {
        this.balance -= amount;
    }



    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }
}
