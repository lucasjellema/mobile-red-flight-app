
Example of request url (GET) to get flight details:

http://10.10.10.21:8011/FlightService/FlightService/flights/KL34?flightDate=2015-03-07


the response JSON payload:

{
"FlightCode" : {
"CarrierCode" : "KL",
"FlightNumber" : 34
},
"FlightStatus" : "scheduled",
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

how to retrieve the passengerlist:

http://10.10.10.21:8011/FlightService/FlightService/flights/KL34/passengerlist?flightDate=2015-03-07

response:

{
  "FlightCode" : {
    "CarrierCode" : "KL",
    "FlightNumber" : 34
  },
  "FlightDate" : "2015-03-07T09:50:00.000+01:00",
  "PassengerList" : {
    "TotalNumberOfPassengers" : 22,
    "Passengers" : [ {
      "FirstName" : "Diana",
      "LastName" : "Woodstock",
      "Country" : "UK",
      "FrequentFlyerNumber" : "BB123332",
      "Seat" : "23A"
    }, {
      "FirstName" : "William",
      "LastName" : "Simon",
      "Country" : "US",
      "FrequentFlyerNumber" : "KK9182673",
      "Seat" : "24A"
    }, {
      "FirstName" : "Hank",
      "LastName" : "Garfunkel",
      "Country" : "NL",
      "FrequentFlyerNumber" : "Q12371234",
      "Seat" : "25A"
    }, {
      "FirstName" : "Francois",
      "LastName" : "Mercury",
      "Country" : "DE",
      "FrequentFlyerNumber" : "P918236734",
      "Seat" : "26A"
    }, {
      "FirstName" : "Heinrich",
      "LastName" : "Böll",
      "Country" : "FR",
      "FrequentFlyerNumber" : "T61625326",
      "Seat" : "27A"
    }, {
      "FirstName" : "Jean",
      "LastName" : "Malot",
      "Country" : "FR",
      "FrequentFlyerNumber" : "Q5162716231",
      "Seat" : "28A"
    }, {
      "FirstName" : "Norman",
      "LastName" : "Mailer",
      "Country" : "ES",
      "FrequentFlyerNumber" : null,
      "Seat" : "29A"
    }, {
      "FirstName" : "Ann",
      "LastName" : "Sjöbrend",
      "Country" : "UK",
      "FrequentFlyerNumber" : null,
      "Seat" : "30A"
    }, {
      "FirstName" : "Carlo",
      "LastName" : "DuPont",
      "Country" : "DE",
      "FrequentFlyerNumber" : null,
      "Seat" : "44A"
    } ]
  }
}


and how to update the flight status:

PUT JSON payload to http://10.10.10.21:8011/FlightService/FlightService/flights

{
"FlightCode" :  "KL34",
"FlightDate" : "2015-03-07T+01:00",
"FlightStatus" : "boarding"
}

response:
{
"FlightStatus" : "boarding"
}
