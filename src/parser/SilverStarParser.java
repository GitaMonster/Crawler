package parser;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.HotelAvailability;
import model.HotelName;
import model.ResortAvailability;
import model.ResortName;
import model.RoomAvailability;

public class SilverStarParser {
	
	public static void addRwidHeader(String pageText, Map<String, String> relevantHeaders) {
		Document doc = Jsoup.parse(pageText);
		Elements els = doc.getElementsByTag("input");
		List<Element> inputElements = els.stream().filter(el -> el.attr("name").equals("rwid")).collect(Collectors.toList());
		if (inputElements.size() > 1) {
			throw new RuntimeException("Error parsing out the rwid; there are multiple valid input elements");
		}
		String rwid = inputElements.get(0).attr("value");
		relevantHeaders.put("rwid", rwid);
	}

	public static void parseAvailabilityForDate(String pageText, Calendar startDate,
			ResortAvailability resortAvailability) {
		// TODO: Use actual room number hidden in page as key instead? Might be more reliable

		if (areAnyRoomsAvailable(pageText)) {
			addAvailabilitiesForDate(pageText, resortAvailability, startDate);
		} else {
			setAllRoomsUnavailableForDate(startDate, resortAvailability);
		}
	}

	private static void addAvailabilitiesForDate(String pageText, ResortAvailability resortAvailability, Calendar startDate) {
		Document doc = Jsoup.parse(pageText);
		Elements elements = doc.getElementsByClass("rw_av3_room_group_section");

		elements.forEach(element -> {
			Element dataEl = element.children().stream().filter(childEl -> childEl.attr("class").contains("rw_av3_room_group_data")).findFirst().orElse(null);
			Element titleEl = dataEl.children().stream().filter(childEl -> childEl.attr("class").contains("rw_av3_room_group_data_maestro")).findFirst().orElse(null);
			HotelName hotelName = HotelName.getByValue(ResortName.SILVER_STAR, titleEl.ownText().trim());
			HotelAvailability hotelAvailability = resortAvailability.getAvailabilityForHotel(hotelName);
			if (hotelAvailability == null) {
				hotelAvailability = new HotelAvailability(hotelName);
				resortAvailability.getHotelAvailabilities().put(hotelName, hotelAvailability);
			}
			Map<String, RoomAvailability> roomAvailabilities = hotelAvailability.getRoomAvailabilities();
			dataEl.siblingElements().stream().filter(sibEl -> sibEl.attr("class").contains("rw_av3_room_data")).forEach(roomEl -> {
				String roomTitle = roomEl.getElementsByAttributeValueContaining("class", "title").first().ownText();
				RoomAvailability roomAvailability = roomAvailabilities.get(roomTitle);
				if (roomAvailability == null) {
					Map<Calendar, Optional<Boolean>> newTotalAvailability = new HashMap<Calendar, Optional<Boolean>>();
					newTotalAvailability.put(startDate, Optional.of(true));
					RoomAvailability newRoomAvailability = new RoomAvailability(roomTitle, newTotalAvailability);
					roomAvailabilities.put(roomTitle, newRoomAvailability);
				} else {
					roomAvailability.setAvailabilityForDate(startDate, Optional.of(true));
				}
			});
		});
	}

	// TODO: Do any date entries exist yet when this is run?
	private static void setAllRoomsUnavailableForDate(Calendar startDate, ResortAvailability resortAvailability) {
		resortAvailability.getHotelAvailabilities().values().forEach(hotelAvailability -> {
			hotelAvailability.getRoomAvailabilities().values().forEach(roomAvailability -> {
				roomAvailability.getTotalAvailability().put(startDate, Optional.of(false));
			});
		});
	}

	private static boolean areAnyRoomsAvailable(String pageText) {
		return !pageText.contains("rw_noavailReasonMessage");
	}
}
