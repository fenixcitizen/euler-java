import util.PrimesHelper;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author kapturma
 */
public class Euler_23 extends EulerRunner {

	private static final int LIMIT = 28123;

	public static void main(String[] args) {
		new Euler_23().execute();
	}

	@Override
	protected String run() {
		// slow because of BigIntegers used but concise
		List<Integer> abundantNumbers = IntStream.range(12, LIMIT).parallel().boxed().filter(this::isAbundant).collect(Collectors.toList());
		Set<Integer> abundantSums = new HashSet<>();
		for (int k = 0; k < abundantNumbers.size(); k++) {
			for (int l = k; l < abundantNumbers.size(); l++) {
				final int candidate = abundantNumbers.get(k) + abundantNumbers.get(l);
				if (candidate <= LIMIT)
					abundantSums.add(candidate);
			}
		}
		return String.valueOf((LIMIT + 1) * LIMIT / 2 - abundantSums.stream().mapToInt(p -> p).sum());
	}

	private boolean isAbundant(int n) {
		return PrimesHelper.properDivisors(BigInteger.valueOf(n)).stream().mapToInt(BigInteger::intValue).sum() > n;
	}

}
