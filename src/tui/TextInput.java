package tui;

import java.util.Scanner;

/**
 * Description of TextInput goes here.
 * 
 * @author Istvan Knoll, Mogens Holm Iversen
 * @version 0.0.1 initial draft version
 */
public class TextInput {

	public TextInput() {
		// TODO Auto-generated constructor stub
	}

	public static int inputNumber(String question) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int number = 0;
		printQuestion(question);
		while (!keyboard.hasNextInt()) {
			System.out.println("Input skal være et tal - prøv igen");
			keyboard.nextLine();
			printQuestion(question);
		}
		number = keyboard.nextInt();
		return number;
	}

	public static String inputString(String question) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		printQuestion(question);
		String input = keyboard.nextLine();
		return input;
	}

	private static void printQuestion(String question) {
		System.out.println();
		System.out.print(" -> " + question + ": ");
	}
}
