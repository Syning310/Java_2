package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matcher_Method {
	public static void main(String[] args) {

		String content = "hello world hello shang hello ning hello";

		String reg = "hello";

		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(content);

		while (m.find()) {
			System.out.println("================");

			System.out.println("start = " + m.start());
			System.out.println("end = " + m.end());

			String mySub = content.substring(m.start(), m.end());
			System.out.println(mySub);
		}


		// 整体匹配方法，常用于，校验某个字符串是否满足某个规则
		System.out.println(m.matches());


		String newContent = m.replaceAll("嗨");
		System.out.println(newContent);


	}
}
