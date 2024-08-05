/***
 *  FILE            : Time.java
 *  AUTHOR          : Orhan ÖZTÜRK
 *  LAST UPDATE     : 25.05.2023
 *
 *  Time class that represents a local time
 *
 *  Copyleft(c) 1992 by Orhan OZTURK All Rights Free
 */

package com.orhn.util.datetime;

import java.time.LocalTime;

public class Time {
    private int m_hour, m_minute, m_second, m_millisecond;

    private static void doWorkForException(String message)
    {
        throw new DateTimeException(message);
    }

    private static boolean isValid(int value, int max)
    {
        return 0 <= value && value <= max;
    }

    private static boolean isValidHour(int hour)
    {
        return isValid(hour, 23);
    }

    private static boolean isValidMinute(int minute)
    {
        return isValid(minute, 59);
    }

    private static boolean isValidSecond(int second)
    {
        return isValid(second, 59);
    }

    private static boolean isValidMillisecond(int millisecond)
    {
        return isValid(millisecond, 999);
    }

    private static boolean isValidTime(int hour, int minute, int second, int millisecond)
    {
        return isValidHour(hour) && isValidMinute(minute) && isValidSecond(second) && isValidMillisecond(millisecond);
    }

    private static void checkHour(int value)
    {
        if (!isValidHour(value))
            doWorkForException("Invalid hour value -> " + value);
    }

    private static void checkMinute(int value)
    {
        if (!isValidMinute(value))
            doWorkForException("Invalid minute value -> " + value);
    }

    private static void checkSecond(int value)
    {
        if (!isValidSecond(value))
            doWorkForException("Invalid second value -> " + value);
    }

    private static void checkMillisecond(int value)
    {
        if (!isValidMillisecond(value))
            doWorkForException("Invalid millisecond value -> " + value);
    }

    private void checkTime(int hour, int minute, int second, int millisecond)
    {
        if (!isValidTime(hour, minute, second, millisecond))
            doWorkForException(String.format("Invalid time value(s): hour -> %d, minute -> %d, second -> %d, millisecond -> %d",
                    hour, minute, second, millisecond));
    }

    private void set(int hour, int minute, int second, int millisecond)
    {
        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public Time() //Bu ctor içerisinde yazılanların bilinmesi gerekmez. Sadece default ctor'un anlamına odaklanınız
    {
        LocalTime now = LocalTime.now();

        m_hour = now.getHour();
        m_minute = now.getMinute();
        m_second = now.getSecond();
        m_millisecond = now.getNano() / 1_000_000;
    }

    public Time(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, int second)
    {
        this(hour, minute, second, 0);
    }

    public Time(int hour, int minute, int second, int millisecond)
    {
        checkTime(hour, minute, second, millisecond);
        set(hour, minute, second, millisecond);
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int hour)
    {
        if (hour == m_hour)
            return;

        checkHour(hour);
        m_hour = hour;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int minute)
    {
        if (minute == m_minute)
            return;

        checkMinute(minute);
        m_minute = minute;
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int second)
    {
        if (second == m_second)
            return;

        checkSecond(second);
        m_second = second;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int millisecond)
    {
        if (millisecond == m_millisecond)
            return;

        checkMillisecond(millisecond);
        m_millisecond = millisecond;
    }

    public String toString()
    {
        return String.format("%s:%02d", toShortTimeString(), m_second);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:%02d", m_hour, m_minute);
    }

    public String toLongTimeString()
    {
        return String.format("%s.%03d", toString(), m_millisecond);
    }
}

