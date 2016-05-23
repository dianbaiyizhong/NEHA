/**
 * 
 */
package hhm.neha.process;

import hhm.neha.area.Analyzer;
import hhm.neha.control.AnalysisSearchListControl;
import hhm.neha.control.WebScanControl;
import hhm.neha.control.WebScanPattern;
import hhm.neha.entity.AnalysisSearchList;
import hhm.neha.entity.EventList;
import hhm.neha.framework.ApplicationContextFactory;
import hhm.neha.gui.EventWebScanGUI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tika.exception.TikaException;
import org.hibernate.exception.JDBCConnectionException;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.xml.sax.SAXException;

import sun.util.logging.resources.logging;

import com.qawaa.httpclient.GetAction;
import com.qawaa.httpclient.HttpClientFactory;
import com.qawaa.httpclient.ResultData;
import com.qawaa.utils.NumberUtil;
import com.qawaa.utils.regex.Grouper;
import com.qawaa.utils.regex.Matched;
import com.qawaa.utils.regex.Matches;
import com.qawaa.utils.security.MD5;

/**
 * 
 * @comment 舆情事件的页面扫描线程 采用so新闻扫描
 * 
 */
public class WebSearchScanThread extends Thread implements Runnable {
	private static Log LOG = LogFactory.getLog(WebSearchScanThread.class);
	private volatile static WebSearchScanThread SCAN_THREAD;
	private EventList event;
	private WebScanControl wsControl = WebScanControl.getInstance();
	private AnalysisSearchListControl aslControl = AnalysisSearchListControl
			.getInstance();
	private boolean flag = true;
	private ApplicationContext context = ApplicationContextFactory
			.getInstance();
	private HttpClient httpClient = HttpClientFactory.createHttpClient(
			HttpClientFactory.SIMPLE, true);
	private String url;
	private static final int PAGE_SIZE = 10;// 每页条数
	private static int PAGE_NUMBER = 1;// 当前页数
	private static int PAGE_COUNT = 1;// 总页数
	private static boolean SCAN_NEXT_PAGE = true;// 是否扫描下一页
	private ResultData webData;

	/**
	 * 
	 */
	private WebSearchScanThread() {
		super();
	}

	public static WebSearchScanThread Instance() {
		if (SCAN_THREAD == null) {
			synchronized (WebSearchScanThread.class) {
				if (SCAN_THREAD == null)
					SCAN_THREAD = new WebSearchScanThread();
			}
		}
		return SCAN_THREAD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (flag) {
			try {
				event = wsControl.getNextEvent();
				PAGE_NUMBER = 1;
				PAGE_COUNT = 1;
				SCAN_NEXT_PAGE = true;
				if (event == null) {
					LOG.info(context.getMessage("event.web.scan.event.empty",
							null, Locale.CHINA));
					try {
						sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					this.scan();// 页面扫描
					this.updateScanDate();// 更新状态
					LOG.info("Scan finish, wait for next event...");

				}
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JDBCConnectionException e) {
				try {
					Thread.sleep(60000L);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}

	/**
	 * 停止页面扫描
	 */
	public void threadStop() {
		flag = false;
		SCAN_NEXT_PAGE = false;

	}

	/**
	 * 页面扫描
	 * 
	 * @throws TikaException
	 * @throws SAXException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private void scan() throws IOException, InterruptedException {
		EventWebScanGUI.setEventTextField(event.getEventTitle());
		if (event.getEventExp().getTime() < System.currentTimeMillis()) {
			wsControl.updateExpired(event.getEventId());
			LOG.info("更新舆情事件[ " + event.getEventId() + " ]状态至到期（41）.");
			return;
		}
		if (event.getEventKeyword() == null
				|| event.getEventKeyword().trim().isEmpty()) {
			wsControl.updateException(event.getEventId(), 61);
			LOG.error("舆情事件[ " + event.getEventId() + " ]监测关键字为空（61）.");
			return;
		}
		String words[] = event.getEventKeyword().trim().split("\\|");
		if (words.length == 0) {
			wsControl.updateException(event.getEventId(), 61);
			LOG.error("舆情事件[ " + event.getEventId() + " ]监测关键字为空（61）.");
			return;
		}
		StringBuffer buffer;
		for (int i = 0; i < words.length; i++) {
			PAGE_NUMBER = 1;
			PAGE_COUNT = 1;
			SCAN_NEXT_PAGE = true;
			buffer = new StringBuffer();
			if (words[i].trim().isEmpty())
				continue;
			buffer.append("http://news.so.com/ns?q=");
			buffer.append(URLEncoder.encode(words[i].replaceAll("\\s", ""),
					"UTF-8"));
			buffer.append("&tn=newstitle&rank=pdate&");
			StringBuffer buffer2 = null;
			List<String> urls = new ArrayList<String>();

			while (SCAN_NEXT_PAGE) {
				LOG.info("Wait for next page[" + PAGE_NUMBER + "]...");
				sleep(1000L);
				EventWebScanGUI.setScanCount();
				buffer2 = new StringBuffer(buffer);
				buffer2.append("pn=");
				buffer2.append(PAGE_NUMBER);
				this.url = buffer2.toString();
				this.webData = this.crawl();
				if (webData == null) {
					LOG.error("搜索失败");
					// 搜索失败
					SCAN_NEXT_PAGE = false;
					break;
				}
				if (webData.getContent() == null
						|| webData.getContent().trim().isEmpty()) {
					LOG.error("检索返回的数据为空");
					SCAN_NEXT_PAGE = false;
					break;
				}
				if (this.isLimitation(webData.getContent())) {
					wsControl.updateException(event.getEventId(), 62);
					LOG.error("舆情事件[ " + event.getEventId() + " ]监测关键字受限（62）.");
					SCAN_NEXT_PAGE = false;
					return;
				}
				if (this.isNotFind(webData.getContent())) {
					LOG.error("无检索数据");
					// 无检索数据
					break;
				}
				this.parserLi(urls);

				try {
					new Analyzer().start(words[i], webData.getContent(),
							event.getEventId());
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("hhm" + "error" + e.getMessage());

				}

				if (PAGE_NUMBER == 1) {
					this.parserWebCount(webData.getContent());
					// 获取总数
				}
				PAGE_NUMBER++;
				if (PAGE_NUMBER > PAGE_COUNT || PAGE_NUMBER > 20) {
					SCAN_NEXT_PAGE = false;
				}

			}
			urls.clear();
			urls = null;
		}
		if (event.getEventStatus() == 10) {
			wsControl.updateNormal(event.getEventId());
			LOG.info("更新舆情事件[ " + event.getEventId() + " ]状态至正常监测（20）.");
		}
	}

	/**
	 * 页面数据抓取
	 * 
	 * @throws TikaException
	 * @throws SAXException
	 * @throws IOException
	 */
	private ResultData crawl() {
		GetAction getAction = new GetAction(url.toString(), httpClient);
		if (event.getEventId().intValue() == 5000) {
			try {
				LOG.info(URLDecoder.decode(url.toString(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ResultData data = getAction.execute();

		// System.out.println(data.getContent());

		if (data.getStatusCode() != 200) {
			LOG.info("检索舆情事件[ " + event.getEventId() + " ]失败（"
					+ data.getStatusCode() + "）.");
			return null;
		}
		return data;
	}

	/**
	 * 关键词检索受限,受限返回true
	 * 
	 * @param content
	 * @return
	 */
	private boolean isLimitation(String content) {
		if (content == null) {
			return true;
		}
		return content.indexOf(WebScanPattern.WEB_CONTENT_SEARCH_LIMIT) > -1;
	}

	/**
	 * 是否没有检索到相关内容，没有检索到则返回true
	 * 
	 * @param content
	 * @return
	 */
	private boolean isNotFind(String content) {
		if (content == null) {
			return true;
		}
		return content.indexOf(WebScanPattern.SO_CONTENT_NOT_FIND) > -1;
	}

	/**
	 * 提取页面中的li标签
	 * 
	 * @param urls
	 * @throws IOException
	 * @throws SAXException
	 * @throws TikaException
	 * @throws InterruptedException
	 */
	private void parserLi(List<String> urls) {
		Matched li_matched = new Matched(WebScanPattern.SO_CONTENT_LI);
		Matches[] li_matches = li_matched.find(this.webData.getContent());
		if (li_matches == null || li_matches.length == 0) {
			LOG.error("System can not match tag with '<li>'");
			return;
		}
		boolean isRepeat = true;
		for (Matches matches : li_matches) {
			if (!matches.hasGroups())
				continue;
			Grouper group = matches.nextGroup();
			if (group.getGroup() == null || group.getGroup().trim().isEmpty()) {
				LOG.error("System can not match content with tag '<li>'");
				continue;
			}
			String c_link = parserLink(group.getGroup());
			if (c_link == null || c_link.trim().isEmpty()) {
				LOG.error("System can not match link with tag '<a>'");
				continue;
			}
			if (urls.contains(MD5.MD5Encode(c_link))) {
				continue;// 已经在本次检索的数据中了
			}
			String c_title = this.parserTitle(group.getGroup());
			if (c_title == null || c_title.trim().isEmpty()) {
				LOG.error("System can not match title with tag '<a>'");
				continue;
			}
			c_title = c_title.replaceAll("<.*?>", "");
			String c_count = this.parserCount(group.getGroup());

			Integer count = 0;
			try {
				// count = NumberUtil.string2Integer(c_count, 1);
				count = Integer.parseInt(c_count);
			} catch (Exception e) {
				LOG.warn("该条没有相关新闻");

			}
			Date date;
			// date = DateUtil.String2Date(this.parserDate(group.getGroup()),
			// WebScanPattern.DATE_FORMATS);
			date = new Date(this.parserDateTime(group.getGroup()));
			this.storage(c_title, c_link, date, count);
			isRepeat = false;
		}
		if (isRepeat)
			SCAN_NEXT_PAGE = false;
	}

	/**
	 * 解析LI中的链接
	 * 
	 * @param li_content
	 * @return
	 */
	private String parserLink(String li_content) {
		Matched link_matched = new Matched(WebScanPattern.SO_CONTENT_LI_URL);
		return link_matched.find(li_content, 0, 0);
	}

	/**
	 * 解析标题
	 * 
	 * @param li_content
	 * @return
	 */
	private String parserTitle(String li_content) {
		Matched title_matched = new Matched(WebScanPattern.SO_CONTENT_LI_TITLE);
		return title_matched.find(li_content, 0, 0);
	}

	/**
	 * 解析总数
	 * 
	 * @param li_content
	 * @return
	 */
	private static String parserCount(String li_content) {
		Matched count_matched = new Matched(WebScanPattern.SO_CONTENT_LI_COUNT);

		return count_matched.find(li_content, 0, 0);
	}

	/**
	 * 解析时间
	 * 
	 * @param li_content
	 * @return
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private String parserDate(String li_content) {
		Matched date_matched = new Matched(WebScanPattern.SO_CONTENT_LI_DATE);
		return date_matched.find(li_content, 0, 0);
	}

	/**
	 * 解析时间
	 * 
	 * @param li_content
	 * @return
	 */
	private long parserDateTime(String li_content) {
		Matched date_matched = new Matched(
				WebScanPattern.SO_CONTENT_LI_DATETIME);
		String time_string = date_matched.find(li_content, 0, 0);
		try {
			return Long.valueOf(time_string).longValue() * 1000L;

		} catch (Exception e) {
			return System.currentTimeMillis();
		}
	}

	/**
	 * 存储
	 * 
	 * @param title
	 * @param url
	 * @param date
	 * @param count
	 */
	private void storage(String title, String url, Date date, Integer count) {
		if (date.before(event.getEventStart())) {
			return;
		}
		AnalysisSearchList asl = aslControl.getEventList(url,
				this.event.getEventId());
		if (asl == null) {
			asl = new AnalysisSearchList();
			asl.setAslEventId(this.event.getEventId());
			asl.setAslPushDate(new Timestamp(date.getTime()));

			asl.setAslTitle(title);
			asl.setAslUrl(url);
			asl.setAslUrlMd5(MD5.MD5Encode(url));
			LOG.info("Save [" + url + "]");
		} else {
			if ((System.currentTimeMillis() - asl.getAslSearchDate().getTime()) < (60L * 1000L)) {
				return;
			}
			LOG.info("Update [" + url + "]");
		}
		asl.setAslCount(count);
		asl.setAslSearchDate(new Timestamp(System.currentTimeMillis()));
		aslControl.save(asl);
	}

	/**
	 * 分析总页数
	 * 
	 * @param content
	 */
	private static void parserWebCount(String content) {
		Matched matched = new Matched(WebScanPattern.SO_CONTENT_COUNT);
		String _count = matched.find(content, 0, 0);
		if (_count != null)
			_count = _count.replaceAll(",", "");
		int count = NumberUtil.string2Integer(_count, 1);
		PAGE_COUNT = count / PAGE_SIZE;
		if (count % PAGE_SIZE > 0)
			PAGE_COUNT += 1;
	}

	public static void main(String[] args) throws IOException {

		Response resp = Jsoup
				.connect(
						"http://news.so.com/ns?q=%E7%A7%91%E6%AF%94&pq=%E7%A7%91%E6%AF%94&rank=rank&src=srp&tn=news")
				.execute();
		Document doc = Jsoup.parse(resp.body());

		String content = doc.select("li[class=res-list hasimg]").get(0).html();

		System.out.println(content);
		// System.out.println(doc.select("li[class=res-list hasimg]").size());

		Matched count_matched = new Matched(
				"class=\"same\".*?>\\[相关新闻：(\\d+)\\]</a>");

		// System.out.println(count_matched.find(content).length);
		System.out.println(count_matched.find(content, 0, 0));
		// String content1 =
		// "<a class=\"news_title\" href=\"http://news.163.com/16/0427/04/BLKOFDCL00014AED.html\" target=\"_blank\"><em>科比</em>是新主帅人选吗?(图)</a>";

		// Matched li_matched = new Matched(
		// "<a.*?href=\"(http://.*?)\" target=\"_blank\">");
		// Matches[] li_matches = li_matched.find(content1);

		// System.out.println(li_matches.length);
	}

	/**
	 * 更新事件检索信息
	 */
	private void updateScanDate() {
		wsControl.updateScanDate(event.getEventId());
	}
}
