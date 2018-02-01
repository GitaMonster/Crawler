package util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import model.RoomAvailability;

public class AggregatorUtils {

	public static RoomAvailability getAggregatedRoomAvailability(Map<String, RoomAvailability> groupedRoomAvailabilities,
			Calendar startDate, Calendar endDate) {
		Map<Calendar, Optional<Boolean>> newTotalAvailability = new HashMap<Calendar, Optional<Boolean>>();
		String roomDescription = groupedRoomAvailabilities.keySet().stream().findFirst().get().split("-")[0].trim();
		if (!groupedRoomAvailabilities.keySet().stream().anyMatch(roomAvailability -> roomAvailability.split("-")[0].trim().equals(roomDescription))) {
			throw new RuntimeException("Error: cannot convert room availability set to aggregated format because the room descriptions do not all match");
		}

		DateUtils.getDateRange(startDate, endDate).forEach(date -> {
			Optional<Boolean> isRoomTypeAvailable;

			Set<Optional<Boolean>> availabilitySet = groupedRoomAvailabilities.values().stream().map(roomAvailability -> roomAvailability.isAvailableOnDate(date)).collect(Collectors.toSet());
			if (availabilitySet.stream().anyMatch(availability -> availability.isPresent() && availability.get().equals(true))) {
				// At least one available
				isRoomTypeAvailable = Optional.of(true);
			} else if (availabilitySet.stream().anyMatch(availability -> !availability.isPresent())) {
				// At least one blocked
				isRoomTypeAvailable = Optional.empty();
			} else {
				// All unavailable
				isRoomTypeAvailable = Optional.of(false);
			}

			newTotalAvailability.put(date, isRoomTypeAvailable);
		});
		return new RoomAvailability(roomDescription, newTotalAvailability);
	}
}
