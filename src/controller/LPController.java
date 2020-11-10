package controller;

import model.LP;
import model.LPContainer;

public class LPController {
	private LPContainer lpContainer;
	
	public LPController() {
		lpContainer = LPContainer.getInstance();
	}
	
	public LP[] findLP(String title){
		return lpContainer.findLP(title);
		
	}
}
