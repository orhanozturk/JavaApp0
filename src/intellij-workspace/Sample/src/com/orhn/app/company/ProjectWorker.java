package com.orhn.app.company;

public class ProjectWorker extends Worker{
    private double m_feeFactor;
    private String m_projectName;

    public double getFeeFactor() {
        return m_feeFactor;
    }

    public void setFeeFactor(double feeFactor) {
        m_feeFactor = feeFactor;
    }

    public String getProjectName() {
        return m_projectName;
    }

    public void setProjectName(String projectName) {
        m_projectName = projectName;
    }
}
