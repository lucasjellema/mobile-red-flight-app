package com.fhacust.app.mobile.entities;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class FlightCodeEntity {
    
    private String CarrierCode;
    private String FlightNumber;

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setCarrierCode(String CarrierCode) {
        String oldCarrierCode = this.CarrierCode;
        this.CarrierCode = CarrierCode;
        propertyChangeSupport.firePropertyChange("CarrierCode", oldCarrierCode, CarrierCode);
    }

    public String getCarrierCode() {
        return CarrierCode;
    }

    public void setFlightNumber(String FlightNumber) {
        String oldFlightNumber = this.FlightNumber;
        this.FlightNumber = FlightNumber;
        propertyChangeSupport.firePropertyChange("FlightNumber", oldFlightNumber, FlightNumber);
    }

    public String getFlightNumber() {
        return FlightNumber;
    }
    public FlightCodeEntity() {
        super();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
