package controller;

import model.Person;
import model.PersonContainer;

public class PersonController {
	private PersonContainer personContainer;
	
	public PersonController() {
		personContainer = PersonContainer.getInstance();
	}
	
	public Person[] findPerson(String input){
		return personContainer.findPerson(input);
		
	}
}
