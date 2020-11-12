package controller;

import java.util.List;

import model.Person;
import model.PersonContainer;

public class PersonController {
	private PersonContainer personContainer;

	
	 /**
	  * Creates connection to personContainer
	  */
	public PersonController() {
		personContainer = PersonContainer.getInstance();
	}

	/**
	 * Find a list of persons based on search query.
	 * @param input search query
	 * @return list of persons, which were found using the search query
	 */
	public List<Person> findPersons(String input) {
		return personContainer.findPersons(input);

	}
	
	/**
	 * Displays a nicely formatted string based on persons
	 * @param Persons to display
	 * @return String with formatted persons
	 */
	public String displayPersonList(List<Person> persons) {
		StringBuilder formatted = new StringBuilder();
		
		for (int i = 0; i < persons.size(); i++) {
			formatted.append("(" + i + ") " + persons.get(i).getName() + "\t: " + persons.get(i).getPhoneNr() + "\n");
		}
		
		return formatted.toString();
	}

	/**
	 * Finds a person with a specific id
	 * @param id/phoneNr of the user to select
	 * @return Person found with id
	 */
	public Person selectPerson(String id) {
		return personContainer.selectPerson(id);
	}

	/**
	 * Creates a person, and adds it to the personContainer
	 * @param name name of the person
	 * @param address address of the person
	 * @param phoneNr phoneNr of the person (will also be used as id)
	 * @param postalCode postal code for the person
	 * @param city city in which the person lives
	 * @return true/false based on if the person was added successfully
	 */
	public boolean CreatePerson(String name, String address, String phoneNr, String postalCode, String city) {
		Person person = new Person(name, address, phoneNr, postalCode, city);
		return personContainer.addPerson(person	);
	}

	/**
	 * Finds a person with a specific id
	 * @param id/phoneNr of the user to select
	 * @return Person found with id
	 */
	public Person getPerson(String id) {
		return personContainer.selectPerson(id);
	}

	/**
	 * Updates a person with id
	 * @param id the id of the user to update
	 * @param name new name to the user
	 * @param address new address for the user
	 * @param phoneNr new phone number for the user
	 * @param postalCode new postal code for the user
	 * @param city new city for the user
	 * @return true/false based on if the person was updated successfully
	 */
	public boolean updatePerson(String id, String name, String address, String phoneNr, String postalCode, String city) {
		return personContainer.updatePerson(id, name, address, phoneNr, postalCode, city);
	}

	/**
	 * Deletes a person
	 * @param id id of the person to delete
	 */
	public void deletePerson(String id) {
		personContainer.deletePerson(id);
	}

}
