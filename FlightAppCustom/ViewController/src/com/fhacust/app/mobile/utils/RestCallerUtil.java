package com.fhacust.app.mobile.utils;

import java.util.logging.Level;

import oracle.adfmf.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class RestCallerUtil {
    
    public RestCallerUtil() {
        super();
    }
    
    //GET
    public String invokeREAD(String requestURI){
        return this.invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_GET, requestURI, "");
    }
    
    //POST
    public String invokeUPDATE(String requestURI, String payload){
        
        return this.invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_POST, requestURI, payload);
    }
     

    public String invokeUPDATEcust(String requestURI, String payload){
        
        return this.invokeRestRequestCust(RestServiceAdapter.REQUEST_TYPE_POST, requestURI, payload);
    }


    /**
     * Method that handles the boilerplate code for obtaining and configuring a service 
     * adapter instance. 
     * 
     * @param httpMethod GET, POST, PUT, DELETE
     * @param requestURI the URI to appends to the base REST URL. URIs are expected to start with "/"
     * @return
     */
    private String invokeRestRequest(String httpMethod, String requestURI, String payload){
    
        String restPayload = "";
        
        RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        //set URL connection defined for this sample. 
        restServiceAdapter.setConnectionName("FlightsREST");
        
        //set GET, POST, DELETE, PUT
        restServiceAdapter.setRequestType(httpMethod);
        
        //this sample uses JSON only. Thus the media type can be hard-coded in this class
        //the content-type tells the server what format the incoming payload has
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        //the accept header indicates the expected payload fromat to the server
        restServiceAdapter.addRequestProperty("Accept", "application/json; charset=UTF-8");
        restServiceAdapter.setRequestURI(requestURI);        
        restServiceAdapter.setRetryLimit(0);    
     
        Trace.log(Utility.ApplicationLogger,Level.INFO, this.getClass(),"invokeRestRequest", requestURI);
        
        //variable holding the response
        String response = "";
        
        //set payload if there is payload passed with the request
        if(payload != null){   
             //send with empty payload
             restPayload  = payload;
        }

        try {
            response = (String) restServiceAdapter.send(restPayload);
        } catch (Exception e) {
            //log error
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", e.getLocalizedMessage());
        }
        Trace.log(Utility.ApplicationLogger,Level.INFO, this.getClass(),"response= ", response);
        
        return response;
    }


    /**
     * Method that handles the boilerplate code for obtaining and configuring a service 
     * adapter instance. 
     * 
     * @param httpMethod GET, POST, PUT, DELETE
     * @param requestURI the URI to appends to the base REST URL. URIs are expected to start with "/"
     * @return
     */
    private String invokeRestRequestCust(String httpMethod, String requestURI, String payload){
    
        String restPayload = "";
        
        RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        //set URL connection defined for this sample. In this sample, the "hrresrconn" connection resolves 
        //to http://127.0.0.1:7101/hrrest/resources/hrappsrvc . The connection has been created for this 
        //sample choosing File | New | From Gallery | General | Connections | URL connection from the JDeveloper menu
        restServiceAdapter.setConnectionName("CustomerREST");
        
        //set GET, POST, DELETE, PUT
        restServiceAdapter.setRequestType(httpMethod);
        
        //this sample uses JSON only. Thus the media type can be hard-coded in this class
        //the content-type tells the server what format the incoming payload has
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        //the accept header indicates the expected payload fromat to the server
        restServiceAdapter.addRequestProperty("Accept", "application/json; charset=UTF-8");
        restServiceAdapter.setRequestURI(requestURI);        
        restServiceAdapter.setRetryLimit(0);    
     
        Trace.log(Utility.ApplicationLogger,Level.SEVERE, this.getClass(),"invokeRestRequest", requestURI);
        
        //variable holding the response
        String response = "";
        
        //set payload if there is payload passed with the request
        if(payload != null){   
             //send with empty payload
             restPayload  = payload;
        }

        Trace.log(Utility.ApplicationLogger,Level.SEVERE, this.getClass(),"invokeRestRequest", restPayload);

        try {
            response = (String) restServiceAdapter.send(restPayload);
        } catch (Exception e) {
            //log error
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequestCust", "Invoke of REST Resource failed for "+httpMethod+" to "+requestURI);
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequestCust", e.getLocalizedMessage());
        }
        Trace.log(Utility.ApplicationLogger,Level.SEVERE, this.getClass(),"response= ", response);
        
        return response;
    
    }

}

