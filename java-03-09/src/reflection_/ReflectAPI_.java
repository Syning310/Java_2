package reflection_;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectAPI_ {
	public static void main(String[] args) throws Exception {

		// 得到Class对象
		Class<?> cls = Class.forName("reflection_.Person");

		// 1、getName():获取全类名
		System.out.println(cls.getName());
		System.out.println("------------------------------");

		// 2、getSimpleName():获取简单类名
		System.out.println(cls.getSimpleName());
		System.out.println("------------------------------");

		// 3、getFields():获取所有public修饰的属性，包含本类以及父类
		Field[] fs = cls.getFields();
		for (Field f : fs) {
			System.out.println("Person及父类的public属性 = " + f.getName());
		}
		System.out.println("------------------------------");


		// 4、getDeclaredFields():获取本类中所有属性，不包含父类
		Field[] fies = cls.getDeclaredFields();
		for (Field f : fies) {
			System.out.println("Person类的所有属性 = " + f.getName());
		}
		System.out.println("------------------------------");


		// 5、getMethods():获取所有public修饰的方法，包含本类以及父类
		Method[] ms = cls.getMethods();
		for (Method m : ms) {
			System.out.println("Person类及父类的public方法 = " + m.getName());  // 包括Object
		}
		System.out.println("------------------------------");


		// 6、getDeclaredMethods():获取本类中所有方法,不包含父类
		Method[] mis = cls.getDeclaredMethods();
		for (Method m : mis) {
			System.out.println("Person类的所有方法 = " + m.getName());
		}
		System.out.println("------------------------------");


		// 7、getConstructors():获取本类所有public修饰的构造器，只有本类，不包含父类
		Constructor<?>[] cons = cls.getConstructors();
		for (Constructor<?> c : cons) {
			System.out.println("Person类的public构造器 = " + c.getName());
		}
		System.out.println("------------------------------");


		// 8、getDeclaredConstructors():获取本类中所有构造器，包括私有
		Constructor<?>[] decons = cls.getDeclaredConstructors();
		for (Constructor<?> c : decons) {
			System.out.println("Person类中所有的构造器 = " + c.getName());
		}
		System.out.println("------------------------------");


		// 9、getPackage():以Package形式返回 包信息
		System.out.println("Person类的包信息 = " + cls.getPackage());
		System.out.println("------------------------------");


		// 10、getSuperclass():以Class形式返回父类信息，也就是说得到父类的Class对象
		Class<?> superCls = cls.getSuperclass();
		System.out.println("Person类的直接父类的Class对象 = " + superCls);
		System.out.println("------------------------------");


		// 11、getInterfaces():以Class[]形式返回接收信息


		// 12、getAnnotations():以Annotation[]形式返回注解信息
		Annotation[] as = cls.getAnnotations();
		for (Annotation a : as) {
			System.out.println("Person类的注解 = " + a);
		}



	}
}

@SuppressWarnings({"all"})
@Deprecated
class Person extends P{
	// 字段
	public String name;
	protected int age;
	String job;
	private int salary;

	// 方法
	public void func1() {
		System.out.println("Person的func1方法...");
	}

	protected void func2() {
		System.out.println("Person的func2方法...");
	}

	void func3() {
		System.out.println("Person的func3方法...");
	}

	private void func4() {
		System.out.println("Person的func4方法...");
	}

	public Person() {}
	public Person(String name) {}
	private Person(int age) {}
}

class P {
	public P() {}
	public P(String name) {}
	public String hobby;
	public void S() {
		System.out.println("P的S方法...");
	}
}
