package override;

public class Dog extends Animal
{
    //Dog的cry方法重写了，Animal的cry方法
    public void cry()
    {
        System.out.println("小狗汪汪汪叫...");
    }

    public Dog test()
    {
        System.out.println("dog重写Animal的test...");
        return this;
    }

}
