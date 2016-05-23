/**
 * 
 */
package hhm.neha.util;

public class StringUtil {

	/**
	 * 字符串能否转换成int型数字
	 * 
	 * @param i
	 *            需要转换的数字
	 * @return 能转换返回true
	 */
	public static boolean str2Int(String i) {
		try {
			Integer.parseInt(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 字符串能否转换成Long型数字
	 * 
	 * @param 需要转换的数字
	 * @return 能转换返回true
	 */
	public static boolean str2Long(String i) {
		try {
			Long.parseLong(i);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 字符串能否转换成Short型数字
	 * 
	 * @param s
	 *            需要转换的数字
	 * @return 能转换返回true
	 */
	public static boolean str2Short(String s) {
		try {
			Short.parseShort(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 根据最长长度截取字符串 maxLength小于0时 返回原字符串 maxLength大于字符串长度时 返回原字符串
	 * 
	 * @param s
	 *            需要处理的字符串
	 * @param maxLength
	 *            最长长度 ,
	 * @return String
	 */
	public static String subString(String s, int maxLength) {
		if (s == null) {
			return null;
		} else {
			if (maxLength < 0) {
				return s;
			} else if (maxLength == 0) {
				return "";
			} else {
				if (maxLength >= s.length()) {
					return s;
				} else {
					return s.substring(0, maxLength);
				}
			}
		}

	}

	/**
	 * 字符串去噪
	 * 
	 * @param s
	 * @return
	 */
	public static String clearString(String str) {
		str = str.replaceAll("\r|\n|\t", "");
		str = str.replaceAll("&nbsp;", " ");
		str = str.replaceAll("<script.*?>.*?</script>", "");
		str = str.replaceAll("<SCRIPT.*?>.*?</SCRIPT>", "");
		str = str.replaceAll("<style.*?>.*?</style>", "");
		str = str.replaceAll("<STYLE.*?>.*?</STYLE>", "");
		str = str.replaceAll("<object.*?>.*?</object>", "");
		str = str.replaceAll("<OBJECT.*?>.*?</OBJECT>", "");
		str = str.replaceAll("<applet.*?>.*?</applet>", "");
		str = str.replaceAll("<APPLET.*?>.*?</APPLET>", "");
		str = str.replaceAll("<embed.*?>.*?</embed>", "");
		str = str.replaceAll("<EMBED.*?>.*?</EMBED>", "");
		str = str.replaceAll("<iframe.*?>.*?</iframe>", "");
		str = str.replaceAll("<IFRAME.*?>.*?</IFRAME>", "");
		str = str.replaceAll("<.*?>", "");
		str = str.replaceAll("<.*?/>", "");
		str = str.replaceAll("<br />", "");
		str = str.replaceAll("<|>", "");
		str = str.replaceAll("\\s+", " ");
		str = str.trim();
		return str;
	}

	/**
	 * 空对象转换为长度为0的字符串
	 * 
	 * @param object
	 * @return
	 */
	public static Object nullObjectToString(Object object) {
		if (object == null) {
			return "";
		} else {
			return object;
		}
	}

	/**
	 * 将字符串中的正则表达式会用到的字符替换为.
	 * 
	 * @param str
	 * @return
	 */
	public static String regexReplace(String str) {
		if (str == null) {
			return null;
		}
		str = str.replaceAll("\\?", ".");
		str = str.replaceAll("\\_", ".");
		str = str.replaceAll("\\-", ".");
		str = str.replaceAll("\\\\", ".");
		str = str.replaceAll("\\|", ".");
		str = str.replaceAll("\\(", ".");
		str = str.replaceAll("\\)", ".");
		str = str.replaceAll("\\<", ".");
		str = str.replaceAll("\\>", ".");
		str = str.replaceAll("\\[", ".");
		str = str.replaceAll("\\]", ".");
		str = str.replaceAll("\\{", ".");
		str = str.replaceAll("\\}", ".");
		str = str.replaceAll("\\^", ".");
		str = str.replaceAll("\\$", ".");
		str = str.replaceAll("\\+", ".");
		return str;
	}

	/**
	 * 把数组转换为字符串，中间使用指定的间隔符隔开.
	 * 
	 * @param array
	 *            数组，array = null 或者array.length=0时返回长度为0的字符串
	 * @param split
	 *            split为null时不使用间隔符
	 * @return
	 */
	public static String arrayToString(String[] array, String split) {
		if (array == null || array.length == 0) {
			return "";
		}
		if (split == null)
			split = "";
		StringBuffer buffer = new StringBuffer();
		for (String s : array) {
			if (s == null || s.equals(""))
				continue;
			buffer.append(s);
			buffer.append(split);
		}
		if (split.equals("")) {
			return buffer.toString();
		}
		String result = buffer.toString();
		if (result.endsWith(split)) {
			result = result.substring(0, (result.length() - split.length()));
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtil.regexReplace(""));

	}

}
