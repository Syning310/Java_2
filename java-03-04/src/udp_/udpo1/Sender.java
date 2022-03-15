package udp_.udpo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender
{

    public static void main(String[] args)
    {

        /*
           1、编写一个接收端和一个发送端
           2、接收端在9999端口等待接收数据
           3、发送端向接收端发送数据：hello，明天吃火锅
           4、接收端接收到发送端发来的数据，回复：好的，明天见，再退出
           5、发送端接收回复的数据，再退出
         */




        DatagramSocket socket = null;

        try
        {
            //1、创建DatagramSocket对象，准备发送和接收数据
            socket = new DatagramSocket(9996);

            //2、将需要发送的数据，封装到DatagramPacket对象
            byte[] data = "兄弟，明天吃火锅~".getBytes();
            //封装的对象构造参数： data内容字节数组，字节长度，主机(ip地址)，接收端口
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.43.1"), 9999);

            //3、发送
            socket.send(packet);


            //4、取得接收端回复来得数据
            socket.receive(packet);

            data = packet.getData();
            int len = packet.getLength();

            System.out.println(new String(data, 0, len));



        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if (socket != null)
            {
                socket.close();
            }
        }








    }

}
