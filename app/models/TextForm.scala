package models
import play.api.data.Forms._
import play.api.data.Form
/**
  * Created by bedux on 30.06.17.
  */

object TextForm {

  case class Text(text: String) {
  }
  val form = Form(
    mapping(
      "text" -> text
    )(Text.apply)(Text.unapply)
  )
}
