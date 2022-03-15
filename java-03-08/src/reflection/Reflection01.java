package reflection;


import java.io.FileInputStream;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

public class Reflection01 {
	public static void main(String[] args) {


		// 1、使用Properties类，读写配置文件
		Properties pps = new Properties();
		try {
			pps.load(new FileInputStream("src\\re.properties"));
		} catch (Exception fe) {
			fe.printStackTrace();
		}
		String classPath = pps.get("classfullpath").toString();
		String methodName = pps.get("method").toString();


		try {
			// 2、使用反射机制
			// 加载类
			Class cls = Class.forName(classPath);

			// 通过 cls 创建加载的类 syning.Cat 的实例
			Object obj1 = cls.newInstance();  // 步骤是在这里才在堆区创建出实例对象，使用的是无参构造器
			Object obj2 = cls.newInstance();  // newInstance在堆区创建出实例对象，使用的是无参构造器
			System.out.println(cls.hashCode());    // 460141958
			System.out.println(obj1.hashCode());   // 1163157884
			System.out.println(obj2.hashCode());   // 1956725890

			System.out.println("cls的运行类型是： " + cls.getClass());  // 运行类型是Class - java.lang.Class

			// 利用cls得到Cat的字段
			//Field name = cls.getField("name");  // getField不能得到私有的属性
			Field ageField = cls.getField("age");  // 得到专门指向Cat类的age属性的指针
			System.out.println(ageField.get(obj1));  // ageField.get(obj1);  把ageField指针，指向Obj1的age

			// 利用cls得到构造器
			Constructor contr = cls.getConstructor(); // ()可以指定构造器参数类型，返回无参构造器
			System.out.println(contr); // public syning.Cat()  无参构造器


			// 取得Cat的有参构造器
			// String.class 就是 String 类的 Class 对象
			Constructor con1 = cls.getConstructor(String.class, int.class);
			System.out.println(con1);  // public syning.Cat(java.lang.String,int)




		} catch (Exception e) {
			e.printStackTrace();
		}





	}
}
