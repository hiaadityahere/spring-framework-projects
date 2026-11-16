package dependency.injection.setter;

public class Address {

	String line1;
	String line2;
	String landmark;
	String city;
	String pincode;
	String country;

	public Address(String line1, String line2, String landmark, String city, String pincode, String country) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
	}

	@Override
	public String toString() {
		return "\t\tLine-1 -" + line1 
				+ "\n\t\tLine-2 - " + line2 
				+ "\n\t\tLandmark -" + landmark 
				+ "\n\t\tCity - " + city
				+ "\n\t\tPincode - " + pincode 
				+ "\n\t\tCountry - " + country
				;
	}
	
}
