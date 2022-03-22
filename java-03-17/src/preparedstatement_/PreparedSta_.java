package preparedstatement_;




// 演示PreparedStatement使用

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class PreparedSta_ {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 让用户输入名字和密码
		System.out.print("请输入查询的id>: ");
		String id = sc.nextLine();
		System.out.print("请输入查询的name>: ");
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


		// 3、得到PreparedStatement

		// 3.1 组织sql语句
		String sql = "select id, name from myhome where id = ? and name = ?";   // sql语句的 ？ 相当于占位符

		// 3.2 pstt指向的对象是，实现了PreparedStatement接口的实现类
		PreparedStatement pstt = cn.prepareStatement(sql);

		// 3.3 给 ？ 赋值
		pstt.setString(1, id);    // 给pstt关联的sql语句中的 ？ 赋值
		pstt.setString(2, name);


		// 4、执行select语句，使用executeQuery方法
		ResultSet ret = pstt.executeQuery();  // 之前连接时已经将sql关联给对象了，如果再填入sql又变成了 ？ 的那句String
		// 这里的executeQuery不能放sql，除非写死了 id = 1 and name = ning

		if (ret.next()) {
			int i = ret.getInt(1);
			String str = ret.getString(2);
			System.out.println(i + "\t" + str);
		} else {
			System.out.println("查无记录");
		}


		ret.close();
		pstt.close();
		cn.close();




	}
}
