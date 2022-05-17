import Common._

// ContainsDollar has to be defined in a separate project from its the places where it's used
lazy val refined2Base = (project in file("refined2Base"))
  .commonSettings("refined2Base", "0.1.0")
  .settings(
    libraryDependencies ++= Seq(Dependencies.refined)
  )

lazy val refined2 = (project in file("refined2"))
  .commonSettings("refined2", "0.1.0")
  .settings(
    libraryDependencies ++= Seq(Dependencies.refined)
  )
  .dependsOn(refined2Base)

lazy val refined3 = (project in file("refined3"))
  .commonSettings("refined3", "0.1.0", "3.1.2")
  .settings(
    libraryDependencies ++= Seq(Dependencies.refined)
  )
