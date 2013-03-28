package stapler;
import java.util.Scanner;

import stapler.Stapler.Color;
/**
 * @author Arthur Laks
 * CSIT 210 - Have you seen my Stapler()
 * Overview: Demonstrates the Stapler class.
 * Input: Asks the user for the color and locations of three staplers.
 * Output: none
 * Variables: Stapler[] staplers; Scanner input; int counter; Color color; double longitude, latitude;
 * Plan:
 * 1. Declares an array of three staplers.
 * 2. For each stapler, asks the user where what color the staples should be and where it should be located.
 * 3. Constructs a stapler in that place with staples of that color.
 * @version 1.0 2013/03/36
 */
public class StaplerDemo {
	public static void main(String[] args) {
		Stapler[] staplers=new Stapler[3];
		Scanner input=new Scanner(System.in);
		for(int counter=0;counter<staplers.length;counter++){
			System.out.printf("What should the color of the staples of stapler #%d be? ", counter+1);
			Color color=Color.valueOf(input.next().toUpperCase());
			System.out.printf("What should be the latitude of stapler #%d? ",counter+1);
			double latitude=input.nextDouble();
			System.out.printf("What should be the longitude of stapler #%d? ",counter+1);
			double longitude=input.nextDouble();
			staplers[counter]=new Stapler(color,latitude,longitude);
		}
		input.close();
	}
}
