package service;

import syning.common.Message;
import syning.common.MessageType;
import syning.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *  该类完成  用户登录验证/用户注册  等功能
 *
 */
public class UserClientService
{
    //创建一个User成员属性，用于存放传来的User对象;因为这个类中的大多数方法，主要围绕着User属性来执行，所以做成成员属性更方便
    private User u;
    //Socket对象，在大多数方法也会使用，所以也做成成员属性
    private Socket socket;

    /**
     * 该方法根据userId和pwd传到服务器验证用户是否合法
     * @param userId  用户名
     * @param pwd  密码
     * @return true - 合法，false - 非法
     */
    public boolean checkUser(String userId, String pwd)
    {
        //设置User对象
        u = new User(userId, pwd);

        boolean bool = false;
        try
        {
            //连接到服务端，得到一个随机的TCP分配的端口，用来与服务端的9999端口交互
            socket = new Socket("192.168.43.1", 9999);
            //得到ObjectOutputStream
            ObjectOutputStream objos = new ObjectOutputStream(socket.getOutputStream());
            //把u对象发送给服务端，由服务器验证
            objos.writeObject(u);

            //读取从服务端回复来的Message对象，如果服务端没有发回来消息，则消息会阻塞在readObject
            ObjectInputStream objis = new ObjectInputStream(socket.getInputStream());
            Message m = (Message)objis.readObject();

            if (m.getMsType().equals(MessageType.MESSAGE_LOGIN_SUCCEED))  //登录成功
            {
                //登录成功的话，创建一个和服务端保持通信的线程 -> ClientConnectServerThread
                ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
                ccst.start();  //开启线程
                //因为是多用户通讯系统，所以为了客户端多线程的扩展，我们将线程放入到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, ccst);

                bool = true;
            }
            else
            {
                //如果登录失败，就不能启动和服务器交互的线程；我们要关闭Socket对象
                socket.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return bool;
    }


    // 向服务端请求在线用户列表
    public void onlineFriendList() {
        // 发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
        Message ms = new Message();
        ms.setMsType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        ms.setSender(u.getUserId());  // 设置消息的发送者

        // 发送给服务端,首先应得到当前线程的Socket对象,然后获取ObjectOutputStream
        try {
            // 得到当前线程的Socket 对应的 ObjectOutputStream对象
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId())
                            .getSocket().getOutputStream());
            oos.writeObject(ms);  // 发送给服务端，请求在线用户列表
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // 编写方法，退出客户端，并给服务端发送一个退出系统的Message的对象
    public void logout() {
        Message ms = new Message();
        ms.setMsType(MessageType.MESSAGE_CLIENT_EXIT);  // 设置消息类型
        ms.setSender(u.getUserId());  // 设置消息发送者,让服务端知道谁请求退出客户端

        // 发送Message
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(ms);  // 发送给服务端，退出请求
            System.out.println("退出系统");
            System.exit(0);  //直接退出进程，不管还有没有线程在执行，都会掐掉
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setU(String userId, String pwd)
    {
        u.setUserId(userId);
        u.setPasswd(pwd);
    }



}
