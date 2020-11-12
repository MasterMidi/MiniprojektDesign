package commands;

import java.util.Iterator;
import java.util.List;

import controller.LoanController;
import model.Copy;
import model.LP;
import model.Loan;
import model.Person;
import tui.Option;
import tui.TextInput;
import util.Util;

public class LendCommand implements Option {
	private LoanController loanController = new LoanController();
	private String commandName = "Udlån LP";

	@Override
	public void start() {
		loanController.createLoan();

		findPersons();
		selectPerson();
		findLPs();
		selectLP();
		selectCopy();
		
		displayLoan(loanController.getLoan());

		System.out.println();
		System.out.println("Successfuld oprettede et nyt løn");
	}

	public void findPersons() {
		Util.flush();
		System.out.println("Find person med navn eller telefon");
		String personListFormatted = loanController.findPersons(TextInput.inputString("Søg"));

		System.out.println(personListFormatted);
	}

	public void selectPerson() {
		System.out.println("Vælg den ønskede person");
		List<Person> personList = loanController.getPersonList();
		Person person = null;
		boolean done = false;

		while (!done) {
			int key = TextInput.inputNumber("Valg");
			if (key < personList.size()) {
				person = loanController.selectPerson(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		displayPerson(person);
	}

	public void displayPerson(Person person) {
		Util.flush();
		System.out.println("Navn:\t\t[" + person.getName() + "]");
		System.out.println("Telefon:\t[" + person.getPhoneNr() + "]");
		System.out.println("Addresse:\t[" + person.getAddress() + "]");
		System.out.println("By:\t\t[" + person.getCity() + "]");
		System.out.println("Postnummber:\t[" + person.getPostalCode() + "]");
	}

	public void findLPs() {
		System.out.println("Søg efter den ønskede LP");
		String lpListFormatted = loanController.findLPs(TextInput.inputString("Søg"));
		//String copyListFormatted = loanController.

		System.out.println(lpListFormatted);
	}

	public void selectLP() {
		System.out.println("Vælg den ønskede LP");
		List<LP> lpList = loanController.getLpList();
		LP lp = null;
		boolean done = false;

		while (!done) {
			int key = TextInput.inputNumber("Valg");
			if (key < lpList.size()) {
				lp = loanController.selectLP(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		displayLP(lp);
	}

	public void displayLP(LP lp) {
		Util.flush();
		System.out.println("Title:\t\t[" + lp.getTitle() + "]");
		System.out.println("Kunstner:\t[" + lp.getArtist() + "]");
		System.out.println("Udgivelses dato:[" + lp.getPublicationDate() + "]");
		System.out.println("Stregkode:\t[" + lp.getBarcode() + "]");
		
		displayCopy();
	}
	
	public void displayCopy() {
		List<Copy> copyList = loanController.getCopyList();
		
		Iterator<Copy> it = copyList.iterator();
		for(int i = 0; it.hasNext(); i++) {
			System.out.println("(" + i + ") " + it.next().getSerialNumber());
		}
	}

	public void selectCopy() {
		System.out.println("Vælg den ønskede kopi");
		List<Copy> copyList = loanController.getCopyList();
		boolean done = false;

		while (!done) {
			int key = TextInput.inputNumber("Valg");
			if (key >= 0 && key < copyList.size()) {
				loanController.selectCopy(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}
	}

	/**
	 * Displays loan information in a formatted way. 
	 * @param loan the loan which is to be displayed
	 */
	public void displayLoan(Loan loan) {
		Util.flush();
		System.out.println("Created new loan!\n");
		System.out.println("ID:\t\t[" + loan.getId() + "]");
		System.out.println("Periode:\t[" + loan.getPeriod() + " dage]");
		System.out.println("Låner telefon:\t[" + loan.getPerson().getPhoneNr() + "]");
		System.out.println("serienummer:\t[" + loan.getCopy().getSerialNumber() + "]");
	}

	@Override
	public String getDescription() {
		return commandName;
	}

}
