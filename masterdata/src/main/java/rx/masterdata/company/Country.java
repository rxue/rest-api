package rx.masterdata.company;

public enum Country {
	CN("China"), DE("Germany"), FI("Finland"), US("America");
	private String fullName;
	private Country(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return fullName;
	}
}
