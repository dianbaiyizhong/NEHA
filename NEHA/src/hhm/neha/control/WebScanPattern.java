/**
 * 
 */
package hhm.neha.control;

import com.qawaa.utils.regex.Matched;

/**
 * 
 * @comment 页面扫描的正则表达式
 * 
 */
public class WebScanPattern {
	public static final String WEB_ALL_URL = "http://tieba.baidu.com/p/\\d+\\?.*";
	public static final String WEB_CONTENT_URL = "http://tieba.baidu.com/p/\\d+";
	public static final String WEB_CONTENT_SEARCH_LIMIT = "抱歉，根据相关法律法规和政策，相关结果不予展现";
	public static final String WEB_CONTENT_COUNT = "找到相关贴吧贴子(\\d+)篇";
	public static final String WEB_CONTENT_NOT_FIND = "抱歉，没有找到与“.*”相关的主题贴。";
	public static final String PAGE_NOT_FIND = "抱歉，你访问的贴子被隐藏，暂时无法访问";
	public static final String PAGE_NOT_FIND_DELETE = "很抱歉，你访问的贴子不存在。";
	public static final String SO_CONTENT_NOT_FIND = "抱歉，未找到和<span>“</span>.*?<span>”</span>相关的新闻内容。";
	public static final String SO_CONTENT_COUNT = "找到相关新闻约(.*?)个";
//	public static final String SO_CONTENT_LI = "<li class=\"res-list\">(.*?)</li>";
	public static final String SO_CONTENT_LI = "<li class=\"res-list.*?\">(.*?)</li>";
//	public static final String SO_CONTENT_LI_URL = "<a href=\"(http://.*?)\" target=\"_blank\">";
	public static final String SO_CONTENT_LI_URL = "<a.*?href=\"(http://.*?)\" target=\"_blank\">";

	public static final String SO_CONTENT_LI_TITLE = "target=\"_blank\">(.*?)</a>";
	//public static final String SO_CONTENT_LI_COUNT = "class=\"same\">(\\d+)条相同新闻</a>";
	public static final String SO_CONTENT_LI_COUNT = "class=\"same\".*?>\\[相关新闻：(\\d+)\\]</a>";

	@Deprecated
	public static final String SO_CONTENT_LI_DATE = "(\\d+-\\d+-\\d+ \\d+:\\d+:\\d+)</span>";
	public static final String SO_CONTENT_LI_DATETIME = "data.pdate=\"(\\d+)\">";
	public static final String[] DATE_FORMATS = { "yyyy-MM-dd HH:mm:ss" };

	public static void main(String[] args) {
		Matched m = new Matched(SO_CONTENT_LI_DATETIME);
		System.out
				.println(m
						.find("<span>•</span><a href=\"http://world.gmw.cn/2014-03/20/content_10721534.htm\" target=\"_blank\">美国第一夫人<em>米歇尔</em>今起<em>访华</em> 话题不涉及政治议题</a><span title=\"2014-03-20 07:47:00\" data-pdate=\"1395272820\">光明网 昨天07:47</span><a href=\"ns?q=rptid:c0d20c88ac693571&tn=newstitle\" class=\"same\">11条相同新闻</a>  </li>",
								0, 0));
	}
}
