package exercise;

public class PolyExercise
{
    public static void main(String[] args)
    {
        double d = 13.4;
        long l = (long)d;
        System.out.println("l = " + l);


        //int in = 5;
        //boolean引用类型 无法指向int对象
        //boolean b = (boolean)in;  //错误


        Object obj = "Hello";
        String objStr = (String)obj;
        System.out.println("objStr = " + objStr);

        Object objPri = new Integer(5);
        //String str = (String)objPri;

        Integer ig = (Integer)objPri;

        System.out.println("ig = " + ig);


        //int数据也无法转换成boolean类型
        //int ib = 1;
        //boolean b = (boolean)ib;


       //String bool = "true";
       ////String类型也无法转换成boolean类型
       //boolean b = (boolean)bool;
       //System.out.println("b = " + b);



    }
}
