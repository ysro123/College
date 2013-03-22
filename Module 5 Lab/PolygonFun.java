import static java.lang.Math.*;
/**

 * @author Arthur Laks
 * CSIT 210 - Classes lab
 * Overview: Stores the information about a polygon and calculates its area and perimeter.
 * Input: none
 * Output: none
 * Plan: none
 * Variables: private int sides; private double sideLength,xCoordinate,yCoordinate.
 * @version 1.0 2013/04/02
 */
public class PolygonFun {
	private int sides=3;
	private double sideLength=1;
	private double xCoordinate=0;
	private double yCoordinate=0;
/**
 * Constructs a new polygon with the default values (3 sides, a side length of 1, and at the origin).
 */
	public PolygonFun(){
	}
	/**
	 * Constructs a new polygon with the specified number of sides of the specified length at the origin.
	 * @param sides the number of sides
	 * @param sideLength the length of each side
	 */
	public PolygonFun(int sides,double sideLength){
		this.sides=sides;
		this.sideLength=sideLength;
	}
	/**
	 * Constructs a new polygon with the specified number of sides of the specified length at the specified location
	 * @param sides the number of sides
	 * @param sideLength the length of each side
	 * @param xCoordinate the x-coordinate
	 * @param yCoordinate the y-coordinate
	 */
	public PolygonFun(int sides,double sideLength,double xCoordinate,double yCoordinate){
		this(sides,sideLength);
		this.xCoordinate=xCoordinate;
		this.yCoordinate=yCoordinate;
	}
	/**
	 * Returns the number of sides
	 * @return
	 */
	public int getSides() {
		return sides;
	}
	/**
	 * Sets the number of sides to the specified value
	 * @param sides
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}
	/**
	 * Returns the side length
	 * @return
	 */
	public double getSideLength() {
		return sideLength;
	}
	/**
	 * Sets the side length to the specified value
	 * @param sideLength
	 */
	public void setSideLength(double sideLength) {
		this.sideLength = sideLength;
	}
	/**
	 * Returns the x-coordinate
	 * @return 
	 */
	public double getxCoordinate() {
		return xCoordinate;
	}
	/**
	 * Sets the x-coordinate to the value that is passed to it
	 * @param xCoordinate
	 */
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	/**
	 * Returns the y-coordinate
	 * @return
	 */
	public double getyCoordinate() {
		return yCoordinate;
	}
	/**
	 * Sets the y-coordinate to the specified value.
	 * @param yCoordinate
	 */
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	/**
	 * Calculates the perimeter of the shape
	 * @return the perimeter of the shape
	 */
	public double getPerimeter(){
		return sides*sideLength;
	}
	/**
	 * Calculates the area of the shape
	 * @return the area of the shape
	 */
	public double getArea(){
		return (pow(sideLength,2)*sides)/(4*tan(PI/sides));
	}
}
