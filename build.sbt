name := "shExLite"

version := "0.1"

lazy val scala212 = "2.12.10"
lazy val scala213 = "2.13.1"
scalaVersion in ThisBuild := scala213
crossScalaVersions := Seq(scala212, scala213)

Compile / scalaSource := baseDirectory.value / "src"
Compile / unmanagedSourceDirectories += baseDirectory.value / "src/library"

Test / unmanagedSourceDirectories += baseDirectory.value / "test/benchmark"
Test / unmanagedSourceDirectories += baseDirectory.value / "test/unit"

parallelExecution in Test := false

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "org.antlr" % "antlr4" % "4.8-1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

coverageExcludedPackages := "compiler.syntactic.generated.*"
