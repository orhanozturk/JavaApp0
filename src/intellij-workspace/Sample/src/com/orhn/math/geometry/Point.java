/*-----------------------------------------------------
  	FILE		: Point.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 16.02.2023
  	
  	Point class that represents a 2 dimensional point int Cartesian plane
  	
  	
  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free
   
 -----------------------------------------------------*/

package com.orhn.math.geometry;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point{

	private final int m_x;
	private final int m_y;

	public Point()
	{
		this(0);
	}
	
	public Point(int a)
	{
		this(a, 0);
	}
	
	public Point(int a, int b)
	{
		m_x = a;
		m_y = b;
	}

	public int getX() {
		return m_x;
	}
	/*public void setX(int x) {
		this.m_x = x;
	}*/

	public int getY() {
		return m_y;
	}

	/*public void setY(int y) {
		this.m_y = y;
	}*/


	public double distance() 
	{
		return distance(0, 0);
	}

	public double distance(Point other) 
	{
		return distance(other.m_x, other.m_y);
	}
	
	public double distance(int a, int b) 
	{
		return  PointCommonUtil.distance(m_x, m_y, a, b);
	}
	
	public Point offset(int dxy)
	{
		return offset(dxy, dxy);
	}

	public Point offset(int dx, int dy)
	{
		return new Point(m_x + dx, m_y + dy);
	}

	public MutablePoint toMutablePoint()
	{
		return MutablePoint(m_x, m_y);
	}

	public void print()
	{
		System.out.printf("(%d, %d)%n", m_x, m_y);
	}
	
	public String toString()
	{
		return PointCommonUtil.toString(m_x, m_y);
	}
}