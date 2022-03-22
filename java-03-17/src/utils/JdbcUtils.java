package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 *
 *  这是一个工具类，完成MySQL的连接和关闭
 *
 */
public class JdbcUtils {

	// 定义相关的属性，因为只需一份，因此写成static

	private static String user;  // 用户名
	private static String password; // 密码
	private static String url;  // url
	private static String driver;  // 驱动名


	// 在static代码块中初始化
	static {
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("src\\work1.properties"));
			// 读取相关属性值
			user = (String)properties.get("user");
			password = (String)properties.get("password");
			url = (String)properties.get("url");
			driver = (String)properties.get("driver");
		} catch (IOException e) {
			// 在实际应用中，可以这样处理
			// 1、将编译异常，转成运行异常
			// 2、这时调用者，可以选择捕获改异常，也可以选择默认处理该异常
			throw new RuntimeException(e);
		}

	}



	// 连接数据库，返回Connection
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	/**  关闭相关资源
	 *   1、ResultSet 结果集
	 *   2、Statement 或者 PreparedStatement
	 *   3、Connection
	 *
	 *   如果需要关闭资源，就传入对象，否则传入null
	 */
	 public static void close(ResultSet set, Statement statement, Connection connection) {
		// 判断是否为空
		 try {
			 if (set != null) {

				 set.close();

			 }
			 if (statement != null) {
				 statement.close();

			 }
			 if (connection != null) {
				 connection.close();
			 }
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }

	 }


}
