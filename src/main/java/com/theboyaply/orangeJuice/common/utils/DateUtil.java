package com.theboyaply.orangeJuice.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author senlin.yang@hand-china.com
 * @version V1.0
 * @Date 2019-2-26
 * @description
 */
public final class DateUtil {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * String(yyyy-MM-dd)转Date
     *
     * @param stringDate
     * @return
     */
    public static Date stringToDateV1(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            throw new RuntimeException("SYS_STRING_IS_NULL");
        }
        String rex = "\\d{4}-\\d{2}-\\d{2}";
        if (!stringDate.matches(rex)) {
            throw new RuntimeException("SYS_DATE_FORMAT_NOT_TRUE");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 字符串(yyyy-MM-dd)转ZonedDateTime
     *
     * @param stringDate 字符串日期
     * @return ZonedDateTime
     */
    public static ZonedDateTime stringToZonedDateTime(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
//            throw new BizException(RespCode.SYS_STRING_IS_NULL);
        }
        String rex = "\\d{4}-\\d{2}-\\d{2}";
        if (!stringDate.matches(rex)) {
            throw new RuntimeException("SYS_DATE_FORMAT_NOT_TRUE");
        }
        ZonedDateTime zonedDateTime = null;
        try {
            zonedDateTime = LocalDate.parse(stringDate, dateTimeFormatter).atStartOfDay(ZoneId.systemDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zonedDateTime;
    }

    /**
     * string转ZonedDateTime +1天，主要用于日期至
     *
     * @param date yyyy-mm-dd
     * @return zonedDateTime
     */
    public static ZonedDateTime string2ZonedDateTimeAddOne(String date) {
        String rex = "\\d{4}-\\d{2}-\\d{2}";
        if (!date.matches(rex)) {
            throw new RuntimeException("请传入 yyyy-MM-dd 格式");
        }
        ZonedDateTime dateTo = null;
        Calendar c = Calendar.getInstance();
        c.setTime(DateUtil.stringToDate(date));
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date time = c.getTime();
        dateTo = DateUtil.dateToZoneDateTime(time);
        return dateTo;
    }

    /**
     * Date转ZonedDateTime
     *
     * @param date
     * @return
     */
    public static ZonedDateTime dateToZoneDateTime(Date date) {
        return date == null ? null : ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * ZonedDateTime 转String
     *
     * @param dateTime
     * @return
     */
    public static String ZonedDateTimeToString(ZonedDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        String str = null;
        try {
            str = dateTime.format(dateTimeFormatter);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
        return str;
    }

    public static Date stringToDate(String stringDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 今天的开始时间
     *
     * @return
     */
    public static ZonedDateTime getCurrentDayStartDate() {
        return LocalDate.now().atStartOfDay(ZoneId.systemDefault());
    }

    /**
     * 今天的开始时间
     *
     * @return
     */
    public static ZonedDateTime getDayEndDate(String date) {
        return LocalDateTime.of(LocalDate.parse(date, dateTimeFormatter), LocalTime.MAX).atZone(ZoneId.systemDefault());
    }

}
