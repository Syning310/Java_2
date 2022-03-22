package regexp;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 正则表达式
public class Regexp_0 {


	public static void main(String[] args) {

		// 假定，编写了爬虫，从百度页面得到了如下字符串
		String content = "1977年，微软公司搬到西雅图的贝尔维尤（雷德蒙德），在那里开发PC编程软件。\n" +
				"1979年，MITS公司关闭，微软公司以修改BASIC程序为主要业务继续发展。公司创立初期以销售BASIC解译器为主。" +
				"当时的计算机爱好者也常常自行开发小型的BASIC解译器，并免费分发。微软是少数几个BASIC解译器的商业生产商，" +
				"微软BASIC逐渐成为公认的市场标准。此后，他们曾经试图以设计MSX家庭计算机标准来进入家用计算机市场，但结果不太成功。\n" +
				"1980年，IBM公司选中微软公司为其新PC编写关键的操作系统软件，这是公司发展中的一个重大转折点。由于时间紧迫，程序复杂" +
				"，微软公司以5万美元的价格从西雅图的一位程序编制者Tim Paterson（帕特森）手中买下了一个操作系统QDOS的使用权，" +
				"在进行部分改写后提供给IBM，并将其命名为Microsoft DOS（Disk Operating System，磁盘操作系统）。" +
				"IBM-PC机的普及使MS-DOS取得了巨大的成功，因为其他PC制造者都希望与IBM兼容。MS-DOS在很多家公司被使用。因此80年代，它成了PC的标准操作系统。\n" +
				"1983年，微软与IBM签订合同，为IBM的PC提供BASIC解译器，还有操作系统，微软公司的销售额超过1亿美元。" +
				"随后，微软公司继续为IBM、苹果公司以及无线电器材公司的计算机开发软件。随着微软公司的日益壮大，Microsoft与IBM已在许多方面成为竞争对手。\n" +
				"1985年，微软开始发行Microsoft Windows1.0，它是Windows系列的第一个产品，同时也是微软第一次对个人电脑操作平台进行用户图形界面的尝试。\n" +
				"1991年，由于利益的冲突，IBM公司、苹果公司解除了与微软公司的合作关系，但IBM与微软的合作关系从未间断过，" +
				"两个公司保持着既合作又竞争的复杂关系。微软公司的产品包括操作系统软件MS-DOS和Xenix。" +
				"Xenix是Unix操作系统其中一种个人电脑上的版本，是微软公司在1979年为Intel处理器所开发的，它能在DECPDP-11和Apple Lisa电脑上执行。" +
				"Xenix继承了UNIX的特性，XENIX具备多用户多任务的工作环境，符合UNIX System V的接口规格 （SVID）。\n" +
				"1983年，保罗·艾伦患霍奇金氏病离开微软公司，后来成立了自己的公司。艾伦拥有微软公司15%的股份，截止2019年2月23日，艾伦仍列席董事会。\n" +
				"1986年，公司转为公营。盖茨保留公司45%的股权，这使其成为1987年PC产业中的第一位亿万富翁。1992年，公司买进Fox公司，迈进了数据库软件市场。\n" +
				"二十世纪90年代中期，微软开始将其产品线扩张到计算机网络领域。微软在1995年8月24日推出了在线服务MSN（Microsoft Network，微软网络）。MSN是美国在线的直接竞争对手，也是微软其他网络产品的主打品牌。\n" +
				"1995年8月24日，微软公司发行内核版本号为4.0的一个混合了16位/32位的Windows系统—Windows 95，成为当时最成功的操作系统。\n" +
				"1996年，微软以及美国的广播业巨擘NBC（国家广播公司）联合创立了MSNBC，一个综合性的24小时新闻频道以及在线新闻服务供应商。\n" +
				"1995年至1999年，微软在中国相继成立了微软中国研究开发中心、微软全球技术支持中心和微软亚洲研究院三大世界级的科研、产品开发与技术支持服务机构， " +
				"微软中国成为微软在美国总部以外功能最为完备的子公司。";




		// 传统方法: 使用一个一个遍历的方式，代码量大，效率不高

//		// 提取文章中所有的英文单词
//		// 正则表达式技术
//		// 1、先创建一个Pattern对象，模式对象，可以理解成就是一个正则表达式对象
//		Pattern pt = Pattern.compile("[a-zA-Z]+");
//		// 2、创建一个匹配器对象
//		// 理解:Matcher匹配器按照 Pattern(模式/样式)，到content文本中去匹配
//		// 找到就返回true，否则就返回false
//		Matcher mr = pt.matcher(content);
//		// 3、开始循环匹配
//		while (mr.find()) {
//			// 匹配内容，文本，放到mr.group(0)
//			System.out.println(mr.group(0));
//		}
//
//
//
//
//		// 提取文章中所有的数字
//		// 1、先创建一个Pattern对象，模式对象，正则表达式对象
//		Pattern p2 = Pattern.compile("[0-9]+");
//
//		// 2、创建一个匹配器对象
//		Matcher m2 = p2.matcher(content);
//
//		while (m2.find()) {
//			System.out.println(m2.group(0));
//		}




  		// 提取文章中的数字和英文单词
		// 1、先创建一个Pattern对象，模式对象，正则表达式对象
		Pattern p3 = Pattern.compile("([0-9]+)|([a-zA-Z]+)");

		// 2、创建一个匹配器对象
		Matcher m3 = p3.matcher(content);

		while (m3.find()) {
			System.out.println(m3.group(0));
		}




	}

}
