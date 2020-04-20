package com.mufeng.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 获取系统时间及日期
 */
@Slf4j
public class DateAndTimeUtils {

	public static Date getSystemNowDate() {
		return new Date();
	}

	public static String getCurrentYear() {
		Calendar rightNow = Calendar.getInstance();
		String year = "";
		int yearint = rightNow.get(Calendar.YEAR);
		year = "" + yearint;
		return year;
	}

	public static String getCurrentMonth() {
		Calendar rightNow = Calendar.getInstance();
		String month = "";
		int monthint = rightNow.get(Calendar.MONTH);
		monthint += 1;
		if (monthint < 10) {
			month = "0" + monthint;
		} else {
			month = "" + monthint;
		}
		return month;
	}

	/**
	 * 获取当前时间上一个月份 格式：YYYYMM
	 * 
	 * @return
	 * @author mufeng
	 */
	public static String getCurrentLastYearMonth() {
		Calendar rightNow = Calendar.getInstance();
		String month = "";
		int monthint = rightNow.get(Calendar.MONTH);
		String year = "";
		int yearint = rightNow.get(Calendar.YEAR);
		if (monthint == 0) {
			monthint = 12;
			yearint -= 1;
		}
		year = "" + yearint;
		if (monthint < 10) {
			month = "0" + monthint;
		} else {
			month = "" + monthint;
		}
		String yearMonth = year + month;
		return yearMonth;
	}

	/**
	 * 取得当前日期格式为：2009年04月01日
	 * 
	 * @return
	 */
	public static String getTodayFomat() {
		Calendar rightNow = Calendar.getInstance();
		String year = "";
		String month = "";
		String day = "";
		int yearint = rightNow.get(Calendar.YEAR);
		int monthint = rightNow.get(Calendar.MONTH);
		monthint += 1;
		int dayint = rightNow.get(Calendar.DATE);
		year = "" + yearint;
		if (monthint < 10) {
			month = "0" + monthint;
		} else {
			month = "" + monthint;
		}
		if (dayint < 10) {
			day = "0" + dayint;
		} else {
			day = "" + dayint;
		}

		String outdatestr = year + "年" + month + "月" + day + "日";
		return outdatestr;
	}

	/**
	 * 得到当天的系统日期,存入到数据库 中的格式为yyyy-mm-dd</br>
	 * 如果是new Date()就有 则存入到数据库中的格式为 yyyy-mm-dd hh:mm:ss
	 * 
	 * @return Date
	 * @throws ParseException
	 * @throws ParseException
	 */
	public static Date getDateFromString() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			return sdf.parse(DateAndTimeUtils.getCurrSysDateY$M$D());
		} catch (ParseException pe) {
			log.error(pe.getMessage(), pe);
			return new Date();
		}

	}

	/**
	 * 将字符串转换成DATE类型
	 * 
	 * @param sDate 字符串为yyyy-mm-dd的形式
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateFromString(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			return sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换日期类型为字符串， 格式为yyyy-MM-dd
	 * 
	 * @return String
	 * @throws ParseException
	 */
	public static String getStringFromDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.setLenient(false);
			return sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 转换日期类型为字符串， 格式为yyyy-MM-dd
	 * 
	 * @return String
	 * @throws ParseException
	 */
	public static String getStringFromDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			sdf.setLenient(false);
			return sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 将字符串转换成DATE类型
	 * 
	 * @param sDate 字符串为yyyymmdd的形式
	 * @return
	 * @throws Exception
	 */
	public static Date getDateFromStringEx(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		Date date = null;
		try {
			date = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 日期指定向前向后N天
	 * 
	 * @param date
	 * @param daynumber -1 负数表示向前移，之前的时间
	 * @return
	 */
	public static Date dateAddorDcrea(Date date, int daynumber) {
		Date d = null;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, daynumber);
		d = c.getTime();
		return d;
	}

	/**
	 * 日期指定向前向后N天
	 * 
	 * @param Y$M$D 格式：2018-01-01
	 * @param daynumber -1 负数表示向前移，之前的时间
	 * @return
	 */
	public static String dateAddorDcrea(String Y$M$D, int daynumber) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(getDateFromString(Y$M$D));
		cl.add(Calendar.DAY_OF_YEAR, daynumber);
		String y = "" + cl.get(Calendar.YEAR);
		String m = "" + (cl.get(Calendar.MONTH) + 1);
		if (m.length() < 2) {
			m = "0" + m;
		}
		String d = "" + cl.get(Calendar.DAY_OF_MONTH);
		if (d.length() < 2) {
			d = "0" + d;
		}
		return y + "-" + m + "-" + d;
	}

	/**
	 * 取得日期前後幾個月份
	 * 
	 * @param workDate
	 * @param month
	 * @return
	 */
	public static Date getRelativeMonth(Date workDate, int month) {
		Calendar workCalendar = Calendar.getInstance();

		workCalendar.setTime(workDate);
		workCalendar.add(Calendar.MONTH, month);
		workDate = workCalendar.getTime();

		return workDate;
	}

	/**
	 * 得到当月的第一天
	 * 
	 * @param Date
	 * @return Date
	 * @author
	 */
	public static Date getMonthBegin(Date date) {
		Calendar monthOneDay = Calendar.getInstance();
		monthOneDay.setTime(date);
		monthOneDay.set(Calendar.DAY_OF_MONTH, 1);
		return monthOneDay.getTime();
	}

	/**
	 * 计算两日期之间的天数
	 * 
	 * @param start
	 * @param end
	 * @return int
	 */
	public static int getDaysBetween(Date start, Date end) {
		boolean negative = false;
		if (end.before(start)) {
			negative = true;
			Date temp = start;
			start = end;
			end = temp;
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(start);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		GregorianCalendar calEnd = new GregorianCalendar();
		calEnd.setTime(end);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);
		if (cal.get(Calendar.YEAR) == calEnd.get(Calendar.YEAR)) {
			if (negative) {
				return (calEnd.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR)) * -1;
			}
			return calEnd.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
		}
		int counter = 0;
		while (calEnd.after(cal)) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			counter++;
		}
		if (negative) {
			return counter * -1;
		}
		return counter;
	}

	/**
	 * 计算两日期之间的天数
	 * 
	 * @param start
	 * @param end
	 * @return int
	 */
	public static int getDaysBetween(String start, String end) {
		SimpleDateFormat sdfDash = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = null;
		Date eDate = null;
		try {
			sDate = sdfDash.parse(start);
			eDate = sdfDash.parse(end);
			return getDaysBetween(sDate, eDate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			return 0;
		}
	}

	/**
	 * 检查两个字符串日期的间隔天数
	 * 
	 * @param start
	 * @param end
	 * @return endDate.getTime() - startDate.getTime(),返回间隔天数
	 * @throws Exception
	 */
	public static int intervalDayYMD(String start, String end) {
		int intervalDay = 0;
		Date startDate = getDateFromStringEx(start);
		Date endDate = getDateFromStringEx(end);
		long interval = endDate.getTime() - startDate.getTime();
		intervalDay = new Long(interval / (1000 * 24 * 60 * 60)).intValue();
		return Math.abs(intervalDay);
	}

	/**
	 * 计算两日期之间的自然月份数
	 * 
	 * @param start
	 * @param end
	 * @return int
	 */
	public static int getMonthsBetween(Date start, Date end) {
		int counter = 0;
		boolean negative = false;
		if (end.before(start)) {
			negative = true;
			Date temp = start;
			start = end;
			end = temp;
		}
		Date b = getMonthBegin(start);
		Date e = getMonthBegin(end);
		int bd = getDaysBetween(b, start);
		int ed = getDaysBetween(e, end);

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(b);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		GregorianCalendar calEnd = new GregorianCalendar();
		calEnd.setTime(e);
		calEnd.set(Calendar.HOUR_OF_DAY, 0);
		calEnd.set(Calendar.MINUTE, 0);
		calEnd.set(Calendar.SECOND, 0);
		calEnd.set(Calendar.MILLISECOND, 0);
		while (calEnd.after(cal)) {
			cal.add(Calendar.MONTH, 1);
			counter++;
		}
		if (ed - bd > 0) {
			counter++;
		}
		if (negative) {
			counter = counter * -1;
		}
		return counter;
	}

	/**
	 * 判断两日期是否为同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return true-同一天
	 */
	public static boolean equalsDate(Date date1, Date date2) {
		if ((null != date1) && (null != date2)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date1).equals(sdf.format(date2));
		}
		return false;
	}

	/**
	 * 比较日期大小
	 * 
	 * @param start
	 * @param end
	 * @return start >= end return true;
	 * @throws Exception
	 */
	public static boolean compareDate(Date start, Date end) {
		return start.getTime() - end.getTime() >= 0;
	}

	/**
	 * 比较字符串日期大小， 传入的日期格式为 YYYYMMDD
	 * 
	 * @param start
	 * @param end
	 * @return start > end return 1, start = end return 0 , start < end -1;
	 * @throws Exception
	 */
	public static int compareDateYMD(String start, String end) {
		Date startDate = getDateFromStringEx(start);
		Date endDate = getDateFromStringEx(end);
		long interval = startDate.getTime() - endDate.getTime();
		if (interval > 0) {
			return 1;
		} else if (interval == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 比较字符串日期大小， 传入的日期格式为YYYY-MM-DD
	 * 
	 * @param start
	 * @param end
	 * @return start > end return 1, start = end return 0 , start < end -1;
	 * @throws Exception
	 */
	public static int compareDateY$M$D(String start, String end) {
		Date startDate = getDateFromString(start);
		Date endDate = getDateFromString(end);
		long interval = startDate.getTime() - endDate.getTime();
		if (interval > 0) {
			return 1;
		} else if (interval == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 根据给定日期，得到它属于的季度 return 1:一季度 return 2:二季度 return 3:三季度 return 4:四季度
	 */
	public static int getSeason(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = (cal.get(Calendar.MONTH)) + 1;
		if (month <= 3) {
			return 1;
		} else if (month >= 4 && month <= 6) {
			return 2;
		} else if (month >= 7 && month <= 9) {
			return 3;
		} else if (month >= 10 && month <= 12) {
			return 4;
		}
		return -1;
	}

	/**
	 * 根据某一日期，取得该日期所属周的第一天的日期 yyyy-MM-dd
	 */
	public static String getWhichWeekFirstDay(String date) {
		String result = "";
		Calendar workCalendar = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			workCalendar.setTime(f.parse(date));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		result = DateAndTimeUtils.getAfterDate(date, -(workCalendar.get(Calendar.DAY_OF_WEEK) - 1), 3);
		return result;
	}

	/**
	 * 根据某一日期，取得该日期所属周的最后一天的日期
	 */
	public static String getWhichWeekLastDay(String date) {
		String result = "";
		Calendar workCalendar = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			workCalendar.setTime(f.parse(date));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		result = DateAndTimeUtils.getAfterDate(date, 7 - (workCalendar.get(Calendar.DAY_OF_WEEK)), 3);
		return result;
	}

	/**
	 * 根据某一日期，取得该日期所属月的第一天的日期
	 */
	public static String getWhichMonthFirstDay(String date) {
		String result = "";

		try {
			result = date.substring(0, 7) + "-01";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 根据某一日期，取得该日期所属月的最后一天的日期
	 */
	public static String getWhichMonthLastDay(String date) {
		String result = "";
		Date d = null;
		Calendar workCalendar = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			workCalendar.setTime(f.parse(date));
			d = workCalendar.getTime();
			result = getLastDayOfMonthByDate(d);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return result;
	}

	/**
	 * 根据某一日期，取得该日期所属季的第一天的日期
	 */
	public static String getWhichSeasonFirstDay(String date) {

		String result = "";
		Calendar workCalendar = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			workCalendar.setTime(f.parse(date));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		switch (workCalendar.get(Calendar.MONTH)) {
		// 一季度
		case Calendar.JANUARY:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JANUARY));
			break;
		case Calendar.FEBRUARY:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JANUARY));
			break;
		case Calendar.MARCH:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JANUARY));
			break;
		// 二季度
		case Calendar.APRIL:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.APRIL));
			break;
		case Calendar.MAY:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.APRIL));
			break;
		case Calendar.JUNE:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.APRIL));
			break;
		// 三季度
		case Calendar.JULY:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JULY));
			break;
		case Calendar.AUGUST:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JULY));
			break;
		case Calendar.SEPTEMBER:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JULY));
			break;
		// 四季度
		case Calendar.OCTOBER:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.OCTOBER));
			break;
		case Calendar.NOVEMBER:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.OCTOBER));
			break;
		case Calendar.DECEMBER:
			result = DateAndTimeUtils.getFirstDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.OCTOBER));
			break;
		default:
			break;
		}

		return result;
	}

	/**
	 * 根据某一日期，取得该日期所属季的最后一天的日期
	 */
	public static String getWhichSeasonLastDay(String date) {

		String result = "";
		Calendar workCalendar = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			workCalendar.setTime(f.parse(date));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		switch (workCalendar.get(Calendar.MONTH)) {
		// 一季度
		case Calendar.JANUARY:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.MARCH));
			break;
		case Calendar.FEBRUARY:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.MARCH));
			break;
		case Calendar.MARCH:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.MARCH));
			break;
		// 二季度
		case Calendar.APRIL:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JUNE));
			break;
		case Calendar.MAY:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JUNE));
			break;
		case Calendar.JUNE:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.JUNE));
			break;
		// 三季度
		case Calendar.JULY:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)),
					String.valueOf(Calendar.SEPTEMBER));
			break;
		case Calendar.AUGUST:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)),
					String.valueOf(Calendar.SEPTEMBER));
			break;
		case Calendar.SEPTEMBER:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)),
					String.valueOf(Calendar.SEPTEMBER));
			break;
		// 四季度
		case Calendar.OCTOBER:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.DECEMBER));
			break;
		case Calendar.NOVEMBER:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.DECEMBER));
			break;
		case Calendar.DECEMBER:
			result = DateAndTimeUtils.getLastDayOfMonth(String.valueOf(workCalendar.get(Calendar.YEAR)), String.valueOf(Calendar.DECEMBER));
			break;
		default:
			break;
		}
		return result;
	}

	/**
	 * 根据某一日期，取该日期所属月的最后一天
	 */
	public static String getLastDayOfMonthByDate(Date date) {
		String returnString = "";
		Calendar workCalendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		workCalendar.setTime(date);
		workCalendar.add(Calendar.MONTH, 1);
		workCalendar.set(Calendar.DAY_OF_MONTH, 1);
		workCalendar.add(Calendar.DATE, -1);
		date = workCalendar.getTime();
		returnString = dateFormat.format(date);
		return returnString;
	}

	/**
	 * 根据某一年，某一季度，取该季度最后一天
	 */
	public static String getLastDayOfSeason(String year, String seasonV) {
		String result = "";
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			int season = Integer.parseInt(seasonV);
			switch (season) {
			case 1:
				result = getLastDayOfMonthByDate(f.parse(year + "-03-01"));
				break;
			case 2:
				result = getLastDayOfMonthByDate(f.parse(year + "-06-01"));
				break;
			case 3:
				result = getLastDayOfMonthByDate(f.parse(year + "-09-01"));
				break;
			case 4:
				result = getLastDayOfMonthByDate(f.parse(year + "-12-01"));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 根据某一年，某一季度，取该季度第一天
	 */
	public static String getFirstDayOfSeason(String year, String seasonV) {
		String result = "";
		try {
			int season = Integer.parseInt(seasonV);
			switch (season) {
			case 1:
				result = year + "-01-01";
				break;
			case 2:
				result = year + "-04-01";
				break;
			case 3:
				result = year + "-07-01";
				break;
			case 4:
				result = year + "-10-01";
				break;
			default:
				break;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 取月初日期
	 */
	public static String getFirstDayOfMonth(String year, String month) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String temp = year + "-" + month + "-01";
		try {
			return f.format(f.parse(temp));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 取月末日期
	 * 
	 * @param year
	 * @param monthV
	 * @return
	 */
	public static String getLastDayOfMonth(String year, String monthV) {
		String result = "";
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			result = getLastDayOfMonthByDate(f.parse(year + "-" + monthV + "-01"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 取指定年的上一年
	 */
	public static String getFirstYear(String year) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		try {
			date = dateFormat.parse(year);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		Calendar workCalendar = Calendar.getInstance();
		if (null != date) {
			workCalendar.setTime(date);
		}
		workCalendar.add(Calendar.YEAR, -1);
		date = workCalendar.getTime();
		String lastYear = workCalendar.get(Calendar.YEAR) + "";
		return lastYear;
		// return String.valueOf(date.getYear());
	}

	/**
	 * 根据传入的指定日期，取得这个日期前后的日期
	 * 
	 * @param day指定日期
	 * @param tot前后多少的日期计量
	 * @param type ：1表示年，2表示月，3表示日
	 * @return
	 */
	public static String getAfterDate(String day, int tot, int type) {
		Date date = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = f.parse(day);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		Calendar workCalendar = Calendar.getInstance();
		if (null != date) {
			workCalendar.setTime(date);
		}
		switch (type) {
		case 1:
			workCalendar.add(Calendar.YEAR, tot);
			break;
		case 2:
			workCalendar.add(Calendar.MONTH, tot);
			break;
		case 3:
			workCalendar.add(Calendar.DAY_OF_YEAR, tot);
			break;
		default:
			break;
		}

		date = workCalendar.getTime();
		return f.format(date);
	}

	/**
	 * 取当前日期所在周的首尾日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date[] getFirstAndEndDateForWeek(Date date) {
		Date[] da = new Date[2];
		Calendar c = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		da[0] = c.getTime();
		da[1] = dateAddorDcrea(da[0], 6);
		return da;
	}

	/**
	 * 取当前日期所在周的首尾日期
	 * 
	 * @param date
	 * @return
	 */
	public static String[] getFirstAndEndDateForWeek(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String[] da = new String[2];
		Date[] dd = null;
		try {
			dd = getFirstAndEndDateForWeek(sdf.parse(date));
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		if (dd != null) {
			da[0] = sdf.format(dd[0]);
			da[1] = sdf.format(dd[1]);
		}
		return da;
	}

	/**
	 * 判断给定日期是否当月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLastDayOfMonth(Date date) {
		if (null == date) {
			return false;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		return (max == day);
	}

	public static Long getMonth(Date startDate, Date endDate) {
		Long monthday = null;
		try {
			Calendar starCal = Calendar.getInstance();
			starCal.setTime(startDate);

			int sYear = starCal.get(1);
			int sMonth = starCal.get(2);
			int sDay = starCal.get(5);

			Calendar endCal = Calendar.getInstance();
			endCal.setTime(endDate);
			int eYear = endCal.get(1);
			int eMonth = endCal.get(2);
			int eDay = endCal.get(5);

			monthday = Long.valueOf((eYear - sYear) * 12 + (eMonth - sMonth));

			if (sDay < eDay) {
				monthday = Long.valueOf(monthday.longValue() + 1L);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return monthday;
	}

	/**
	 * yyyyMMdd日期字符串转换成yyyy-MM-dd
	 * 
	 * @param sDate
	 * @return sdf.setLenient(false);
	 * @throws Exception
	 */
	public static String yyyyMMdd2yyyyMMddDash(String sDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		SimpleDateFormat sdfDash = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = sdf.parse(sDate);
		return sdfDash.format(parse);
	}

	/**
	 * yyyy-MM-dd日期字符串转换成yyyy年MM月dd日
	 * 
	 * @param sDate
	 * @return sdf.setLenient(false);
	 * @throws Exception
	 */
	public static String yyyyMMddDash2Chinese(String sDate) {
		SimpleDateFormat sdfDash = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		Date parse = null;
		try {
			parse = sdf.parse(sDate);
		} catch (ParseException e) {
			log.error(e.getMessage(),e);
		}
		return sdfDash.format(parse);
	}

	/**
	 * HHmmss时间字符串转换成 HH:mm:ss
	 * 
	 * @param sDate
	 * @return
	 * @throws Exception
	 */
	public static String hhmmss2hhmmssDot(String sTime) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		SimpleDateFormat sdfDot = new SimpleDateFormat("HH:mm:ss");
		Date parse = sdf.parse(sTime);
		return sdfDot.format(parse);
	}

	/**
	 * 银行返回交易时间字符串转换成 HH:mm:ss
	 * 
	 * @param sTime
	 * @return
	 * @throws Exception
	 */
	public static String time2hhmmssDot(String sTime) throws Exception {
		StringBuffer sTimeBuffer = new StringBuffer();
		for (int i = 0; i < 6 - sTime.length(); i++) {
			sTimeBuffer.append("0");
		}
		sTimeBuffer.append(sTime);
		return hhmmss2hhmmssDot(sTimeBuffer.toString());
	}

	/**
	 * 取得当前系统时间，格式为HHmmss
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrHHmmSS() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		Date dtNow = new Date();
		return sdf.format(dtNow);
	}

	/**
	 * 取得当前系统时间，格式为HH:mm:ss
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrHHmmSSDot() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date dtNow = new Date();
		return sdf.format(dtNow);
	}

	/**
	 * 得到当前系统日期及时间，yyyy-MM-dd HH:mm:ss
	 * 
	 * @param sDate
	 * @return
	 * @throws Exception
	 */
	public static String getCurrSysDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		return sdf.format(c.getTime());
	}

	/**
	 * 得到当前系统日期及时间，yyyyMMddHHmmss
	 * 
	 * @param sDate
	 * @return
	 * @throws Exception
	 */
	public static String getCurrSysDateTimeYMDHMS() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar c = Calendar.getInstance();
		return sdf.format(c.getTime());
	}

	/**
	 * 当前系统日期，格式化成yyyy-MM-dd
	 */
	public static String getCurrSysDateY$M$D() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dtNow = new Date();
		return sdf.format(dtNow);
	}

	/**
	 * 当前系统日期，格式化成yyyyMMdd
	 */
	public static String getCurrSysDateYMD() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dtNow = new Date();
		return sdf.format(dtNow);
	}

	/**
	 * yyyy-MM-dd 返回 年月日的字符串数组
	 */
	public static String[] getDateArray(String dateStr) {
		String[] split = dateStr.split("-");
		return split;
	}

	/**
	 * yyyy-MM-dd 返回 年
	 */
	public static String getYearStr(String dateStr) {
		return getDateArray(dateStr)[0];
	}

	/**
	 * yyyy-MM-dd 返回 月
	 */
	public static String getMonStr(String dateStr) {
		return getDateArray(dateStr)[1];
	}

	/**
	 * yyyy-MM-dd 返回 日
	 */
	public static String getDayStr(String dateStr) {
		return getDateArray(dateStr)[2];
	}

	/**
	 * 金额转大写
	 * 
	 * @param amt
	 * @return
	 */
	public static String amtUppercase(BigDecimal numberOfMoney) {
		String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
		String CN_FULL = "整";
		String CN_NEGATIVE = "负";
		int MONEY_PRECISION = 2;
		String CN_ZEOR_FULL = "零元" + CN_FULL;
		StringBuffer sb = new StringBuffer();
		int signum = numberOfMoney.signum();
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}
		long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			number = number / 10;
			++numIndex;
		}
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}
}
