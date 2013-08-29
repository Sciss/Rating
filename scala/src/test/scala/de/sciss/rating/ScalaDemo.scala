package de.sciss.rating

import scala.swing.{Orientation, BoxPanel, MainFrame, Frame, SimpleSwingApplication}
import scala.swing.event.ValueChanged

object ScalaDemo extends SimpleSwingApplication {
  lazy val top: Frame = new MainFrame {
    title     = "Rating Demo"
    contents  = new BoxPanel(Orientation.Vertical) {
      for (i <- 0 to 10) {
        val comp      = new Rating
        comp.maximum  = 10
        comp.value    = i
        listenTo(comp)
        reactions += {
          case ValueChanged(`comp`) => println(s"Rating #${i+1} changed to ${comp.value}")
        }
        contents += comp
      }
    }
  }
}
