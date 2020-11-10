package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LPContainer {
	private static LPContainer instance;
	private List<LP> lps;

	public static LPContainer getInstance() {
		if (instance == null) {
			instance = new LPContainer();
		}

		return instance;
	}

	private LPContainer() {
		lps = new ArrayList<>();
		
		lps.add(new LP("Abbey Road"));
		lps.add(new LP("Dark Side of the Moon"));
		lps.add(new LP("Guardians of the Galaxy Awesome Mix Vol. 1"));
		lps.add(new LP("Legend"));
		lps.add(new LP("Back to Black"));
	}
	
	public LP[] findLP(String title) {
		LP[] lpsFound = lps.stream()
				.filter(lp -> lp.getTitle().contains(title))
				.toArray(LP[]::new);

		return lpsFound;
	}
}
