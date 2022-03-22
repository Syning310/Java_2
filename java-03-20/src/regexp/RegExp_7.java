package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_7 {
	public static void main(String[] args) {


		String content = "我...我要...学学学学....java!";  // 把内容编程 我要学java!


		// 1、首先去掉所有的 .
		Pattern pat = Pattern.compile("\\.");
		Matcher mat = pat.matcher(content);
		content = mat.replaceAll("");  // 我我要学学学学java!

		// 2、去掉重复的字 : 1、使用(.)\\1+
		pat = Pattern.compile("(.)\\1+");  // 分组的捕获内容，记录到了 $1
		mat = pat.matcher(content);

		while (mat.find()) {
			System.out.println(mat.group(0));
		}

		// 使用反向引用 $1 来替换匹配到的内容
		content = mat.replaceAll("$1");  // 用相反引用，替换原来匹配到的内容：我我    学学学学
		System.out.println("content = " + content);



		// 也可以使用一条语句，去掉重复的字
		String conp = "我...我要...学学学学....java!";
		conp = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");

		System.out.println("conp = " + conp);


	}
}
