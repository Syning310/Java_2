package io;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjOut
{
    public static void main(String[] args) throws Exception
    {

        //序列化后，保存的文件格式，不是文本(txt)，而是按照它的格式保存
        String path = "d:\\data";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        //序列化数据到 d:\\data   中
        oos.writeInt(new Integer(100));
        oos.writeBoolean(true);

        oos.writeChar('a');
        oos.writeDouble(9.5);

        //保存一个自定义对象
        oos.writeObject(new Dog("旺财", 10));



        oos.close();
        System.out.println("数据保存完毕");


    }

}

class Dog implements Serializable
{

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

