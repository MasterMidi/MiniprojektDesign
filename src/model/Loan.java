package model;

public class Loan {
	private int period;
	private String id;
	private String serialNumber;
	private String phoneNr;
	
	public Loan(String id, int period, String serialNumber, String phoneNr) {
		super();
		this.period = period;
		this.id = id;
		this.serialNumber = serialNumber;
		this.phoneNr = phoneNr;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	
}
