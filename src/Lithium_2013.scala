import java.util

import scala.reflect.ClassTag

/**
 * Created by mateusz on 03/05/16.
 */
object Lithium_2013 extends EulerRunner {

  def C: Array[Array[Int]] = Array(Array(1, 2, 3, 4, 5, 7, 9), Array(1, 2, 3, 5, 7, 8, 10), Array(1, 2, 3, 4, 5, 7, 9), Array(10, 1, 2, 3, 4, 7, 9), Array(10, 1, 2, 3, 4, 7, 9), Array(6, 8, 9, 10, 1, 2, 5), Array(7, 8, 9, 10, 1, 2, 5))

  def PP: Int = 10

  def main(args: Array[String]) {
    execute(99999)
  }

  override protected def run(): String = {
    solution(C, PP).toString
  }

  def solution(A: Array[Array[Int]], P: Int): Int = {
    val clocks: Array[Spaces] = parseClocks(A, P)

    val freqs: Map[Spaces, Int] = calculateFreqs(clocks)

    freqs.foldLeft(0)({ case (acc: Int, (spaces: Spaces, freq: Int)) => acc + freq * (freq - 1) / 2 })
  }

  def calculateFreqs(clocks: Array[Spaces]): Map[Spaces, Int] = {
    clocks.groupBy(identity).mapValues(_.length)
  }

  def parseClocks(A: Array[Array[Int]], P: Int): Array[Spaces] = {
    A.map(hands => {
      val sortedHands: Array[Int] = hands.sorted
      sortedHands
        .zip(rotate(1, sortedHands))
        .map({ case (firstHand, secondhand) =>
        val space: Int = secondhand - firstHand
        if (space < 0)
          secondhand + (P - firstHand) // to address 00:00 crossing
        else
          space
      })
    }).map((as: Array[Int]) => new Spaces(as))
  }

  def rotate[A](n: Int, l: Array[A])(implicit m: ClassTag[A]): Array[A] = {
    val wrapn = if (l.isEmpty) 0 else n % l.length
    if (wrapn < 0) rotate(l.length + n, l)
    else l.drop(wrapn).++(l.take(wrapn))
  }

  case class Spaces(spaces: Array[Int], representation: String) {

    def this(spaces: Array[Int]) {
      this(spaces, util.Arrays.toString((for {rotationSize <- spaces.indices} yield rotate(rotationSize, spaces)).min(new Ordering[Array[Int]] {
        override def compare(xs: Array[Int], ys: Array[Int]): Int = {
          require(xs.length == ys.length)
          var iter: Int = 0
          while (iter < xs.length) {
            if (xs(iter) < ys(iter))
              return -1
            else if (xs(iter) > ys(iter))
              return 1
            iter += 1
          }
          0
        }
      }): Array[Int]))
    }

    override def equals(o: Any) = o match {
      case (that: Spaces) => this.representation.equals(that.representation)
      case _ => false
    }

    override def hashCode = this.representation.hashCode
  }

}
