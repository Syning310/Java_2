package reflection_;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectAccessProperty {
	public static void main(String[] args) throws Exception {


		Class<?> cls = Class.forName("reflection_.Student");

		// 创建对象
		Object o = cls.newInstance();


		// 1、使用反射得到private的age字段
		Field f = cls.getDeclaredField("age");
		// 暴破
		f.setAccessible(true);
		// 设置 o 对象的值
		f.set(o, 3200);
		System.out.println(f.get(o));


		// 2、使用反射得到private的静态字段
		Field fs = cls.getDeclaredField("name");
		fs.setAccessible(true);  // 暴破
		fs.set(null, "尚亦宁");
		System.out.println(fs.get(null));



		// 3、使用反射得到非静态的private方法
		Method m = cls.getDeclaredMethod("func1");
		m.setAccessible(true);
		m.invoke(o);

		// 4、使用反射得到静态的private方法
		Method ms = cls.getDeclaredMethod("func2");
		ms.setAccessible(true);
		ms.invoke(null);

		// 5、获取有参的方法
		ms = cls.getDeclaredMethod("func3", int.class, double.class);
		ms.setAccessible(true);
		ms.invoke(null, 3, 3.14);


		// 每次指向方法都要重新暴破，才能使用private
		ms = cls.getDeclaredMethod("func2");
		ms.setAccessible(true);
		ms.invoke(null);



		// 6、反射的返回值
		Method mps = cls.getDeclaredMethod("add", int.class, int.class);
		mps.setAccessible(true);
		Object sum = mps.invoke(o, 10, 20);
		System.out.println("mps返回值的运行类型是 = " + sum.getClass());  // Integer



	}
}

class Student {
	private int age;
	private static String name;

	public Student() { }

	public String toString() {
		return "Student [age = " + age + ", name = " + name + "]";
	}

	private void func1() {
		System.out.println("student func1");
	}

	private static void func2() {
		System.out.println("student static func2");
	}

	private static void func3(int a, double d) {
		System.out.println("student static func3");
	}

	private int add(int a, int b) {
		return a + b;
	}

}

