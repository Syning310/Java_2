
public class MyTools
{

    public static void main(String[] args)
    {

        int[] array = {9, 7, 4, 2, 6, 1, 0, 3, 5, 8};


        MyTools mt = new MyTools();

        System.out.println("排序前： ");
        for (int a : array)
        {
            System.out.print(a + " ");
        }
        System.out.println();

        mt.test(array);

        System.out.println("排序后： ");
        for (int a : array)
        {
            System.out.print(a + " ");
        }
        System.out.println();

    }

    public void test(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; ++i)
        {
            for (int j = 0; j < arr.length - i - 1; ++j)
            {
                if (arr[j] > arr[j + 1])
                {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

}
