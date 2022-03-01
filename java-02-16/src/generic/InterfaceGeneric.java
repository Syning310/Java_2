package generic;

public class InterfaceGeneric
{
    public static void main(String[] args)
    {
        QQ<String> q = new QQ<>();
        q.e = "宁";
        q.retE();



    }
}

interface IUSB<U, R>
{
    //普通方法中，才能使用接口的泛型
    R get(U u);
    void hi(R r);
    void run (R r1, R r2, U u1, U u2);

    default R method (U u)
    {
        return null;
    }

}
//继承接口
interface IA extends IUSB<String, Double>
{

}
//实现IA，因为IA已经指定过类型了，所以这里只需要实现即可
class QA implements IA
{

    @Override
    public Double get(String s)
    {
        return null;
    }

    @Override
    public void hi(Double aDouble)
    {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2)
    {

    }
}

//实现IUSB接口，这里需要指定泛型
class PA implements IUSB<String, Integer>
{
    @Override
    public Integer get(String s)
    {
        return null;
    }

    @Override
    public void hi(Integer integer)
    {

    }

    @Override
    public void run(Integer r1, Integer r2, String u1, String u2)
    {

    }
}


interface IN<E>
{
    E retE();
}
class QQ<E> implements IN
{
    public E e;
    public E retE()
    {
        System.out.println("e.getClass() = " + e.getClass());
        return null;
    }
}



