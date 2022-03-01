package properties_;

import java.util.Properties;

public class Properties_
{
    public static void main(String[] args)
    {

        Properties ppts = new Properties();

        ppts.put("n1", 100);
        //ppts.put(null, 100);  //异常
        //ppts.put("n2", null); //异常

        ppts.put("n3", 500);
        ppts.put("n4", 900);
        ppts.put("n4", 1000);

        System.out.println("ppts = " + ppts);


        //通过k 获取对应值
        System.out.println(ppts.get("n1"));

        ppts.remove("n1");
        System.out.println("ppts = " + ppts);


    }
}
