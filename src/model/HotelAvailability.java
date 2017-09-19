package model;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			if (latestDateForRoom.before(latestKnownDate)) {
				latestKnownDate = latestDateForRoom;
			}
		}
		return latestKnownDate;
	}

	public RoomAvailability getAvailabilityForRoomNumber(String roomNumber) {
		return this.roomAvailabilities.get(roomNumber);
	}

	public List<String> getRoomNumbersAvailableOnDate(Calendar date) {
		List<String> availableRoomNumbers = new ArrayList<String>();
		for (RoomAvailability roomAvailability : this.roomAvailabilities.values()) {
			if (roomAvailability.getTotalAvailability().containsKey(date)) {
				availableRoomNumbers.add(roomAvailability.getRoomNumber());
			}
		}
		return availableRoomNumbers;
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
