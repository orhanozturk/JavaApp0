/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin aşağıdaki açıklamalara
	göre haftanın hangi gününe geldiğini döndüren getDayOfWeek isimli metodu yazınız ve aşağıdaki kod ile test ediniz.
	Açıklamalar:
		- Metot geçersiz bir tarih durumunda -1 değerine geri dönecektir
		- Haftanın günü 1.1.1900 ile verilen tarih arasındaki (verilen tarih dahil) gün sayısının 7(yedi) ile bölümünden
		elde edilen kalan ile belirlenebilir. Buna göre değer sıfır ise "pazar", 1 ise "pazartesi", ..., 6 ise "cumartesi"
		günlerine karşılık gelir

		- 1.1.1900 öncesindeki tarihler geçersiz sayılacaktır
		- getDayOfWeek metodu ile birlikte

		- İleride daha iyisi yazılacaktır parametresi ile aldığı int türden gün, ay ve yıl bilgilerine ilişkin tarihin
		hafta sonu olup olmadığınıu test eden isWeekend ve hafta içi olup olmadığını test eden isWeekday metotlarını yazınız.
		Bu iki metot tarih geçerlilik kontrolü yapmayacaktır
----------------------------------------------------------------------------------------------------------------------*/

/*
Homework
Sınıf Çalışması: Parametresi ile aldığı en fazla üç basamaklı bir sayının Türkçe okunuşunu döndüren numToText3DigitsTR
	isimli metodu NumberUtil sınıfı içerisinde yazınız ve aşağıdaki kod ile test ediniz.
	Açıklamalar:
		- Metot 3 basamaktan büyük sayı kontrolü yapmayacaktır
		- Örnekler:
				123		-> yüzyirmiüç
				-123	-> eksiyüzyirmiüç
				203		-> ikiyüzüç
 */

package com.orhn.app;
import com.orhn.util.NumberUtil;
import java.util.Random;
import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		NumToText3DigitsTRTest.run();
	}
}

class NumToText3DigitsTRTest {
	public static void run()
	{
		Scanner kb = new Scanner(System.in);
		Random r = new Random();

		System.out.print("Bir sayı giriniz:");
		int count = Integer.parseInt(kb.nextLine());

		for (int i = 0; i < count; ++i) {
			int val = r.nextInt(-999, 1000);
			String fmt = (val < 0 ? "-%03d " : " %03d ") +  " -> %s%n";
			System.out.printf(fmt, Math.abs(val), NumberUtil.numToText3DigitsTR(val));
		}

		System.out.println("Tekrar yapıyor musunuz?");
	}
}


