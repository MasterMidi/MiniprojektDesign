package tui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import controller.LoanController;
import model.Copy;
import model.LP;
import model.Person;
import util.Util;

public class LoanUI implements IMenu {
	private LoanController loanController;
	private Map<Integer, ICommand> options;
	private String menuName;

	public LoanUI() {
		menuName = "Loan Menu";

		options = new HashMap<Integer, ICommand>();

		options.put(1, new FindPersonCommand());

		this.loanController = new LoanController();
	}

	public void open() {
		choose();
	}

	public String getMenuName() {
		// TODO Auto-generated method stub
		return menuName;
	}

	@Override
	public void choose() {
		Util.flush();
		Person person = selectPersons();
		
		Util.flush();
		LP lp = selectLPs();
		
		Util.flush();
		Copy copy = selectCopies(lp);
		
		Util.flush();
		if(loanController.lendCopy(7, copy.getSerialNumber(), person.getPhoneNr())) {
			System.out.println("Successfully created new loan");
		} else {
			System.out.println("");
		}
	}

	public Person selectPersons() {
		Person[] persons = loanController.findPerson(TextInput.inputString("søg navn eller telefon"));
		Map<Integer, Person> personMap = new HashMap<>();
		Person person = null;

		for (int i = 0; i < persons.length; i++) {
			personMap.put(i, persons[i]);
			System.out.println("(" + i + ") " + persons[i].getName() + "\t: " + persons[i].getPhoneNr());
		}

		int key = TextInput.inputNumber("Valg");
		if (personMap.containsKey(key)) {
			person = personMap.get(key);
		}

		return person;
	}

	public LP selectLPs() {
		LP[] lps = loanController.findLP(TextInput.inputString("Søg"));
		Map<Integer, LP> lpMap = new HashMap<>();
		LP lp = null;

		for (int i = 0; i < lps.length; i++) {
			lpMap.put(i, lps[i]);
			System.out.println("(" + i + ") " + lps[i].getTitle());
		}

		int key = TextInput.inputNumber("Valg");
		if (lpMap.containsKey(key)) {
			lp = lpMap.get(key);
		}

		return lp;
	}

	public Copy selectCopies(LP lp) {
		Copy[] copies = lp.getCopies();
		Map<Integer, Copy> copyMap = new HashMap<>();
		Copy copy = null;

		for (int i = 0; i < copies.length; i++) {
			copyMap.put(i, copies[i]);
			System.out.println("(" + i + ") " + copies[i].getSerialNumber());
		}

		int key = TextInput.inputNumber("Valg");
		if (copyMap.containsKey(key)) {
			copy = copyMap.get(key);
		}

		return copy;
	}
}
