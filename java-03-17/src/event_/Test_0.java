package event_;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


// 演示JDBC中使用事务
public class Test_0 {

	// 创建表
	//@Test
	public void createTable() throws Exception {

		String sql = "create table account "
				+ "(id int primary key auto_increment,"
				+ "name varchar(32) not null default '', "
				+ "balance double not null default 0) character set utf8";

		// 1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2、得到连接,连接到机子的 MySQL DBMS 系统端口
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb02", "root", "syning");

		// 3、得到PreparedStatement
		PreparedStatement pst = cn.prepareStatement(sql);

		// 执行
		boolean ret = pst.execute();

		pst.close();
		cn.close();

	}


	// 添加语句
	//@Test
	public void insertAcc() throws Exception {

		String sql = "insert into account values (null, ?, ?), (null, ?, ?)";

		// 1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 2、得到连接到机子 DBMS 系统端口
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb02", "root", "syning");

		// 3、得到PreparedStatement
		PreparedStatement pst = cn.prepareStatement(sql);

		pst.setString(1, "宁");
		pst.setInt(2, 1100);
		pst.setString(3, "月");
		pst.setInt(4, 1900);


		int ret = pst.executeUpdate();

		System.out.println(ret + "rows 受到影响");

		// 关闭资源
		pst.close();
		cn.close();

	}


	// 没有使用事务，模拟转账业务
	@Test
	public void transaction() {
		// 转账的SQL语句
		String sql = "update account set balance = balance - ? where id = ?";
		String sql2 = "update account set balance = balance + ? where id = ?";

		try {
			// 1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 2、得到 DBMS 端口连接
			Connection cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb02", "root", "syning");

			// 3、得到PreparedStatement对象
			PreparedStatement pst = cons.prepareStatement(sql);

			// 4、执行
			pst.setInt(1, 100);
			pst.setInt(2, 1);
			int ret = pst.executeUpdate();   // 默认自动提交

			System.out.println(ret + "rows 语句受影响");

			// 没有使用事务，如果这里出现了异常，那么下面的代码不会执行

			pst = cons.prepareStatement(sql2);
			pst.setInt(1, 100);
			pst.setInt(2, 2);
			ret = pst.executeUpdate();

			System.out.println(ret + "rows 语句受影响");

			pst.close();
			cons.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	// 使用事务，模拟业务转账
	@Test
	public void event_stansaction() {
		// 转账的SQL语句
		String sql = "update account set balance = balance - ? where id = ?";
		String sql2 = "update account set balance = balance + ? where id = ?";

		Connection cons = null;
		PreparedStatement pst = null;

		try {
			// 1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、连接到 DBMS系统端口
			cons = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb02", "root", "syning");
			cons.setAutoCommit(false);  // 取消默认提交事务，并设置一个保存点

			// 3、得到PreparedStatement对象
			pst = cons.prepareStatement(sql);

			pst.setInt(1, 100);
			pst.setInt(2, 1);
			// 4、执行
			int ret = pst.executeUpdate();
			System.out.println(ret + "rows 语句受到影响");


			//ret = 1 / 0;  // 这里发生除0异常


			// 再次取得PreparedStatement对象
			pst = cons.prepareStatement(sql2);

			pst.setInt(1, 100);
			pst.setInt(2, 2);
			ret = pst.executeUpdate();
			System.out.println(ret + "rows 语句受到影响");

			// 这里提交事务
			cons.commit();

			// 关闭资源
			pst.close();
			cons.close();


		} catch (Exception e) {

			if (cons != null) {
				try {
					System.out.println("发生异常，回滚到开始时，撤销SQL操作");
					// 这里可以进行回滚，即撤销执行的SQL语句
					cons.rollback();  // 回滚到事务开启的地方
				} catch (SQLException s) {

					s.printStackTrace();
				}
			}

			e.printStackTrace();
		}


	}




}
