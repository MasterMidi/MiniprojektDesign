package controller;

import java.util.ArrayList;

import model.Person;
import model.PersonContainer;

public class PersonController {
	private PersonContainer personContainer;
	
	public PersonController() {
		personContainer = PersonContainer.getInstance();
	}
	
	public ArrayList<Person> findPerson(String input){
		ArrayList<Person> persons;
		
		try {
			Integer.parseInt(input);
			
			persons = personContainer.findByNumber(input);
		} catch(NumberFormatException ex) {
			persons = personContainer.findByName(input);
		}
		
		return persons;
	}
}
