package utils;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 演示如何使用JdbcUtils工具类，完成dml和select
public class USE_ {

	@Test
	public void testDML() {

		// 1、得到连接
		Connection cons =null;

		// 2、组织一个sql语句
		String sql = "update myhome set name = ? where id = ?";
		PreparedStatement prt = null;

		try {
			// 1、得到连接
			cons = JdbcUtils.getConnection();

			prt = cons.prepareStatement(sql);
			// 给占位符赋值
			prt.setString(1, "尚亦宁");
			prt.setInt(2, 1);

			// 执行
			int rows = prt.executeUpdate();
			System.out.println(rows > 0 ? "成功" : "失败");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JdbcUtils.close(null, prt, cons);
		}

	}

	@Test
	public void selectAll() {
		// 1、得到连接
		Connection cons = null;

		// 2、组织sql语句
		String sql = "select * from myhome where id = ?";
		PreparedStatement pst = null;
		ResultSet ret = null;

		try {

			// 1、得到连接
			cons = JdbcUtils.getConnection();

			pst = cons.prepareStatement(sql);

			pst.setInt(1, 5);

			// 3、调用语句，得到ResultSet 结果集
			ret = pst.executeQuery();
			while (ret.next()) {
				int i = ret.getInt("id");
				String name = ret.getString("name");
				System.out.println(i + "\t" + name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JdbcUtils.close(ret, pst, cons);
		}


	}


}
