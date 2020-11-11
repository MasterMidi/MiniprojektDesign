package tui;

import java.util.HashMap;
import java.util.Map;

import controller.LoanController;
import model.Copy;
import model.LP;
import model.Loan;
import model.Person;
import util.Util;

public class LendCommand implements ICommand {
	private LoanController loanController = new LoanController();
	private String commandName = "Udlån LP";

	@Override
	public void execute() {
		Util.flush();
		Person person = selectPersons();
		displayPerson(person);

		Util.flush();
		LP lp = selectLPs();
		displayLP(lp);
		Copy copy = selectCopies(lp);

		Util.flush();
		Loan loan = loanController.lendCopy(7, copy.getSerialNumber(), person.getPhoneNr());
		displayLoanConfirmation(loan);
		
		System.out.println();
		System.out.println("Successfuld oprettede et nyt lån");
	}

	public Person selectPersons() {
		System.out.println("Find person med navn eller telefon");
		Person[] persons = loanController.findPerson(TextInput.inputString("Søg"));
		Map<Integer, Person> personMap = new HashMap<>();
		Person person = null;

		for (int i = 0; i < persons.length; i++) {
			personMap.put(i, persons[i]);
			System.out.println("(" + i + ") " + persons[i].getName() + "\t: " + persons[i].getPhoneNr());
		}

		boolean done = false;
		while(!done) {
			int key = TextInput.inputNumber("Valg");
			if (personMap.containsKey(key)) {
				person = personMap.get(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}
		
		return person;
	}
	
	public void displayPerson(Person person) {
		Util.flush();
		System.out.println("Navn:\t\t[" + person.getName() + "]");
		System.out.println("Telefon:\t[" + person.getPhoneNr() + "]");
		System.out.println("Addresse:\t[" + person.getAddress() + "]");
		System.out.println("By:\t\t[" + person.getCity() + "]");
		System.out.println("Postnummber:\t[" + person.getPostalCode() + "]");
	}

	public LP selectLPs() {
		System.out.println("Søg efter den ønskede LP");
		LP[] lps = loanController.findLP(TextInput.inputString("Søg"));
		Map<Integer, LP> lpMap = new HashMap<>();
		LP lp = null;

		for (int i = 0; i < lps.length; i++) {
			lpMap.put(i, lps[i]);
			System.out.println("(" + i + ") " + lps[i].getTitle());
		}

		boolean done = false;
		while(!done) {
			int key = TextInput.inputNumber("Valg");
			if (lpMap.containsKey(key)) {
				lp = lpMap.get(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		return lp;
	}
	
	public void displayLP(LP lp) {
		Util.flush();
		System.out.println("Title:\t\t[" + lp.getTitle() + "]");
		System.out.println("Kunstner:\t[" + lp.getArtist() + "]");
		System.out.println("Udgivelses dato:[" + lp.getPublicationDate() + "]");
		System.out.println("Stregkode:\t[" + lp.getBarcode() + "]");
	}

	public Copy selectCopies(LP lp) {
		System.out.println("Vælg den ønskede kopi");
		Copy[] copies = lp.getCopies();
		Map<Integer, Copy> copyMap = new HashMap<>();
		Copy copy = null;

		for (int i = 0; i < copies.length; i++) {
			copyMap.put(i, copies[i]);
			System.out.println("(" + i + ") " + copies[i].getSerialNumber());
		}

		boolean done = false;
		while(!done) {
			int key = TextInput.inputNumber("Valg");
			if (copyMap.containsKey(key)) {
				copy = copyMap.get(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		return copy;
	}
	
	public void displayLoanConfirmation(Loan loan) {
		Util.flush();
		System.out.println("ID:\t\t[" + loan.getId() + "]");
		System.out.println("Periode:\t[" + loan.getPeriod() + " dage]");
		System.out.println("Låner telefon:\t[" + loan.getPhoneNr() + "]");
		System.out.println("serienummer:\t[" + loan.getSerialNumber() + "]");
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

}
