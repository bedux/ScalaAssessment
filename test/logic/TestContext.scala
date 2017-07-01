package logic

import models._

case class RunwayTest(id:Int,airport_ref:Int,le_ident: String,surface: String) extends Runway{
  override val airport_ident: String = ""
  override val width_ft: Option[Int] = None
  override val length_ft: Option[Int] = None
}
case class CountryTest(id: Int,airports: List[Airport],code: String,name: String = "") extends Country {
  override val wikipedia_link: String = ""
  override val continent: String = ""
  override val keywords: String = ""
}
case class AirportTest(id: Int,runways: List[Runway],ident: String,iso_country: String )extends Airport{
  override val name: String = ""
  override val atype: String = ""
}

/**
  * Created by bedux on 01.07.17.
  */
object TestContext {

  implicit val simpleContext:Context = new Context {
    val r1 = RunwayTest(3,2,"B12","GRASS")
    val a1 = AirportTest(2,List(r1),"UTC","IT")
    val c1 = CountryTest(1,List(a1),"IT","Italy")


    override val Runways: List[Runway] = List(r1)
    override val Countries: List[Country] = List(c1)
    override val Airports: List[Airport] = List(a1)
  }

  implicit val complexContext:Context = new Context {
    val r1 = RunwayTest(3,2,"B12","GRASS")
    val r2 = RunwayTest(5,2,"B13","grAss")
    val r3 = RunwayTest(6,2,"B11","Grass")
    val r4 = RunwayTest(7,2,"B12","wood")

    val a1 = AirportTest(1,List(r1,r2),"UTC","IT")
    val a2 = AirportTest(2,List(r3,r4),"ULT","IT")
    val a3 = AirportTest(3,List(r1,r3),"CC","SP")


    val c1 = CountryTest(1,List(a1,a2),"IT","Italy")
    val c2 = CountryTest(2,List(a3),"SP","Spain")



    override val Runways: List[Runway] = List(r1,r2,r3,r4)
    override val Countries: List[Country] = List(c1,c2)
    override val Airports: List[Airport] = List(a1,a2,a3)
  }


}
