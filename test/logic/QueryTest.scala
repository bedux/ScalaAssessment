package logic

import org.scalatestplus.play.PlaySpec

/**
  * Created by bedux on 01.07.17.
  */
class QueryTest  extends PlaySpec {

  import TestContext.simpleContext

  "getAirportsAndRunwayIn" must {
    "Have" in {
      val result = Query.getAirportsAndRunwayIn("it")
      result.head._1.id mustBe 2
      result.head._2.head.id mustBe 3

      val result1 = Query.getAirportsAndRunwayIn("It")
      result1.head._1.id mustBe 2
      result1.head._2.head.id mustBe 3
    }
  }
  "getAirportsAndRunwayIn partial search" must {
    "Have" in {
      val result = Query.getAirportsAndRunwayIn("i")
      result.head._1.id mustBe 2
      result.head._2.head.id mustBe 3
    }
  }
  "getAirportsAndRunwayIn partial search by name" must {
    "Have" in {
      val result = Query.getAirportsAndRunwayIn("ita")
      result.head._1.id mustBe 2
      result.head._2.head.id mustBe 3
    }
  }
  "getAirportsAndRunwayIn None" must {
    "Have" in {
      val result = Query.getAirportsAndRunwayIn("s")
      result.isEmpty mustBe true
    }
  }
}
