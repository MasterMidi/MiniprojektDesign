package tui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Util;

/**
 * 
 * @author Michael
 *
 * @param <T>
 */
public abstract class MenuUI implements Option{
	private String description;
	private List<Option> options;
	
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
	
	public List<Option> getOptions(){
		return new ArrayList<>(options);
	}

	public boolean choice(boolean exit) {
		boolean done = false;

		while (!done) {
			int input = TextInput.inputNumber("Vælg");

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
	
	public void addOption(Option option) {
		options.add(option);
	}

	public void printOptions() {
		System.out.println("****** " + description + " ******");
		System.out.println("(0) Log af");

		Iterator<Option> it = options.iterator();
		for (int i = 0; i < options.size() && it.hasNext(); i++) {
			System.out.println("(" + (i + 1) + ") " + it.next().getDescription());
		}
	}
	
	
	
}
