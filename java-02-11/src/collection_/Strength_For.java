package collection_;

import java.util.ArrayList;
import java.util.Collection;

public class Strength_For
{
    @SuppressWarnings ({"all"})
    public static void main(String[] args)
    {
        Collection col = new ArrayList();
        col.add(new Person("宁", 4000));
        col.add(new Person("月", 3000));
        col.add(new Person("颜", 200));
        col.add(new Person("尘", 28));

        //增强for循环
        for (Object ob : col)
        {
            System.out.println(ob);
        }




    }



}
