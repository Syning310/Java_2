package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp_3 {

	public static void main(String[] args) {


		String content = "syning 宁 hongyan";

		String regStr = "ning|宁";



		Pattern pat = Pattern.compile(regStr);
		Matcher mar = pat.matcher(content);
		while (mar.find()) {
			System.out.println(mar.group(0));
		}




	}


}
