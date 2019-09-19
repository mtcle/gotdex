package com.android.sys.appdefault.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 */
@SuppressLint("SimpleDateFormat")
public class DateUtils {

	public static SimpleDateFormat sdf_DT_N = new SimpleDateFormat(
			"yyyy/MM/dd-HH:mm:ss");
	public static SimpleDateFormat sdf_T = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf_MS = new SimpleDateFormat(
			"MM-dd HH:mm:ss");
	public static SimpleDateFormat sdf_TM = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	public static SimpleDateFormat sdf_M = new SimpleDateFormat("MM-dd HH:mm");
	public static SimpleDateFormat sdf_D = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdf_YM = new SimpleDateFormat("yyyy-MM");
	public static SimpleDateFormat sdf_Month = new SimpleDateFormat("MM");
	public static SimpleDateFormat sdf_Y = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat sdf_HMS = new SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat sdf_HM = new SimpleDateFormat("HH:mm");

	public static String getCurrentYear() {
		return sdf_Y.format(new Date(System.currentTimeMillis()));
	}

	public static String getPreYear() {
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
		Date date = curr.getTime();
		return sdf_Y.format(date);
	}

	/**
	 * 方法名：getCurrDate_Time 方法描述：获取当前年月日时分秒
	 * 
	 * 创建日期：2012-3-16 修改人： 修改日期： 备注：
	 * 
	 * @return
	 */
	public static String getCurrDate_TimeWithFormat(
			SimpleDateFormat simpleDateFormat) {
		return simpleDateFormat.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 方法名：getCurrDate_Time 方法描述：获取当前年月日时分秒
	 * 
	 * 创建日期：2012-3-16 修改人： 修改日期： 备注：
	 * 
	 * @return
	 */
	public static String getCurrDate_Time() {
		return sdf_T.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 方法名：getCurrYear 方法描述：获取当前年月
	 * 
	 * 创建日期：2012-3-22 修改人： 修改日期： 备注：
	 * 
	 * @return
	 */
	public static String getCurrYearMonth() {
		return sdf_YM.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 方法名：getCurrYear 方法描述：获取当前年月
	 * 
	 * 创建日期：2012-3-22 修改人： 修改日期： 备注：
	 * 
	 * @return
	 */
	public static String getCurrYearMonthOnly() {
		return sdf_Month.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * 方法名：getCurrDate 方法描述：获取当前年月日
	 * 
	 * 创建日期：2012-3-16 修改人： 修改日期： 备注：
	 * 
	 * @return
	 */
	/*
	 * public static String getCurrDate(){ return sdf2.format(new
	 * Date(System.currentTimeMillis())); }
	 */

	/**
	 * 方法名：getPreMDate 方法描述：以当前月计算获取前后月份日期
	 * 
	 * 创建日期：2012-3-20 修改人： 修改日期： 备注：
	 * 
	 * @param monthNum
	 *            相差月数
	 * @return
	 */
	public static String getPreMDate(int monthNum) {
		Calendar cal = Calendar.getInstance();
		// 下面可以设置月份，注：月份设置要减1，所以设置1月就是1-1，设置2月就是2-1，如此类推
		// cal.set(Calendar.MONTH, 1-1);
		// 调到上monthNum个月
		cal.add(Calendar.MONTH, -monthNum);
		// 得到一个月最最后一天日期(31/30/29/28)
		// int MaxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 按你的要求设置时间
		// cal.set( cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay, 23,
		// 59, 59);
		// 按格式输出
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));

		return sdf_D.format(cal.getTime());
	}

	public static String getPreMD(int monthNum) {
		Calendar cal = Calendar.getInstance();
		// 下面可以设置月份，注：月份设置要减1，所以设置1月就是1-1，设置2月就是2-1，如此类推
		// cal.set(Calendar.MONTH, 1-1);
		// 调到上monthNum个月
		cal.add(Calendar.MONTH, -monthNum);
		// 得到一个月最最后一天日期(31/30/29/28)
		// int MaxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 按你的要求设置时间
		// cal.set( cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay, 23,
		// 59, 59);
		// 按格式输出
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));

		return sdf_YM.format(cal.getTime());
	}

	public static String getPreMMD(int monthNum) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -monthNum);
		return sdf_Month.format(cal.getTime());
	}

	public static String getPreYDate(int yearNum) {
		Calendar cal = Calendar.getInstance();
		// 下面可以设置月份，注：月份设置要减1，所以设置1月就是1-1，设置2月就是2-1，如此类推
		// cal.set(Calendar.MONTH, 1-1);
		// 调到上monthNum个月
		cal.add(Calendar.YEAR, -yearNum);
		// 得到一个月最最后一天日期(31/30/29/28)
		// int MaxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 按你的要求设置时间
		// cal.set( cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay, 23,
		// 59, 59);
		// 按格式输出
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));

		return sdf_YM.format(cal.getTime());
	}

	/**
	 * getPreWDate 描述：获取数周前的日期
	 * 
	 * 创建日期：2013-6-24 下午3:57:52 修改人： 修改日期： 修改备注：
	 */
	public static String getPreWDate(int weekNum) {
		Calendar cal = Calendar.getInstance();
		// 下面可以设置月份，注：月份设置要减1，所以设置1月就是1-1，设置2月就是2-1，如此类推
		// cal.set(Calendar.MONTH, 1-1);
		// 调到上monthNum个月
		cal.add(Calendar.DATE, -weekNum * 7);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		// 得到一个月最最后一天日期(31/30/29/28)
		// int MaxDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 按你的要求设置时间
		// cal.set( cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), MaxDay, 23,
		// 59, 59);
		// 按格式输出
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));

		return sdf_D.format(cal.getTime());
	}

	/**
	 * 方法名：compareDate 方法描述：比较年月日
	 * 
	 * 创建日期：2012-3-20 修改人： 修改日期： 备注：
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int compareDate(String beginDate, String endDate) {
		return compareDateCommon(beginDate, endDate, "yyyy-MM-dd");
	}

	/**
	 * 方法名：compareDateTime 方法描述：比较时间
	 * 
	 * 创建日期：2012-3-20 修改人： 修改日期： 备注：
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int compareDateTime(String beginDate, String endDate) {
		return compareDateCommon(beginDate, endDate, "yyyy-MM-dd HH:mm:ss");
	}

	private static int compareDateCommon(String beginDate, String endDate,
			String format) {
		SimpleDateFormat sdftemp = new SimpleDateFormat(format);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(sdftemp.parse(beginDate));
			c2.setTime(sdftemp.parse(endDate));
		} catch (ParseException e) {
			System.err.println("格式不正确");
			return 2;
		}
		/*
		 * if(result==0) //System.out.println("c1相等c2"); return true; else
		 * if(result<0) //System.out.println("c1小于c2"); return true; else
		 * //System.out.println("c1大于c2");
		 */
		int result = c1.compareTo(c2);
		return result;
	}

	/**
	 * 方法名：compareDaysDiff 方法描述：计算天数差
	 * 
	 * 创建日期：2012-3-27 修改人： 修改日期： 备注：
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long compareDaysDiff(String beginDate, String endDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d_beginDate = df.parse(beginDate);
			Date d_endDate = df.parse(endDate);
			long diff = d_endDate.getTime() - d_beginDate.getTime();
			long months = diff / (1000 * 60 * 60 * 24);
			return months;
		} catch (Exception e) {
		}
		return 0;
	}

	/**
	 * 方法名：getPreMinDate 方法描述：获取minNum前的时间
	 * 
	 * 创建日期：2012-7-23 修改人： 修改日期： 备注：
	 * 
	 * @param minNum
	 *            例如minNum=30,即获取30分钟前的时间
	 * @return
	 */
	public static Calendar getPreMinDate(int minNum) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -minNum);
		return cal;
	}

	public static Map<String, String> getFirstday_Lastday_Week(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 2;
		cal.add(Calendar.DATE, -day_of_week);
		String day_first = df.format(cal.getTime());

		cal.add(Calendar.DATE, 6);
		String day_last = df.format(cal.getTime());

		Map<String, String> map = new HashMap<String, String>();
		map.put("first", day_first);
		map.put("last", day_last);
		return map;
	}

	public static String formatIDNo(String idNo) {
		if (idNo.length() > 10) {
			StringBuffer newstr = new StringBuffer();
			newstr.append(idNo.substring(0, idNo.length() - 8));
			newstr.append("****");
			newstr.append(idNo.substring(idNo.length() - 4));
			return newstr.toString();
		} else {
			return idNo;
		}
	}

	@SuppressLint("SimpleDateFormat")
	public static int getCurrentHour() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		String hour = sdf.format(new Date(System.currentTimeMillis()));
		return Integer.parseInt(hour);
	}

	/**
	 * 标准格式时间字符串 返回结果 非同年 则返回格式sdf_TM 若同年 则返回格式sdf_M 若同日 则返回格式sdf_HM
	 */
	public static String standTimeChatReturn(String orginalTime) {
		Date orginalDate;
		try {
			orginalDate = sdf_T.parse(orginalTime);
			String nowTime = getCurrDate_Time();
			if (compareDateCommon(orginalTime, nowTime, "yyyy") == 0) {
				// 同年 比较是否同日
				if (compareDateCommon(orginalTime, nowTime, "yyyy-MM-dd") == 0) {
					// 同日
					return sdf_HM.format(orginalDate);
				}
				return sdf_M.format(orginalDate);
			} else {
				// 非同年 返回sdf_TM
				return sdf_TM.format(orginalDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * getCurrentAgeByBirthdate 描述： 根据生日获取年龄;
	 * 
	 * @param brithday
	 * @return
	 * @throws Exception
	 */
	public static int getCurrentAgeByBirthdate(String brithday) {
		try {
			Calendar calendar = Calendar.getInstance();
			String currentTime = sdf_D.format(calendar.getTime());
			Date today = sdf_D.parse(currentTime);
			Date brithDay = sdf_D.parse(brithday);
			return today.getYear() - brithDay.getYear();
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 某一个月第一天和最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Map<String, String> getFirstday_Lastday_Month(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();

		// 上个月第一天
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());

		// 上个月最后一天
		calendar.add(Calendar.MONTH, 1); // 加一个月
		calendar.set(Calendar.DATE, 1); // 设置为该月第一天
		calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
		String day_last = df.format(calendar.getTime());

		Map<String, String> map = new HashMap<String, String>();
		map.put("first", day_first);
		map.put("last", day_last);
		return map;
	}

	/**
	 * 描述：计算天数差
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long compareDaysDiff(String beginDate) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d_beginDate = df.parse(beginDate);
			Date d_endDate = new Date(System.currentTimeMillis());
			long diff = d_endDate.getTime() - d_beginDate.getTime();
			long months = diff / (1000 * 60 * 60 * 24);
			return months;
		} catch (Exception e) {
		}
		return 0;
	}


	//几天前的日期字符串
	public static String[] dayAgoString(int dayAgo) {
		String str = sdf_D.format(new Date(System.currentTimeMillis() - dayAgo * 24 * 60 * 60 * 1000));
		return new String[]{str + " 00:00:00", str + " 23:59:59"};
	}

	public static void main(String[] a) {
		String[] r = dayAgoString(1);
		System.out.print("开始：" + r[0] + ";结束：" + r[1]);
	}
}
