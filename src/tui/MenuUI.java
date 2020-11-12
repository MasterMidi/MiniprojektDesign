package tui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Util;

public abstract class MenuUI<T extends Option> implements Option{
	private String description;
	private List<T> options;
	
	public MenuUI(String description) {
		this.description = description;
		
		options = new ArrayList<>();
	}

	public void start() {
		Util.flush();
		boolean exit = false;
		while (!exit) {
			printOptions();
			exit = choice(exit);
		}
	}

	public String getDescription() {
		return description;
	}
	
	public List<T> getOptions(){
		return new ArrayList<>(options);
	}

	public boolean choice(boolean exit) {
		boolean done = false;

		while (!done) {
			int input = TextInput.inputNumber("V�lg");

			if (input == 0) {
				exit = true;
				done = true;
			} else if (input > 0 && input <= options.size()) {
				options.get(--input).start();
				done = true;
			} else {
				Util.flush();
				System.out.println("Ikke en mulighed");
				printOptions();
			}

		}

		return exit;
	}
	
	public void addOption(T option) {
		options.add(option);
	}

	public void printOptions() {
		Util.flush();
		System.out.println("****** " + description + " ******");
		System.out.println("(0) Log af");

		Iterator<T> it = options.iterator();
		for (int i = 0; i < options.size() && it.hasNext(); i++) {
			System.out.println("(" + (i + 1) + ") " + it.next().getDescription());
		}
	}
	
	
	
}
