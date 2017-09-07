package model;

public enum HotelName {
	BIG_WHITE("Big White"),
	WALNUT_BEACH("Walnut Beach");


	private String name;

	HotelName(String name) {
		this.name = name;
	}

	public String getStringName() {
		return this.name;
	}
}
