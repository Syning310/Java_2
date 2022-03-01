package arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class Test0
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 20, 30, 5, 80, 44, 9};

        System.out.println("arr1默认排序前:");
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr1);  //默认排序

        System.out.println("arr1默认排序后:");
        System.out.println(Arrays.toString(arr1));


        Integer[] arr2 = {52, 23, 90, 85, 19, 48, 10, 22, -19, -1, 22, 14, 55};
        System.out.println("arr2定制排序前:");
        System.out.println(Arrays.toString(arr2));

        //调用定制排序时，传入两个参数1、数组  2、实现Comparator接口的匿名内部类

        Arrays.sort(arr2, new Comparator()
                                {
                                    @Override
                                    public int compare(Object v1, Object v2)
                                    {
                                        Integer i1 = (Integer)v1;
                                        Integer i2 = (Integer)v2;
                                        return i2 - i1;
                                    }
                                });

        System.out.println("arr2定制排序后:");
        System.out.println(Arrays.toString(arr2));



    }
}


//class Cmp implements Comparator
//{
//    @Override
//    public int compare(Object v1, Object v2)
//    {
//        Integer i1 = (Integer)v1;
//        Integer i2 = (Integer)v2;
//        return i2 - i1;
//    }
//}