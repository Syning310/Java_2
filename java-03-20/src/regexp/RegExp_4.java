package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_4 {

	public static void main(String[] args) {

		String con = "hello111111111";

		String reg = "\\d+?";

		Pattern pat = Pattern.compile(reg);
		Matcher mat = pat.matcher(con);

		while (mat.find()) {
			System.out.println(mat.group(0));
		}


	}
}
