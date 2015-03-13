package com.fhacust.app.mobile.uri;


public class FlightCustURIs {
    
    private static final String FLIGHTS_URI = "/flights";
    private static final String CUSTOMER_URI = "/complaints";    
    
    //Flights URI
    public static String GetAllFlightsURI(){ return FLIGHTS_URI; }
    public static String GetFlightsByNumberURI(String flightNumber){ return FLIGHTS_URI+"/"+flightNumber;}
    public static String GetPassengersinFlight(String flightNumber){ return FLIGHTS_URI+"/"+flightNumber+"/passengerlist";}
    
    public static String PostFlightStatusUpdateURI(){ return FLIGHTS_URI;}

    //customer URI
    public static String PostCustomerComplaintURI(){return CUSTOMER_URI;}
    
}
