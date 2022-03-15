package service;

import java.util.HashMap;

/**
 *  该类用来管理客户端连接到服务端的线程
 *
 */
public class ManageClientConnectServerThread
{
    /**存放所有客户端和服务端连接的线程
     *
     * k - userId
     * value - 线程
     */
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();


    //将某个线程加入到集合中
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread ccst)
    {
        hm.put(userId, ccst);
    }

    //通过userId，可以得到对应线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId)
    {
        return hm.get(userId);
    }




}
