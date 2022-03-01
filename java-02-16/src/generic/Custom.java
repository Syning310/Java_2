package generic;

public class Custom<T, R, M>
{
    String name;
    T t;
    R r;
    M m;
    //泛型数组不能实例化，因为new时，无法确定T的类型，所以无法在内存开空间
    //T[] ts = new T[8];
    T[] ts;


    //因为静态属性是与类相关的，在类加载时，对象可能还未创建，如果静态使用了泛型，JVM就无法完成初始化(不知道给多大的空间)
    /*public static void func(M m)
    {

    }*/

    public Custom(String name, T t, R r, M m)
    {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }



}
