/*----------------------------------------------------------------------------------------------------------------------
	 Sınıf Çalışması: com.orhn.util.datetime paketi içerisindeki Time ve TimeUtil sınıflarını yazınız
	 Açıklamalar:
		- Sınıfın public bölümünü değiştirmeden diledğiniz kadar metot ya da veri ekleyebilirsiniz
		- Zaman geçerlilik kontrolü yapılacaktır. Geçersiz olması durumunda program uygun mesaj verip sonlandırılacaktır
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		Time now = new Time();

		System.out.println(now.toLongTimeString());
	}
}

