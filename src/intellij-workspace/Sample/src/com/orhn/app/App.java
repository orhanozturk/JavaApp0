/*----------------------------------------------------------------------------------------------------------------------
	4. Bir sınıf referansının onun desteklemediği bir arayüz referansına dönüştürülmesi tür dönüştürme operatörü ile
	yapılabilir. Çalışma zamanında kaynak referansın dinamik türünün hedef arayüzü destekleyipş desteklemediğine bakılır.
	Destekliyorsa haklı dönüşümdür. Desteklemiyorsa haksız dönüşümdür, ClassCastException nesnesi fırlatılır
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		A a = new C();
		IX ix;

		ix = (IX)a; //Haklı dönüşüm

		a = new B();

		ix = (IX)a; //Haksız dönüşüm


		System.out.println("Tekrar yapıyor musunuz?");

	}
}

class C extends A implements IX {
	//...
}
class B extends A {
	//...
}

class A {
	//...
}

interface IX {
	//...
}