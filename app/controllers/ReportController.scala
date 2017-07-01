package controllers

import javax.inject._
import logic.Report
import models.ReportResult
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import models.CurrentDB._


@Singleton
class ReportController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    val nAirport = Report.getNCountriesAirport(10)
    val runwayXCountry = Report.GetTypeOfRunways()
    val comonRunway = Report.TopCommonRunway(10)
    val res = ReportResult(nAirport._1,nAirport._2,runwayXCountry,comonRunway)
    Ok(views.html.report(res))
  }
}
