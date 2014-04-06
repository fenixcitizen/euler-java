import util.PrimesHelper;

import java.math.BigInteger;

/**
 * Created by kapturma@04/04/14.
 */
public class Euler_10 extends EulerRunner {

    private static final int PRIME_LIMIT = 2000000;

    public static void main(String[] args) {
        new Euler_10().execute();
    }

    @Override
    protected String run() {
        boolean[] isNotPrime = PrimesHelper.getCompoundNumberMarks(PRIME_LIMIT);
        BigInteger sum = BigInteger.ZERO;
        int iter = 2;
        while (iter < PRIME_LIMIT) {
            if (!isNotPrime[iter]) {
                sum = sum.add(BigInteger.valueOf(iter));
            }
            iter++;
        }
        return String.valueOf(sum);
    }

}
