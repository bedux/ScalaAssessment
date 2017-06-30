package models

import scala.io.Source

//Define the current context, in this example is csv
object CurrentDB{


  implicit val context: Context = ContextCSV.context
}

trait Context{
  val Airports:List[Airport]
  val Countries:List[Country]
  val Runways:List[Runway]

}

object ContextCSV{
  val fileAirport = "./app/data/airports.csv"
  val fileCountries = "./app/data/countries.csv"
  val fileRunway = "./app/data/runways.csv"
  val context =  ContextCSV(fileAirport,fileCountries,fileRunway)
}

//CSV context
case class ContextCSV(fileAirport:String,fileCountries:String,fileRunway:String) extends  Context{



  lazy val Airports:List[Airport] = {
    val lines = Source.fromFile(fileAirport).getLines.drop(1).toList
    for{
      line <- lines
    }yield new AirportCSV(line,this)
  }

  lazy val Countries:List[Country] = {
    val lines = Source.fromFile(fileCountries).getLines.drop(1).toList
    for{
      line <- lines
    }yield new CountryCSV(line,this)
  }

  lazy val Runways:List[Runway] = {
    val lines = Source.fromFile(fileRunway).getLines.drop(1).toList
    for{
      line <- lines
    }yield new RunwayCSV(line)
  }

  //Build index for a faster access
  lazy val AirportIndexByISO:Map[String,List[Airport]] = Airports.groupBy(x=>x.iso_country)
  lazy val RunwayIndexByAirportRef:Map[Int,List[Runway]] = Runways.groupBy(x=>x.airport_ref)
}
