package jdbc_;

public class MysqlJdbcImpl implements JdbcInterface{
	@Override
	public Object getConnection() {
		System.out.println("得到mysql的连接...");
		return null;
	}

	@Override
	public void crud() {
		System.out.println("mysql的增删改查...");
	}

	@Override
	public void close() {
		System.out.println("关闭mysql连接...");
	}
}
