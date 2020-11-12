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
		Random rnd = new Random();
		loan = new Loan("" + rnd.nextInt(10000), 30);
	}

	public List<Person> findPersons(String input) throws Exception {
		PersonController personController = new PersonController();
		personList = personController.findPersons(input);

		if(personList.isEmpty()) {
			throw new Exception("No matching person");
		}
		
		return personList;
	}

	public List<LP> findLPs(String title) throws Exception {
		LPController lpController = new LPController();
		lpList = lpController.findLPs(title);
		
		if(lpList.isEmpty()) {
			throw new Exception("No matching lps");
		}

		return lpList;
	}

	public Person selectPerson(int index) {
		Person person = personList.get(index);
		loan.setPerson(person);
		return person;
	}

	public LP selectLP(int index) {
		LP lp = lpList.get(index);
		copyList = lp.getCopies();
		return lp;
	}

	public void selectCopy(int index) {
		Copy copy = copyList.get(index);
		loan.setCopy(copy);
		lendCopy();
	}

	public void lendCopy() {
		loanContainer.addLoan(loan);
	}

	public Loan getLoan() {
		return loan;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	public List<LP> getLpList() {
		return lpList;
	}

	public void setLpList(ArrayList<LP> lpList) {
		this.lpList = lpList;
	}

	public List<Copy> getCopyList() {
		return copyList;
	}

	public void setCopyList(ArrayList<Copy> copyList) {
		this.copyList = copyList;
	}
}
