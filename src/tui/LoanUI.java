package tui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import controller.LoanController;
import util.Util;

public class LoanUI implements IMenu {
	private LoanController loanController;
	private Map<Integer, ICommand> options;
	private String menuName;

	public LoanUI() {
		menuName = "Loan Menu";

		options = new HashMap<Integer, ICommand>();

		options.put(1, new FindPersonCommand());

		this.loanController = new LoanController();
	}

	public void open() {
		Util.flush();
		printOptions();
		choose();
	}

	public String getMenuName() {
		// TODO Auto-generated method stub
		return menuName;
	}

	public void choose() {
		int input = -1;

		while (input == -1) {
			int temp = TextInput.inputNumber("Valg");

			if (options.containsKey(temp)) {
				input = temp;
			} else {
				Util.flush();
				System.out.println("Ikke en valid menu");
				printOptions();
			}
		}

		options.get(input).execute();
	}

	private void printOptions() {

		System.out.println("****** " + menuName + " ******");
		for (Entry<Integer, ICommand> entry : options.entrySet()) {
			System.out.println("(" + entry.getKey() + ") " + entry.getValue().getCommandName());
		}

	}

}
