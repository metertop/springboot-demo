/**
 * 
 */
package com.example.demo.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static final String DATE_TIME_PATTERN = null;
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss.SSS）
	 */
	public static String formatDateTimeMillis(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}
	
	/**
	 * 得到指定时间的小时分钟字符串 格式（HH:mm:ss）
	 */
	public static String getHourMintue(Date date) {
		return formatDate(date, "HH:mm");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @Title: parseDate
	 * @Description: 将时间戳转换为 日期格式
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String parseDate(Long time, String pattern) {
		if (time == null) {
			return null;
		}
		return DateFormatUtils.format(time, pattern);
	}

	/**
	 * @Title: parseDate
	 * @Description: 将时间戳转换为 日期格式
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static Date parseTimeStamp2Date(Long time, String pattern) {
		if (time == null) {
			return null;
		}
		String date = DateFormatUtils.format(time, pattern);

		return parseDate(date);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 */
	public static Date StrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			if (StringUtils.isEmpty(str) || "null".equals(str)) {
				return new Date();
			}
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数（没有算上当前的那1天）
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 获取当前时间,N天之前/之后的开始时间
	 * 
	 * @return
	 */
	public static Date getTimeNDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * @Title: compareTwoDate
	 * @Description: 两个日期比较,相差几天（得出差值后 +1 是相差的天数）
	 * @param fDate 开始时间
	 * @param oDate 结束时间
	 * @return
   *
   * 该算法有bug ，无法精准计算出相差的天数
   * @author zhangning03
	 */
	public static int compareTwoDate(Date fDate, Date oDate) {
		if (null == fDate || null == oDate) {
			return -1;
		}
    long intervalMilli = oDate.getTime() - fDate.getTime();
    return (int) (intervalMilli / (24 * 60 * 60 * 1000)) + 1;

  }

	/**
	 * @Title: compareTwoDate
	 * @Description: 两个日期比较,后者减去前者,得到两者相差的毫秒数
	 * @param fDate
	 * @param oDate
	 * @return
	 */
	public static Long compareTwoDateTime(Date fDate, Date oDate) {
		if (null == fDate || null == oDate) {
			return -1l;
		}

		return oDate.getTime() - fDate.getTime();
	}

	public static Date getBeforeDawn(Date date) {
		try {
			String formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(formatDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getAfterDawn(Date date) {
		try {
			String formatDateStr = DateFormatUtils.format(date, "yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date formatDate = format.parse(formatDateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(formatDate);
			cal.add(Calendar.DATE, 1);
			return cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Title: isBetweenDate
	 * @Description: 校验两个时间是否在时间区间内
	 * @param start
	 *            起始时间
	 * @param end
	 *            结束时间
	 * @param validStart
	 *            要校验的起始时间
	 * @param validEnd
	 *            要校验的结束时间
	 * @return
	 */
	public static boolean isBetweenDate(Date start, Date end, Date validStart, Date validEnd) {
		Long validStartTime = validStart.getTime();
		Long validEndTime = validEnd.getTime();
		Long startTime = start.getTime();
		Long endTime = end.getTime();
		// validStartTime===2016-12-28 validEndTime==2016-12-29
		// startTime----2016-12-29 endTime== 2016-12-30
		if (validStartTime >= startTime && validStartTime <= endTime && validEndTime >= startTime
				&& validEndTime <= endTime) {
			return true;
		}
		return false;
	}

	/**
	 * @Title: isOrBetweenDate
	 * @Description: 校验两个时间是否在时间区间内,起始时间或者结束时间在区间范围内
	 * @param start
	 * @param end
	 * @param validStart
	 * @param validEnd
	 * @return
	 */
	@SuppressWarnings("unused")
	public static boolean isOrBetweenDate(Date start, Date end, Date validStart, Date validEnd) {

		Long startTime = start.getTime();
		Long endTime = end.getTime();
		if (validStart == null) {
			if (validEnd != null) {
				Long validEndTime = validEnd.getTime();
				if (validEndTime >= startTime && validEndTime <= endTime) {
					return true;
				}
			} else {
				return true;
			}
		} else {
			if (validEnd == null) {
				Long validStartTime = validStart.getTime();
				if (validStartTime >= startTime && validStartTime <= endTime) {
					return true;
				}
			} else {
				Long validStartTime = validStart.getTime();
				Long validEndTime = validEnd.getTime();
				if ((validStartTime >= startTime && validStartTime <= endTime)
						|| (validEndTime >= startTime && validEndTime <= endTime)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 根据年月日以及时间槽获取时间戳，精确到秒
	 * 
	 * @param yearMonthDayTimeSlot
	 *            1990-01-01_23
	 * @return
	 */
	public static Long getTimestamp(String yearMonthDayTimeSlot) throws Exception {
		String[] data = StringUtils.split(yearMonthDayTimeSlot, "_");
		String _yearMonthDay = data[0];
		String yesr = _yearMonthDay.substring(0, 4);
		String month = _yearMonthDay.substring(4, 6);
		String day = _yearMonthDay.substring(6, 8);
		String yearMonthDay = yesr + "-" + month + "-" + day;

		String timeSlot = data[1];
		Integer iTimeSlot = Integer.parseInt(timeSlot);
		iTimeSlot = iTimeSlot - 1;
		String sTime = "";
		if (iTimeSlot % 2 != 0) {
			Integer hour = iTimeSlot / 2;
			if (hour < 10) {
				sTime = "0" + hour + ":30:00";
			} else {
				sTime = hour + ":30:00";
			}
		} else {
			Integer hour = iTimeSlot / 2;
			if (hour < 10) {
				sTime = "0" + hour + ":00:00";
			} else {
				sTime = hour + ":00:00";
			}
		}
		yearMonthDay += " " + sTime;

		Date dateTime = DateUtils.StrToDate(yearMonthDay);
		Long maxDate = dateTime.getTime() / 1000;

		return maxDate;
	}

	/**
	 * 
	 * getDay:得到传入的时间是周几
	 * @param date
	 * @return
	 * @since JDK 1.7
	 */
	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 
	 * getHourOfDay:得到传入时间是当天几点
	 * @param date
	 * @return
	 * @since JDK 1.7
	 */
	public static int getHourOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 
	 * hourConvertToSecond:时间格式的字符串转换为分钟
	 * @param hour 格式为  HH:mm
	 * @return
	 * @since JDK 1.7
	 */
	public static int hourConvertToMinute(String hour) {
		if (StringUtils.isEmpty(hour)) {
			return 0;
		}
		String[] arr = hour.split(":");
		if (arr.length != 2) {
			return 0;
		}
		return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
	}

	/**
	 * 
	 * getDateSecond: 得到传入时间的 小时和分钟 的分钟数之和
	 * @param date
	 * @return  
	 * @since JDK 1.7
	 */
	public static int getDateMinute(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		System.out.println(getDateMinute(new Date()));

		// System.out.println(formatDate(parseDate("2010/3/6")));
		// System.out.println(getDate("yyyy骞碝M鏈坉d鏃�E"));
		// long time = new Date().getTime()-parseDate("2012-11-19").getTime();
		// System.out.println(time/(24*60*60*1000));20150713_20280413
		// 2027-10-17_2028-04-13
		// 2026-04-25_2027-10-16
		// 2024-11-01_2026-04-24
		// 2023-05-11_2024-10-31
		// 2021-11-17_2023-05-10
		// 2020-05-26_2021-11-16
		// 2018-12-03_2020-05-25
		// 2017-06-11_2018-12-02
		// 2015-12-19_2017-06-10
		// 2015-09-16_2015-12-18
		/*
		 * System.out.println(DateUtils.parseDate("2028-04-13"));
		 * System.out.println(compareTwoDate(DateUtils.parseDate("2015-11-23"),
		 * DateUtils.parseDate("2015-11-24")));
		 */
        System.out.println("=====");
		// System.out.println(DateUtils.formatDate(getTimeNDay(DateUtils.parseDate("2016-01-01"),-1),"yyyy-MM-dd"));
		/*
		 * System.out.println(DateUtils.isBetweenDate(
		 * DateUtils.parseDate("2027-10-17"), DateUtils.parseDate("2028-04-19"),
		 * DateUtils.parseDate("2016-12-27"),
		 * DateUtils.parseDate("2016-12-28")));
		 */
		/*
		 * Integer a = new Integer(2); Integer b =new Integer(2);
		 * System.out.println("====" + (a.intValue()==b.intValue()));
		 * System.out.println(formatDate(getTimeNDay(new
		 * Date(),0),"yyyy-MM-dd"));
		 */
		//	System.out.println(getAfterDawn(new Date()));
		System.out.println(getDayOfWeek(new Date()));
	}

	/**
	 * 时间转换成“20160912_24”
	 * @author ysf
	 * Date:2016年9月12日下午12:20:08
	 * @return
	 * @since JDK 1.6
	 */
	public static String getDateChangeTime() {
		String time = "";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 2);
		int year = cal.get(Calendar.YEAR);//获取年份
		int month = cal.get(Calendar.MONTH);//获取月份
		int day = cal.get(Calendar.DATE);//获取日
		int hour = cal.get(Calendar.HOUR_OF_DAY);//小时
		int minute = cal.get(Calendar.MINUTE);//分
		int timeSlot = 0;
		if (minute > 30) {
			timeSlot = (2 * hour) + 2;
		} else {
			timeSlot = (2 * hour) + 1;
		}
		time = year + "" + month + "" + day + "_" + timeSlot;
		return time;
	}



	/**
	 * 
	 * Compare:按给定的时间格式转换字符串时间并做比较 <br/>
	 *返回-2，表示比较失败;0表示时间相同;-1表示dateTime&lt;anotherDateTime; 1表示dateTime&gt;anotherDateTime
	 * @author tuaobin
	 * Date:2017年4月17日下午5:27:25
	 * @param dateFormat 时间转换器
	 * @param dateTime 时间（字符串格式）
	 * @param anotherDateTime 要比较的时间
	 * @return 返回-2，表示比较失败;0表示时间相同;-1表示dateTime&lt;anotherDateTime; 1表示dateTime&gt;anotherDateTime
	 * @since JDK 1.7
	 */
	public static int compare(SimpleDateFormat dateFormat, String dateTime, Date anotherDateTime) {
		if (dateFormat == null || dateTime.equals("") || dateTime == null || anotherDateTime == null)
		{
			return -2;
		}
		Date date = null;
		try {
			date = dateFormat.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return -2;
		}
		if (date != null && anotherDateTime != null)
		{
			return date.compareTo(anotherDateTime);
		}
		return -2;
	}

	/**
	 * 
	 * Compare:给定的时间格式转换字符串时间并做比较 <br/>
	 *返回-2，表示比较失败;0表示时间相同;-1表示dateTime&lt;anotherDateTime; 1表示dateTime&gt;anotherDateTime
	 *
	 * @author tuaobin
	 * Date:2017年4月17日下午5:36:48
	 * @param dateFormat 时间转换器
	 * @param dateTime 时间（字符串格式）
	 * @param anotherDateTime 要比较的时间（字符串格式）
	 * @return 返回-2，表示比较失败;0表示时间相同;-1表示dateTime&lt;anotherDateTime; 1表示dateTime&gt;anotherDateTime
	 * @since JDK 1.7
	 */
	public static int compare(SimpleDateFormat dateFormat, String dateTime, String anotherDateTime) {
		if (dateFormat == null || dateTime.equals("") || dateTime == null || anotherDateTime.equals("") || anotherDateTime == null)
		{
			return -2;
		}
		Date anotherDate = null;
		try {
			anotherDate = dateFormat.parse(anotherDateTime);
		} catch (ParseException e) {
			e.printStackTrace();
			return -2;
		}
		if (anotherDate != null)
		{
			return compare(dateFormat, dateTime, anotherDate);
		}
		return -2;
	}

	/**
	 * 返回一天的开始时间 yyyy-MM-dd 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getStartOfDay(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  format2.parse(format.format(date));
	}

	/**
	 * 返回一天的结束时间  yyyy-MM-dd 59:59:59
	 */
	public static Date getEndOfDay(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return  format2.parse(format.format(date));
	}


}
