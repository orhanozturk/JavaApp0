package com.orhn.app.school;

import com.orhn.app.samples.dateapp.DateUtil;

public class LectureInfoParser {
    public LectureInfo lectureInfo;

    /*
    <ad soyad>:<ders adı>:<gg-aa-yyyy>:<gg-aa-yyyy>:<arasınav>:<final>
    Oğuz Karan:Matematik:04/04/2022:01/07/2022:78:67
    Barış Er:Radyo Haberleşmesi:03/04/2022:02/07/2022:89:100
    Ziya ÇAYLAN:PLC Programlama:10/04/2022:13/06/2022:90:98
    */


    public static String getDateStr(String str)
    {
        String []dateInfo = str.split("[/]");
        int day = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int year = Integer.parseInt(dateInfo[2]);

        return DateUtil.getDateStrTR(day, month, year);
    }

    public LectureInfoParser(String str)
    {
        String [] lectureInfoStr = str.split("[:]+");

        lectureInfo = new LectureInfo();
        lectureInfo.studentName = lectureInfoStr[0];
        lectureInfo.lectureName = lectureInfoStr[1];
        lectureInfo.midtermDate = getDateStr(lectureInfoStr[2]);
        lectureInfo.finalDate = getDateStr(lectureInfoStr[3]);
        lectureInfo.midtermGrade = Integer.parseInt(lectureInfoStr[4]);
        lectureInfo.finalGrade = Integer.parseInt(lectureInfoStr[5]);
    }
}
