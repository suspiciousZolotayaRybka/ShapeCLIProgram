package Project1;

/* CMSC 335 7382 Object-Oriented and Concurrent Programming
 * Professor Amitava Karmaker
 * Project 1
 * TwoDimensionalShape.java
 * Isaac Finehout
 * 16 March 2025
 *
 * This is an abstract class named TwoDimensionalShape. It serves as a base for specifying two
 * dimensional shapes. Its is-a and has-a relationships
 * are as follows:
 *
 * is-a(n): Shape
 *
 * has-a(n): area, numberOfDimensions
 *
 *
 * @author fineh
 *
 */

public abstract class TwoDimensionalShape extends Shape {

	// This is a private field that represents the area a TwoDimensionalShape has
	private final double area;

	// This is the constructor for TwoDimensionalShape
	public TwoDimensionalShape(double area) {
		super(2);
		this.area = area;
	}

	// This is the getter for area
	public double getArea() {
		return area;
	}
}
