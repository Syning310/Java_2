package jdbc_1;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc00 {
	public static void main(String[] args) throws SQLException {


		// 前置工作：在项目下创建一个文件夹，如：lib
		// 将mysql.jar拷贝到该 目录下，点击 “添加到库” 加入到项目中


		// 1、注册驱动    com.mysql.jdbc.Driver
		Driver dr = new Driver();


		// 2、得到连接
		//   ① jdbc:mysql://   这是规定好的，表示协议，用过jdbc的方式连接mysql
		//   ② localhost 主机，因为所操作的数据库在本机，如果是在其他机子上，可以填ip地址
		//   ③ 3306 表示连接3306端口
		//   ④ tmp  表示连接到mysql dbms的tmp数据库
		//   ⑤ mysql的连接，本质就是socket连接
		String url = "jdbc:mysql://localhost:3306/tmp";

		// 2.1 将用户名和密码放入到Properties对象中
		Properties pps = new Properties();

		// 2.2 user和password是规定好的，后面的值视情况
		pps.setProperty("user", "root");  // 用户
		pps.setProperty("password", "syning");  // 密码

		// 2.3 获取连接
		Connection cont = dr.connect(url, pps);


		// 3、执行sql

		//String sql = "insert into actor values (null, '宁', '男', '2001-04-03', '1560')";
		String sql = "update actor set name = '颜', sex = '女' where name = '宁'";


		// Statement 用于执行静态SQL语句并返回其生成的结果的对象
		Statement stt = cont.createStatement();

		// 如果是 dml 语句，返回的就是受影响的行数
		int rows = stt.executeUpdate(sql);

		System.out.println(rows > 0 ? "成功" : "失败");


		// 4、关闭连接资源

		stt.close();
		cont.close();



	}
}
