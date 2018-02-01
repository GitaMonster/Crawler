package model;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import util.DateUtils;

public class RoomAvailability {

	private String roomNumber;
	private int cirrusId;
	private Map<Calendar, Optional<Boolean>> totalAvailability;

	public RoomAvailability(String roomNumber, Map<Calendar, Optional<Boolean>> totalAvailability) {
		this.roomNumber = roomNumber;
		this.totalAvailability = totalAvailability;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setCirrusId(int cirrusId) {
		this.cirrusId = cirrusId;
	}

	public int getCirrusId() {
		return this.cirrusId;
	}

	public void setTotalAvailability(Map<Calendar, Optional<Boolean>> totalAvailability) {
		this.totalAvailability = totalAvailability;
	}

	public Map<Calendar, Optional<Boolean>> getTotalAvailability() {
		return this.totalAvailability;
	}

	public Optional<Boolean> isAvailableOnDate(Calendar date) {
		return this.totalAvailability.get(date);
	}

	public void setAvailabilityForDate(Calendar date, Optional<Boolean> isAvailable) {
		this.totalAvailability.put(date, isAvailable);
	}

	public void mergeWith(RoomAvailability otherAvailability) {
		if (!otherAvailability.getRoomNumber().equals(this.roomNumber)) {
			throw new RuntimeException("Error: Cannot merge availabilities for different rooms into one object");
		}
		for (Entry<Calendar, Optional<Boolean>> otherEntry : otherAvailability.getTotalAvailability().entrySet()) {
			Calendar otherKey = otherEntry.getKey();
			Optional<Boolean> otherValue = otherEntry.getValue();
			if (this.totalAvailability.containsKey(otherKey)) {
				Optional<Boolean> existingValue = this.totalAvailability.get(otherKey);
				if (otherValue == null ^ existingValue == null) {
					throw new RuntimeException("Error when merging room availabilities for date " + 
							DateUtils.getReadableDateString(otherKey) + "; One value was set and the other was null");
				} else if (otherValue != null && existingValue != null && !otherValue.equals(existingValue)) {
					throw new RuntimeException("Error when merging room availabilities for date " + 
							DateUtils.getReadableDateString(otherKey) + "; One value was " + otherValue.toString() + " and the other was " + existingValue.toString());
				}
			} else {
				this.totalAvailability.put(otherKey, otherEntry.getValue());
			}
		}
	}

	public List<Calendar> getAvailableDates() {
		List<Calendar> availableDates = new ArrayList<Calendar>();
		this.totalAvailability.forEach((date, isAvailable) -> {
			if (isAvailable.isPresent() ? isAvailable.get() : false) {
				availableDates.add(date);
			}
		});
		return availableDates;
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
		Calendar latestDay = new GregorianCalendar(1900, 1, 1);
		for (Calendar day : totalAvailability.keySet()) {
			if (day.after(latestDay)) {
				latestDay = day;
			}
		}
		return latestDay;
	}

	public Map<Calendar, Optional<Boolean>> getAvailabilityForMonth(YearMonth month) {
		Map<Calendar, Optional<Boolean>> availability = new HashMap<Calendar, Optional<Boolean>>();
		for (Entry<Calendar, Optional<Boolean>> entry : totalAvailability.entrySet()) {
			if (entry.getKey().get(Calendar.MONTH) == month.getMonthValue()) {
				availability.put(entry.getKey(), entry.getValue());
			}
		}
		return availability;
	}

	// Note: once this is called, dates outside the given range will be permanently removed from this object
	public void trimDateRange(Calendar earliestAllowedDate, Calendar latestAllowedDate) {
		Iterator<Calendar> iterator = this.totalAvailability.keySet().iterator();
		while (iterator.hasNext()) {
			Calendar key = iterator.next();
			if (key.before(earliestAllowedDate) || key.after(latestAllowedDate)) {
				iterator.remove();
			}
		}
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
        result = prime * result + (int) (cirrusId ^ (cirrusId >>> 32));
        result = prime * result + ((totalAvailability == null) ? 0 : totalAvailability.hashCode());
        return result;
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
        if (this.cirrusId != other.cirrusId) {
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

    @Override
    public String toString() {
        return "RoomAvailability [roomNumber = "+ roomNumber + ", cirrusId = " + cirrusId +", totalAvailability=" + totalAvailability + "]";
    }
}
