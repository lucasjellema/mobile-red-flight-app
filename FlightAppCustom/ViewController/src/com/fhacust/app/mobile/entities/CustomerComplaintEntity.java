package com.fhacust.app.mobile.entities;


public class CustomerComplaintEntity {
    
    private FlightCodeEntity flightCode;
    private String flightDate;
    private String complaintTimeStamp;
    private PassengerEntity passenger;
    private String description;
    private String email;
    private String compensation;
    
    public CustomerComplaintEntity() {
        super();
    }

    public void setFlightCode(FlightCodeEntity flightCode) {
        this.flightCode = flightCode;
    }

    public FlightCodeEntity getFlightCode() {
        return flightCode;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setComplaintTimeStamp(String complaintTimeStamp) {
        this.complaintTimeStamp = complaintTimeStamp;
    }

    public String getComplaintTimeStamp() {
        return complaintTimeStamp;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getCompensation() {
        return compensation;
    }

}
