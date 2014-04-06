package util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigInteger.*;

/**
 * Created by kapturma@29/03/14.
 */
public class PrimesHelper {
    private static final BigInteger TWO = new BigInteger("2");

    /**
     * A function to obtain prime factors of a given number n
     *
     * @param n input integer number
     * @return map of divisors and its frequencies after factorization
     */
    public static Map<Integer, Integer> factorize(BigInteger n) {
        Map<Integer, Integer> primeFactors = new HashMap<>();
        n = reduceWithDivision(n, primeFactors, TWO);
        int sqrt_n = (int) Math.sqrt(n.doubleValue());
        // n must be odd at this point. So we can skip one element (Note i = i + 2)
        for (Integer i = 3; i <= sqrt_n; i = i + 2) {
            n = reduceWithDivision(n, primeFactors, BigInteger.valueOf(i));
        }
        // This condition is to handle the case when n is a prime number greater than 2
        if (n.compareTo(TWO) > 0)
            primeFactors.put(n.intValue(), 1);
        return primeFactors;
    }

    private static BigInteger reduceWithDivision(BigInteger n, Map<Integer, Integer> primeFactors, BigInteger divisor) {
        if (n.mod(divisor).equals(ZERO)) {
            primeFactors.put(divisor.intValue(), 0);
            int alpha_k = 0;
            while (n.mod(divisor).equals(ZERO)) {
                alpha_k++;
                n = n.divide(divisor);
            }
            primeFactors.put(divisor.intValue(), alpha_k);
        }
        return n;
    }

    /**
     * A function to obtain number of unique divisors of a given number n
     *
     * @param n input integer number
     * @return number of unique divisors
     */
    public static Integer numberOfUniqueDivisors(BigInteger n) {
        Integer numberOfUniqueDivisors = 0;
        if (n.mod(TWO).equals(ZERO)) {
            numberOfUniqueDivisors++;
            while (n.mod(TWO).equals(ZERO)) {
                n = n.divide(TWO);
            }
        }
        int sqrt_n = (int) Math.sqrt(n.doubleValue());
        // n must be odd at this point. So we can skip one element (Note i = i + 2)
        for (Integer i = 3; i <= sqrt_n; i = i + 2) {
            BigInteger divisor = BigInteger.valueOf(i);
            if (n.mod(divisor).equals(ZERO)) {
                numberOfUniqueDivisors++;
                while (n.mod(divisor).equals(ZERO)) {
                    n = n.divide(divisor);
                }
            }
        }
        // This condition is to handle the case when n is a prime number greater than 2
        if (n.compareTo(TWO) > 0)
            numberOfUniqueDivisors++;
        return numberOfUniqueDivisors;
    }

    /**
     * A function to obtain number of divisors of a n^power
     *
     * @param n input integer number
     * @return number of divisors
     */
    public static Integer numOfDivisors(BigInteger n, Integer power) {
        Map<Integer, Integer> primeFactors = new HashMap<>();
        n = reduceWithDivision(n, primeFactors, TWO);
        int sqrt_n = (int) Math.sqrt(n.doubleValue());
        // n must be odd at this point. So we can skip one element (Note i = i + 2)
        for (Integer i = 3; i <= sqrt_n; i = i + 2) {
            n = reduceWithDivision(n, primeFactors, BigInteger.valueOf(i));
        }
        // This condition is to handle the case when n is a prime number greater than 2
        if (n.compareTo(TWO) > 0)
            primeFactors.put(n.intValue(), 1);
        Integer numOfDivisors = 1;
        for (Integer alpha_k : primeFactors.values()) {
            numOfDivisors *= (power * alpha_k + 1);
        }
        return numOfDivisors;
    }

    public static BigInteger GCD(BigInteger a, BigInteger b) {
        if (a.signum() == 0)
            return b;
        if (b.signum() == 0) {
            return a;
        }
        while (!a.equals(ZERO)) {
            if (a.compareTo(b) == -1) {
                b = b.mod(a);
            } else {
                BigInteger tmp = a;
                a = b;
                b = tmp.subtract(b);
            }
        }
        return b;
    }

    public static boolean[] getCompoundNumberMarks(int primeLimit) {
        boolean[] compounds = new boolean[primeLimit];
        compounds[0] = true;
        compounds[1] = true;
        int currentPrime = 2;
        int pl_sqrt = (int) Math.sqrt(primeLimit);
        while (currentPrime <= pl_sqrt) {
            int multiple = currentPrime + currentPrime;
            while (multiple < primeLimit) {
                compounds[multiple] = true;
                multiple += currentPrime;
            }
            currentPrime++;
            while (compounds[currentPrime]) {
                currentPrime++;
            }
        }
        return compounds;
    }

}
