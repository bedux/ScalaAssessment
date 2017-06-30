package controllers

import javax.inject._

import logic.Query
import play.api.mvc._
import play.api.libs.json._
import models.{Airport, Runway, TextForm}
import play.api.data.{Field, Form}
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import models.CurrentDB._

/**
  * Created by bedux on 30.06.17.
  */
@Singleton
class QueryController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  def index() = Action { implicit request: Request[AnyContent] =>

    Ok(views.html.query(TextForm.form,routes.QueryController.submitQuery()))
  }

  def submitQuery = Action { implicit request: Request[AnyContent] =>

    val c = TextForm.form.bindFromRequest()
    println(c)
    c.fold(_ => BadRequest("Errors"),(s)=>{
      val p1:List[(Airport,List[Runway])] = Query.getAirportsAndRunwayIn(s.text.toLowerCase)
      Ok(views.html.queryResult(p1))
    })


  }
}
