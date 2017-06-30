package logic
import models._

/**
  * Created by bedux on 29.06.17.
  */
object Query {
  def getAirportsAndRunwayIn(query:String)(implicit context:Context):List[(Airport,List[Runway])] = {
    context.Countries
      .filter(x=>x.code.toLowerCase.indexOf(query)==0 || x.name.toLowerCase.indexOf(query)==0)
      //get all airport
      .flatMap(_.airports)
      //get all runways for each airport
      .map(x=> (x,x.runways))
  }
}
