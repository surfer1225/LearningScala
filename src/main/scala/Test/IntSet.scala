package Test

/**
  * Created by Ryan on 6/8/2017 AD.
  */

trait IntSet {
  def isEmpty: Boolean
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def excl(x: Int): IntSet

  def union(set: IntSet): IntSet
  def intersect(set: IntSet): IntSet
}

object EmptySet extends IntSet {
  def isEmpty = true
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmptySet(x, EmptySet, EmptySet)
  def excl(x: Int) = this
  def union(other: IntSet) = other
  def intersect(other: IntSet) = EmptySet

  override def toString = "."
}

class NonEmptySet(val elem: Int, val left: IntSet, val right: IntSet) extends IntSet {
  def isEmpty = false

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this

  def excl(x: Int) = {
    if (x < elem) new NonEmptySet(elem, left.excl(x), right)
    if (x > elem) new NonEmptySet(elem, left, right.excl(x))
    else left union right
  }

  def union(other: IntSet) = ((left union other) union right) incl elem

  def intersect(other: IntSet) = {
    val sub = ((left intersect other) union (right intersect other))
    if (!other.isEmpty) {
      val otherNonEmpty = other.asInstanceOf[NonEmptySet]
      val otherSub = ((otherNonEmpty.left intersect this) union (otherNonEmpty.right intersect this))
      val union = sub union otherSub
      if (elem == otherNonEmpty.elem) union incl elem  else union
    }
    else sub
  }

  override def toString = s"(${left.toString}$elem${right.toString})"
}

abstract class IntTree
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

object IntTree {
  def contains(tree: IntTree, value: Int): Boolean = tree match {
    case EmptyTree => false
    case Node(e, left, right) =>
      if (e == value) true
      else contains(left, value) || contains(right, value)
  }

  def insert(tree: IntTree, value: Int): IntTree = tree match {
    case EmptyTree => Node(value, EmptyTree, EmptyTree)
    case Node(v, l, r) => if (v < value) Node(v, insert(l, value), r)
    else Node(v, l, insert(r, value))
  }
}