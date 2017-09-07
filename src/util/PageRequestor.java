package util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PageRequestor {

	public static String crawlWithRegularConnection(String urlString) throws MalformedURLException, IOException {
		HttpURLConnection connection;
//		String urlString = "http://irmestore.bigwhite.com/irmnet/(S(l05nuvtafolzxjeb2qmckz0v))/res/RoomDetailsPage.aspx?Resort=01&PropertyCode=SB&RoomNum=SB1102&Arrival=01/03/18";
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
	
	public static String crawlWithRegularConnectionAndHeaders(String urlString) throws MalformedURLException, IOException {
		HttpURLConnection connection;
//		String urlString = "http://irmestore.bigwhite.com/irmnet/(S(l05nuvtafolzxjeb2qmckz0v))/res/RoomDetailsPage.aspx?Resort=01&PropertyCode=SB&RoomNum=SB1102&Arrival=01/03/18";
		URL url = new URL(urlString);
		
		connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
	    connection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
	    connection.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
	    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36");
	    connection.setRequestProperty("Cookie", "cookie_vid=776470582; __utma=1.1729098428.1503183817.1503183817.1503188257.2; __utmc=1; __utmz=1.1503188257.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); _ga=GA1.3.1063614067.1503183004; _gid=GA1.3.2081205223.1503183004");
	    connection.setRequestProperty("Cache-Control", "max-age=0");
	    connection.setRequestProperty("Connection", "keep-alive");
	    
//	    connection.setRequestProperty("Content-Type",
//	        "application/x-www-form-urlencoded");

//	    connection.setRequestProperty("Content-Length", 
//	        Integer.toString(urlParameters.getBytes().length));
	    connection.setRequestProperty("Content-Language", "en-US");

	    connection.setUseCaches(false);
	    connection.setDoOutput(true);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
//	    wr.writeBytes(urlParameters);
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
	
	

	public static String crawlWithSecureConnection(String urlString) throws MalformedURLException, IOException {
		HttpsURLConnection connection;
		
//		String urlString = "http://irmestore.bigwhite.com/irmnet/(S(l05nuvtafolzxjeb2qmckz0v))/res/RoomDetailsPage.aspx?Resort=01&PropertyCode=SB&RoomNum=SB1102&Arrival=01/03/18";
//		String urlString = "http://reservation.worldweb.com/Bookings-nr105/activity-edit.html?table=hotels&listing_id=975&mode=command&command=website_availabilitycalendar&hotel_id=975";
		URL url = new URL(urlString);
		
		connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setRequestProperty("Content-Type",
	        "application/x-www-form-urlencoded");

//	    connection.setRequestProperty("Content-Length", 
//	        Integer.toString(urlParameters.getBytes().length));
	    connection.setRequestProperty("Content-Language", "en-US"); 

	    connection.setUseCaches(false);
	    connection.setDoOutput(true);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
//	    wr.writeBytes(urlParameters);
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
//	    return "";
	}
	
	public static String getPageWithSecureAjax(String urlString) throws MalformedURLException, IOException {
		String payload = "{\"hotelCode\":15158,\"lang\":\"EN_US\",\"ratePlanCode\":\"1685332\",\"ratePlanType\":\"Regular\",\"dateIn\":\"2017-10-01\",\"dateOut\":\"2017-11-30\",\"multiRoomOccupancy\":[{\"adults\":\"1\",\"children\":0}],\"roomTypeCode\":\"90891\",\"preFetch\":true}";
		String response = sendPostRequest(urlString, payload);
		return response;
	}

	public static String sendPostRequest(String requestUrl, String payload) {
		StringBuffer jsonString;
	    try {
	        URL url = new URL(requestUrl);
	        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write(payload);
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	    } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	    }
	    return jsonString.toString();
	}

}
