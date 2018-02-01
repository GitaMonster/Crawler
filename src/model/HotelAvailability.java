package model;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import util.AggregatorUtils;

public class HotelAvailability {

	private HotelName name;
	private Map<String, RoomAvailability> roomAvailabilities;
	private Map<YearMonth, HotelAvailabilityForMonth> availabilityByMonth;

	public HotelAvailability(HotelName name) {
		this.name = name;
		this.roomAvailabilities = new HashMap<String, RoomAvailability>();
	}

	public HotelAvailability(HotelName name, Map<String, RoomAvailability> roomAvailabilities) {
		this.name = name;
		this.roomAvailabilities = roomAvailabilities;
		// TODO: calculate availabilityByMonth upon construction only once and then make accessible
	}

	public void setName(HotelName name) {
		this.name = name;
	}

	public HotelName getName() {
		return this.name;
	}

	public void setRoomAvailabilities(Map<String, RoomAvailability> roomAvailabilities) {
		this.roomAvailabilities = roomAvailabilities;
	}

	public Map<String, RoomAvailability> getRoomAvailabilities() {
		return this.roomAvailabilities;
	}

	public void setAvailabilityByMonth(Map<YearMonth, HotelAvailabilityForMonth> availabilityByMonth) {
		this.availabilityByMonth = availabilityByMonth;
	}
	
	public Map<YearMonth, HotelAvailabilityForMonth> getAvailabilityByMonth() {
		return this.availabilityByMonth;
	}
	
	public Calendar getEarliestKnownDate() {
		Calendar earliestKnownDate = new GregorianCalendar(3000, 1, 1);
		
		for (RoomAvailability ra : roomAvailabilities.values()) {
			Calendar earliestDateForRoom = ra.getEarliestKnownDate();
			if (earliestDateForRoom.before(earliestKnownDate)) {
				earliestKnownDate = earliestDateForRoom;
			}
		}
		return earliestKnownDate;
	}
	
	public Calendar getLatestKnownDate() {
		Calendar latestKnownDate = new GregorianCalendar(1900, 1, 1);

		for (RoomAvailability ra : roomAvailabilities.values()) {
			Calendar latestDateForRoom = ra.getLatestKnownDate();
			if (latestDateForRoom.after(latestKnownDate)) {
				latestKnownDate = latestDateForRoom;
			}
		}
		return latestKnownDate;
	}

	public RoomAvailability getAvailabilityForRoomNumber(String roomNumber) {
		return this.roomAvailabilities.get(roomNumber);
	}

	// Bug in this method? It doesn't seem to check the availability content for the date, only that it's there
	public List<String> getRoomNumbersAvailableOnDate(Calendar date) {
		List<String> availableRoomNumbers = new ArrayList<String>();
		for (RoomAvailability roomAvailability : this.roomAvailabilities.values()) {
			if (roomAvailability.getTotalAvailability().containsKey(date)) {
				availableRoomNumbers.add(roomAvailability.getRoomNumber());
			}
		}
		return availableRoomNumbers;
	}

	// Note: once this is called, dates outside the given range will be permanently removed from this object
	public void trimDateRange(Calendar earliestAllowedDate, Calendar latestAllowedDate) {
		this.roomAvailabilities.values().forEach(roomAvailability -> {
			roomAvailability.trimDateRange(earliestAllowedDate, latestAllowedDate);
		});
	}

	public List<CirrusRoomGrouping> getGroupedRoomAvailabilities() {

		List<CirrusRoomGrouping> cirrusRoomGroupings = new ArrayList<CirrusRoomGrouping>();
		Set<Integer> cirrusIds = getCirrusIdSet();
		cirrusIds.forEach(cirrusId -> {

			Map<String, RoomAvailability> groupedRoomAvailabilities = new HashMap<String, RoomAvailability>();
			roomAvailabilities.forEach((roomDescription, roomAvailability) -> {
				if (roomAvailability.getCirrusId() == cirrusId) {
					groupedRoomAvailabilities.put(roomDescription, roomAvailability);
				}
			});
			Calendar startDate = getEarliestKnownDate();
			Calendar endDate = getLatestKnownDate();
			RoomAvailability aggregatedRoomAvailability = AggregatorUtils.getAggregatedRoomAvailability(groupedRoomAvailabilities, startDate, endDate);

			String roomDescription = aggregatedRoomAvailability.getRoomNumber();
			List<String> roomNumbers = groupedRoomAvailabilities.values().stream().map(groupedRoomAvailability -> groupedRoomAvailability.getRoomNumber()).collect(Collectors.toList());
			CirrusRoomGrouping newRoomGrouping = new CirrusRoomGrouping(cirrusId, roomDescription, roomNumbers, aggregatedRoomAvailability.getTotalAvailability());
			cirrusRoomGroupings.add(newRoomGrouping);
		});
		return cirrusRoomGroupings;
	}

	private Set<Integer> getCirrusIdSet() {
		return roomAvailabilities.values().stream().map(roomAvailability -> roomAvailability.getCirrusId()).collect(Collectors.toSet());
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((roomAvailabilities == null) ? 0 : roomAvailabilities.hashCode());
        result = prime * result + ((availabilityByMonth == null) ? 0 : availabilityByMonth.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HotelAvailability [name = "+ name + ", roomAvailabilities=" + roomAvailabilities + 
        		", availabilityByMonth=" + availabilityByMonth + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HotelAvailability other = (HotelAvailability) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (roomAvailabilities == null) {
            if (other.roomAvailabilities != null) {
                return false;
            }
        } else if (!roomAvailabilities.equals(other.roomAvailabilities)) {
            return false;
        }
        if (availabilityByMonth == null) {
            if (other.availabilityByMonth != null) {
                return false;
            }
        } else if (!availabilityByMonth.equals(other.availabilityByMonth)) {
            return false;
        }
        return true;
    }
}
