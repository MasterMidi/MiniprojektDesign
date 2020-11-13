package model;

public class Loan {
	private int period;
	private String id;
	private String state;
	private String borrowedDate;
	private Copy copy;
	private Person person;
	
	public Loan(int period, String borrowedDate) {
		super();
		this.borrowedDate = borrowedDate;
		this.period = period;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	
	
}
