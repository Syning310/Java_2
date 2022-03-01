package homework.hm02;

public class CheckingAccount extends BankAccount
{
    public CheckingAccount() { }
    public CheckingAccount(int balance)
    {
        super(balance);
    }

    public void deposit(int amount)
    {
        super.deposit(amount - 1);
    }

    public void withdraw(int amount)
    {
        super.withdraw(amount + 1);
    }


}
