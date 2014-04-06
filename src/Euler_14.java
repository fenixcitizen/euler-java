/**
 * Created by kapturma@06/04/14.
 */
public class Euler_14 extends EulerRunner {

    private static long LIMIT = 1000000;

    public static void main(String[] args) {
        new Euler_14().execute();
    }

    @Override
    protected String run() {
        long maxCycle = 0;
        for (long iter = 13; iter < LIMIT; iter++) {
            long currentValue = iter, currentCycleLength = 1;
            while (currentValue != 1) {
                currentValue = getNextNumber(currentValue);
                currentCycleLength++;
            }

            if (currentCycleLength > maxCycle) {
                maxCycle = currentCycleLength;
            }
        }
        return String.valueOf(maxCycle);
    }

    private static long getNextNumber(long n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }
}
