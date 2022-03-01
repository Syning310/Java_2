package io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import io.ObjOut;

public class ObjectIn
{
    public static void main(String[] args) throws Exception
    {
        String path = "d:\\data";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        //读取的顺序，需要和保存数据的顺序一致

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());

        //System.out.println(ois.readUTF());

        Object obj = ois.readObject();
        System.out.println("Obj的运行类型： " + obj.getClass());
        System.out.println(obj);

        Dog d = (Dog)obj;
        System.out.println(d.getName());
        System.out.println(d.getAge());


        ois.close();




    }



}


