/*----------------------------------------------------------------------------------------------------------------------
	Arayüz referansları taban sınıf referansı gibi kullanılabilir. Böylelikle "polymorphism" arayüzler ile de
	gerçekleştirilebilmektedir. Yani arayüzler "çoklu türetmeyi (multiple inheritance)" kısmı olarak kullanabilme
	olanağı sağlar.

	Aşağıdaki örnekte Test sınıfo IY arayüzünü desteklemediğinde ** ile belirtilen çağrıda error oluşur
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		Util u = new Util();
		Sample s = new Sample();
		Test t = new Test();

		u.doWorkForIX(s);
		u.doWorkForIY(s);
		u.doWorkForIX(t);
		u.doWorkForIY(t); //** error

	}
}

class Util {
	//...
	public void doWorkForIX(IX ix)
	{
		//...

		ix.foo();
	}


	public void doWorkForIY(IY iy)
	{
		//...

		iy.bar();
	}
}

class Test implements IX {
	public void foo()
	{
		System.out.println("Test.foo");
	}
}

class Sample implements IX, IY {
	public void foo()
	{
		System.out.println("Sample.foo");
	}

	public void bar()
	{
		System.out.println("Sample.bar");
	}
}


interface IX {
	void foo();
}

interface IY {
	void bar();
}

