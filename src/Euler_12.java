import util.PrimesHelper;

import java.math.BigInteger;

/**
 * Created by kapturma@12/04/14.
 */
public class Euler_12 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_12().execute();
    }

    @Override
    protected String run() {
        int currentTriangleNumber = 1;
        int iter = 2;
        while (PrimesHelper.numOfDivisors(BigInteger.valueOf(currentTriangleNumber), 1) < 500) {
            currentTriangleNumber += iter;
            iter++;
        }
        return String.valueOf(currentTriangleNumber);
    }

}
