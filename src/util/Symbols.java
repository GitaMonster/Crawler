package util;

import java.util.Optional;

public class Symbols {

	public static final String AVAILABLE = "Y";
	public static final String UNAVAILABLE = "X";
	public static final String BLOCKED = " ";

	public static String getDisplaySymbol(Optional<Boolean> isAvailable) {
		String symbol;
		if (isAvailable.isPresent()) {
			symbol = isAvailable.get() ? "Y" : "X";
		} else {
			symbol = " ";
		}
		return symbol;
	}
}
