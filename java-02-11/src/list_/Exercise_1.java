package list_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_1
{
    @SuppressWarnings({"all"})
    public static void main(String[] args)
    {

        List lst = new ArrayList();
        lst.add(new Book("红楼梦", "曹雪芹", 100));
        lst.add(new Book("西游记", "吴承恩", 10));
        lst.add(new Book("水浒传", "施耐庵", 9));
        lst.add(new Book("三国演义", "罗贯中", 80));
        lst.add(new Book("西游记", "吴承恩", 10));

        toBubbol(lst);

        for (Object o : lst)
        {
            System.out.println(o);
        }


        //由这段代码可见，ArrayList可以添加空指针，而不是把null转换成字符存入
        {
            Object o10 = null;
            lst.add(o10);
            System.out.println(lst.get(5));
            Object pj = lst.get(5);
            //System.out.println(pj.hashCode());  //空指针异常
            lst.add(null);
            pj = lst.get(6);
            System.out.println(pj.hashCode());  //空指针异常
        }

    }

    public static void toBubbol(List lst)
    {
        Object tmp;
        for (int i = 0; i < lst.size() - 1; ++i)
        {
            for (int j = 0; j < lst.size() - i - 1; ++j)
            {
                //List不是数组，只能用get获得元素
                if(((Book)lst.get(j)).getPrice() < ((Book)lst.get(j + 1)).getPrice())
                {
                    tmp = lst.get(j);
                    lst.set(j, lst.get(j + 1));  //修改元素也是不能用[]，用set
                    lst.set(j + 1, tmp);
                }
            }
        }
    }


}

class Book
{
    private String author;
    private String name;
    private int price;

    public String toString()
    {
        return "名称:" + this.name + "\t\t" + "价格:" + this.price + "\t\t" + "作者:" + this.author;
    }


    public Book(String author, String name, int price) {
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
