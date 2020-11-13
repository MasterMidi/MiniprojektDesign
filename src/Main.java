import model.Copy;
import model.LP;
import model.LPContainer;
import model.Person;
import model.PersonContainer;
import tui.MainMenuUI;

public class Main {

	public static void main(String[] args) {
		PersonContainer personContainer = PersonContainer.getInstance();

		// Dummy data
		personContainer.addPerson(new Person("Michael", "Gundorfslund 1, st. mf.", "24267667", "9000", "Aalborg"));
		personContainer.addPerson(new Person("Anders", "Gundorfslund 1, st. mf.", "31334010", "9000", "Aalborg"));
		personContainer.addPerson(new Person("Jannie", "Urnehøjen 11", "30616515", "7400", "Herning"));
		personContainer.addPerson(new Person("Johnny", "Urnehøjen 11", "12938102", "7400", "Herning"));
		personContainer.addPerson(new Person("Julius", "Somewhere 1", "53381465", "9000", "Aalborg"));
		personContainer.addPerson(new Person("Nicklas", "Somewhere 2", "20741072", "9000", "Aalborg"));
		personContainer.addPerson(new Person("Alex", "Somewhere 3", "24986881", "9000", "Aalborg"));

		LPContainer lpContainer = LPContainer.getInstance();

		LP lp1 = new LP("Abbey Road", "The Beatles", "974813", "1969-09-26");
		lp1.addCopy(new Copy(lp1, "84290823902", "2020-11-12", 100, false));
		lp1.addCopy(new Copy(lp1, "89023409405", "2010-06-03", 100, false));
		lp1.addCopy(new Copy(lp1, "80693720563", "2015-01-26", 100, false));

		LP lp2 = new LP("Dark Side of the Moon", "Pink Floyd", "6246425", "1973-03-01");
		lp2.addCopy(new Copy(lp2, "98273549234", "2015-01-26", 100, false));
		lp2.addCopy(new Copy(lp2, "78673909330", "2015-01-26", 100, false));

		LP lp3 = new LP("Guardians of the Galaxy: Awesome Mix Vol. 1", "Guardians of the Galaxy", "9573216",
				"2014-06-29");
		lp3.addCopy(new Copy(lp3, "29387671098", "2015-01-26", 100, false));
		lp3.addCopy(new Copy(lp3, "20394977347", "2015-01-26", 100, false));
		lp3.addCopy(new Copy(lp3, "98778929504", "2015-01-26", 100, false));
		lp3.addCopy(new Copy(lp3, "53894579235", "2015-01-26", 100, false));
		lp3.addCopy(new Copy(lp3, "42908802780", "2015-01-26", 100, false));
		
		LP lp4 = new LP("Legend", "Bob Marley & The Wailers", "1436785", "1984-04-08");
		lp4.addCopy(new Copy(lp4, "45745645627", "2015-01-26", 100, false));

		LP lp5 = new LP("Back to Black", "Amy Winehouse", "8971098", "2006-09-26");

		LP lp6 = new LP("Thriller", "Michael Jackson", "2387462", "1982-11-30");
		lp6.addCopy(new Copy(lp6, "96897438762", "2015-01-26", 100, false));
		lp6.addCopy(new Copy(lp6, "45807428993", "2015-01-26", 100, false));

		LP lp7 = new LP("Sgt. Pepper’s Lonely Hearts Club Band", "The Beatles", "809132374", "1967-04-26");

		LP lp8 = new LP("Rumors", "Fleetwood Mac", "34678463", "1977-02-04");
		lp8.addCopy(new Copy(lp8, "42990623485", "2015-01-26", 100, false));
		lp8.addCopy(new Copy(lp8, "98232876444", "2015-01-26", 100, false));
		lp8.addCopy(new Copy(lp8, "49823749283", "2015-01-26", 100, false));
		lp8.addCopy(new Copy(lp8, "56789174928", "2015-01-26", 100, false));

		LP lp9 = new LP("Kind of Blue", "Miles Davis", "0365092", "1959-03-02");
		lp9.addCopy(new Copy(lp9, "84572938474", "2015-01-26", 100, false));
		lp9.addCopy(new Copy(lp9, "59871049099", "2015-01-26", 100, false));
		lp9.addCopy(new Copy(lp9, "42789687924", "2015-01-26", 100, false));
		lp9.addCopy(new Copy(lp9, "98723848524", "2015-01-26", 100, false));

		LP lp10 = new LP("Born To Die", "Lana Del Rey", "1231235", "2012-01-27");
		lp10.addCopy(new Copy(lp10, "4293879529", "2015-01-26", 100, false));

		lpContainer.addLP(lp1);
		lpContainer.addLP(lp2);
		lpContainer.addLP(lp3);
		lpContainer.addLP(lp4);
		lpContainer.addLP(lp5);
		lpContainer.addLP(lp6);
		lpContainer.addLP(lp7);
		lpContainer.addLP(lp8);
		lpContainer.addLP(lp9);
		lpContainer.addLP(lp10);

		new MainMenuUI();
	}

}
