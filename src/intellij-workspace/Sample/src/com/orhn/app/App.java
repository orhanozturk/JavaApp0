/*----------------------------------------------------------------------------------------------------------------------
	Sarmalayan Sınıflar (Wrapper Classes): Java'da her temel türe karşılık gelen bir sınıf vardır. Bu sınıflara
	sarmalayan sınıflar denir. Böyle bir tasarımın nedeni sınıfları tanıdıkça anlaşılacaktır. Bu sınıflar sarmalamanın
	dışında ilgili temel türe ilişkin bazı yararlı işlemlerin de yapılmasına yönelik metotlar. Örneğin Integer sarmalayan
	sınıfının parseInt metodu bir yazıyı int türden bir değere çevirmek için kullanılır. Temel türlere ilişkin
	sarmalayan sınıflar şunlardır:

	Temel Tür							Sarmalayan Sınıf
	----------------------------------------------------
	short									Short
	int										Integer
	long									Long
	byte									Byte
	double									Double
	float									Float
	char									Character
	boolean									Boolean

	Bu sınıflardan tanmsayı ve gerçek sayı türlerine ilişkin olanlarına (Short, Integer, Long, Byte, Double ve Float)
	numerik sarmalayan sınıflar da denebilir.

	Sarmalayan sınıfların temel özellikleri:
	- Sarmalayan sınıfların hepsi java.lang paraketi içerisinde bildirilmiştir

	- Tamsayı ve gerçek sayı türlerine ilişkin sınıflar java.lang paketinde bulunan Number sınıfından türetilmiştir. Number
	sınıfının birçok yararlı metodu vardır. Bu metotlar ileride ele alınacaktır.

	- Sarmalayan sınıfların hepsi "immutable"'dır.

	- Bu sınıflar temel türden değerlerin heap'de tutulması için kullanılır. Bu kavrama "kutulama (boxing)" denir. Bu
	konu ileride ele alınacaktır.

	- Java 9 ile birlikte sarmalayan sınıfların ctor'ları "deprecated" olmuştur. Zaten Java 5'den itibaren bu ctor'ların
	kullanılması iyi bir teknbik değildi, artık deprecated olduğu için hiç kullanılmamalıdır. Bunun ileride anlaşılacaktır
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	Tamsayı, gerçek sayı ve char türüne ilişkin sarmalayan sınıfların MIN_VALUE ve MAX_VALUE isimli final ve static veri
	elemanları vardır. Bu elemanlar ilişkin oldukları temel türdendir. Double ve Float sınıflarının MIN_VALUE değerlerinin
	pozitif olduğuan dikkat ediniz. Bu durum IEEE 754 formatına ilişkindir. double ve float türleri için sınır değerlerin
	"-+" biçiminde olduğunu anımsayınız
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

class App {
	public static void main(String [] args)
	{
        System.out.printf("byte:[%d, %d]%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short:[%d, %d]%n", Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int:[%d, %d]%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long:[%d, %d]%n", Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("double:[-+" +  Double.MIN_VALUE + ", -+" + Double.MAX_VALUE + "]");
        System.out.println("float:[-+" +  Float.MIN_VALUE + ", -+" + Float.MAX_VALUE + "]");
        System.out.printf("char:[%d, %d]%n", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE);

	}
}
