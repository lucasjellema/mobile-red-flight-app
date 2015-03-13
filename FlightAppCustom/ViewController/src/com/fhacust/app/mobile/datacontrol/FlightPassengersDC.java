package com.fhacust.app.mobile.datacontrol;

import com.fhacust.app.mobile.entities.CustomerComplaintEntity;
import com.fhacust.app.mobile.entities.DepartureDestinationEntity;
import com.fhacust.app.mobile.entities.FlightCodeEntity;
import com.fhacust.app.mobile.entities.FlightDetailsEntity;
import com.fhacust.app.mobile.entities.FlightPassengerListEntity;
import com.fhacust.app.mobile.entities.PassengerEntity;
import com.fhacust.app.mobile.json.helper.CustomerComplaintToJson;
import com.fhacust.app.mobile.json.helper.FlightDetailsEntityToJson;
import com.fhacust.app.mobile.json.helper.JsonObjectToFlightDetailsObject;
import com.fhacust.app.mobile.json.helper.JsonObjectToFlightPassengerListObject;
import com.fhacust.app.mobile.uri.FlightCustURIs;
import com.fhacust.app.mobile.utils.RestCallerUtil;

import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class FlightPassengersDC {
    
    String flightNumber ="KL34";
    
    //Details for a selected flight. 
    private FlightDetailsEntity flightDetails = null;
  

    //all Passengerrs. We fecth the passnegers only once as this is not expected to
    //change in the context of the flight
    private FlightPassengerListEntity flightPassengers = null;
 
    
    public FlightPassengersDC() {
        super();
    }
    

    public void setFlightDetails(FlightDetailsEntity flightDetails) {
        this.flightDetails = flightDetails;
    }


    public void refresh(){
        getFlightDetails();
        flightPassengers=null;
        getFlightPassengers();
    }

    public void findFlightByNumber(String flightNr){
        if (flightNr!=null&&flightNr!=""){
            this.flightNumber=flightNr;
        }
        getFlightDetails();
    }
   
    public FlightDetailsEntity getFlightDetails() {

        if(flightDetails == null){ 
            String restURI = FlightCustURIs.GetFlightsByNumberURI(this.flightNumber);
            RestCallerUtil rcu = new RestCallerUtil();
            String jsonObjectAsString = rcu.invokeREAD(restURI);
            FlightDetailsEntity flights = JsonObjectToFlightDetailsObject.getFlightsObject(jsonObjectAsString);
            flightDetails = flights;
        }

        return flightDetails;
    }


    public void updateFlightStatus(String newFlightStatus) {
        String restURI = FlightCustURIs.PostFlightStatusUpdateURI();
        RestCallerUtil rcu = new RestCallerUtil();
        
        DepartureDestinationEntity flightStatus = new DepartureDestinationEntity();
        flightStatus.setFlightStatus(newFlightStatus);
        flightStatus.setFlightcode(flightDetails.getFlightcode());
        flightStatus.setFlightDate(flightDetails.getFlightDate());
        
        
        String jsonArrayAsString = rcu.invokeUPDATE(restURI, FlightDetailsEntityToJson.getJson(flightStatus));
    }

    public void createCustomerComplaint(String carrierCode, String flightNumber, String flightDate,
                                        String complaintTimeStamp, String firstName, String lastName, String country,
                                        String frequentFlyerNumber, String seat, String description, String email,
                                        String compensation) {

        CustomerComplaintEntity cust = new CustomerComplaintEntity();

        FlightCodeEntity fc = new FlightCodeEntity();
        fc.setCarrierCode(carrierCode);
        fc.setFlightNumber(flightNumber);
        cust.setFlightCode(fc);
        cust.setFlightDate(flightDate);
        cust.setComplaintTimeStamp(complaintTimeStamp);

        PassengerEntity p = new PassengerEntity();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setCountry(country);
        p.setFrequentFlyerNumber(frequentFlyerNumber);
        p.setSeat(seat);
        cust.setPassenger(p);
        cust.setDescription(description);
        cust.setEmail(email);
        cust.setCompensation(compensation);

        //this is where all the infrastructure classes and methods become handy
        String restURI = FlightCustURIs.PostCustomerComplaintURI();
        RestCallerUtil rcu = new RestCallerUtil();
        String jsonString = rcu.invokeUPDATEcust(restURI, CustomerComplaintToJson.getJson(cust));

    }
    
    
    public void setFlightPassengers(FlightPassengerListEntity flightPassengers) {
        this.flightPassengers = flightPassengers;
    }

    public FlightPassengerListEntity getFlightPassengers() {
        
        if(flightPassengers == null){
   
            String restURI = FlightCustURIs.GetPassengersinFlight(flightNumber);
            RestCallerUtil rcu = new RestCallerUtil();
            String jsonArrayAsString = rcu.invokeREAD(restURI);
            FlightPassengerListEntity passengers =
                JsonObjectToFlightPassengerListObject.getPassengersArray(jsonArrayAsString);
            flightPassengers = passengers;
        }
        return flightPassengers;
    }
    

    //***** provider change support *****//
    //Enable provider change support
      protected transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

      public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
      }

      public void removeProviderChangeListener(ProviderChangeListener l) {
         providerChangeSupport.removeProviderChangeListener(l);
      }


    
    
}
