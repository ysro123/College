import java.util.Scanner;
/**

 * @author Arthur Laks
 *CSIT 210 - Rectangle Lab
 *Overview: Uses the methods of the rectangle class.
 *Input: Asks the user for the length and width of the two rectangles.
 *Output: Displays their area, perimeter, and combined width and length
 *Variables: input,rectangle1,rectangle2,width,length
 *Plan:
 *1. Initializes the first rectangle to a size of 0,0;
 *2. Sets the length and the width to values specified by the user.
 *3. Displays the area and perimeter of the first rectangle.
 *4. Repeats the same steps with the second rectangle, except that it asks the user for the length and width first, stores them
 in variables, and then initializes the rectangle to those values.
 *5. Displays the combined lengths and widths of the two rectangles.
 *@version 1.0 February 26, 2013
 */
public class RectangleDemo {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Rectangle rectangle1=new Rectangle();

		System.out.print("How long do you want the first rectangle to be? ");
		rectangle1.setLength(input.nextDouble());
		System.out.print("How wide do you want the first rectangle to be? ");
		rectangle1.setWidth(input.nextDouble());
		System.out.printf("The area of the first rectangle is %f and the perimeter is %f.\n",
rectangle1.getArea(),rectangle1.getPerimeter());
		
		double length,width;
		System.out.print("How long do you want the second rectangle to be? ");
		length=input.nextDouble();
		System.out.print("How wide do you want the second rectangle to be? ");
		width=input.nextDouble();
		Rectangle rectangle2=new Rectangle(length,width);
		System.out.printf("The area of the second rectangle is %f and the perimeter is %f.\n",
rectangle2.getArea(),rectangle2.getPerimeter());
		System.out.printf("The combined length of the two rectangles is %f and the combined width is %f.",
rectangle1.getLength()+rectangle2.getLength(),rectangle1.getWidth()+rectangle2.getWidth());
		input.close();
	}

}
