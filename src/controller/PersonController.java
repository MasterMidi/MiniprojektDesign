package controller;

import java.util.List;

import model.Person;
import model.PersonContainer;

public class PersonController {
	private PersonContainer personContainer;

	public PersonController() {
		personContainer = PersonContainer.getInstance();
	}

	public List<Person> findPersons(String input) {
		return personContainer.findPersons(input);

	}
	
	public String displayPersonList(List<Person> persons) {
		StringBuilder formatted = new StringBuilder();
		
		for (int i = 0; i < persons.size(); i++) {
			formatted.append("(" + i + ") " + persons.get(i).getName() + "\t: " + persons.get(i).getPhoneNr() + "\n");
		}
		
		return formatted.toString();
	}

	public Person selectPerson(String id) {
		return personContainer.selectPerson(id);
	}

	public boolean CreatePerson(String name, String address, String phoneNr, String postalCode, String city) {
		Person person = new Person(name, address, phoneNr, postalCode, city);
		return personContainer.addPerson(person	);
	}

	public Person getPerson(String id) {
		return personContainer.selectPerson(id);
	}

	public boolean updatePerson(String id, String name, String address, String phoneNr, String postalCode, String city) {
		return personContainer.updatePerson(id, name, address, phoneNr, postalCode, city);
	}

	public void deletePerson(String id) {
		personContainer.deletePerson(id);
	}

}
