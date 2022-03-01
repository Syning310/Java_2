public class CpuNum
{
    public static void main(String[] args)
    {
        Runtime runtime = Runtime.getRuntime();

        int i = runtime.availableProcessors();

        System.out.println("当前CPU个数：");
        System.out.println("i = " + i);

    }
}
