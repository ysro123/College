
/**
 * 
 * @author Arthur Laks
 * CSIT 210 - Rectangle Lab.
 * Overview: Stores the length and width of a rectangle and calculates it's area and parimeter.
 * Input: none
 * Output: none
 * Variables: doubles length and width
 * Plan: none.
 * @version: 1.0 February 26 2013.
 */
public class Rectangle {
	private double length,width;
	/**
	 * Initializes a rectangle with both the length and the width set to zero.
	 */
	public Rectangle(){
		length=width=0;		//Sets both the length and the width to zero.
	}
	/**
	 * Initializes a rectangle with the specified dimensions.
	 * @param len the length of the rectangle.
	 * @param width the width of the rectangle
	 */
	public Rectangle(double len,double width){
		length=len;
		this.width=width;
	}
	/**
	 * Sets the length of the rectangle to the specified number.
	 * @param length the length that the rectangle should have.
	 */
	public void setLength(double length){
		this.length=length;
	}
	/**
	 * Returns the length of the rectangle.
	 * @return the length of the rectangle
	 */
	public double getLength(){
		return length;
	}
	/**
	 * Sets the width the rectangle to the specified value.
	 * @param width the new width of the rectangle
	 */
	public void setWidth(double width){
		this.width=width;
	}
	/**
	 * Returns the current width of the rectangle.
	 * @return the current width of the rectangle
	 */
	public double getWidth(){
		return width;
	}
	/**
	 * Calculates the perimeter of the rectangle.
	 * @return the perimeter of the rectangle
	 */
	public double getPerimeter(){ 
		return 2*(length+width);
	}
	/**
	 * Calculates the area of the rectangle.
	 * @return the area of the rectangle
	 */
	public double getArea(){
		return length*width;
	}
}
