
Example of request url (GET) to get flight details:

http://10.10.10.21:8011/FlightService/FlightService/flights/KL34?flightDate=2015-03-07


the response JSON payload:

{
"FlightCode" : {
"CarrierCode" : "KL",
"FlightNumber" : 34
},
"FlightStatus" : "SCH",
"FlightDate" : "2015-03-07T+01:00",
"Departure" : {
"Time" : "2015-03-07T09:50:00+01:00",
"AirportCode" : null,
"AirportName" : "Schiphol Airport",
"City" : "Amsterdam",
"Country" : "NL"
},
"Destination" : {
"Time" : "2015-03-07T11:55:00-08:00",
"AirportCode" : null,
"AirportName" : "San Francisco International Airport",
"City" : "San Francisco",
"Country" : "US"
}
}
