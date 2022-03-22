package apache_dbutils;

import dao_.utils_.JdbcUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;

public class Test_3 {

	// 使用 apache + druid 完成 dml 语句
	@Test
	public void testDML() throws Exception {

		// 1、得到连接
		Connection cons = JdbcUtilsByDruid.getConnection();

		// 2、创建QueryRunner对象
		QueryRunner qrr = new QueryRunner();

		// 3、sql语句
		String sql = "insert into myhome values (?, ?)";

		// 执行 dml 操作是 update()，返回值是受影响的行数
		int i = qrr.update(cons, sql, 2, "汐");
		System.out.println(i + "rows 受影响");

		JdbcUtilsByDruid.close(null, null, cons);


	}


}
