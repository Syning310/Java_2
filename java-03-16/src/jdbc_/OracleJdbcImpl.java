package jdbc_;

public class OracleJdbcImpl implements JdbcInterface{
	@Override
	public Object getConnection() {
		System.out.println("得到oracle的连接");
		return null;
	}

	@Override
	public void crud() {
		System.out.println("oracle的增删改查");
	}

	@Override
	public void close() {
		System.out.println("关闭orcale连接");
	}
}
