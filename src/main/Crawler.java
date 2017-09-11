package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.HotelAvailability;
import model.HotelName;
import model.RoomAvailability;
import parser.BigWhiteParser;
import parser.WalnutBeachParser;
import util.PageRequestor;

// TODO: Remove unneeded dependency jar files from class path
public class Crawler {

	// TODO: Make relative to home directory, independent of OS
	public static final String CRAWLING_PATH = "/Users/adrian.bocker/Desktop/Crawling/";

	public static void main(String[] args) throws Exception {
		HotelAvailability bigWhiteAvailability = BigWhite.getAvailability();
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
