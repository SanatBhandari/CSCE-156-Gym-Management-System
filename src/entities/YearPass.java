/*
 * Year Pass Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

import org.joda.time.LocalDateTime;

public class YearPass extends Product {
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Address address;
	private String passName;

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		if (startDate != null) {
			this.startDate = startDate;
		} else {
			System.out.println("Please enter a valid start date using yyyy-MM-dd.");
			System.exit(1);
		}
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		if (endDate != null) {
			this.endDate = endDate;
		} else {
			System.out.println("Please enter a valid end date using yyyy-MM-dd.");
			System.exit(1);
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassName() {
		return passName;
	}

	public void setPassName(String passName) {
		if (passName.length() > 0) {
			this.passName = passName;
		} else {
			System.out.println("Pass name is too short.");
			System.exit(1);
		}
	}

	public YearPass(String productCode, String productType, double productCost, LocalDateTime startDate,
			LocalDateTime endDate, Address address, String passName) {
		super(productCode, productType, productCost);
		if (startDate != null) {
			this.startDate = startDate;
		} else {
			System.out.println("Please enter a valid start date using yyyy-MM-dd");
			System.exit(1);
		}
		if (endDate != null) {
			this.endDate = endDate;
		} else {
			System.out.println("Please enter a valid end date using yyyy-MM-dd");
			System.exit(1);
		}
		this.address = address;
		if (passName.length() > 0) {
			this.passName = passName;
		} else {
			System.out.println("Pass name is too short.");
			System.exit(1);
		}
	}

}
