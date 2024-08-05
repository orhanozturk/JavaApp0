package com.orhn.util.datetime;

public class DateApp {

    private static void printDateTR(int day, int month, int year)
    {
        try {
            Date d = new Date(day, month, year);

            System.out.println(d.toLongDateStringTR());
            System.out.println(d.isWeekend() ? "Bugün kurs var. Tekrar yaptınız mı?" : "Kurs günü yaklaşıyor. Tekrar yapmayı unutmayınız!...");
        }
        catch (DateTimeException ignore) {
            System.out.println("Geçersiz değerler");
        }
    }

    private static void printDateEN(int day, int month, int year)
    {
        try {
            Date d = new Date(day, month, year);

            System.out.println(d.toLongDateStringEN());
            System.out.println(d.isWeekend() ? "That is the course day. Did you review?" : "Course day is coming. Do not forget to review!...");
        }
        catch (DateTimeException ignore) {
            System.out.println("Invalid values");
        }
    }
    public static void run()
    {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Gün ay ve yıl bilgilerini giriniz?");
            int day = kb.nextInt();
            int month = kb.nextInt();
            int year = kb.nextInt();

            if (day == 0)
                break;

            printDateTR(day, month, year);
            printDateEN(day, month, year);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}
