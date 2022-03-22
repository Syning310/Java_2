package batch_;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 演示JDBC 批处理
public class Batch_ {


	// 传统方法，添加5000条数据到admin表
	@Test
	public void noBatch() throws Exception {

		String sql = "insert into admin values(null, ?, ?)";


		long start = System.currentTimeMillis();
		// 1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2、连接到端口
		Connection cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb02", "root", "syning");

		// 3、得到PreparedStatement对象
		PreparedStatement pst = cons.prepareStatement(sql);


		// 4、执行
		for (int i = 0; i < 5000; ++i) {  // 五千次循环
			pst.setString(1, "n" + i);
			pst.setString(2, "666");
			pst.executeUpdate();
		}

		// 5、关闭连接
		pst.close();
		cons.close();


		long end = System.currentTimeMillis();
		System.out.println("传统方式耗时，一共使用了/毫秒 = " + (end - start));
	}
	// 测试，五千次insert语句，传统方式从注册驱动到关闭连接：一共耗时 3598 毫秒



	// 使用批处理的方式
	@Test
	public void batch() throws Exception {

		String sql = "insert into admin values(null, ?, ?)";

		long start = System.currentTimeMillis();
		// 1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2、连接端口
		Connection cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb02?rewriteBatchedStatements=true"
				, "root", "syning");
		// 3、得到PreparedStatement对象
		PreparedStatement pst = cons.prepareStatement(sql);

		// 添加sql语句到批处理包中
		for (int i = 0; i < 5000; ++i) {
			pst.setString(1, "n" + i);
			pst.setString(2, "666");

			// 将sql语句加入到批处理包中
			pst.addBatch();


			// 4、执行
			// 当有1000条语句时，再批量执行
			if ((i + 1) % 1000 == 0) {
				pst.executeBatch();
				// 清空
				pst.clearBatch();
			}
		}


		// 5、关闭连接
		pst.close();
		cons.close();

		long end = System.currentTimeMillis();
		System.out.println("批处理方式耗时，一共使用了/毫秒 = " + (end - start));
	}
	// 测试，批处理insert语句，从注册驱动到关闭连接，一共耗时 329 毫秒



}
