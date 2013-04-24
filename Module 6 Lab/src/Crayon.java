
/**
 * Author: Arthur Laks
 * CSIT 210 - Arrays Lab Part 2
 * Overview: This class represents a crayon and stores its color, length, and sharpness.
 * Input: none
 * Output: none
 * Variables: color, length, sharpness.
 * Plan: none.
 * @version 1.0 2013-04-23
 */
public class Crayon {
	/**
	 * Represents a color.
	 */
	
	private Color color;
	private int length;
	private int sharpness;
	/**
	 * Returns the color of the crayon.
	 * @return the color of the crayon.
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Returns the length of the crayon in millimeters.
	 * @return the length of the crayon in millimeters.
	 */
	public int getLength() {
		return length;
	}
	/**
	 * Returns the sharpness of the crayon as a number between one and five.
	 * @return the sharpness of the crayon.
	 */
	public int getSharpness() {
		return sharpness;
	}
	/**
	 * Creates a new crayon with the specified color, length, and sharpness.
	 * @param color the color of the crayon
	 * @param length the length of the crayon in millimeters
	 * @param sharpness a number between 1 and 5 representing the sharpness of the crayon.
	 */
	public Crayon(Color color, int length, int sharpness) {
		this.color = color;
		this.length = length;
		this.sharpness = sharpness;
	}
	/**
	 * Returns a string containing the color, sharpness, and length of the crayon.
	 */
	@Override
	public String toString(){
		return String.format("Color: %s Sharpness: %d Length: %d millimeters.",color,sharpness,length);
	}
}
