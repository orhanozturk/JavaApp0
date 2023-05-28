/*-----------------------------------------------------
  	FILE		: AnalyticalCircle.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 28.05.2023

  	AnalyticalCircle class that represents a circle in 2D plane


  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free

 -----------------------------------------------------*/

package com.orhn.math.geometry;

public class AnalyticalCircle extends Circle{
    private final MutablePoint m_center;

    public AnalyticalCircle(double radius)
    {
        this(radius, 0 ,0);
    }

    public AnalyticalCircle(int x, int y)
    {
        this(0, x, y);
    }
    public AnalyticalCircle(double radius, int x, int y)
    {
        super(radius);
        m_center = new MutablePoint(x, y);
    }

    public int getX()
    {
        return m_center.getX();
    }

    public void setX(int x)
    {
        m_center.setX(x);
    }

    public int getY()
    {
        return m_center.getY();
    }

    public void setY(int y)
    {
        m_center.setY(y);
    }

    public void set(int x, int y)
    {
        setX(x);
        setY(y);
    }

    public boolean isTangent(AnalyticalCircle other)
    {
        //TODO
        return true;
    }

    public boolean isInside(int x, int y)
    {
        return m_center.distance(x, y) <= getRadius();
    }

    public void offset(int dxy)
    {
        offset(dxy, dxy);
    }

    public void offset(int dx, int dy)
    {
        m_center.offset(dx, dy);
    }

    public double radiusDistance(AnalyticalCircle other)
    {
        return m_center.distance(other.m_center);
    }
}
