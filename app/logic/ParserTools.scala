package logic

import scalaz.Validation

/**
  * Created by bedux on 29.06.17.
  */
object ParserTools {

  def GetRequire[A](conv:Validation[Exception,A]):A ={
      conv.toEither match{
      case Right(x) => x
      case Left(x) => throw  x
    }
  }
  def GetRequire(conv:String):String = {
    if(conv.isEmpty){
      throw  new Exception("Value Required")
    }else{
      conv.replaceAll("\"","")
    }
  }

}
