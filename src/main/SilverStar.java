package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import model.HotelName;
import model.ResortAvailability;
import model.ResortName;
import model.RoomAvailability;
import parser.SilverStarParser;
import util.DateUtils;
import util.ExcelWriter;

public class SilverStar {

	public static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2017, 10, 23);
	public static final Calendar FINAL_DATE_OF_SEASON = new GregorianCalendar(2018, 3, 8);

	public static void main(String[] args) throws Exception {

		Calendar startDate = FIRST_DATE_OF_SEASON;
		Calendar endDate = FINAL_DATE_OF_SEASON;

		ResortAvailability resortAvailability = getFullAvailability(startDate, endDate);

		String roomNumber = "1 Bedroom Executive";
		RoomAvailability roomAvailability = resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_SNOWBIRD).getAvailabilityForRoomNumber(roomNumber);
		System.out.println("\nAvailable dates for 1 Bedroom Executive:");
		roomAvailability.getAvailableDates().forEach(date -> System.out.println(DateUtils.getReadableDateString(date)));

		// Write to excel file
		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_SNOWBIRD));
		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_FIRELIGHT));
		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_LORD_ABERDEEN));
		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_SILVER_CREEK));
		ExcelWriter.writeHotelAvailability(resortAvailability.getAvailabilityForHotel(HotelName.SILVER_STAR_VACATION_HOMES));
	}

	public static ResortAvailability getFullAvailability(Calendar startDate, Calendar endDate) throws MalformedURLException, IOException {
		Map<String, String> relevantHeaders = new HashMap<String, String>();
		String page = getInitialPageForHeaders(relevantHeaders);

		SilverStarParser.addRwidHeader(page, relevantHeaders);
		ResortAvailability resortAvailability = new ResortAvailability(ResortName.SILVER_STAR);

		Set<Calendar> dateRange = DateUtils.getDateRange(startDate, endDate);
		for (Calendar date: dateRange) {
			System.out.println("Getting availability for date " + DateUtils.getReadableDateString(date));
			addAvailabilityForDate(resortAvailability, date, relevantHeaders);
		}

		convertUnavailableDatesToFalse(resortAvailability, dateRange);

		return resortAvailability;
	}

	public static void addAvailabilityForDate(ResortAvailability resortAvailability, Calendar startDate,
			Map<String, String> relevantHeaders) throws MalformedURLException, IOException {

		String cookie = relevantHeaders.get("Cookie");
		String rwid = relevantHeaders.get("rwid");
		String url = "https://www.reseze.net/servlet/WebresShowAvailable";
		String arrivalDateString = String.format("&arrivalMonth=%d&arrivalDay=%d&arrivalYear=%d",
				startDate.get(Calendar.MONTH), startDate.get(Calendar.DAY_OF_MONTH), startDate.get(Calendar.YEAR));
		String postBody = "rwid="+ rwid + arrivalDateString + "&nightsStay=2&buildingCodeRoomType=any%7Cany&numberRooms=1&adults=1&children=0&age3=0&age4=0&rateCode=&groupId=&iataNumber=&ownerReservation=false&check=Check+Now";

		String html = getPage(url, postBody, cookie);

		SilverStarParser.parseAvailabilityForDate(html, startDate, resortAvailability);
	}

	private static String getInitialPageForHeaders(Map<String, String> relevantHeaders) throws MalformedURLException, IOException {

		String urlString = "https://www.reseze.net/servlet/WebresResDesk?hotelid=1485&nightsStay=2";
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String cookie = connection.getHeaderField("Set-Cookie");
		relevantHeaders.put("Cookie", cookie);

		StringBuffer htmlString = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			htmlString.append(line);
		}
		br.close();
		connection.disconnect();
		return htmlString.toString();
	}

	private static String getPage(String urlString, String postBody, String cookie) throws MalformedURLException, IOException {
		StringBuffer htmlString;
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Cookie", "has_js=1; " + cookie); 
		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.write(postBody);
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		htmlString = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			htmlString.append(line);
		}
		br.close();
		connection.disconnect();
		return htmlString.toString();
	}

	private static void convertUnavailableDatesToFalse(ResortAvailability resortAvailability, Set<Calendar> dateRange) {
		for (Calendar date : dateRange) {
			resortAvailability.getHotelAvailabilities().values().forEach(hotelAvailability -> {
				hotelAvailability.getRoomAvailabilities().values().forEach(roomAvailability -> {
					if (roomAvailability.isAvailableOnDate(date) == null) {
						roomAvailability.setAvailabilityForDate(date, Optional.of(false));
					}
				});
			});
		}
	}
}
