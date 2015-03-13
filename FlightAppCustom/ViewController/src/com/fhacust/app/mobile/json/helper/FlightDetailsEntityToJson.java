package com.fhacust.app.mobile.json.helper;

import com.fhacust.app.mobile.entities.DepartureDestinationEntity;

public class FlightDetailsEntityToJson {
    public FlightDetailsEntityToJson() {
        super();
    }
    
       /**
         * Converts local flights entity to JSON object string
         * Example:
         * {
           "FlightCode" :  "KL34",
           "FlightDate" : "2015-03-07T+01:00",
           "FlightStatus" : "boarding"
         }
         *  }
         * @param department
         * @return
         */
        public static String getJson(DepartureDestinationEntity flight){
            
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        
        if(flight.getFlightStatus()!=null){
         sb.append("\"FlightCode\":\"");
         sb.append(flight.getFlightcode()+"\",");
     
         sb.append("\"FlightDate\":\"");
         sb.append(flight.getFlightDate()+"\",");
      
         sb.append("\"FlightStatus\":\"");
         sb.append(flight.getFlightStatus()+"\",");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        
        sb.append("}");
        
        String jsonObject = sb.toString();     
                    
        return jsonObject;
        
        }
    
}
