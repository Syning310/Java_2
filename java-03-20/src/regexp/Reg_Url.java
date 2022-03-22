package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_Url {

	public static void main(String[] args) {

		String content = "https://www.bilibili.com/video/BV1r54y127Tc?spm_id_from=333.788.top_right_bar_window_default_collection.content.click";

		// 匹配 url
		// 思路：
		//   1、先确定url的开始： https:// | http://
		//   2、确定域名： ([\\w-]+\\.)+[\\w-]+$  匹配   www.bilibili.com
		//   3、最后结尾可以看成一体的： (\\/[\\w-?=&/%.#]*)?$
		String reg = "^((https|http)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";

		Pattern pat = Pattern.compile(reg);

		Matcher mat = pat.matcher(content);

		while (mat.find()) {
			System.out.println(mat.group(0));

		}

	}
}
