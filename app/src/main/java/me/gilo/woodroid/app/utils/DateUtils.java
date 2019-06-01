package me.gilo.woodroid.app.utils;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE hh:mma MMM d, yyyy");
    static SimpleDateFormat longagoDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat weekdayFormat = new SimpleDateFormat("EEE");
    static SimpleDateFormat hourMinuteFormat = new SimpleDateFormat("hh:mm a");

    private static boolean isToday (DateTime dateTime) {
        DateMidnight today = new DateMidnight();
        return today.equals(dateTime.toDateMidnight());
    }

    private static boolean isYesterday (DateTime dateTime) {
        DateMidnight yesterday = (new DateMidnight()).minusDays(1);
        return yesterday.equals(dateTime.toDateMidnight());
    }

    private static String getDayString(Date date) {
        String s;

        if (isToday(new DateTime(date)))
            s = "Today";
        else if (isYesterday(new DateTime(date)))
            s = "Yesterday";
        else
            s = weekdayFormat.format(date);

        return s;
    }

    public static String getDateString_shortAndSmart(Date date) {
        String s;

        DateTime nowDT = new DateTime();
        DateTime dateDT = new DateTime(date);
        int days = Days.daysBetween(dateDT, nowDT).getDays();

        if (isToday(new DateTime(date)))
            s = getHourMinuteString(date);
        else if (days < 7)
            s = getDayString(date);
        else
            s = getDateString(date);

        return s;
    }


    public static String getDateStatus(Date date) {
        String s;

        if (date == null)
            return "Null";

        DateTime nowDT = new DateTime();
        DateTime dateDT = new DateTime(date);
        int days = Days.daysBetween(dateDT, nowDT).getDays();

        if (isToday(new DateTime(date)))
            s = getHourMinuteString(date);
        else if (days < 7)
            s = getDayString(date) + "at " + getHourMinuteString(date);
        else
            s = getDateString(date);

        return "Last online " + s;
    }

    private static String getDateString(Date date) {
        return longagoDateFormat.format(date);
    }

    private static String getHourMinuteString(Date date) {
        String s = hourMinuteFormat.format(date);

        return s;
    }
}
