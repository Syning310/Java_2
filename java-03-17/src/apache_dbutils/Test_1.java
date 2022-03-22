package apache_dbutils;

import datasource_.JdbcUtilsByDruid;
import datasource_.MyHome;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

public class Test_1 {


	@Test
	// 使用 apache + druid 完成 返回结果是单行记录(单个对象)
	public void testQuerySingle() throws Exception {

		// 1、得到连接 druid
		Connection cons = JdbcUtilsByDruid.getConnection();

		// 2、创建 QueryRunner 对象
		QueryRunner qrr = new QueryRunner();

		// 3、执行相关的方法，返回 单个对象
		String sql = "select * from myhome where id = 3";

		// 因为知晓返回的是单行记录，也就是单个对象，使用的是Handler 是BeanHandler
		MyHome h = qrr.query(cons, sql, new BeanHandler<>(MyHome.class));
		System.out.println(h);


		JdbcUtilsByDruid.close(null, null, cons);


	}


}
