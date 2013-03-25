import java.util.*;
/**
 * @author Arthur Laks
 * CSIT 210 - Repetition Lab
 * Overview: Counts down the specified number of seconds.
 * Input: Asks the user for the number of seconds that it should count down.
 * Output: Every second, displays the number of seconds left.
 * Variables: Scanner input; int length; int secondsPassed, secondsLeft; GregorianCalendar endOfSecond
 * Plan:
 * 1. Asks the user for the length of the countdown.
 * 2. For each second that the countdown should last, displays the number of seconds left and waits a second.
 * 3. Displays BAZINGA!.
 * @version 1.0 2013.03.19
 */
public class FinalCountDown {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("How many seconds should the countdown last for? ");
		int length=input.nextInt();		//The length of the countdown
		for(int secondsPassed=0;secondsPassed<length;secondsPassed++){	//For each second that the countdown should last.
			int secondsLeft=length-secondsPassed;	//I store it as a variable because I have to refer to it twice.
			//Displays the number of seconds left.  Uses the ternary operator to display second if there is one second left
			//and seconds if there are more than one second left.
			System.out.println(secondsLeft+(secondsLeft==1?" second left.":" seconds left."));
			//Waits a second by declaring a calendar that is set to a second after the current time and waits until the current time
			//is after that calendar.
			GregorianCalendar endOfSecond=(GregorianCalendar) GregorianCalendar.getInstance();	//getInstance returns the current
			//date.
			endOfSecond.add(GregorianCalendar.SECOND, 1);	//Adds one second to the current date.
			while(endOfSecond.after(GregorianCalendar.getInstance())){	//Runs the empty loop until the current time is after
				//endOfSecond
			}
		}
		System.out.print("bazinga!".toUpperCase());		//Displays bazinga in all-caps
		input.close();
	}

}
