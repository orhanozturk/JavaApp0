/***
 *  FILE            : Month.java
 *  AUTHOR          : Orhan ÖZTÜRK
 *  LAST UPDATE     : 20.05.2023
 *
 *  Enum class for months
 *
 *  Copyleft(c) 1992 by Orhan OZTURK All Rights Free
 */

package com.orhn.util.datetime;

public enum Month {
    JAN(31), FEB(28), MAR(31), MAY(31), JUN(30), JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);

    private final int m_days;

    Month(int d)
    {
        m_days = d;
    }

    static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    int getDays(int year)
    {
        return ordinal() == 1 && isLeapYear(year) ? 29 : m_days;
    }
}
