create table fli_airports
( id number(5) not null primary key
, name varchar2(100)
, country_code varchar2(2) not null
, iata_code varchar2(3) not null
, city varchar2(50) not null
);

create table fli_airline_carriers
( id number(5) not null primary key
, iata_code varchar2(2) not null
, name varchar2(100) not null
);

create table fli_flights 
(id number(5) not null primary key
, flight_number number(4,0) not null
, carrier_id number(5)
, origin_airport_id number(5) 
, destination_airport_id number(5)
, departure_time timestamp with time zone
, arrival_time timestamp with time zone
, flight_status varchar2(3)
);

create table fli_customers
(id number(5) not null primary key
, first_name varchar2(30)
, last_name varchar2(50)
, frequent_flyer_number varchar2(20)
, country_code varchar2(2)
);

create table fli_passengers
(id number(5) not null primary key
, flight_id number(5)
, seat varchar2(3)
, customer_id number(5)
, passenger_status varchar2(3)
);




create user as DBA 

create user fli identified by fli default tablespace users temporary tablespace temp; 
alter user fli quota unlimited on  users ; 
grant connect, create table, create procedure, create sequence, create type to fli;



select car.iata_code airline_code
,      fli.FLIGHT_NUMBER
,      car.iata_code||fli.FLIGHT_NUMBER flight_code
,      car.name airline_name
,      ori.NAME departure
,      ori.COUNTRY_CODE departure_country
,      ori.CITY departure_city
,      dst.NAME destination
,      dst.CITY destination_city
,      dst.COUNTRY_CODE destination_country
,      fli.arrival_time - fli.departure_time flying_time
,      fli.departure_time
,      fli.ARRIVAL_TIME
,      fli.FLIGHT_STATUS
from   fli_flights fli
       join
       fli_airports ori
       on (fli.origin_airport_id = ori.id)
       join 
       fli_airports dst
       on (fli.destination_airport_id = dst.id)
       join
       fli_airline_carriers car
       on (fli.carrier_id = car.id)

create or replace 
type flight_t force as object 
( airline_code varchar2(2)
, flight_number number(4,0)
, flight_code varchar2(6)
, airline_name varchar2(100)
, departure_airport varchar2(100)
, departure_city varchar2(100)
, departure_country varchar2(2)
, destination_airport varchar2(100)
, destination_city varchar2(100)
, destination_country varchar2(2)
, departure_time timestamp with time zone
, arrival_time timestamp with time zone
, flight_time  interval day (1) to second (0)
, flight_status varchar2(3)
);

create or replace 
type passenger_t force as object 
( seat varchar2(3)
, status varchar2(3) 
, first_name varchar2(30)
, last_name varchar2(50)
, frequent_flyer_number varchar2(20)
, country_code varchar2(2)
);

create or replace 
type passenger_tbl_t force as 
table of passenger_t;

create or replace 
type passenger_list_t force as object 
( airline_code varchar2(2)
, flight_number number(4,0)
, flight_code varchar2(6)
, departure_time timestamp with time zone
, passengers passenger_tbl_t
);




create or replace 
package flight_service
as
function retrieve_flight_details
( p_flight_number in number
, p_airline_code in varchar2
, p_departure_date in date
) return flight_t
;


end flight_service;
/







create or replace 
package body flight_service
as
function retrieve_flight_details
( p_flight_number in number
, p_airline_code in varchar2
, p_departure_date in date
) return flight_t
is
  l_flight flight_t;
begin
select flight_t(
car.iata_code 
,      fli.FLIGHT_NUMBER
,      car.iata_code||fli.FLIGHT_NUMBER 
,      car.name 
,      ori.NAME 
,     ori.CITY 
,      ori.COUNTRY_CODE 
,      dst.NAME 
,      dst.CITY 
,      dst.COUNTRY_CODE 
,      fli.departure_time
,      fli.ARRIVAL_TIME
,      fli.arrival_time - fli.departure_time 
,      fli.FLIGHT_STATUS
)
into   l_flight
from   fli_flights fli
       join
       fli_airports ori
       on (fli.origin_airport_id = ori.id)
       join 
       fli_airports dst
       on (fli.destination_airport_id = dst.id)
       join
       fli_airline_carriers car
       on (fli.carrier_id = car.id)
where  fli.FLIGHT_NUMBER = p_flight_number
and    car.IATA_CODE = p_airline_code
and    trunc(CAST(fli.DEPARTURE_TIME  AS DATE)) =  trunc(nvl(p_departure_date, sysdate))
;
  return l_flight;
end retrieve_flight_details;



end flight_service;
/


Insert into FLI.FLI_FLIGHTS (ID,FLIGHT_NUMBER,CARRIER_ID,ORIGIN_AIRPORT_ID,DESTINATION_AIRPORT_ID,DEPARTURE_TIME,ARRIVAL_TIME,FLIGHT_STATUS) values (1,617,1,4,2,to_timestamp_tz('06-MAR-15 05.10.00.000000000 PM EUROPE/BUDAPEST','DD-MON-RR HH.MI.SSXFF AM TZR'),to_timestamp_tz('06-MAR-15 08.25.00.000000000 PM US/PACIFIC','DD-MON-RR HH.MI.SSXFF AM TZR'),'SCH');
Insert into FLI.FLI_FLIGHTS (ID,FLIGHT_NUMBER,CARRIER_ID,ORIGIN_AIRPORT_ID,DESTINATION_AIRPORT_ID,DEPARTURE_TIME,ARRIVAL_TIME,FLIGHT_STATUS) values (2,34,2,3,1,to_timestamp_tz('07-MAR-15 09.50.00.000000000 AM EUROPE/BERLIN','DD-MON-RR HH.MI.SSXFF AM TZR'),to_timestamp_tz('07-MAR-15 02.55.00.000000000 AM US/PACIFIC','DD-MON-RR HH.MI.SSXFF AM TZR'),'SCH');


insert into fli_passengers
(id, flight_id, seat, customer_id, passenger_status)
select fli.id *100 + cus.id
, fli.id
,     rownum||'A'
, cus.id
, 'BKD'
from  fli_flights fli
       cross join 
       fli_customers cus
       
       

select cus.first_name||' '||cus.last_name name
,      pas.seat
from   fli_passengers pas
       join
       fli_customers cus
       on (pas.customer_id = cus.id)
where  pas.flight_id = 1


select flight_service.retrieve_flight_details
( p_flight_number => 34, p_airline_code=> 'KL', p_departure_date => to_date('07-03-2015','DD-MM-YYYY') 
)
from dual
