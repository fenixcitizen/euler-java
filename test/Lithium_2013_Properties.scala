import Lithium_2013.Spaces
import org.junit.Test
import org.scalacheck.Gen
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import org.scalacheck.Prop.forAllNoShrink

/**
 * Created by mateusz on 07/05/16.
 */


class Lithium_2013_Properties extends JUnitSuite with Checkers {

  @Test
  def testConcat() {
    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)
  }

  def genList[T](genElem: Gen[T], N: Int, M: Int): Gen[List[List[T]]] = {
    val clocks: Gen[List[List[T]]] = for {
      clock <- Gen.listOfN(N, Gen.listOfN(M, genElem))
    } yield clock
    clocks
  }

  implicit override val generatorDrivenConfig = PropertyCheckConfig(minSuccessful = 1000, maxSize = 2000)

  @Test
  def testSumOfFrequenciesEqualsTotalNumberOfClocks() {
    val P: Int = 8
    val numOfClocks = 6
    val numOfHands = 6
    val list: Gen[List[List[Int]]] = genList(Gen.choose(1, P), numOfClocks, numOfHands)
    check(forAllNoShrink(list) { (clocks: List[List[Int]]) => {
      val A: Array[Array[Int]] = clocks.map(_.toArray).toArray
      var freqs: Map[Spaces, Int] = Lithium_2013.calculateFreqs(Lithium_2013.parseClocks(A, P))
      val sumOfFreqs: Int = freqs.foldLeft(0)({ case (acc: Int, (_, freq: Int)) => acc + freq })
//      println("sumOfFreqs:" + sumOfFreqs)
      sumOfFreqs == clocks.length
    }})
  }

}
