package udp_.udpo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver
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
            //1、创建一个DatagramSocket对象，准备在9999端口接收数据
            socket = new DatagramSocket(9999);

            //2、构建一个DatagramPacket对象，准备接收数据
            byte[] buf = new byte[64 * 1024];  //UDP协议，一个数据包最大是64k
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            //3、调用接收方法，将通过网络传输过来的DatagramPacket对象，填充到packet对象中
            //提示：当有数据包发送到本机的9999端口时，就会接收到数据；如果没有数据包发送到本机的9999端口，程序就会阻塞
            socket.receive(packet);

            //4、把packet对象进行拆包，取出数据，并显示
            int len = packet.getLength();  //实际接收到的数据 字节长度
            byte[] data = packet.getData();

            System.out.println(new String(data, 0, len));


            //5、回复给发送端：好的明天见
            buf = "好的明天见！！！".getBytes();
            packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.1"), 9996);

            socket.send(packet);


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            //5、关闭资源
            if (socket != null)
            {
                socket.close();
            }

        }




    }

}
