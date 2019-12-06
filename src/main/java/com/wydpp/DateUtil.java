package com.wydpp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期操作相关类
 * @author dpp
 */
public class DateUtil {

    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";

    /**
     * 日期Date转化为String
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 日期字符串String转化为Date类型
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr,String format){
        if(dateStr == null || format == null){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定时间的日期
     * @param year
     * @param month 月份是从0-11
     * @param dayOfMonth
     * @param hourOfDay
     * @param minute
     * @param second
     * @return
     */
    public static Date getDate(int year,int month,int dayOfMonth,int hourOfDay,int minute,int second){
        //或者使用calendar.set方法实现
        Calendar calendar = new GregorianCalendar(year, month, dayOfMonth,hourOfDay,minute,second);
        return calendar.getTime();
    }

    /**
     * 获取距date日期相距n天的date
     * @param date
     * @param n 可以为负数
     * @return
     */
    public static Date getDateNextNDays(Date date,int n){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,n);
        return calendar.getTime();
    }

    /**
     * 获取指定日期是所在年的第几个星期
     * @return
     */
    public static int getWeekOfYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getWeeksInWeekYear();
    }

    /**
     * 获取指定日期是所在月的第几个星期
     * @return
     */
    public static int getWeekOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取日期是周几
     * 周日-周六对应1-7
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取月份最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }

    /**
     * 获取月份第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }

    /**
     * 比较两个日期相距多少天
     * @param d1
     * @param d2
     * @return
     */
    public static long getDiffDay(Date d1,Date d2){
        if(d1 == null || d2 == null){
            return 0;
        }
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        //24*60*60*1000=86400000
        long diffDay = (time1-time2)/86400000;
        return Math.abs(diffDay);
    }

}
