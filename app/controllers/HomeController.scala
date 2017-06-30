package controllers

import javax.inject._

import play.api.mvc._
import play.api.libs.json._
import logic.{Query, Report}
import converter.JsonConverter._
import models.ReportResult
import models.CurrentDB._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {


  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def query() = Action { implicit request: Request[AnyContent] =>
    val querys:String = ""
    val p1 = Query.getAirportsAndRunwayIn(querys.toLowerCase)
    Ok(Json.toJson(p1))
  }


  def repo() = Action { implicit request: Request[AnyContent] =>
    println("Start")

    val nAirport = Report.getNCountriesAirport(10)
    val runwayXCountry = Report.GetTypeOfRunways()
    val comonRunway = Report.TopCommonRunway(10)
    val res = ReportResult(nAirport._1,nAirport._2,runwayXCountry,comonRunway)
   Ok(Json.toJson(res))
  }
}




