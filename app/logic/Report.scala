package logic

import models._

/**
  * Created by bedux on 29.06.17.
  */
object Report {

  // N countries with highest number of airports (with count) and countries with lowest number of airports.
  // return will be (highest,lowest)
  def getNCountriesAirport(n:Int)(implicit context:Context):(List[(Country,Int)],List[(Country,Int)]) ={
    val airportsForACountry = context.Countries.sortBy{_.airports.length}
    (airportsForACountry.reverse.take(n).map(x=>(x,x.airports.length)),airportsForACountry.take(n).map(x=>(x,x.airports.length)))
  }


  def GetTypeOfRunways()(implicit context:Context):List[(Country,List[String])] ={
    context.Countries.map(x=>(x,x.airports.flatMap(_.runways).map(_.surface.toUpperCase).distinct)).filter(_._2.nonEmpty)
  }


  def TopCommonRunway(n:Int)(implicit context:Context):List[String] ={
    context.Airports.flatMap(_.runways)
            .groupBy(_.le_ident)
            .toList
            .sortBy(_._2.length)
            .reverse.take(n)
            .map(_._2.head.le_ident)
  }


}
