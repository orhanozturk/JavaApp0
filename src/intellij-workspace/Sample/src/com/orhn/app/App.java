/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte Color enum sınıfına eklenem ctor ile her bir sabite ilişkin nesne için bilgiler iliştirilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb =new Scanner(System.in);
		RandomColorFactory factory = new RandomColorFactory(new Random());

		System.out.println("Bir sayi giriniz:");
		int count = kb.nextInt();

		for (int i = 0; i < count; i++){
			Color color = factory.getColor();

			System.out.println("-------------------------------");
			System.out.printf("%s:{r: %d, g: %d, b: %d}%n", color.toString(), color.r, color.g, color.b);
		}
	}
}

class RandomColorFactory{
	private static final Color [] COLORS = Color.values();
	private final Random m_random;

	public RandomColorFactory(Random m_random)
	{
		this.m_random = m_random;
	}

	public Color getColor()
	{
		return COLORS[m_random.nextInt(COLORS.length)];
	}
}

enum Color{
	RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), WHITE(255, 255, 255), BLACK(0, 0, 0);

	public final int r, g, b;
	Color(int x, int y, int z)
	{
		r = x;
		g = y;
		b = z;
	}

}
