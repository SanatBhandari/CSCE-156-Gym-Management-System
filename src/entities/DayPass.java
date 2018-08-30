/*
 * Day Pass Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

import org.joda.time.LocalDateTime;

public class DayPass extends Product {
	private LocalDateTime dateTime;
	private Address address;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		if (dateTime != null) {
			this.dateTime = dateTime;
		} else {
			System.out.println("Please enter a valid date and time in yyyy-MM-dd'T'HH:mm:ss format.");
			System.exit(1);
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		if (address != null) {
			this.address = address;
		} else {
			System.out.println("Please enter a valid Address.");
			System.exit(1);
		}
	}

	public DayPass(String productCode, String productType, double productCost, LocalDateTime dateTime,
			Address address) {
		super(productCode, productType, productCost);
		if (dateTime != null) {
			this.dateTime = dateTime;
		} else {
			System.out.println("Please enter a valid date and time in yyyy-MM-dd'T'HH:mm:ss format.");
			System.exit(1);
		}
		if (address != null) {
			this.address = address;
		} else {
			System.out.println("Please enter a valid Address.");
			System.exit(1);
		}
	}
}
