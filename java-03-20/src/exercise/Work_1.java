package exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Work_1 {
	public static void main(String[] args) {


		// 验证电子邮箱格式是否合法

		String mail = "syning310@outlook.com";

		Pattern pat = Pattern.compile("^[\\w-]+@[a-zA-Z.]+[a-zA-Z]$");
		Matcher mat = pat.matcher(mail);

		System.out.println(mat.matches());

		while (mat.find()) {
			System.out.println(mat.group(0));
		}



	}
}
