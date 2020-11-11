package tui;

public interface IMenu {
	public void open();
	public String getDescription();
	public boolean choice(boolean done);
}
