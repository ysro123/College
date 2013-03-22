import java.util.Scanner;
/**
 * @author Arthur Laks
 * CSIT 210-Dice
 *Overview: Simulates the throwing of two dice.
 *Input: Asks the user for the number of sides of each dice.
 *Output: Displays random numbers for each roll of the dice and the total and average of the numbers that each dice landed on.
 *Plan:
 * 1. Creates an array of two die.
 * 2. Asks the user how many sides each die should have.
 * 3. Throws each die three times and displays the number it landed on.
 * 4. Displays the total and the averagenof the numbers that each die landed on.
 * Variables: Scanner input; Die[] dice, int count,roll
 * @version: 1.0 February 26, 2013
 */
public class Dice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Die[] dice = new Die[2];	//An array of the two die.
		//Initializes each die in dice[] to the number of sides that the user specifies.
		for(int count=0;count<=1;count++){
			System.out.printf("How many sides does die %d have?",count+1);
			dice[count]=new Die(input.nextInt());
			}
		//Throws each die three times and prints the number that the die landed on.
		for(int roll=1;roll<=3;roll++){		//For each throw
			for(int die=0;die<=1;die++)		//For each die.
				System.out.printf("Die %d roll %d = %d.\n",die+1,roll,dice[die].roll());	//Throw the die and display the
			//number that the die landed on.
			}
		//Displays the total and average of the numbers that each die landed on.
		for(int die=0;die<=1;die++)
			System.out.printf("Die %d rolled a total of %d and rolled %.3f on average.\n", die,dice[die].total(),dice[die].average());
		input.close();
		}

}
