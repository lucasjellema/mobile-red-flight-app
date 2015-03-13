package com.fhacust.app.mobile.entities;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class SlotEntity {
    
    private String time;
    private String airportCode;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        propertyChangeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getTime() {
        return time;
    }

    public void setAirportCode(String airportCode) {
        String oldAirportCode = this.airportCode;
        this.airportCode = airportCode;
        propertyChangeSupport.firePropertyChange("airportCode", oldAirportCode, airportCode);
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportName(String airportName) {
        String oldAirportName = this.airportName;
        this.airportName = airportName;
        propertyChangeSupport.firePropertyChange("airportName", oldAirportName, airportName);
    }

    public String getAirportName() {
        return airportName;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        propertyChangeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        propertyChangeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getCountry() {
        return country;
    }
    private String airportName;
    private String city;
    private String country;
    
    public SlotEntity() {
        super();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
