package de.sciss.rating

import scala.swing.{Publisher, Component}
import de.sciss.rating.j.{JRating, DefaultRatingModel, RatingModel}
import scala.swing.event.ValueChanged

object Rating {
  object Alignment {
    case object Horizontal extends Alignment
    case object Vertical   extends Alignment

    implicit def toJava(alignment: Alignment): j.RatingAlignment = alignment match {
      case Horizontal => j.RatingAlignment.HORIZONTAL
      case Vertical   => j.RatingAlignment.VERTICAL
    }

    implicit def fromJava(alignment: j.RatingAlignment): Alignment = alignment match {
      case j.RatingAlignment.HORIZONTAL => Horizontal
      case j.RatingAlignment.VERTICAL   => Vertical
    }
  }
  sealed trait Alignment
}

/** A `Rating` component displays a rating choice on an integer scale.
  * The incremental steps in this choice, called rating elements, are displayed
  * horizontally or vertically aligned. The default rendering of such an element
  * is a star icon. The current rating value, from zero
  * to the maximum number of elements, is reflected by visually highlighting
  * the corresponding number of elements.
  *
  * For example, with the default star renderer,
  * if the maximum number of elements is five, and the rating is two, a total of
  * five stars are shown, the first two of which are visually highlighted.
  *
  * @param model0 the model to use for the rating
  * @param align0 the alignment (horizontal or vertical) of the component
  */
class Rating(model0: RatingModel, align0: Rating.Alignment) extends Component with Publisher {
  me =>

  import Rating.Alignment

  def this(model0: RatingModel) {
    this(model0, Rating.Alignment.Horizontal)
  }

  def this(align0: Rating.Alignment) {
    this(new DefaultRatingModel, align0)
  }

  def this() {
    this(new DefaultRatingModel())
  }

  private object listener extends j.RatingListener {
    def indexChanged(event: j.RatingEvent): Unit = publish(new ValueChanged(me))

    def maxCountChanged(event: j.RatingEvent) = ()
  }

  model0.addRateListener(listener)

  override lazy val peer: JRating = new JRating(model0, align0) with SuperMixin

  /** Queries whether the element at a given index (counting from zero) is marked. */
  def isMarked(index: Int): Boolean = peer.isMarked(index)

  /** Returns the rating value which is the number of marked elements. */
  def value          : Int        = peer.getMarkedCount
  /** Adjusts the rating value which is the number of marked elements. */
  def value_=(count  : Int): Unit = peer.setMarkCount(count)

  /** Returns the total number of rating elements. */
  def maximum        : Int        = peer.getMaxCount
  /** Adjusts the total number of rating elements. */
  def maximum_=(count: Int): Unit = peer.setMaxCount(count)

  def alignment        : Alignment        = peer.getAlignment
  def alignment_=(value: Alignment): Unit = peer.setAlignment(value)

  def model    : RatingModel        = peer.getModel
  def model_=(m: RatingModel): Unit = {
    model.removeRateListener(listener)
    peer.setModel(m)
    m.addRateListener(listener)
  }

  /** Returns the visual gap in pixels between adjacent rating elements. */
  def gap        : Int        = peer.getGap
  /** Adjusts the visual gap in pixels between adjacent rating elements. */
  def gap_=(value: Int): Unit = peer.setGap(value)
}