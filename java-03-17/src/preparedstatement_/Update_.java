package preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class Update_ {
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);

		// 让用户输入名字和密码
//		System.out.print("请输入添加的id>: ");
//		String id = sc.nextLine();
//		System.out.print("请输入添加的name>: ");
//		String name = sc.nextLine();


//		System.out.print("请输入需要修改的id>: ");
//		String id = sc.nextLine();
//		System.out.print("请输入name>: ");
//		String name = sc.nextLine();

		System.out.print("请输入删除的id>: ");
		String id = sc.nextLine();




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

		// 添加记录
		//String sql = "insert into myhome values (?, ?)";
		// 修改记录
		//String sql = "update myhome set name = ? where id = ?";
		// 删除记录
		String sql = "delete from myhome where id = ?";

		// 3.2 pstt指向的对象是，实现了PreparedStatement接口的实现类
		PreparedStatement pstt = cn.prepareStatement(sql);

		// 3.3 添加values
//		pstt.setString(1, id);
//		pstt.setString(2, name)

		// 修改语句
//		pstt.setString(1, name);
//		pstt.setString(2, id);

		// 删除语句
		pstt.setString(1, id);


		// 4、执行select语句，使用executeQuery方法
		int ret = pstt.executeUpdate();  // 之前连接时已经将sql关联给对象了，如果再填入sql又变成了 ？ 的那句String
		// 这里的executeQuery不能放sql，除非写死了 id = 1 and name = ning


		System.out.println(ret > 0 ? "成功" : "失败");

		pstt.close();
		cn.close();




	}
}
