import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author kapturma
 */
public class Euler_19 extends EulerRunner {

	public static void main(String[] args) {
		new Euler_19().execute();
	}

	@Override
	protected String run() {
		int sundaysOnFirstDayOfMonth = 0;
		Calendar calendar = new GregorianCalendar();
		for (int year = 1; year <= 100; year++) {
			for (int month = 1; month <= 12; month++) {
				calendar.set(1900 + year, month, 1);
				if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
					sundaysOnFirstDayOfMonth++;
				}
			}
		}
		return String.valueOf(sundaysOnFirstDayOfMonth);
	}
}
