package base

import eu.timepit.refined.api.Validate

case class ContainsDollar()

object ContainsDollar {
  implicit val stringContainingDollar: Validate.Plain[String, ContainsDollar] =
    Validate.fromPredicate(s => s.contains('$'), s => s"($s contains '$$')", ContainsDollar())
}
