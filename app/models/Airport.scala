package models

import logic.ParserTools

import scalaz._
import Scalaz._

trait Airport{
  val id : Int
  val ident : String
  val atype : String
  val name:String
  val iso_country:String
  val runways:List[Runway]

  override def toString: String ={
    s"($ident,$name,$iso_country)"
  }
}



 class AirportCSV(csvLine:String,context:ContextCSV) extends  Airport{
  val fields = csvLine.split(',')

  val id : Int = ParserTools.GetRequire(fields(0).parseInt)
  val ident : String = ParserTools.GetRequire(fields(1))
  val atype : String = ParserTools.GetRequire(fields(2))
  val name:String = ParserTools.GetRequire(fields(3))
  val iso_country:String =  ParserTools.GetRequire(fields(8))
   lazy val runways: List[Runway] =  context.RunwayIndexByAirportRef.getOrElse(id,List())
 }


