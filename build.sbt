name := "Rating"

version in ThisBuild := "0.1.0-SNAPSHOT"

organization in ThisBuild := "de.sciss"

scalaVersion in ThisBuild := "2.10.2"

homepage in ThisBuild := Some(url("https://github.com/Sciss/Rating"))

licenses in ThisBuild := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

// ---- sub-projects ----

// lazy val rating = project.in(file(".")).aggregate(rating_java)

lazy val `rating-java` = project.in(file("java")).settings(
  description := "A Java Swing Component for Rating",
  crossPaths := false,
  autoScalaLibrary := false
)

lazy val `rating-scala` = project.in(file("scala")).dependsOn(`rating-java`).settings(
  description := "A Scala Swing Component for Rating",
  libraryDependencies <+= scalaVersion { sv =>
    "org.scala-lang" % "scala-swing" % sv
  }
)

// ---- publishing ----

publishMavenStyle in ThisBuild := true

publishTo in ThisBuild <<= version { v =>
  Some(if (v endsWith "-SNAPSHOT")
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )
}

publishArtifact in Test in ThisBuild := false

pomIncludeRepository in ThisBuild := { _ => false }
