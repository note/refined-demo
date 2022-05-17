package example

import eu.timepit.refined.boolean.Or
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.numeric.Interval.Closed
import eu.timepit.refined.refineV

import scala.compiletime.constValue

object Proposition {
  implicit inline def refineMV[T, P](inline t: T)(using inline p: Predicate[T, P]): Refined[T, P] =
    inline if (p.isValid(t)) Refined.unsafeApply(t) else scala.compiletime.error("no")

  trait Predicate[T, P] {
    transparent inline def isValid(inline t: T): Boolean
  }

  object Predicate {
    inline given [M <: Int, N <: Int]: Predicate[Int, Interval.Closed[M, N]] with
      transparent inline def isValid(inline t: Int): Boolean = constValue[M] <= t && t <= constValue[N]

//    inline given [Int, A <: Predicate[_, _], B <: Predicate[_, _]]: Predicate[Int, Or[A, B]] with
//      transparent inline def isValid(inline t: Int): Boolean = true
  }

  object Approach1 {
    inline given [T, A <: Predicate[T, _], B <: Predicate[T, _]]: Predicate[T, Or[A, B]] with
      transparent inline def isValid(inline t: T): Boolean = true // Dummy impl, just make it compile

    val a = refineMV[Int, Or[Predicate[Int, Interval.Closed[3, 5]], Predicate[Int, Interval.Closed[103, 105]]]](4)
  }

//  object Approach2 {
//    inline given [T, A <: Refined[T, _], B <: Refined[T, _]]: Predicate[T, Or[A, B]] with
//      transparent inline def isValid(inline t: T): Boolean = true
//
//    val a = refineMV[Int, Or[Interval.Closed[3, 5], Interval.Closed[103, 105]]](4)
//  }

  // approach 2:
//  val aa = refineMV[Int, Or[Interval.Closed[3, 5], Interval.Closed[103, 105]]](4)

//  val b: Refined[Int, Closed[3, 5]]  = refineMV[Int, Interval.Closed[3, 5]](12)

//  def main(args: Array[String]): Unit = {
//    val x = refineV[Interval.Closed[3, 5]](args(1).toInt)
//  }
}
