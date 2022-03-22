package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_1 {

	// 演示转义字符的使用
	public static void main(String[] args) {
		String content = "abc$(abc(123(";

		// 匹配 (  必须加上 \\
		// 如果匹配 .  若是没有加上 \\ 则会寻找所有的字符
		//String regStr = "\\.";
		//String regStr = "\\d{3}(\\d)?";
		String regStr = "\\D";
		Pattern pat = Pattern.compile(regStr);

		Matcher mar = pat.matcher(content);
		while (mar.find()) {
			System.out.println(mar.group(0));
		}


	}

}
