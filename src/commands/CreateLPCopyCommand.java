package commands;

import java.util.List;

import controller.LPController;
import model.Copy;
import model.LP;
import tui.IOption;
import tui.TextInput;
import util.Util;

public class CreateLPCopyCommand implements IOption {

	LPController lpController;
	
	@Override
	public void start() {
		
		lpController = new LPController();
		
		Util.flush();
		System.out.println("****Opret Copy****");
		
		findLPs();
		LP lp = selectLP();
		
		System.out.println();
		String serialNumber = TextInput.inputString("Serienummer: \t\t");
		String purchaseDate = TextInput.inputString("Købsdato: \t\t");
		double purchasePrice = TextInput.inputNumber("Købspris: \t\t");
		
		lp.addCopy(new Copy(lp, serialNumber, purchaseDate, purchasePrice, false));
		
		
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Tilføj Copy";
	}
	
	public void findLPs() {
		Util.flush();		
		boolean done = false;
		while(!done) {
			System.out.println("Søg efter den ønskede LP");
			
			try {
				List<LP> lpList = lpController.findLPs(TextInput.inputString("Søg"));
				displayLPList(lpList);
				done = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void displayLPList(List<LP> lpList) {
		StringBuilder formatted = new StringBuilder();

		for (int i = 0; i < lpList.size(); i++) {
			formatted.append("(" + i + ") " + lpList.get(i).getTitle() + "\n");
		}

		System.out.println(formatted.toString());
	}

	public LP selectLP() {
		System.out.println("Vælg den ønskede LP");
		List<LP> lpList = lpController.getLpList();
		LP lp = null;
		boolean done = false;

		while (!done) {
			int key = TextInput.inputNumber("Valg");
			if (key < lpList.size()) {
				lp = lpController.selectLP(key);
				done = true;
			} else {
				System.out.println("Ikke en mulighed");
			}
		}

		return lp;
	}

	public void displayLP(LP lp) {
		Util.flush();
		System.out.println("Title:\t\t[" + lp.getTitle() + "]");
		System.out.println("Kunstner:\t[" + lp.getArtist() + "]");
		System.out.println("Udgivelses dato:[" + lp.getPublicationDate() + "]");
		System.out.println("Stregkode:\t[" + lp.getBarcode() + "]");
	}
}


