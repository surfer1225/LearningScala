package Test

/**
  * Created by Ryan on 19/5/18.
  */
object DataHelper extends App{
  /**
    * need to specify the contract that '=' or ';' cannot be part of the key or value
    * otherwise, we can transform it to some other character first
    * and the transform back
    *
    * the above processes are just
    * String.replaceAll('=', ANOTHER_CHAR)
    * String.replaceAll(ANOTHER_CHAR, '=')
    */
  def store(arr: Array[Map[String, String]]): String =
    arr.map(_.map { case (k, v) => s"$k=$v"} mkString(";")).mkString("\n")

  def load(txt: String): Array[Map[String, String]] = {
    txt.split("\n").map { _.split(";").map { s =>
        (s.substring(0,s.indexOf('=')), s.substring(s.indexOf('=')+1))
      }.toMap
    }
  }

  println(store(Array(Map("0"->"a","1"->"b"),Map("2"->"c","3"->"d"))))
  println()
  load(store(Array(Map("0"->"a","1"->"b"),Map("2"->"c","3"->"d")))).foreach(println)
}
