package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_6 {

	public static void main(String[] args) {


		//String content = "he3443llo world like i11 my yyy99999 xxx ";
		//String reg = "(\\d)\\1";  // 匹配两个连续相同的数字
		//String reg = "(\\d)\\1{4}";  // 匹配五个连续相同的数字
		//String reg = "(\\d)(\\d)\\2\\1";  // 匹配个位与千位相同，十位与百位相同的数 5225  1551


		String content = "12321-333999111";
		String reg = "\\d{4}-(\\d)\\1\\1(\\d)\\2\\2(\\d)\\3\\3";


		Pattern p = Pattern.compile(reg);

		Matcher m = p.matcher(content);

		while (m.find()) {
			System.out.println(m.group(0));
		}


	}
}
