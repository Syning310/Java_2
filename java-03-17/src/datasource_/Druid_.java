package datasource_;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Druid_ {

	@Test
	public void testDruid() throws Exception {

		// 1、加入 Druid jar 包
		// 2、加入配置文件 druid.properties 放入 src 目录

		// 3、创建Properties对象，读取配置文件
		Properties pps = new Properties();
		pps.load(new FileInputStream("src\\druid.properties"));

		// 4、创建一个指定参数的数据库连接池,Druid连接池
		DataSource dse = DruidDataSourceFactory.createDataSource(pps);

		Connection cons = dse.getConnection();

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
