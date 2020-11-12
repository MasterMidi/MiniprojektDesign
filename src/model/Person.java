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

	/**
	 * Get the name of the user
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the user
	 * @param name name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	 /**
	  * Gets the address from the person
	  * @return address of this person
	  */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of this user
	 * @param address new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the phone number for a user
	 * @return phone number
	 */
	public String getPhoneNr() {
		return phoneNr;
	}

	/**
	 * Sets the user phone number
	 * @param phoneNr new phone number
	 */
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	/**
	 * gets the postal code for this person
	 * @return postal code for this person
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * sets the postal code for this person
	 * @param postalCode new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * gets the city for this person
	 * @return city 
	 */
	public String getCity() {
		return city;
	}

	/**
	 * sets the city of this person
	 * @param city new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
