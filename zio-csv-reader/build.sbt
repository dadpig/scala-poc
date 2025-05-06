val zioVersion = "2.1.9"

scalaVersion := "3.3.2"
name := "zio-csv-reader"
version := "0.0.1"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion,
  "dev.zio" %% "zio-streams" % zioVersion,
  "dev.zio" %% "zio-http" % "3.0.1"
)
