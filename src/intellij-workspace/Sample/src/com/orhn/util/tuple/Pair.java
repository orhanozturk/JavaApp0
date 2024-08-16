/*----------------------------------------------------------------------
	FILE        : Pair.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 06.11.2022

	Immutable Pair class that represents a Tuple<F, S>

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.orhn.util.tuple;

public class Pair<F, S> {
    private final F m_first;
    private final S m_second;

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public Pair()
    {
        this(null, null);
    }

    public Pair(F first, S second)
    {
        m_first = first;
        m_second = second;
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    public String toString()
    {
        return String.format("(%s, %s)", m_first, m_second);
    }

    //...
}
