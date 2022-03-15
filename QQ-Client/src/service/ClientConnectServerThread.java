package service;

import syning.common.FileMessage;
import syning.common.Message;
import syning.common.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread
{
    //该线程需要持有和服务端交互的Socket对象
    private Socket socket;

    /**
     *  线程需要在后台和服务端保持通讯，因此应该做成while死循环
     */
    @Override
    public void run()
    {

        while (true)
        {
            try {
                //System.out.println("客户端线程，等待读取从服务端发送来的消息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                // 如果服务端没有发送Message对象来，那么线程会阻塞在这里
                Message m = (Message)ois.readObject();

                // 判断接收到的Message类型，然后做相应的处理

                // 如果接收到的是服务端，返回来的在线用户列表 true
                if (m.getMsType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {  // 接收到服务端返回来的在线用户列表
                    //取出在线列表信息，并显示
                    String[] online = m.getContent().split(" ");
                    System.out.println("\n======= 在线用户列表 =======");
                    for (String s : online)
                    {
                        System.out.println("用户: " + s);
                    }
                } else if (m.getMsType().equals(MessageType.MESSAGE_COMM_MES)) { // 接收到服务端转发来的普通消息
                    // 把从服务端转发来的消息，显示到控制台即可
                    System.out.println("\ndate: " +  m.getSendTime() + "\n"
                            + m.getSender() + " to " + m.getGetter() + " say: " + m.getContent());
                } else if (m.getMsType().equals(MessageType.MESSAGE_TO_ALL_MES)) {  // 接收到服务端转发来的群发消息
                    System.out.println("\ndate: " + m.getSendTime() + "\n"
                            + m.getSender() + " to all say: " + m.getContent());  // 输出到控制台
                } else if (m.getMsType().equals(MessageType.MESSAGE_FILE_MES)) {  // 接收到服务端转发来的文件消息类型
                    // 接收到的文件消息的运行类型是FileMessage，所以直接向下转型最好
                    FileMessage fm = (FileMessage)m;
                    // 取出文件的字节数组，通过文件输出流，写到磁盘中
                    FileOutputStream fos = new FileOutputStream(fm.getDest());  // 定位到磁盘位置
                    fos.write(fm.getFileBytes()); // 写文件
                    fos.close(); // 关闭文件，不刷新则无效写入

                    // 控制台输出提示信息
                    System.out.println("\ndate: " + fm.getSendTime() + "\n"
                            + fm.getSender() + " send file to " + fm.getDest());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    //构造器接收一个Socket对象，与服务端的端口进行交互；Socket对象本身也是一个端口
    public ClientConnectServerThread(Socket socket)
    {
        this.socket = socket;
    }


    public Socket getSocket() {
        return socket;
    }

}
