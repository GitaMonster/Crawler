package parser;

import java.io.IOException;
import java.util.Map;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import model.HotelAvailability;
import model.RoomAvailability;

public class WalnutBeachParser implements HotelParser {
	
	@Override
	public HotelAvailability parse(String page) {
		return null;
	}
	
	@Override
	public RoomAvailability parseSingleRoomAvailability(String page, String roomNumber) throws IOException {
		Map<Calendar, Boolean> totalRoomAvailability = new HashMap<Calendar, Boolean>();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode root = objectMapper.readTree(page);

		ArrayNode dates = (ArrayNode) root.get("dates");

		dates.forEach(dateAvailability -> {
			String date = dateAvailability.get("date").asText();
			boolean isAvailable = dateAvailability.get("isAvailable").booleanValue();
			String[] dateParts = date.split("-");
			int year = Integer.parseInt(dateParts[0]);
			int month = Integer.parseInt(dateParts[1]) - 1;
			int day = Integer.parseInt(dateParts[2]);

			Calendar specificDate = new GregorianCalendar(year, month, day);
			totalRoomAvailability.put(specificDate, isAvailable);
		});
		return new RoomAvailability(roomNumber, totalRoomAvailability);
	}
}
