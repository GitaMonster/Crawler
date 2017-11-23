//package main;
//
//import model.HotelAvailability;
//import model.RoomAvailability;
//import parser.SolitudeParser;
//import util.DateUtils;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.*;
//
///**
// * Created by Chloe on 11/8/2017.
// */
//public class Solitude {
//
//    private static final boolean AGGREGATE_ROOM_TYPES = true;
//    private static final String PATH_TO_HOTELS_DIRECTORY = System.getProperty("user.dir") + "/resources/resortData/Solitude/";
//    public static final Calendar FIRST_DATE_OF_SEASON = new GregorianCalendar(2017, 11, 01);
//    public static final Calendar FINAL_DATE_OF_SEASON = new GregorianCalendar(2018, 10, 31);
//
//    private static final String ROOM_NUMBERS_KEY = "rooms";
//    private static final String PROPERTY_CODE_KEY = "propertyCode";
//    private static final String ROOM_NUMBER_CODE_KEY = "roomNumberCode";
//    private static final String RESORT_CODE_KEY = "resortCode"; //this is actually "property code" in the URL
//
//
//
//    public static void addAvailabilityAroundDate(HotelAvailability hotelAvailability, List<String> fullRoomNumbers, String resortCode,
//                                                 Calendar requestDate, Optional<Object> propertyCode, String roomNumberCode) throws MalformedURLException, IOException {
//        SolitudeParser parser = new SolitudeParser();
//        Map<String, RoomAvailability> roomAvailabilities = hotelAvailability.getRoomAvailabilities();
//
//        String requestDateString = DateUtils.getMonthDayYearFormat(requestDate);
//        // TODO: Randomize request order for rooms
//        for (String fullRoomNumber : fullRoomNumbers) {
//            System.out.println("Getting data for room: " + fullRoomNumber + " - " + hotelAvailability.getName().getName());
//            String roomNumber = fullRoomNumber.split("-")[1].trim();
//            String url;
//            if (propertyCode.isPresent()) {
//                url = String.format("http://solitudepropertymanagement.com/IRMNet/Res/ResMain.aspx?propertycode=*&arrival=%s"); //not sure as this auto fills a 1 night stay which might exclude some properties from showing up
//                        //resortCode, propertyCode.get().toString(), roomNumberCode, roomNumber, requestDateString);
//            } else {
//                url = String.format("http://solitudepropertymanagement.com/IRMNet/Res/ResMain.aspx?propertycode=*&arrival=%s",
//                        resortCode, roomNumberCode, roomNumber, requestDateString);
//            }
//            String page = getPage(url);
//            RoomAvailability roomAvailability = parser.parseSingleRoomAvailability(page, roomNumber);
//            RoomAvailability preExistingRoomAvailability = roomAvailabilities.get(fullRoomNumber);
//            if (preExistingRoomAvailability == null) {
//                roomAvailabilities.put(fullRoomNumber, roomAvailability);
//            } else {
//                preExistingRoomAvailability.mergeWith(roomAvailability);
//            }
//        }
//    }
//
//    // The fetcher; sends a request to the Solitude servers for one page of availability; gets response in form of string containing entire webpage html
//    private static String getPage(String urlString) throws MalformedURLException, IOException {
//        HttpURLConnection connection;
//        URL url = new URL(urlString);
//
//        connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setUseCaches(false);
//        connection.setDoOutput(true);
//
//        //Send request
//        DataOutputStream wr = new DataOutputStream (
//                connection.getOutputStream());
//        wr.close();
//
//        //Get Response
//        InputStream is = connection.getInputStream();
//        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//        String line = rd.readLine();
//        StringBuffer buffer = new StringBuffer();
//        while (line != null) {
//            buffer.append(line);
//            line = rd.readLine();
//        }
//        rd.close();
//        connection.disconnect();
//        return buffer.toString();
//    }
//
//
//}




