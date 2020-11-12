package model;

public class Copy {
	private LP parentLP;
	private String serialNumber;
	private String purchaseDate;
	private String purchasePrice;
	private boolean borrowed;
	
	public Copy(LP parentLP, String serialNumber, String purchaseDate, String purchasePrice, boolean borrowed) {
		this.parentLP = parentLP;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.borrowed = borrowed;
	}

	/**
	 * Dummy Copy, kun til simple tests
	 * @param serialNumber
	 */
	public Copy(String serialNumber) {
		this(null, serialNumber, null, null, false);
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
