package model;

public class Copy {
	private LP parentLP;
	private String serialNumber;
	private String purchaseDate;
	private String purchasePrice;
	private boolean borrowed;
	
	public Copy(String serialNumber, String purchaseDate, String purchasePrice, boolean borrowed) {
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.borrowed = borrowed;
	}

	public Copy(String serialNumber) {
		this(serialNumber, null, null, false);
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

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	
	
	
}
