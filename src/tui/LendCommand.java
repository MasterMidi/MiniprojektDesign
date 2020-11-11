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
	private String commandName = "Udl�n LP";

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
		System.out.println("Successfuld oprettede et nyt l�n");
	}

	public void findPersons() {
		System.out.println("Find person med navn eller telefon");
		Person[] persons = loanController.findPerson(TextInput.inputString("S�g"));
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println("(" + i + ") " + persons[i].getName() + "\t: " + persons[i].getPhoneNr());
		}
		
		selectPerson();
	}

	public void selectPerson() {
		System.out.println("V�lg den �nskede person");
		ArrayList<Person> personArr = loanController.getPersonArr();
		Person person = null;

		while (person == null) {
			int key = TextInput.inputNumber("Valg");
			if (key < personArr.size()) {
				loanController.linkPerson(personArr.get(key).getPhoneNr());
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
		System.out.println("S�g efter den �nskede LP");
		LP[] lps = loanController.findLP(TextInput.inputString("S�g"));

		for (int i = 0; i < lps.length; i++) {
			System.out.println("(" + i + ") " + lps[i].getTitle());
		}
		
		selectLPs();
	}

	public void selectLPs() {
		System.out.println("V�lg den �nskede LP");
		ArrayList<LP> lpArr = loanController.getLpArr();
		LP lp = null;

		while (lp == null) {
			int key = TextInput.inputNumber("Valg");
			if (key < lpArr.size()) {
				lp = lpArr.get(key);
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		displayLP(lp);
		selectCopy(lp);
	}

	public void displayLP(LP lp) {
		Util.flush();
		System.out.println("Title:\t\t[" + lp.getTitle() + "]");
		System.out.println("Kunstner:\t[" + lp.getArtist() + "]");
		System.out.println("Udgivelses dato:[" + lp.getPublicationDate() + "]");
		System.out.println("Stregkode:\t[" + lp.getBarcode() + "]");
	}

	public void selectCopy(LP lp) {
		System.out.println("V�lg den �nskede kopi");
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
		System.out.println("L�ner telefon:\t[" + loan.getPhoneNr() + "]");
		System.out.println("serienummer:\t[" + loan.getSerialNumber() + "]");
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

}
