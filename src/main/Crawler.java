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

	public static void main(String[] args) throws Exception {
		String postBodyTemplate = new String(Files.readAllBytes(Paths.get(LEAVE_TOWN_POST_DATA_PATH + "cirrusRequestBodyTemplate.txt")));

		ResortAvailability resortAvailability = BigWhite.getResortAvailability();
		postResortAvailabilityToLeaveTown(resortAvailability, postBodyTemplate);
	}

	private static void postResortAvailabilityToLeaveTown(ResortAvailability resortAvailability,
			String cirrusRequestBodyTemplate) throws IOException {

		Map<String, String> propertyIdMap = getPropertyIdMap();
		propertyIdMap.forEach((roomDescription, fullPropertyId) -> {
			Set<RoomAvailability> roomAvailabilities = BigWhite.getRoomAvailabilitiesForProperty(resortAvailability, roomDescription);
			Map<Calendar, Optional<Boolean>> propertyAvailability = BigWhite.convertToPropertyAvailability(roomAvailabilities);
			postPropertyAvailability(propertyAvailability, propertyIdMap.get(roomDescription), cirrusRequestBodyTemplate);
		});
	}

	private static void postPropertyAvailability(Map<Calendar, Optional<Boolean>> propertyAvailability,
			String propertyId, String cirrusRequestBodyTemplate) {
		
	}

	private static void postToLeavetown(String propertyId, String postBody) throws MalformedURLException, IOException {
		StringBuffer resultText;
		String urlString = "https://cirrus.leavetown.com/property-detail.aspx?propertyid=374";
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
	
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary8AtExlAiL3twjKYH");
//		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=r0ir2ben2yekvh1fezkownd4; Login.Username=chloe@leavetown.com; .ASPXAUTH=ABE34FCA26F79D3CBE8E47C703D5138A7A17093D910979A177015B29FBCABE278C290DF60D772FF856A9F88C0F97823C17D297D7E12E69834381648BBF7E5EA6A785B55FF289D8949B7736797DEC09FB34D574267D66B2294B5FF9306A6380000E8D129923518998DB61FC7C8BC693C66378E43C20FF6181111D2B779BD25970; _ga=GA1.3.72223939.1506225904; _gid=GA1.3.1738991228.1506225904; _gali=ContentPlaceHolder1_btnSubmitAvailabilityPricingFake");
		connection.setRequestProperty("Content-type", "multipart/form-data; boundary=----WebKitFormBoundaryP344hY411nA3LwwK");
		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=jvw0udyjeijhb1br2y5uo1lf; Login.Username=chloe@leavetown.com; .ASPXAUTH=36636BD1FD6C986F17041DBA11D2853C032BF1441C99826EF398126C18FFC451B6A599378A81A7933B0931FA324504AD1DA81EA0E3AB241351C3355CCB7973F0EAB4D47F14A0A78048D6A3A644FFEBB9DA1087C6D7C3A6BFFCB4334BCBFB943C86686C3248DC696C87AA82601D8258013796D133FDB347441146D2742824B213; _ga=GA1.3.679933037.1506233851; _gid=GA1.3.51340828.1506233851; _gali=ContentPlaceHolder1_btnAvailabilityPricing");
		connection.setRequestProperty("Origin", "https://cirrus.leavetown.com");
		connection.setRequestProperty("Referer", "https://cirrus.leavetown.com/property-detail.aspx?propertyid=374");
		
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
		connection.disconnect();
		System.out.println(resultText);
	}

	private static Map<String, String> getPropertyIdMap() throws IOException {
		Map<String, String> propertyIdMap = new HashMap<String, String>();
		String fileText = new String(Files.readAllBytes(Paths.get(LEAVE_TOWN_POST_DATA_PATH + "jsonPath")));
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode root = objectMapper.readTree(fileText);

		return propertyIdMap;
	}

	private static String convertToCSV(RoomAvailability roomAvailability) {
		StringBuffer csvString = new StringBuffer();
		csvString.append("Availability,");

		Calendar startDate = roomAvailability.getEarliestKnownDate();
		Calendar endDate = roomAvailability.getLatestKnownDate();
		Set<Calendar> dateRange = DateUtils.getOrderedDateRange(startDate, endDate);
		Map<Calendar, Optional<Boolean>> totalAvailability = roomAvailability.getTotalAvailability();

		dateRange.forEach(date -> {
			Optional<Boolean> isAvailable = totalAvailability.get(date);
			csvString.append(Symbols.getDisplaySymbol(isAvailable));
			csvString.append(',');
		});
		return csvString.toString();
	}
}
