package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import model.HotelAvailability;
import model.HotelName;
import model.ResortAvailability;
import model.ResortName;
import model.RoomAvailability;
import parser.BigWhiteParser;
import util.DateUtils;
import util.ExcelWriter;

public class BigWhite {

	private static final boolean AGGREGATE_ROOM_TYPES = true;
	private static final String PATH_TO_HOTELS_DIRECTORY = System.getProperty("user.dir") + "/resources/resortData/BigWhite/";
	public static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2017, 10, 22);
	public static final Calendar FINAL_DATE_OF_SEASON = new GregorianCalendar(2018, 3, 7);

	private static final String ROOM_NUMBERS_KEY = "rooms";
	private static final String PROPERTY_CODE_KEY = "propertyCode";
	private static final String ROOM_NUMBER_CODE_KEY = "roomNumberCode";
	private static final String RESORT_CODE_KEY = "resortCode";

	@SuppressWarnings("serial")
	private static final Set<HotelName> HOTELS_TO_GET = new LinkedHashSet<HotelName>() {{
		add(HotelName.BIG_WHITE_BEARS_PAW);
		add(HotelName.BIG_WHITE_BLACK_BEAR);
		add(HotelName.BIG_WHITE_BULLET_CREEK);
		add(HotelName.BIG_WHITE_CHATEAU_RIDGE);
		add(HotelName.BIG_WHITE_COPPER_KETTLE);
		add(HotelName.BIG_WHITE_EAGLES);
		add(HotelName.BIG_WHITE_GRIZZLY);
		add(HotelName.BIG_WHITE_PLAZA_RIDGE);
		add(HotelName.BIG_WHITE_PTARMINGAN);
		add(HotelName.BIG_WHITE_SNOWY_CREEK);
		add(HotelName.BIG_WHITE_STONEBRIDGE);
		add(HotelName.BIG_WHITE_STONEGATE);
		add(HotelName.BIG_WHITE_SUNDANCE);
		add(HotelName.BIG_WHITE_TOWERING_PINES);
		add(HotelName.BIG_WHITE_TRAPPERS_CROSSING);
		add(HotelName.BIG_WHITE_WHITEFOOT);
	}};

	public static void main2(String[] args) throws Exception {
		Calendar startDate = FIRST_DATE_OF_SEASON;
		Calendar endDate = FINAL_DATE_OF_SEASON;

		for (HotelName hotel : HOTELS_TO_GET) {
			HotelAvailability hotelAvailability = getAvailabilityForHotel(hotel, startDate, endDate);

			if (AGGREGATE_ROOM_TYPES) {
				Map<String, RoomAvailability> roomAvailabilities = hotelAvailability.getRoomAvailabilities();
				Map<String, RoomAvailability> aggregatedRoomAvailabilities = getAggregatedAvailabilitiesForRoomType(roomAvailabilities, startDate, endDate);
				hotelAvailability.setRoomAvailabilities(aggregatedRoomAvailabilities);
			}

			ExcelWriter.writeHotelAvailability(hotelAvailability);
		}
    }

	/***
	 * Gets the availability for all of Big White (Warning, it can take a long time)
	 *
	 * @param startDate
	 * @param endDate
	 * @return Resort Availability
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static ResortAvailability getResortAvailability(Calendar startDate, Calendar endDate) throws MalformedURLException, IOException {
		Set<HotelAvailability> acquiredHotelAvailabilities = new HashSet<HotelAvailability>();
		for (HotelName hotel : HOTELS_TO_GET) {
			acquiredHotelAvailabilities.add(getAvailabilityForHotel(hotel, startDate, endDate));
		}

		Map<HotelName, HotelAvailability> hotelAvailabilities = new HashMap<HotelName, HotelAvailability>();
		acquiredHotelAvailabilities.forEach(hotelAvailability -> hotelAvailabilities.put(hotelAvailability.getName(), hotelAvailability));

		return new ResortAvailability(ResortName.BIG_WHITE, hotelAvailabilities);
	}

	public static ResortAvailability getResortAvailability() throws MalformedURLException, IOException {
		return getResortAvailability(FIRST_DATE_OF_SEASON, FINAL_DATE_OF_SEASON);
	}

	@SuppressWarnings("unchecked")
	public static HotelAvailability getAvailabilityForHotel(HotelName hotelName, Calendar startDate,
			Calendar endDate) throws MalformedURLException, IOException {
		Map<String, Object> roomsData = new HashMap<String, Object>();
		readRoomDataFromFile(PATH_TO_HOTELS_DIRECTORY + hotelName.getName() + ".json", roomsData);
		List<String> fullRoomNumbers = (List<String>) roomsData.get(ROOM_NUMBERS_KEY);
		Optional<Object> propertyCode = roomsData.get(PROPERTY_CODE_KEY) == null ? Optional.empty() : Optional.of(roomsData.get(PROPERTY_CODE_KEY));
		String roomNumberCode = (String) roomsData.get(ROOM_NUMBER_CODE_KEY);
		String resortCode = (String) roomsData.get(RESORT_CODE_KEY);

		HotelAvailability hotelAvailability = new HotelAvailability(hotelName);
		List<Calendar> requestDates = calculateRequestDates(startDate, endDate);

		for (Calendar requestDate : requestDates) {
			addAvailabilityAroundDate(hotelAvailability, fullRoomNumbers, resortCode, requestDate, propertyCode, roomNumberCode);
		}
		hotelAvailability.trimDateRange(startDate, endDate);

		System.out.println("\nEarliest available date for " + hotelName.getName() + ": " + DateUtils.getReadableDateString(hotelAvailability.getEarliestKnownDate()));
		System.out.println("Latest available date for " + hotelName.getName() + ": " + DateUtils.getReadableDateString(hotelAvailability.getLatestKnownDate()) + "\n");
		return hotelAvailability;
	}

	public static void addAvailabilityAroundDate(HotelAvailability hotelAvailability, List<String> fullRoomNumbers, String resortCode,
			Calendar requestDate, Optional<Object> propertyCode, String roomNumberCode) throws MalformedURLException, IOException {
		BigWhiteParser parser = new BigWhiteParser();
		Map<String, RoomAvailability> roomAvailabilities = hotelAvailability.getRoomAvailabilities();

		String requestDateString = DateUtils.getMonthDayYearFormat(requestDate);
		// TODO: Randomize request order for rooms
		for (String fullRoomNumber : fullRoomNumbers) {
			System.out.println("Getting data for room: " + fullRoomNumber + " - " + hotelAvailability.getName().getName());
			String roomNumber = fullRoomNumber.split("-")[1].trim();
			String url;
			if (propertyCode.isPresent()) {
				url = String.format("http://irmestore.bigwhite.com/irmnet/res/RoomDetailsPage.aspx?Resort=%s&PropertyCode=%s&RoomNum=%s%s&Arrival=%s",
						resortCode, propertyCode.get().toString(), roomNumberCode, roomNumber, requestDateString);
			} else {
				url = String.format("http://irmestore.bigwhite.com/irmnet/res/RoomDetailsPage.aspx?Resort=%s&RoomNum=%s%s&Arrival=%s",
						resortCode, roomNumberCode, roomNumber, requestDateString);
			}
			String page = getPage(url);
			RoomAvailability roomAvailability = parser.parseSingleRoomAvailability(page, roomNumber);
			RoomAvailability preExistingRoomAvailability = roomAvailabilities.get(fullRoomNumber);
			if (preExistingRoomAvailability == null) {
				roomAvailabilities.put(fullRoomNumber, roomAvailability);
			} else {
				preExistingRoomAvailability.mergeWith(roomAvailability);
			}
		}
	}

	// The fetcher; sends a request to the Big White servers for one page of availability; gets response in form of string containing entire webpage html
	private static String getPage(String urlString) throws MalformedURLException, IOException {
		HttpURLConnection connection;
		URL url = new URL(urlString);
		
		connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setUseCaches(false);
	    connection.setDoOutput(true);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.close();

	    //Get Response
	    InputStream is = connection.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    String line = rd.readLine();
	    StringBuffer buffer = new StringBuffer();
	    while (line != null) {
	    	buffer.append(line);
	    	line = rd.readLine();
	    }
	    rd.close();
	    connection.disconnect();
	    return buffer.toString();
	}

	private static List<Calendar> calculateRequestDates(Calendar startDate, Calendar endDate) {
		if (startDate.after(endDate)) {
			throw new RuntimeException("Error: the given start date is after the given end date");
		}
		List<Calendar> requestDates = new ArrayList<Calendar>();
		YearMonth startMonth = DateUtils.getYearMonthFromDate(startDate);
		YearMonth endMonth = DateUtils.getYearMonthFromDate(endDate);
		if (startMonth.equals(endMonth) || startMonth.plusMonths(1).equals(endMonth) || startMonth.plusMonths(2).equals(endMonth)) {
			requestDates.add(startDate);
		} else {
			YearMonth currentYearMonth = startMonth.plusMonths(1);
			Calendar currentDate = new GregorianCalendar(currentYearMonth.getYear(), currentYearMonth.getMonthValue() - 1,
					startDate.get(Calendar.DAY_OF_MONTH));
			Calendar lowerDateLimit = (Calendar) startDate.clone();
			while(!lowerDateLimit.after(endDate)) {
				requestDates.add(currentDate);
				currentYearMonth = DateUtils.getYearMonthFromDate(currentDate).plusMonths(4);

				currentDate = (Calendar) currentDate.clone();
				currentDate.set(Calendar.YEAR, currentYearMonth.getYear());
				currentDate.set(Calendar.MONTH, currentYearMonth.getMonthValue() - 1);
				lowerDateLimit = new GregorianCalendar(currentYearMonth.minusMonths(1).getYear(),
						currentYearMonth.minusMonths(1).getMonthValue(), 1);
			}
		}
		return requestDates;
	}

	public static Map<String, RoomAvailability> getAggregatedAvailabilitiesForRoomType(Map<String, RoomAvailability> roomAvailabilities,
			Calendar startDate, Calendar endDate) {
		Map<String, RoomAvailability> aggregatedRoomAvailabilities = new HashMap<String, RoomAvailability>();

		Set<String> uniqueRoomDescriptions = getUniqueRoomDescriptions(roomAvailabilities.keySet());

		uniqueRoomDescriptions.forEach(roomDescription -> {
			Map<String, RoomAvailability> groupedRoomAvailabilities = new HashMap<String, RoomAvailability>();
			for (String key : roomAvailabilities.keySet()) {
				if (key.split("-")[0].trim().equals(roomDescription)) {
					groupedRoomAvailabilities.put(key, roomAvailabilities.get(key));
				}
			}

			RoomAvailability aggregatedRoomAvailability = getAggregatedRoomAvailability(groupedRoomAvailabilities, startDate, endDate);
			aggregatedRoomAvailabilities.put(roomDescription, aggregatedRoomAvailability);
		});
		return aggregatedRoomAvailabilities;
	}

	private static RoomAvailability getAggregatedRoomAvailability(Map<String, RoomAvailability> groupedRoomAvailabilities,
			Calendar startDate, Calendar endDate) {
		Map<Calendar, Optional<Boolean>> newTotalAvailability = new HashMap<Calendar, Optional<Boolean>>();
		String roomDescription = groupedRoomAvailabilities.keySet().stream().findFirst().get().split("-")[0].trim();
		if (!groupedRoomAvailabilities.keySet().stream().anyMatch(roomAvailability -> roomAvailability.split("-")[0].trim().equals(roomDescription))) {
			throw new RuntimeException("Error: cannot convert room availability set to aggregated format because the room descriptions do not all match");
		}

		DateUtils.getDateRange(startDate, endDate).forEach(date -> {
			Optional<Boolean> isRoomTypeAvailable;

			Set<Optional<Boolean>> availabilitySet = groupedRoomAvailabilities.values().stream().map(roomAvailability -> roomAvailability.isAvailableOnDate(date)).collect(Collectors.toSet());
			if (availabilitySet.stream().anyMatch(availability -> availability.isPresent() && availability.get().equals(true))) {
				// At least one available
				isRoomTypeAvailable = Optional.of(true);
			} else if (availabilitySet.stream().anyMatch(availability -> !availability.isPresent())) {
				// At least one blocked
				isRoomTypeAvailable = Optional.empty();
			} else {
				// All unavailable
				isRoomTypeAvailable = Optional.of(false);
			}

			newTotalAvailability.put(date, isRoomTypeAvailable);
		});
		return new RoomAvailability(roomDescription, newTotalAvailability);
	}

	private static Set<String> getUniqueRoomDescriptions(Set<String> roomAvailabilities) {
		return roomAvailabilities.stream().map(roomAvailability -> roomAvailability.split("-")[0].trim()).collect(Collectors.toSet());
	}

	// Is this needed? - Maybe for Leavetown direct posting
	public static Set<RoomAvailability> getRoomAvailabilitiesForProperty(ResortAvailability resortAvailability,
			String roomDescription) {
		Set<RoomAvailability> roomAvailabilitiesForProperty = new HashSet<RoomAvailability>(); 

		resortAvailability.getHotelAvailabilities().values().forEach(hotelAvailability -> {
			hotelAvailability.getRoomAvailabilities().forEach((fullRoomNumber, roomAvailability) -> {
				if (fullRoomNumber.split("-")[0].trim().equals(roomDescription)) {
					roomAvailabilitiesForProperty.add(roomAvailability);
				}
			});
		});
		return roomAvailabilitiesForProperty;
	}

	// Is this needed?  - Maybe for Leavetown direct posting
	public static Map<Calendar, Optional<Boolean>> convertToPropertyAvailability(Set<RoomAvailability> roomAvailabilities) {
		return convertToPropertyAvailability(roomAvailabilities, FIRST_DATE_OF_SEASON, FINAL_DATE_OF_SEASON);
	}

	// Is this needed?  - Maybe for Leavetown direct posting
	public static Map<Calendar, Optional<Boolean>> convertToPropertyAvailability(Set<RoomAvailability> roomAvailabilities,
			Calendar startDate, Calendar endDate) {
		Map<Calendar, Optional<Boolean>> propertyAvailabilities = new HashMap<Calendar, Optional<Boolean>>();
		String roomDescription = roomAvailabilities.stream().findFirst().get().getRoomNumber().split("-")[0].trim();
		if (!roomAvailabilities.stream().anyMatch(roomAvailability -> roomAvailability.getRoomNumber().split("-")[0].trim().equals(roomDescription))) {
			throw new RuntimeException("Error: cannot convert room availability set to property format because the property descriptions do not all match");
		}

		DateUtils.getDateRange(startDate, endDate).forEach(date -> {
			Optional<Boolean> isPropertyAvailable;

			Set<Optional<Boolean>> availabilitySet = roomAvailabilities.stream().map(roomAvailability -> roomAvailability.isAvailableOnDate(date)).collect(Collectors.toSet());
			if (availabilitySet.stream().anyMatch(availability -> availability.isPresent() && availability.get().equals(true))) {
				// At least one available
				isPropertyAvailable = Optional.of(true);
			} else if (availabilitySet.stream().anyMatch(availability -> !availability.isPresent())) {
				// At least one blocked
				isPropertyAvailable = Optional.empty();
			} else {
				// All unavailable
				isPropertyAvailable = Optional.of(false);
			}

			propertyAvailabilities.put(date, isPropertyAvailable);
		});
		return propertyAvailabilities;
	}

	private static void readRoomDataFromFile(String filePath, Map<String, Object> roomsData) throws IOException {
		List<String> fullRoomNumbers = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		String fileText = new String(Files.readAllBytes(Paths.get(filePath)));
		JsonNode root = objectMapper.readTree(fileText);
		TextNode propertyCodeNode = (TextNode) root.get(PROPERTY_CODE_KEY);
		if (propertyCodeNode != null) {
			roomsData.put(PROPERTY_CODE_KEY, propertyCodeNode.asText());
		} else {
			roomsData.put(PROPERTY_CODE_KEY, Optional.empty());
		}
		String roomNumberCode = root.get(ROOM_NUMBER_CODE_KEY).asText();
		String resortCode = root.get(RESORT_CODE_KEY).asText();

		roomsData.put(ROOM_NUMBER_CODE_KEY, roomNumberCode);
		roomsData.put(RESORT_CODE_KEY, resortCode);

		ObjectNode roomNumberData = (ObjectNode) root.get(ROOM_NUMBERS_KEY);

		roomNumberData.fields().forEachRemaining(field -> {
			ArrayNode roomNumbers = (ArrayNode) field.getValue();
			roomNumbers.forEach(roomNumber -> {
				fullRoomNumbers.add(field.getKey() + " - " + roomNumber.asText());
			});
		});
		roomsData.put(ROOM_NUMBERS_KEY, fullRoomNumbers);
	}
}
