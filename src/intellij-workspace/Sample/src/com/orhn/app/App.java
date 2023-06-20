/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örnekte miv referansına null atanması derleyicinin "değer verilmeme ihtimali olan bir değişkeni kullanıyorsun"
	şeklindeki hata durumunu engellemöek için kullanılmıştır. Derleyic programcının aşağıdaki algoritması anlayıp akışın
	hiç bir switch deyiminden yakalanmadan çıkacağını anla(ya)maz. Üstelik anlamak zorunda da değildir. Hatta aşağıdaki
	kod anlaması mümkün olmayacak şekilde de yazılabilir. Örneğin if deyimi ve yaptıkları bir metot içerisinde yazılıp burada
	çağrılabilir. Bu durumda derleyici bunu anlayamaz. Şüphesiz aşağıdaki örnek farklı şekillerde de ytazılabilir. null
	kullanımı göstermek için bu şekilde yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

import com.orhn.util.wrapper.MutableIntValue;

import java.util.Scanner;

class App {
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("Bir sayı giriniz:");
		int a = Integer.parseInt(kb.nextLine());

		if(a < 1 || a > 3){
			System.out.println("Geçersiz bir deger girdiniz!....");
			System.exit(1);
		}

		MutableIntValue miv = null;

		switch (a){
			case 1 -> miv = new MutableIntValue(-128);
			case 2 -> miv = new MutableIntValue(0);
			case 3 -> miv = new MutableIntValue(127);
		}

		System.out.printf("Value = %d%n", miv.getValue());
	}
}