/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden bir kare matrisin esas köşegeni (diagonal) üzerindeki sayıların
	toplamını döndüren sumDiagonal isimli metodu ArrayUtil sınıfı içerisinde yazınız ve test ediniz.
	Açıklamalar:
	 - Metot karematris kontrolü yapmayacaktır
	 - Bir kare matrisin esas köşegeni üzerindeki sayılar, örneğin:

	 1 2 3
	 4 5 6
	 7 8 9

	 matrisi için 1, 5 ve 9 sayılarıdır
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

import com.orhn.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		SumDiagonalTest.run();

	}
}

class SumDiagonalTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Bir sayı giriniz:");
		int count = kb.nextInt();


		for (int i = 0; i < count; ++i) {
			int [][] a = ArrayUtil.getRandomSquareMatrix(r, r.nextInt(3, 8), 0, 99);
			ArrayUtil.print(2, a);

			System.out.printf("Esas köşegen üzerindeki elemanların toplamı:%d%n", ArrayUtil.sumDiagonal(a));
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}