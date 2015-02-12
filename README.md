# Rating

[![Flattr this](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=sciss&url=https%3A%2F%2Fgithub.com%2FSciss%2FRating&title=Rating%20Swing%20Widget&language=Java&tags=github&category=software)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.sciss/rating_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.sciss/rating_2.11)

A rating (mark-out-of-X-stars) component for Swing. This started as a fork/clone from the Java project at https://code.google.com/p/jrating/. Original project and fork are released under the [Apache 2.0 License](LICENSE). The original author was Hendrik Ebbers.

The Java component, in sub project `java`, is accompanied by a component for the Scala programming language, found in sub project `scala`.

All modifications, extensions and Scala project (C)opyright 2013 by Hanns Holger Rutz.

## linking

    "de.sciss" %  "rating-java"  % v  // Java only component
    "de.sciss" %% "rating-scala" % v  // Scala component

The current version `v` is `0.1.1+`

## building

The project builds with [sbt](http://www.scala-sbt.org/) 0.13. Scala version is 2.10.

To compile `sbt compile`. To run the Java demo, `sbt rating-java/test:run`. To run the Scala demo, `sbt rating-scala/test:run`. To build the API docs, `sbt doc`.
