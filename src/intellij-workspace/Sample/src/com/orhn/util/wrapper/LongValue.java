/***
 *  FILE            :  LongValue.java
 *  AUTHOR          : Orhan ÖZTÜRK
 *  LAST UPDATE     : 18.05.2023
 *
 *  Immutable LongValue class that wraps an int value by using cache
 *  for values in[-128, 127] closed interval
 *
 *  Copyleft(c) 1992 by Orhan OZTURK All Rights Free
 */

package com.orhn.util.wrapper;

public class LongValue {
    private static final int CACHE_MIN = -128;
    private static final int CACHE_MAX = 127;

    private static final LongValue[] CACHE = new LongValue[CACHE_MAX - CACHE_MIN + 1];
    private final int m_value;

    public static final LongValue ZERO = of(0);
    public static final LongValue ONE = of(1);
    public static final LongValue TWO = of(2);
    public static final LongValue TEN = of(10);

    private LongValue(int mValue) {
        m_value = mValue;
    }

    public static LongValue of(int value)
    {
        if(value < CACHE_MIN || CACHE_MAX < value)
            return new LongValue(value);

        int idx = value + 128;

        if(CACHE[idx] == null)
            CACHE[idx] = new LongValue(value);

        return CACHE[idx];
    }
    public int getValue()
    {
        return m_value;
    }

    public int compareTo(LongValue other)
    {
        long diff = m_value - other.m_value;

        if(diff > 0)
            return 1;

        if(diff < 0)
            return -1;

        return 0;
    }

    public LongValue[] divideAndRemainder(int value)
    {
        LongValue[] result = new LongValue[2];
        result[0] = divide(value);
        result[1] = of(m_value % value);

        return result;
    }

    public LongValue[] divideAndRemainder(LongValue value)
    {
        return divideAndRemainder(value.m_value);
    }
    public LongValue add(int value)
    {
        return of(m_value + value);
    }

    public LongValue mod(int value)
    {
        return of(m_value % value);
    }

    public LongValue mod(LongValue value)
    {
        return mod(value.m_value);
    }

    public LongValue add(LongValue value)
    {
        return add(value.m_value);
    }

    public LongValue subtract(int value)
    {
        return add(-value);
    }

    public LongValue subtract(LongValue value)
    {
        return subtract(value.m_value);
    }

    public LongValue multiply(int value) {
        return of(m_value * value);
    }

    public LongValue multiply(LongValue value) {
        return multiply(value.m_value);
    }

    public LongValue divide(int value) {
        return of(m_value / value);
    }

    public LongValue divide(LongValue value) {
        return divide(value.m_value);
    }


    public LongValue inc()
    {
        return add(1);
    }

    public LongValue dec()
    {
        return subtract(1);
    }

    public String toString()
    {
        return m_value + "";
    }


}
