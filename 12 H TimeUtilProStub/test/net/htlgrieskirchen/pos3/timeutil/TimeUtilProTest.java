/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.timeutil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author timst
 */
public class TimeUtilProTest {

    public TimeUtilProTest() {
    }

    private final LocalDate LOCALDATE = LocalDate.of(2003, 2, 1);
    private final LocalDateTime LOCALDATEWITHOUTTIME = LocalDateTime.of(2003, 2, 1, 0, 0);
    private final LocalDateTime LOCALDATETIME = LocalDateTime.of(2003, 2, 1, 12, 34);
    private final Date DATE = new Date(103, 1, 1);

    @Test
    public void testIntToLocalDate() {
        LocalDate result = TimeUtilPro.intToLocalDate(20030201);
        assertEquals(LOCALDATE, result);
    }

    @Test
    public void testLongToLocalDate() {

        LocalDate result = TimeUtilPro.longToLocalDate(200302011234L);
        assertEquals(LOCALDATE, result);
    }

    @Test
    public void testDateToLocalDate() {

        LocalDate result = TimeUtilPro.dateToLocalDate(DATE);
        assertEquals(LOCALDATE, result);
    }

    @Test
    public void testCalendarToLocalDate() {
        Calendar calander = Calendar.getInstance();
        calander.set(2003, 1, 1);
        LocalDate result = TimeUtilPro.calendarToLocalDate(calander);
        assertEquals(LOCALDATE, result);
    }

    @Test
    public void testIntToLocalDateTime() {

        LocalDateTime result = TimeUtilPro.intToLocalDateTime(20030201);
        assertEquals(LOCALDATEWITHOUTTIME, result);
    }

    @Test
    public void testLongToLocalDateTime() {

        LocalDateTime result = TimeUtilPro.longToLocalDateTime(200302011234L);
        assertEquals(LOCALDATETIME, result);
    }

    @Test
    public void testDateToLocalDateTime() {

        LocalDateTime result = TimeUtilPro.dateToLocalDateTime(DATE);
        assertEquals(LOCALDATEWITHOUTTIME, result);
    }

    @Test
    public void testCalendarToLocalDateTime() {
        Calendar calender = Calendar.getInstance();
        calender.set(2003, Calendar.FEBRUARY, 1, 12, 34);
        LocalDateTime result = TimeUtilPro.calendarToLocalDateTime(calender);
        assertEquals(LOCALDATETIME, result);
    }

    @Test
    public void testLocalDateToInt() {

        int result = TimeUtilPro.localDateToInt(LOCALDATE);
        assertEquals(20030201, result);
    }

    @Test
    public void testLocalDateTimeToInt() {

        int result = TimeUtilPro.localDateTimeToInt(LOCALDATEWITHOUTTIME);
        assertEquals(20030201, result);
    }

    @Test
    public void testLocalDateToLong() {

        long result = TimeUtilPro.localDateToLong(LOCALDATE);
        assertEquals(20030201L, result);
    }

    @Test
    public void testLocalDateTimeToLong() {

        long result = TimeUtilPro.localDateTimeToLong(LOCALDATETIME);
        assertEquals(200302011234L, result);
    }

    @Test
    public void testLocalDateToDate() {

        Date result = TimeUtilPro.localDateToDate(LOCALDATE);
        assertEquals(DATE, result);
    }

    @Test
    public void testLocalDateTimeToDate() {

        Date result = TimeUtilPro.localDateTimeToDate(LOCALDATEWITHOUTTIME);
        assertEquals(DATE, result);
    }

}
