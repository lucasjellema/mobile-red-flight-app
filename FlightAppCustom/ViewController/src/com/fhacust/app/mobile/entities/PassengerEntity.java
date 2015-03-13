package com.fhacust.app.mobile.entities;

import java.util.logging.Level;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class PassengerEntity {

    private String firstName;
    private String lastName;
    private String country;
    private String frequentFlyerNumber;
    private String seat;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public PassengerEntity() {
        super();
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        propertyChangeSupport.firePropertyChange("firstName", oldFirstName, firstName);
        Trace.log(Utility.ApplicationLogger, Level.SEVERE, PassengerEntity.class, "setFirstName",
                  firstName);

    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        propertyChangeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        propertyChangeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getCountry() {
        return country;
    }

    public void setFrequentFlyerNumber(String frequentFlyerNumber) {
        String oldFrequentFlyerNumber = this.frequentFlyerNumber;
        this.frequentFlyerNumber = frequentFlyerNumber;
        propertyChangeSupport.firePropertyChange("frequentFlyerNumber", oldFrequentFlyerNumber, frequentFlyerNumber);
    }

    public String getFrequentFlyerNumber() {
        return frequentFlyerNumber;
    }

    public void setSeat(String seat) {
        String oldSeat = this.seat;
        this.seat = seat;
        propertyChangeSupport.firePropertyChange("seat", oldSeat, seat);
    }

    public String getSeat() {
        return seat;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
