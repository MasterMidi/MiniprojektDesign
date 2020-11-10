package controller;

import java.util.ArrayList;

import model.Loan;
import model.LoanContainer;
import model.Person;

public class LoanController {
	private LoanContainer loanContainer;
	private Loan loan;
	
	public LoanController() {
		loanContainer = LoanContainer.getInstance();
	}
	
	public ArrayList<Person> findPerson(){
		
	}
}
