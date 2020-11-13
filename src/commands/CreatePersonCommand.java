package commands;

import controller.PersonController;
import tui.IOption;
import tui.TextInput;
import util.Util;

public class CreatePersonCommand implements IOption {

	PersonController controller;
	
	@Override
	/**
	 * executes the command. in this case, it will ask for information that CreatePerson needs.
	 */
	public void start() {
		
		controller = new PersonController();
		
		Util.flush();
		System.out.println("****Opret person****");
		

		String name = TextInput.inputString("Navn: \t\t");
		int phoneNr = TextInput.inputNumber("Telefon nr: \t\t");
		String address = TextInput.inputString("Adresse: \t\t");
		String city = TextInput.inputString("By: \t\t");
		String postalCode = TextInput.inputString("Postnummer: \t\t");
		
		controller.createPerson(name, address, Integer.toString(phoneNr), postalCode, city);
		
	}

	@Override
	/**
	 * Set the description of the UI
	 */
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Tilføj Person";
	}
	

}


