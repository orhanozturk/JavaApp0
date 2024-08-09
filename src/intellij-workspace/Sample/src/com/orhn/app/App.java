/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki çağrılarda tür belirtilse bile ilgili türden parametreli metotlar çağprılır. Yani bu anlamda tür belirtmenin
	generic çağrılsın gibi bir anlamı Java'da yoktur. Aşağıdaki gibi overload işlemleri bir işlemin türe özgü olarak
	farklılaşması gibi durumlarda kullanılır
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		Sample.foo("ankara"); //#3
		System.out.println("-----------------------------------");
		Sample.<String>foo("ankara"); //#3
		System.out.println("-----------------------------------");
		Sample.foo(10); //#2
		System.out.println("-----------------------------------");
		Sample.<Integer>foo(10); //#2
		System.out.println("-----------------------------------");
		Sample.foo(Integer.valueOf(10)); //#1
		System.out.println("-----------------------------------");
		Sample.foo(3.4); //#1

	}
}

class Sample {
	public static <T> void foo(T t) //#1
	{
		System.out.println("foo(T)");
		System.out.println(t);
	}

	public static  void foo(int val)  //#2
	{
		System.out.println("foo(int)");
		System.out.println(val);
	}

	public static  void foo(String val)  //#3
	{
		System.out.println("foo(String)");
		System.out.println(val);
	}

}

