<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java"
                xmlns:tns="com.fliyinghigh/operations/flightservice/nxsd"
                xmlns:DVMFunctions="http://www.oracle.com/XSL/Transform/java/com.bea.wli.sb.functions.dvm.DVMFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:BasicCredentialsUserFunction="http://www.oracle.com/XSL/Transform/java/com.bea.wli.sb.stages.functions.BasicCredentialsUserFunction"
                xmlns:UUIDUserFunction="http://www.oracle.com/XSL/Transform/java/com.bea.wli.sb.stages.functions.UUIDUserFunction"
                xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:IsUserInRoleFunction="http://www.oracle.com/XSL/Transform/java/com.bea.wli.sb.stages.functions.IsUserInRoleFunction"
                xmlns:ns0="com.flyinghigh/operations/flightservice"
                xmlns:IsUserInGroupFunction="http://www.oracle.com/XSL/Transform/java/com.bea.wli.sb.stages.functions.IsUserInGroupFunction"
                xmlns:XrefFunctions="http://www.oracle.com/XSL/Transform/java/com.bea.wli.sb.functions.xref.XrefFunctions"
                exclude-result-prefixes="xsd xsi oracle-xsl-mapper xsl ns0 tns oraxsl DVMFunctions BasicCredentialsUserFunction UUIDUserFunction IsUserInRoleFunction IsUserInGroupFunction XrefFunctions"
                xmlns:com="com.flyinghigh/operations/common" xmlns:plnk="http://docs.oasis-open.org/wsbpel/2.0/plnktype"
                xmlns:ns1="http://xmlns.oracle.com/FlyingHighAirlineProxyServices/FlightService/FlightService"
                xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:inp1="http://TargetNamespace.com/FlightService_retrieveFlightDetails_response">
  <oracle-xsl-mapper:schema>
    <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
    <oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:source type="XSD">
        <oracle-xsl-mapper:schema location="../XMLSchema_417271354.xsd"/>
        <oracle-xsl-mapper:rootElement name="retrievePassengerListForFlightResponse"
                                       namespace="com.flyinghigh/operations/flightservice"/>
      </oracle-xsl-mapper:source>
    </oracle-xsl-mapper:mapSources>
    <oracle-xsl-mapper:mapTargets>
      <oracle-xsl-mapper:target type="WSDL">
        <oracle-xsl-mapper:schema location="../Resources/FlightRestService.wsdl"/>
        <oracle-xsl-mapper:rootElement name="PassengerListForFlight"
                                       namespace="com.fliyinghigh/operations/flightservice/nxsd"/>
      </oracle-xsl-mapper:target>
    </oracle-xsl-mapper:mapTargets>
    <!--GENERATED BY ORACLE XSL MAPPER 12.1.3.0.0(XSLT Build 140529.0700.0211) AT [SAT FEB 28 08:46:49 CET 2015].-->
  </oracle-xsl-mapper:schema>
  <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
  <xsl:template match="/">
    <tns:PassengerListForFlight>
      <tns:FlightCode>
        <tns:CarrierCode>
          <xsl:value-of select="/ns0:retrievePassengerListForFlightResponse/ns0:FlightCode/com:CarrierCode"/>
        </tns:CarrierCode>
        <tns:FlightNumber>
          <xsl:value-of select="/ns0:retrievePassengerListForFlightResponse/ns0:FlightCode/com:FlightNumber"/>
        </tns:FlightNumber>
      </tns:FlightCode>
      <tns:FlightDate>
        <xsl:value-of select="/ns0:retrievePassengerListForFlightResponse/ns0:FlightDate"/>
      </tns:FlightDate>
      <tns:PassengerList>
        <tns:TotalNumberOfPassengers>
          <xsl:value-of select="/ns0:retrievePassengerListForFlightResponse/ns0:PassengerList/com:TotalNumberOfPassengers"/>
        </tns:TotalNumberOfPassengers>
        <xsl:for-each select="/ns0:retrievePassengerListForFlightResponse/ns0:PassengerList/com:Passengers/com:Passenger">
          <tns:Passengers>
            <tns:FirstName>
              <xsl:value-of select="com:FirstName"/>
            </tns:FirstName>
            <tns:LastName>
              <xsl:value-of select="com:LastName"/>
            </tns:LastName>
            <tns:Country>
              <xsl:value-of select="com:Country"/>
            </tns:Country>
            <tns:FrequentFlyerNumber>
              <xsl:value-of select="com:FrequentFlyerNumber"/>
            </tns:FrequentFlyerNumber>
            <tns:Seat>
              <xsl:value-of select="com:Seat"/>
            </tns:Seat>
          </tns:Passengers>
        </xsl:for-each>
      </tns:PassengerList>
    </tns:PassengerListForFlight>
  </xsl:template>
</xsl:stylesheet>