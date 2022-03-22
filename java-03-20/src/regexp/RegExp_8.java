package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_8 {

	public static void main(String[] args) {


		String content1 = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，" +
				"几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
				"2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。" +
				"在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布，" +
				"成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，" +
				"Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、格式化I/O及可变参数。";


		// 使用正则表达式，将 JDK1.3 和 JDK1.4 替换成 JDK

		content1 = content1.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
		System.out.println(content1);


		String content2 = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，" +
				"几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
				"2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。" +
				"在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。2004年9月30日，J2SE1.5发布，" +
				"成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），代号为“Tiger”，" +
				"Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、格式化I/O及可变参数。";


		Pattern pat = Pattern.compile("JDK(?:1\\.3|1\\.4)");
		Matcher mar = pat.matcher(content2);
		content2 = mar.replaceAll("JDK");
		System.out.println(content2);


		System.out.println("content1.equals(content2) = " + content1.equals(content2));




		// 要求验证一个手机号，必须是以 138 或 139 开头的 11 位数
		String phone = "13806033250";


		Pattern p = Pattern.compile("^(138|139)\\d{8}");
		Matcher m = p.matcher(phone);
		if (m.find()) {
			System.out.println(m.group(0));
			System.out.println("符合要求");
		} else {
			System.out.println("不符合要求");
		}


	}
}
