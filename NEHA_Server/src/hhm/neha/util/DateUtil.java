package hhm.neha.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 
 * @comment 日期帮助类
 * @version 1.3
 */
public class DateUtil {

	/**
	 * 将字符串类型日期转换为java.util.Date类型
	 * 
	 * @param s
	 *            字符串
	 * @return Date
	 */
	public static Date String2Date(String s) {
		try {
			Date date = DateFormat.getDateInstance().parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Error: 日期转换错误！");
			return new Date();
		}
	}

	/**
	 * 
	 * @param s
	 *            日期格式字符串
	 * @param date
	 *            需要转换的日期
	 * @return
	 */
	public static String formatDate(String s, Date date) {
		SimpleDateFormat sdf;
		try {
			sdf = new SimpleDateFormat(s);
		} catch (java.lang.IllegalArgumentException e) {
			e.printStackTrace();
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			System.out.println("ERROR:日期格式错误，采用默认格式yyyy-MM-dd HH:mm:ss SSS");
		}
		if (date != null) {
			return sdf.format(date);
		} else {
			System.out.println("ERROR:日期错误，采用当前实时日期");
			return sdf.format(new Date());
		}
	}

	/**
	 * 将日期的字符串格式转换为日期格式
	 * 
	 * @param date
	 *            日期的字符串
	 * @param dateFormat
	 *            日期格式
	 * @return
	 * @throws ParseException
	 */
	public static Date String2Date(String date, String[] dateFormat)
			throws ParseException {
		Date parsedDate = new Date();
		parsedDate = DateUtils.parseDate(date, dateFormat);
		return parsedDate;
	}

	/**
	 * 得到查询日期所在周的周一
	 * 
	 * @return yyyy-MM-dd
	 */
	public static Date getMondayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 1);
		return c.getTime();
	}

	/**
	 * 得到查询日期所在周周日
	 * 
	 * @return yyyy-MM-dd
	 */
	public static Date getSundayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayofweek == 0)
			dayofweek = 7;
		c.add(Calendar.DATE, -dayofweek + 7);
		return c.getTime();
	}

	/**
	 * 得到查询日期所在月最后一天
	 * 
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * 得到查询日期所在月第一天
	 * 
	 * @return
	 */
	public static Date getFristDateOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int days = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * 得到查询日期的下一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 得到查询日期的上一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeforeDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取指定日期所在天的最后时刻。example：2011-09-09 12：00：00 ->2011-09-09 23：59：59.999
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastTimeOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * 获取指定日期所在天的开始时刻。example：2011-09-09 12：00：00 ->2011-09-09 00：00：00.000
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginTimeOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}

	/**
	 * 获取当前时间小时段的开始时间example：2011-09-09 12：15：10 ->2011-09-09 12：00：00.000
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginTimeOfHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		cal.set(Calendar.MILLISECOND, 000);
		return cal.getTime();
	}

	/**
	 * 获取当前时间小时段的最后时间example：2011-09-09 12：15：10 ->2011-09-09 12：59：59.999
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastTimeOfHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();

	}

	private static SimpleDateFormat ft5 = new SimpleDateFormat(
			"yyyyMMddHHmmssSSS");

	/**
	 * 根据当前时间，返回yyyyMMddHHmmssSSS
	 * 
	 * @param date
	 * @return
	 */
	public static String getStringFt5(Date date) {
		String newDate = ft5.format(date);
		return newDate;
	}

	private static SimpleDateFormat ft3 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss.SSS");

	/**
	 * 根据当前时间，返回 yyyy-MM-dd HH:mm:ss.SSS
	 * 
	 * @param date
	 * @return
	 */
	public static String getStringFt3(Date date) {
		String newDate = ft3.format(date);
		return newDate;
	}

	/**
	 * 时间类型的转换
	 * 
	 * @param d
	 * @return
	 */
	public static String getStringFt3toFt5(String d) {
		java.util.Date date1;
		String newDate = "";
		try {
			date1 = ft3.parse(d);
			newDate = ft5.format(date1);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * 根据日期格式将一个字符串转换为Date类
	 * 
	 * @param date
	 *            需要转换的日期字符串
	 * @param format
	 *            日期格式
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateFromStringWithFormat(String date, String format)
			throws ParseException {
		DateFormat format1 = new SimpleDateFormat(format);
		return format1.parse(date);
	}

	/**
	 * 比较两个日期之间的天数,如果compDate在targetDate之前则返回一个正整数，反之返回一个负整数
	 * 
	 * @param compDate
	 *            要比较的日期
	 * @param targetDate
	 *            目标日期
	 * @return
	 */
	public static int getIntervalDate(Date compDate, Date targetDate) {
		long DAY = 24L * 60L * 60L * 1000L;
		return (int) ((targetDate.getTime() - compDate.getTime()) / DAY);
	}

	/**
	 * 根据日期获取所在年分的第X周，星期一为每周起点,跨年周计入下一年度。
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.setFirstDayOfWeek(Calendar.MONDAY);
		int week = cl.get(Calendar.WEEK_OF_YEAR);
		System.out.println(week);
		cl.add(Calendar.DAY_OF_MONTH, -7);
		int year = cl.get(Calendar.YEAR);
		if (week < cl.get(Calendar.WEEK_OF_YEAR)) {
			year += 1;
		}
		return year;

	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println(getBeforeDate(new Date()));
	}

}
