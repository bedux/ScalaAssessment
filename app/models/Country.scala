package models

import logic.ParserTools

import scalaz._
import Scalaz._

trait Country{
  val id : Int
  val code : String
  val name : String
  val continent:String
  val wikipedia_link:String
  val keywords:String
   val airports:List[Airport]
  override def toString: String ={
    s"($name)"
  }
}

 class CountryCSV(csvLine:String,context:ContextCSV) extends  Country{
  val fields = csvLine.split(',')

  val id : Int = ParserTools.GetRequire(fields(0).parseInt)
  val code : String = ParserTools.GetRequire(fields(1))
  val name : String = ParserTools.GetRequire(fields(2))
  val continent:String = ParserTools.GetRequire(fields(3))
  val wikipedia_link:String = fields(4).replaceAll("\"","")
  val keywords:String = if(fields.length == 6) fields(5).replaceAll("\"","") else ""
  lazy val airports: List[Airport] =  context.AirportIndexByISO.getOrElse(code,List())
 }