package statement__;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Statem {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 让用户输入名字和密码
		System.out.print("请输入查询的id>: ");  // 1' or

		String id = sc.nextLine();  // 看到注入的效果，需要用到nextLine()读取一行(遇到\n 回车才结束)
									// next() 当接收到空格或者 ' 就表示结束

		System.out.print("请输入查询的name>: ");  // or '1'='1
		String name = sc.nextLine();



		// 读取Properties类的信息
		Properties pps = new Properties();

		pps.load(new FileInputStream("src\\work1.properties"));
		String user = (String)pps.get("user");
		String password = (String)pps.get("password");
		String url = (String)pps.get("url");
		String driver = (String)pps.get("driver");

		// 1、注册驱动
		Class.forName(driver);  // 类加载

		// 2、得到连接，java程序和MySQL DBMS建立网络连接
		Connection cn = DriverManager.getConnection(url, user, password);


		// 3、得到Statement
		Statement stt = cn.createStatement();



		// 4、组织SQL
		String cle = "select id, name from myhome where id = '" + id
				+ "' and name = '" + name + "' ";

		ResultSet ret = stt.executeQuery(cle);


		// 如果查询到一条记录，则说明该记录存在
		if (ret.next()) {
			int i = ret.getInt(1);
			String str = ret.getString(2);
			System.out.println(i + "\t" + str);
		} else {
			System.out.println("用户不存在");
		}





		ret.close();
		stt.close();
		cn.close();



	}
}
