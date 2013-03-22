import java.util.Scanner;
import java.util.Random;
/**
 * @author Arthur Laks
 * CSIT 210 - Selection Lab
 * Overview: Emulates a variation of EasyMoney with a three-digit number.
 * Input: Asks the user to select a number.
 * Output: Outputs the amount of money the user should win based on the number of digits he matched.
 * Variables: Scanner input; Random generator; String winningNumber; String guess; int matches;
 * Plan:
 * 1. Picks a random number between 0 and 999 and stores it as a String (that way, it is easier to access its digits).
 * 2. Asks the user to enter his guess and stores it as a string.
 * 3. Outputs the winning number.
 * 4. If the user guessed the right number, tells him that he won $900 and terminates the program.
 * 5. Calculates the number of digits that the user matched with the winning number.
 * 6. If he matched all of them, but in the wrong order, tells him that he won $180 and terminates the program.
 * 7. If he matched at least one digit, tell him that he won $8 and terminates the program.
 * 8. If he did not match any digits, apologizes that there was no match.
 * @version 1.0 2013.03.19
 */
public class EasyMoney {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final Random generator=new Random();
		// Generate a lottery
		String winningNumber=Integer.toString(generator.nextInt(1000));		//Stores the winning number and the user's guess as strings in order to make it easier to access
		//the digits individually.
		// Prompt the user to enter a guess
		System.out.print("Enter your EasyMoney pick (3 digits): ");
		String guess=input.nextLine();
		input.close();
		System.out.println("The EasyMoney number is " + winningNumber);
		if(guess.equals(winningNumber)){	//If the user matched the winning number exactly.
				System.out.print("Exact Match: You win $900");
				return;		//Exit the program so that the user would not win additional money for the digits that he matched.
			}
		int matches=0;
		//Calculates the number of matches between the number that the user picked and the winning number
		for(int winCounter=0;winCounter<3;winCounter++){	//For each digit in the winning number, go through the number that the user picked and add up the number of matches.
			for(int guessCounter=0;guessCounter<3;guessCounter++){
				if(winningNumber.charAt(winCounter)==guess.charAt(guessCounter))	//If the digits match, increment matches.
					matches++;
			}
		}
		//If the user matched all three digits, but in the wrong order.
		if(matches==3){
			System.out.println("Match all digits: you win $180.");
			return;
		}
		
		if(matches>=1){
			System.out.println("Match 1 digit: you win $8.");
			return;
		}
		System.out.println("Sorry, no match");
	}
}
