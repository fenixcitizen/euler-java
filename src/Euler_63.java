import util.PrimesHelper;

import java.math.BigInteger;

/**
 * Created by kapturma@30/03/14.
 */
public class Euler_63 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_63().execute();
    }

    @Override
    protected String run() {
        Integer counter = 0;
        BigInteger a = BigInteger.ZERO;
        for (int a_ = 1; a_ < 10; a_++) {
            a = a.add(BigInteger.ONE);
            for (int b_ = 1; b_ < 22; b_++) {
                if (a.pow(b_).toString().length() == b_)
                    counter++;
            }
        }
        return counter.toString();
    }
}
