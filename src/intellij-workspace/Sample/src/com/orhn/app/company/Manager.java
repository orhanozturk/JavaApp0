package com.orhn.app.company;

public class Manager extends Employee{
    private double m_salary;
    private String m_department;

    public double getSalary() {
        return m_salary;
    }

    public void setSalary(double salary) {
        this.m_salary = salary;
    }

    public String getDepertment() {
        return m_department;
    }

    public void setDepartment(String department) {
        this.m_department = department;
    }
}
