import sbt._

object Dependencies {
	lazy val refined        =  "eu.timepit" %% "refined" % "0.9.29"

	lazy val munit = "org.scalameta" %% "munit" % "0.7.29" % Test
}
