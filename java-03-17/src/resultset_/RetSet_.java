package resultset_;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

// 演示select语句 返回ResultSet
public class RetSet_ {

	public static void main(String[] args) throws Exception {

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


		// 4、组织select语句
		String select = "select id, name from myhome";

		ResultSet retSet = stt.executeQuery(select);


		// 5、使用while循环取出数据
		// next方法让光标向后移动，如果没有更多行，则返回false
		while (retSet.next()) {
			int id = retSet.getInt(1);  // 获取该行记录的 第一列(第一个字段)，int类型
			String name = retSet.getString(2);  // 获取该行记录的 第二列(第二个字段)，string类型

			System.out.println(id + "\t" + name);


		}





		retSet.close();
		stt.close();
		cn.close();


	}

}
