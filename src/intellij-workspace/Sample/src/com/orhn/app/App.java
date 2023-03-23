/*----------------------------------------------------------------------------------------------------------------------
	for-each döngü deyiminde :'den sonraki ifade bir kez yapılır
----------------------------------------------------------------------------------------------------------------------*/

package com.orhn.app;

class App {
	public static void main(String [] args)
	{
		for (int val: Sample.getArray())
			System.out.printf("%d ", val);

		System.out.println();
	}
}

class Sample {
	public static  int[] getArray()
	{
		System.out.println("getArray");
		return new int[]{1, 2, 3, 4, 5, 6, 7, 8};
	}
}