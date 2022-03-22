package datasource_;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class USE_ {


	@Test
	// 模拟解决ResultSet -- 封装成 --> ArrayList
	public void testToArrayList() {

		Connection cons = null;
		PreparedStatement pst = null;
		ResultSet ret = null;

		ArrayList<MyHome> list = new ArrayList<>();

		String sql = "select * from myhome";

		try {
			cons = JdbcUtilsByDruid.getConnection();
			pst = cons.prepareStatement(sql);

			ret = pst.executeQuery();

			while (ret.next()) {
				// 将ResultSet取出的记录，封装到MyHome对象，然后放入ArrayList对象
				Integer id = ret.getInt("id");
				String name = ret.getString("name");
				list.add(new MyHome(id, name));
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtilsByDruid.close(ret, pst, cons);
		}


		System.out.println("list集合数据 = ");
		Iterator<MyHome> it = list.iterator();
		while (it.hasNext()) {
			MyHome h = it.next();
			System.out.println(h);
		}

		// 甚至可以 return list;

	}


	public static void main(String[] args) {

		Connection cons = null;
		PreparedStatement pst = null;
		ResultSet ret = null;

		String sql = "select * from myhome";

		try {
			cons = JdbcUtilsByDruid.getConnection();  // 1、获取连接
			System.out.println(cons.getClass());
			pst = cons.prepareStatement(sql);         // 2、获取PreparedStatement，并关联sql语句

			ret = pst.executeQuery();   // 3、执行

			while (ret.next()) {
				int i = ret.getInt("id");
				String str = ret.getString("name");
				System.out.println(i + "\t" + str);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtilsByDruid.close(ret, pst, cons);
		}

	}
}
