package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.net.ssl.HttpsURLConnection;

public class Crawler {

	// TODO: Make relative to home directory, independent of OS
	public static final String CRAWLING_PATH = "/Users/adrian.bocker/Desktop/Crawling/";

	public static void main(String[] args) throws Exception {
		String postBody = new String(Files.readAllBytes(Paths.get("C:/Users/Adrian/Desktop/Crawling/cirrusRequestBody.txt")));
		
		StringBuffer resultText;
		String urlString = "https://cirrus.leavetown.com/property-detail.aspx?propertyid=374";
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
	
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary8AtExlAiL3twjKYH");
		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=r0ir2ben2yekvh1fezkownd4; Login.Username=chloe@leavetown.com; .ASPXAUTH=ABE34FCA26F79D3CBE8E47C703D5138A7A17093D910979A177015B29FBCABE278C290DF60D772FF856A9F88C0F97823C17D297D7E12E69834381648BBF7E5EA6A785B55FF289D8949B7736797DEC09FB34D574267D66B2294B5FF9306A6380000E8D129923518998DB61FC7C8BC693C66378E43C20FF6181111D2B779BD25970; _ga=GA1.3.72223939.1506225904; _gid=GA1.3.1738991228.1506225904; _gali=ContentPlaceHolder1_btnSubmitAvailabilityPricingFake");
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

	public static void getAvailabilityForWalnutBeach() throws MalformedURLException, IOException {
//		print("Starting to acquire page\n");

		String ajaxUrl = "https://api.travelclick.com/ibe/v1/hotel/15158/basicavail/multi-room";
//		String response = PageRequestor.ajaxWithSecureConnection(ajaxUrl);

//		print("Done acquiring page, starting to parse\n");
//		HotelAvailability availability = new WalnutBeachResortParser().parse(response);
//		print("Done parsing\n");
	}



}
