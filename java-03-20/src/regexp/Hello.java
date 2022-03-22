package regexp;

import java.util.regex.Pattern;

public class Hello {
	public static void main(String[] args) {

		String content = "I am ning from syning.";

		String reg = ".*syning.*";

		boolean isMatch = Pattern.matches(reg, content);

		System.out.println("整体匹配： " + isMatch);


	}
}
