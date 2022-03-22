package datasource_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class C3p0_ {


	// 方式一：相关参数再程序中指定
	@Test
	public void testC3p0_01() throws Exception {


		// 1、创建一个数据源对象
		ComboPooledDataSource cpds = new ComboPooledDataSource();

		// 2、通过配置文件work1.properties获取相关的信息
		Properties pps = new Properties();
		pps.load(new FileInputStream("src\\work1.properties"));

		String user = (String)pps.get("user");
		String password = (String)pps.get("password");
		String driver = (String)pps.get("driver");
		String url = (String)pps.get("url");


		// 3、给数据源 comboPooledDataSource 设置相关参数
		// 连接的管理是由 comboPooledDataSource 管理
		cpds.setDriverClass(driver);  // 设置驱动
		cpds.setJdbcUrl(url);
		cpds.setUser(user);
		cpds.setPassword(password);


		// 设置初始化连接数
		cpds.setInitialPoolSize(5);  // 初始化连接数

		cpds.setMaxPoolSize(25);  // 最大连接数，连接数的上限，如果不够，就会进等待队列

		// 这个方法就是从 DataSpurce 接口实现
		Connection cons = cpds.getConnection();  // 获取连接


		// 操作SQL语句



		cons.close();

	}




	// 第二种方式，使用配置文件模板来完成
	@Test
	public void testC3p0_02() throws Exception {

		// 1、将C3P0 提供的 C3P0.config.xml 拷贝到 src 目录下
		// 2、该文件制定了连接数据库和连接池的相关参数

		ComboPooledDataSource cbpd = new ComboPooledDataSource("hello");

		Connection cons = cbpd.getConnection();


		String sql = "select * from myhome";
		PreparedStatement pst = cons.prepareStatement(sql);

		ResultSet ret = pst.executeQuery();

		while (ret.next()) {
			int i = ret.getInt("id");
			String str = ret.getString("name");
			System.out.println(i + "\t" + str);
		}



		cons.close();




	}




}
