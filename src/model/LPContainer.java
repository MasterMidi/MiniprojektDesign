package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LPContainer {
	private static LPContainer instance;
	private List<LP> lpList;

	public static LPContainer getInstance() {
		if (instance == null) {
			instance = new LPContainer();
		}

		return instance;
	}

	private LPContainer() {
		lpList = new ArrayList<>();
	}
	
	/**
	 * Finds a list of LPs matching the title
	 * @param title the title to search for
	 * @return the list of matching LPs
	 */
	public List<LP> findLPs(String title) {
		List<LP> lpListFound = lpList.stream()
				.filter(lp -> lp.getTitle().contains(title))
				.collect(Collectors.toList());

		return lpListFound;
	}
	
	public boolean addLP(LP lp) {
		return lpList.add(lp);
	}
}
