package jdbc_;

public class TestJbdc {
	public static void main(String[] args) {
		// 完成对mysql的操作
		JdbcInterface ji = new OracleJdbcImpl();

		ji.getConnection();  // 通过接口来调用实现类

		ji.crud();

		ji.close();

	}
}
