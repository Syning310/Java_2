package dao_.dao__;


import dao_.utils_.JdbcUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 *   BasicDAO， 是其他DAO的父类
 *	 泛型指定具体的类型
 */

public class BasicDAO <T> {

	private QueryRunner qr = new QueryRunner();

	// 开发通用的 dml 方法，针对任意的表
	public int update(String sql, Object... parameters) {
		Connection cons = null;

		try {
			cons = JdbcUtilsByDruid.getConnection();

			return qr.update(cons, sql, parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtilsByDruid.close(null, null, cons);
		}
	}


	/**
	 *   返回多个对象(查询结果是多行)，针对任意表
	 * @param sql     传入sql语句
	 * @param clazz   传入一个类的class对象，如MyHome对象，需要知道映射表记录的类
	 * @param parameters  传入 ? 的具体值，可以是多个
	 * @return  根据 clszz 返回对应的ArrayList集合
	 */
	public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {

		Connection cons = null;

		try {
			cons = JdbcUtilsByDruid.getConnection();

			return qr.query(cons, sql, new BeanListHandler<>(clazz), parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtilsByDruid.close(null, null, cons);
		}
	}

	// 查询单行结果
	public T querySingle(String sql, Class<T> clazz, Object... parameters) {

		Connection cons = null;

		try {
			cons = JdbcUtilsByDruid.getConnection();

			return qr.query(cons, sql, new BeanHandler<>(clazz), parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtilsByDruid.close(null, null, cons);
		}
	}

	// 查询单行单列的结果
	public Object queryScalar(String sql, Object... parameters) {

		Connection cons = null;

		try {
			cons = JdbcUtilsByDruid.getConnection();

			return qr.query(cons, sql, new ScalarHandler<>(), parameters);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtilsByDruid.close(null, null, cons);
		}
	}


}
