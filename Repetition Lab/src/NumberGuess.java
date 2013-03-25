import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author Arthur Laks
 * CSIT 210 - Repetition Lab
 * Overview: Picks a random number between 456 and 890 and asks the user to guess the number.
 * Input: Asks the user to guess the number.
 * Output: Tells the user whether he guessed the right number.
 * Variables: Scanner input; ThreadLocalRandom generator; int number; int guess;
 * Plan:
 * 1. Picks a random number between 456 and 891.
 * 2. Asks the user to guess that number.
 * 3. If the user guessed the wrong number, repeats the process.
 * 4. Repeats the process until the user guesses the right number or enters -1 to quit.
 * @version 1.0 2013.03.18
 */
public class NumberGuess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		ThreadLocalRandom generator=ThreadLocalRandom.current();	//As in Project 1, I am using ThreadLocalRandom because it
		//makes it easier to generate a random number from within an interval.
		int number=generator.nextInt(456,891);	//The lower bound is inclusive and the upper bound is exclusive
		System.out.println(number);
		int guess=0;
		do{
			System.out.print("Guess a number between 456 and 890 inclusive (enter -1 to quit): ");
			guess=input.nextInt();
			if(guess!=-1&&(guess<456||guess>890))	//If the number is invalid (if it is not -1 and it is not between 456 and 890).
				System.out.println("The number has to be between 456 and 890.");
		}while(guess!=number&&guess!=-1);	//The loop runs while the user picks the wrong number and does not pick -1.
		if(guess==number)	//If the user picked the right number
			System.out.print("Congratulations: you guessed correctly.");
		input.close();
	}

}
