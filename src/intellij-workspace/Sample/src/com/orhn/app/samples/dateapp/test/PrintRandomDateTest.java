package com.orhn.app.samples.dateapp.test;

import com.orhn.app.samples.dateapp.DateUtil;

public class PrintRandomDateTest {

    public static void run()
    {
        java.util.Random r = new java.util.Random();
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Bir sayi giriniz : ");
        int count = Integer.parseInt(kb.nextLine());

        for (int i = 0; i < count ; ++i)
            DateUtil.printRandomDate(r);
    }

}
