package tui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import controller.LoanController;
import util.Util;

public class LoanUI implements IMenu {
	private LoanController loanController;
	private Map<Integer, ICommand> options;
	private String description = "Låner menu";

	public LoanUI() {
		options = new HashMap<Integer, ICommand>();
		options.put(1, new LendCommand());

		this.loanController = new LoanController();
	}

	public void open() {
		boolean done = false;
		
		Util.flush();
		while (!done) {
			printOptions();
			done = choice(done);
		}
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public boolean choice(boolean done) {
		int input = -1;

		while (input == -1) {
			int temp = TextInput.inputNumber("Valg");

			if (options.containsKey(temp)) {
				input = temp;
				options.get(input).execute();
			} else {
				if (temp == 0) {
					input = temp;
					done = true;
					System.out.println("Vi ses!");
				} else {
					Util.flush();
					System.out.println("Ikke en valgmulighed");
					printOptions();
				}
			}
		}
		
		return done;
	}
	
	private void printOptions() {
		System.out.println("****** " + description + " ******");
		System.out.println("(0) Tilbage");
		for (Entry<Integer, ICommand> entry : options.entrySet()) {
			System.out.println("(" + entry.getKey() + ") " + entry.getValue().getCommandName());
		}
	}
}
