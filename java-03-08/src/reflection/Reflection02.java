package reflection;

import syning.Cat;

import java.lang.reflect.Method;

public class Reflection02 {
	public static void main(String[] args) throws Exception {
		func1();
		func2();
		func3();
		Class cls = Class.forName("syning.Cat");
		Class cls2 = Class.forName("syning.Cat");
		Class cls3 = Class.forName("syning.Cat");
	}

	// 传统方法调用Cat的call
	public static void func1() {
		Cat cat = new Cat();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 90000000; ++i) {
			cat.add();
		}
		long end = System.currentTimeMillis();
		System.out.println("func1方法的耗时: " + (end - start));
	}
	// 反射机制调用Cat的call
	public static void func2() throws Exception {
		Class cls = Class.forName("syning.Cat");
		Object obj = cls.newInstance();      // 得到一个Cat运行对象
		Method m = cls.getMethod("add");  // 指向Cat.Class中的call方法

		long start = System.currentTimeMillis();
		for (int i = 0; i < 90000000; ++i) {
			m.invoke(obj);  // 反射的方法调用Cat实例的方法
		}
		long end = System.currentTimeMillis();
		System.out.println("func2方法的耗时: " + (end - start));

	}

	// 反射调用优化，关闭访问检查
	public static void func3() throws Exception {
		Class cls = Class.forName("syning.Cat");
		Object obj = cls.newInstance();      // 得到一个Cat运行对象
		Method m = cls.getMethod("add");  // 指向Cat.Class中的call方法
		m.setAccessible(true);  // 在反射方法调用时，取消访问检查

		long start = System.currentTimeMillis();
		for (int i = 0; i < 90000000; ++i) {
			m.invoke(obj);  // 反射的方法调用Cat实例的方法
		}
		long end = System.currentTimeMillis();
		System.out.println("func3方法的耗时: " + (end - start));

	}
}
