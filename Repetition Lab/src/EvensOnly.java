import java.util.Scanner;
/**
 * @author Arthur Laks
 * CSIT 210 - Repetition Lab
 * Overview: Adds the even numbers that the user types.
 * Input: Asks the user for even numbers.
 * Output: Outputs the sum of the numbers that the user typed.
 * Variables: Scanner input; int sum, number;
 * Plan:
 * 1. Declares variables to store the number that the user entered and the sum of the even numbers that the user entered.
 * 2. Asks the user to enter numbers and adds those numbers to sum until he enters an odd number.
 * 3. Displays the sum of the even numbers that the user entered.
 * @version 1.0 2013.03.19
 */
public class EvensOnly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int sum=0,number=0;		//Stores the sum of the numbers that the user entered and the number that he just entered.
		do{
			sum+=number;	//The first time that the loop runs, this statement just adds 0 to 0.  Afterwards, it adds to 
			//sum the number that the user entered in the previous iteration of the loop which has to be even because otherwise, 
			//the loop would have stopped.
			System.out.print("Enter an even number to add (enter an odd number to quit): ");
			number=input.nextInt();
		}while(number%2==0);
		System.out.print("The sum of the even numbers that you entered is "+sum +".");
		input.close();
	}

}
