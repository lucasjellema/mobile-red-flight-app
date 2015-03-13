package com.fhacust.app.mobile.entities;


import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class FlightDetailsEntity {
    private FlightCodeEntity flightcode;
    private String flightDate;
    private String flightStatus;
    private SlotEntity departure;
    private SlotEntity destination;


    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public FlightDetailsEntity() {
        super();
    }

    public Object clone() {

        FlightDetailsEntity fde = new FlightDetailsEntity();
        fde.setFlightcode(flightcode);
        fde.setFlightDate(flightDate);
        fde.setFlightStatus(flightStatus);
        fde.setDeparture(departure);
        fde.setDestination(destination);
        return fde;
    }

    public void setFlightcode(FlightCodeEntity flightcode) {
        FlightCodeEntity oldFlightcode = this.flightcode;
        this.flightcode = flightcode;
        propertyChangeSupport.firePropertyChange("flightcode", oldFlightcode, flightcode);
    }

    public FlightCodeEntity getFlightcode() {
        return flightcode;
    }

    public void setDeparture(SlotEntity departure) {
        SlotEntity oldDeparture = this.departure;
        this.departure = departure;
        propertyChangeSupport.firePropertyChange("departure", oldDeparture, departure);
    }

    public SlotEntity getDeparture() {
        return departure;
    }

    public void setDestination(SlotEntity destination) {
        SlotEntity oldDestination = this.destination;
        this.destination = destination;
        propertyChangeSupport.firePropertyChange("destination", oldDestination, destination);
    }

    public SlotEntity getDestination() {
        return destination;
    }

    public void setFlightDate(String flightDate) {
        String oldFlightDate = this.flightDate;
        this.flightDate = flightDate;
        propertyChangeSupport.firePropertyChange("flightDate", oldFlightDate, flightDate);
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightStatus(String flightStatus) {
        String oldFlightStatus = this.flightStatus;
        this.flightStatus = flightStatus;
        propertyChangeSupport.firePropertyChange("flightStatus", oldFlightStatus, flightStatus);
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
