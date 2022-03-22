package homework_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Work1 {
	public static void main(String[] args) throws Exception {


		// 读取Properties类的信息
		Properties pps = new Properties();

		pps.load(new FileInputStream("src\\work1.properties"));
		String user = (String)pps.get("user");
		String password = (String)pps.get("password");
		String url = (String)pps.get("url");
		String driver = (String)pps.get("driver");


		Class<?> cls = Class.forName(driver);

		Connection cn = DriverManager.getConnection(url, user, password);

		String sql = "delete from myhome where id = 4";


		// Statement用于执行静态SQL语句，并返回其生成的结果的对象
		Statement stat = cn.createStatement();

		int rows = stat.executeUpdate(sql);

		System.out.println(rows > 0 ? "成功" : "失败");

		cn.close();



	}

	public static void sql1() {

		// 创建MyHome表
		String createMyHome = "create table myhome (id int, name varchar(32) )";

		// 添加5条数据
		String insertData = "insert into myhome values(1, '一一'), ('2', '瑶'), (3, '颜'), (4, '龙'), (5, '潇')";

		// 修改id=1，将name改成宁
		String updateData = "update myhome set name = '宁' where id = 1";

		// 删除id=4的记录
		String deleteData = "delete from myhome where id = 4";


	}

}
