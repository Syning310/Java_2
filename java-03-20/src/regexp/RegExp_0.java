package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_0 {

	public static void main(String[] args) {

		String content = "11111111";


		//String reg = "a{3}";  // 表示匹配 aaa 字符串
		//String reg = "1{4}";  // 匹配 1111
		String reg = "1*";

		Pattern pat = Pattern.compile(reg);

		Matcher mat = pat.matcher(content);

		while (mat.find()) {
			System.out.println(mat.group(0));
		}


	}

}
