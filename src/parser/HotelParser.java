package parser;

import model.HotelAvailability;
import model.RoomAvailability;

public interface HotelParser {

	public HotelAvailability parse(String page) throws Exception;
	
	public RoomAvailability parseSingleRoomAvailability(String page, String roomNumber) throws Exception;
}
