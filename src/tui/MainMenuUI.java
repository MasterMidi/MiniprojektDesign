package tui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.Util;

public class MainMenuUI implements IMenu {
	private Map<Integer, IMenu> menues;
	private String menuName;
	private boolean done;

	public MainMenuUI() {
		// TODO Auto-generated constructor stub
		menuName = "Main Menu";

		menues = new HashMap<>();

		menues.put(1, new LoanUI());

		open();
	}

	public void open() {
		done = false;
		while (!done) {
			printMenues();
			choose();
		}
	}

	public void choose() {
		int input = -1;

		while (input == -1) {
			int temp = TextInput.inputNumber("Valg");

			if (menues.containsKey(temp)) {
				input = temp;
				menues.get(input).open();
			} else {
				if (temp == 0) {
					input = temp;
					done = true;
					System.out.println("Vi ses!");
				} else {
					Util.flush();
					System.out.println("Ikke en valid menu");
					printMenues();
				}
			}
		}
	}

	public String getMenuName() {
		return menuName;
	}

	private void printMenues() {
		Util.flush();
		System.out.println("****** " + menuName + " ******");
		System.out.println("(0) exit");
		for (Entry<Integer, IMenu> entry : menues.entrySet()) {
			System.out.println("(" + entry.getKey() + ") " + entry.getValue().getMenuName());
		}
	}

}
