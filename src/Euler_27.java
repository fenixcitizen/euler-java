import java.util.Arrays;

/**
 * Created by kapturma@26/04/14.
 */
public class Euler_27 extends EulerRunner {

    private static final int LIMIT = 1000000;
    private static boolean[] primes = new boolean[LIMIT];

    public static void main(String[] args) {
        new Euler_27().execute();
    }

    @Override
    protected String run() {
        fillSieve();
        int maxPrimes = 0, abProduct = 0;
        for (int a = -999; a < 999; a++) {
            for (int b = -999; b < 999; b++) {
                if (primes[Math.abs(b)]) {
                    int primesProduced = calculatePrimesProduced(a, b);
                    if (primesProduced > maxPrimes) {
                        maxPrimes = primesProduced;
                        abProduct = a * b;
                    }
                }
            }
        }
        return String.valueOf(abProduct);
    }

    private int calculatePrimesProduced(int a, int b) {
        int primesProduced = 1;
        int n = 1;
        while ((n < b) && (primes[Math.abs(n * n + a * n + b)])) {
            primesProduced++;
            n++;
        }
        return primesProduced;
    }

    //set up the primesieve
    public static void fillSieve() {
        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 2; i < primes.length; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

}
