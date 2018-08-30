/*
 * Product Class
 * 
 * Sanat Bhandari & Daniel Shchur
 * 
 * Custom written for S.C.H.Y.C. Fitness
 */

package entities;

public class Product {
	private String productCode;
	private String productType;
	private double productCost;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		if (productCode.length() > 0) {
			this.productCode = productCode;
		} else {
			System.out.println("Product code is too short.");
			System.exit(1);
		}
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		if (productType.length() == 1) {
			this.productType = productType;
		} else {
			System.out.println("Product type must be only 1 character long.");
			System.exit(1);
		}
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(Integer productCost) {
		if (productCost >= 0) {
			this.productCost = productCost;
		} else {
			System.out.println("Product cost must be no less than 0.");
			System.exit(1);
		}
	}

	public Product(String productCode, String productType, double productCost) {
		super();
		if (productCode.length() > 0) {
			this.productCode = productCode;
		} else {
			System.out.println("Product code is too short.");
			System.exit(1);
		}
		if (productType.length() == 1) {
			this.productType = productType;
		} else {
			System.out.println("Product type must be only 1 character long.");
			System.exit(1);
		}
		if (productCost >= 0) {
			this.productCost = productCost;
		} else {
			System.out.println("Product cost must be no less than 0.");
			System.exit(1);
		}
	}
}
