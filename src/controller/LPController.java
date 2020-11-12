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
}
