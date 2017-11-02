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

	private static final String PATH_TO_HOTELS_DIRECTORY = System.getProperty("user.dir") + "/resources/resortData/BigWhite/";
	public static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2017, 10, 22);
	public static final Calendar FINAL_DATE_OF_SEASON = new GregorianCalendar(2018, 3, 7);

	private static final String ROOM_NUMBERS_KEY = "rooms";
	private static final String PROPERTY_CODE_KEY = "propertyCode";
	private static final String ROOM_NUMBER_CODE_KEY = "roomNumberCode";
	private static final String RESORT_CODE_KEY = "resortCode";

	public static void main(String[] args) throws Exception {
		Calendar startDate = FIRST_DATE_OF_SEASON;
		Calendar endDate = FINAL_DATE_OF_SEASON;

		ResortAvailability bigWhiteAvailability = getResortAvailability(startDate, endDate);

		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_BEARS_PAW));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_BLACK_BEAR));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_BULLET_CREEK));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_CHATEAU_RIDGE));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_COPPER_KETTLE));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_EAGLES));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_GRIZZLY));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_PLAZA_RIDGE));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_PTARMINGAN));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_SNOWY_CREEK));
        ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_STONEBRIDGE));
        ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_STONEGATE));
        ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_SUNDANCE));
        ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_TOWERING_PINES));
        ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_TRAPPERS_CROSSING));
		ExcelWriter.main(bigWhiteAvailability.getAvailabilityForHotel(HotelName.BIG_WHITE_WHITEFOOT));
    }

	public static ResortAvailability getResortAvailability(Calendar startDate, Calendar endDate) throws MalformedURLException, IOException {
		HotelAvailability bearsPawAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_BEARS_PAW, startDate, endDate);
		HotelAvailability blackBearAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_BLACK_BEAR, startDate, endDate);
		HotelAvailability bulletCreekAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_BULLET_CREEK, startDate, endDate);
		HotelAvailability chateauRidgeAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_CHATEAU_RIDGE, startDate, endDate);
		HotelAvailability copperKettleAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_COPPER_KETTLE, startDate, endDate);
		HotelAvailability eaglesAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_EAGLES, startDate, endDate);
		HotelAvailability grizzlyAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_GRIZZLY, startDate, endDate);
		HotelAvailability plazaRidgeAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_PLAZA_RIDGE, startDate, endDate);
		HotelAvailability ptarmiganAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_PTARMINGAN, startDate, endDate);
		HotelAvailability snowyCreekAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_SNOWY_CREEK, startDate, endDate);
		HotelAvailability stonebridgeAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_STONEBRIDGE, startDate, endDate);
		HotelAvailability stonegateAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_STONEGATE, startDate, endDate);
		HotelAvailability sundanceAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_SUNDANCE, startDate, endDate);
		HotelAvailability toweringPinesAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_TOWERING_PINES, startDate, endDate);
		HotelAvailability trappersCrossingAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_TRAPPERS_CROSSING, startDate, endDate);
		HotelAvailability whitefootAvailability = getAvailabilityForHotel(HotelName.BIG_WHITE_WHITEFOOT, startDate, endDate);

		Map<HotelName, HotelAvailability> hotelAvailabilities = new HashMap<HotelName, HotelAvailability>();
		hotelAvailabilities.put(HotelName.BIG_WHITE_BEARS_PAW, bearsPawAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_BLACK_BEAR, blackBearAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_BULLET_CREEK, bulletCreekAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_CHATEAU_RIDGE, chateauRidgeAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_COPPER_KETTLE, copperKettleAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_EAGLES, eaglesAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_GRIZZLY, grizzlyAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_PLAZA_RIDGE, plazaRidgeAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_PTARMINGAN, ptarmiganAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_SNOWY_CREEK, snowyCreekAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_STONEBRIDGE, stonebridgeAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_STONEGATE, stonegateAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_SUNDANCE, sundanceAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_TOWERING_PINES, toweringPinesAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_TRAPPERS_CROSSING, trappersCrossingAvailability);
		hotelAvailabilities.put(HotelName.BIG_WHITE_WHITEFOOT, whitefootAvailability);

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

	public static Map<Calendar, Optional<Boolean>> convertToPropertyAvailability(Set<RoomAvailability> roomAvailabilities) {
		return convertToPropertyAvailability(roomAvailabilities, FIRST_DATE_OF_SEASON, FINAL_DATE_OF_SEASON);
	}

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
