package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonContainerTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindPersons() {
		Person p1 = new Person("Michael", "Gundorfslund 1, st. mf.", "24267667", "9000", "Aalborg");
		Person p2 = new Person("Anders", "Gundorfslund 1, st. mf.", "31334010", "9000", "Aalborg");
		PersonContainer.getInstance().addPerson(p1);
		PersonContainer.getInstance().addPerson(p2);
		
		Person pTest = PersonContainer.getInstance().findPersons("24267667").get(0);
		
		assertSame(p1, pTest); 
	}
	
	@Test
	void testDeletePerson() {
		Person p1 = new Person("Julius", "Somewhere 1", "53381465", "9000", "Aalborg");
		PersonContainer.getInstance().addPerson(p1);
		
		PersonContainer.getInstance().deletePerson(p1.getPhoneNr());
		
		assertTrue(PersonContainer.getInstance().findPersons(p1.getPhoneNr()).isEmpty());
	}
	
	@Test
	void testSelectPerson() {
		Person p1 = new Person("Nicklas", "Somewhere 2", "20741072", "9000", "Aalborg");
		PersonContainer.getInstance().addPerson(p1);
		
		assertEquals(p1, PersonContainer.getInstance().selectPerson(p1.getPhoneNr()));
	}

	@Test
	void testUpdatePerson() {
		Person p1 = new Person("Alex", "Somewhere 3", "24986881", "9000", "Aalborg");
		PersonContainer.getInstance().addPerson(p1);
		PersonContainer.getInstance().updatePerson(p1.getPhoneNr(), null, null, "12345678", null, null);
		
		Person p1Test = PersonContainer.getInstance().selectPerson("12345678");
		assertSame(p1, p1Test);
	}
}
