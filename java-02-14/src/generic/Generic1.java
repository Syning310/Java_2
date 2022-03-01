package generic;

public class Generic1
{
    public static void main(String[] args)
    {
        //创建对象时指定<Q>
        Person<String> p1 = new Person<>("宁");

        Person<Integer> p2 = new Person<>(10);


        System.out.println("p1.s = " + p1.s);
        System.out.println("p2.s = " + p2.s);

    }
}


class Person<Q>
{
    Q s;


    public Person(Q s)
    {
        this.s = s;
    }

}
