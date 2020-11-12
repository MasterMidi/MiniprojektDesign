package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Copy;
import model.LP;
import model.Loan;
import model.LoanContainer;
import model.Person;

public class LoanController {
	private LoanContainer loanContainer;
	private Loan loan;
	
	private List<Person> personList;
	private List<LP> lpList;
	private List<Copy> copyList;
	
	public LoanController() {
		loanContainer = LoanContainer.getInstance();
		
		personList = new ArrayList<>();
		lpList = new ArrayList<>();
		copyList = new ArrayList<>();
	}
	
	public void createLoan() {
		loan = new Loan();
	}
	
	
	public String findPersons(String input){ //TODO flyt til metode under PersonController
		PersonController personController = new PersonController();
		personList = personController.findPersons(input);
		
		return personController.displayPersonList(personList);
	}
	
	public List<LP> findLPs(String title){ //TODO flyt til metode under LPController
		LPController lpController = new LPController();
		LP[] lps = lpController.findLP(title);
		lpList = new ArrayList<>();
		
		for (int i = 0; i < lps.length; i++) {
			lpList.add(lps[i]);
		}
		
		return lpList;
	}
	
	public Loan lendCopy(int period, String serialNumber, String phoneNr) {
		Random rnd = new Random();
		loan = new Loan("" + rnd.nextInt(10000), period);
		loanContainer.addLoan(loan);
		
		return loan;
	}
	
	public void linkPerson(int index) {
		loan.setPerson(personList.get(index));
	}
	
	public void linkCopy(int index) {
		loan.setCopy(copyList.get(index));
	}
	
	public Loan getLoan() {
		return loan;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonArr(ArrayList<Person> personArr) {
		this.personList = personArr;
	}

	public List<LP> getLpArr() {
		return lpList;
	}

	public void setLpArr(ArrayList<LP> lpArr) {
		this.lpList = lpArr;
	}

	public List<Copy> getCopyArr() {
		return copyList;
	}

	public void setCopyArr(ArrayList<Copy> copyArr) {
		this.copyList = copyArr;
	}
}
