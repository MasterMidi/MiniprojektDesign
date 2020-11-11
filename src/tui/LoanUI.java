package tui;

import java.util.Iterator;

import util.Util;

public class LoanUI extends MenuUI<Option>{
	public LoanUI() {
		super("Låner Menu");
		
		super.addOption(new LendCommand());
	}
	
	@Override
	public void printOptions() {
		Util.flush();
		System.out.println("****** " + getDescription() + " ******");
		System.out.println("(0) Tilbage");

		Iterator<Option> it = super.getOptions().iterator();
		for (int i = 0; i < super.getOptions().size() && it.hasNext(); i++) {
			System.out.println("(" + (i + 1) + ") " + it.next().getDescription());
		}
	}
}
