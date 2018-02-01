package model;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CirrusRoomGrouping {

	private int cirrusId;
	private String roomDescription;
	private List<String> roomNumbers;
	private Map<Calendar, Optional<Boolean>> totalAvailability;

	public CirrusRoomGrouping() {}

	public CirrusRoomGrouping(int cirrusId, String roomDescription, List<String> roomNumbers) {
		this.cirrusId = cirrusId;
		this.roomDescription = roomDescription;
		this.roomNumbers = roomNumbers;
	}

	public CirrusRoomGrouping(int cirrusId, String roomDescription, List<String> roomNumbers, Map<Calendar, Optional<Boolean>> totalAvailability) {
		this.cirrusId = cirrusId;
		this.roomDescription = roomDescription;
		this.roomNumbers = roomNumbers;
		this.totalAvailability = totalAvailability;
	}

	public int getCirrusId() {
		return this.cirrusId;
	}

	public String getRoomDescription() {
		return this.roomDescription;
	}

	public List<String> getRoomNumbers() {
		return this.roomNumbers;
	}

	public Map<Calendar, Optional<Boolean>> getTotalAvailability() {
		return this.totalAvailability;
	}

	public void setCirrusId(int cirrusId) {
		this.cirrusId = cirrusId;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public void setRoomNumbers(List<String> roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	public void setTotalAvailability(Map<Calendar, Optional<Boolean>> totalAvailability) {
		this.totalAvailability = totalAvailability;
	}

	public void addRoomNumber(String roomNumber) {
		this.roomNumbers.add(roomNumber);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (cirrusId ^ (cirrusId >>> 32));
        result = prime * result + ((roomDescription == null) ? 0 : roomDescription.hashCode());
        result = prime * result + ((roomNumbers == null) ? 0 : roomNumbers.hashCode());
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
        CirrusRoomGrouping other = (CirrusRoomGrouping) obj;
        if (this.cirrusId != other.cirrusId) {
        	return false;
        }
        if (roomDescription == null) {
            if (other.roomDescription != null) {
                return false;
            }
        } else if (!roomDescription.equals(other.roomDescription)) {
            return false;
        }
        if (roomNumbers == null) {
            if (other.roomNumbers != null) {
                return false;
            }
        } else if (!roomNumbers.equals(other.roomNumbers)) {
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
        return "CirrusRoomGrouping [cirrusId = " + cirrusId + ", roomDescription = " + roomDescription +
        		", roomNumbers = " + roomNumbers +", totalAvailability=" + totalAvailability + "]";
    }
}
