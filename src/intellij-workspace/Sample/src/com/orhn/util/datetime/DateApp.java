package com.orhn.util.datetime;

public class DateApp {

    private static void printDateTR(int day, int month, int year)
    {
        Date d = new Date(day, month, year);

        System.out.println(d.toLongDateStringTR());
        System.out.println(d.isWeekend() ? "Bugun hava guzel" : "Bugun hava kotu.");
    }

    private static void printDateEN(int day, int month, int year)
    {
        Date d = new Date(day, month, year);

        System.out.println(d.toLongDateStringEN());
        System.out.println(d.isWeekend() ? "Day is a good" : "Day is a bad");
    }

    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for(;;){
            System.out.print("Gun ay ve yıl bilgilerini giriniz?");
            int day = kb.nextInt();
            int month = kb.nextInt();
            int year = kb.nextInt();

            if(day == 0)
                break;

            printDateTR(day, month, year);
            printDateEN(day, month, year);
        }
    }
}
