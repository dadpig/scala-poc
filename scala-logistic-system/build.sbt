ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"
resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"
lazy val root = (project in file("."))
  .settings(
    name := "scala-logistic-system"
  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test