package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LPContainerTest {
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindLPs() {
		LP lp = new LP("Abbey Road", "The Beatles", "974813", "1969-09-26");
		LP lp2 = new LP("Dark Side of the Moon", "Pink Floyd", "6246425", "1973-03-01");
		LPContainer.getInstance().addLP(lp);
		LPContainer.getInstance().addLP(lp2);
		
		LP lpTest = LPContainer.getInstance().findLPs("Abbey Road").get(0);
		
		assertSame(lp, lpTest);
	}

}
