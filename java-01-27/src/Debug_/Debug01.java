package Debug_;

import java.util.Arrays;

public class Debug01
{
    public static void main(String[] args)
    {
        int[] arr = {9, -19, 10, -21, 5};

        Arrays.sort(arr);

        for (int i : arr)
        {
            System.out.print(i + " ");
        }

    }
}
