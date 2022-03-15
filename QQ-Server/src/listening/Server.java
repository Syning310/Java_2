package listening;

import syning.common.Message;
import syning.common.MessageType;
import syning.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *  这是服务端，监听端口，等待客户端的连接，并保持通讯
 *
 */
public class Server
{
    //服务端监听端口
    private ServerSocket sst;

    //创建一个集合，存放多个用户，如果客户端传过来的用户对象存在于此集合中，就认为是合法的
    private static HashMap<String, User> validUsers = new HashMap<>();
    //这里也可以使用ConcurrentHashMap，可以处理并发的集合，线程安全，而HashMap是线程不安全的
    static  //在静态代码块中，初始化validUsers
    {
        validUsers.put("ning", new User("ning", "0310"));
        validUsers.put("yue", new User("yue", "0310"));
        validUsers.put("qing", new User("qing", "0310"));
        validUsers.put("yan", new User("yan", "0310"));
    }


    public Server()
    {
        // 注意：端口可以写在配置文件
        System.out.println("服务端在9999端口监听");

        // 启动推送新闻的线程
        new Thread(new SendNewsToAllService()).start();

        try
        {
            sst = new ServerSocket(9999);

            //当和某个客户端连接之后，会继续监听会不会还有其他客户端连接，因此用死循环
            while (true)
            {
                //如果有客户端连接到服务端，就会往下执行，否则阻塞
                Socket socket = sst.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                //客户端发来的是一个请求验证的 User对象
                User u = (User)ois.readObject();
                //定义Message对象，准备回复客户端
                Message ms = new Message();

                //验证User对象是否合法，也就是是否有注册
                if (judgUser(u))
                {
                    //登录成功，给客户端发去一个登录成功的Message对象
                    ms.setMsType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(ms);  //回复给客户端

                    //创建一个线程，和客户端保持通讯，该线程持有Socket对象与客户端的Socket对象交互
                    ServerConnectClientThread scct = new ServerConnectClientThread(socket, u.getUserId());
                    scct.start();  //启动线程

                    //把线程对象放入到集合中进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), scct);

                }
                else
                {
                    System.out.println(u.getUserId() + " 登陆失败");
                    //登录失败
                    ms.setMsType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(ms);
                    socket.close();  //关闭与客户端连接的Socket对象
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private boolean judgUser(User u)
    {
        boolean b = true;
        User user = validUsers.get(u.getUserId());  //get方法，如果没有找到相应的key，则返回null
        //user如果为空，则说明服务器中没有认可该User对象(没有相应的key)
        if (user == null || !(user.getPasswd().equals(u.getPasswd())))
        {
            b = false;
        }

        return b;
    }

}
