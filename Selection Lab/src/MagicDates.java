import java.util.Scanner;
/**
 * @author Arthur Laks
 * CSIT 210 - Selection Lab
 * Overview: Determines if a date is a magic date (the product of the day and the month equals the last two digits of the year.
 * Input: Asks the user for a date.
 * Output: Tells the user whether or not it is a magic date.
 * Variables: Scanner input; int day, month, year;
 * Plan:
 * 1. Asks the user for the last two digits of the year, the month, and the day.
 * 2. If the day times the month equals the year, displays a message saying that the date is a magic date.
 * 3. If the day times the month does not equal the year, displays a message saying that the date is not a magic date.
 * @version: 1.0 2013/3/19
 */
public class MagicDates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int day,month,year;
		//Asks the user for the date.
		System.out.print("Enter the last two digits of the year: ");
		year=input.nextInt();
		System.out.print("Enter the month as a number (1 for January, 2 for February, etc): ");
		month=input.nextInt();
		System.out.print("Enter the day of the month: ");
		day=input.nextInt();
		
		//Determines if the date is a magic date.
		if(day*month==year)
			System.out.print("That date is a magic date.");
		else
			System.out.print("That date is not a magic date.");
		input.close();
		
	}

}
