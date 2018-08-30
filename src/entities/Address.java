/*
 * Address Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		if (street.length() > 0) {
			this.street = street;
		} else {
			System.out.println("Street address is too short.");
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city.length() > 0) {
			this.city = city;
		} else {
			System.out.println("City name is too short.");
			System.exit(1);
		}
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if (state.length() >= 2) {
			this.state = state;
		} else {
			System.out.println("State must be at least 2 characters long.");
			System.exit(1);
		}
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		
		if (zip.length() > 0) {
			this.zip = zip;
		} else {
			System.out.println("Zip is too short. Set as null.");
			this.zip = null;
			//System.exit(1);
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		if (country.length() > 0) {
			this.country = country;
		} else {
			System.out.println("Country is too short.");
			System.exit(1);
		}
	}

	public Address(String street, String city, String state, String zip, String country) {
		super();
		if (street.length() > 0) {
			this.street = street;
		} else {
			System.out.println("Street address is too short.");
			System.exit(1);
		}
		if (city.length() > 0) {
			this.city = city;
		} else {
			System.out.println("City name is too short.");
			System.exit(1);
		}
		if (state.length() >= 2) {
			this.state = state;
		} else {
			System.out.println("State must be at least 2 characters long.");
			System.exit(1);
		}
		if (zip.length() > 0) {
			this.zip = zip;
		} else {
			System.out.println("Zip is too short. Set as null.");
			this.zip = null;
			//System.exit(1);
		}
		if (country.length() > 0) {
			this.country = country;
		} else {
			System.out.println("Country is too short.");
			System.exit(1);
		}
	}

}
