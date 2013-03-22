import static java.lang.Math.*;
/**
 * 
 * @author Arthur Laks
 * CSIT 210 - Triangle Lab
 * Overview: A class that represents a right triangle and calculates its area, hypotenuse, and perimeter.
 * Input: none.
 * Output: none.
 * Variables: private double height, private double width
 * Plan: 
 * 1. User constructs a Triangle.
 * 2. User sets the height and base of the triangle either through the setBase and getBase methods, or through the constructor.
 * 3. User calls the getHypotenuse, getArea and getPerimeter in order to obtain those values.
 * @version 1.0 2013.03.05 
 */
public class RTTriangle {
	/**
	 * Stores the height and base of the triangle.
	 */
	private double height,base;
	/**
	 * Initializes a triangle to the specified base and height.
	 * @param base a double containing the length of the base
	 * @param height a double containing the height.
	 */
	public RTTriangle(double base,double height){
		this.base=base;
		this.height=height;
	}
	/**
	 * Constructs a triangle with a base and height of zero.
	 */
	public RTTriangle(){
		//As fields, the base and height are automatically initialized to zero.
	}
	/**
	 * Returns the height of the triangle.
	 * @return a double containing the height of the triangle.
	 */
	public double getHeight(){
		return height;
	}
	/**
	 * Sets the height of the triangle to the specified value.
	 * @param height the value that the height of the triangle should be set to.
	 */
	public void setHeight(double height){
		this.height=height;
	}
	/**
	 * Returns the base of the triangle.
	 * @return a double containing the base of the triangle
	 */
	public double getBase(){
		return base;
	}
	/**
	 * Sets the base of the triangle to the specified value.
	 * @param base the value that the base of the triangle should be set to.
	 */
	public void setBase(double base){
		this.base=base;
	}
	/**
	 * Calculates the length of the hypotenuse of the triangle.
	 * @return a double containing the hypotenuse of the triangle.
	 */
	public double getHypotenuse(){
		return sqrt(pow(base,2)+pow(height,2));		//Uses the pythagorean theorem.  (Since there is a static import for Math,
		//I do not need to type Math.sqrt.)
	}
	/**
	 * Calculates the perimeter of the triangle.
	 * @return a double containing the perimeter of the triangle.
	 */
	public double getPerimeter(){
		return base+height+getHypotenuse();
	}
	/**
	 * Calculates the area of the triangle.
	 * @return a double containing the area of the triangle.
	 */
	public double getArea(){
		return base*height/2;
	}
}
