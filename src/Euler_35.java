import util.PrimesHelper;

/**
 * Created by kapturma@04/05/14.
 */
public class Euler_35 extends EulerRunner {

    private static final int LIMIT = 1000000;

    public static void main(String[] args) {
        new Euler_35().execute(100);
    }

    @Override
    protected String run() {
        int circularPrimesCounter = 0;
        boolean[] compoundNumbers = PrimesHelper.getCompoundNumberMarks(LIMIT);
        for (int iter = 2; iter < LIMIT; iter++) {
            if (!compoundNumbers[iter] && !String.valueOf(iter).contains("0")) {
                int tmp = rotate(iter);
                boolean isCircular = true;
                while (tmp != iter) {
                    if (compoundNumbers[tmp])
                        isCircular = false;
                    tmp = rotate(tmp);
                }
                if (isCircular)
                    circularPrimesCounter += 1;
            }
        }
        return String.valueOf(circularPrimesCounter);
    }

    private int rotate(int n) {
        int powOf10 = 1;
        if (n < 10)
            return n;
        int tmp = n;
        while (tmp > 10) {
            powOf10 *= 10;
            tmp /= 10;
        }
        return (n % powOf10) * 10 + n / powOf10;
    }

}
