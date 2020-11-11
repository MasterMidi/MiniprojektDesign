package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonContainer {
	private static PersonContainer instance;
	private List<Person> persons;

	public static PersonContainer getInstance() {
		if (instance == null) {
			instance = new PersonContainer();
		}

		return instance;
	}

	private PersonContainer() {
		persons = new ArrayList<>();
		
		//Dummy data
		persons.add(new Person("Michael", "24267667"));
		persons.add(new Person("Anders", "41398413"));
		persons.add(new Person("Jannie", "30616515"));
		persons.add(new Person("Johnny", "12938102"));
		persons.add(new Person("Michael", "132837198"));
		persons.add(new Person("Julius", "53381465"));
		persons.add(new Person("Nicklas", "20741072"));
		persons.add(new Person("Alex", "24986881"));
	}

	public Person[] findPerson(String input) {
		boolean isInt = input.matches("\\d+");
		
		Person[] personsFound = persons.stream()
				.filter(p -> (isInt) ? p.getPhoneNr().contains(input) : p.getName().contains(input))
				.toArray(Person[]::new);
		
		return personsFound;
	}
	
	public Person selectPerson(String id)
	{
		Optional<Person> person = persons.stream()
				.filter(p -> p.getPhoneNr().equals(id)).findFirst();
		
		return person.get();
		
	}
	
	public void deletePerson(String id)
	{
		persons.remove(selectPerson(id));
		
	}
	
	public void updatePerson(String id, String name, String address, String phoneNr, String postalCode, String city)
	{
		
		int index = persons.indexOf(selectPerson(id));

		//Null check. If null, use the already set value
		persons.get(index).setName((name == null || name.isEmpty()) ? persons.get(index).getName() : name);
		persons.get(index).setName((address == null || address.isEmpty()) ? persons.get(index).getAddress() : address);
		persons.get(index).setName((phoneNr == null || phoneNr.isEmpty()) ? persons.get(index).getPhoneNr() : phoneNr);
		persons.get(index).setName((postalCode == null || postalCode.isEmpty()) ? persons.get(index).getPostalCode() : postalCode);
		persons.get(index).setName((city == null || city.isEmpty()) ? persons.get(index).getCity() : city);
		
	}
}
