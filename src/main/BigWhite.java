package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import model.HotelAvailability;
import model.HotelName;
import model.RoomAvailability;
import parser.BigWhiteParser;
import util.ExcelWriter;

public class BigWhite {
	
	private static String[] ROOM_NUMBERS = {"1206", "1408", "1301"};
	
	public static void main(String[] args) throws Exception {
		HotelAvailability avail = getAvailability();
        ExcelWriter.main(avail);
    }

	public static HotelAvailability getAvailability() throws MalformedURLException, IOException {
		BigWhiteParser parser = new BigWhiteParser();
		Map<String, RoomAvailability> roomAvailabilities = new HashMap<String, RoomAvailability>();

		for (String roomNumber : ROOM_NUMBERS) {
			String url = "http://irmestore.bigwhite.com/irmnet/res/RoomDetailsPage.aspx?Resort=01&PropertyCode=SB&RoomNum=SB" + roomNumber + "&Arrival=01/03/18";
			String page = getPage(url);
			RoomAvailability roomAvailability = parser.parseSingleRoomAvailability(page, roomNumber);
			roomAvailabilities.put(roomNumber, roomAvailability);
		}
		return new HotelAvailability(HotelName.BIG_WHITE, roomAvailabilities);
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
}
