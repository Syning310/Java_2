package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_2 {

	public static void main(String[] args) {

		// 分组

		String content = "syning s6060 ge0310das";

		//String reg = "\\d\\d\\d\\d";  // 匹配四个数组的字符串

		// 非命名分组：1、通过mat.group(0)，得到匹配到的字符串；2、mat.group(1)得到匹配到的第1个分组的内容；3、mat.group(2)得到匹配到的第2个分组的内容
		//String reg = "(\\d\\d)(\\d\\d)";

		// 命名分组：
		String reg = "(?<g1>\\d\\d)(?<g2>\\d\\d)";

		Pattern pat = Pattern.compile(reg);

		Matcher mat = pat.matcher(content);

		while (mat.find()) {
			System.out.println(mat.group(0));
			System.out.println("第一个分组 = " + mat.group(1));
			System.out.println("第二个分组 = " + mat.group(2));
			System.out.println("命名分组g1 = " + mat.group("g1"));
			System.out.println("命名分组g2 = " + mat.group("g2"));
		}


	}

}
