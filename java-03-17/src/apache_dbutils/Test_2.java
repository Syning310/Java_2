package apache_dbutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import datasource_.JdbcUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Test_2 {


	// apache + druid 查询结果是单行单列的情况，返回的就是Object
	@Test
	public void testScalar() throws Exception {


		// 加入 Druid.jar包 和 加入 druid.properties 配置文件

		// 1、创建Properties对象，读取配置文件
		Properties pps = new Properties();
		pps.load(new FileInputStream("src\\druid.properties"));

		// 2、创建一个指定参数的数据库连接池，Druid连接池
		DataSource dse = DruidDataSourceFactory.createDataSource(pps);

		// 3、从连接池中取得一个连接
		Connection cons = dse.getConnection();
		// 返回单行单列的情况
		String sql = "select name from myhome where id = ?";

		// 4、创建 QueryRunner 对象，apache 提供的工具类
		QueryRunner qrr = new QueryRunner();

		// 因为返回的是一个对象，使用的handler就是ScalarHandler对象
		Object obj = qrr.query(cons, sql, new ScalarHandler<>(), 1);

		System.out.println(obj);


		JdbcUtilsByDruid.close(null, null, cons);


	}


}
