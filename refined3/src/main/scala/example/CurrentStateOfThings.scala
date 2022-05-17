package example

import eu.timepit.refined.refineV
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.numeric.Interval.Closed

import scala.compiletime.constValue

import eu.timepit.refined._
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._
import eu.timepit.refined.api.{RefType, Refined}
import eu.timepit.refined.boolean._
import eu.timepit.refined.char._
import eu.timepit.refined.collection._
import eu.timepit.refined.generic._
import eu.timepit.refined.string._
import shapeless.{::, HNil}

import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._

object CurrentStateOfThings {
  def main(args: Array[String]): Unit =
    // This works just fine:
    val a: Either[String, Refined[Int, Closed[3, 5]]] = refineV[Interval.Closed[3, 5]](4)
    println(a)

  // This doesn't compile though:
  // val b: Refined[Int, Closed[3, 5]] = 4
}
