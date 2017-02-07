package cn.damai.beautiful_article.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/*
 * * 类名：UtilDate 功能：自定义订单类 详细：工具类，可以用作获取系统日期、订单编号等
 */
public class DateUtil {

    /** 年月日时分秒(无下划线) yyyyMMddHHmmss */
    public static final String dtLong = "yyyyMMddHHmmss";

    /** 完整时间 yyyy-MM-dd HH:mm:ss */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /** 年月日(带中划线) yyyy-MM-dd */
    public static final String siShort = "yyyy-MM-dd";

    /** 年月日(无下划线) yyyyMMdd */
    public static final String dtShort = "yyyyMMdd";

    public static final String dtTime = "HHmmss";


    /**
     * 将时间戳 按照给的的格式转化为时间类型字符串
     * @param time 时间戳
     * @param format
     * @return
     */
    public static String getDateFromTimeStamp(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(time));
    }


    /**
     * 将给定的时间字符串按照给定的格式转化为Date类型
     * @param time 时间字符串，例如20140822115001
     * @param format 格式，例如：yyyyMMddHHmmss
     * @return Date
     */
    public static Date getDateUseFormat(String time, String format) {
        Date date = null;
        DateFormat df = new SimpleDateFormat(format);
        try {
            date = df.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }


    /**
     * 根据给定时间格式获取日期
     * @param time 日期字符串
     * @param format 给定格式
     * @return
     */
    public static String getDataForm(String time, String format) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            return df.format(df.parse(time));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }



    /**
     * 返回指定时间(精确到毫秒),作为一个唯一的订单编号，格式yyyyMMddHHmmss
     * @param date
     * @return  
     */
    public static String getFormatTime(Date date) {
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }


    /**
     * 返回系统当前时间(精确到毫秒),格式yyyyMMddHHmmss
     * @param date
     * @return  
     */
    public static String getFormatTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }


    /**
     * 返回指定格式的时间字符串,格式自定义
     * @param date
     * @return  
     */
    public static String getFormatTime(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }


    /**
     * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static String getDateFormatter(Date date) {
        DateFormat df = new SimpleDateFormat(simple);
        return df.format(date);
    }


    /**
     * 获取指定年月日(精确到天)，格式：yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getFormatDater(Date date) {
        DateFormat df = new SimpleDateFormat(siShort);
        return df.format(date);
    }


    /**
     * 获取系统当期年月日(精确到天)，格式：yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getFormatDater() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(siShort);
        return df.format(date);
    }


    /**
     * 获取指定年月日(精确到天)，格式：yyyyMMdd
     * @param date 要转的时间
     * @return
     */
    public static String getFormatDate(Date date) {
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }


    /**
     * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
     * @param date 要转的时间
     * @return
     */
    public static String getFormatDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }


    /**
     * 获取系统当前时分秒，格式：HHmmss
     * 
     * @return
     */
    public static String getTimestamp() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtTime);
        return df.format(date);
    }


    /**
     * 产生随机的三位数
     * 
     * @return
     */
    public static String getThree() {
        Random rad = new Random();
        return rad.nextInt(1000) + "";
    }


    /**
     * 获取count个随机数
     * 
     * @param count
     *            随机数个数
     * @return
     */
    public static String getRandomNum(int count) {
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num) + ""), "");
        }
        return sb.toString();
    }


    /**
     * 
     * @Title getTransTimeoutTime
     * @Description 获得过期时间
     * @param day
     *            有效期天数
     * @return String 返回类型
     */
    public static String getTransTimeoutTime(int day) {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(dtLong);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        Date date = calendar.getTime();
        return df.format(date);
    }


    /**
     * 
     * @Title getDateTime
     * @Description 获得指定日期的time
     * @param date
     * @return String 返回类型
     */
    public static String getDateTime(Date date) {
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }


    /**
     * 
     * @Title getAddYearDate
     * @Description 获得几年后的date
     * @param year
     * @return Date 返回类型
     */
    public static Date getAddYearDate(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }


    /**
     * 为日期增加分钟数
     * 
     * @param date
     *            日期
     * @param minute
     *            分钟数
     * @return
     */
    public static Date getAddMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }


    /**
     * 为日期增加分钟数
     * 
     * @param date
     *            日期
     * @param seconds
     *            秒数
     * @return
     */
    public static Date addSeconds(Date date, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }


    /**
    * 日期date上加count天，count为负表示减
    */
    public static Date addDay(Date date, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, count);
        return calendar.getTime();
    }


    /**
     * 获取年份的后两位，例如2014返回14
     * @return
     */
    public static String getYear() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        return (year + "").substring(2);
    }

    // public static void main(String[] args) {
    // System.out.println(getTimestamp());
    // }

}
