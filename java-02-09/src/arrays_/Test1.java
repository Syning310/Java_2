package arrays_;

import java.util.Arrays;

public class Test1
{
    public static void main(String[] args)
    {
        //数组元素的复制
        int[] arr = {0, -9, 55, 6, -8, 11, 82, 43, 2};

        //1、意思是：从arr数组中，拷贝arr.length个元素，然后返回
        //2、如果拷贝的长度大于arr.length 就在新数组的后面填装，Object填装null，int类型填装0
        int[] newArr = Arrays.copyOf(arr, arr.length + 5);

        System.out.println(Arrays.toString(newArr));


        int[] prr = new int[]{9, 10, 11};
        Arrays.fill(prr, 100);

        System.out.println(Arrays.toString(prr));







    }
}
