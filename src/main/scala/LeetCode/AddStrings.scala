package LeetCode

/**
  * Created by Ryan on 13/1/18.
  */

/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
object AddStrings extends App {
  println(addStrings("123", "1111"))
  def addStrings(num1: String, num2: String): String = {
    val l1 = num1.length
    val l2 = num2.length
    val l = Math.max(l1, l2)
    var carry = 0
    var res = ""
    for (i <- 0 to l-1) {
      val digit1 = if (i<l1) num1.charAt(l1-1-i) - '0' else 0
      val digit2 = if (i<l2) num2.charAt(l2-1-i) - '0' else 0
      val sum = digit1 + digit2 + carry
      carry = sum / 10
      res = sum % 10 + res
    }
    if (carry == 1) res = 1 + res
    res
  }
}
