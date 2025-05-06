ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "scala-redis-server"
  )

///resolvers += Resolver.url("my-test-repo", url("https://example.org/repo-releases/"))
resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases"