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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
