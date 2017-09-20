package model;

import java.util.Arrays;

public enum HotelName {
	BIG_WHITE_STONEBRIDGE(ResortName.BIG_WHITE, "Stonebridge Lodge"),
	BIG_WHITE_STONEGATE(ResortName.BIG_WHITE, "Stonegate Resort"),
	BIG_WHITE_BEARS_PAW(ResortName.BIG_WHITE, "Bears Paw"),
	BIG_WHITE_BLACK_BEAR(ResortName.BIG_WHITE, "Black Bear Lodge"),
	BIG_WHITE_BULLET_CREEK(ResortName.BIG_WHITE, "Bullet Creek Cabins"),
	BIG_WHITE_CHATEAU_RIDGE(ResortName.BIG_WHITE, "Chateau on the Ridge"),
	BIG_WHITE_COPPER_KETTLE(ResortName.BIG_WHITE, "Copper Kettle Lodge"),
	BIG_WHITE_EAGLES(ResortName.BIG_WHITE, "Eagles Resort"),
	WALNUT_BEACH_DEFAULT(ResortName.WALNUT_BEACH, "Main"),
	SILVER_STAR_SNOWBIRD(ResortName.SILVER_STAR, "Snowbird Lodge"),
	SILVER_STAR_FIRELIGHT(ResortName.SILVER_STAR, "Firelight Lodge"),
	SILVER_STAR_SILVER_CREEK(ResortName.SILVER_STAR, "Silver Creek Lodge"),
	SILVER_STAR_LORD_ABERDEEN(ResortName.SILVER_STAR, "The Lord Aberdeen Hotel"),
	SILVER_STAR_VACATION_HOMES(ResortName.SILVER_STAR, "Vacation Homes & Condos");


	private ResortName resortName;
	private String name;

	HotelName(ResortName resortName, String hotelName) {
		this.resortName = resortName;
		this.name = hotelName;
	}

	public static HotelName getByValue(ResortName resortName, String hotelName) {
		return Arrays.asList(HotelName.values()).stream().filter(name -> {
			return (name.resortName.equals(resortName) && name.name.equals(hotelName));
		}).findFirst().orElse(null);
	}

	public String getName() {
		return this.name;
	}

	public String getDisplayName() {
		return this.resortName.getDisplayName() + " - " + this.name;
	}
}
