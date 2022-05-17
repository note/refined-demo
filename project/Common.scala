import com.softwaremill.SbtSoftwareMillCommon.autoImport.commonSmlBuildSettings
import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile
import sbt.Keys._
import sbt.{Project, TestFramework}

object Common {
  implicit class ProjectFrom(project: Project) {
    def commonSettings(nameArg: String, versionArg: String, scalaV: String = "2.13.8"): Project = project.settings(
      name := nameArg,
      organization := "pl.msitko",
      version := versionArg,

      scalaVersion := scalaV,
      scalafmtOnCompile := true,

      commonSmlBuildSettings,
      scalacOptions += "-Ymacro-annotations",
      testFrameworks += new TestFramework("munit.Framework")
    )
  }
}
