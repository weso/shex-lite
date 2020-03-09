name := "shExLite"

version := "0.1"

scalaVersion := "2.13.1"

Compile / scalaSource := baseDirectory.value / "src/compiler"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/library"

Test / scalaSource := baseDirectory.value / "test"

libraryDependencies += "org.antlr" % "antlr4" % "4.8-1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

lazy val shexlite = project in file (".")
