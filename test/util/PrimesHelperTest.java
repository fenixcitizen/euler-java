package util;

import junit.framework.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Map;

import static util.PrimesHelper.*;

/**
 * Created by kapturma@29/03/14.
 */
public class PrimesHelperTest {

    @Test
    public void testFactorize() throws Exception {

        Map<Integer,Integer> factorizedOne = factorize(new BigInteger("1"));
        Assert.assertEquals(0, factorizedOne.size());

        Map<Integer,Integer> factorizedTwo = factorize(new BigInteger("2"));
        Assert.assertEquals(1, factorizedTwo.size());
        Assert.assertTrue(factorizedTwo.containsKey(2));
        Assert.assertTrue(factorizedTwo.get(2).equals(1));

        Map<Integer,Integer> factorizedThree = factorize(new BigInteger("3"));
        Assert.assertEquals(1, factorizedThree.size());
        Assert.assertTrue(factorizedThree.containsKey(3));
        Assert.assertTrue(factorizedThree.get(3).equals(1));

        Map<Integer,Integer> factorizedFour = factorize(new BigInteger("4"));
        Assert.assertEquals(1, factorizedFour.size());
        Assert.assertTrue(factorizedFour.containsKey(2));
        Assert.assertTrue(factorizedFour.get(2).equals(2));

        Map<Integer,Integer> factorizedSix = factorize(new BigInteger("6"));
        Assert.assertEquals(2, factorizedSix.size());
        Assert.assertTrue(factorizedSix.containsKey(2));
        Assert.assertTrue(factorizedSix.containsKey(3));
        Assert.assertTrue(factorizedSix.get(2).equals(1));
        Assert.assertTrue(factorizedSix.get(3).equals(1));

        Map<Integer,Integer> factorizedThirteen = factorize(new BigInteger("13"));
        Assert.assertEquals(1, factorizedThirteen.size());
        Assert.assertTrue(factorizedThirteen.containsKey(13));
        Assert.assertTrue(factorizedThirteen.get(13).equals(1));

        Map<Integer,Integer> factorizedTwentyFour = factorize(new BigInteger("24"));
        Assert.assertEquals(2, factorizedTwentyFour.size());
        Assert.assertTrue(factorizedTwentyFour.containsKey(2));
        Assert.assertTrue(factorizedTwentyFour.containsKey(3));
        Assert.assertTrue(factorizedTwentyFour.get(2).equals(3));
        Assert.assertTrue(factorizedTwentyFour.get(3).equals(1));

    }

    @Test
    public void testNumOfUniqueDivisors() {
       Assert.assertEquals(0, numberOfUniqueDivisors(new BigInteger("1")).intValue());
       Assert.assertEquals(1, numberOfUniqueDivisors(new BigInteger("2")).intValue());
       Assert.assertEquals(1, numberOfUniqueDivisors(new BigInteger("3")).intValue());
       Assert.assertEquals(1, numberOfUniqueDivisors(new BigInteger("4")).intValue());
       Assert.assertEquals(2, numberOfUniqueDivisors(new BigInteger("6")).intValue());
       Assert.assertEquals(2, numberOfUniqueDivisors(new BigInteger("24")).intValue());
       Assert.assertEquals(3, numberOfUniqueDivisors(new BigInteger("30")).intValue());
    }

    @Test
    public void testNumOfDivisors() {
        Assert.assertEquals(2, numOfDivisors(BigInteger.valueOf(2),1).intValue());
        Assert.assertEquals(4, numOfDivisors(BigInteger.valueOf(6),1).intValue());
        Assert.assertEquals(8, numOfDivisors(BigInteger.valueOf(24),1).intValue());
        Assert.assertEquals(2187, numOfDivisors(BigInteger.valueOf(2*3*5*7*11*13*17),2).intValue());
    }

    @Test
    public void testGCD() {
        Assert.assertEquals(BigInteger.valueOf(4), PrimesHelper.GCD(BigInteger.valueOf(8), BigInteger.valueOf(4)));
        Assert.assertEquals(BigInteger.valueOf(1), PrimesHelper.GCD(BigInteger.valueOf(8), BigInteger.valueOf(7)));
        Assert.assertEquals(BigInteger.valueOf(6), PrimesHelper.GCD(BigInteger.valueOf(18), BigInteger.valueOf(12)));
        Assert.assertEquals(BigInteger.valueOf(13), PrimesHelper.GCD(BigInteger.valueOf(13), BigInteger.valueOf(13)));
        Assert.assertEquals(BigInteger.valueOf(13), PrimesHelper.GCD(BigInteger.valueOf(0), BigInteger.valueOf(13)));
        Assert.assertEquals(BigInteger.valueOf(13), PrimesHelper.GCD(BigInteger.valueOf(13), BigInteger.valueOf(0)));
    }

    @Test
    public void testErastothenesSieve() {
        Assert.assertTrue(PrimesHelper.getCompoundNumberMarks(10)[4]);
        Assert.assertTrue(PrimesHelper.getCompoundNumberMarks(10)[6]);
        Assert.assertFalse(PrimesHelper.getCompoundNumberMarks(10)[7]);
        Assert.assertFalse(PrimesHelper.getCompoundNumberMarks(100)[7]);
        Assert.assertFalse(PrimesHelper.getCompoundNumberMarks(100)[41]);
    }

}
