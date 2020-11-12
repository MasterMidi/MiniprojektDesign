package tui;

public class MainMenuUI extends MenuUI {
	public MainMenuUI() {
		super("Main Menu");

		super.addOption(new LoanUI());
		super.addOption(new PersonUI());

		start();
	}

	@Override
	public void start() {
		super.start();
		System.out.println("Vi ses!");
	}
}
