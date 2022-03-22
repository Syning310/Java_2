package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_1 {

	public static void main(String[] args) {


		//String content = "123abc";
		//String reg = "^[0-9][a-z]*";  // 必须以一个数字开头，任意字母跟在后面
		//String reg = "^[0-9]+[a-z]+$";  // 必须以一个或多个数字开头，必须以一个或多个字母结尾
		//String reg = "^[0-9]*[a-z]*";


		String content = "yan ningq yuening ningu";
		String reg = "ning\\B";

		Pattern prt = Pattern.compile(reg);
		Matcher mat = prt.matcher(content);

		while (mat.find()) {
			System.out.println(mat.group(0));
		}


	}


}
