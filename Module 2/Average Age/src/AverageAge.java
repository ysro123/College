import java.util.Scanner;
/**
 * 
 * @author Arthur Laks
 * CSIT: Module 2 lab
 * Overview: Computes the average of three ages, supplied by the user.
 * Input: From Keyboard.
 * Output: Text Display.
 * Variables: val1,val2,val3, which store the three ages that the user supplies, and average, which stores the average.
 * Plan:
 * 1. User runs the program.
 * 2. The program asks the user for three ages.
 * 3. The program calculates the average of those ages.
 * 4. The program displays the average.
 * @version: 1.0 February 18, 2013.
 */
public class AverageAge{
	public static void main(String[] args){
		int val1, val2, val3;
		double average;
		Scanner scan = new Scanner(System.in) ;
// get three ages from the user
		System.out.println(" Enter three ages and I will compute their average.");
		System.out.print("Enter the first age:");
		val1=scan.nextInt();
		System.out.print("Enter the second age:");
		val2=scan.nextInt();
		System.out.print("Enter the third age: ");
		val3=scan.nextInt();
		//compute the average
		average=(val1+val2+val3)/3d;
//print the average (note decimals in the display)
		System.out.printf("The average is %f.", average);
		scan.close();
}
}