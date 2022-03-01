package override;

public class Animal
{
    public void cry()
    {
        System.out.println("动物叫唤...");
    }

    public Animal test()
    {
        System.out.println("Animal的test...");
        return this;
    }

}
