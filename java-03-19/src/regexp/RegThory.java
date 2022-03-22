package regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

// java的正则表达式的底层实现
public class RegThory {

	public static void main(String[] args) {

		String content = "\"1977年，微软公司搬到西雅图的贝尔维尤（雷德蒙德），在那里开发PC编程软件。\\n\" +\n" +
				"\t\t\t\t\"1979年，MITS公司关闭，微软公司以修改BASIC程序为主要业务继续发展。公司创立初期以销售BASIC解译器为主。\" +\n" +
				"\t\t\t\t\"当时的计算机爱好者也常常自行开发小型的BASIC解译器，并免费分发。微软是少数几个BASIC解译器的商业生产商，\" +\n" +
				"\t\t\t\t\"微软BASIC逐渐成为公认的市场标准。此后，他们曾经试图以设计MSX家庭计算机标准来进入家用计算机市场，但结果不太成功。\\n\" +\n" +
				"\t\t\t\t\"1980年，IBM公司选中微软公司为其新PC编写关键的操作系统软件，这是公司发展中的一个重大转折点。由于时间紧迫，程序复杂";


		// 目标：匹配所有 4 位数的字符串

		// 说明：(1) \\d 表示一个任意的数字
		String regStr = "(\\d\\d)(\\d\\d)";

		// 2、创建模式对象[正则表达式对象]
		Pattern pat = Pattern.compile(regStr);

		// 3、创建匹配器：按照正则表达式对象，匹配content字符串
		Matcher mat = pat.matcher(content);

		// 4、开始匹配

		while (mat.find()) {
			System.out.println(mat.group(0));
			System.out.println(mat.group(1));  // groups[group*2], groups[group*2 + 1]  ，也就是 索引为2，索引为3
			System.out.println(mat.group(2));
		}


	}


}
