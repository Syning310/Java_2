package service;

import syning.common.FileMessage;
import syning.common.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 *   该类实现文件传输服务
 */
public class FileClientInteract {

	/**
	 *   单独发送文件
	 * @param src     源文件
	 * @param dest    目的地目录
	 * @param sender  发送者
	 * @param getter  接收者
	 */
	public void sendFileToOne(String src, String dest, String sender, String getter) {
		// 读取src文件，封装到FileMessage对象啊中
		FileMessage fm = new FileMessage();
		String date = new Date().toString();
		fm.setSendTime(date);  // 设置文件日期
		fm.setMsType(MessageType.MESSAGE_FILE_MES);  // 设置消息类型
		fm.setSender(sender); // 设置发送人
		fm.setGetter(getter); // 设置接收人

		FileInputStream fis = null;
		try {
			File f = new File(src);
			if (f.exists()) {
				// 文件存在
				long len = f.length();  // 文件的长度
				byte[] fileBytes = new byte[(int)len]; // 创建一个读取文件字节的数组
				// 读取文件的流
				fis = new FileInputStream(f);
				fis.read(fileBytes);  // 将src文件，读取到程序的字节数组中

				// 将文件对应的字节数组，设置到FileMessage
				fm.setFileBytes(fileBytes);
				fm.setScource(src);  // 设置文件来源
				fm.setDest(dest); // 设置文件目的地
				fm.setFileLen(len);  // 设置文件长度

				// 客户端控制台提示信息
				System.out.println("\ndate: " + date + "\n"
						+ sender + "FilePath: " + src + " \n\tto " + getter + " dest: " + dest);

				// 发送到服务端，由服务端转发
				ObjectOutputStream oos =
						new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
				oos.writeObject(fm);
			} else {
				// 文件不存在
				System.out.println("=====想要发送的文件不存在！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}




}
