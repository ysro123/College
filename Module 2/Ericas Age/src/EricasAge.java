import java.util.Scanner;

//Arthur Laks
/**
 * Overview: Calculates Erica's age based on Sam's age.
 * Input: Text input
 * Output: Text Display
 * Variables: samAge, ericaAge
 * Plan:
 * 1. User starts the program.
 * 2. Asks the user for Sam's age.
 * 3. Calculates Erica's age based on Sam's age.
 * 4. Displays Erica's age.
 * @author Arthur Laks
 * @version 1.0 February 15, 2013
 */
public class EricasAge {

	/**
	 * @param args
	 */
	public static void main(String args[])
	{
	int samAge = 0;
	int ericaAge = 0;
	Scanner scan = new Scanner(System.in );
	System.out.print(" What is Samantha's current age? ");
	samAge = scan.nextInt() ;
	ericaAge = 3*samAge-7;
	System.out.println("If Samantha is " + samAge + " then Erica must be " + ericaAge +
	".");
	scan.close();
	}

}
