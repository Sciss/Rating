name := "Rating"

version in ThisBuild := "0.1.0"

organization in ThisBuild := "de.sciss"

scalaVersion in ThisBuild := "2.10.2"

homepage in ThisBuild := Some(url("https://github.com/Sciss/Rating"))

licenses in ThisBuild := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

// ---- sub-projects ----

lazy val rating = project.in(file("."))
  .aggregate(`rating-java`, `rating-scala`)
  .dependsOn(`rating-java`, `rating-scala`)
  .settings(
    publishArtifact in(Compile, packageBin) := false, // there are no binaries
    publishArtifact in(Compile, packageDoc) := false, // there are no javadocs
    publishArtifact in(Compile, packageSrc) := false, // there are no sources
    autoScalaLibrary := false,
    pomExtra := pomExtraBoth
  )

lazy val `rating-java` = project.in(file("java")).settings(
  description := "A Java Swing Component for Rating",
  crossPaths := false,
  autoScalaLibrary := false,
  pomExtra := pomBase ++ pomDevsBoth
)

lazy val `rating-scala` = project.in(file("scala")).dependsOn(`rating-java`).settings(
  description := "A Scala Swing Component for Rating",
  libraryDependencies <+= scalaVersion { sv =>
    "org.scala-lang" % "scala-swing" % sv
  },
  pomExtra := pomBase ++ pomDevsSciss
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

lazy val pomExtraBoth = pomBase ++ pomDevsBoth

lazy val pomBase =
  <scm>
    <url>git@github.com:Sciss/Rating.git</url>
    <connection>scm:git:git@github.com:Sciss/Rating.git</connection>
  </scm>

lazy val pomDevSciss =
  <developer>
    <id>sciss</id>
    <name>Hanns Holger Rutz</name>
    <url>http://www.sciss.de</url>
  </developer>

lazy val pomDevEbbers=
  <developer>
    <id>guigarage</id>
    <name>Hendrik Ebbers</name>
    <url>https://github.com/guigarage</url>
  </developer>

lazy val pomDevsBoth =
  <developers>
    {pomDevSciss}
    {pomDevEbbers}
  </developers>

lazy val pomDevsSciss =
  <developers>
    {pomDevSciss}
  </developers>
