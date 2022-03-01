package codeblock;

class Sample
{
    Sample(String s)
    {
        System.out.println(s);
    }
    Sample()
    {
        System.out.println("Sample默认构造函数被调用");
    }
}

public class Test02 {
    Sample sam1 = new Sample("sam1成员初始化");  //3
    static Sample sam = new Sample("静态成员sam初始化");  //1

    static
    {
        System.out.println("static 代码块执行"); //2
        if (sam == null)    //按顺序，先初始化了sam，所以，这条语句为false
        {
            System.out.println("sam is null");
        }
    }

    Test02()  //4
    {
        System.out.println("Test默认构造函数被调用");
    }

    public static void main(String[] args)
    {
        Test02 a = new Test02();
        /*运行结果：
            静态成员sam初始化
            static 代码块执行
            sam1成员初始化
            Test默认构造函数被调用

        */
    }

}
