package example

import base.ContainsDollar
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric.Interval.Closed
import eu.timepit.refined.refineMV

case class Point(x: Int, y: Int)
case class Quadrant1()

object Main {
  def main(args: Array[String]): Unit = {
    val a: Int Refined Interval.Closed[3, 5] = 4
    println(a)

    val aa: Refined[Int, Closed[3, 5]] = refineMV[Interval.Closed[3, 5]](4)
    println(aa)

    val s: String Refined ContainsDollar = "a$bc"
    println(s)

//    Fails compilation with:
//      [error] /Users/michal/programming/scala/experiments/refined2/src/main/scala/example/Main.scala:16:44: Predicate failed: (abc contains '$').
//      [error]     val s: String Refined ContainsDollar = "abc"
//      [error]                                            ^
//      [info] String("abc") <: eu.timepit.refined.api.Refined[String,base.ContainsDollar]?
//      [info] false
//      [error] one error found
//    val s2: String Refined ContainsDollar = "abc"
//    println(s2)
  }
}
