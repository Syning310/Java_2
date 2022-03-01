package homework.hm02;

public class SavingAccount extends BankAccount
{
    private int count = 3;
    private int rate = 1;
    public SavingAccount() { }

    public SavingAccount(int balance) {
        super(balance);
    }

    //每个月初，统计上个月的利息，同时将count = 3
    public void earnMonthlyInterest()
    {
        this.count = 3;
        super.deposit(this.getBalance() * rate);
    }



    @Override
    public void deposit(int amount)
    {
        if (count > 0)
        {
            super.deposit(amount);
            --this.count;
        }
        else
        {
            super.deposit(amount - 1);
        }
    }

    @Override
    public void withdraw(int amount)
    {
        if (count > 0)
        {
            super.withdraw(amount);
            --count;
        }
        else
        {
            super.withdraw(amount + 1);
        }
    }
}
