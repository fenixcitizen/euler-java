import util.PrimesHelper;

import java.math.BigInteger;

/**
 * Created by kapturma@29/03/14.
 */
public class Euler_108 extends EulerRunner {

    public static final int LIMIT = 4000;

    public static void main(String[] args) {
        new Euler_108().execute();
    }

    @Override
    protected String run() {
        System.out.println(PrimesHelper.numberOfUniqueDivisors(BigInteger.valueOf(6126120)));
        System.out.println(PrimesHelper.numOfDivisors(BigInteger.valueOf(6126120),2));
        System.out.println(PrimesHelper.factorize(BigInteger.valueOf(6126120)));
        BigInteger n = BigInteger.valueOf(999999999);
        while ((PrimesHelper.numOfDivisors(n, 2) + 1) / 2 < LIMIT) {
            n = n.add(BigInteger.ONE);
        }
        return n.toString();
    }
}
