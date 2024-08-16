/*----------------------------------------------------------------------------------------------------------------------
	Aşağıdaki örneği inceleyiniz. Örnek durumu göstermek için yazılmıştır
----------------------------------------------------------------------------------------------------------------------*/
package com.orhn.app;

import java.util.Random;

class App {
	public static void main(String [] args)
	{
		String currentWorkingDirectory = System.getProperty("user.dir");

		System.out.printf("Current working  Directory:%s%n", currentWorkingDirectory);

		if(args.length > 0)
			System.setProperty("user.dir", args[0]);

		currentWorkingDirectory = System.getProperty("user.dir");

		System.out.printf("Current Working  Directory:%s%n", currentWorkingDirectory);
	}
}
