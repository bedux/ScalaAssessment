package logic
import models._


object Query {
  def getAirportsAndRunwayIn(query:String)(implicit context:Context):List[(Airport,List[Runway])] = {
    val queryLower = query.toLowerCase
    context.Countries
      .filter(x=>x.code.toLowerCase.indexOf(queryLower) == 0 || x.name.toLowerCase.indexOf(queryLower) == 0)
      //get all airport
      .flatMap(_.airports)
      //get all runways for each airport
      .map(x=> (x,x.runways))
      .sortBy(_._2.length)
      .reverse

  }
}
