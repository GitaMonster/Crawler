package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.HotelAvailability;
import model.HotelName;
import model.RoomAvailability;
import parser.BigWhiteParser;
import util.DateUtils;
import util.ExcelWriter;

public class BigWhite {

	private static String PATH_TO_HOTELS_DIRECTORY = System.getProperty("user.dir") + "/hotelData/BigWhite/";

	public static void main(String[] args) throws Exception {
		Calendar requestDate = new GregorianCalendar(2018, 0, 1);

		List<String> fullRoomNumbers = readRoomNumbersFromFile(PATH_TO_HOTELS_DIRECTORY + "Stonebridge.json");

		HotelAvailability hotelAvailability = getAvailability(fullRoomNumbers, requestDate);
		System.out.println("Earliest available date: " + DateUtils.getReadableDateString(hotelAvailability.getEarliestKnownDate()));
		System.out.println("Latest available date: " + DateUtils.getReadableDateString(hotelAvailability.getLatestKnownDate()));
        ExcelWriter.main(hotelAvailability);
    }
	
	//each resort will have a unique starting date, not in the excel sheet, but for starting avail checking
	//this class needs to contain something that tells it to 

	public static HotelAvailability getAvailability(List<String> fullRoomNumbers, Calendar requestDate) throws MalformedURLException, IOException {
		BigWhiteParser parser = new BigWhiteParser();
		Map<String, RoomAvailability> roomAvailabilities = new HashMap<String, RoomAvailability>();

		String arrivalString = String.format("&Arrival=" + DateUtils.getMonthDayYearFormat(requestDate));
		// TODO: Randomize request order for rooms
		for (String fullRoomNumber : fullRoomNumbers) {
			System.out.println("Getting data for room: " + fullRoomNumber);
			String roomNumber = fullRoomNumber.split("-")[1].trim();
			String url = "http://irmestore.bigwhite.com/irmnet/res/RoomDetailsPage.aspx?Resort=01&PropertyCode=SB&RoomNum=SB" + roomNumber + arrivalString;
			String page = getPage(url);
			RoomAvailability roomAvailability = parser.parseSingleRoomAvailability(page, roomNumber);
			roomAvailabilities.put(fullRoomNumber, roomAvailability);
		}
		return new HotelAvailability(HotelName.BIG_WHITE_STONEBRIDGE, roomAvailabilities);
	}

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

	private static List<String> readRoomNumbersFromFile(String filePath) throws IOException {
		List<String> fullRoomNumbers = new ArrayList<String>();
		ObjectMapper objectMapper = new ObjectMapper();
		String fileText = new String(Files.readAllBytes(Paths.get(filePath)));
		JsonNode root = objectMapper.readTree(fileText);
		ObjectNode roomsData = (ObjectNode) root.get("rooms");

		roomsData.fields().forEachRemaining(field -> {
			ArrayNode roomNumbers = (ArrayNode) field.getValue();
			roomNumbers.forEach(roomNumber -> {
				fullRoomNumbers.add(field.getKey() + " - " + roomNumber.asText());
			});
		});
		return fullRoomNumbers;
	}
}
