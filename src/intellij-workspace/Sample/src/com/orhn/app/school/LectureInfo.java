package com.orhn.app.school;

import com.orhn.util.datetime.Date;

public class LectureInfo {
    private String m_studentName;
    private String m_lectureName;
    private Date m_midtermDate;
    private Date m_finalDate;
    private int m_midtermGrade;
    private int m_finalGrade;
    public String getStudentName() {
        return m_studentName;
    }

    public void setStudentName(String studentName) {
        this.m_studentName = studentName;
    }

    public String getLectureName() {
        return m_lectureName;
    }

    public void setLectureName(String lectureName) {
        this.m_lectureName = lectureName;
    }

    public Date getMidtermDate() {
        return m_midtermDate;
    }

    public void setMidtermDate(Date midtermDate) {
        this.m_midtermDate = midtermDate;
    }

    public Date getFinalDate() {
        return m_finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.m_finalDate = finalDate;
    }

    public int getMidtermGrade() {
        return m_midtermGrade;
    }

    public void setMidtermGrade(int midtermGrade) {
        this.m_midtermGrade = midtermGrade;
    }

    public int getFinalGrade() {
        return m_finalGrade;
    }

    public void setFinalGrade(int finalGrade) {
        this.m_finalGrade = finalGrade;
    }

    public int getGrade()
    {
        return (int)Math.round(m_midtermGrade* 0.4 + m_finalGrade * 0.6);
    }
}
