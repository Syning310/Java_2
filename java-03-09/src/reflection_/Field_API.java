package reflection_;

import java.lang.reflect.Field;

public class Field_API {
	public static void main(String[] args) throws Exception {


		// 得到Class对象
		Class<?> cls = Class.forName("reflection_.Person");

		// getDeclaredFields():获取本类中所有字段
		Field[] df = cls.getDeclaredFields();
		for (Field f : df) {
			System.out.println("Perosn类中的字段 = " + f.getName()
				+ " 该字段的修饰符值 = " + f.getModifiers()
				+ " 该字段的类型 = " + f.getType());
		}

	}
}
