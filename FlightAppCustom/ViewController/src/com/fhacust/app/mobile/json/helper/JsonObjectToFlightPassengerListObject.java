package com.fhacust.app.mobile.json.helper;

import com.fhacust.app.mobile.entities.FlightPassengerListEntity;

import java.util.logging.Level;

import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class JsonObjectToFlightPassengerListObject {
    public JsonObjectToFlightPassengerListObject() {
        super();
    }


    public static FlightPassengerListEntity getPassengersArray(String jsonObjectAsString) {

        Trace.log(Utility.ApplicationLogger, Level.SEVERE, JsonObjectToFlightPassengerListObject.class, "getPassengersArray", "1");

        FlightPassengerListEntity passengersResult = null;

        //object that serializes the JSON payload into the Java object
        JSONBeanSerializationHelper jbsh = new JSONBeanSerializationHelper();


        try {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, JsonObjectToFlightPassengerListObject.class, "getPassengersArray", "2");

            passengersResult =
                (FlightPassengerListEntity) jbsh.fromJSON(FlightPassengerListEntity.class,
                                                                jsonObjectAsString);
            System.out.println("MyBean class object received after deserializing is: " + passengersResult.toString());

        } catch (Exception e) {
            Trace.log("JSONArray_to_JavaArray", Level.SEVERE, JsonObjectToFlightPassengerListObject.class, "getEmployeesArray",
                      "Parsing of REST response failed: " + e.getLocalizedMessage());
        }

        Trace.log(Utility.ApplicationLogger, Level.SEVERE, JsonObjectToFlightPassengerListObject.class, "getPassengersArray", passengersResult.getTotalNumberOfPassengers());
        return passengersResult;
    }

}
