package controllers

import javax.inject._

import logic.{Query, Report}
import play.api.mvc._
import play.api.libs.json._
import models.{Airport, ReportResult, Runway, TextForm}
import play.api.data.{Field, Form}
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import models.CurrentDB._
/**
  * Created by bedux on 30.06.17.
  */
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
