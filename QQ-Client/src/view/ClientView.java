package view;
import service.FileClientInteract;
import service.MessageInteract;
import service.UserClientService;
import utils.Utility;

/**
 *  客户端的菜单界面
 *
 */
public class ClientView
{

    // 控制是否退出菜单
    private boolean loop = true;

    // 用来接收用户的键盘收入
    private String key;


    // 用于 登录服务器/注册用户
    private UserClientService userClientService = new UserClientService();

    // 用于客户端与客户端的消息交互，本质是先发送消息给服务端，由服务端转发给直接的接收者
    private MessageInteract messInteract = new MessageInteract();

    // 用于传输文件
    private FileClientInteract fcit = new FileClientInteract();

    // 显示登录页面
    private void oneMenu()
    {
        while (loop)
        {
            System.out.println("======网络通信系统登录界面======");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 0 退出系统");

            System.out.print("请输入你的选择>: ");
            //读取一个字符串  1 或者 9
            key = Utility.readString(1);

            //根据用户的输入，来处理不同的逻辑
            switch (key)
            {
                case "1":
                {
                    System.out.print("请输入用户号>: ");
                    String userId = Utility.readString(10);  //限制用户名长度10个字符
                    System.out.print("请输入密码>: ");
                    String pwd = Utility.readString(20);   //限制密码长度20个字符

                    //这里需要把数据传到服务端，验证用户是否合法
                    if (userClientService.checkUser(userId, pwd))  //为true登录成功
                    {
                        System.out.println("======登录成功：欢迎 " + userId + " ======\n");
                        twoMenu(userId);
                    }
                    else  //否则登录失败
                    {
                        System.out.println("登录失败：用户名或密码错误\n");
                    }
                }
                    break;
                case "0":
                    System.out.println("退出系统");
                    loop = false;
                    break;
                default :
                    System.out.println("输入有误");
                    break;
            }
        }

    }

    // 二级菜单;登录成功进入的菜单
    // userId为当前登录中的用户ID
    private void twoMenu(String userId)
    {
        while (loop)
        {
            System.out.println("======(网络通信系统二级菜单(用户 " + userId +  " )======");
            System.out.println("\t\t 1 显示在线用户列表");
            System.out.println("\t\t 2 群发消息");
            System.out.println("\t\t 3 私聊消息");
            System.out.println("\t\t 4 发送文件");
            System.out.println("\t\t 0 退出系统");

            System.out.print("请输入你的选择>: ");
            //接收键盘输入的选择
            key = Utility.readString(1);

            switch (key)
            {
                case "1": //显示在线用户列表
                    //在UserClientService类中，写一个方法来获取在线用户列表
                    userClientService.onlineFriendList();
                    sleepS();
                    break;
                case "2": //群发消息
                    System.out.print("请输入群发的消息>: ");
                    String content = Utility.readString(100);  // 限制消息为100个字符
                    // 调用方法，将消息封装成Message对象，发送给服务端
                    messInteract.sendMessageToAll(content, userId); // 内容，发起者
                    break;
                case "3": //私聊消息
                    System.out.print("请输入消息的接收者(在线)>: ");
                    String getter = Utility.readString(10);  // 限制接收者的用户名为10个字符
                    System.out.print("请输入发送的内容>: ");
                    String conent = Utility.readString(100);  // 限制发送的消息为100个字符
                    // 将消息的接收者，和发送的消息传入到方法中
                    messInteract.sendMessageToOne(conent, userId, getter); // 内容，发起人，接收人
                    break;
                case "4": //发送文件
                    System.out.print("请输入接收文件的用户(在线)>: ");
                    String getterId = Utility.readString(10);  // 长度为10
                    System.out.print("发送文件的绝对路径>: ");
                    String src = Utility.readString(100);
                    System.out.print("发送文件的目的地>: ");
                    String dest = Utility.readString(100);

                    fcit.sendFileToOne(src, dest, userId, getterId);
                    break;
                case "0": //退出系统
                    // 调用方法，给服务端发送一个退出系统的Message
                    userClientService.logout();
                    //loop = false;  // logout中直接就System.exit(0)，直接关闭掉了进程
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }

        }

    }

    private static void sleepS() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        //测试
        new ClientView().oneMenu();
        System.out.println("客户端退出系统");

    }


}
