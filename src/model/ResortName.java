package model;

public enum ResortName {

	BIG_WHITE("Big White"),
	WALNUT_BEACH("Walnut Beach"),
	SILVER_STAR("Silver Star");

	private String name;

	ResortName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return this.name;
	}
}
