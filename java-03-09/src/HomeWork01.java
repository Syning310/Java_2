


import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Constructor;

public class HomeWork01 {
	public static void main(String[] args) {



		try {
			// 得到File的Class对象
			Class<?> fcls = Class.forName("java.io.File");


			// 打印File的所有构造器
			Constructor<?>[] cons = fcls.getConstructors();

			for (Constructor<?> c : cons) {
				System.out.println(c);
			}


			// 取得构造器
			Constructor<?> cs = fcls.getConstructor(String.class);
			Object o = cs.newInstance("D:\\行为守则.txt");  // 创建File对象实例
			System.out.println("o的运行类型是 = " + o.getClass());


			// 读文件
			Reader bf = new FileReader((File)o);
			char[] chs = new char[1024];
			int readLen = 0;
			while ((readLen = bf.read(chs)) != -1) {
				System.out.println(new String(chs, 0, readLen));
			}

			bf.close();


		} catch (Exception e) {
			e.printStackTrace();
		}




	}
}
