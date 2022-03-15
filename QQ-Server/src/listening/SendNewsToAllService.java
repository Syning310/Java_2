package listening;

import syning.common.Message;
import syning.common.MessageType;
import utils.Utility;

import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SendNewsToAllService implements Runnable {


	@Override
	public void run() {
		// 为了可以多次推送新闻，用死循环
		while (true) {
			System.out.print("请输入服务器要推送的消息[输出exit表示退出推送服务]>: ");
			String news = Utility.readString(100);
			if (news.equals("exit")) {
				break;
			}

			String date = new Date().toString();
			// 构建消息，群发消息类型
			Message ms = new Message();
			ms.setSender("服务端");
			ms.setGetter("所有人");
			ms.setContent(news);
			ms.setSendTime(date);
			ms.setMsType(MessageType.MESSAGE_TO_ALL_MES);

			System.out.println("date: " + date + "\n"
					+ ms.getSender() + " say to all: " + ms.getContent());

			// 遍历当前所有的通信线程，得到Socket对象，并发送ms
			HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();  // 取得当前所有现在用户的线程集合
			Set<String> set = hm.keySet();  // 取得所有key的集合
			Iterator<String> it = set.iterator();  // 利用迭代器遍历集合

			// 依次获取与在线用户连接的Socket对象
			while (it.hasNext()) {
				String users = it.next(); // 遍历
				try {
					ObjectOutputStream oos =
							new ObjectOutputStream(ManageClientThreads.getServerConnectClientThread(users).getSocket().getOutputStream());
					oos.writeObject(ms);  // 发送消息
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
