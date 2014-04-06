import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by kapturma@22/03/14.
 */
public class Euler_26 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_26().execute();
    }

    @Override
    protected String run() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(-3);
        list.add(2);
        list.add(6);
        list.add(0);
        Collections.sort(list, Integer::compareTo);
        Collection<Integer> coll = new ArrayList<>();
        for (int n = 0; n < 101; n++) {
            coll.add(n);
        }
        System.out.println(coll.parallelStream().mapToInt(n -> n).sequential().average());


        return null;
    }

}
