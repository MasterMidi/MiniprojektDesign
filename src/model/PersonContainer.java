package model;

import java.util.ArrayList;
import java.util.List;

public class PersonContainer {
	private static PersonContainer instance;
	private List<Person> persons;

	public static PersonContainer getInstance() {
		if (instance == null) {
			instance = new PersonContainer();
		}

		return instance;
	}

	private PersonContainer() {
		persons = new ArrayList<>();

		persons.add(new Person("Michael", "24267667"));
		persons.add(new Person("Anders", "41398413"));
		persons.add(new Person("Jannie", "30616515"));
		persons.add(new Person("Johnny", "12938102"));
		persons.add(new Person("Michael", "132837198"));
		persons.add(new Person("Julius", "53381465"));
		persons.add(new Person("Nicklas", "20741072"));
		persons.add(new Person("Alex", "24986881"));
	}

	public Person[] findPerson(String input) {
		boolean isInt = input.matches("\\d+");
		
		Person[] personsFound = persons.stream()
				.filter(p -> (isInt) ? p.getPhoneNr().contains(input) : p.getName().contains(input))
				.toArray(Person[]::new);
		
		return personsFound;
	}
}
