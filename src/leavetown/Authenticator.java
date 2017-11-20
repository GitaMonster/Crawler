package leavetown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Authenticator {

	public static final String SESSION_COOKIE_KEY = "ASP.NET_SessionId";
	public static final String VIEWSTATE_KEY = "__VIEWSTATE";
	public static final String VIEWSTATE_GENERATOR_KEY = "__VIEWSTATEGENERATOR";
	public static final String EVENT_VALIDATION_KEY = "__EVENTVALIDATION";
	public static final String USERNAME_LOGIN_KEY = "username";
	public static final String USERNAME_UPDATE_AVAILABILITY_KEY = "Login.Username";
	public static final String PASSWORD_KEY = "password";
	public static final String REMEMBER_KEY = "remember";
	public static final String USERNAME_VALUE = "chloe@leavetown.com";
	public static final String PASSWORD_VALUE = "Leavetown2016!";
	public static final String REMEMBER_VALUE = "False";

	public static final String INITIAL_PAGE_REQUEST_URL = "https://cirrus.leavetown.com/login.aspx?ReturnUrl=%2f";
//	public static final String LOGIN_REQUEST_URL = "https://cirrus.leavetown.com/login.aspx?ReturnUrl=/";
	public static final String LOGIN_REQUEST_URL = "https://cirrus.leavetown.com/login.aspx?ReturnUrl=%2f";
//	public static final String LOGIN_REQUEST_URL = "https://cirrus.leavetown.com/login.aspx";

	public static void main(String[] args) throws Exception {
		Map<String, String> relevantHeadersAndPostValues = getRelevantHeadersAndPostValuesForLogin();

		String sessionCookieValue = relevantHeadersAndPostValues.get(SESSION_COOKIE_KEY);
		String viewStateValue = relevantHeadersAndPostValues.get(VIEWSTATE_KEY);
		String viewStateGeneratorValue = relevantHeadersAndPostValues.get(VIEWSTATE_GENERATOR_KEY);
		String eventValidationValue = relevantHeadersAndPostValues.get(EVENT_VALIDATION_KEY);

		System.out.println(SESSION_COOKIE_KEY + " = " + sessionCookieValue);
		System.out.println(VIEWSTATE_KEY + " = " + viewStateValue);
		System.out.println(VIEWSTATE_GENERATOR_KEY + " = " + viewStateGeneratorValue);
		System.out.println(EVENT_VALIDATION_KEY + " = " + eventValidationValue);
		System.out.println("\nConstructed login request post body = " + makeRequestPostBody(relevantHeadersAndPostValues));

		Thread.sleep(1000);

		performLoginAndAddAspXAuthCookie(relevantHeadersAndPostValues);
//		String fileContent = new String(Files.readAllBytes(Paths.get("/Users/adrian.bocker/Desktop/Crawling/cirrusRequestBody2.txt")));
//		postToLeavetown("374", fileContent);
	}

	public static Map<String, String> getRelevantHeadersAndPostValuesForLogin() throws IOException {
		Map<String, String> relevantHeadersAndPostValues = new HashMap<String, String>();
		
		URL url = new URL(INITIAL_PAGE_REQUEST_URL);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);

		connection.setRequestMethod("GET");
		connection.setRequestProperty("Host", "cirrus.leavetown.com");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:55.0) Gecko/20100101 Firefox/55.0");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//		connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
//		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
//		connection.setRequestProperty("Origin", "https://cirrus.leavetown.com");

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuffer resultText = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			resultText.append(line);
		}
		br.close();
		System.out.println("\nResponse code for session cookie request: " + connection.getResponseCode());
		String sessionCookie = connection.getHeaderField("Set-Cookie");
		sessionCookie = sessionCookie.split("path")[0].trim();
		sessionCookie = sessionCookie.substring(0, sessionCookie.length() - 1);
		sessionCookie = sessionCookie.split("=")[1].trim();

		relevantHeadersAndPostValues.put(SESSION_COOKIE_KEY, sessionCookie);

		addPostValuesNeededForLogin(relevantHeadersAndPostValues, resultText.toString());

		connection.disconnect();

		return relevantHeadersAndPostValues;
	}

	private static void addPostValuesNeededForLogin(Map<String, String> relevantHeadersAndPostValues, String responsePage) throws IOException {
		Document doc = Jsoup.parse(responsePage);
		Elements els = doc.getElementsByTag("input");

		List<Element> inputElementsWithViewstate = els.stream().filter(el -> el.attr("id").equals(VIEWSTATE_KEY)).collect(Collectors.toList());
		if (inputElementsWithViewstate.size() > 1) {
			throw new RuntimeException("Error parsing out " + VIEWSTATE_KEY +"; there are multiple valid input elements");
		}
		String viewState = inputElementsWithViewstate.get(0).attr("value");
		relevantHeadersAndPostValues.put(VIEWSTATE_KEY, viewState);
		
		List<Element> inputElementsWithViewstateGenerator = els.stream().filter(el -> el.attr("id").equals(VIEWSTATE_GENERATOR_KEY)).collect(Collectors.toList());
		if (inputElementsWithViewstateGenerator.size() > 1) {
			throw new RuntimeException("Error parsing out " + VIEWSTATE_GENERATOR_KEY +"; there are multiple valid input elements");
		}
		String viewStateGenerator = inputElementsWithViewstateGenerator.get(0).attr("value");
		relevantHeadersAndPostValues.put(VIEWSTATE_GENERATOR_KEY, viewStateGenerator);

		List<Element> inputElementsWithEventValidation = els.stream().filter(el -> el.attr("id").equals(EVENT_VALIDATION_KEY)).collect(Collectors.toList());
		if (inputElementsWithEventValidation.size() > 1) {
			throw new RuntimeException("Error parsing out " + EVENT_VALIDATION_KEY +"; there are multiple valid input elements");
		}
		String eventValidation = inputElementsWithEventValidation.get(0).attr("value");
		relevantHeadersAndPostValues.put(EVENT_VALIDATION_KEY, eventValidation);
	}

	private static void performLoginAndAddAspXAuthCookie(Map<String, String> relevantHeadersAndPostValues) throws IOException {
		URL url = new URL(LOGIN_REQUEST_URL);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		
		String postBody = makeRequestPostBody(relevantHeadersAndPostValues);

		connection.setDoInput(true);
		connection.setDoOutput(true);

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Host", "cirrus.leavetown.com");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:55.0) Gecko/20100101 Firefox/55.0");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Length", Integer.toString(postBody.length()));
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Referer", "https://cirrus.leavetown.com/login.aspx?ReturnUrl=%2f");
		connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
		
		String cookieHeader = SESSION_COOKIE_KEY + "=" + relevantHeadersAndPostValues.get(SESSION_COOKIE_KEY);
		System.out.println("Cookie header being set:");
		System.out.println(cookieHeader + "\n");
		connection.setRequestProperty("Cookie", cookieHeader);

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.write(postBody);
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuffer resultText = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			resultText.append(line);
		}
		br.close();
		
		String xAuthCookie = connection.getHeaderField("Set-Cookie");
		System.err.println("Response code = " + connection.getResponseCode());
//		System.err.println("Response text = " + resultText.toString());
		System.err.println("Response content = " + resultText.toString());
		System.err.println("XAuthCookie = " + xAuthCookie);

		connection.disconnect();
	}

	private static String makeRequestPostBody(Map<String, String> relevantHeadersAndPostValues) throws UnsupportedEncodingException {
		String viewStateValue = relevantHeadersAndPostValues.get(VIEWSTATE_KEY);
		String viewStateGeneratorValue = relevantHeadersAndPostValues.get(VIEWSTATE_GENERATOR_KEY);
		String eventValidationValue = relevantHeadersAndPostValues.get(EVENT_VALIDATION_KEY);
		
		viewStateValue = URLEncoder.encode(viewStateValue, "UTF-8");
		viewStateGeneratorValue = URLEncoder.encode(viewStateGeneratorValue, "UTF-8");
		eventValidationValue = URLEncoder.encode(eventValidationValue, "UTF-8");
		String username = URLEncoder.encode(USERNAME_VALUE, "UTF-8");
		String password = URLEncoder.encode(PASSWORD_VALUE, "UTF-8"); 

//		return String.format("%s=%s&%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", VIEWSTATE_KEY, viewStateValue, VIEWSTATE_GENERATOR_KEY, 
//					viewStateGeneratorValue, EVENT_VALIDATION_KEY, eventValidationValue, USERNAME_LOGIN_KEY, username,
//					PASSWORD_KEY, password, REMEMBER_KEY, REMEMBER_VALUE);
		// Without remember value:
		return String.format("%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", VIEWSTATE_KEY, viewStateValue, VIEWSTATE_GENERATOR_KEY, 
				viewStateGeneratorValue, EVENT_VALIDATION_KEY, eventValidationValue, USERNAME_LOGIN_KEY, username,
				PASSWORD_KEY, password);
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
		connection.setRequestProperty("Content-type", "multipart/form-data; boundary=----WebKitFormBoundaryuWBt5cYzQBOYwOp5");
		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=mwiot5k12p3ybrfptpv31t1m; Login.Username=chloe@leavetown.com; .ASPXAUTH=166C247D3AD082B04520CE631396C357C5B15372081944AE688D9F0FFBA97D2DB7F1342B44927FBE86F45C7FCEC0B53A8DF492A739ADF1193C190CCEDDBE7C91996062187D649366CE093ADF4679194CF0FD692032D4CF4CE81FB20405F70CC08B0E9732E2FE29BFC36883681FFD122D3785DDC4C3A1CAEF84E8FF434ED7941E; _gat=1; _ga=GA1.3.1514275910.1510618310; _gid=GA1.3.1195913523.1510618310; _gali=ContentPlaceHolder1_btnSubmitAvailabilityPricingFake");
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
}
