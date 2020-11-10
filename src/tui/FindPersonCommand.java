package tui;

import java.util.HashMap;
import java.util.Map;

import controller.LoanController;
import model.Copy;
import model.LP;
import model.Person;

public class FindPersonCommand implements ICommand {
	private LoanController loanController = new LoanController();
	private String commandName = "find person";
	
	private Person person;
	private LP lp;
	private Copy copy;
	
	@Override
	public void execute() {
		selectPersons();
		selectLPs();
		selectCopies();
		loanController.lendCopy(7, copy.getSerialNumber(), person.getPhoneNr());
	}
	
	public void selectPersons() {
		Person[] persons = loanController.findPerson(TextInput.inputString("søg navn eller telefon"));
		Map<Integer, Person> personMap = new HashMap<>();
		
		for(int i = 0; i < persons.length; i++) {
			personMap.put(i, persons[i]);
			System.out.println("(" + i + ") " + persons[i].getName() + "\t: " + persons[i].getPhoneNr());
		}
		
		int key = TextInput.inputNumber("Valg");
		if(personMap.containsKey(key)) {
			person = personMap.get(key);			
		}
	}
	
	public void selectLPs() {
		LP[] lps = loanController.findLP(TextInput.inputString("Søg"));
		Map<Integer, LP> lpMap = new HashMap<>();
		
		for(int i = 0; i < lps.length; i++) {
			lpMap.put(i, lps[i]);
			System.out.println("(" + i + ") " + lps[i].getTitle());
		}
		
		int key = TextInput.inputNumber("Valg");
		if(lpMap.containsKey(key)) {
			lp = lpMap.get(key);			
		}
	}
	
	public void selectCopies() {
		Copy[] copies = lp.getCopies();
		Map<Integer, Copy> copyMap = new HashMap<>();
		
		for(int i = 0; i < copies.length; i++) {
			copyMap.put(i, copies[i]);
			System.out.println("(" + i + ") " + copies[i].getSerialNumber());
		}
		
		int key = TextInput.inputNumber("Valg");
		if(copyMap.containsKey(key)) {
			copy = copyMap.get(key);			
		}
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return commandName;
	}

}
