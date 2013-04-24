import java.util.Scanner;
/**
 * Author: Arthur Laks.
 * CSIT 210 - Arrays Lab
 * Overview: Asks the user to enter temperatures and compares them with the average of the temperatures that
 he entered so far.
 * Input: Asks the user to enter temperatures.
 * Output: Informs the user if the temperatures that he just entered are greater than, less than, or equal to
 the average.
 * Variables: input, temperature (stores the temperature that the user just entered), sum (the sum of the 
 temperatures that he entered so far), counter, average.
 * Plan: 
 * 1. Asks the user to enter a temperature or to enter -1 to quit.
 * 2. If the temperature is -1 then breaks out of the loop and quits.
 * 3. Calculates the average of the temperatures that were entered so far.
 * 4. Displays a message, informing the user if the temperature that he just
 entered is equal to, greater than, or less than the average.
 * 5. Adds the temperature that he just entered to sum.
 * @version 1.0 2013-04-23. 
 */
public class AvgTemps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int temperature;
		int sum=0;	//Stores the sum of the temperatures that the user entered so far
		for(int counter=1;;counter++){	//Breaks out of the loop when the user enters -1 through a break
			//statement.
			System.out.print("Enter a temperature (enter -1 to quit): ");
			temperature=input.nextInt();
			if(temperature==-1)
				break;
			int average=sum/counter;
			if(average==temperature)
				System.out.println("The temperature that you just entered is equal to the average");
			else
				System.out.printf("The temperature that you just entered is %s than the average.\n",
						temperature>average?"greater":"less");	//Uses the ternary operator to display
			//greater if temperature is greater than average, and otherwise less.
			sum+=temperature;
		}
		input.close();
	}

}
