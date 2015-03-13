package com.fhacust.app.mobile.entities;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class FlightPassengerListEntity {
    
    private FlightCodeEntity flightCode;
    private String flightDate;
    private String totalNumberOfPassengers;    
                   
   
    private PassengerEntity[] passengers;
    
    
   
 

    public void setTotalNumberOfPassengers(String totalNumberOfPassengers) {
        this.totalNumberOfPassengers = totalNumberOfPassengers;
    }

    public String getTotalNumberOfPassengers() {
        return totalNumberOfPassengers;
    }

    public void setPassengers(PassengerEntity[] passengers) {
        this.passengers = passengers;
    }

    public PassengerEntity[] getPassengers() {
        return passengers;
    }
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public FlightPassengerListEntity() {
        super();
    }

    public void setFlightCode(FlightCodeEntity flightCode) {
        FlightCodeEntity oldFlightCode = this.flightCode;
        this.flightCode = flightCode;
        propertyChangeSupport.firePropertyChange("flightCode", oldFlightCode, flightCode);
    }

    public FlightCodeEntity getFlightCode() {
        return flightCode;
    }

    public void setFlightDate(String flightDate) {
        String oldFlightDate = this.flightDate;
        this.flightDate = flightDate;
        propertyChangeSupport.firePropertyChange("flightDate", oldFlightDate, flightDate);
    }

    public String getFlightDate() {
        return flightDate;
    }



    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    public Object clone() {

        FlightPassengerListEntity pass = new FlightPassengerListEntity();

        pass.setFlightCode(flightCode);
        pass.setFlightDate(flightDate);
        pass.setTotalNumberOfPassengers(totalNumberOfPassengers);
        pass.setPassengers(passengers);
        return pass;
    }

}
