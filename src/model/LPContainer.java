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
