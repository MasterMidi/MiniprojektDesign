package commands;

import java.util.List;

import controller.PersonController;
import model.Person;
import tui.Option;
import tui.TextInput;
import util.Util;

public class UpdatePersonCommand implements Option {

	PersonController controller;
	List<Person> persons;
	String id;

	@Override
	public void start() {

		Util.flush();
		controller = new PersonController();
		persons = controller.findPersons(TextInput.inputString("S�g efter navn/telefon nummer"));

		findPersons();

		Person person = selectPerson();

		String oldName = person.getName();
		String name = TextInput.inputString(String.format("Navn: (%s) \t\t", person.getName()));
		int phoneNr = TextInput.inputNumber(String.format("Telefon nummer: (%s) \t\t", person.getPhoneNr()));
		String address = TextInput.inputString(String.format("Adresse: (%s) \t\t", person.getAddress()));
		String postalCode = TextInput.inputString(String.format("Postnummer: (%s) \t\t", person.getPostalCode()));
		String city = TextInput.inputString(String.format("By: (%s) \t\t", person.getCity()));
		
		controller.updatePerson(id, name, address, Integer.toString(phoneNr), postalCode, city);
		System.out.println(String.format("Opdaterede '%s'",oldName));

		

	}

	public void findPersons() {
		System.out.println("Find person med navn eller telefon");
		for (int i = 0; i < persons.size(); i++) {
			System.out.println("(" + i + ") " + persons.get(i).getName() + "\t: " + persons.get(i).getPhoneNr());
		}
	}

	public Person selectPerson() {
		System.out.println("V�lg den �nskede person");
		Person person = null;

		while (person == null) {
			int key = TextInput.inputNumber("Vælg");
			if (key < persons.size()) {
				person = persons.get(key);
				id = person.getPhoneNr();
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		return person;
	}

	
	

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Opdater Person";
	}
	

}
