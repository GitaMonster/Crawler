package model;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RoomAvailability {

	private String roomNumber;
//	private Map<MonthDay, Boolean> totalAvailability;
	private Map<Calendar, Boolean> totalAvailability;

	public RoomAvailability(String roomNumber, Map<Calendar, Boolean> totalAvailability) {
		this.roomNumber = roomNumber;
		this.totalAvailability = totalAvailability;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setTotalAvailability(Map<Calendar, Boolean> totalAvailability) {
		this.totalAvailability = totalAvailability;
	}

	public Map<Calendar, Boolean> getTotalAvailability() {
		return this.totalAvailability;
	}

	public Calendar getEarliestKnownDate() {
		Calendar earliestDay = new GregorianCalendar(3000, 1, 1);
		for (Calendar day : totalAvailability.keySet()) {
			if (day.before(earliestDay)) {
				earliestDay = day;
			}
		}
		return earliestDay;
	}

	public Calendar getLatestKnownDate() {
		Calendar earliestDay = new GregorianCalendar(1900, 1, 1);
		for (Calendar day : totalAvailability.keySet()) {
			if (day.after(earliestDay)) {
				earliestDay = day;
			}
		}
		return earliestDay;
	}

	public Map<Calendar, Boolean> getAvailabilityForMonth(YearMonth month) {
		Map<Calendar, Boolean> availability = new HashMap<Calendar, Boolean>();
		for (Entry<Calendar, Boolean> entry : totalAvailability.entrySet()) {
			if (entry.getKey().get(Calendar.MONTH) == month.getMonthValue()) {
				availability.put(entry.getKey(), entry.getValue());
			}
		}
		return availability;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
        result = prime * result + ((totalAvailability == null) ? 0 : totalAvailability.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RoomAvailabilityForMonth [roomNumber = "+ roomNumber + ", dailyAvailability=" + totalAvailability + "]";
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
        RoomAvailability other = (RoomAvailability) obj;
        if (roomNumber == null) {
            if (other.roomNumber != null) {
                return false;
            }
        } else if (!roomNumber.equals(other.roomNumber)) {
            return false;
        }
        if (totalAvailability == null) {
            if (other.totalAvailability != null) {
                return false;
            }
        } else if (!totalAvailability.equals(other.totalAvailability)) {
            return false;
        }
        return true;
    }
}
