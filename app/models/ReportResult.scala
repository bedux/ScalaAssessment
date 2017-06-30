package models

/**
  * Created by bedux on 29.06.17.
  */
case class ReportResult(hAirport:List[(Country,Int)],lAirport:List[(Country,Int)],runwaysCountry: List[(Country,List[String])],commonRunway:List[String]);
