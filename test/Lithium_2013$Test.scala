import org.scalatest._

/**
 * Created by mateusz on 07/05/16.
 */

class Lithium_2013_Test extends FlatSpec with Matchers {

    "Challenge example" should "just work" in {
      def A: Array[Array[Int]] = Array(Array(1, 2), Array(2, 4), Array(4, 3), Array(2, 3), Array(1, 3))
      Lithium_2013.solution(A, 4) should be (4)
    }

    "Simple example" should "just work" in {
      def A: Array[Array[Int]] = Array(Array(1, 2, 3), Array(2, 3, 4), Array(4, 3, 1), Array(2, 3, 1), Array(1, 3, 2))
      Lithium_2013.solution(A, 4) should be (10)
    }

    "Single hand" should "be isomorphic with all other" in {
      def A: Array[Array[Int]] = Array(Array(1), Array(2), Array(3), Array(4), Array(5))
      Lithium_2013.solution(A, 5) should be (10)
    }

}