package logic

import models.{Airport, Context, Country, Runway}
import org.scalatestplus.play.PlaySpec

/**
  * Created by bedux on 29.06.17.
  */

case class RunwayTest(id:Int,airport_ref:Int,le_ident: String,surface: String) extends Runway{
  override val airport_ident: String = ""
  override val width_ft: Option[Int] = None
  override val length_ft: Option[Int] = None
}
case class CountryTest(id: Int,airports: List[Airport],code: String) extends Country {
  override val wikipedia_link: String = ""
  override val continent: String = ""
  override val name: String = ""
  override val keywords: String = ""
}
case class AirportTest(id: Int,runways: List[Runway],ident: String,iso_country: String )extends Airport{
  override val name: String = ""
  override val atype: String = ""
}


class RepoTest extends PlaySpec {
      implicit val contextTest:Context = new Context {
        val r1 = RunwayTest(3,2,"B12","GRASS")
        val a1 = AirportTest(2,List(r1),"UTC","IT")
        val c1 = CountryTest(1,List(a1),"IT")

        override val Runways: List[Runway] = List(r1)
        override val Countries: List[Country] = List(c1)
        override val Airports: List[Airport] = List(a1)
      }

  "Report TopCommonRunway" must {
    "Contains" in {
      Report.TopCommonRunway(1).contains("B12") mustBe true
    }
  }
}
