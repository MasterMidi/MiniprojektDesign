package commands;

import java.util.Iterator;
import java.util.List;

import controller.PersonController;
import model.Person;
import tui.Option;
import tui.TextInput;
import util.Util;

public class ReadPersonCommand implements Option {

	PersonController controller;

	@Override
/**
 * Executes command. prints out information about users. Users are found via the "input" variable
 */
	public void start() {

		controller = new PersonController();

		Util.flush();
		System.out.println("****Søg person****");

		String input = TextInput.inputString("Søg efter navn eller telefon nummer");

		List<Person> persons = controller.findPersons(input);

		if (persons.size() > 0) {
			Iterator<Person> it = persons.iterator();

			while (it.hasNext()) {
				System.out.println("=========================================================");
				Person person = it.next();
				System.out.println("Navn:\t\t[" + person.getName() + "]");
				System.out.println("Telefon:\t[" + person.getPhoneNr() + "]");
				System.out.println("Addresse:\t[" + person.getAddress() + "]");
				System.out.println("By:\t\t[" + person.getCity() + "]");
				System.out.println("Postnummber:\t[" + person.getPostalCode() + "]");

				if (!it.hasNext())
					System.out.println("=========================================================");
				
			}
		} else {
			System.out.println(String.format("Systemet kunne ikke finde nogle personer, med '%s' som input.", input));
		}

	}

	@Override
	/**
	 * Set the description of the UI
	 */
	public String getDescription() {

		return "Søg Personer";
	}

}
