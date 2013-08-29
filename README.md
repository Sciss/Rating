# Rating

A Rating (mark-out-of-X-stars) component for Swing. This started as a fork/clone from the Java project at https://code.google.com/p/jrating/. Original project and fork are released under the [Apache 2.0 License](LICENSE). The original author was Hendrik Ebbers.

The Java component, in sub project `java`, will be accompanied by Scala-Swing component at some point.

All modifications, extensions and Scala project (C)opyright 2013 by Hanns Holger Rutz.

## linking

(NOT YET) To use the library:

    "de.sciss" %  "rating-java"  % v  // Java only component
    "de.sciss" %% "rating-scala" % v  // Scala component

The current version `v` is `0.1.+`

## building

The project builds with [sbt](http://www.scala-sbt.org/) 0.13 now. To compile `sbt compile`. To run the core demo, `sbt rating-java/test:run`. To build the API docs, `sbt doc`.
