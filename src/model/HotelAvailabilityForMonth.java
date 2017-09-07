package model;

import java.time.YearMonth;
import java.util.Map;

public class HotelAvailabilityForMonth {

	private YearMonth month;
	private Map<String, Boolean> roomAvailabilities;

	public HotelAvailabilityForMonth(YearMonth month, Map<String, Boolean> roomAvailabilities) {
		this.month = month;
		this.roomAvailabilities = roomAvailabilities;
	}

	public void setMonth(YearMonth month) {
		this.month = month;
	}

	public YearMonth getMonth() {
		return this.month;
	}

	public void setRoomAvailabilities(Map<String, Boolean> roomAvailabilities) {
		this.roomAvailabilities = roomAvailabilities;
	}

	public Map<String, Boolean> getRoomAvailabilities() {
		return this.roomAvailabilities;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((month == null) ? 0 : month.hashCode());
        result = prime * result + ((roomAvailabilities == null) ? 0 : roomAvailabilities.hashCode());
        return result;
    }


    @Override
    public String toString() {
        return "AvailabilityForMonth [month=" + month + ", roomAvailabilities=" + roomAvailabilities + "]";
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
        HotelAvailabilityForMonth other = (HotelAvailabilityForMonth) obj;
        if (month == null) {
            if (other.month != null) {
                return false;
            }
        } else if (!month.equals(other.month)) {
            return false;
        }
        if (roomAvailabilities == null) {
            if (other.roomAvailabilities != null) {
                return false;
            }
        } else if (!roomAvailabilities.equals(other.roomAvailabilities)) {
            return false;
        }
        return true;
    }
}
