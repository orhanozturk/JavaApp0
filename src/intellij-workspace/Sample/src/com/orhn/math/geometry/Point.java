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

	public int m_x;
	public int m_y;

	public int getX() {
		return m_x;
	}

	public void setX(int x) {
		this.m_x = x;
	}

	public int getY() {
		return m_y;
	}

	public void setY(int y) {
		this.m_y = y;
	}
	
	public Point()
	{
	}
	
	public Point(int a)
	{
		m_x = a;
	}
	
	public Point(int a, int b)
	{
		m_x = a;
		m_y = b;
	}
	
	public double distance() 
	{
		return distance(0, 0);
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	
	public double distance(Point other) 
	{
		return distance(other.m_x, other.m_y);
	}
	
	public double distance(int a, int b) 
	{
		return sqrt(pow(m_x - a, 2) + pow(m_y - b, 2));
	}
	
	public void offset(int dx, int dy)
	{
		m_x += dx;
		m_y += dy;
	}
	
	public void print()
	{
		System.out.printf("(%d, %d)%n", m_x, m_y);
	}
	
	public String toString()
	{
		return String.format("(%d, %d)", m_x, m_y);
	}
}