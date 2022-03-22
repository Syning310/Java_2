package regexp;

public class RegExp_9 {


	public static void main(String[] args) {


		// String 支持正则表达式

		String content = "hello#world-北京~simth";

		// 要求，按照 # 或 - 或 ~ 分割字符串
		String newStr = "";
		String[] strArr = content.split("#|-|~");
		for (String s : strArr) {
			newStr += s;
			System.out.println(s);
		}

		System.out.println(newStr);


	}
}
