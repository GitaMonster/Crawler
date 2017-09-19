package util;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DateUtils {

	public static String getReadableDateString(Calendar date) {
		String year = Integer.toString(date.get(Calendar.YEAR));
		String month = YearMonth.of(Integer.parseInt(year), date.get(Calendar.MONTH) + 1).getMonth().toString();
		String day = Integer.toString(date.get(Calendar.DAY_OF_MONTH));
		return String.format("%s %s, %s", month, day, year);
	}

	public static Set<Calendar> getDateRange(Calendar startDate, Calendar endDate) {
		Set<Calendar> dateRange = new HashSet<Calendar>();
		constructDateRange(startDate, endDate, dateRange);
		return dateRange;
	}

	public static Set<Calendar> getOrderedDateRange(Calendar startDate, Calendar endDate) {
		Set<Calendar> dateRange = new LinkedHashSet<Calendar>();
		constructDateRange(startDate, endDate, dateRange);
		return dateRange;
	}

	private static void constructDateRange(Calendar startDate, Calendar endDate, Set<Calendar> dateRange) {
		while (!startDate.after(endDate)) {
			dateRange.add(startDate);
			startDate = (Calendar) startDate.clone();
			startDate.set(Calendar.DAY_OF_MONTH, startDate.get(Calendar.DAY_OF_MONTH) + 1);
		}
	}
}