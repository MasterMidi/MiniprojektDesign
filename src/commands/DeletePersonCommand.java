package commands;

import java.util.List;

import controller.PersonController;
import model.Person;
import tui.Option;
import tui.TextInput;
import util.Util;

public class DeletePersonCommand implements Option {

	PersonController controller;
	List<Person> persons;
	String name;

	@Override
	public void start() {

		Util.flush();
		controller = new PersonController();
		persons = controller.findPersons(TextInput.inputString("S�g efter navn/telefon nummer"));

		findPersons();

		String id = selectPerson();

		displayPerson(id);

		boolean delete = (TextInput.inputString("Er du sikker på du vil slette overstående person? (Y/n)").equals("Y"));

		if (delete) {
			controller.deletePerson(id);
			System.out.println(String.format("Personen '%s' er slettet fra systemet.", name));

		} else {
			start();
		}

	}

	public void findPersons() {
		System.out.println("Find person med navn eller telefon");
		for (int i = 0; i < persons.size(); i++) {
			System.out.println("(" + i + ") " + persons.get(i).getName() + "\t: " + persons.get(i).getPhoneNr());
		}
	}

	public String selectPerson() {
		System.out.println("V�lg den �nskede person");
		String id = null;

		while (id == null) {
			int key = TextInput.inputNumber("Vælg");
			if (key < persons.size()) {
				name = persons.get(key).getName();
				id = persons.get(key).getPhoneNr();
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		return id;
	}

	public void displayPerson(String id) {
		Util.flush();
		Person person = controller.selectPerson(id);
		System.out.println("Navn:\t\t[" + person.getName() + "]");
		System.out.println("Telefon:\t[" + person.getPhoneNr() + "]");
		System.out.println("Addresse:\t[" + person.getAddress() + "]");
		System.out.println("By:\t\t[" + person.getCity() + "]");
		System.out.println("Postnummber:\t[" + person.getPostalCode() + "]");

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Slet Person";
	}

}
