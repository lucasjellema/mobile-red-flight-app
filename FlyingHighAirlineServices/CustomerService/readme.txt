The REST ful service is described by the WADL at:

http://soa2admin2.example.com:8001/soa-infra/resources/default/CustomerService!1.0/CustomerCareService/application.wadl

The service endpoint is 
http://soa2admin2.example.com:8001/soa-infra/resources/default/CustomerService!1.0/CustomerCareService/complaints

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