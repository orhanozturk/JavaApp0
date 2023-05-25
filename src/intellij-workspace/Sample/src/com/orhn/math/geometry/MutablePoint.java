/*-----------------------------------------------------
  	FILE		: MutablePoint.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 25.05.2023

  	MutablePoint class that represents a 2 dimensional point int Cartesian plane


  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free

 -----------------------------------------------------*/

package com.orhn.math.geometry;

public class MutablePoint {
    private int m_x;
    private int m_y;

    public MutablePoint()
    {
    }
    public MutablePoint(int x)
    {
        m_x = x;
    }
    public MutablePoint(int x, int y)
    {
        m_x = x;
        m_y = y;
    }

    public int getX() {
        return m_x;
    }

    public void setX(int m_x) {
        this.m_x = m_x;
    }

    public int getY() {
        return m_y;
    }

    public void setY(int m_y) {
        this.m_y = m_y;
    }


    public double distance()
    {
        return distance(0, 0);
    }

    public double distance(MutablePoint other)
    {
        return distance(other.m_x, other.m_y);
    }

    public double distance(int x, int y)
    {
        return  PointCommonUtil.distance(m_x, m_y, x, y);
    }

    public void offset(int dxy)
    {
        offset(dxy, dxy);
    }

    public void offset(int dx, int dy)
    {
        m_x += dx;
        m_y += dy;
    }

    public Point toPoint()
    {
        return new Point(m_x, m_y);
    }

    public String toString()
    {
        return PointCommonUtil.toString(m_x, m_y);
    }
}
