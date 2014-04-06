import java.math.BigInteger;

/**
 * Created by kapturma@22/03/14.
 */
public class Euler_25 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_25().execute();
    }

    @Override
    protected String run() {
        return has1000Digits(BigInteger.ONE, BigInteger.ONE, 3);
    }

    private static String has1000Digits(BigInteger fn_2, BigInteger fn_1, Integer counter) {
        BigInteger fn = fn_2.add(fn_1);
        if (fn.toString().length() >= 1000) {
            return counter.toString();
        }
        return has1000Digits(fn_1, fn, counter + 1);
    }

}
