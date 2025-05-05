/*ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "zio-scala-http"
  )
*/

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "scala-zio-poc"
  )

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.11",
  "dev.zio" %% "zio-http" % "3.0.1", // for the HTTP server
  "dev.zio" %% "zio-json" % "0.7.3"
)