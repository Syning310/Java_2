package class_;

import java.io.Serializable;

public class AllTypeClass {
	public static void main(String[] args) {

    	// 外部类
		Class cls1 = String.class;

		// 接口
		Class cls2 = Serializable.class;


		// 数组
		Class cls3 = int[].class;
		System.out.println(cls3);


		// 注解
		Class cls4 = Deprecated.class;


		// 枚举
		Class cls5 = Thread.State.class;


		// void
		Class cls6 = void.class;
		System.out.println(cls6);


		// Class
		Class cls7 = Class.class;


		// 基本数据类型
		Class cls8 = int.class;



	}
}
