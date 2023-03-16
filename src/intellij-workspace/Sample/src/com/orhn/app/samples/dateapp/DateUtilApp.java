package com.orhn.app.samples.dateapp;

public class DateUtilApp {
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;){
            System.out.print("Gün ay ve yıl bilgilerini giriniz?");
            int day = kb.nextInt();
            int month = kb.nextInt();
            int year = kb.nextInt();

            if(day == 0)
                break;

            DateUtil.printDateTR(day, month, year);
            DateUtil.printDateEN(day, month, year);
        }
    }
}
