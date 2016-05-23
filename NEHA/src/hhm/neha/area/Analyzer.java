package hhm.neha.area;

import java.io.IOException;

import hhm.neha.area.dao.impl.ContentDaoImpl;
import hhm.neha.area.pojo.ResultContent;
import hhm.neha.area.test.FileUtil;
import hhm.neha.entity.Content;

import org.apache.commons.httpclient.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.mortbay.jetty.security.SSORealm;

import com.qawaa.httpclient.GetAction;
import com.qawaa.httpclient.HttpClientFactory;
import com.qawaa.httpclient.ResultData;

public class Analyzer {
	private HttpClient httpClient = HttpClientFactory.createHttpClient(
			HttpClientFactory.SIMPLE, true);
	static ContentDaoImpl dataImpl = new ContentDaoImpl();

	public static void main(String[] args) throws IOException {
		String content = new FileUtil()
				.getFromTxt2("C:\\Users\\hhm\\Desktop\\1.txt");
		String content1 = Jsoup
				.connect(
						"http://news.so.com/ns?q=%E8%99%B9%E6%A1%A5%E6%9C%BA%E5%9C%BA%E7%81%AB%E7%81%BE&pn=2&tn=news&rank=rank&j=0")
				.timeout(6000).get().body().toString();
		new Analyzer().start("ss", content1, 88);
	}

	public void start(String keywords, String Content, int id) {


		Document doc = Jsoup.parse(Content);

		Elements e_ul = doc.select("ul[id=news]");

		for (int i = 0; i < e_ul.size(); i++) {

			Elements e_li = e_ul.get(i).select("li");

			for (int j = 0; j < e_li.size(); j++) {

				Elements e_url = e_li.get(j).select("a[class=same]");

				// for (int k = 0; k < e_url.size(); k++) {
				// System.out.println(e_url.get(k));
				// }
				if (e_url.size() >= 1) {
					// 证明有更多相关新闻的链接
					String more_url = "http://news.so.com/"
							+ e_url.get(0).attr("href");
					// 再次进行挖掘
					GetAction getAction = new GetAction(more_url, httpClient);
					ResultData data = getAction.execute();
					analyzerAgain(keywords, data.getContent(), id);

				} else {
					String url_title = e_li.get(j).select("a").get(0)
							.attr("href").toString();

					ResultContent rc = new ResultContent();

					rc.setEventId(id);
					rc.setKeyword(keywords);
					String title = e_li.get(j).select("a").get(0).text();
					rc.setUrl(url_title);
					rc.setTitle(title);
					TransAndPutInDB(rc);
					System.out.println(rc.toString());
				}

			}

		}

	}

	public void analyzerAgain(String keywords, String Content, int id) {
		Document doc = Jsoup.parse(Content);

		Elements e_ul = doc.select("ul[class=result]");

		for (int i = 0; i < e_ul.size(); i++) {

			Elements e_li = e_ul.get(i).select("li");

			for (int j = 0; j < e_li.size(); j++) {

				String url_title = e_li.get(j).select("a").get(0).attr("href")
						.toString();

				ResultContent rc = new ResultContent();

				rc.setEventId(id);
				rc.setKeyword(keywords);
				String title = e_li.get(j).select("a").get(0).text();
				rc.setUrl(url_title);
				rc.setTitle(title);
				TransAndPutInDB(rc);
				System.out.println(rc.toString());
			}
		}
	}

	static AnalyzerDomain ad = new AnalyzerDomain();

	public void TransAndPutInDB(ResultContent rc) {

		Content content = new Content();
		content.setUrl(rc.getUrl());
		content.setEventId(rc.getEventId());
		content.setKeyword(rc.getKeyword());

		// 接下来开始解析网址的域名
		ad.Start(content);

		// PointMultipleDailyService service = (PointMultipleDailyService)
		// context.getBean("pointMultipleDailyService");

	}

}
