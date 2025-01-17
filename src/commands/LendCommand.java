package commands;

import java.util.Iterator;
import java.util.List;

import controller.LoanController;
import model.Copy;
import model.LP;
import model.Loan;
import model.Person;
import tui.IOption;
import tui.TextInput;
import util.Util;

public class LendCommand implements IOption {
	private LoanController loanController;
	private String commandName = "Udlån LP";
	
	public LendCommand() {
		loanController = new LoanController();
	}

	@Override
	public void start() {
		loanController.createLoan();
		
		findPersons();
		selectPerson();
		findLPs();
		selectLP();

		if(displayCopyList()) {
			selectCopy();
			displayLoan(loanController.getLoan());
			
			System.out.println();
			System.out.println("Successfuld oprettede et nyt løn");
		}
	}

	public void findPersons() {
		Util.flush();
		boolean done = false;
		while(!done) {
			System.out.println("Find person med navn eller telefon");
			
			try {
				List<Person> personList = loanController.findPersons(TextInput.inputString("Søg"));
				displayPersonList(personList);
				done = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void displayPersonList(List<Person> personList) {
		StringBuilder formatted = new StringBuilder();
		
		for (int i = 0; i < personList.size(); i++) {
			formatted.append("(" + i + ") " + personList.get(i).getName() + "\t: " + personList.get(i).getPhoneNr() + "\n");
		}
		
		System.out.println(formatted.toString());
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
		Util.flush();		
		boolean done = false;
		while(!done) {
			System.out.println("Søg efter den ønskede LP");
			
			try {
				List<LP> lpList = loanController.findLPs(TextInput.inputString("Søg"));
				displayLPList(lpList);
				done = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void displayLPList(List<LP> lpList) {
		StringBuilder formatted = new StringBuilder();

		for (int i = 0; i < lpList.size(); i++) {
			formatted.append("(" + i + ") " + lpList.get(i).getTitle() + "\n");
		}

		System.out.println(formatted.toString());
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
	}
	
	public boolean displayCopyList() {
		List<Copy> copyList = loanController.getCopyList();
		boolean hasCopies = true;
		
		if(copyList.isEmpty()) {
			System.out.println("Beklager, men der var ingen kopier til denne LP");
			hasCopies = false;
		} else {
			StringBuilder formatted = new StringBuilder();
			
			Iterator<Copy> it = copyList.iterator();
			for(int i = 0; it.hasNext(); i++) {
				formatted.append("(" + i + ") " + it.next().getSerialNumber() + "\n");
			}
			
			System.out.println(formatted.toString());
		}
		
		return hasCopies;
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
