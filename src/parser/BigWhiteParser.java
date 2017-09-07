package parser;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import model.HotelAvailability;
import model.RoomAvailability;

public class BigWhiteParser implements HotelParser {
	
	private static final String VACANT_IDENTIFIER = "CalendarBackgroundVacant";
	private static final String OCCUPIED_IDENTIFIER = "CalendarBackgroundOccupied";

	public HotelAvailability parse(String page) {
		return null;
	}

	@Override
	public RoomAvailability parseSingleRoomAvailability(String pageText, String roomNumber) {

		Map<Calendar, Boolean> availability = new HashMap<Calendar, Boolean>();

		addAvailableDates(pageText, availability);
		addOccupiedDates(pageText, availability);
		return new RoomAvailability(roomNumber, availability);
	}
	
	private void addAvailableDates(String pageText, Map<Calendar, Boolean> availability) {
		int currentIndex = pageText.indexOf(VACANT_IDENTIFIER);
		while (currentIndex != -1) {
			String dateData = pageText.substring(currentIndex - 12, currentIndex - 2);
			if (!dateData.startsWith("20")) {
				dateData = pageText.substring(currentIndex - 11, currentIndex - 2);
			}
			if (!dateData.startsWith("20")) {
				dateData = pageText.substring(currentIndex - 10, currentIndex - 2);
			}
			if (!dateData.startsWith("20")) {
				currentIndex = pageText.indexOf(VACANT_IDENTIFIER, currentIndex + 1);
				continue;
			}
			String[] date = dateData.split(",");
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]) - 1;
			int day = Integer.parseInt(date[2]);

			currentIndex = pageText.indexOf(VACANT_IDENTIFIER, currentIndex + 1);
			
			Calendar specificDate = new GregorianCalendar(year, month, day);
//			System.out.println("December = " + Calendar.DECEMBER);
//			System.out.println("Adding available date: year = " + year + ", month = " + month + ", day = " + day);
			availability.put(specificDate, true);
		}
	}

	private void addOccupiedDates(String pageText, Map<Calendar, Boolean> availability) {
		int currentIndex = pageText.indexOf(OCCUPIED_IDENTIFIER);
		while (currentIndex != -1) {
			String dateData = pageText.substring(currentIndex - 12, currentIndex - 2);
			if (!dateData.startsWith("20")) {
				dateData = pageText.substring(currentIndex - 11, currentIndex - 2);
			}
			if (!dateData.startsWith("20")) {
				dateData = pageText.substring(currentIndex - 10, currentIndex - 2);
			}
			if (!dateData.startsWith("20")) {
				currentIndex = pageText.indexOf(OCCUPIED_IDENTIFIER, currentIndex + 1);
				continue;
			}
			String[] date = dateData.split(",");
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]) - 1;
			int day = Integer.parseInt(date[2]);

			currentIndex = pageText.indexOf(OCCUPIED_IDENTIFIER, currentIndex + 1);
			
			Calendar specificDate = new GregorianCalendar(year, month, day);
			availability.put(specificDate, false);
		}
	}

//	private void addNegativeAvailabilities(Map<MonthDay, Boolean> availability, year, monthDay) {
//		GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(year), monthDay.getMonthValue(), 1);
//		int totalDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//	}

//	public static String parseAvailableDatesFromPageIntoString(String pageText, String roomNumber) {
//	StringBuffer buffer = new StringBuffer();
//
//	buffer.append("For room number " + roomNumber + ":\n\n");
//
//	int currentIndex = pageText.indexOf(VACANT_IDENTIFIER);
//	while (currentIndex != -1) {
//		String dateData = pageText.substring(currentIndex - 12, currentIndex - 2);
//		if (!dateData.startsWith("20")) {
//			dateData = pageText.substring(currentIndex - 11, currentIndex - 2);
//		}
//		if (!dateData.startsWith("20")) {
//			dateData = pageText.substring(currentIndex - 10, currentIndex - 2);
//		}
//		if (!dateData.startsWith("20")) {
//			currentIndex = pageText.indexOf(VACANT_IDENTIFIER, currentIndex + 1);
//			continue;
//		}
//		String[] date = dateData.split(",");
//		String year = date[0];
//		String month = date[1];
//		String day = date[2];
//
//		currentIndex = pageText.indexOf(VACANT_IDENTIFIER, currentIndex + 1);
//		String formattedDate = year + '/' + month + '/' + day;
//		buffer.append(formattedDate + '\n');
//	}
//	buffer.append("\n\n");
//	return buffer.toString();
//}
}
