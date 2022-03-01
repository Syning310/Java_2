package exercise;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Work0
{
    public static void main(String[] args)
    {
        News news1 = new News("新冠确诊病例超千万，数百万印度教徒赴恒河”圣浴“引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList al = new ArrayList();
        al.add(news1);
        al.add(news2);



        for (Object obj : al)
        {
            System.out.println(((News)obj).toString());
        }

        for (Object obj : al)
        {
            System.out.println(processTitle(((News)obj).toString()));
        }


    }

    //专门写一个方法，处理实现新闻标题
    public static String processTitle(String title)
    {
        if (title == null)
        {
            return null;
        }
        if (title.length() > 15)
        {
            return title.substring(0, 15) + "...";
        }
        else
        {
            return title;
        }

    }
}

class News
{
    private String item;
    private String content;

    public String toString()
    {
        return "item: " + item;
    }

    public News(String item)
    {
        this.item = item;
    }

    public String getItem()
    {
        return item;
    }

    public void setItem(String item)
    {
        this.item = item;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
}
