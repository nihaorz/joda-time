package com.nihaorz.joda.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * 测试 joda-time 的一些常用方法
 * @author wangrui1066
 *
 */
public class JodaTimeTest {

	@Test
	public void test() {
		// 初始化时间
		DateTime dateTime = new DateTime(2012, 12, 13, 18, 23, 55);

		// 年,月,日,时,分,秒,毫秒
		DateTime dt3 = new DateTime(2011, 2, 13, 10, 30, 50, 333);// 2010年2月13日10点30分50秒333毫秒

		// 下面就是按照一点的格式输出时间
		String str2 = dateTime.toString("MM/dd/yyyy hh:mm:ss.SSS a");
		System.out.println("str2:" + str2);
		String str3 = dateTime.toString("dd-MM-yyyy HH:mm:ss");
		System.out.println("str3:" + str3);
		String str4 = dateTime.toString("EEEE dd MMMM, yyyy年 HH:mm:ssa");
		System.out.println("str4:" + str4);
		String str5 = dateTime.toString("MM/dd/yyyy HH:mm ZZZZ");
		System.out.println("str5:" + str5);
		String str6 = dateTime.toString("MM/dd/yyyy HH:mm Z");
		System.out.println("str6:" + str6);

		DateTimeFormatter format = DateTimeFormat
				.forPattern("yyyy-MM-dd HH:mm:ss");
		// 时间解析
		DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);

		// 时间格式化，输出==> 2012/12/21 23:22:45 Fri
		String string_u = dateTime2.toString("yyyy/MM/dd HH:mm:ss EE");
		System.out.println("string_u:" + string_u);

		// 格式化带Locale，输出==> 2012年12月21日 23:22:45 星期五
		String string_c = dateTime2.toString("yyyy年MM月dd日 HH:mm:ss EE",
				Locale.CHINESE);
		System.out.println("string_c:" + string_c);

		DateTime dt1 = new DateTime();// 取得当前时间

		// 根据指定格式,将时间字符串转换成DateTime对象,这里的格式和上面的输出格式是一样的
		DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
				.parseDateTime("2012-12-26 03:27:39");

		// 计算两个日期间隔的天数
		LocalDate start = new LocalDate(2012, 12, 14);
		LocalDate end = new LocalDate(2013, 01, 15);
		int days = Days.daysBetween(start, end).getDays();
		System.out.println("days:"+days);

		// 计算两个日期间隔的小时数,分钟数,秒数

		// 增加日期
		DateTime dateTime1 = DateTime.parse("2012-12-03");
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusDays(30);
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusHours(3);
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusMinutes(3);
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusMonths(2);
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusSeconds(4);
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusWeeks(5);
		System.out.println("dateTime1:" + dateTime1);
		dateTime1 = dateTime1.plusYears(3);
		System.out.println("dateTime1:" + dateTime1);

		// Joda-time 各种操作.....
		dateTime = dateTime.plusDays(1) // 增加天
				.plusYears(1)// 增加年
				.plusMonths(1)// 增加月
				.plusWeeks(1)// 增加星期
				.minusMillis(1)// 减分钟
				.minusHours(1)// 减小时
				.minusSeconds(1);// 减秒数

		// 判断是否闰月
		DateTime dt4 = new DateTime();
		org.joda.time.DateTime.Property month = dt4.monthOfYear();
		System.out.println("month:" + month);
		System.out.println("是否闰月:" + month.isLeap());

		System.out.println("dateTime1:" + dateTime1);
		// 取得 3秒前的时间
		DateTime dt5 = dateTime1.secondOfMinute().addToCopy(-3);
		System.out.println("dt5:" + dt5);
		dateTime1.getSecondOfMinute();// 得到整分钟后，过的秒钟数
		dateTime1.getSecondOfDay();// 得到整天后，过的秒钟数
		dateTime1.secondOfMinute();// 得到分钟对象,例如做闰年判断等使用

		// DateTime与java.util.Date对象,当前系统TimeMillis转换
		DateTime dt6 = new DateTime(new Date());
		Date date = dateTime1.toDate();
		DateTime dt7 = new DateTime(System.currentTimeMillis());
		dateTime1.getMillis();

		Calendar calendar = Calendar.getInstance();
		dateTime = new DateTime(calendar);
		System.out.println(dateTime);
	}

}
