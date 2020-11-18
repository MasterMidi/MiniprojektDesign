package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonContainer {
	private static PersonContainer instance;
	private List<Person> persons;

	/**
	 * Singleton instance for the personContainer
	 * 
	 * @return singleton object of PersonContainer
	 */
	public static PersonContainer getInstance() {
		if (instance == null) {
			instance = new PersonContainer();
		}

		return instance;
	}

	private PersonContainer() {
		persons = new ArrayList<>();
	}

	/**
	 * Finds persons based on search query
	 * 
	 * @param input search query
	 * @return List of persons that match the search query
	 */
	public List<Person> findPersons(String input) {
		boolean isInt = input.matches("\\d+");

		return persons.stream().filter(
				p -> (isInt) ? p.getPhoneNr().contains(input) : p.getName().toLowerCase().contains(input.toLowerCase()))
				.collect(Collectors.toList());

	}

	/**
	 * Find a person with id
	 * 
	 * @param id the id of the person to find
	 * @return Person with the specific id
	 */
	public Person selectPerson(String id) {
		Optional<Person> person = persons.stream().filter(p -> p.getPhoneNr().equals(id)).findFirst();

		return person.get();
	}

	/**
	 * deletes a person with the specific id
	 * 
	 * @param id id of the person to delete
	 */
	public void deletePerson(String id) {
		persons.remove(selectPerson(id));

	}

	/**
	 * Updates a person if value are null of empty, the current value will be used
	 * 
	 * @param id         id of the person to update
	 * @param name       new name to the updated person
	 * @param address    new address for the person
	 * @param phoneNr    new phone number for the person
	 * @param postalCode new postal code for the person
	 * @param city       new city for the person
	 * @return
	 */
	public boolean updatePerson(String id, String name, String address, String phoneNr, String postalCode,
			String city) {
		try {
			int index = persons.indexOf(selectPerson(id));

			// Null check. If null, use the already set value
			persons.get(index).setName((name == null || name.isEmpty()) ? persons.get(index).getName() : name);
			persons.get(index)
					.setAddress((address == null || address.isEmpty()) ? persons.get(index).getAddress() : address);
			persons.get(index)
					.setPhoneNr((phoneNr == null || phoneNr.isEmpty()) ? persons.get(index).getPhoneNr() : phoneNr);
			persons.get(index).setPostalCode(
					(postalCode == null || postalCode.isEmpty()) ? persons.get(index).getPostalCode() : postalCode);
			persons.get(index).setCity((city == null || city.isEmpty()) ? persons.get(index).getCity() : city);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Adds a person to the 'persons' list
	 * 
	 * @param person person to add
	 * @return true/false based on success.
	 */
	public boolean addPerson(Person person) {
		return persons.add(person);
	}
}
