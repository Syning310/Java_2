package apache_dbutils;

import datasource_.JdbcUtilsByDruid;
import datasource_.MyHome;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class Test_0 {

	// 使用 apache-DBUtils 工具类 + druid 完成对表的 crud 操作
	@Test
	// 返回结果是多行的情况
	public void testQueryMany() throws Exception {

		// 1、得到连接 druid
		Connection cons = JdbcUtilsByDruid.getConnection();

		// 2、使用 DBUtils 类和接口，   先引入 DBUtils 相关的 jar 文件，加入到 lib 添加为库

		// 3、创建QueryRunnerww
		QueryRunner qy = new QueryRunner();  // org.apache.commons.dbutils.QueryRunner;

		// 4、QueryRunner对象，就可以执行相关的方法，返回 ArrayList 结果集

		// (1) query 方法就是执行 sql 语句，得到 ResultSet  --- 封装 ---> ArrayList 集合中
		// (2) 返回集合
		// (3) connection : 连接
		// (4) sql ： 执行的 sql 语句
		// (5) new BeanListHandler<>(MyHome.class) : 在将 ResultSet 取出到 MyHome 对象，然后封装到 ArrayList 对象中
		//     底层使用反射机制，去获取 MyHome 类的属性，然后进行封装
		// (6) Object... 就是给 sql 语句中的 ? 赋值的，可以有多个值，因为这是一个可变参数
		// (7) query方法底层得到的 ResultSet 和 PreparedStatement 会在 query 方法中关闭连接，
		List<MyHome> lst =
				qy.query(cons, "select * from myhome", new BeanListHandler<>(MyHome.class));

		System.out.println("myhome表 : ");
		for (MyHome m : lst) {
			System.out.println(m);
		}

		JdbcUtilsByDruid.close(null, null, cons);

	}


}
