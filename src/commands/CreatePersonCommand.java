package commands;

import controller.PersonController;
import tui.Option;
import tui.TextInput;
import util.Util;

public class CreatePersonCommand implements Option {

	PersonController controller;
	
	@Override
	public void start() {
		
		controller = new PersonController();
		
		Util.flush();
		System.out.println("****Opret person****");
		

		String name = TextInput.inputString("Navn: \t\t");
		int phoneNr = TextInput.inputNumber("Telefon nr: \t\t");
		String address = TextInput.inputString("Adresse: \t\t");
		String city = TextInput.inputString("By: \t\t");
		String postalCode = TextInput.inputString("Postnummer: \t\t");
		
		controller.CreatePerson(name, address, Integer.toString(phoneNr), postalCode, city);
		
	}
	
	

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Tilføj Person";
	}
	

}


