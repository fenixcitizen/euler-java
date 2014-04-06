import util.PrimesHelper;

/**
 * Created by kapturma@03/04/14.
 */
public class Euler_7 extends EulerRunner {

    private static final int LIMIT = 10001;
    private static int PRIME_LIMIT;
    private static boolean[] isNotPrime;

    public static void main(String[] args) {
        new Euler_7().execute(100);
    }

    @Override
    protected String run() {
        int n = 2;
        while (n / Math.log(n) < LIMIT) {
            n += 13;
        }
        PRIME_LIMIT = n;
        isNotPrime = new boolean[PRIME_LIMIT];
        int step = 2;
        int mult = 2;
        int pl_sqrt = (int) Math.sqrt(PRIME_LIMIT);
        while (step < pl_sqrt) {
            while (step * mult < PRIME_LIMIT) {
                isNotPrime[step * mult] = true;
                mult++;
            }
            step++;
            mult = 2;
        }
        int counter = 0;
        int iter = 2;
        while (counter < LIMIT) {
            if (!isNotPrime[iter]) {
                counter++;
            }
            iter++;
        }
        return String.valueOf(iter - 1);
    }

}
