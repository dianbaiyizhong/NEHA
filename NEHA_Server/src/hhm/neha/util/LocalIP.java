/**
 * 
 */
package hhm.neha.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LocalIP {
	private static final Log LOG = LogFactory.getLog(LocalIP.class);

	/**
	 * 本机ip地址,本机可能有多个IP地址，故返回的是一个String的List
	 * 
	 * @return
	 */
	private static List<String> getLocalIPs() {
		ArrayList<String> allIP = new ArrayList<String>();
		Enumeration<NetworkInterface> netInterfaces = null;
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
			while (netInterfaces.hasMoreElements()) {
				NetworkInterface ni = netInterfaces.nextElement();
				Enumeration<InetAddress> ips = ni.getInetAddresses();

				while (ips.hasMoreElements()) {
					String ip = ips.nextElement().getHostAddress();
					if (ip.equalsIgnoreCase("127.0.0.1")) {
						continue;
					}
					allIP.add(ip);
				}
			}
		} catch (Exception e) {
			LOG.warn("Get local IP address fail: " + e.getMessage());
			allIP.add("0.0.0.0");
		}
		return allIP;
	}

	/**
	 * 从IP地址列表中获取符合IPV4规范的IP地址，如果存在多个，则取第一个，如果不存在 则返回0.0.0.0
	 * 
	 * @param list
	 * @return
	 */
	public static String getLocalIP() {
		Pattern pattern = Pattern
				.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		for (String s : getLocalIPs()) {
			Matcher m = pattern.matcher(s);
			if (m.matches()) {
				return s;
			}
		}
		return "0.0.0.0";
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info(getLocalIP());
	}
}
