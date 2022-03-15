package syning.common;

import java.io.Serializable;

/**
 *   表示一个用户信息
 *   为了让这个类能够在网络上传输，需要实现Serializable接口，这叫序列化
 *
 */
public class User implements Serializable
{

    //用户名
    private String userId;

    //用户密码
    private String passwd;



    public User(String userId, String passwd)
    {
        this.userId = userId;
        this.passwd = passwd;
    }

    public User() {}

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPasswd()
    {
        return passwd;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }
}
