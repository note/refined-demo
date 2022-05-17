package example

import eu.timepit.refined.refineV
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.numeric.Interval.Closed

import scala.compiletime.constValue

object CurrentStateOfThings {
  def main(args: Array[String]): Unit =
    // This works just fine:
    val a: Either[String, Refined[Int, Closed[3, 5]]] = refineV[Interval.Closed[3, 5]](4)
    println(a)

  // This doesn't compile though:
  // val b: Refined[Int, Closed[3, 5]] = 4
}
