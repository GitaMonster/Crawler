package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SilverStarVanceCreek {

	public static void main(String[] args) throws Exception {
		System.out.println(getPage());
	}

	private static String getPage() throws IOException {
		String urlString = "https://www.book.vancecreekhotel.com/irmnet/(S(dmbvkb5uzpsxsjjbpeky3mco))/Res/ResMain.aspx";
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "*/*");
		connection.setRequestProperty("Host", "www.book.vancecreekhotel.com");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
		connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
		connection.setRequestProperty("Pragma", "no-cache");
		connection.setRequestProperty("Referer", "https://www.book.vancecreekhotel.com/irmnet/(S(dmbvkb5uzpsxsjjbpeky3mco))/Res/ResMain.aspx");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36");

		String postBody = "ScriptManager1=UpdatePanelAvailability%7CdlRoomTypes%24ctl01%24lbtnViewCalendar&__VIEWSTATE=&JavaScriptEnabled=&hdnClickSearchProgrammatically=false&hdnImageViewerHeight=75px&hdnSelectedRateInfo=&wdpArrival_clientState=%7C0%7C012017-11-24-0-0-0-0%7C%7C%5B%5B%5B%5B%5D%5D%2C%5B%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2C%22012017-11-24-0-0-0-0%22%5D&WebMonthCalendar1_clientState=%5B%5B%5B%5B%5D%5D%2C%5B%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2C%2201%2C2017%2C11%2C2017%2C11%2C24%22%5D&wcNights=1&wdpDeparture_clientState=%7C0%7C012017-11-25-0-0-0-0%7C%7C%5B%5B%5B%5B%5D%5D%2C%5B%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2C%22012017-11-25-0-0-0-0%22%5D&WebMonthCalendar2_clientState=%5B%5B%5B%5B%5D%5D%2C%5B%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2C%2201%2C2017%2C11%2C2017%2C11%2C25%22%5D&ResPeople1%24wcPpl1Short=1&ResPeople1%24wcPpl2Short=0&ResPeople1%24wcPpl3Short=0&ResPeople1%24wcPpl4Short=0&wcPropertyCode=*&ucGuestRequests%24wcRDPReq2=*&ucGuestRequests%24wcRDPReq3=*&ucGuestRequests%24wcIRMReq2=*&txtPromoCode=&dlRoomTypes%24ctl01%24hdnRoomType=CREG%20%20&dlRoomTypes%24ctl01%24hdnRoomNum=CC242%20%20%20&dlRoomTypes%24ctl01%24hdnDescription=Chilcoot%20Hotel%20Room%20%20%20%20%20&dlRoomTypes%24ctl01%24hdnRoomDetailURL=&dlRoomTypes%24ctl02%24hdnRoomType=CREG%20%20&dlRoomTypes%24ctl02%24hdnRoomNum=CC331%20%20%20&dlRoomTypes%24ctl02%24hdnDescription=Chilcoot%20Hotel%20Room%20%20%20%20%20&dlRoomTypes%24ctl02%24hdnRoomDetailURL=&dlRoomTypes%24ctl03%24hdnRoomType=CREG%20%20&dlRoomTypes%24ctl03%24hdnRoomNum=CC334%20%20%20&dlRoomTypes%24ctl03%24hdnDescription=Chilcoot%20Hotel%20Room%20%20%20%20%20&dlRoomTypes%24ctl03%24hdnRoomDetailURL=&dlRoomTypes%24ctl04%24hdnRoomType=CREG%20%20&dlRoomTypes%24ctl04%24hdnRoomNum=CC342%20%20%20&dlRoomTypes%24ctl04%24hdnDescription=Chilcoot%20Hotel%20Room%20%20%20%20%20&dlRoomTypes%24ctl04%24hdnRoomDetailURL=&dlRoomTypes%24ctl05%24hdnRoomType=CREG%20%20&dlRoomTypes%24ctl05%24hdnRoomNum=CC442%20%20%20&dlRoomTypes%24ctl05%24hdnDescription=Chilcoot%20Hotel%20Room%20%20%20%20%20&dlRoomTypes%24ctl05%24hdnRoomDetailURL=&dlRoomTypes%24ctl06%24hdnRoomType=V1BE%20%20&dlRoomTypes%24ctl06%24hdnRoomNum=MONASH%20%20&dlRoomTypes%24ctl06%24hdnDescription=1%20Bedroom%20Executive%20%20%20%20%20&dlRoomTypes%24ctl06%24hdnRoomDetailURL=&dlRoomTypes%24ctl07%24hdnRoomType=V1BR%20%20&dlRoomTypes%24ctl07%24hdnRoomNum=VC201%20%20%20&dlRoomTypes%24ctl07%24hdnDescription=Vance%20Creek%201B%20Suite%20%20%20%20&dlRoomTypes%24ctl07%24hdnRoomDetailURL=&dlRoomTypes%24ctl08%24hdnRoomType=V1BR%20%20&dlRoomTypes%24ctl08%24hdnRoomNum=VC202%20%20%20&dlRoomTypes%24ctl08%24hdnDescription=Vance%20Creek%201B%20Suite%20%20%20%20&dlRoomTypes%24ctl08%24hdnRoomDetailURL=&wdwDialog_clientState=%5B%5B%5B%5Bnull%2C3%2Cnull%2Cnull%2Cnull%2Cnull%2C0%2Cnull%2C1%2C0%2Cnull%2C3%5D%5D%2C%5B%5B%5B%5B%5Bnull%2Cnull%2Cnull%5D%5D%2C%5B%5B%5B%5B%5B%5D%5D%2C%5B%5D%2Cnull%5D%2C%5Bnull%2Cnull%5D%2C%5Bnull%5D%5D%2C%5B%5B%5B%5B%5D%5D%2C%5B%5D%2Cnull%5D%2C%5Bnull%2Cnull%5D%2C%5Bnull%5D%5D%2C%5B%5B%5B%5B%5D%5D%2C%5B%5D%2Cnull%5D%2C%5Bnull%2Cnull%5D%2C%5Bnull%5D%5D%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2Cnull%5D%2C%5B%5B%5B%5Bnull%2Cnull%2Cnull%2Cnull%5D%5D%2C%5B%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2Cnull%5D%5D%2C%5B%5D%5D%2C%5B%7B%7D%2C%5B%5D%5D%2C%223%2C3%2C%2C%2C%2C%2C0%22%5D&hdnPropertyName=&_IG_CSS_LINKS_=~%2FApp_Themes%2FDefault%2F1CommonStyles.css%7C~%2FApp_Themes%2FDefault%2FCalendar.css%7C~%2FApp_Themes%2FDefault%2FGrids.css%7C~%2FApp_Themes%2FDefault%2FhaRoomDetails.css%7C~%2FApp_Themes%2FDefault%2Fig_styles.css%7C~%2FApp_Themes%2FDefault%2FMonitorStyles.css%7C~%2FApp_Themes%2FDefault%2FOwnerStyles.css%7C~%2FApp_Themes%2FDefault%2FResMain.css%7C~%2FApp_Themes%2FDefault%2FResStyles.css%7C~%2FApp_Themes%2FDefault%2FRoomsCal.css%7C~%2FApp_Themes%2FDefault%2FRoundedBoxes.css%7C~%2FApp_Themes%2FDefault%2FSurvey.css%7C~%2FApp_Themes%2FDefault%2Fv4Buttons.css%7C~%2FApp_Themes%2FDefault%2Fv4ig_styles.css%7C~%2FApp_Themes%2FDefault%2Fv4OwnerStyles.css%7C~%2FApp_Themes%2FDefault%2Fv4ResStyles.css%7C..%2Fig_res%2FDefault%2Fig_dialogwindow.css%7C..%2Fig_res%2FDefault%2Fig_monthcalendar.css%7C..%2Fig_res%2FDefault%2Fig_texteditor.css%7C..%2Fig_res%2FDefault%2Fig_shared.css&__EVENTTARGET=dlRoomTypes%24ctl01%24lbtnViewCalendar&__EVENTARGUMENT=&__LASTFOCUS=&__EVENTVALIDATION=%2FwEWqAEC%2Fq2g6QICvvOP0QMCwIflzQUC36yi2w4CgNTH7gsCkpXV4AICrKPs3A0CxLb45QoC%2BfybiAwCvcqP0QMCqY2P0AUCrMC32w4C5dHh6wsCr8zK4AICq%2Frr3A0C%2B%2Bvt5QoClpu%2F9AsCwISQ0QMCvqf1yQUCob2m2w4C%2BvPX8QsCzMfZ4AICrrTs3A0Cmub05QoC%2F%2F%2BEgwwCv9uP0QMCv6WQzQUCxpKc2w4Cj%2B6C7wsC8fzO4AICrYvs3A0CuZ3q5QoCvNun9AsCutOP0QMCxMfkzwUC44u62w4C9I%2B37AsChvTM4AICqIPs3A0CwJfw5QoC1bnr8QsCuaqP0QMCvcX%2FyQUCgKOv2w4C%2BZHS6QsCo6vC4AICp9rr3A0C58zl5QoCktnO7gsCvOSP0QMCwufUzAUCpZye2w4CjrDH7wsC0KbR4AICqpTs3A0Chsfs5QoC%2B73U9AsCu7uP0QMCw%2BGF0QUCyu2y2w4C86nI6gsC5dvG4AICqevr3A0Cpf7h5QoCmJq37QsCvaLwkw4C66rr5gICjInAmQ4C18GVlgQC6ZCT%2Fg0CnMy0rg0Cz%2BjMpAYC%2BLKg5g0C992KiAEC9t2KiAEC9d2KiAEC9N2KiAEC892KiAEC8t2KiAEC8d2KiAEC4N2KiAEC792KiAEC993KiwEC993GiwEC993CiwEC993%2BiwEC9936iwEC9932iwEC993yiwEC993uiwEC992qiAEC992miAEC9t3KiwEC9t3GiwEC9t3CiwEC9t3%2BiwEC9t36iwEC9t32iwEC9t3yiwEC9t3uiwEC9t2qiAEC9t2miAEC78juhAcC%2F6fE6gsC4KfE6gsC4afE6gsC4qfE6gsC46fE6gsC5KfE6gsC5afE6gsC5qfE6gsC96fE6gsC%2BKfE6gsC4KeE6QsCksnuhAcCgqbE6gsCnabE6gsCnKbE6gsCn6bE6gsCnqbE6gsCmabE6gsCmKbE6gsCm6bE6gsCiqbE6gsCscnuhAcCoabE6gsCvqbE6gsCv6bE6gsCvKbE6gsCvabE6gsCuqbE6gsCu6bE6gsCuKbE6gsCqabE6gsCtMvuhAcCpKTE6gsCu6TE6gsCuqTE6gsCuaTE6gsCuKTE6gsCv6TE6gsCvqTE6gsCvaTE6gsCrKTE6gsCtdrfwAICs7X1rg4C6LXBsA4C6LWBsA4C7LWNsA4C37XBsA4C37WVsA4Ch6%2B8%2FwMCgcCWkQ8CiMCWkQ8CicCWkQ8CisCCkg8C6effzw0Chq%2B8%2FwMCgMCWkQ8Cip21uQsCm6LGjwwC0NT%2FkAoC6%2FC1mAwC7Z%2BfdgKcn592Atjak8QBAvmwh74PAoGjhL0FmMJ%2B021JmRUAQhsAFYLBOAWpHwZGq%2BEprnD4avsBhDM%3D";

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
		writer.write(postBody);
		writer.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuffer htmlString = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			htmlString.append(line);
		}
		br.close();
		connection.disconnect();
		return htmlString.toString();
	}
}
