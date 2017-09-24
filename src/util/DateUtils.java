package util;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DateUtils {

	public static String getReadableDateString(Calendar date) {
		String year = Integer.toString(date.get(Calendar.YEAR));
		String month = YearMonth.of(Integer.parseInt(year), date.get(Calendar.MONTH) + 1).getMonth().toString();
		String day = Integer.toString(date.get(Calendar.DAY_OF_MONTH));
		return String.format("%s %s, %s", month, day, year);
	}

	public static Calendar today() {
		return Calendar.getInstance();
	}

	public static YearMonth getYearMonthFromDate(Calendar date) {
		return YearMonth.of(date.get(Calendar.YEAR), date.get(Calendar.MONTH) + 1);
	}

	public static String getMonthDayYearFormat(Calendar date) {
		int day = date.get(Calendar.DAY_OF_MONTH);
		int month = date.get(Calendar.MONTH) + 1;
		int year = date.get(Calendar.YEAR);
		String dayString = (day < 10) ? ("0" + day) : Integer.toString(day);
		String monthString = (month < 10) ? ("0" + month) : Integer.toString(month); 
		String yearString = Integer.toString(year).substring(2, 4);
		return String.format("%s/%s/%s", monthString, dayString, yearString);
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

	public static Set<Calendar> getOrderedDateRange(Set<Calendar> dateRange) {
		return dateRange.stream().sorted((date1, date2) -> (int) (date1.getTimeInMillis() - date2.getTimeInMillis()))
					.collect(Collectors.toSet());
	}

	private static void constructDateRange(Calendar startDate, Calendar endDate, Set<Calendar> dateRange) {
		while (!startDate.after(endDate)) {
			dateRange.add(startDate);
			startDate = (Calendar) startDate.clone();
			startDate.set(Calendar.DAY_OF_MONTH, startDate.get(Calendar.DAY_OF_MONTH) + 1);
		}
	}
}
