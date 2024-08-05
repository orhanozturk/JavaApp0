/*----------------------------------------------------------------------
	FILE        : DateTimeException.java
	AUTHOR      : Java-Feb-2022 Group
	LAST UPDATE : 07.10.2022

	DateTimeException class

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.orhn.util.datetime;

public class DateTimeException extends RuntimeException {
    public DateTimeException(String message)
    {
        super(message);
    }

    public String getMessage()
    {
        return String.format("For input value:%s", super.getMessage());
    }
}