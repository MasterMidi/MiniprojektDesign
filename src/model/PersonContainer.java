package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
	}

	public ArrayList<Person> findPerson(String input) {
		Person[] _persons = null;
		
		boolean isInt = input.matches("\\d+");
		
		_persons = (Person[]) persons.stream().filter(p->(isInt)?p.getPhoneNr().startsWith(input):p.getName().startsWith(input)).toArray();
		
		return new ArrayList<>(Arrays.asList(_persons));
	}
}
