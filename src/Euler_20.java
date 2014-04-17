import java.math.BigInteger;

/**
 * @author kapturma
 */
public class Euler_20 extends EulerRunner {

	private static final BigInteger TEN = BigInteger.valueOf(10);

	public static void main(String[] args) {
		new Euler_20().execute();
	}

	@Override
	protected String run() {
		BigInteger fac_100 = get100Factorial();
		int sumOfDigits = 0;
		while (fac_100.compareTo(BigInteger.ZERO) == 1) {
			sumOfDigits += fac_100.mod(TEN).intValue();
			fac_100 = fac_100.divide(TEN);
		}
		return String.valueOf(sumOfDigits);
	}

	private BigInteger get100Factorial() {
		BigInteger fac_100 = BigInteger.ONE;
		for (int n = 2; n <= 100; n++) {
			fac_100 = fac_100.multiply(BigInteger.valueOf(n));
		}
		return fac_100;
	}

}
