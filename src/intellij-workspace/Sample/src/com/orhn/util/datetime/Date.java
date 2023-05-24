/***
 *  FILE            : Date.java
 *  AUTHOR          : Orhan ÖZTÜRK
 *  LAST UPDATE     : 18.05.2023
 *
 *  Date class that represents a local date
 *
 *  Copyleft(c) 1992 by Orhan OZTURK All Rights Free
 */

package com.orhn.util.datetime;

import java.time.LocalDate;

import static com.orhn.util.datetime.DateUtil.MONTHS;

public class Date {
    private static final String [] MONTHS_TR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
    private static final String [] DAYS_OF_WEEK_TR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
    private static final String [] MONTHS_EN = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String [] DAYS_OF_WEEK_EN = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    private static int getDayOfYear(int day, int month, int year)
    {
        /*if (!isValidDate(day, month, year))
            return -1;*/

        int totalDays = day;

        for(int m = month - 1; m >= 1; --m)
            totalDays += MONTHS[m - 1].getDays(year);

        return totalDays;

    }
    private static int getDayOfWeek(int day, int month, int year)
    {
        int totalDays = getDayOfYear(day, month, year);

        /*if (year < 1900 || totalDays  == -1)
            return -1;*/

        for (int y = 1900; y < year; ++y)
            totalDays += Month.isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static String getDaySuffix(int day)
    {
        return switch (day){
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            default -> "th";
        };
    }
    private static boolean isValidDate(int day, int month, int year)
    {
        return  1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= MONTHS[month - 1].getDays(year);
    }

    private static void doWorkForException(String message)
    {
        System.out.println(message);
        System.exit(1); //Exception konusuna kadar bekliyoruz
    }

    private static void checkDate(int day, int month, int year, String message)
    {
        if(!isValidDate(day, month, year))
            doWorkForException(message);
    }

    private void checkDay(int day, String message)
    {
        checkDate(day, m_month, m_year, message);
    }

    private void checkMonth(int month, String message)
    {
        checkDate(m_day, month, m_year, message);
    }

    private void checkYear(int year, String message)
    {
        checkDate(m_day, m_month, year, message);
    }


    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    private void set(int day, int month, int year)
    {
        m_day = day;
        m_month = month;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(m_day, m_month, m_year);
    }

    public Date()
    {
        LocalDate today = LocalDate.now();

        set(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
    }
    public Date(int day, int month, int year)
    {
        checkDate(day, month, year, String.format("Invalid date value(s) -> day: %d, month value: %d, year: %d",
                day, month, year));
        set(day, month, year);
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }
    public int getDay()
    {
        return m_day;
    }

    public void setDay(int day)
    {
        if(m_day == day)
            return;

        checkDay(day, "Invalid day value:" + day);
        set(day, m_month, m_year);
    }

    public int getMonthValue()
    {
        return m_month;
    }

    public void setMonthValue(int month)
    {
        if(m_month == month)
            return;

        checkMonth(month, "Invalid month value:" + month);
        set(m_day, month, m_year);
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int year)
    {
        if(m_year == year)
            return;

        checkYear(year, "Invalid year value:" + year);
        set(m_day, m_month, year);
    }

    public int getDayOfWeekValue()
    {
        return m_dayOfWeek;
    }

    public String getDayOfWeekTR()
    {
        return DAYS_OF_WEEK_TR[m_dayOfWeek];
    }

    public String getDayOfWeekEN()
    {
        return DAYS_OF_WEEK_EN[m_dayOfWeek];
    }

    public boolean isLeapYear()
    {
        return Month.isLeapYear(m_year);
    }

    public boolean isWeekend()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }

    public boolean isWeekday()
    {
        return !isWeekend();
    }

    public String toString()
    {
        return toString('/');
    }

    public String toString(char delimiter)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delimiter, m_month, delimiter, m_year);
    }

    public String toLongDateStringTR()
    {
        return String.format("%s %s", toShortDateStringTR(), getDayOfWeekTR());
    }

    public String toLongDateStringEN()
    {
        return String.format("%s %s", toShortDateStringEN(), getDayOfWeekEN());
    }

    public String toShortDateStringTR() {
        return String.format("%d %s %d", m_day, MONTHS_TR[m_month], m_year);
    }

    public String toShortDateStringEN() {
        return String.format("%d%s %s %d", m_day, getDaySuffix(m_day), MONTHS_EN[m_month], m_year);
    }
}
