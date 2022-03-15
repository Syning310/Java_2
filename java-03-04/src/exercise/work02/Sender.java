package exercise.work02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender
{

    public static void main(String[] args)
    {


        DatagramSocket socket = null;
        String s = "四大名著是哪些";


        try
        {
            //发送端的UDP端口是9966
            socket = new DatagramSocket(9966);

            //发送数据，发给对方机子的8888端口
            byte[] buf = s.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.43.1"), 8888);
            socket.send(packet);


            //接收返回来的数据，然后拆包
            byte[] bps = new byte[64 * 1024];
            packet = new DatagramPacket(bps, bps.length);
            socket.receive(packet);
            int len = packet.getLength();
            byte[] conent = packet.getData();

            System.out.println(new String(conent, 0, len));



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
                e.getMessage();
            }


        }



    }

}
