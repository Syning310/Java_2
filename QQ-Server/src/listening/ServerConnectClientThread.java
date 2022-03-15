package listening;

import syning.common.Message;
import syning.common.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  该类对应的一个对象和某个客户端保持通讯
 *
 */
public class ServerConnectClientThread extends Thread
{
    //与客户端交互的端口
    private Socket socket;

    //连接到服务端的用户ID
    private String userId;

    //这里线程处于run状态，可以发送/接收消息
    @Override
    public void run()
    {

        //不停地读取从客户端发来的消息，
        while (true)
        {
            try
            {
                //System.out.println("服务端与客户端- " + userId + "保持通讯");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                // 读取的对象是Message对象
                Message ms = (Message)ois.readObject();

                // 根据Message的类型，做相应的业务处理
                if (ms.getMsType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {  // 请求在线用户消息类型

                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());  // 创建输出流
                    // 客户端请求在线用户列表
                    System.out.println("用户: " +  ms.getSender() + " 请求在线用户列表");
                    // 调用管理线程类中的getOnlineUsers，在线用户列表的信息，按照每个 用户名 + " "  返回
                    String onlineUsers = ManageClientThreads.getOnlineUsers();
                    // 构建一个Message对象，返回给客户端
                    Message retMs = new Message();
                    retMs.setMsType(MessageType.MESSAGE_RET_ONLINE_FRIEND); // 设置消息类型
                    retMs.setContent(onlineUsers);  // 设置在线用户列表信息
                    retMs.setGetter(ms.getSender());  // 设置接收者
                    // 写入到数据通道，返回给客户端
                    oos.writeObject(retMs);

                } else if (ms.getMsType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {  // 请求退出系统的消息类型

                    // 客户端请求退出系统
                    System.out.println(ms.getSender() + " 退出系统");
                    // 将这个客户端对应的线程，从管理线程的集合中移除
                    ManageClientThreads.rmServerConnectClientThread(ms.getSender());  // 根据消息的发送者，删除交互的线程
                    socket.close();  // 关闭与客户端某个线程的交互连接
                    break;  // 退出线程

                } else if (ms.getMsType().equals(MessageType.MESSAGE_COMM_MES)) {  // 私聊的消息类型
                    try {
                        System.out.println("date: " + ms.getSendTime() + "\n"
                                + ms.getSender() + " to " + ms.getGetter() + " say: " + ms.getContent());  // 在服务端显示双方交流的信息

                        // 通过ms获取接收者getter，在管理线程集合中取得对应的Socket对象，由这个Socket对象发送给指定得接收者
                        Socket sendSt =
                              ManageClientThreads.getServerConnectClientThread(ms.getGetter()).getSocket();  // 通过接收者ID，获取线程类的Socket对象
                        ObjectOutputStream sendMess = new ObjectOutputStream(sendSt.getOutputStream()); // 获取Socket的输出流对象
                        sendMess.writeObject(ms);
                        //ServerConnectClientThread scct = ManageClientThreads.getServerConnectClientThread(ms.getGetter());  // 得到线程对象
                        //ObjectOutputStream sendSocket = new ObjectOutputStream(scct.getSocket().getOutputStream());  // 通过线程对象得到对应的Socket的输出流
                        //sendSocket.writeObject(ms);  // 将从发送客户端发来的消息，交给和接收者交互的Socket对象，由它打入接收者的数据通道
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }  else if (ms.getMsType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    // 需要遍历管理线程的集合，把所有在线用户取出来，排除发送人
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();  // 取得集合
                    Iterator<String> it = hm.keySet().iterator();  // 取得集合中的所有key值
                    while (it.hasNext()) {
                        // 取出在线用户的id
                        String onlineUserId = it.next();
                        // 如果遍历的用户的名字不是发起者，则可以发送消息; 排除掉发起者
                        if (!onlineUserId.equals(ms.getSender())) {
                            // 通过id 取得收件人的Socket的输出流
                            ObjectOutputStream objos =
                                    new ObjectOutputStream(ManageClientThreads.getServerConnectClientThread(onlineUserId).getSocket().getOutputStream());
                            objos.writeObject(ms);
                        }
                    }
                } else if (ms.getMsType().equals(MessageType.MESSAGE_FILE_MES)) {  // 接收到客户端发来的文件消息类型
                    // 消息对象的运行类型是FileMessage，是Message的子类，所以可以用ms来操作
                    Socket sot =
                            ManageClientThreads.getServerConnectClientThread(ms.getGetter()).getSocket();
                    ObjectOutputStream objos = new ObjectOutputStream(sot.getOutputStream());
                    objos.writeObject(ms);
                    // 把消息发送在控制台
                    System.out.println("date: " + ms.getSendTime() + "\n" + ms.getSender() + " to " + ms.getGetter() + " send to file");
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }

    public ServerConnectClientThread(Socket socket, String userId)
    {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }
}
