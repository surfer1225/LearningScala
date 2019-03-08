package Test

object FlattenMapUtils extends App {
  def flattenMap(m: Map[String, Any], previousKey: String = ""): Map[String, Any] = {
    m.toSeq.flatMap {
      case (k1, v1) =>
        v1 match {
          case m2: Map[String, Any] => flattenMap(m2, s"$previousKey$k1.")
          case _ => Map(s"$previousKey$k1" -> v1)
        }
    }.toMap
  }
  println(flattenMap(Map("a" -> Map("b" -> Map("z" -> 3.0, "y" -> false), "c" -> "zzz"), "d" -> 8.0)))
}
