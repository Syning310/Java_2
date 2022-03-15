package reflection_;


import java.lang.reflect.Constructor;

// 通过反射机制，创建实例
public class ReflectCreateInstance {
	public static void main(String[] args) {


		try {
			// 先获取User类的Class对象
			Class<?> cls = Class.forName("reflection_.User");


			// 1、通过public的无参构造器创建实例
			Object o = cls.newInstance();
			System.out.println(o);

			// 2、通过public的有参构造器创建实例
			Constructor<?> strt = cls.getConstructor(String.class);  // 取得对应的构造器
			Object obj1 = strt.newInstance("尚亦宁"); // 使用构造器对象创建实例
			System.out.println("obj1的运行类型是: " + obj1.getClass() + "\nobj1 = " + obj1);

			System.out.println("-------------------------------------");

			// 3、通过private的有参构造器创建实例，反射机制可以获取private的构造器来创建对象实例
			Constructor<?> cons = cls.getDeclaredConstructor(int.class, String.class);  // 得到私有构造器
			// 暴破
			cons.setAccessible(true);
			Object obj2 = cons.newInstance(3500, "尚亦宁");  // 创建对象实例
			System.out.println("obj2 = " + obj2);





		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


class User {
	private int age = 10;
	private String name = "宁";

	public User() {}

	public User(String name) {
		this.name = name;

	}

	private User(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public String toString() {
		return "User [age = " + age + ", name = " + name + "]";
	}
}
