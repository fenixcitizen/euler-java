/**
 * Created by kapturma@12/04/14.
 */
public class Euler_92 extends EulerRunner {

    private static final int LIMIT = 10000000;
    private static final int CACHE_SIZE = 81 * 7; // second number is always smaller than that
    private static boolean[] _89_Hitters = new boolean[CACHE_SIZE];

    public static void main(String[] args) {
        new Euler_92().execute();
    }

    @Override
    protected String run() {
        int counter = 0;
        int iter = 1;
        while (iter < LIMIT) {
            if (hits89(iter))
                counter++;
            iter++;
        }
        return String.valueOf(counter);
    }

    private boolean hits89(int start) {
        int currentIter = start;
        currentIter = calculateNextChainNumber(currentIter);
        int secondIter = currentIter;
        if (_89_Hitters[secondIter - 1]) { // just check the second number found - checking every time is very time consuming
            return true;
        }
        while (currentIter != 1 && currentIter != 89) {
            currentIter = calculateNextChainNumber(currentIter);
        }
        final boolean hits89 = currentIter == 89;
        if (hits89)
            _89_Hitters[secondIter - 1] = true;
        return hits89;
    }

    private int calculateNextChainNumber(int currentIter) {
        int currentSubIter = currentIter;
        int sumOfSquareDigits = 0;
        while (currentSubIter != 0) {
            final int lastDigit = currentSubIter % 10;
            sumOfSquareDigits += (lastDigit * lastDigit);
            currentSubIter /= 10;
        }
        currentIter = sumOfSquareDigits;
        return currentIter;
    }

}
