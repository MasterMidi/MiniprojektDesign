package tui;

public class MainMenuUI extends MenuUI<Option>{
	public MainMenuUI() {
		super("Main Menu");
		
		super.addOption(new LoanUI());

		start();
	}
	
	@Override
	public void start() {
		super.start();
		System.out.println("Vi ses!");
	}
}
