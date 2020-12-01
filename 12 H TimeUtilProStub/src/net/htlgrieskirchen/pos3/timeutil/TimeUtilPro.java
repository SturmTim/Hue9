package net.htlgrieskirchen.pos3.timeutil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TimeUtilPro {

    private TimeUtilPro() {
    }

    // ########## LOCALDATE METHODS ##########
    public static LocalDate intToLocalDate(int date) {
        return LocalDate.of(date / 10000, (date / 100) % 100, date % 100);
    }

    public static LocalDate longToLocalDate(long dateTime) {
        return intToLocalDate((int) (dateTime / 10000));
    }

    public static LocalDate dateToLocalDate(Date dateTime) {
        return LocalDate.of(dateTime.getYear() + 1900, dateTime.getMonth() + 1, dateTime.getDate());
    }

    public static LocalDate calendarToLocalDate(Calendar dateTime) {
        return LocalDate.of(dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH) + 1, dateTime.get(Calendar.DAY_OF_MONTH));
    }

    // ########## LOCALDATETIME METHODS ##########
    public static LocalDateTime intToLocalDateTime(int date) {
        return LocalDateTime.of(date / 10000, (date / 100) % 100, date % 100, 0, 0);
    }

    public static LocalDateTime longToLocalDateTime(long dateTime) {
        LocalDate date = longToLocalDate(dateTime);
        return LocalDateTime.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), (int) ((dateTime / 100) % 100), (int) (dateTime % 100));
    }

    public static LocalDateTime dateToLocalDateTime(Date dateTime) {
        return LocalDateTime.of(dateTime.getYear() + 1900, dateTime.getMonth() + 1, dateTime.getDate(), 0, 0);
    }

    public static LocalDateTime calendarToLocalDateTime(Calendar dateTime) {
        return LocalDateTime.of(dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH) + 1, dateTime.get(Calendar.DAY_OF_MONTH), dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE));
    }

    // ########## INT METHODS ##########
    public static int localDateToInt(LocalDate date) {
        return date.getYear() * 10000 + date.getMonthValue() * 100 + date.getDayOfMonth();
    }

    public static int localDateTimeToInt(LocalDateTime dateTime) {
        return localDateToInt(dateTime.toLocalDate());
    }

    // ########## LONG METHODS ##########
    public static long localDateToLong(LocalDate date) {
        return ((long) (date.getYear() * 10000 + date.getMonthValue() * 100 + date.getDayOfMonth()));
    }

    public static long localDateTimeToLong(LocalDateTime dateTime) {
        return localDateToLong(dateTime.toLocalDate()) * 10000 + dateTime.getHour() * 100 + dateTime.getMinute();
    }

    // ########## DATE METHODS ##########
    public static Date localDateToDate(LocalDate date) {
        return new Date(date.getYear() - 1900, date.getMonthValue() - 1, date.getDayOfMonth());
    }

    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        return localDateToDate(dateTime.toLocalDate());
    }

    // ########## CALENDAR METHODS ##########
    public static Calendar localDateToCalendar(LocalDate date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(localDateToDate(date));
        return calendar;
    }

    public static Calendar localDateTimeToCalendar(LocalDateTime dateTime) {
        Date date = localDateTimeToDate(dateTime);
        date.setHours(dateTime.getHour());
        date.setMinutes(dateTime.getMinute());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
