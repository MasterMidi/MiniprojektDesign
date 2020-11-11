package tui;

import java.util.ArrayList;
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
		loanController.createLoan();

		Util.flush();
		findPersons();

		Util.flush();
		findLPs();

		Util.flush();
		displayLoanConfirmation(loanController.getLoan());

		System.out.println();
		System.out.println("Successfuld oprettede et nyt lån");
	}

	public void findPersons() {
		System.out.println("Find person med navn eller telefon");
		ArrayList<Person> personArr = loanController.findPersons(TextInput.inputString("Søg"));

		for (int i = 0; i < personArr.size(); i++) {
			System.out.println("(" + i + ") " + personArr.get(i).getName() + "\t: " + personArr.get(i).getPhoneNr());
		}

		selectPerson();
	}

	public void selectPerson() {
		System.out.println("Vælg den ønskede person");
		ArrayList<Person> personArr = loanController.getPersonArr();
		boolean done = false;

		while (!done) {
			int key = TextInput.inputNumber("Valg");
			if (key < personArr.size()) {
				loanController.linkPerson(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		displayPerson();
	}

	public void displayPerson() {
		Util.flush();
		Person person = loanController.getLoan().getPerson();
		System.out.println("Navn:\t\t[" + person.getName() + "]");
		System.out.println("Telefon:\t[" + person.getPhoneNr() + "]");
		System.out.println("Addresse:\t[" + person.getAddress() + "]");
		System.out.println("By:\t\t[" + person.getCity() + "]");
		System.out.println("Postnummber:\t[" + person.getPostalCode() + "]");
	}

	public void findLPs() {
		System.out.println("Søg efter den ønskede LP");
		ArrayList<LP> lpArr = loanController.findLPs(TextInput.inputString("Søg"));

		for (int i = 0; i < lpArr.size(); i++) {
			System.out.println("(" + i + ") " + lpArr.get(i).getTitle());
		}

		selectLPs();
	}

	public void selectLPs() {
		System.out.println("Vælg den ønskede LP");
		ArrayList<LP> lpArr = loanController.getLpArr();
		boolean done = false;

		while (!done) {
			int key = TextInput.inputNumber("Valg");
			if (key < lpArr.size()) {
				lp = lpArr.get(key);
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		displayLP();
		//selectCopy(lp);
	}

	public void displayLP() {
		Util.flush();
		LP lp = loanController.getLoan().getPerson();
		System.out.println("Title:\t\t[" + lp.getTitle() + "]");
		System.out.println("Kunstner:\t[" + lp.getArtist() + "]");
		System.out.println("Udgivelses dato:[" + lp.getPublicationDate() + "]");
		System.out.println("Stregkode:\t[" + lp.getBarcode() + "]");
	}

	public void selectCopy(LP lp) {
		System.out.println("Vælg den ønskede kopi");
		ArrayList<Copy> copyArr = loanController.getCopyArr();
		Copy copy = null;

		while (copy == null) {
			int key = TextInput.inputNumber("Valg");
			if (key < copyArr.size()) {
				copy = copyArr.get(key);
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		loanController.linkCopy(copy.getSerialNumber());
	}

	public void displayLoanConfirmation(Loan loan) {
		Util.flush();
		System.out.println("ID:\t\t[" + loan.getId() + "]");
		System.out.println("Periode:\t[" + loan.getPeriod() + " dage]");
		System.out.println("Låner telefon:\t[" + loan.getPerson().getPhoneNr() + "]");
		System.out.println("serienummer:\t[" + loan.getCopy().getSerialNumber() + "]");
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

}
