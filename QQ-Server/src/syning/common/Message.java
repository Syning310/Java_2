package syning.common;

import java.io.Serializable;

/**
 *   表示客户端和服务端通信时的消息对象
 *   为了能让此类上网络上传输，也需要实现Serializable接口，序列化
 *
 */
public class Message implements Serializable
{

    //消息的发送方
    private String sender;

    //消息的接收方
    private String getter;

    //消息内容
    private String content;

    //发送时间
    private String sendTime;

    //消息的类型：可能是文件，可能是文字，也可能是表情；可以在接口定义消息类型
    private String msType;





    public String getMsType() {
        return msType;
    }

    public void setMsType(String msType) {
        this.msType = msType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }


}
