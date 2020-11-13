package tui;

import java.util.Iterator;

import commands.CreateLPCommand;
import commands.CreateLPCopyCommand;

public class LPUI extends MenuUI{
	public LPUI() {
		super("LP Menu");
		
		super.addOption(new CreateLPCommand());
		super.addOption(new CreateLPCopyCommand());
	}
	
	@Override
	public void printOptions() {
		System.out.println("****** " + getDescription() + " ******");
		System.out.println("(0) Tilbage");

		Iterator<IOption> it = super.getOptions().iterator();
		for (int i = 0; i < super.getOptions().size() && it.hasNext(); i++) {
			String formatted = String.format("(%s) %s", (i + 1), it.next().getDescription());
			System.out.println(formatted);
			
		}
	}
}
