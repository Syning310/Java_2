package homework.hm02;

public class test
{
    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount(1000);

        ba.deposit(10);
        System.out.println(ba.getBalance());  //1010

        ba.withdraw(10);
        System.out.println(ba.getBalance());  //1000


        ba = new CheckingAccount(1000);

        ba.deposit(10);
        System.out.println(ba.getBalance());  //1009

        ba.withdraw(10);
        System.out.println(ba.getBalance());  //998


    }

}
