package houstrent.view;


import houstrent.domain.House;
import houstrent.service.HouseService;
import houstrent.utils.Utilitys;



public class HouseView
{
    private HouseService hse;  //数据层
    private int idCounter;     //自增长器

    public HouseView()
    {
        hse = new HouseService();
        this.idCounter = 1;
    }

    //显式主菜单
    private void menu()
    {
            System.out.println("***************房屋出租系统***************");
            System.out.println("\t\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t\t4 修 改 房 屋");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退      出");
            System.out.print("请输入你的选择>: ");
    }

    //接收用户选择
    public void open()
    {
        boolean loop = true;   //控制循环
        char key = ' ';  //接收用户选择

        do
        {
            this.menu();
            key = Utilitys.readMenuSelection();

            switch (key)
            {
                case '1' :  //新增房源
                    this.addHouse();
                    break;
                case '2' :  //查找房屋
                    this.checkHouse();
                    break;
                case '3' :  //删除房屋
                    this.delHouse();
                    break;
                case '4' :  //修改房屋
                    this.reviseHouse();
                    break;
                case '5' :  //房屋列表
                    this.listHouses();
                    break;
                case '6' :  //退出
                        if (Utilitys.readConfirmSelection() == 'Y')
                        {
                            System.out.println("---------------退出程序---------------");
                            loop = false;
                        }
                        else
                        {
                            break;
                        }

            }


        } while (loop);


    }


    //显式房屋列表
    public void listHouses()
    {
        System.out.println("---------------房屋列表---------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");

        House[] houses = this.hse.list();
        for (House h : houses)
        {
            System.out.println(h);
        }
        System.out.println("---------------显式完毕---------------");
    }


    //接收输入，创建House对象，调用Service中的add方法
    public void addHouse()
    {
        System.out.println("---------------添加房屋---------------");
        System.out.print("姓名>: ");
        String name = Utilitys.readString(8);
        System.out.print("电话>: ");
        String phone = Utilitys.readString(11);
        System.out.print("地址>: ");
        String address = Utilitys.readString(16);
        System.out.print("月租>: ");
        int rent = Utilitys.readInt();
        System.out.print("状态>: ");
        String statue = Utilitys.readString(3);
        //创建一个新的House对象,id是按序号分配的
        House nH = new House(this.idCounter++, name, phone, address, rent, statue);
        this.hse.addH(nH);
    }


    //接收输入的id，调用Service中的，del方法删除House数组中的House
    public void delHouse()
    {
        System.out.println("---------------删除房屋---------------");
        System.out.print("请输入要删除房屋的编号(-1退出)>: ");
        int delId = Utilitys.readInt();
        if (delId == -1)
        {
            System.out.println("---------------取消删除---------------");
            return;
        }
        System.out.println("Y->确定  N->取消");
        char c = Utilitys.readConfirmSelection();
        if (c == 'Y')
        {
            if (this.hse.delH(delId))
            {
                System.out.println("---------------删除成功---------------");
                return;
            }
            else
            {
                System.out.println("---------------删除失败---------------");
                return;
            }
        }
        else
        {
            System.out.println("---------------放弃删除---------------");
            return;
        }

    }


    //接收用户输入的数据
    public void checkHouse()
    {
        System.out.println("---------------查找房屋---------------");
        System.out.print("请输入要查找的房屋编号(-1退出)>: ");
        int check = Utilitys.readInt();
        if (check == -1)
        {
            System.out.println("---------------放弃查找---------------");
            return;
        }

        String str = hse.checkH(check);  //返回hse.houses[check].toString
        if (str == null)
        {
            System.out.println("---------------未能找到---------------");
            return ;
        }
        else
        {
            System.out.println("编号		房主		电话		地址		月租		状态(未出租/已出租)");
            System.out.println(str);
        }

    }


    //接收用户输入的数据
    public void reviseHouse()
    {
        System.out.println("---------------修改信息---------------");
        System.out.print("请输入要修改的房屋编号(-1退出)>: ");
        int check = Utilitys.readInt();
        if (check == -1)
        {
            System.out.println("---------------放弃修改---------------");
            return;
        }

        int ret = this.hse.retIndex(check);
        if (ret == -1)
        {
            System.out.println("---------------未能找到---------------");
            return;
        }

        this.hse.reviseH(ret);
        System.out.println("---------------修改成功---------------");

    }


}

