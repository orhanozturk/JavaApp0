/*----------------------------------------------------------------------------------------------------------------------
	Partition algoritması ve ArrayUtil sınıfının partition metodu
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;
import com.orhn.app.lottery.NumericLotteryApp;
import com.orhn.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String[] args) {
		PartitionTest.run();
	}
}
class PartitionTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		for (;;) {
			System.out.print("Bir sayı giriniz:");
			int count = Integer.parseInt(kb.nextLine());

			if (count <= 0)
				break;

			System.out.print("Eşik değerini giriniz:");
			int threshold = Integer.parseInt(kb.nextLine());

			int [] a = ArrayUtil.getRandomArray(r, count, 0, 99);
			System.out.println("---------------------------------------------------------");
			ArrayUtil.print(2, a);
			int partitionPoint = ArrayUtil.partition(a, threshold);

			System.out.printf("Bölümleme Noktası:%d%n", partitionPoint);
			ArrayUtil.print(2, a);
			System.out.println("---------------------------------------------------------");
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}

