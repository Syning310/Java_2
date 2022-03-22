package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_5 {


	public static void main(String[] args) {


		//String content = "尚亦宁";
		//String regStr = "^[\u0391-\uffe5]+$";  // 以一个汉字开头，可以接任意多个汉字，最后以汉字结尾

		//String content = "真真";
		//String regStr = "^[\u0391-\uffe5][\\u0391-\\uffe5]$";  // 以一个汉字开头，以一个汉字结尾，中间无内容

		//String content = "124121";
		//String regStr = "^[1-9]\\d{5}$";


		String content = "15606033250";
		String regStr = "^1(?:3|4|5|8)\\d{9}$";

		Pattern pat = Pattern.compile(regStr);
		Matcher mar = pat.matcher(content);

		while (mar.find()) {
			System.out.println(mar.group(0));
		}


	}
}
