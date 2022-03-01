package houstrent.service;

import houstrent.domain.House;
import houstrent.utils.Utilitys;

public class HouseService
{
    private House[] houses;

    public HouseService()
    {
        houses = new House[0];

    }

    //返回houses数组
    public House[] list()
    {
        return this.houses;
    }

    //添加新对象
    public void addH(House newHouse)
    {

        House[] anHouses = new House[this.houses.length + 1];
        for (int i = 0; i < this.houses.length; ++i)
        {
            anHouses[i] = this.houses[i];
        }
        //把newHouse加入到这个数组的最后
        anHouses[anHouses.length - 1] = newHouse;
        this.houses = anHouses;
    }


    //删除对象
    public boolean delH(int delId)
    {
        int index = -1;
        for (int i = 0; i < this.houses.length; ++i)
        {
            if (this.houses[i].getId() == delId)
            {
                index = i;
            }
        }

        if (index == -1)
        {
            return false;
        }
        else
        {
            House[] anHouses = new House[this.houses.length - 1];

            for (int i = 0, j = 0; i < this.houses.length; ++i)
            {
                if (i != index)
                {
                    anHouses[j++] = this.houses[i];
                }
            }
            this.houses = anHouses;
            return true;
        }

    }


    //接收check，返回字符串
    public String checkH(int check)
    {
        int index = -1;  //下标
        for (int i = 0; i < this.houses.length; ++i)
        {
            if (check == this.houses[i].getId())
            {
                index = i;
            }
        }

        if (index == -1)  //说明没有找到
        {
            return null;
        }
        else
        {
            return this.houses[index].toString();
        }
    }

    //返回查找的编号的房屋下标
    public int retIndex(int check)
    {
        int index = -1;
        for (int i = 0; i < this.houses.length; ++i)
        {
            if (check == this.houses[i].getId())
            {
                index = i;
            }

        }
        if (index == -1)
        {
            return -1;
        }
        else
        {
            return index;
        }
    }

    //接收要修改的下标，修改房屋信息
    public void reviseH(int i)
    {
        System.out.print("姓名(" + houses[i].getName() + "):> ");
        String name = Utilitys.readString(10, houses[i].getName());
        System.out.print("电话(" + houses[i].getPhone() + "):> ");
        String phone = Utilitys.readString(11, houses[i].getPhone());
        System.out.print("地址(" + houses[i].getAddress() + "):> ");
        String address = Utilitys.readString(5, houses[i].getAddress());
        System.out.print("租金(" + houses[i].getRent() + "):> ");
        int rent = Utilitys.readInt(houses[i].getRent());
        System.out.print("状态(" + houses[i].getStatue() + "):> ");
        String statue = Utilitys.readString(3, houses[i].getStatue());

        this.houses[i].setName(name);
        this.houses[i].setPhone(phone);
        this.houses[i].setAddress(address);
        this.houses[i].setRent(rent);
        this.houses[i].setStatue(statue);
    }

}



