package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SilverCreek {
	
	private static PrintStream S = System.out;
	private static String UTM_COOKIES = "__utmc=19053498; __utma=19053498.2068434907.1527465609.1527465609.1527467484.2; __utmb=19053498; __utmz=19053498.1527467484.2.2.utmccn=(referral)|utmcsr=google.ca|utmcct=/|utmcmd=referral"; 

	public static void main(String[] args) throws Exception {
		HttpsURLConnection.setFollowRedirects(false);

		String cookie = getAspCookie();
		System.out.println("Cookie = " + cookie);
		String secondCookie = getSecondAspCookie(cookie);
		System.out.println("Second Cookie = " + secondCookie);
		getIQHomePage(secondCookie);
		getAgentLoginPage(secondCookie);
		String page = getAvailabilityPage(secondCookie);
		System.out.println("Sold = " + page.indexOf("Sold"));
		System.out.println("419 = " + page.indexOf("419"));
		System.out.println(page);
	}

	private static void parse(String html) {
		Document doc = Jsoup.parse(html);
		Elements els = doc.getElementsByTag("tbody");
		Element tableDiv = doc.getElementById("availTbl");
		Elements tbodies = tableDiv.getElementsByTag("tbody");
		String title = tbodies.get(0).getElementsByTag("th").get(0).text();
		System.out.println("Title = " + title);
		Element el = doc.getElementById("testing");
		Elements trs = el.getElementsByTag("tr");
		Elements ths = trs.get(0).getElementsByTag("th");
		System.out.println("TRS = " + trs.size());
		System.out.println("THS = " + ths.size());
		System.out.println("Room  = " + ths.get(0).text());
	}
	
	private static String getAspCookie() throws IOException {
		HttpsURLConnection connection;
//		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/default.asp?CIM=5&CID=29&CIY=2018&COM=5&COD=30&COY=2018&checkInDate=29-May-2018&checkOutDate=30-May-2018&AD=2&CH=0&RMS=1&promoCode=&submit=Check+Availability");
//		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/default.asp?CIM=6&CID=20&CIY=2018&COM=6&COD=21&COY=2018&checkInDate=20-Jun-2018&checkOutDate=21-Jun-2018&AD=2&CH=0&RMS=1&promoCode=&submit=Check+Availability");
		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/default.asp?CIM=6&CID=20&CIY=2018&COM=6&COD=21&COY=2018&checkInDate=20-Jun-2018&checkOutDate=21-Jun-2018&AD=2&CH=0&RMS=1&promoCode=&submit=Check+Availability");

		connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    connection.setRequestProperty("Accept-encoding", "gzip, deflate, br");
	    connection.setRequestProperty("Accept-language", "en-US,en;q=0.9");
	    connection.setRequestProperty("Cache-control", "no-cache");
	    connection.setRequestProperty("Pragma", "no-cache");
	    connection.setRequestProperty("Referrer", "http://silvercreekcanmore.ca/booking_engine.htm");
	    connection.setRequestProperty("Upgrade-insecure-requests", "1");
	    connection.setRequestProperty("User-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
	    connection.setRequestProperty("Cookie", UTM_COOKIES);
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
	    
	    String cookie = connection.getHeaderField("Set-Cookie");
	    cookie = cookie.substring(0, cookie.indexOf(';'));

	    connection.disconnect();
	    return cookie;
	}

	private static String getSecondAspCookie(String firstCookie) throws IOException {
//		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/home.asp?CIM=5&CID=29&CIY=2018&COM=5&COD=30&COY=2018&checkInDate=29-May-2018&checkOutDate=30-May-2018&AD=2&CH=0&RMS=1&promoCode=&submit=Check+Availability");
//		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/home.asp?CIM=6&CID=20&CIY=2018&COM=6&COD=21&COY=2018&checkInDate=20-Jun-2018&checkOutDate=21-Jun-2018&AD=2&CH=0&RMS=1&promoCode=&submit=Check+Availability");
		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/home.asp?CIM=6&CID=20&CIY=2018&COM=6&COD=21&COY=2018&checkInDate=20-Jun-2018&checkOutDate=21-Jun-2018&AD=2&CH=0&RMS=1&promoCode=&submit=Check+Availability");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		String cookie = UTM_COOKIES + "; ";
		cookie += firstCookie;

	    connection.setRequestMethod("GET");
	    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    connection.setRequestProperty("Accept-encoding", "gzip, deflate, br");
	    connection.setRequestProperty("Accept-language", "en-US,en;q=0.9");
	    connection.setRequestProperty("Cache-control", "no-cache");
	    connection.setRequestProperty("Pragma", "no-cache");
	    connection.setRequestProperty("Host", "reservations.silvercreekcanmore.ca");
	    connection.setRequestProperty("Referrer", "http://silvercreekcanmore.ca/booking_engine.htm");
	    connection.setRequestProperty("Upgrade-insecure-requests", "1");
	    connection.setRequestProperty("User-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
	    connection.setRequestProperty("Cookie", cookie);
	    connection.setUseCaches(false);
	    connection.setDoOutput(true);

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
	    
	    System.out.println("Second cookie response code = " + connection.getResponseCode());
	    
	    String responseCookie = connection.getHeaderField("Set-Cookie");
	    responseCookie = responseCookie.substring(0, responseCookie.indexOf(';'));

	    connection.disconnect();
	    return responseCookie;
	}
	
	private static String getIQHomePage(String aspCookie) throws IOException {
		HttpsURLConnection connection;
		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/IQHome.asp");

		connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setUseCaches(false);
	    connection.setDoOutput(true);
	    
	    String cookie = UTM_COOKIES + "; ";
	    cookie += aspCookie;
    
	    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    connection.setRequestProperty("Accept-encoding", "gzip, deflate, br");
	    connection.setRequestProperty("Accept-language", "en-US,en;q=0.9");
	    connection.setRequestProperty("Referer", "http://silvercreekcanmore.ca/booking_engine.htm");
	    connection.setRequestProperty("Cache-control", "no-cache");
	    connection.setRequestProperty("Pragma", "no-cache");
	    connection.setRequestProperty("Upgrade-insecure-requests", "1");
	    connection.setRequestProperty("User-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
	    connection.setRequestProperty("Cookie", cookie);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.close();
	    
	    System.out.println("IQ home page response code = " + connection.getResponseCode());

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

	private static String getAgentLoginPage(String aspCookie) throws IOException {
		HttpsURLConnection connection;
//		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/AgentLogin.asp?CheckInMonth=5&CheckInDay=29&CheckInYear=2018&CheckOutMonth=5&CheckOutDay=30&CheckOutYear=2018&txtAdults=2&txtChildren=0&txtNumRooms=1&txtPromoCode=&txtRateSelected=&ForcedUser1=&ForcedUser2=");
		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/AgentLogin.asp?CheckInMonth=6&CheckInDay=20&CheckInYear=2018&CheckOutMonth=6&CheckOutDay=21&CheckOutYear=2018&txtAdults=2&txtChildren=0&txtNumRooms=1&txtPromoCode=&txtRateSelected=&ForcedUser1=&ForcedUser2=");

		connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setUseCaches(false);
	    connection.setDoOutput(true);
	    
	    String cookie = UTM_COOKIES + "; ";
	    cookie += aspCookie;
    
	    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    connection.setRequestProperty("Accept-encoding", "gzip, deflate, br");
	    connection.setRequestProperty("Accept-language", "en-US,en;q=0.9");
	    connection.setRequestProperty("Referer", "http://silvercreekcanmore.ca/booking_engine.htm");
	    connection.setRequestProperty("Cache-control", "no-cache");
	    connection.setRequestProperty("Pragma", "no-cache");
	    connection.setRequestProperty("Upgrade-insecure-requests", "1");
	    connection.setRequestProperty("User-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
	    System.out.println("Using cookie: " + cookie);
	    connection.setRequestProperty("Cookie", cookie);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.close();
	    
	    System.out.println("Agent login response code = " + connection.getResponseCode());

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

	private static String getAvailabilityPage(String aspCookie) throws IOException {
		HttpsURLConnection connection;
		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/CheckAvailability.asp");
//		URL url = new URL("https://reservations.silvercreekcanmore.ca/iqreservations/asp/AgentLogin.asp?CheckInMonth=5&CheckInDay=29&CheckInYear=2018&CheckOutMonth=5&CheckOutDay=30&CheckOutYear=2018&txtAdults=2&txtChildren=0&txtNumRooms=1&txtPromoCode=&txtRateSelected=&ForcedUser1=&ForcedUser2=");

		connection = (HttpsURLConnection) url.openConnection();
	    connection.setRequestMethod("GET");
	    connection.setUseCaches(false);
	    connection.setDoOutput(true);
	    
	    String cookie = UTM_COOKIES + "; ";
	    cookie += aspCookie;
    
	    connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
	    connection.setRequestProperty("Accept-encoding", "gzip, deflate, br");
	    connection.setRequestProperty("Accept-language", "en-US,en;q=0.9");
	    connection.setRequestProperty("Referer", "http://silvercreekcanmore.ca/booking_engine.htm");
	    connection.setRequestProperty("Cache-control", "no-cache");
	    connection.setRequestProperty("Pragma", "no-cache");
	    connection.setRequestProperty("Upgrade-insecure-requests", "1");
	    connection.setRequestProperty("User-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
//	    connection.setRequestProperty("Cookie", "__utma=19053498.326226247.1526232939.1526232939.1526232939.1; __utmb=19053498; __utmc=19053498; __utmz=19053498.1526232939.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none); ASPSESSIONIDAWBBAQAA=EEPJIKDAFCMAGAJJIAOPPEKJ");
//	    connection.setRequestProperty("Cookie", "__utmc=19053498; __utma=19053498.326226247.1526232939.1527132725.1527454671.6; __utmb=19053498; __utmz=19053498.1527454671.6.3.utmccn=(referral)|utmcsr=google.ca|utmcct=/|utmcmd=referral; ");
	    System.out.println("Using cookie: " + cookie);
	    connection.setRequestProperty("Cookie", cookie);

	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.close();

	    System.out.println(" response code = " + connection.getResponseCode());

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
