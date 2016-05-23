/**
 * 
 */
package hhm.neha.util;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NumberUtil {
	private static final Log LOG = LogFactory.getLog(NumberUtil.class);

	/**
	 * 将String类型转换为BigDecimal类型
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @return BigDecimal
	 */
	public static BigDecimal string2BigDecimal(String s) {
		BigDecimal bd;
		try {
			bd = new BigDecimal(s);
		} catch (Exception e) {
			LOG.error("类型转换错误! MESSAGE:" + s + " TO " + "BigDecimal;返回空值");
			bd = null;
		}
		return bd;
	}

	/**
	 * 将String类型转换为Integer类型
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @return Integer
	 */
	public static Integer string2Integer(String s) {
		Integer i;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			LOG.error("类型转换错误! MESSAGE:" + s + " TO " + "Integer, 返回默认值：0");
			i = 0;
		}
		return i;
	}

	/**
	 * 判断String是否能转换为int类型 能转换返回true
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 尝试将String类型转换为Integer类型，如果转换不成功则使用默认值
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @param defaultInteger
	 *            默认值
	 * @return
	 */
	public static Integer string2Integer(String s, Integer defaultInteger) {
		Integer i;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			LOG.error("类型转换错误! MESSAGE:" + s + " TO " + "Integer; 使用默认值："
					+ defaultInteger);
			i = defaultInteger;
		}
		return i;
	}

	/**
	 * 将Long类型转换为Integer类型。如果超出Integer的最大范围，则返回Integer.MAX_VALUE;
	 * 如果小于Integer的最小范围，则返回Integer.MIN_VALUE。
	 * 
	 * @param i
	 *            需要进行转换的数值。如果i为空，则返回0
	 * @return
	 */
	public static Integer longToint(Long i) {
		if (i == null) {
			return 0;
		}
		if (i > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (i < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return i.intValue();

	}

}
