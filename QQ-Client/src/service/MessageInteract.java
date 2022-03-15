package service;


import syning.common.Message;
import syning.common.MessageType;

import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 	该类编写客户端发送消息给客户端的方法
 */
public class MessageInteract
{
	/**
	 *  发送私聊消息给服务端，由服务端转发给接收人
	 * @param content   发送内容
	 * @param senderId  发送者
	 * @param getterId  接收者
	 */
	public void sendMessageToOne(String content, String senderId, String getterId) {
		// 构建Messagae对象
		Message m = new Message();
		String date = new Date().toString();  // 发送消息的时间
		m.setMsType(MessageType.MESSAGE_COMM_MES);  // 设置消息类型为普通消息
		m.setSender(senderId);  // 设置消息发送者
		m.setGetter(getterId);  // 设置消息接收者
		m.setContent(content);  // 设置内容
		m.setSendTime(date);  // 设置发送时间
		System.out.println("date: " + date + "\n" + senderId + " to " + getterId + " say: " + content);

		// 发送给服务端
		try {
			ObjectOutputStream oos =
				new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
			oos.writeObject(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *   将要群发的消息封装成Message，发给服务端
	 * @param content   内容
	 * @param senderId  发送人
	 */
	public void sendMessageToAll(String content, String senderId) {
		Message ms = new Message();
		String date = new Date().toString();
		ms.setContent(content);  // 设置群发消息的内容
		ms.setMsType(MessageType.MESSAGE_TO_ALL_MES);  // 设置成群发消息的类型
		ms.setSender(senderId); // 设置发起人
		ms.setSendTime(date); // 设置时间
		System.out.println("date: " + date +  "\n" + senderId + " to all say: " + content);

		// 发送给服务端
		try {
			ObjectOutputStream oos =
					new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
			oos.writeObject(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
