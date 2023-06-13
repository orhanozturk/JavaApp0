package com.orhn.app.company;

public class Employee {
    private String m_citizenId;
    private String m_name;
    private String m_address;

    public String getCitizenId() {
        return m_citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.m_citizenId = citizenId;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        this.m_name = name;
    }

    public String getAddress() {
        return m_address;
    }

    public void setAddress(String address) {
        this.m_address = address;
    }
}
