package leavetown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Authenticator {

	public static void main(String[] args) throws Exception {
		String sessionCookie = getInitialSessionCookie();
		Thread.sleep(7000);
		String xAuthCookie = getAspXAuthCookie(sessionCookie);
	}

	public static String getInitialSessionCookie() throws IOException {
		StringBuffer resultText;
		String urlString = "https://cirrus.leavetown.com/login.aspx?ReturnUrl=%2f";
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
	
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
//		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=mqhajihqhkf2s5d4w42j5uow; Login.Username=chloe@leavetown.com; .ASPXAUTH=74BB0F0325402DC4652E7DBA8F53629461D58454A4C716F8F4BAB5403B8E85AD0AC150E208F84B0EC8C79245435AE2BBE979B192E52A0318838EF669D2E2242EF8BDEA721E7C5601FE3466DFEFB1B9E1AC6104A8540FF452F6400C01685CB5E9FE268C3D78EC91317C57101126DBE1ECF7EBC791B6DC712B13A0925F89367522; _ga=GA1.3.1302789716.1506298073; _gid=GA1.3.1853479770.1506298073; _gali=ContentPlaceHolder1_btnSubmitAvailabilityPricingFake");
		connection.setRequestProperty("Origin", "https://cirrus.leavetown.com");
//		connection.setRequestProperty("Referer", "https://cirrus.leavetown.com/property-detail.aspx?propertyid=");

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		resultText = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			resultText.append(line);
		}
		br.close();
		System.out.println("\nRequest complete, response code = " + connection.getResponseCode());
		String cookie = connection.getHeaderField("Set-Cookie");
		cookie = cookie.split("path")[0].trim();
		cookie = cookie.substring(0, cookie.length() - 1);
		System.out.println("Cookie = " + cookie);
		connection.disconnect();

		return cookie;
	}

	private static String getAspXAuthCookie(String initialSessionCookie) throws IOException {
		StringBuffer resultText;
//		String urlString = "https://cirrus.leavetown.com/login.aspx?ReturnUrl=%2f";
		String urlString = "https://cirrus.leavetown.com";
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Cache-control", "max-age=0");
//		connection.setRequestProperty("Cookie", "ASP.NET_SessionId=mqhajihqhkf2s5d4w42j5uow; Login.Username=chloe@leavetown.com; .ASPXAUTH=74BB0F0325402DC4652E7DBA8F53629461D58454A4C716F8F4BAB5403B8E85AD0AC150E208F84B0EC8C79245435AE2BBE979B192E52A0318838EF669D2E2242EF8BDEA721E7C5601FE3466DFEFB1B9E1AC6104A8540FF452F6400C01685CB5E9FE268C3D78EC91317C57101126DBE1ECF7EBC791B6DC712B13A0925F89367522; _ga=GA1.3.1302789716.1506298073; _gid=GA1.3.1853479770.1506298073; _gali=ContentPlaceHolder1_btnSubmitAvailabilityPricingFake");
		connection.setRequestProperty("Cookie", initialSessionCookie);
//		connection.setRequestProperty("upgrade-insecure-requests", "1");
//		connection.setRequestProperty("Origin", "https://cirrus.leavetown.com");
//		connection.setRequestProperty("Referer", "https://cirrus.leavetown.com/login.aspx?ReturnUrl=%2f");
//		connection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		resultText = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			resultText.append(line);
		}
		br.close();
		System.out.println("\nRequest complete, response code = " + connection.getResponseCode());
		String cookie = connection.getHeaderField("Set-Cookie");
//		System.out.println("Cookie = " + cookie);
		System.out.println("Keys:");
		connection.getHeaderFields().forEach((key, value) -> System.out.println(key + " : " + value));
		connection.disconnect();

		return cookie;
	}
}
