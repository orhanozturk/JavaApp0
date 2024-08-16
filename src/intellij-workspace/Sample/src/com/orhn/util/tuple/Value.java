/*----------------------------------------------------------------------
	FILE        : Value.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 06.11.2022

	Immutable Value class that represents a Tuple<T>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.orhn.util.tuple;

public class Value<T> {
    private final T m_value;

    public static <T> Value<T> of(T value)
    {
        return new Value<>(value);
    }

    public Value()
    {
        this(null);
    }

    public Value(T value)
    {
        m_value = value;
    }

    public T getValue()
    {
        return m_value;
    }

    public String toString()
    {
        return String.format("%s", m_value);
    }

    //...
}
