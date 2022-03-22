package dao_.test;

import dao_.dao__.GoodsDAO;
import dao_.dao__.MyHomeDAO;
import dao_.domain_.Goods;
import datasource_.MyHome;
import org.junit.Test;

import java.util.List;

public class TestDAO_0 {

	// 测试 MyHomeDAO 对 myhome 表的 crud 操作
	@Test
	public void testMyHomeDAO() throws Exception {

		MyHomeDAO mydao = new MyHomeDAO();

		String sql1 = "select * from myhome";
		// 1、查询多条语句
		List<MyHome> lst = mydao.queryMulti(sql1, MyHome.class);

		System.out.println("多行查询结果 = ");

		for (MyHome h : lst) {
			System.out.println(h);
		}


		// 2、查询单行记录
		String sql2 = "select * from myhome where id = ?";

		// 返回一条记录，也就是一个对象
		MyHome h = mydao.querySingle(sql2, MyHome.class, 8);
		System.out.print("单行查询结果 = ");
		System.out.println(h);


		// 3、查找单列
		String sql3 = "select name from myhome where id = ?";
		Object obj = mydao.queryScalar(sql3, 10);
		System.out.print("单列查询结果 = ");
		System.out.println(obj);



		// 4、dml
		int i = mydao.update("update myhome set name = ? where id = ?",
				"卿", 10);
		System.out.println(i + " 行受到影响");


	}



	// 测试 GoodsDAO
	@Test
	public void testGoodsDAO() throws Exception {

		GoodsDAO gs = new GoodsDAO();

		// 插入数据
		String sqlInsert = "insert into goods values (1, '华为手机', 2000),"
				+ "(2, '苹果手机', 3000), (3, '小米手机', 2000), (4, 'vivo手机', null),"
				+ "(5, '三星手机', 2300), (6, '海尔手机', 1800), (7, '锤子手机', 5000),"
				+ "(8, '格力手机', null), (9, '格力手机', null)";

		//int i = gs.update(sqlInsert);
		//System.out.println(i + " 行语句受影响");


		// 查询语句
		String sqlSelect = "select * from goods";
		List<Goods> lst1 = gs.queryMulti(sqlSelect, Goods.class);
		for (Goods g : lst1) {
			System.out.println(g);
		}






	}

}
