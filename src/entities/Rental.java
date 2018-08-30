/*
 * Rental Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

public class Rental extends Product {
	private String rentalName;

	public String getRentalName() {
		return rentalName;
	}

	public void setRentalName(String rentalName) {
		if (rentalName.length() > 0) {
			this.rentalName = rentalName;
		} else {
			System.out.println("Rental name is too short.");
			System.exit(1);
		}
	}

	public Rental(String productCode, String productType, double productCost, String rentalName) {
		super(productCode, productType, productCost);
		if (rentalName.length() > 0) {
			this.rentalName = rentalName;
		} else {
			System.out.println("Rental name is too short.");
			System.exit(1);
		}
	}

}
