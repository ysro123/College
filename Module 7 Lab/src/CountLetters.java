
/**
 * Author: Arthur Laks
 * CSIT 210 - Exceptions Lab
 * Overview: Asks the user to enter a word, and counts the number of times each character appears in that 
 word.  
 * Input: Asks the user to enter a word.
 * Output: Displays "Have a good day" for every character that the user enters, prompts the user for every
 invalid character that he enters, and prints the number of occurrences of each character and the number
 of invalid characters.
 * Variables: counts, scan, word, invalidChars, i(the counter), currentChar, and e (the exception)
 * Plan:
 * 1. Asks the user to enter a single word.
 * 2. For each character in that word, increments the corresponding element in an array of 26 ints. It does
 so by subtracting the numeric value of 'A' from the value of the character in order to obtain the index in 
 array to increment.
 * 3. If the character was not one of the 26 characters in the alphabet, catches the resulting 
indexOutOfBoundsExcetpion and prompts the user that the character is invalid.  Increments a variable to keep
track of the number of invalid characters.
 * 4. Whether or not the character was valid, wishes the user a good day.
 * 5. Displays the number of occurrences of each character.
 * 6. Displays the number of invalid characters.
 * 
 */

import java.util.Scanner;

public class CountLetters {
	public static void main(String[] args) {
		int[] counts = new int[26];
		try(Scanner scan = new Scanner(System.in)){
		// get word from user
		System.out.print(" Enter a single word (letters only): ");
		String word = scan.nextLine();
		int invalidChars=0;
		// convert to all upper case
		word = word.toUpperCase();
		// count frequency of each letter in string
		for(char currentChar:word.toCharArray()){	//For each character in the string
			try {
				counts[currentChar - 'A']++;
			} catch (IndexOutOfBoundsException e) {
				System.out.printf("'%s' is not a valid character.  It will not be counted.\n", currentChar);
				invalidChars++;
				e.printStackTrace();
			}finally{
				System.out.println("Have a good day");	//Prints a positive message.
			}
		}
		// print frequencies
		System.out.println();
		for (int i = 0; i < counts.length; i++){
			if (counts[i] != 0)
				System.out.println((char) (i + 'A') + ": " + counts[i]);
			}
		System.out.printf("You entered %d invalid characters.", invalidChars);	//Print the number of invalid
		//characters.
		}
	}
}