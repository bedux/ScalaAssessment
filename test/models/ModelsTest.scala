package models

import org.scalatestplus.play.PlaySpec

/**
  * Created by bedux on 29.06.17.
  */
class ModelsTest extends PlaySpec {

  object TestContext extends ContextCSV("","",""){
    override lazy val Airports: List[Airport] = List()
    override lazy val Countries: List[Country] = List()
    override lazy val Runways: List[Runway] = List()
    override lazy val AirportIndexByISO: Map[String, List[Airport]] = Map()
    override lazy val RunwayIndexByAirportRef: Map[Int, List[Runway]] = Map()
  }
     "AirportCSV" must {
        "be evaluated in" in {
              val cvsStr = "6539,\"00IL\",\"small_airport\",\"Hammer Airport\",41.97840118408203,-89.5604019165039,840,\"NA\",\"US\",\"US-IL\",\"Polo\",\"no\",\"00IL\",,\"00IL\",,,"
              val result = new AirportCSV(cvsStr,TestContext)
              result.id mustBe 6539
              result.ident mustBe "00IL"
              result.atype mustBe "small_airport"
              result.name mustBe "Hammer Airport"
              result.iso_country mustBe "US"
        }
      }

      "RunwayCSV" must {
        "be evaluated in" in {
          val cvsStr = "254165,6525,\"00AL\",2300,200,\"TURF\",0,0,\"01\",,,,,,\"19\",,,,,"
          val result = new RunwayCSV(cvsStr)
          result.id mustBe 254165
          result.airport_ident mustBe "00AL"
          result.surface mustBe "TURF"
          result.length_ft mustBe  Some(2300)
        }
       }

      "CountryCSV" must {
        "be evaluated in" in {
          val cvsStr = "302741,\"JM\",\"Jamaica\",\"NA\",\"http://en.wikipedia.org/wiki/Jamaica\","
          val result = new CountryCSV(cvsStr,TestContext)
          result.id mustBe 302741
          result.code mustBe "JM"
          result.name mustBe "Jamaica"
        }
      }


}
