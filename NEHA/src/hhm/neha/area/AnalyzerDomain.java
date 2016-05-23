package hhm.neha.area;

import hhm.neha.area.service.ContentService;
import hhm.neha.entity.Content;
import hhm.neha.framework.ApplicationContextFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;

public class AnalyzerDomain {
	private ApplicationContext context;

	public void Start(Content content) {
		try {
			URL url = new URL(content.getUrl());
			try {
				InetAddress[] address = InetAddress.getAllByName(url.getHost());

				// 获取ip地址
				String ip = address[0].getHostAddress();

				// System.out.println(ip);
				content.setIp(ip);

				String arr_lal[] = getIPXY(ip);

				if (arr_lal != null) {
					content.setLal(arr_lal[0] + "," + arr_lal[1]);

				}

				content.setCity(getAddressByIP(ip));

				context = ApplicationContextFactory.getInstance();

				ContentService service = (ContentService) context
						.getBean("contentService");

				service.save(content);

			} catch (UnknownHostException e1) {
				// e1.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public static String getAddressByIP(String strIP) {
		try {
			URL url = new URL("http://ip.qq.com/cgi-bin/searchip?searchip1="
					+ strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();

			Document doc = Jsoup.parse(result.toString());

			return "";

		} catch (IOException e) {
			return "读取失败";
		}
	}

	/**
	 * 获取指定IP对应的经纬度（为空返回当前机器经纬度）
	 * 
	 * @param ip
	 * @return
	 */
	static String ak = "oU5jofRjrAgcwFUneyKo8EE8";

	public static void main(String[] args) {
		String arr[] = getIPXY("218.75.124.130");
		System.out.println(arr[0] + "___" + arr[1]);
	}

	public static String[] getIPXY(String ip) {

		if (null == ip) {
			ip = "";
		}

		try {

			URL url = new URL("http://api.map.baidu.com/location/ip?ak=" + ak
					+ "&ip=" + ip + "&coor=bd09ll");
			InputStream inputStream = url.openStream();
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputReader);
			StringBuffer sb = new StringBuffer();
			String str;
			do {
				str = reader.readLine();
				sb.append(str);
			} while (null != str);

			str = sb.toString();
			if (null == str || str.isEmpty()) {
				return null;
			}

			// 获取坐标位子
			int index = str.indexOf("point");
			int end = str.indexOf("}}", index);

			if (index == -1 || end == -1) {
				return null;
			}

			str = str.substring(index - 1, end + 1);
			if (null == str || str.isEmpty()) {
				return null;
			}

			String[] ss = str.split(":");
			if (ss.length != 4) {
				return null;
			}

			String x = ss[2].split(",")[0];
			String y = ss[3];

			x = x.substring(x.indexOf("\"") + 1, x.indexOf("\"", 1));
			y = y.substring(y.indexOf("\"") + 1, y.indexOf("\"", 1));

			return new String[] { x, y };

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

}
