package model;

import java.util.ArrayList;

public class LoanContainer {
	private static LoanContainer instance;
	private ArrayList<Loan> loans;
	
	public static LoanContainer getInstance() {
		if(instance == null) {
			instance = new LoanContainer();
		}
		
		return instance;
	}
	
	private LoanContainer() {
		loans = new ArrayList<>();
	}
	
	/**
	 * adds a loan to the container list
	 * @param loan the loan to be added
	 * @return if the operation was a success
	 */
	public boolean addLoan(Loan loan) {
		boolean res = false;
		
		if(loan != null) {
			loans.add(loan);
			res = true;
		}
		
		return res;
	}
}
