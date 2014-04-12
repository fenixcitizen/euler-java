/**
 * Created by kapturma@22/03/14.
 */
public abstract class EulerRunner {

    protected void execute() {
        long start = System.currentTimeMillis();
        String output = this.run();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start) + " miliseconds.");
        System.out.println("Solution is: " + output);
    }

    protected void execute(int n) {
        int iter = 0;
        long start = System.nanoTime();
        while (iter < n) {
            this.run();
            iter++;
        }
        String output = this.run();
        System.out.println("Avg time elapsed=" + ": " + ((System.nanoTime() - start) / (n + 1)) + " nanoseconds.");
        System.out.println("Solution is: " + output);
    }

    protected abstract String run();

}
