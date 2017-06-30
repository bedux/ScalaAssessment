package models
import logic.ParserTools

import scalaz._
import Scalaz._


trait  Runway{
    val id : Int
    val airport_ref : Int
    val airport_ident : String
    val length_ft:Option[Int]
    val width_ft:Option[Int]
    val surface:String
    val le_ident : String
    override def toString: String ={
            s"($id,$airport_ident)"
    }
}


class RunwayCSV(csvLine:String) extends Runway{
    val fields = csvLine.split(',')

    val id : Int = ParserTools.GetRequire(fields(0).parseInt)
    val airport_ref : Int = ParserTools.GetRequire(fields(1).parseInt)
    val airport_ident : String = ParserTools.GetRequire(fields(2))
    val length_ft:Option[Int] = fields(3).parseInt.toOption
    val width_ft:Option[Int] = fields(4).parseInt.toOption
    val surface : String = fields(5).replaceAll("\"","")
    val le_ident : String =  if(fields.length >8) fields(8).replaceAll("\"","") else ""
 }

