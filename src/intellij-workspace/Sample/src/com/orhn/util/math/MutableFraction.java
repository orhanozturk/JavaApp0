/*----------------------------------------------------------------------
	FILE        : MutableFraction.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 07.10.2022

	MutableFraction class that represents fraction in mathematics

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.orhn.util.math;

public class MutableFraction {
    private int m_a, m_b;

    private static MutableFraction add(int a1, int b1, int a2, int b2)
    {
        return new MutableFraction(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static MutableFraction subtract(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static MutableFraction multiply(int a1, int b1, int a2, int b2)
    {
        return new MutableFraction(a1 * a2, b1 * b2);
    }

    private static MutableFraction divide(int a1, int b1, int a2, int b2)
    {
        return multiply(a1, b1, b2, a2);
    }

    private static void doWorkForException(String message)
    {
        throw new IllegalArgumentException(message);
    }

    private static void check(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                doWorkForException("Indeterminate");
            else
                doWorkForException("Undefined");
        }
    }

    private void configureSign()
    {
        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a), m_b);

        for (int i = min; i >= 2; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_a = 0;
            m_b = 1;
            return;
        }
        m_a = a;
        m_b = b;
        configureSign();
        simplify();
    }

    public MutableFraction()
    {
        m_b = 1;
    }

    public MutableFraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public MutableFraction(int a, int b)
    {
        check(a, b);
        set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int value)
    {
        if (value == m_a)
            return;

        set(value, m_b);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public void setDenominator(int value)
    {
        if (value == m_b)
            return;
        check(m_a, value);
        set(m_a, value);
    }

    public double getRealValue()
    {
        return (double)m_a / m_b;
    }

    public static MutableFraction add(int value, MutableFraction fraction)
    {
        return add(value, 1, fraction.m_a, fraction.m_b);
    }

    public MutableFraction add(MutableFraction other)
    {
        return add(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction add(int value)
    {
        return add(m_a, m_b, value, 1);
    }

    public static MutableFraction subtract(int value, MutableFraction fraction)
    {
        return subtract(value, 1, fraction.m_a, fraction.m_b);
    }

    public MutableFraction subtract(MutableFraction other)
    {
        return subtract(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction subtract(int value)
    {
        return subtract(m_a, m_b, value, 1);
    }

    public static MutableFraction multiply(int value, MutableFraction fraction)
    {
        return multiply(value, 1, fraction.m_a, fraction.m_b);
    }

    public MutableFraction multiply(MutableFraction other)
    {
        return multiply(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction multiply(int value)
    {
        return multiply(m_a, m_b, value, 1);
    }

    public static MutableFraction divide(int value, MutableFraction fraction)
    {
        return divide(value, 1, fraction.m_a, fraction.m_b);
    }

    public MutableFraction divide(MutableFraction other)
    {
        return divide(m_a, m_b, other.m_a, other.m_b);
    }

    public MutableFraction divide(int value)
    {
        return divide(m_a, m_b, value, 1);
    }

    public void inc(int value)
    {
        m_a += m_b * value;
    }

    public void inc()
    {
        inc(1);
    }

    public void dec(int value)
    {
        inc(-value);
    }

    public void dec()
    {
        dec(1);
    }

    public String toString()
    {
        return String.format("%d%s", m_a, m_b == 1 ? "" : " / " + m_b + " = " + getRealValue());
    }
}

