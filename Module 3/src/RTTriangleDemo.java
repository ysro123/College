import java.util.Scanner;
/**
 * @author Arthur Laks
 * CSIT 210 - Triangle lab.
 * Overview: Demonstrates the RTTriangle class.
 * Input: Asks the user for the base and height of two right triangles.
 * Output: Displays the hypotenuse, perimeter, and area of the two triangles.
 * Variables: Scanner input; double[2] base, height; int counter (twice).
 * Plan:
 * 1. Declares two arrays of doubles in order to store the values that the user specifies for the base and height of the two
triangles.
 * 2. Asks the user for the base and height of each triangle and stores them in the arrays of doubles.
 * 3. Declares and array of triangles.
 * 4. For the first triangle, passes the first values in height[] and base[] to the constructor,
 * 5. For the second triangle, passes nothing to the constuctor and uses the setBase and setHeight methods to set the base and the
height to the values that the user typed.
 * 6. For each triangle, displays the hypotenuse, perimeter, and area.
 * @version 1.0 2013.03.05
 */
public class RTTriangleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double[] base=new double[2];	//Stores the values that the user types for the base of both triangles.
		double[] height=new double[2];	//Stores the values that the user types for the height of both triangles.
		//For each triangle, ask the user for the base and height of those triangles and assign the respective values of base[] and
		//height[] to what the user types.
		for(int counter=0;counter<2;counter++){
			System.out.printf("What should the base of triangle %d be? ",counter+1);	//One is added to counter so that it would
			//not be zero-based. 
			base[counter]=input.nextDouble();
			System.out.printf("What should the height of triangle %d be? ",counter+1);
			height[counter]=input.nextDouble();
		}
		//Construct both triangles, one with each constructor, based on the values that the user inputed.
		RTTriangle[] triangles=new RTTriangle[2];
		triangles[0]=new RTTriangle(base[0], height[0]);
		
		triangles[1]=new RTTriangle();
		triangles[1].setBase(base[1]);
		triangles[1].setHeight(height[1]);
		//For each triangle, display its hypotenuse, perimeter, and area.
		for(int counter=0;counter<2;counter++){
			System.out.printf("The hypotenuse of triangle %d is %f, the perimeter is %f, and the area is %f.\n",
					counter+1,triangles[counter].getHypotenuse(),triangles[counter].getPerimeter(),triangles[counter].getArea());
		}
		input.close();
	}

}
