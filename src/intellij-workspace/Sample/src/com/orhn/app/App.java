/*----------------------------------------------------------------------------------------------------------------------
		Aşağıdaki örnekte doWork metodu yalnızca A sınıfına bağlı (dependency) olarak yazılmıştır. Bu metot A sınıfından
	doğrudan ya da dolaylı olarak türetilen her sınıf türünden referans ile çağrılabilir. Yani, doWork metodu için derleme
	zamanından yalnızca A türünün bulunması yeterlidir. Hatta daha sonra A'dan doğrudan ya da dolaylı olarak türetilmiş
	yani A'dan türeyen sınıflar hiyerarşisine eklenmiş sınıflar için de doWork metodu çağrılabilir. Yani doWork metodunu
	ayrıca değiştirmeye gerek yoktur. Burada doWork metodu "türden bağımsız" yazılmıştır. Türden bağımsız kod yazma kavramı
	detaylı olarak ele alınacaktır
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		F f = new F();

		Sample.doWork(a);
		Sample.doWork(b); //upcasting
		Sample.doWork(c); //upcasting
		Sample.doWork(d); //upcasting
		Sample.doWork(e); //upcasting
		Sample.doWork(f); //upcasting
	}
}

class Sample{
	public static void doWork(A a)
	{
		++a.x;
	}
}

class F extends C{

}
class E extends B{

}
class D extends A{

}

class C extends B{

}

class B extends A{

	// ..
}
class A {
	public int x;
	//..
}

