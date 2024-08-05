package com.orhn.app.places;

public class PlaceInfo {
    private String m_name;
    private double m_latitude;
    private double m_longitude;
    //...

    public PlaceInfo(String name, double latitude, double longitude)
    {
        m_name = name;
        m_latitude = latitude;
        m_longitude = longitude;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        //...
        m_name = name;
    }

    public double getLatitude()
    {
        return m_latitude;
    }

    public void setLatitude(double latitude)
    {
        //...
        m_latitude = latitude;
    }

    public double getLongitude()
    {
        return m_longitude;
    }

    public void setLongitude(double longitude)
    {
        //...
        m_longitude = longitude;
    }

    public String toString()
    {
        return String.format("Name:%s, Latitude: %f, Longitude: %f", m_name, m_latitude, m_longitude);
    }
}
