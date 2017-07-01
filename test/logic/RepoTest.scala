package logic

import models.{Airport, Context, Country, Runway}
import org.scalatestplus.play.PlaySpec

/**
  * Created by bedux on 29.06.17.
  */

class SimpleRepoTest extends PlaySpec {
  import TestContext.simpleContext
  "Report TopCommonRunway" must {
    "Contains" in {
      Report.TopCommonRunway(1).contains("B12") mustBe true
    }
  }
}


class ComplexRepoTest  extends PlaySpec {
  import TestContext.complexContext
  "Country with highest number of airport " must {
     "Be" in {
       val res  = Report.getNCountriesAirport(1)._1
       println(res)
       res.length mustBe 1
       res.head._1.code mustBe "IT"
       res.head._2 mustBe 2
     }
  }
  "Country with lowest number of airport " must {
    "Be" in {
      val res = Report.getNCountriesAirport(1)._2
      println(res)
      res.length mustBe 1
      res.head._1.code mustBe "SP"
      res.head._2 mustBe 1
    }
  }
  "Type of runways (as indicated in \"surface\" column) per country" must {
      "Be" in {
        val res = Report.GetTypeOfRunways()

        println(res)
        res.length mustBe 2
        val IT = res.filter( a => a._1.code == "IT").head
        IT._2.length mustBe 2
        IT._2.contains("GRASS") mustBe true
        IT._2.contains("WOOD") mustBe true


        val SP = res.filter( a => a._1.code == "SP").head
        SP._2.length mustBe 1
        SP._2.contains("GRASS") mustBe true
      }
    }

  "Print the top 10 most common runway identifications (indicated in \"le_ident\" column)"

}