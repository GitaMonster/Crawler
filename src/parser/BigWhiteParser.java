package parser;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import model.HotelAvailability;
import model.RoomAvailability;

public class BigWhiteParser implements HotelParser {
	
	private static final String VACANT_IDENTIFIER = "CalendarBackgroundVacant";
	private static final String OCCUPIED_IDENTIFIER = "CalendarBackgroundOccupied";
	private static final String BLOCKED_IDENTIFIER = "CalendarBackgroundBlocked";

	public HotelAvailability parse(String page) {
		return null;
	}

	@Override
	public RoomAvailability parseSingleRoomAvailability(String pageText, String roomNumber) {

		Map<Calendar, Optional<Boolean>> availability = new HashMap<Calendar, Optional<Boolean>>();

		addDates(pageText, availability, VACANT_IDENTIFIER, Optional.of(true));
		addDates(pageText, availability, OCCUPIED_IDENTIFIER, Optional.of(false));
		addDates(pageText, availability, BLOCKED_IDENTIFIER, Optional.empty());
		return new RoomAvailability(roomNumber, availability);
	}
	
	private void addDates(String pageText, Map<Calendar, Optional<Boolean>> availability, String identifier, Optional<Boolean> markAsAvailable) {
		int currentIndex = pageText.indexOf(identifier);
		while (currentIndex != -1) {
			String dateData = pageText.substring(currentIndex - 12, currentIndex - 2);
			if (!dateData.startsWith("20")) {
				dateData = pageText.substring(currentIndex - 11, currentIndex - 2);
			}
			if (!dateData.startsWith("20")) {
				dateData = pageText.substring(currentIndex - 10, currentIndex - 2);
			}
			if (!dateData.startsWith("20")) {
				currentIndex = pageText.indexOf(identifier, currentIndex + 1);
				continue;
			}
			String[] date = dateData.split(",");
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]) - 1;
			int day = Integer.parseInt(date[2]);

			currentIndex = pageText.indexOf(identifier, currentIndex + 1);

			Calendar specificDate = new GregorianCalendar(year, month, day);
			availability.put(specificDate, markAsAvailable);
		}
	}
}
