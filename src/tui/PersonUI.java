package tui;

import java.util.Iterator;

import commands.CreatePersonCommand;
import commands.DeletePersonCommand;
import commands.ReadPersonCommand;
import commands.UpdatePersonCommand;
import util.Util;

public class PersonUI extends MenuUI<Option> {
	
	public PersonUI() {
		super("håndter Personer");
		
		super.addOption(new CreatePersonCommand());
		super.addOption(new ReadPersonCommand());
		super.addOption(new UpdatePersonCommand());
		super.addOption(new DeletePersonCommand());
		
	}
	
	@Override
	/**
	 * Show which options the interface has
	 */
	public void printOptions() {
		System.out.println("****** " + getDescription() + " ******");
		System.out.println("(0) Tilbage");

		Iterator<Option> it = super.getOptions().iterator();
		for (int i = 0; i < super.getOptions().size() && it.hasNext(); i++) {
			String formatted = String.format("(%s) %s", (i + 1), it.next().getDescription());
			System.out.println(formatted);
			
		}
	}
	
}
