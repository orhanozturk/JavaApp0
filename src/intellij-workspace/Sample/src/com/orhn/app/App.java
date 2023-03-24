/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

import com.orhn.math.geometry.Circle;

class App {
	public static void main(String [] args)
	{
		Circle c = new Circle(-3.2);

		System.out.printf("Radius : %f%n", c.getRadius());
		System.out.printf("Area : %f%n", c.getArea());
		System.out.printf("Circumference : %f%n", c.getCircumference());

		c.setRadius(6.7);
		System.out.printf("Radius : %f%n", c.getRadius());
		System.out.printf("Area : %f%n", c.getArea());
		System.out.printf("Circumference : %f%n", c.getCircumference());
	}
}
