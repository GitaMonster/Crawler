package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import model.HotelAvailability;
import model.HotelName;
import model.RoomAvailability;
import parser.WalnutBeachParser;

public class WalnutBeach {

	private static final int MAX_SPAN_OF_DATES_IN_REQUEST = 90;
	private static final int MAX_NUM_OF_DAYS_INTO_FUTURE_HOTEL_KEEPS_DATA = 400;
	private static final Map<Integer, String> ROOM_CODES = new HashMap<>();
	static {
		ROOM_CODES.put(90891, "Chardonnay Studio Suite Mountain View");
        ROOM_CODES.put(117454, "Chardonnay Studio Lakeview");
		ROOM_CODES.put(117452, "Sauvignon One Bedroom Mountainview");
        ROOM_CODES.put(117455, "Pinot One Bedroom with Den Mountainview");
        ROOM_CODES.put(90892, "Sauvignon One Bedroom Lakeview");
        ROOM_CODES.put(90894, "Shiraz Two Bedroom Lakeview");
        ROOM_CODES.put(117453, "Gamay Two Bedroom Lakeview");
	}

	public static void main(String[] args) throws Exception {
		HotelAvailability avail = getAvailability();
		RoomAvailability chardRoomAvail = avail.getRoomAvailabilities().get("Chardonnay Studio Suite Mountain View");
		Calendar chardEarliest = chardRoomAvail.getEarliestKnownDate();
		Calendar chardLatest = chardRoomAvail.getLatestKnownDate();
		System.out.println("Earliest date = " + chardEarliest.get(Calendar.DAY_OF_MONTH) + "/" + (chardEarliest.get(Calendar.MONTH) + 1) + "/" + chardEarliest.get(Calendar.YEAR));
		System.out.println("Latest date = " + chardLatest.get(Calendar.DAY_OF_MONTH) + "/" + (chardLatest.get(Calendar.MONTH) + 1) + "/" + chardLatest.get(Calendar.YEAR));
	}

	public static HotelAvailability getAvailability() throws MalformedURLException, IOException {
		WalnutBeachParser parser = new WalnutBeachParser();
		Map<String, RoomAvailability> roomAvailabilities = new HashMap<String, RoomAvailability>();

		String url = "https://api.travelclick.com/ibe/v1/hotel/15158/basicavail/multi-room";
		for (int roomCode : ROOM_CODES.keySet()) {
			String postBody = "{\"hotelCode\":15158,\"lang\":\"EN_US\",\"ratePlanCode\":\"1685332\",\"ratePlanType\":\"Regular\",\"dateIn\":\"2017-09-19\",\"dateOut\":\"2017-12-05\",\"multiRoomOccupancy\":[{\"adults\":\"1\",\"children\":0}],\"roomTypeCode\":\"" + roomCode + "\",\"preFetch\":true}";
			String page = getPage(url, postBody);
			RoomAvailability roomAvailability = parser.parseSingleRoomAvailability(page, ROOM_CODES.get(roomCode));
			roomAvailabilities.put(roomAvailability.getRoomNumber(), roomAvailability);
		}

		return new HotelAvailability(HotelName.WALNUT_BEACH_DEFAULT, roomAvailabilities);
	}

	public static String getPage(String urlString, String postBody) throws MalformedURLException, IOException {
		StringBuffer jsonString;
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.write(postBody);
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		jsonString = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			jsonString.append(line);
		}
		br.close();
		connection.disconnect();
		return jsonString.toString();
	}
}
