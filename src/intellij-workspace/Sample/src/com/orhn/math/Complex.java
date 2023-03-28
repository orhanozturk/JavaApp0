/*-----------------------------------------------------
  	FILE		: Complex.java
  	AUTHOR		: Orhan OZTURK
  	LAST UPDATE : 16.02.2023
  	
  	Complex class that represents a complex number
  	
  	
  	Copyleft(c) 1992 by Orhan ÖZTÜRK All Rights Free
   
 -----------------------------------------------------*/

package com.orhn.math;

import static java.lang.Math.sqrt;

public class Complex{


	public double m_real;
	public double m_imag;

	public double getReal() {
		return m_real;
	}

	public double getImag() {
		return m_imag;
	}

	public void setReal(double real) {
		this.m_real = real;
	}

	public void setImag(double imag) {
		this.m_imag = imag;
	}
	
	public static Complex add(double a1, double b1, double a2, double b2) //ileride bu metot gizlenecek
	{
		return new Complex(a1 + a2, b1 + b2);
	}

	public static Complex subtract(double a1, double b1, double a2, double b2)  //ileride bu metot gizlenecek
	{
		return add(a1, b1, -a2, -b2);
	}
	
	public static Complex multiply(double a1, double b1, double a2, double b2)  //ileride bu metot gizlenecek
	{
		return new Complex(a1 * a2 - b1 * b2, a1 * b2 + a2 * b1);
	}
	
	public Complex()
	{
	}
	
	public Complex(double re)
	{
		m_real = re;
	}
	
	public Complex(double re, double im)
	{
		m_real = re;
		m_imag = im;
	}
	
	public double getNorm()
	{
		return sqrt(m_real * m_real + m_imag * m_imag);
	}
	
	public double getLength()
	{
		return getNorm();
	}
	
	public Complex getComjugate()
	{
		return  new Complex(m_real, -m_imag);
	}
	
	public static Complex add(double value, Complex z) 
	{
		return add(value, 0, z.m_real, z.m_imag);
	}
	
	public Complex add(Complex other)
	{
		return add(m_real, m_imag, other.m_real, other.m_imag);
	}
	
	public Complex add(double value)
	{
		return add(m_real, m_imag, value, 0);
	}
	
	public static Complex subtract(double value, Complex z)
	{
		return subtract(value, 0, z.m_real, z.m_imag);
	}
	
	public Complex subtract(Complex other)
	{
		return subtract(m_real, m_imag, other.m_real, other.m_imag);
	}
	
	public Complex subtract(double value)
	{
		return subtract(m_real, m_imag, value, 0);
	}
	
	public static Complex multiply(double value, Complex z)
	{
		return multiply(value, 0, z.m_real, z.m_imag);
	}
	
	public Complex multiply(Complex other)
	{
		return multiply(m_real, m_imag, other.m_real, other.m_imag);
	}
	
	public Complex multiply(double value)
	{
		return multiply(m_real, m_imag, value, 0);
	}
	
	public void inc(double value)
	{
		m_real += value;
	}
	
	public void inc()
	{
		inc(1);
	}
	
	public void dec(double value)
	{
		inc(-value);
	}
	
	public void dec()
	{
		dec(1);
	}
	
	public void print()
	{
		System.out.printf("|%.2f, %.2f| = %f%n", m_real, m_imag, getNorm());
	}
	
	public String toString()
	{
		return String.format("|%.2f, %.2f| = %f", m_real, m_imag, getNorm());
	}
	
}
