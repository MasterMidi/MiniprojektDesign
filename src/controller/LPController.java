package controller;

import java.util.List;

import model.LP;
import model.LPContainer;

public class LPController {
	private LPContainer lpContainer;
	
	private List<LP> lpList;

	public LPController() {
		lpContainer = LPContainer.getInstance();
	}

	public List<LP> findLPs(String title) throws Exception {
		lpList = lpContainer.findLPs(title);
		
		if(lpList.isEmpty()) {
			throw new Exception("No matching lps");
		}

		return lpList;
	}
	
	public LP selectLP(int index) {
		LP lp = lpList.get(index);
		return lp;
	}
	
	public boolean createLP(String title, String artist, String barcode, String publicationDate) {
		LP lp = new LP(title, artist, barcode, publicationDate);
		return lpContainer.addLP(lp);
	}

	public List<LP> getLpList() {
		return lpList;
	}
}
