package wrapper;

public class WrapperType
{
    public static void main(String[] args)
    {

        //jdk5前是手动装箱和手动拆箱
        int n = 10;
        Integer iger1 = new Integer(n);
        Integer iger2 = Integer.valueOf(n);

        int j = iger1.intValue();

        System.out.println(j);


        //jdk5之后，就可以自动装箱和拆箱
        int n2 = 200;
        Integer iger3 = 200;
        Integer iger4 = n2;

        Object obj = true ? new Integer(1) : new Double(2.0);

        System.out.println(obj);


    }

}
