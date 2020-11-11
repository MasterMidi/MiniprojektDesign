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
	
	public Person[] findPerson(String input){
		PersonController personController = new PersonController();
		Person[] persons = personController.findPerson(input);
		personArr = new ArrayList<>();
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println("(" + i + ") " + persons[i].getName() + "\t: " + persons[i].getPhoneNr());
		}
		
		return persons;
	}
	
	public LP[] findLP(String title){
		LPController lpController = new LPController();
		
		return lpController.findLP(title);
		
	}
	
	public Loan lendCopy(int period, String serialNumber, String phoneNr) {
		Random rnd = new Random();
		loan = new Loan("" + rnd.nextInt(10000), period, serialNumber, phoneNr);
		loanContainer.addLoan(loan);
		
		return loan;
	}
	
	public void linkPerson(String phoneNr) {
		loan.setPhoneNr(phoneNr);
	}
	
	public void linkCopy(String serialNumber) {
		loan.setSerialNumber(serialNumber);
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
