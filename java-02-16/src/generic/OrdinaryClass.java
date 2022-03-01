package generic;

public class OrdinaryClass
{
    public static void main(String[] args)
    {
        Car.fly("宁", 10);
        Fish<Double> f = new Fish<>();
        f.eat("🐟", 3.14);


    }
}


//普通类中定义泛型方法
class Car
{
    //泛型方法，只给fly方法使用
    public static <T,R> void fly(T t, R r)
    {
        System.out.println("fly = " + t + "  类型： " + t.getClass().getSimpleName());
        System.out.println("fly = " + r + "  类型： " + r.getClass());
    }

}


//泛型类
class Fish<E>
{
    public <Q> void eat(Q q, E e)
    {
        System.out.println("eat = " + q + "  类型： " + q.getClass());
        System.out.println("eat = " + e + "  类型： " + e.getClass());
    }


}
