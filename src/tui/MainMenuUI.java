package tui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.Util;

public class MainMenuUI implements IMenu{
	private Map<Integer, IMenu> menues;
	private String menuName;
	
	public MainMenuUI() {
		// TODO Auto-generated constructor stub
		menuName = "Main Menu";
		
		menues = new HashMap<>();
		
		menues.put(1, new LoanUI());
		menues.put(2, new LoanUI());
		menues.put(3, new LoanUI());
		menues.put(4, new LoanUI());
		
		open();
	}
	
	public void open() {
		Util.flush();
		printMenues();
		choose();
	}
	
	public void choose() {
		int input = -1;
		
		while(input == -1) {
			int temp = TextInput.inputNumber("Valg");
			
			if(menues.containsKey(temp)) {
				input = temp;
			} else {
				Util.flush();
				System.out.println("Ikke en valid menu");
				printMenues();
			}
		}
		
		menues.get(input).open();
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	private void printMenues() {
		
		System.out.println("****** " + menuName + " ******");
		for(Entry<Integer, IMenu> entry : menues.entrySet()) {
			System.out.println("(" + entry.getKey() + ") " + entry.getValue().getMenuName());
		}
		
	}

}


