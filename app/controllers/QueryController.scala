package controllers

import javax.inject._
import logic.Query
import models.{Airport, Runway, TextForm}
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import models.CurrentDB._


@Singleton
class QueryController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.query(TextForm.form,routes.QueryController.submitQuery()))
  }

  def submitQuery = Action { implicit request: Request[AnyContent] =>
    val c = TextForm.form.bindFromRequest()
    c.fold(_ => BadRequest("Errors"),(s)=>{
      val p1:List[(Airport,List[Runway])] = Query.getAirportsAndRunwayIn(s.text)
      Ok(views.html.queryResult(p1))
    })
  }
}
