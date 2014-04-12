/**
 * Created by kapturma@12/04/14.
 */
public class Euler_4 extends EulerRunner {

    public static final int UPPER_LIMIT = 999;
    public static final int LOWER_LIMIT = 99;

    public static void main(String[] args) {
        new Euler_4().execute(100000);
    }

    @Override
    protected String run() {
        int largestPalindrom = 0;
        for (int k = UPPER_LIMIT; k > LOWER_LIMIT; k--) {
            int REFINED_UPPER_LIMIT = UPPER_LIMIT;
            int dm = 1;
            if (!(k % 11 == 0)) { // this trick is taken from problem overview
                REFINED_UPPER_LIMIT = UPPER_LIMIT - UPPER_LIMIT % 11;
                dm = 11;
            }
            for (int m = REFINED_UPPER_LIMIT; m > k; m -= dm) {
                int candidate = k * m;
                if (candidate > largestPalindrom && isPalindrom(candidate)) {
                    largestPalindrom = candidate;
                }
            }
        }
        return String.valueOf(largestPalindrom);
    }

    private static boolean isPalindrom(int n) {
        final byte DIGIT_NUMBER = 10;
        final byte[] digits = new byte[DIGIT_NUMBER]; // because n \in [-2,147,483,648, 2,147,483,647]
        byte k = DIGIT_NUMBER - 1;
        while (n != 0) {
            digits[k] = (byte) (n % 10);
            n /= 10;
            k--;
        }
        byte m = DIGIT_NUMBER - 1;
        k++;
        while (k < DIGIT_NUMBER) {
            if (digits[k] != digits[m])
                return false;
            m--;
            k++;
        }
        return true;
    }

}
