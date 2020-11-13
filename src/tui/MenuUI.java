package tui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.Util;

/**
 * An abstract class to contain core menu functionality for the system.
 */
public abstract class MenuUI implements IOption {
	private String description;
	private List<IOption> options;

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

	/**
	 * A method to retrieve the list of options in this menu.
	 * 
	 * @return The list of available options in this menu
	 */
	public List<IOption> getOptions() {
		return new ArrayList<>(options);
	}

	/**
	 * 
	 * @param exit a boolean value used to decide whether or not to exit the current
	 *             menu.
	 * @return a boolean value to decide if this menu is to be finished and exited.
	 */
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

	/**
	 * Method to add new options to the menu.
	 * 
	 * @param option the option to add to the list of options
	 */
	public void addOption(IOption option) {
		options.add(option);
	}

	/**
	 * Prints all the options to the console, as a TUI for the user.
	 */
	public void printOptions() {
		System.out.println("****** " + description + " ******");
		System.out.println("(0) Log af");

		Iterator<IOption> it = options.iterator();
		for (int i = 0; i < options.size() && it.hasNext(); i++) {
			System.out.println("(" + (i + 1) + ") " + it.next().getDescription());
		}
	}
}
