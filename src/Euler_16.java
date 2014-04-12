import util.PrimesHelper;

import java.math.BigInteger;

/**
 * Created by kapturma@12/04/14.
 */
public class Euler_16 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_16().execute();
    }

    @Override
    protected String run() {
        BigInteger pow = BigInteger.ONE.add(BigInteger.ONE).pow(1000);
        int sumOfDigits = 0;
        String powString = pow.toString();
        for (int i = 0; i < powString.length(); ++i) {
            char c = powString.charAt(i);
            sumOfDigits += (c - '0');
        }
        return String.valueOf(sumOfDigits);
    }

}
