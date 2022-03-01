package exercise_;

public class Work_1
{
    public static void main(String[] args)
    {
        //1、首先验证输入的参数个数是否正确 两个参数
        try
        {
            if (args.length != 2)
            {
                throw new ArrayIndexOutOfBoundsException("参数个数应为两个");
            }

            //2、把从命令行中收到的参数，转换成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            int ret = cal(n1, n2);
            System.out.println("计算结果为： " + ret);
        }
        catch (ArrayIndexOutOfBoundsException a)
        {
            System.out.println(a.getMessage());
        }
        catch (NumberFormatException n)
        {
            System.out.println("参数格式不正确，需要输入整数");
        }
        catch (ArithmeticException a)
        {
            System.out.println("出现除0的异常");
        }


    }

    public static int cal(int v1, int v2)
    {
        return v1 / v2;
    }


}



