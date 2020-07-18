package com.insurgency.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 时间转换工具类
 *
 * @author Lynx
 * @since 2020/03/21
 */

@SuppressWarnings("unused")
public final class DateUtil {

    // make non-instantiate ability
    private DateUtil() {
    }

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_PATTERN_TIGHT = "yyyyMMdd";
    public static final String DATE_PATTERN_DOT = "yyyy.MM.dd";
    public static final String DATE_PATTERN_HM = "HH:mm";
    public static final String DATE_PATTERN_HM2 = "HHmm";
    public static final String DATE_PATTERN_YMDHM = "yyyyMMddHHmm";
    public static final String DATE_PATTERN_MD_CN = "MM月dd日";
    public static final String DATE_PATTERN_EA_CN = "yyyy年MM月dd日 E HH:mm";
    public static final String DATE_PATTERN_MDY = "MMddyyyy";

    public static final ZoneId SHANGHAI_ZONE = ZoneId.of("Asia/Shanghai"); // 上海时区
    public static final ZoneId NEWYORK_ZONE = ZoneId.of("America/New_York"); // 纽约时区

    /**
     * 日期转化为指定日期格式类型
     *
     * @param date    date
     * @param pattern 格式
     * @return 转换后的日期
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);// 日期格式
        return sdf.format(date); // 日期转化为指定格式
    }

    /**
     * 日期字符串转化为指定日期格式类型
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式类型，如yyyy-MM-dd
     */
    public static Date stringToDate(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);// 日期格式
        return sdf.parse(dateStr);// 日期转化为指定格式
    }

    /**
     * 计算两个日期之间的天数差
     *
     * @param beginDateString 开始日期
     * @param endDateString   结束日期
     * @param datePattern     日期格式
     * @return 时间天数差
     * @throws ParseException 抛出转换异常
     */
    public static int calculateDateOffSet(String beginDateString, String endDateString, String datePattern)
            throws ParseException {
        Date dateBegin = stringToDate(beginDateString, datePattern);
        Date dateEnd = stringToDate(endDateString, datePattern);
        return calculateDateOffSet(dateBegin, dateEnd);
    }

    /**
     * 计算两个日期之间的天数差
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 时间天数差
     */
    public static int calculateDateOffSet(Date beginDate, Date endDate) {
        long offSet = (endDate.getTime() - beginDate.getTime()) / (60 * 60 * 24 * 1000);
        return Math.abs(Integer.parseInt(String.valueOf(offSet)));
    }

    /**
     * 获取当前时区的时间String
     *
     * @param pattern 格式
     * @return 时间 String
     */
    public static String getToday(String pattern) {
        return getToday(pattern, SHANGHAI_ZONE);
    }

    /**
     * 获取指定时区的时间String
     *
     * @param pattern 格式
     * @return 时间 string
     */
    public static String getToday(String pattern, ZoneId zoneId) {
        LocalDateTime nowDateTime = LocalDateTime.now(zoneId);
        return nowDateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    /**
     * 获得今天日期时间Date
     *
     * @return 今天日期时间
     */
    public static Date getTodayDate() {
        LocalDateTime now = LocalDateTime.now(SHANGHAI_ZONE);
        return parseLocalDateTimeToDate(now);
    }

    /**
     * 获取今日日期LocalDateTime
     *
     * @return 今日日期
     */
    public static LocalDateTime getTodayLocalDateTime() {
        return LocalDateTime.now(SHANGHAI_ZONE);
    }

    /**
     * 获取今日日期LocalDate
     *
     * @return 今日日期LocalDate
     */
    public static LocalDate getTodayLocalDate() {
        return LocalDate.now(SHANGHAI_ZONE);
    }

    /**
     * 获得指定时区日期LocalDateTime
     *
     * @return 指定时区日期
     */
    public static LocalDateTime getTodayLocalDateTime(ZoneId zoneId) {
        return LocalDateTime.now(zoneId);
    }

    /**
     * 比较时间间隔，time1+space <= time2
     *
     * @param time1   格式 09：00
     * @param time2   格式 12：00
     * @param minutes 格式 120
     * @return 时间间隔
     */
    public static boolean compareTimeSpace(String time1, String time2, int minutes) {
        LocalTime timeA = LocalTime.parse(time1).plusMinutes(minutes);
        LocalTime timeB = LocalTime.parse(time2);
        return timeA.isBefore(timeB);
    }

    /**
     * 时间加减小时
     *
     * @param startDate 要处理的时间
     * @param minutes   加减的分钟
     * @return 加减后的的日期 Date
     */
    public static Date dateAddHours(Date startDate, int minutes) {
        LocalDateTime localDateTime = parseDateToLocalDateTime(startDate);
        Date date;
        if (minutes >= 0) {
            date = parseLocalDateTimeToDate(localDateTime.plusMinutes(minutes));
        } else {
            date = parseLocalDateTimeToDate(localDateTime.minusMinutes(-minutes));
        }

        return date;

    }

    /**
     * 天加减小时
     *
     * @param startDate 要处理的时间
     * @param days      加减的天数
     */
    public static Date dateAddDays(Date startDate, int days) {
        LocalDateTime localDateTime = parseDateToLocalDateTime(startDate);
        Date date;
        if (days >= 0) {
            date = parseLocalDateTimeToDate(localDateTime.plusDays(days));
        } else {
            date = parseLocalDateTimeToDate(localDateTime.minusDays(-days));
        }
        return date;
    }

    /**
     * 计算开始和结束时间的时间差，返回秒为单位
     *
     * @param startTime 开始时间，可用currentTimeMillis
     * @param endTime   结束时间，可用currentTimeMillis
     * @return 相差时间：秒
     */
    public static float computeTimeDifference(long startTime, long endTime) {
        return (endTime - startTime) / 1000F;
    }

    /**
     * 计算两个时间间隔为半小时的中间时间
     *
     * @param startTime 开始时间HH:mm，必须半小时为整数
     * @param endTime   结束时间HH:mm，必须半小时为整数
     * @return 示例：["12:00", "12:30", "13:00", "13:30"]
     * @throws ParseException
     * @date : 2019-06-27 16:28
     * @author : LeoSong
     */
    public static List<String> populateTimeIntervalByHalfHour(String startTime, String endTime) {
        List<String> result = new ArrayList<>();
        LocalTime start = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime end = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));

        result.add(startTime);
        for (int counter = 0; counter < 48; counter++) { // 最多48次步长
            if (start.isBefore(end)) {
                start = start.plusMinutes(30);
                result.add(start.format(DateTimeFormatter.ofPattern("HH:mm")));
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 拆解为格式化时间
     *
     * @param time "0900"
     * @return
     */
    public static String getSimpleTime(String time) throws ParseException {
        return dateToString(stringToDate(time, "HHmm"), "HH:mm");
    }

    /**
     * 向下半小时取整
     *
     * @param localTime 格式0910
     * @return
     */
    public static String getDateHalfHourRound(String localTime) {
        LocalTime time = LocalTime.parse(localTime, DateTimeFormatter.ofPattern(DATE_PATTERN_HM2));
        int hou = time.getHour();
        int min = time.getMinute();

        if (min < 30) {
            min = 30;
        } else if (min >= 30) {
            hou += 1;
            min = 0;
        }
        LocalTime newTime = LocalTime.of(hou, min);

        return newTime.format(DateTimeFormatter.ofPattern(DATE_PATTERN_HM));
    }

    /**
     * 获取今天往后的日期
     */
    public static LocalDate getDateAfter(int count) {
        LocalDate now = LocalDate.now(SHANGHAI_ZONE);
        return now.plusDays(count);
    }

    /**
     * 获取今天往前的日期
     */
    public static LocalDate getDateBefore(int count) {
        LocalDate now = LocalDate.now(SHANGHAI_ZONE);
        return now.minusDays(count);
    }

    /**
     * 获取指定日期往后的日期
     */
    public static LocalDate getDateAfter(LocalDate localDate, int count) {
        return localDate.plusDays(count);
    }

    /**
     * 获取今天往前的日期
     */
    public static LocalDate getDateBefore(LocalDate localDate, int count) {
        return localDate.minusDays(count);
    }

    /**
     * 将LocalDate转化为Date
     */
    public static Date parseLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalTime转化为Date
     */
    public static Date parseLocalTimeToDate(LocalDate localDate, LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalDateTime转化为Date
     */
    public static Date parseLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将Date转化为LocalDateTime
     */
    public static LocalDateTime parseDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 指定LocalDate的输出格式
     */
    public static String parseLocalFormat(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    /**
     * 指定LocalDate的输出格式
     */
    public static String parseLocalFormat(LocalTime localTime, String pattern) {
        return localTime.format(DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    /**
     * 指定LocalDateTime的输出格式
     */
    public static String parseLocalFormat(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern, Locale.CHINA));
    }

    /**
     * 返回格式- "05月08日 日终前到达"
     */
    public static String formatUpsDateDisplay(String dateStr, String timeStr, String serviceCode) {
        String timeArrive = "";
        if ("08".equals(serviceCode) || "65".equals(serviceCode)) {
            timeArrive = "日终";
        } else {
            timeArrive = timeStr.substring(0, 2) + ":" + timeStr.substring(2, 4) + " ";
        }
        return dateStr.substring(4, 6) + "月" + dateStr.substring(6, 8) + "日 " + timeArrive + "前到达";
    }

    /**
     * 返回该日期的23:59:59.999
     */
    public static Date getDateEnd(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }
}
