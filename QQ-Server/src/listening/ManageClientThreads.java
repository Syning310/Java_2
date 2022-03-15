package listening;

import java.util.HashMap;
import java.util.Iterator;

/**
 *  管理和客户端通讯的线程
 *
 */
public class ManageClientThreads
{
    //用HashMap集合来管理，k-用户名  v-线程
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();


    //添加线程到hm
    public static void addClientThread(String userId, ServerConnectClientThread scct)
    {
        hm.put(userId, scct);
    }

    //根据userId，返回线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId)
    {
        return hm.get(userId);
    }


    // 返回在线用户列表的方法
    public static String getOnlineUsers(){
        // 集合遍历，遍历HashMap的key
        Iterator<String> it = hm.keySet().iterator();
        String onlineUserList = "";
        while (it.hasNext()){
            onlineUserList += it.next() + " ";
        }
        return onlineUserList;
    }

    // 从集合中，删除某个线程对象
    public static void rmServerConnectClientThread(String userId) {
        hm.remove(userId);
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
}
