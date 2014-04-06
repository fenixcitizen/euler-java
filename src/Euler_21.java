import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kapturma@21/03/14.
 */
public class Euler_21 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_21().execute();
    }
    private final static int LIMIT = 10000;

    @Override
    public String run() {
        Collection<Integer> coll = new ArrayList<>();
        for (int n = 0; n < LIMIT; n++) {
            coll.add(n);
        }
        Map<Integer, Integer> amicablePairs = coll.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        n -> {
                            int sumOfProperDivisors = 1;
                            int sqrt_n = (int) Math.sqrt(n);
                            for (int i = 2; i < sqrt_n; i++) {
                                if (n % i == 0) {
                                    sumOfProperDivisors += i;
                                    sumOfProperDivisors += n / i;
                                }
                            }
                            return sumOfProperDivisors;
                        }));

        Integer sumOfAmicableNumbers = amicablePairs.entrySet().stream()
                .filter(entry -> amicablePairs.get(entry.getValue()) != null && !entry.getValue().equals(entry.getKey()) && amicablePairs.get(entry.getValue()).equals(entry.getKey()))
                .collect(Collectors.summingInt(entry -> entry.getKey()));

        return sumOfAmicableNumbers.toString();
    }

}
