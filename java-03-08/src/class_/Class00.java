package class_;


import syning.Person;

import java.lang.reflect.Field;

// 演示Class类的常用方法
public class Class00 {
	public static void main(String[] args) throws Exception {

		String classAllPath = "syning.Person";

		// 获取Person类对应的Class对象
		// <?>表示不确定的java类型
		Class<?> cls = Class.forName(classAllPath);

		// 1、输出cls.toString
		System.out.println(cls.toString());  // 输出: cls是属于哪个类的Class对象

		// 2、输出cls的运行类型
		System.out.println(cls.getClass());  // class(isClass) java.lang.Class(类的路径)

		// 3、得到包名
		System.out.println(cls.getPackage().getName()); // 输出: cls所属类存在的包

		// 4、得到全类名
		System.out.println(cls.getName());


		// 5、通过cls创建对象实例
		Person p = (Person)cls.newInstance();
		System.out.println(p);


		// 6、通过反射获得属性 age
		Field pAge = cls.getField("age");  // 相当于得到一个允许指向Person类，age字段的一次性指针(每次都要传入Person对象，才能操作)
		Object val = pAge.get(p);          // 传入一个Person类对象，反射回对象实例的age的值
		System.out.println(val);
		System.out.println(pAge.getName());  // age
		System.out.println(pAge.getType());  // int

		// 7、通过反射给字段赋值
		pAge.set(p, 2400);    // 需要传入Person对象，和要修改的值
		System.out.println(pAge.get(p));

		System.out.println("------------------------------");


		// 8、得到Person类的所有字段属性
		Field[] fies = cls.getFields();
		for (Field f : fies) {
			System.out.println(f.getName());
		}



	}
}
