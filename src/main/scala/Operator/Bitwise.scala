package Operator

/**
  * Created by Ryan on 6/7/2017 AD.
  */
object Bitwise {
  def main(args: Array[String]) {
    var x = 16;
    var y = 12;
    var z = 0;

    z = x & y;
    println("Bitwise And of x & y = " + z );

    z = x | y;
    println("Bitwise Or of x | y = " + z );

    z = x ^ y;
    println("Bitwise Xor of x ^ y = " + z );

    z = ~x;
    println("Bitwise Ones Complement of ~x = " + z );

    z = x << 2;
    println("Bitwise Left Shift of x << 2 = " + z );

    z = x >> 2;
    println("Bitwise Right Shift of x >> 2 = " + z );

    z = x >>> 2;
    println("Bitwise Shift Right x >>> 2 = " + z );
  }
}
