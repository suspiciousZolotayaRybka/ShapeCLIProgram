package Project1;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class PromptMethod {

	private static Scanner stdin = new Scanner(System.in);

	/**
	 * This method takes a minimum and maximum value and prompt the user to enter an
	 * Integer until they enter an integer within range.
	 *
	 * @param minVal The minimum value, inclusive, the user can enter.
	 * @param maxVal The maximum value, inclusive, the user can enter
	 * @return The final integer value the user enters, always between minVal and
	 *         MaxVal. Note: returnInt, used for the return value, uses the Integer
	 *         wrapper class to verify integer is not null.
	 */
	public static int promptReturnInt(int minVal, int maxVal) {
		Integer returnInt = null;
		// While the user has not yet entered an int or it is not in range
		while ((returnInt == null) || (returnInt < minVal) || (returnInt > maxVal)) {
			try {
				System.out.println();
				String userInput = stdin.next();
				System.out.println();
				returnInt = Integer.parseInt(userInput);

				if ((returnInt < minVal) || (returnInt > maxVal)) {
					throw (new IllegalArgumentException());
				}
			} catch (Exception e) {
				System.out.printf("Sorry, I do not Understand. Enter #%d-%d%n", minVal, maxVal);
				stdin.nextLine();
			}
		}
		stdin.nextLine();
		return returnInt;
	}

	/**
	 * This method takes a minimum and maximum value and prompt the user to enter a
	 * Double until they enter a double within range.
	 *
	 * @param minVal The minimum value, inclusive, the user can enter.
	 * @param maxVal The maximum value, inclusive, the user can enter
	 * @return The final double value the user enters, always between minVal and
	 *         MaxVal. Note: returnDouble, used for the return value, uses the
	 *         Double wrapper class to verify double is not null.
	 */
	public static double promptReturnDouble(double minVal, double maxVal) {
		Double returnDouble = null;
		// While the user has not yet entered an int or it is not in range
		while ((returnDouble == null) || (returnDouble < minVal) || (returnDouble > maxVal)) {
			try {
				System.out.println();
				String userInput = stdin.next();
				System.out.println();
				returnDouble = Double.parseDouble(userInput);

				if ((returnDouble < minVal) || (returnDouble > maxVal)) {
					throw (new IllegalArgumentException());
				}
			} catch (Exception e) {
				System.out.printf("Sorry, I do not Understand. Enter #%.2f-%.2f%n", minVal, maxVal);
				stdin.nextLine();
			}
		}
		stdin.nextLine();
		return returnDouble;
	}

	/**
	 * This method returns true or false based on the user entering yes or no.
	 *
	 * @return Return true or false based on user input
	 */
	public static boolean promptReturnBoolean() {
		boolean returnBoolean = false;
		String userInput = "";
		System.out.println("Y or N");

		do {
			try {
				System.out.println();
				// Use regex to find matching user inputs
				userInput = stdin.next(Pattern.compile("[yYnN]"));
				System.out.println();
				returnBoolean = userInput.toUpperCase().equals("Y") ? true : false;
			} catch (Exception e) {
				System.out.println("Sorry I do not understand. Enter Y or N");
				stdin.nextLine();
			}
		} while (!(userInput.toUpperCase().equals("Y") || userInput.toUpperCase().equals("N")));
		stdin.nextLine();
		return returnBoolean;
	}

	public static void closeScanner() {
		stdin.close();
	}
}
