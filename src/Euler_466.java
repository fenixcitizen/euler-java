import util.PrimesHelper;

import java.math.BigInteger;

/**
 * Created by kapturma@06/04/14.
 */
public class Euler_466 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_466().execute();
    }

    @Override
    protected String run() {
        System.out.println(PrimesHelper.factorize(BigInteger.valueOf(1263)));
        return null;
    }
}
