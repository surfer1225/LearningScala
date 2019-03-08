package Test

/**
  * Created by Ryan on 6/6/2017 AD.
  */


trait Queue[T] {
  def get(): T
  def put(x: T)
}

import scala.collection.mutable.ArrayBuffer

class IntQueue extends Queue[Int] {
  private val arr = new ArrayBuffer[Int]

  override def get(): Int = arr remove 0

  override def put(x: Int) = arr append x

  def isEmpty(): Boolean = arr.isEmpty
}

class StringQueue extends Queue[String] {
  private val arr = new ArrayBuffer[String]

  override def get(): String = arr remove 0

  override def put(x: String) = arr append x

  def isEmpty(): Boolean = arr.isEmpty
}
