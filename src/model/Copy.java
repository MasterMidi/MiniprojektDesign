package model;

public class Copy {
	private LP parentLP;
	private String serialNumber;
	private String purchaseDate;
	private double purchasePrice;
	private boolean borrowed;
	
	public Copy(LP parentLP, String serialNumber, String purchaseDate, double purchasePrice, boolean borrowed) {
		this.parentLP = parentLP;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.borrowed = borrowed;
	}

	public LP getParentLP() {
		return parentLP;
	}

	public void setParentLP(LP parentLP) {
		this.parentLP = parentLP;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	
	
}
