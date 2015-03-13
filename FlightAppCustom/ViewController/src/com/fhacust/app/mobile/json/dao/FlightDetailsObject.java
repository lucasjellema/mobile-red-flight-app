package com.fhacust.app.mobile.json.dao;

import com.fhacust.app.mobile.entities.FlightDetailsEntity;

public class FlightDetailsObject {
    /**
     * class that mimics the structure of the JSON payload for the flights request
     *
     */


    
    private FlightDetailsEntity flightDetails = null;

    public FlightDetailsObject() {
        super();
    }


    public void setFlightDetails(FlightDetailsEntity flightDetails) {
        this.flightDetails = flightDetails;
    }

    public FlightDetailsEntity getFlightDetails() {
        return flightDetails;
    }


}
