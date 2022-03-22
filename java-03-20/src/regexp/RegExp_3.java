package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_3 {

	public static void main(String[] args) {


		String content = "宁老师|宁同学|宁家长";

		String reg = "宁(?:老师|同学|家长)";

		Pattern pat = Pattern.compile(reg);
		Matcher mat = pat.matcher(content);

		while (mat.find()) {
			System.out.println(mat.group(0));
		}

	}
}
