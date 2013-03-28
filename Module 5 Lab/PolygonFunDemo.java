import java.util.*;
/**
 * @author Arthur Laks
 * CSIT 210 - Classes lab
 * Overview: Demonstrates the PolygonFun class.
 * Input: Asks the user for the attributes of two polygons.
 * Output: Displays the total area and perimeter of the three polygons.
 * Variables: Scanner input; Random generator; PolygonFun[] polygons; int sides; double totalArea, totalPerimeter;
 * Plan:
 * 1. Declares an array of three polygons.
 * 2. Initializes the first one to random values.
 * 3. Asks the user for the number of sides and side length of the second polygon and initializes it accordingly.
 * 4. Initializes the third one to the default values and then sets all of its properties to what the user 
 chooses.
 * 5. Adds up and displays the area and perimeter of the three polygons.
 * @version 1.0 2013/04/02
*/
public class PolygonFunDemo {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Random generator=new Random();
		PolygonFun polygons[]=new PolygonFun[3];
		//Initializes a polygon with random numbers for all of its attributes.
		polygons[0]=new PolygonFun(generator.nextInt(10),generator.nextDouble(),
				generator.nextDouble()*4,generator.nextDouble()*4);
		//Asks the user for the number of sides and side length of each 
		System.out.print("How many sides should the second polygon have? ");
		int sides=input.nextInt();
		System.out.print("How long should each side be? ");
		polygons[1]=new PolygonFun(sides,input.nextDouble());
		polygons[2]=new PolygonFun();
		System.out.print("How many sides should the third polygon have? ");
		polygons[2].setSides(input.nextInt());
		System.out.print("How long should each side be? ");
		polygons[2].setSideLength(input.nextDouble());
		System.out.print("How far should it be from the x-axis? ");
		polygons[2].setxCoordinate(input.nextDouble());
		System.out.print("How far should it be from the y-axis? ");
		polygons[2].setyCoordinate(input.nextDouble());
		
		double totalArea=0,totalPerimeter=0;
		for(PolygonFun thisPolygon:polygons){
			totalArea+=thisPolygon.getArea();
			totalPerimeter=thisPolygon.getPerimeter();
		}
		System.out.printf("The total area of the three polygons is %f and the total perimeter is %f."
				,totalArea,totalPerimeter);
		input.close();
	}
}
