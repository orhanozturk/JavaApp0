package com.orhn.app.school;

import com.orhn.app.samples.dateapp.DateUtil;
import com.orhn.util.datetime.Date;

public class LectureInfoParser {
    private final LectureInfo m_lectureInfo;

    /*
    <ad soyad>:<ders adı>:<gg-aa-yyyy>:<gg-aa-yyyy>:<arasınav>:<final>
    Oğuz Karan:Matematik:04/04/2022:01/07/2022:78:67
    Barış Er:Radyo Haberleşmesi:03/04/2022:02/07/2022:89:100
    Ziya ÇAYLAN:PLC Programlama:10/04/2022:13/06/2022:90:98
    */


    private static Date getDate(String str)
    {
        String []dateInfo = str.split("[/]");
        int day = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int year = Integer.parseInt(dateInfo[2]);

        return new Date(day, month, year);
    }

    public LectureInfoParser(String str)
    {
        String [] lectureInfoStr = str.split("[:]+");

        m_lectureInfo = new LectureInfo();
        m_lectureInfo.setStudentName(lectureInfoStr[0]);
        m_lectureInfo.setLectureName(lectureInfoStr[1]);
        m_lectureInfo.setMidtermDate(getDate(lectureInfoStr[2]));
        m_lectureInfo.setFinalDate(getDate(lectureInfoStr[3]));
        m_lectureInfo.setMidtermGrade(Integer.parseInt(lectureInfoStr[4]));
        m_lectureInfo.setFinalGrade(Integer.parseInt(lectureInfoStr[5]));
    }

    public LectureInfo getLectureInfo()
    {
        return m_lectureInfo;
    }
}
