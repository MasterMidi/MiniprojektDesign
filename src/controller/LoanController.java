package controller;

import java.util.ArrayList;
import java.util.Random;

import model.Copy;
import model.LP;
import model.Loan;
import model.LoanContainer;
import model.Person;

public class LoanController {
	private LoanContainer loanContainer;
	private Loan loan;
	
	private ArrayList<Person> personArr;
	private ArrayList<LP> lpArr;
	private ArrayList<Copy> copyArr;
	
	public LoanController() {
		loanContainer = LoanContainer.getInstance();
		
		personArr = new ArrayList<>();
		lpArr = new ArrayList<>();
		copyArr = new ArrayList<>();
	}
	
	public void createLoan() {
		loan = new Loan();
	}
	
	public ArrayList<Person> findPersons(String input){
		PersonController personController = new PersonController();
		Person[] persons = personController.findPerson(input);
		personArr = new ArrayList<>();
		
		for (int i = 0; i < persons.length; i++) {
			personArr.add(persons[i]);
		}
		
		return personArr;
	}
	
	public ArrayList<LP> findLPs(String title){
		LPController lpController = new LPController();
		LP[] lps = lpController.findLP(title);
		lpArr = new ArrayList<>();
		
		for (int i = 0; i < lps.length; i++) {
			lpArr.add(lps[i]);
		}
		
		return lpArr;
	}
	
	public Loan lendCopy(int period, String serialNumber, String phoneNr) {
		Random rnd = new Random();
		loan = new Loan("" + rnd.nextInt(10000), period, serialNumber, phoneNr);
		loanContainer.addLoan(loan);
		
		return loan;
	}
	
	public void linkPerson(int index) {
		loan.setPerson(personArr.get(index));
	}
	
	public void linkCopy(int index) {
		loan.setCopy(copyArr.get(index));
	}
	
	public Loan getLoan() {
		return loan;
	}

	public ArrayList<Person> getPersonArr() {
		return personArr;
	}

	public void setPersonArr(ArrayList<Person> personArr) {
		this.personArr = personArr;
	}

	public ArrayList<LP> getLpArr() {
		return lpArr;
	}

	public void setLpArr(ArrayList<LP> lpArr) {
		this.lpArr = lpArr;
	}

	public ArrayList<Copy> getCopyArr() {
		return copyArr;
	}

	public void setCopyArr(ArrayList<Copy> copyArr) {
		this.copyArr = copyArr;
	}
}
