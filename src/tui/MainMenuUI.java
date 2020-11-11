package tui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.Util;

public class MainMenuUI implements IMenu {
	private Map<Integer, IMenu> menues;
	private String description = "Main Menu";

	public MainMenuUI() {
		menues = new HashMap<>();
		menues.put(1, new LoanUI());

		open();
	}

	public void open() {
		boolean done = false;
		while (!done) {
			printMenues();
			done = choice(done);
		}
	}

	public boolean choice(boolean done) {
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
		
		return done;
	}

	public String getDescription() {
		return description;
	}

	private void printMenues() {
		Util.flush();
		System.out.println("****** " + description + " ******");
		System.out.println("(0) Log af");
		for (Entry<Integer, IMenu> entry : menues.entrySet()) {
			System.out.println("(" + entry.getKey() + ") " + entry.getValue().getDescription());
		}
	}

}
