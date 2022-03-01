package homework_;

public class Work3
{
    public static void main(String[] args)
    {
        Cellphone cp = new Cellphone();

        int ret = cp.testWork(new Calc(){
                                            public int work(int v1, int v2)
                                            {
                                                return v1 + v2;
                                            }
                                        }, 10, 20);
        /*
        new Calc(),,,   它的的底层是：
            class 匿名类 implements Calc
            {
                public int work(int v1, int v2)
                {
                    return v1 + v2;
                }
            }
        完后，立马new出对象，传递给 Calc u 形参
         */

        System.out.println("ret = " + ret);


    }


}


interface Calc
{
    int work(int v1, int v2);
}

class Cellphone
{
    public int testWork(Calc u, int v1, int v2)
    {
        return u.work(v1, v2);
    }
}
