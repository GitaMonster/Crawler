package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.ResortAvailability;
import model.RoomAvailability;
import util.DateUtils;
import util.Symbols;

public class Crawler {

	private static final String LEAVE_TOWN_POST_DATA_PATH = System.getProperty("user.dir") + "/resources/leavetownPostData/";
	private static final String AVAILABILITY_TEMPLATE_CODE = "____AVAILABILITY____";
	private static final String START_DATE_TEMPLATE_CODE = "____START_DATE____";
	private static final String END_DATE_TEMPLATE_CODE = "____END_DATE____";

	public static void main(String[] args) throws Exception {
		String postBodyTemplate = new String(Files.readAllBytes(Paths.get(LEAVE_TOWN_POST_DATA_PATH + "cirrusRequestBodyTemplate.txt")));

		ResortAvailability resortAvailability = BigWhite.getResortAvailability();
		postResortAvailabilityToLeaveTown(resortAvailability, postBodyTemplate);
	}

	// This assumes dates have already been trimmed to desired length
	private static void postResortAvailabilityToLeaveTown(ResortAvailability resortAvailability,
			String cirrusRequestBodyTemplate) throws MalformedURLException, IOException {

		Calendar startDate = resortAvailability.getEarliestKnownDate();
		Calendar endDate = resortAvailability.getLatestKnownDate();

		Map<String, String> propertyIdMap = getTestPropertyIdMap();
		for (Entry<String, String> entry : propertyIdMap.entrySet()) {
			String roomDescription = entry.getKey();
			String propertyId = entry.getValue();

			Set<RoomAvailability> roomAvailabilities = BigWhite.getRoomAvailabilitiesForProperty(resortAvailability, roomDescription);
			if (!roomAvailabilities.isEmpty()) {
				System.out.println("\nPosting availability for " + roomDescription + "; property id = " + propertyId);
				Map<Calendar, Optional<Boolean>> propertyAvailability = BigWhite.convertToPropertyAvailability(roomAvailabilities,
						startDate, endDate);
				postPropertyAvailability(propertyAvailability, propertyId, cirrusRequestBodyTemplate,
						startDate, endDate);
			}
		}
	}

	private static void postPropertyAvailability(Map<Calendar, Optional<Boolean>> propertyAvailability, String propertyId,
			String cirrusRequestBodyTemplate, Calendar startDate, Calendar endDate) throws MalformedURLException, IOException {
		
		String availabilityBlock = convertToCSV(propertyAvailability, startDate, endDate);
		String availabilityRendered = cirrusRequestBodyTemplate.replaceAll(AVAILABILITY_TEMPLATE_CODE, availabilityBlock);

		String startDateString = DateUtils.getMonthDayYearFormat(startDate);
		String endDateString = DateUtils.getMonthDayYearFormat(endDate);
		String startDateRendered = availabilityRendered.replaceAll(START_DATE_TEMPLATE_CODE, startDateString);
		String endDateRendered = startDateRendered.replaceAll(END_DATE_TEMPLATE_CODE, endDateString);

		postToLeavetown(propertyId, endDateRendered);
	}

	private static void postToLeavetown(String propertyId, String postBody) throws MalformedURLException, IOException {
		StringBuffer resultText;
		String urlString = "https://cirrus.leavetown.com/property-detail.aspx?propertyid=" + propertyId;
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
	
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		connection.setRequestProperty("Content-type", "multipart/form-data; boundary=----WebKitFormBoundaryP344hY411nA3LwwK");
		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=jvw0udyjeijhb1br2y5uo1lf; Login.Username=chloe@leavetown.com; .ASPXAUTH=36636BD1FD6C986F17041DBA11D2853C032BF1441C99826EF398126C18FFC451B6A599378A81A7933B0931FA324504AD1DA81EA0E3AB241351C3355CCB7973F0EAB4D47F14A0A78048D6A3A644FFEBB9DA1087C6D7C3A6BFFCB4334BCBFB943C86686C3248DC696C87AA82601D8258013796D133FDB347441146D2742824B213; _ga=GA1.3.679933037.1506233851; _gid=GA1.3.51340828.1506233851; _gali=ContentPlaceHolder1_btnAvailabilityPricing");
		connection.setRequestProperty("Origin", "https://cirrus.leavetown.com");
		connection.setRequestProperty("Referer", "https://cirrus.leavetown.com/property-detail.aspx?propertyid=" + propertyId);

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.write(postBody);
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		resultText = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			resultText.append(line);
		}
		br.close();
		System.out.println("\nPosting complete, response code = " + connection.getResponseCode());
		connection.disconnect();
	}

	private static Map<String, String> getTestPropertyIdMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Budget", "374");

		return map;
	}

	// Note: this returns a map that is the reverse of the json file, with format (roomDescription : propertyId)
	private static Map<String, String> getPropertyIdMap() throws IOException {
		Map<String, String> propertyIdMap = new HashMap<String, String>();
		String fileText = new String(Files.readAllBytes(Paths.get(LEAVE_TOWN_POST_DATA_PATH + "propertyIDMappings.json")));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode root = objectMapper.readTree(fileText);

		root.fields().forEachRemaining(field -> {
			String propertyId = field.getKey();
			String roomDescription = field.getValue().asText();
			propertyIdMap.put(propertyId, roomDescription);
		});

		Map<String, Integer> roomDescriptionCounts = new HashMap<String, Integer>();
		propertyIdMap.forEach((propertyId, roomDescription) -> {
			if (roomDescriptionCounts.containsKey(roomDescription)) {
				Integer formerValue = roomDescriptionCounts.get(roomDescription);
				roomDescriptionCounts.put(roomDescription, formerValue + 1);
			} else {
				roomDescriptionCounts.put(roomDescription, 1);
			}
		});

		// filter out duplicates
		Map<String, String> reverseMap = new HashMap<String, String>();
		propertyIdMap.forEach((propertyId, roomDescription) -> {
			if (roomDescriptionCounts.get(roomDescription) == 1) {
				reverseMap.put(roomDescription, propertyId);
			}
		});
		return reverseMap;
	}

	private static String convertToCSV(Map<Calendar, Optional<Boolean>> totalAvailability, Calendar startDate, Calendar endDate) {
		StringBuffer csvString = new StringBuffer();
		csvString.append("Availability,");

		Set<Calendar> dateRange = DateUtils.getOrderedDateRange(startDate, endDate);

		dateRange.forEach(date -> {
			Optional<Boolean> isAvailable = totalAvailability.get(date);
			csvString.append(Symbols.getDisplaySymbol(isAvailable).trim());
			csvString.append(',');
		});
		return csvString.toString();
	}
}
