package reflection;


import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection00
{
	public static void main(String[] args) throws Exception {
		// 根据配置文件，re.properties 执行的信息，创建Cat对象并调用方法call

		// 1、传统方法 new 对象.call
		//new Cat().call();

		// 尝试用读文件的方法执行
		Properties p = new Properties();
		p.load(new FileInputStream("src\\re.properties"));

		String classfullpath = p.get("classfullpath").toString();
		String methodName = p.get("method").toString();

		System.out.println("classPath = " + classfullpath + "\tmethodName = " + methodName);

		// 2、创建对象，传统的方法行不通，因为必须是 new 类名
		// new classfullpath();  // 这是String类型，而且toString()也不管用






		// 3、使用反射机制解决问题
		// (1)加载类，返回Class类型的对象；Class是类名
		Class cls = Class.forName(classfullpath);

		// (2)通过cls得到加载的类 syning.Cat的对象实例
		Object o = cls.newInstance();  // 返回的类型是Object，但是运行类型是syning.Cat
		System.out.println("o的运行类型是 = " + o.getClass());

		// (3)通过 cls 得到加载的类 syning.Cat 的 methodName 的方法
		// 即：在反射中，可以把方法当成对象(万物皆对象);Method是类名
		Method method1 = cls.getMethod(methodName);


		System.out.println("----------------------------------------------");
		// (4)通过method1 来调用方法：即通过方法对象，来调用方法
		method1.invoke(o);  // 传统方法是 对象.方法() ， 反射机制是 方法.invoke(对象)


	}
}
