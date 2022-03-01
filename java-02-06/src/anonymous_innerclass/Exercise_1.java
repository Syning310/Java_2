package anonymous_innerclass;

public class Exercise_1
{
    public static void main(String[] args)
    {
        func1(new IL(){
                        public void show()
                        {
                            System.out.println("匿名类实现IL的show抽象方法");
                        }
        });

    }

    public static void func1(IL il)
    {
        il.show();
    }
}

interface IL
{
    void show();
}

