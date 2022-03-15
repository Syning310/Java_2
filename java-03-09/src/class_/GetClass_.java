package class_;


import syning.Cat;

// 取得Class对象的各种方法(6)
public class GetClass_ {
	public static void main(String[] args) {

		// 1、Class.forName(strPath);  Class的静态方法
		String strPath = "syning.Cat";
		try {
			Class cls1 = Class.forName(strPath);
			System.out.println(cls1);
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}


		// 2、类名.class    Cat.class  用于参数传递
		Class cls2 = Cat.class;
		System.out.println(cls2);


		// 3、对象.getClass()   m.getClass()   有对象实例
		Cat m = new Cat();
		Class cls3 = m.getClass();
		System.out.println(cls3);


		// 4、通过类加载器，来获取类的Class对象
		try {
			// 4.1先得到类加载器cat
			ClassLoader claLoader = m.getClass().getClassLoader();
			// 4.2通过类加载器得到Class对象
			Class cls4 = claLoader.loadClass(strPath);
			System.out.println(cls4);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// cls1， cls2， cls3， cls4  都是指向同一个对象


		// 5、基本数据类型
		Class cls5 = int.class;
		System.out.println(cls5);

		// 6、对应的包装类
		Class cls6 = Integer.TYPE;
		System.out.println(cls6);




	}
}
