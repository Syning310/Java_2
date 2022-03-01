package generic;

public class Work0
{
    public static void main(String[] args)
    {
        D<String> d = new D<>("宁");
        d.print();

        Dao<Integer> dao = new D(10);
        dao.print();

    }
}

class Dao<T>
{
    private T t;
    public Dao(T t)
    {
        this.t = t;
    }

    public void print()
    {
        System.out.println("t.getClass = " + t.getClass().getSimpleName());
    }

    public T getT()
    {
        return t;
    }

}

class D<T> extends Dao
{
    public D(T t)
    {
        super(t);

    }

    public void print()
    {
        System.out.println("t.getClass = " + getT().getClass().getSimpleName());
    }

}