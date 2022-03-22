package exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Work_3 {
	public static void main(String[] args) {

		// 解析一个url
		// http://www.sohu.com:8080/abc/index.htm


		String url = "http://www.sohu.com:8080/abc/index.htm";

		String reg = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";

		//String[] arr = url.split(reg);

//		for (String s : arr) {
//			System.out.println(s);
//		}

		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(url);

		while (m.find()) {
			System.out.println("整体匹配 = " + m.group(0));
			System.out.println("协议 = " + m.group(1));
			System.out.println("域名 = " + m.group(2));
			System.out.println("端口 = " + m.group(3));
			System.out.println("文件名 = " + m.group(4));
		}


	}
}
