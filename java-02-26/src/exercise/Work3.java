package exercise;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class Work3
{
    public static void main(String[] args) throws Exception
    {
        /**
         * 1、编写一个dog.properties
         * name=tom
         * age=5
         * color=red
         *
         * 2、编写Dog类(name, age, color)创建一个dog对象，读取dog.properties用相应的内容完成属性初始化，并输出
         * 3、将创建的Dog对象，序列化到文件dog.dat文件中
         */


        Properties ps = new Properties();

        ps.load(new FileReader("src\\dog.properties"));
        //ps.list(System.out);


        String name = ps.get("name") + "";
        int age = Integer.parseInt(ps.get("age") + "");
        String color = ps.get("color") + "";


        Dog d = new Dog(name, age, color);

        System.out.println(d);



        String path = "d:\\dog.dat";
        ObjectOutputStream ow = new ObjectOutputStream(new FileOutputStream(path));


        ow.writeObject(d);

        ow.close();




    }


    //编写一个方法，反序列化
    @Test
    public void m() throws Exception
    {
        String path = "d:\\dog.dat";

        ObjectInputStream bis = new ObjectInputStream(new FileInputStream(path));

        Dog d = (Dog)bis.readObject();

        System.out.println(d);

        bis.close();

    }

}


class Dog implements Serializable
{

    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color)
    {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }
}

