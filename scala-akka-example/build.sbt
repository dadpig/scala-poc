ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "scala-akka-example"
  )

libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.8.8"
// https://mvnrepository.com/artifact/org.slf4j/slf4j-api
libraryDependencies += "org.slf4j" % "slf4j-api" % "2.0.17"
// https://mvnrepository.com/artifact/org.slf4j/slf4j-reload4j
libraryDependencies += "org.slf4j" % "slf4j-reload4j" % "2.0.17"