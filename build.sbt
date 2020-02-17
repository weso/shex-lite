name := "shExLite"

version := "0.1"

scalaVersion := "2.12.7"

Compile / scalaSource := baseDirectory.value / "src/main/scala-2.13"
Compile / javaSource := baseDirectory.value / "src/main/java"

libraryDependencies += "org.antlr" % "antlr4" % "4.8-1"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

lazy val shexlite = project in file (".")

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"