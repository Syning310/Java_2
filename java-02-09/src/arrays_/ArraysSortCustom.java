package arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom
{
    public static void main(String[] args)
    {
        int[] arr = {0, -9, 55, 6, -8, 11, 82, 43, 2};

        System.out.println("arr排序前：");
        System.out.println(Arrays.toString(arr));

        //bubble01(arr);    //从小到大的冒泡排序

        mySort(arr, new Comparator()
                            {
                                public int compare(Object v1, Object v2)
                                {
                                    int i1 = (Integer) v1;
                                    int i2 = (Integer) v2;
                                    return i2 - i1;
                                }
                            });


        System.out.println("arr排序后：");
        System.out.println(Arrays.toString(arr));



    }

    //使用冒泡完成排序  -从小到大
    public static void bubble01(int[] arr)
    {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; ++i)
        {
            for (int j = 0; j < arr.length - i - 1; ++j)
            {
                if (arr[j] > arr[j + 1])
                {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }



    //结合 冒泡 + 定制
    public static void mySort(int[] arr, Comparator c)
    {
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; ++i)
        {
            for (int j = 0; j < arr.length - i - 1; ++j)
            {
                //如果 [j] - [j + 1]  结果大于0为真，那么 [j] 大于 [j + 1]  交换两个数
                //如果 [j + 1] - [j]  结果大于0为真，那么 [j + 1] 大于 [j]  交换两个数
                if (c.compare(arr[j], arr[j + 1]) > 0)
                {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


}
