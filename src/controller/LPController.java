package controller;

import java.util.List;

import model.LP;
import model.LPContainer;

public class LPController {
	private LPContainer lpContainer;

	public LPController() {
		lpContainer = LPContainer.getInstance();
	}

	public List<LP> findLPs(String title) {
		return lpContainer.findLPs(title);
	}

	public String displayLPList(List<LP> lpList) {
		StringBuilder formatted = new StringBuilder();

		for (int i = 0; i < lpList.size(); i++) {
			formatted.append("(" + i + ") " + lpList.get(i).getTitle() + "\n");
		}

		return formatted.toString();
	}
}
