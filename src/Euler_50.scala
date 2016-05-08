import util.PrimesGenerator._

import scala.collection.immutable.IndexedSeq

/**
 * Created by mateusz on 03/05/16.
 */
object Euler_50 extends EulerRunner {

  val LIMIT: Int = 1000000

  val primesOfInterest: Vector[Int] = generatePrimes().toVector

  def generatePrimes() = {
    do {
      nextPrime
    } while (ps.sum < LIMIT)
    ps
  }

  def main(args: Array[String]) {
    execute()
  }

  override protected def run(): String = {
    val tuples: IndexedSeq[(Vector[Int], Int, Int, Boolean)] = for {
      from <- 0 to primesOfInterest.length
      until <- (from + 1) to primesOfInterest.length
    } yield {
        val slice: Vector[Int] = primesOfInterest.slice(from, until)
        val sum: Int = slice.sum
        (slice, sum, slice.length, isPrime(sum))
      }
    tuples
      .filter(_._4)
      .max(Ordering.by((t: (_, _, Int, _)) => t._3))
      ._2
      .toString
  }


}
