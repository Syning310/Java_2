package exercise.work02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver
{
    public static void main(String[] args)
    {

        String conent = "四大名著是哪些";
        DatagramSocket socket = null;

        try
        {
            //接收端启用的UDP端口是8888
            socket = new DatagramSocket(8888);

            byte[] bs = new byte[64 * 1024];
            //创建一个packet对象，来收数据通道来的对象，并传入byte[]保存数据
            DatagramPacket packet = new DatagramPacket(bs, bs.length);

            //调用接收方法，将传输来的对象，填入到packet
            socket.receive(packet);


            //把packet对象拆包
            int len = packet.getLength();
            byte[] data = packet.getData();

            String str = new String(data, 0, len);
            if (conent.equals(str))
            {
                data = "四大名著是《红楼梦》、《三国演义》、《水浒传》、《西游记》".getBytes();
                packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.43.1"), 9966);
                socket.send(packet);
            }
            else
            {
                data = "what?".getBytes();
                packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.43.1"), 9966);
                socket.send(packet);
            }


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {

                socket.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }


    }
}
