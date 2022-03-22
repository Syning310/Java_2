package jdbc_1;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectTest {



	// 第一种连接方式
	@Test
	public void connect00() throws SQLException {
		Driver dr = new Driver();

		String url = "jdbc:mysql://localhost:3306/tmp";

		Properties pps = new Properties();
		pps.setProperty("user", "root");
		pps.setProperty("password", "syning");

		Connection connection = dr.connect(url, pps);

		System.out.println(connection);

		connection.close();

	}

	// 第二种连接方式 : 使用反射
	@Test
	public void connect01() throws Exception {
		// 使用反射加载Driver类
		Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
		Driver dr = (Driver)cls.newInstance();

		String url = "jdbc:mysql://localhost:3306/tmp";

		Properties pps = new Properties();
		pps.setProperty("user", "root");
		pps.setProperty("password", "syning");

		Connection cn = dr.connect(url, pps);

		System.out.println(cn);

		cn.close();

	}

	// 第三种连接方式 : 使用DriverManager 替代 Driver 进行统一管理
	@Test
	public void connection02() throws Exception {
		Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
		Driver dr = (Driver)cls.newInstance();

		// 创建url 和  user和password
		String url = "jdbc:mysql://localhost:3306/tmp";
		String user = "root";
		String password = "syning";

   		// 注册驱动
		DriverManager.registerDriver(dr);


		Connection cn = DriverManager.getConnection(url, user, password);
		System.out.println(cn);

		cn.close();

	}

	// 第四种连接方式 : 使用Class.forName 自动完成注册驱动，简化代码
	// 推荐使用！！！
	@Test
	public void connection03() throws Exception {

		// 在源码，静态代码块在类加载时会执行一次
		// DriverManager.registerDriver(new Driver());
		// 因此注册Driver对象的工作已经完成
		Class<?> cls = Class.forName("com.mysql.jdbc.Driver");  // 这段反射代码没有依然可以成功

		// 1、MySQL驱动5.1.6可以无需Class.forName("com.mysql.jdbc.Driver");
		// 2、从jdk1.5以后，使用jdbc4，不再需要显示调用Class.forName()注册驱动
		// 		而是自动调用驱动jar包下的  META-INF\services\java.sql.Driver  文本中的类名称去注册
		// 3、建议还是写上

		// 创建url 和  user和password
		String url = "jdbc:mysql://localhost:3306/tmp";
		String user = "root";
		String password = "syning";

		Connection cn = DriverManager.getConnection(url, user, password);
		System.out.println(cn);

		cn.close();

	}

	// 第五种连接方式 : 在方式四 的基础上，增加配置文件，让连接mysql更加灵活
	@Test
	public void connection04() throws Exception {

		Properties pps = new Properties();
		pps.load(new FileInputStream("src\\mysql.properties"));

		String user = (String)pps.get("user");
		String password = (String)pps.get("password");
		String url = (String)pps.get("url");
		String driver = (String)pps.get("driver");



		Class cls = Class.forName(driver);


		Connection con = DriverManager.getConnection(url, user, password);


		System.out.println(con);

		con.close();

	}



}
