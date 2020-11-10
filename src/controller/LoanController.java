package controller;

import java.util.Random;

import model.LP;
import model.Loan;
import model.LoanContainer;
import model.Person;

public class LoanController {
	private LoanContainer loanContainer;
	private Loan loan;
	
	public LoanController() {
		loanContainer = LoanContainer.getInstance();
	}
	
	public Person[] findPerson(String input){
		PersonController personController = new PersonController();
		
		return personController.findPerson(input);
		
	}
	
	public LP[] findLP(String title){
		LPController lpController = new LPController();
		
		return lpController.findLP(title);
		
	}
	
	public boolean lendCopy(int period, String serialNumber, String phoneNr) {
		Random rnd = new Random();
		loan = new Loan("" + rnd.nextInt(10000), period, serialNumber, phoneNr);
		loanContainer.addLoan(loan);
		
		return true;
	}
}
