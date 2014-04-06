/**
 * Created by kapturma@06/04/14.
 */
public class Euler_14 extends EulerRunner {

    private static int LIMIT = 1000000;

    public static void main(String[] args) {
        new Euler_14().execute();
    }

    @Override
    protected String run() {
        int maxCycleLength = 0;
        int maxCycleStartingNumber = 0;
        int[] cache = new int[LIMIT];
        cache[1] = 1;
        for (int iter = 2; iter < LIMIT; iter++) {
            long currentValue = iter;
            int currentCycleLength = 1;
            while (currentValue != 1 && currentValue >= iter) {
                currentValue = getNextNumber(currentValue);
                currentCycleLength++;
            }
            cache[iter] = currentCycleLength + cache[(int) currentValue];
            if (cache[iter] > maxCycleLength) {
                maxCycleLength = cache[iter];
                maxCycleStartingNumber = iter;
            }
        }
        return String.valueOf(maxCycleStartingNumber);
    }

    private static long getNextNumber(long n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

}
