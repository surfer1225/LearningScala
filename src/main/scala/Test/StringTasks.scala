package Test

import scala.collection.JavaConverters._

/**
  * Created by Ryan on 6/7/2017 AD.
  */
class StringTasks {

  private def splitStrToSet(inputStr: String): Set[String] = {
    inputStr.split(" ").toSet
  }

  private def splitStrToList(inputStr: String): List[String] = {
    inputStr.split(" ").toList
  }

  def longestWord(inputStr: String): String = {
    var longestWord = ""
    for {
      s <- splitStrToSet(inputStr)
      if (s.length > longestWord.length)
    } longestWord = s

    longestWord
  }

  def mostCommonWord(inputStr: String): String = {
    var cnt = 0
    var mostCommonStr = ""
    val strList = splitStrToList(inputStr)
    for (s <- splitStrToSet(inputStr)) {
      if (strList.count(_ == s) > cnt) {
        mostCommonStr = s
        cnt = strList.count(_ == s)
      }
    }
    mostCommonStr
  }

  //better syntax????
  def mostCommonChar(inputStr: String): Char = {
    var cnt = 0
    var mostCommonC = 'a'

    val compareChar = (c: Char) => {
      if (inputStr.count(_ == c) > cnt) {
        cnt = inputStr.count(_ == c)
        mostCommonC = c
      }
    }

    inputStr.foreach(compareChar(_))
    mostCommonC
  }

  //1 more qn here: Create a map from letter to a set of words it appear in

  def strlistToCharList(inputStrList: List[String]): List[List[Char]] = {
    for {
      str <- inputStrList
    } yield str.toCharArray.toList
  }
}

