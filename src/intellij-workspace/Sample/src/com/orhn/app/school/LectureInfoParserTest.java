package com.orhn.app.school;
/*
    <ad soyad>:<ders adı>:<gg-aa-yyyy>:<gg-aa-yyyy>:<arasınav>:<final>
    Oğuz Karan:Matematik:04/04/2022:01/07/2022:78:67
    Barış Er:Radyo Haberleşmesi:03/04/2022:02/07/2022:89:100
    Ziya ÇAYLAN:PLC Programlama:10/04/2022:13/06/2022:90:98
    */

import java.util.Scanner;
public class LectureInfoParserTest {
    public static void printLectureInfo(LectureInfo lectureInfo)
    {
        int grade = lectureInfo.getGrade();

        System.out.printf("Adı Soyadı:%s%n", lectureInfo.getStudentName());
        System.out.printf("Ders Adı:%s%n", lectureInfo.getLectureName());
        System.out.printf("Arasınav Tarihi:%s%n", lectureInfo.getMidtermDate().toLongDateStringTR());
        System.out.printf("Final Tarihi:%s%n", lectureInfo.getFinalDate().toLongDateStringTR());
        System.out.printf("Arasınav Notu:%d%n", lectureInfo.getMidtermGrade());
        System.out.printf("Final Notu:%d%n", lectureInfo.getFinalGrade());
        System.out.printf("Geçme Notu:%d%n", grade);
        System.out.printf("Sonuç:%s%n", grade >= 50 ? "Geçti" : "Kaldı");
    }

    public static void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Formatlı yazıyı giriniz:");
            String str = kb.nextLine();

            if ("elma".equals(str))
                break;

            LectureInfoParser parser = new LectureInfoParser(str);
            LectureInfo lectureInfo = parser.getLectureInfo();

            printLectureInfo(lectureInfo);
        }

        System.out.println("Tekrar yapıyor musunuz?");
    }
}