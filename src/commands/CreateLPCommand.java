package commands;

import controller.LPController;
import tui.IOption;
import tui.TextInput;
import util.Util;

public class CreateLPCommand implements IOption {

	LPController lpController;
	
	@Override
	public void start() {
		
		lpController = new LPController();
		
		Util.flush();
		System.out.println("****Opret LP****");
		

		String title = TextInput.inputString("title: \t\t");
		String artist = TextInput.inputString("artist: \t\t");
		String barcode = TextInput.inputString("barcode: \t\t");
		String publicationDate = TextInput.inputString("publicationDate: \t");
		
		//lpController.CreatePerson(name, address, Integer.toString(phoneNr), postalCode, city);
		lpController.createLP(title, artist, barcode, publicationDate);
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Tilføj LP";
	}
	

}


