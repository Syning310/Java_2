package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_2 {

	public static void main(String[] args) {



		//String content = "a11c8";
		//String regStr = "[a-z]";  // 匹配 a-z 之间任意一个字符

		//String content = "abcABC,";
		//String regStr = "abc";   // 匹配 abc 字符串，默认区分大小写
		//String regStr = "(?i)abc"; // 匹配 abc 字符串，不区分大小写

		String content = "a11c8_	";
		//String regStr = "[^a-z]";  // 118  匹配不是 a-z 之间的任意一个字符
		//String regStr = "[^a-z]{2}"; // 11 匹配连续两个不是 a-z 之间的任意两个字符
		//String regStr = "[^0-9]";  // 匹配不是 0-9 之间的任意一个字符
		//String regStr = "\\d";  // 相当于 [0-9]
		//String regStr = "\\w";  // 匹配任意英文字符、数字和下划线 相当于[a-zA-Z0-9_]
		String regStr = "\\s";  // 匹配任何空白字符(空格，制表符等等)


		Pattern pt = Pattern.compile(regStr);
		Matcher mr = pt.matcher(content);
		while (mr.find()) {
			System.out.println("查询到 = " + mr.group(0));
		}





	}


}
