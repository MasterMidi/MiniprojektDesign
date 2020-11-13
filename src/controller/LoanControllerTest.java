package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Copy;
import model.LP;
import model.LPContainer;
import model.Loan;
import model.Person;
import model.PersonContainer;

class LoanControllerTest {
	LoanController loanController;

	@BeforeEach
	void setUp() throws Exception {
		loanController = new LoanController();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testLoanPersonLink() throws Exception {
		Person p = new Person("Michael", "Gundorfslund 1, st. mf.", "24267667", "9000", "Aalborg");
		PersonContainer.getInstance().addPerson(p);
		
		LP lp = new LP("Abbey Road", "The Beatles", "974813", "1969-09-26");
		lp.addCopy(new Copy(lp, "84290823902", "2020-11-12", 100, false));
		LPContainer.getInstance().addLP(lp);
		
		loanController.createLoan();
		
		loanController.findPersons("24267667");
		loanController.selectPerson(0);
		
		loanController.findLPs("Abbey Road");
		loanController.selectLP(0);
		loanController.selectCopy(0);
		
		assertSame(p, loanController.getLoan().getPerson());
	}
	
	@Test
	void testLoanCopyLink() throws Exception {
		Person p = new Person("Julius", "Somewhere 1", "53381465", "9000", "Aalborg");
		PersonContainer.getInstance().addPerson(p);
		
		LP lp = new LP("Dark Side of the Moon", "Pink Floyd", "6246425", "1973-03-01");
		Copy copy = new Copy(lp, "98273549234", "2015-01-26", 100, false);
		lp.addCopy(copy);
		LPContainer.getInstance().addLP(lp);
		
		loanController.createLoan();
		
		loanController.findPersons("53381465");
		loanController.selectPerson(0);
		
		loanController.findLPs("Dark Side of the Moon");
		loanController.selectLP(0);
		loanController.selectCopy(0);
		
		assertSame(copy, loanController.getLoan().getCopy());
	}

}
