package com.fhacust.app.mobile.json.helper;

import com.fhacust.app.mobile.entities.CustomerComplaintEntity;
import com.fhacust.app.mobile.entities.DepartureDestinationEntity;

public class CustomerComplaintToJson {
    public CustomerComplaintToJson() {
        super();
    }
    /**
      * Converts local flights entity to JSON object string
      * Example:
      * 
     {
       "FlightCode" : {
         "CarrierCode" : "KL",
         "FlightNumber" : 37
       },
       "FlightDate" : "2015-02-25",
       "ComplaintTimestamp" : "2015-03-05T13:20:00",
       "Passenger" : {
         "FirstName" : "Lucas",
         "LastName" : "Jellema",
         "Country" : "NL",
         "FrequentFlyerNumber" : "KP123-9817",
         "Seat" : "12B"
       },
       "Description" : "Very annoying, loud, smelly and extremely large neighbour in 14A.",
       "EmailAddress" : "lucas.jellema@amis.nl",
       "SuggestedCompensation" : 83.72
     }
      * @param department
      * @return
      */
     public static String getJson(CustomerComplaintEntity custcomp){
         
     StringBuffer sb = new StringBuffer();
     sb.append("{");
     
     
      sb.append("\"FlightCode\" : {");
      sb.append("\"CarrierCode\":\""); 
      sb.append(custcomp.getFlightCode().getCarrierCode()+"\",");
      sb.append("\"FlightNumber\":\""); 
      sb.append(custcomp.getFlightCode().getFlightNumber()+"\"},");
               
      sb.append("\"FlightDate\":\"");
      sb.append(custcomp.getFlightDate()+"\",");
    
      sb.append("\"ComplaintTimestamp\":\"");
      sb.append(custcomp.getComplaintTimeStamp()+"\",");
      
         sb.append("\"Passenger\" : {");
         sb.append("\"FirstName\":\""); 
         sb.append(custcomp.getPassenger().getFirstName()+"\",");
         sb.append("\"LastName\":\""); 
         sb.append(custcomp.getPassenger().getLastName()+"\",");
      
         sb.append("\"Country\":\""); 
         sb.append(custcomp.getPassenger().getCountry()+"\",");
      
         sb.append("\"FrequentFlyerNumber\":\""); 
         sb.append(custcomp.getPassenger().getFrequentFlyerNumber()+"\",");

         sb.append("\"Seat\":\""); 
         sb.append(custcomp.getPassenger().getSeat()+"\"},");
      
      
         sb.append("\"Description\":\"");
         sb.append(custcomp.getDescription()+"\",");
         sb.append("\"EmailAddress\":\"");
         sb.append(custcomp.getEmail()+"\",");
         sb.append("\"SuggestedCompensation\":\"");
         sb.append(custcomp.getCompensation()+"\"");
     
     sb.append("}");
     
     String jsonObject = sb.toString();     
                 
     return jsonObject;
     
     }
}
