/**
 * Created by kapturma@22/03/14.
 */
public abstract class EulerRunner {

    protected static int STEP = 1;

    protected void execute() {
        long start = System.currentTimeMillis();
        String output = this.run();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start) + " miliseconds.");
        System.out.println("Solution is: " + output);
    }

    protected void execute(int n) {
        int iter = 0;
        String output;
        long start = System.currentTimeMillis();
        while (iter < n) {
            this.run();
            iter++;
        }
        output = this.run();
        System.out.println("Avg time elapsed=" + ": " + ((System.currentTimeMillis() - start) / (n + 1)) + " miliseconds.");
        System.out.println("Solution is: " + output);
    }

    protected abstract String run();

}
