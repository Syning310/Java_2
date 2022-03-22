package exercise;

public class Work_2 {

	public static void main(String[] args) {

		// 验证是不是整数或小数
		// 验证是整数还是负数
		// 如： 123	 -345 	34.89	 -87.8 	-0.01 	-0.45


		String number = "-123.321";


		// 先写出简单的正则式，再逐步完善
		String reg = "^[-+]?\\d+(\\.\\d+)?$";


		boolean b = number.matches(reg);

		System.out.println(b);



	}
}
