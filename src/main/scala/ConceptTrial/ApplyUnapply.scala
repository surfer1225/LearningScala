package ConceptTrial

class ApplyUnapply(val a:String, val b:Int)

object ApplyUnapply{
  def apply(a: String, b: Int) = new ApplyUnapply(a, b)

  def unapply(applyUnapply: ApplyUnapply): (String, Int) = (applyUnapply.a, applyUnapply.b)
}
