import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapturma@01/04/14.
 */
public class Euler_5 extends EulerRunner {

    private static final Integer LIMIT = 1000;

    public static void main(String[] args) {
        new Euler_5().execute();
    }


    @Override
    protected String run() {
        ArrayList divisors = new ArrayList();
        for (Long i = 1l; i < LIMIT; i++) {
            divisors.add(i);
        }
        return String.valueOf(lcm(divisors));
    }

    private static Long lcm(Long a, Long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    private static Long lcm(List<Long> a_i) {
        return a_i.size() > 2 ? lcm(a_i.get(0), lcm(a_i.subList(1, a_i.size()))) : lcm(a_i.get(0), a_i.get(1));
    }

}
