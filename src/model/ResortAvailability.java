package model;


import java.util.HashMap;
import java.util.Map;

public class ResortAvailability {

	private ResortName name;
	private Map<HotelName, HotelAvailability> hotelAvailabilities;

	public ResortAvailability(ResortName name) {
		this.name = name;
		this.hotelAvailabilities = new HashMap<HotelName, HotelAvailability>();
	}

	public ResortAvailability(ResortName name, Map<HotelName, HotelAvailability> hotelAvailabilities) {
		this.name = name;
		this.hotelAvailabilities = hotelAvailabilities;
	}

	public void setName(ResortName name) {
		this.name = name;
	}

	public ResortName getName() {
		return this.name;
	}

	public void setHotelAvailabilities(Map<HotelName, HotelAvailability> hotelAvailabilities) {
		this.hotelAvailabilities = hotelAvailabilities;
	}

	public Map<HotelName, HotelAvailability> getHotelAvailabilities() {
		return this.hotelAvailabilities;
	}

	public HotelAvailability getAvailabilityForHotel(HotelName hotelName) {
		return this.hotelAvailabilities.get(hotelName);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((hotelAvailabilities == null) ? 0 : hotelAvailabilities.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HotelAvailability [name = "+ name + ", hotelAvailabilities=" + hotelAvailabilities + "]"; 
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
        ResortAvailability other = (ResortAvailability) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (hotelAvailabilities == null) {
            if (other.hotelAvailabilities != null) {
                return false;
            }
        } else if (!hotelAvailabilities.equals(other.hotelAvailabilities)) {
            return false;
        }
        return true;
    }
}
