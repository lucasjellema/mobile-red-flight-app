package com.fhacust.app.mobile.json.dao;

import com.fhacust.app.mobile.entities.FlightPassengerListEntity;

public class FlightPassengerListObject {
    /**
     * class that mimics the structure of the JSON payload for the flights request
     *
     */

    private FlightPassengerListEntity flightPassengerList = null;

    
    public FlightPassengerListObject() {
        super();
    }


    public void setFlightPassengerList(FlightPassengerListEntity flightPassengerList) {
        this.flightPassengerList = flightPassengerList;
    }

    public FlightPassengerListEntity getFlightPassengerList() {
        return flightPassengerList;
    }

}
