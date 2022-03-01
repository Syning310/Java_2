
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys
{
    private double[] balance;  //余额
    private double[] income;   //收益明细
    private double[] consume;  //消费
    private String[] date;     //日期

    public SmallChangeSys()
    {
        this.balance = new double[0];
        this.income = new double[0];
        this.consume = new double[0];
        this.date = new String[0];
    }

    private void menu()
    {
        System.out.println("--------------------零钱通菜单--------------------");
        System.out.println("\t\t\t\t1、零钱通明细");
        System.out.println("\t\t\t\t2、收益入账");
        System.out.println("\t\t\t\t3、消    费");
        System.out.println("\t\t\t\t4、退    出");
    }

    //1、菜单
    public void apple()
    {
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String key = "";

        do
        {
            this.menu();
            System.out.print("请选择(1 - 4)： ");

            key = sc.next();
            switch (key)
            {
                case "1":
                    this.details();
                    break;
                case "2":
                    this.record();
                    break;
                case "3":
                    consumer();
                    break;
                case "4":
                    String choice = "";
                    while (true)
                    {
                        System.out.println("你确定要退出吗？ y / n");
                        choice = sc.next();
                        if ("y".equals(choice) || "n".equals(choice))
                        {
                            break;
                        }
                    }
                    if (choice.equals("y"))
                    {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);

        System.out.println("--------------------退出零钱通--------------------");

    }


    //2、零钱通明细 1)可以先把收益入账和消费，保存到数组;  2)可以使用对象;  3)可以使用String拼接
    public void details()
    {
        System.out.println("--------------------零钱通明细--------------------");

        int in = 0;
        int come = 0;
        for (int i = 0; i < this.balance.length; ++i)
        {
            if (i == 0)
            {
                if (this.balance[i] > 0)
                {
                    this.printWord(true, i, in);
                    ++in;
                }
                else
                {
                    this.printWord(false, i, come);
                    ++come;
                }
            }
            else
            {
                if (this.balance[i] > this.balance[i - 1])  //如果第i个元素大于第i-1个元素，说明这笔是入账
                {
                    this.printWord(true, i, in);
                    ++in;
                }
                else if (this.balance[i] < this.balance[i - 1])  //如果第i个元素小于第i-1个元素，说明这笔帐是支出
                {
                    this.printWord(false, i, come);
                    ++come;
                }
                else  //否则相等的话
                {
                    System.out.println("消费支出   " + 0 + "\t\t" + this.date[i] + "\t余额: " + this.balance[i]);
                }
            }

        }

    }
    //如果为真，打印入账金额，为假，打印消费金额
    private void printWord(boolean b, int i, int p)
    {

        if (b)
        {
            System.out.println("入账金额  +" + this.income[p] + "\t\t" + this.date[i] + "\t余额: " + this.balance[i]);
        }
        else
        {
            System.out.println("消费金额  -" + this.consume[p] + "\t\t" + this.date[i] + "\t余额: " + this.balance[i]);
        }
    }



    //3、收益入账
    public void record()
    {
        Scanner sc = new Scanner(System.in);
        double[] anIncome = null;

        System.out.print("入账金额: ");

        anIncome = new double[this.income.length + 1];
        for (int i = 0; i < this.income.length; ++i)
        {
            anIncome[i] = this.income[i];
        }
        anIncome[anIncome.length - 1] = sc.nextDouble();

        this.income = anIncome;

        this.addDate();    //记录时间
        this.calcBalance(true);
    }

    public void consumer()
    {
        Scanner sc = new Scanner(System.in);
        double[] anConsume = null;
        System.out.print("消费金额: ");

            anConsume = new double[this.consume.length + 1];

            for (int i = 0; i < this.consume.length; ++i)
            {
                anConsume[i] = this.consume[i];
            }

            anConsume[anConsume.length - 1] = sc.nextDouble();
            this.consume = anConsume;

        this.addDate();    //记录时间
        this.calcBalance(false);
    }

    //计算余额的数组
    private void calcBalance(boolean bool)  //如果为true计算收入，如果为false计算支出
    {
        //如果是第一笔交易
        if (this.balance.length == 0)
        {
            this.balance = new double[this.balance.length + 1];
            if (bool)
            {
                this.balance[this.balance.length - 1] = this.income[this.income.length - 1];
            }
            else
            {
                this.balance[this.balance.length - 1] = 0 - this.consume[this.consume.length - 1];
            }
        }
        else
        {
            //开辟一个加一的新空间
            double[] anBalance = new double[this.balance.length + 1];

            //把balance的元素拷贝给新空间，空出来的最后一个位置用来存放最后算出来的数据
            for (int i = 0; i < this.balance.length; ++i)
            {
                anBalance[i] = this.balance[i];
            }

            //如果为真，则是收入，为假则是支出
            if (bool)
            {
                //最新的余额等于，余额数组最后一个元素 + 收入数组的最后一个元素
                anBalance[anBalance.length - 1] = this.balance[this.balance.length - 1] + this.income[this.income.length - 1];
            }
            else
            {
                anBalance[anBalance.length - 1] = this.balance[this.balance.length - 1] - this.consume[this.consume.length - 1];
            }
            this.balance = anBalance;
        }

    }


    private void addDate()
    {
        Date date = new Date();      //日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //用于日期格式化的对象

        String[] anDate = new String[this.date.length + 1];

        for (int i = 0; i < this.date.length; ++i)
        {
            anDate[i] = this.date[i];
        }

        anDate[anDate.length - 1] = "" + sdf.format(date);
        this.date = anDate;
    }

}
