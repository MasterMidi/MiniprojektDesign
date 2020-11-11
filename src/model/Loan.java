package model;

public class Loan {
	private int period;
	private String id;
	private Copy copy;
	private Person person;
	
	public Loan(String id, int period) {
		super();
		this.period = period;
		this.id = id;
	}
	
	public Loan() {
		this(null, 0);
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

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

//	public String getSerialNumber() {
//		return serialNumber;
//	}
//
//	public void setSerialNumber(String serialNumber) {
//		this.serialNumber = serialNumber;
//	}
//
//	public String getPhoneNr() {
//		return phoneNr;
//	}
//
//	public void setPhoneNr(String phoneNr) {
//		this.phoneNr = phoneNr;
//	}
	
	
}
