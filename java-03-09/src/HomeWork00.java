import java.lang.reflect.Field;

import java.lang.reflect.Method;

public class HomeWork00 {
	public static void main(String[] args) {



		// 3、创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，
		//     并调用getName()的方法打印name属性值

		try {
			// 类加载，取得PrivateTest的Class对象
			Class<?> cls = Class.forName("PrivateTest");

			// 得到一个PrivateTest的对象实例
			Object obj = cls.newInstance();

			// 得到私有属性name
			Field f = cls.getDeclaredField("name");
			f.setAccessible(true);  // 暴破

			f.set(obj, "尚亦宁");

			// 得到私有方法
			Method m = cls.getDeclaredMethod("getName");
			m.setAccessible(true);  // 暴破
			Object ret = m.invoke(obj);
			System.out.println((String)ret);


		} catch (Exception e) {
			e.printStackTrace();
		}




	}
}

// 1、定义PrivateTest类，私有属性name，并且属性值为hellokitty
// 2、提供getName的共有方法
class PrivateTest {
	private String name = "hellokitty";

	private String getName() {
		return name;
	}


}
