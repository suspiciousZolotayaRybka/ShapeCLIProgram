package Project1;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

/* CMSC 335 7382 Object-Oriented and Concurrent Programming
 * Professor Amitava Karmaker
 * Project 1
 * Driver.java
 * Isaac Finehout
 * 16 March 2025
 *
 * This the driver for the Shape.java family. It allows the user to use a
 * command line driven menu that can construct each of the TwoDimensional and
 * ThreeDimensional Shape subclasses. The menu continues to loop prompting for
 * a specific class and then prompts for appropriate input parameters. The
 * values returned are the volume or area as appropriate to the shape. Error
 * checks make sure appropriate menu items and types of data were input and
 * prompt the user to enter to correct data. An option to exit the program
 * is available as well that will provide an appropriate Thank you message
 * along with the current date and time. Its is-a and has-a relationships are
 * as follows:
 *
 * is-a(n): Shape
 *
 * has-a(n): volume
 *
 *
 * @author fineh
 *
 */

public class Driver {

	// Declare user variables

	private static UserChoice userChoice;
	private static boolean isRunningProgram = true;

	/**
	 * Run the main program
	 */
	private static void runMain() {
		programWelcome();

		do {
			printMenu();
			userChoice = promptUserChoice();
			processUserChoice(userChoice);
			if (userChoice != UserChoice.EXIT_THE_PROGRAM) {
				// If the user chooses to exit, they will not be prompted to continue
				isRunningProgram = promptUserToContinue();
			}
		} while (isRunningProgram);
		PromptMethod.closeScanner();
		programFarewell();
	}

	/**
	 * Welcome the user to the program
	 */
	private static void programWelcome() {
		System.out.printf("%sWelcome to the Java OO Shapes Program%s%n", "*".repeat(10), "*".repeat(10));
	}

	/**
	 * Say goodbye to the user. The date is also displayed in format: Mmm DD at
	 * HH:MM AMPM.
	 */
	private static void programFarewell() {
		ZonedDateTime d = ZonedDateTime.now();
		String amPm = (d.get(ChronoField.AMPM_OF_DAY) == 0) ? "AM" : "PM";
		System.out.printf("Thanks for using the program. Today is %s %d at %s:%s %s.%n%n",
				d.getMonth().toString().substring(0, 1).toUpperCase()
						+ d.getMonth().toString().substring(1, 3).toLowerCase(),
				d.getDayOfMonth(), d.getHour(), d.getMinute(), amPm);
	}

	/**
	 * Print the menu for the Shapes program
	 */
	private static void printMenu() {
		String menu = String.format("%nSelect from the menu below:%n%n"
				+ "1. Construct a Circle%n"
				+ "2. Construct a Rectangle%n"
				+ "3. Construct a Square%n"
				+ "4. Construct a Triangle%n"
				+ "5. Construct a Sphere%n"
				+ "6. Construct a Cube%n"
				+ "7. Construct a Cone%n"
				+ "8. Construct a Cylinder%n"
				+ "9. Construct a Torus%n"
				+ "10. Exit the program%n", (Object) null);
		System.out.print(menu);
	}

	/**
	 * This method calls on promptReturnInt with the values 1 - 10. It then returns
	 * the UserChoice (ENUM) based on the integer the user entered.
	 *
	 * @return UserChoice ENUM for the option the user selected.
	 */
	private static UserChoice promptUserChoice() {
		UserChoice userChoice = null;
		int userIntChoice = PromptMethod.promptReturnInt(1, 10);
		switch (userIntChoice) {
		case 1:
			userChoice = UserChoice.CONSTRUCT_A_CIRCLE;
			break;
		case 2:
			userChoice = UserChoice.CONSTRUCT_A_RECTANGLE;
			break;
		case 3:
			userChoice = UserChoice.CONSTRUCT_A_SQUARE;
			break;
		case 4:
			userChoice = UserChoice.CONSTRUCT_A_TRIANGLE;
			break;
		case 5:
			userChoice = UserChoice.CONSTRUCT_A_SPHERE;
			break;
		case 6:
			userChoice = UserChoice.CONSTRUCT_A_CUBE;
			break;
		case 7:
			userChoice = UserChoice.CONSTRUCT_A_CONE;
			break;
		case 8:
			userChoice = UserChoice.CONSTRUCT_A_CYLINDER;
			break;
		case 9:
			userChoice = UserChoice.CONSTRUCT_A_TORUS;
			break;
		case 10:
			userChoice = UserChoice.EXIT_THE_PROGRAM;
			break;
		}
		return userChoice;

	}

	/**
	 * This method takes the user choice and calls a method to process the shape the
	 * user chose.
	 *
	 * @param userChoice
	 */
	private static void processUserChoice(UserChoice userChoice) {
		switch (userChoice) {
		case CONSTRUCT_A_CIRCLE:
			constructACircle();
			break;
		case CONSTRUCT_A_RECTANGLE:
			constructARectangle();
			break;
		case CONSTRUCT_A_SQUARE:
			constructASquare();
			break;
		case CONSTRUCT_A_TRIANGLE:
			constructATriangle();
			break;
		case CONSTRUCT_A_SPHERE:
			constructASphere();
			break;
		case CONSTRUCT_A_CUBE:
			constructACube();
			break;
		case CONSTRUCT_A_CONE:
			constructACone();
			break;
		case CONSTRUCT_A_CYLINDER:
			constructACylinder();
			break;
		case CONSTRUCT_A_TORUS:
			constructATorus();
			break;
		case EXIT_THE_PROGRAM:
			isRunningProgram = false;
			break;
		}
	}

	/**
	 * This method asks the user to construct a circle then displays its area.
	 */
	private static void constructACircle() {
		double radius;
		System.out.println("You have selected a Circle\n");
		System.out.println("What is the radius?");
		radius = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Circle circle = new Circle(radius);
		System.out.printf("The area of the Circle is %.2f.", circle.getArea());
	}

	/**
	 * This method asks the user to construct a rectangle then displays its area.
	 */
	private static void constructARectangle() {
		double length;
		double width;
		System.out.println("You have selected a Rectangle\n");
		System.out.println("What is the length?");
		length = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.println("What is the width?");
		width = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Rectangle rectangle = new Rectangle(length, width);
		System.out.printf("The area of the Rectangle is %.2f.", rectangle.getArea());
	}

	/**
	 * This method asks the user to construct a square then displays its area.
	 */
	private static void constructASquare() {
		double side;
		System.out.println("You have selected a Square\n");
		System.out.println("What is the side length?");
		side = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Square square = new Square(side);
		System.out.printf("The area of the Square is %.2f.", square.getArea());
	}

	/**
	 * This method asks the user to construct a triangle then displays its area.
	 */
	private static void constructATriangle() {
		double base;
		double height;
		System.out.println("You have selected a Triangle\n");
		System.out.println("What is the base length?");
		base = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.println("What is the height?");
		height = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Triangle triangle = new Triangle(base, height);
		System.out.printf("The area of the Triangle is %.2f.", triangle.getArea());
	}

	/**
	 * This method asks the user to construct a sphere then displays its volume.
	 */
	private static void constructASphere() {
		double radius;
		System.out.println("You have selected a Sphere\n");
		System.out.println("What is the radius?");
		radius = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Sphere sphere = new Sphere(radius);
		System.out.printf("The volume of the Sphere is %.2f.", sphere.getVolume());
	}

	/**
	 * This method asks the user to construct a cube then displays its volume.
	 */
	private static void constructACube() {
		double side;
		System.out.println("You have selected a Cube\n");
		System.out.println("What is the side length?");
		side = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Cube cube = new Cube(side);
		System.out.printf("The volume of the Cube is %.2f.", cube.getVolume());
	}

	/**
	 * This method asks the user to construct a cone then displays its volume.
	 */
	private static void constructACone() {
		double radius;
		double height;
		System.out.println("You have selected a Cone\n");
		System.out.println("What is the radius?");
		radius = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.println("What is the height?");
		height = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Cone cone = new Cone(radius, height);
		System.out.printf("The volume of the Cone is %.2f.", cone.getVolume());
	}

	/**
	 * This method asks the user to construct a cylinder then displays its volume.
	 */
	private static void constructACylinder() {
		double radius;
		double height;
		System.out.println("You have selected a Cylinder\n");
		System.out.println("What is the radius?");
		radius = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.println("What is the height?");
		height = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Cylinder cylinder = new Cylinder(radius, height);
		System.out.printf("The volume of the Cylinder is %.2f.", cylinder.getVolume());
	}

	/**
	 * This method asks the user to construct a torus then displays its volume.
	 */
	private static void constructATorus() {
		double minorRadius;
		double majorRadius;
		System.out.println("You have selected a Torus\n");
		System.out.println("What is the minor radius?");
		minorRadius = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.println("What is the major radius?");
		majorRadius = PromptMethod.promptReturnDouble(Double.MIN_VALUE, Double.MAX_VALUE);
		Torus torus = new Torus(minorRadius, majorRadius);
		System.out.printf("The volume of the Torus is %.2f.", torus.getVolume());
	}

	/**
	 * This prompts a yes or no answer from the user to continue running the
	 * program.
	 *
	 * @return Returns true or false based on user input
	 */
	private static boolean promptUserToContinue() {
		System.out.print("\n\nWould you like to continue? ");
		return PromptMethod.promptReturnBoolean();
	}

	public static void main(String args[]) {
		runMain();
	}
}
