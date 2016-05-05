package util

import scala.collection.mutable.ListBuffer

/**
 * Created by mateusz on 03/05/16.
 */
object PrimesGenerator {

  val ps: ListBuffer[Int] = new ListBuffer[Int]

  ps.+=(2)

  def nextPrime: Int = {
    ps.+=(Stream
        .from(ps.last)
        .filter(i => ps.takeWhile(p => p*p<=i).forall(p => i%p>0))
        .take(2)
        .last)
    ps.last
  }

  def isPrime(n: Int) = ps.contains(n) || !((2 until (Math.sqrt(n).toInt + 1)) exists (n % _ == 0))

}
