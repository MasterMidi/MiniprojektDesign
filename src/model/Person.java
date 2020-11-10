package model;

public class Person {
	private String name;
	private String address;
	private String phoneNr;
	private String postalCode;
	private String city;

	public Person(String name, String address, String phoneNr, String postalCode, String city) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNr = phoneNr;
		this.postalCode = postalCode;
		this.city = city;
	}

	public Person(String name, String phoneNr) {
		this(name, null, phoneNr, null, null);
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
